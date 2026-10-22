package qe;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static volatile Choreographer choreographer;

    static {
        Object r8 = new f(a(Looper.getMainLooper()));     // Catch: Throwable -> L4
    L7:
        if ((r8 instanceof xd.e.a) == false) goto L9;
        r8 = null;
    L9:
        g r10 = (g) r8;
        return;
    L4:
        th = move-exception;
        r8 = defpackage.c.D(th);
        goto L7
    }

    public static final Handler a(Looper r8) {
        Object r10 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r8});
        i.d(r10, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r10;
    }
}
