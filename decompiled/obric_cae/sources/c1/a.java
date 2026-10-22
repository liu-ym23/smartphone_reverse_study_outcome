package c1;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f3241e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f3243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f3244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f3245d;

    static {
        f3241e = new HashMap();
    }

    public a(String r8, File r10, boolean r11) {
        this.f3242a = r11;
        if (r10 == null) goto L5;
        File r12 = new File(r10, r8.concat(".lck"));
    L6:
        this.f3243b = r12;
        HashMap r13 = f3241e;
        monitor-enter(r13);
        Object r14 = r13.get(r8);     // Catch: Throwable -> L15
        if (r14 != null) goto L11;
        r14 = new ReentrantLock();     // Catch: Throwable -> L15
        r13.put(r8, r14);     // Catch: Throwable -> L15
    L11:
        Lock r15 = (Lock) r14;     // Catch: Throwable -> L15
        monitor-exit(r13);
        this.f3244c = r15;
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        r12 = null;
        goto L6
    }

    public final void a(boolean r8) {
        this.f3244c.lock();
        if (r8 == false) goto L16;
        File r10 = this.f3243b;
        if (r10 == null) goto L11;
        File r11 = r10.getParentFile();     // Catch: IOException -> L12
        if (r11 == null) goto L9;
        r11.mkdirs();     // Catch: IOException -> L12
    L9:
        FileChannel r12 = new FileOutputStream(r10).getChannel();     // Catch: IOException -> L12
        r12.lock();     // Catch: IOException -> L12
        this.f3245d = r12;     // Catch: IOException -> L12
        return;
    L11:
        throw new IOException("No lock directory was provided.");     // Catch: IOException -> L12
    L12:
        e = move-exception;
        this.f3245d = null;
        Log.w("SupportSQLiteLock", "Unable to grab file lock.", e);
        return;
    }

    public final void b() {
        FileChannel r8 = this.f3245d;     // Catch: IOException -> L7
        if (r8 == null) goto L5;
        r8.close();     // Catch: IOException -> L7
    L5:
        this.f3244c.unlock();
    }
}
