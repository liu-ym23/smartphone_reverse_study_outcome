package mqa;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public boolean a;
    public boolean b;
    public FileLock c;
    public RandomAccessFile d;

    public f() {
    }

    public final boolean a(PolarisFileWrapper r7) {
        boolean r2 = false;
        if (r7.exists() == true) goto L5;
        return false;
    L5:
        boolean r1 = true;
        FileLock r3 = null;
        RandomAccessFile r4 = new RandomAccessFile(r7, "rwd");     // Catch: Throwable -> L17
        this.d = r4;     // Catch: Throwable -> L17
        r3 = r4.getChannel().tryLock();     // Catch: Throwable -> L17
        if (r3 == null) goto L9;
        this.c = r3;     // Catch: Throwable -> L17
    L9:
        FileLock r8 = this.c;     // Catch: Throwable -> L17
        if (r8 == null) goto L14;
        if (r8.isValid() == false) goto L14;
        r2 = true;
    L14:
        if (r3 != null) goto L16;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.d), "ExclusiveFileLock"));
    L16:
        return r2;
    L17:
        th = move-exception;
    L29:
        th = move-exception;
        if (r3 != null) goto L32;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.d), "ExclusiveFileLock"));
    L32:
        throw th;
    L19:
        if ((th instanceof IOException) == true) goto L21;
    L23:
        r1 = false;
    L24:
        if (r1 == true) goto L26;
        th.printStackTrace();     // Catch: Throwable -> L29
    L26:
        if (r3 != null) goto L28;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(this, this.d), "ExclusiveFileLock"));
    L28:
        return false;
    L21:
        if (th.getMessage().contains("fcntl failed: EAGAIN") == false) goto L23;
        goto L23
    }
}
