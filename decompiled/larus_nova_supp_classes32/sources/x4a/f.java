package x4a;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f {
    public static void a(g r1, MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getAction() != 0) goto L8;
        r1.getPlayer().h(r2.getX(), r2.getY());
        return;
    }
}
