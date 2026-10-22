package d5;

import android.os.Environment;
import java.util.ArrayList;
import java.util.Iterator;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f6800a;

    public j(j0 r8) {
        this.f6800a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j0 r8 = this.f6800a;
        ArrayList r10 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (r8.C == false) goto L34;
    L21:
        Iterator r11 = r10.iterator();
    L23:
        if (r11.hasNext() == false) goto L29;
        defpackage.c.E((String) r11.next());     // Catch: Throwable -> L27
        int r12 = x4.r.f13543a;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L34:
        r10.add(Environment.getExternalStorageDirectory().getPath() + t2.b.j("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L30:
        r10.add(Environment.getExternalStorageDirectory().getPath() + "/" + t2.b.x());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L30
    L4:
        if (r8.C == false) goto L6;
        String r13 = "device_id";
    L7:
        r10.add(r8.f13465c.getExternalCacheDir().getParent() + "/" + r13);     // Catch: Throwable -> L9
        goto L12
    L6:
        r13 = t2.b.x();     // Catch: Throwable -> L9
        goto L7
    }
}
