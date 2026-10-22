package q3;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f12453a;

    /* JADX INFO: renamed from: q3.a$a, reason: collision with other inner class name */
    class RunnableC0282a implements Runnable {
        RunnableC0282a(a r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = com.bytedance.memory.heap.a.j().k();     // Catch: Throwable -> L8
            if (r10 != 0) goto L5;
            return;
        L5:
            if ((System.currentTimeMillis() - r10) <= 604800000) goto L14;
            u3.a.b().f("deleteExpiredWidgetFolder");     // Catch: Throwable -> L8
            com.bytedance.memory.heap.a.j().d();     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();
        }
    }

    private a() {
    }

    private boolean a(File r10) {
        p3.c.c("lastModified %d now %d", new Object[]{Long.valueOf(r10.lastModified()), Long.valueOf(System.currentTimeMillis())});
        if ((System.currentTimeMillis() - r10.lastModified()) > 604800000) goto L5;
        return false;
    L5:
        return true;
    }

    public static a d() {
        if (f12453a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12453a != null) goto L9;
        f12453a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f12453a;
    }

    @WorkerThread
    public void b() {
        p3.b.f12318a.a(new RunnableC0282a(this), "DumpFileController-checkWidgetFolder");
    }

    @WorkerThread
    public void c(@NonNull File r10) {
        if (r10.isFile() == false) goto L10;
        if (a(r10) == false) goto L7;
    L8:
        r10.delete();
        return;
    L7:
        if (r10.length() == 0) goto L8;
        return;
    L10:
        if (r10.isDirectory() == false) goto L21;
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.length <= 0) goto L23;
        int r12 = r11.length;
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L24;
        c(r11[r13]);
        r13 = r13 + 1;
        goto L16
    L24:
        return;
    L23:
        return;
    }
}
