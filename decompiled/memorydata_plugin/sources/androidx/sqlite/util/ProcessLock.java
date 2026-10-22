package androidx.sqlite.util;

import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/sqlite/util/ProcessLock;", "", ActivityLifecycle.NAME, "", "lockDir", "Ljava/io/File;", "processLock", "", "(Ljava/lang/String;Ljava/io/File;Z)V", "lockChannel", "Ljava/nio/channels/FileChannel;", "lockFile", "threadLock", "Ljava/util/concurrent/locks/Lock;", "lock", "", "unlock", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProcessLock {
    public static final Companion Companion = null;
    private static final String TAG = "SupportSQLiteLock";
    private static final Map<String, Lock> threadLocksMap = null;
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    private final Lock threadLock;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/util/ProcessLock$Companion;", "", "()V", "TAG", "", "threadLocksMap", "", "Ljava/util/concurrent/locks/Lock;", "getThreadLock", "key", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ Lock access$getThreadLock(Companion r0, String r1) {
            return r0.getThreadLock(r1);
        }

        private final Lock getThreadLock(String r5) {
            Map r4 = ProcessLock.access$getThreadLocksMap$cp();
            monitor-enter(r4);
            Map r0 = ProcessLock.access$getThreadLocksMap$cp();     // Catch: Throwable -> L10
            Object r1 = r0.get(r5);     // Catch: Throwable -> L10
            if (r1 != null) goto L7;
            r1 = (Lock) ZeusTransformUtils.preCheckCast(new ReentrantLock(), Lock.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            r0.put(r5, r1);     // Catch: Throwable -> L10
        L7:
            Lock r6 = (Lock) ZeusTransformUtils.preCheckCast(r1, Lock.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            monitor-exit(r4);
            return r6;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
        threadLocksMap = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public ProcessLock(String r3, File r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.processLock = r5;
        if (r4 == null) goto L5;
        File r6 = new File(r4, r3 + ".lck");
    L6:
        this.lockFile = r6;
        this.threadLock = Companion.access$getThreadLock(Companion, r3);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ Map access$getThreadLocksMap$cp() {
        return threadLocksMap;
    }

    public static /* synthetic */ void lock$default(ProcessLock r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0.processLock;
    L5:
        r0.lock(r1);
    }

    public final void lock(boolean r2) {
        this.threadLock.lock();
        if (r2 == false) goto L16;
        File r3 = this.lockFile;     // Catch: IOException -> L12
        if (r3 == null) goto L11;
        File r4 = r3.getParentFile();     // Catch: IOException -> L12
        if (r4 == null) goto L9;
        r4.mkdirs();     // Catch: IOException -> L12
    L9:
        FileChannel r5 = new FileOutputStream(this.lockFile).getChannel();     // Catch: IOException -> L12
        r5.lock();     // Catch: IOException -> L12
        this.lockChannel = r5;     // Catch: IOException -> L12
        return;
    L11:
        throw new IOException("No lock directory was provided.");     // Catch: IOException -> L12
    L12:
        e = move-exception;
        this.lockChannel = null;
        Log.w(TAG, "Unable to grab file lock.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void unlock() {
        FileChannel r0 = this.lockChannel;     // Catch: IOException -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: IOException -> L7
    L5:
        this.threadLock.unlock();
    }
}
