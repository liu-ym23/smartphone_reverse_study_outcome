package g3;

import android.os.Looper;
import c2.k;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7628a = null;

        static {
            f7628a = new b();
        }
    }

    public b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        Throwable r10 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        b3.b.C0032b.f3038a.c(new g3.a(r10));
    L8:
        boolean r11 = k.f3297a;
        return;
    L5:
        r8 = false;
        goto L6
    }
}
