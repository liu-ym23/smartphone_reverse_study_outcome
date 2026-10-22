package androidx.sqlite.util;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ProcessLock {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLiteLock";
    private static final Map<String, Lock> threadLocksMap = null;
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;

    @SuppressLint({"SyntheticAccessor"})
    private final Lock threadLock;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Lock access$getThreadLock(Companion r10, String r11) {
            return r10.getThreadLock(r11);
        }

        private final Lock getThreadLock(String r10) {
            Map r11 = ProcessLock.access$getThreadLocksMap$cp();
            monitor-enter(r11);
            Map r12 = ProcessLock.access$getThreadLocksMap$cp();     // Catch: Throwable -> L10
            Object r13 = r12.get(r10);     // Catch: Throwable -> L10
            if (r13 != null) goto L7;
            r13 = new ReentrantLock();     // Catch: Throwable -> L10
            r12.put(r10, r13);     // Catch: Throwable -> L10
        L7:
            Lock r14 = (Lock) r13;     // Catch: Throwable -> L10
            monitor-exit(r11);
            return r14;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
        threadLocksMap = new HashMap();
    }

    public ProcessLock(String r10, File r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "lockDir");
        this.processLock = r12;
        File r13 = new File(r11, r10 + ".lck");
        this.lockFile = r13;
        Companion r14 = Companion;
        String r15 = r13.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r15, "lockFile.absolutePath");
        this.threadLock = Companion.access$getThreadLock(r14, r15);
    }

    public static final /* synthetic */ Map access$getThreadLocksMap$cp() {
        return threadLocksMap;
    }

    public static /* synthetic */ void lock$default(ProcessLock r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = r10.processLock;
    L5:
        r10.lock(r11);
    }

    public final void lock(boolean r10) {
        this.threadLock.lock();
        if (r10 == false) goto L14;
        File r11 = this.lockFile.getParentFile();     // Catch: IOException -> L9
        if (r11 == null) goto L7;
        r11.mkdirs();     // Catch: IOException -> L9
    L7:
        FileChannel r12 = new FileOutputStream(this.lockFile).getChannel();     // Catch: IOException -> L9
        r12.lock();     // Catch: IOException -> L9
        this.lockChannel = r12;     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        this.lockChannel = null;
        Log.w(TAG, "Unable to grab file lock.", e);
        return;
    }

    public final void unlock() {
        FileChannel r10 = this.lockChannel;     // Catch: IOException -> L7
        if (r10 == null) goto L5;
        r10.close();     // Catch: IOException -> L7
    L5:
        this.threadLock.unlock();
    }
}
