package moc;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.e;
import z5c.p2;
import z5c.p3;
import z5c.v1;
import z5c.w0;
import z5c.x0;
import z5c.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r1, String r2, String r3, boolean r4, boolean r5, s5c.a r6) {
        Intrinsics.checkNotNullParameter(r1, "functionKey");
        Intrinsics.checkNotNullParameter(r2, "functionScene");
        Intrinsics.checkNotNullParameter(r3, "functionCategory");
        Intrinsics.checkNotNullParameter(r6, "click");
        s5c.a r0 = p3.c;
        r6.getClass();
        d r7 = d.b.b(r6, r0).plus(y0.c.a(r1)).plus(x0.d.a(r2)).plus(w0.c.a(r3));
        if (r4 == false) goto L5;
        s5c.a r8 = e.c;
    L6:
        d r9 = r7.plus(r8);
        if (r5 == false) goto L9;
        s5c.a r10 = v1.d;
    L10:
        Statistics.sendEvent("common_pricing_popup_click", r9.plus(r10).plus(p2.c).toJson());
        return;
    L9:
        r10 = v1.c;
        goto L10
    L5:
        r8 = e.d;
        goto L6
    }
}
