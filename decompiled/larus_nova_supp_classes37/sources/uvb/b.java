package uvb;

import android.view.View;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(View r2) {
        a(r2, 2131391985, c.k);
        a(r2, 2131388654, c.l);
        a(r2, 2131375672, c.m);
    }

    public static void a(View r0, int r1, c.a r2) {
        if (r0 == null) goto L4;
        View r3 = r0.findViewById(r1);
    L5:
        a.b(r3, r2);
        return;
    L4:
        r3 = null;
        goto L5
    }
}
