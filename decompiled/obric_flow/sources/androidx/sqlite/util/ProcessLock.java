package androidx.sqlite.util;

import ai.j0;
import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/sqlite/util/ProcessLock;", "", "name", "", "lockDir", "Ljava/io/File;", "processLock", "", "(Ljava/lang/String;Ljava/io/File;Z)V", "lockChannel", "Ljava/nio/channels/FileChannel;", "lockFile", "threadLock", "Ljava/util/concurrent/locks/Lock;", "lock", "", "unlock", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/sqlite/util/ProcessLock$Companion;", "", "()V", "TAG", "", "threadLocksMap", "", "Ljava/util/concurrent/locks/Lock;", "getThreadLock", STGroup.DICT_KEY, "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ Lock access$getThreadLock(Companion r5, String r10) {
            return r5.getThreadLock(r10);
        }

        private final Lock getThreadLock(String r5) {
            Map r10 = ProcessLock.access$getThreadLocksMap$cp();
            monitor-enter(r10);
            Map r11 = ProcessLock.access$getThreadLocksMap$cp();     // Catch: Throwable -> L7
            Object r12 = r11.get(r5);     // Catch: Throwable -> L7
            if (r12 != null) goto L9;
            r12 = new ReentrantLock();     // Catch: Throwable -> L7
            r11.put(r5, r12);     // Catch: Throwable -> L7
        L9:
            Lock r13 = (Lock) r12;     // Catch: Throwable -> L7
            monitor-exit(r10);
            return r13;
        L7:
            th = move-exception;
            throw th;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        threadLocksMap = new HashMap();
    }

    public ProcessLock(String r5, File r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.processLock = r11;
        if (r10 == null) goto L5;
        File r12 = new File(r10, j0.j(r5, ".lck"));
    L6:
        this.lockFile = r12;
        this.threadLock = Companion.access$getThreadLock(Companion, r5);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static final /* synthetic */ Map access$getThreadLocksMap$cp() {
        return threadLocksMap;
    }

    public static /* synthetic */ void lock$default(ProcessLock r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = r5.processLock;
    L5:
        r5.lock(r10);
    }

    public final void lock(boolean r5) {
        this.threadLock.lock();
        if (r5 == false) goto L17;
        File r10 = this.lockFile;     // Catch: IOException -> L9
        if (r10 == null) goto L13;
        File r11 = r10.getParentFile();     // Catch: IOException -> L9
        if (r11 == null) goto L11;
        r11.mkdirs();     // Catch: IOException -> L9
    L11:
        FileChannel r12 = new FileOutputStream(this.lockFile).getChannel();     // Catch: IOException -> L9
        r12.lock();     // Catch: IOException -> L9
        this.lockChannel = r12;     // Catch: IOException -> L9
        return;
    L13:
        throw new IOException("No lock directory was provided.");     // Catch: IOException -> L9
    L9:
        e = move-exception;
        this.lockChannel = null;
        Log.w(TAG, "Unable to grab file lock.", e);
        return;
    }

    public final void unlock() {
        FileChannel r5 = this.lockChannel;     // Catch: IOException -> L7
        if (r5 == null) goto L5;
        r5.close();     // Catch: IOException -> L7
    L5:
        this.threadLock.unlock();
    }
}
