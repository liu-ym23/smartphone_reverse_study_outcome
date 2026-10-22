package zx0;

import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements zx0.a {

    public static final class a {
    }

    static {
    }

    public d() {
        com.bytedance.android.live.revlink.impl.settings.live.a.j.a();
    }

    @Override // zx0.a
    public final b a(com.bytedance.android.live.revenue.common.player.vendor.link.c r7) {
        Intrinsics.checkNotNullParameter(r7, "reduceContext");
        RectF r0 = b(r7);
        if (r0 != null) goto L5;
        return null;
    L5:
        Integer r2 = (Integer) r7.j.m.getValue();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L10:
        if (r3 != 1) goto L14;
        b03.a r4 = b03.a.a;
        double r5 = ((double) s1.w()) * 0.19d;
        return new b(r0, new sx0.a.b(((Number) r7.j.s.getValue()).floatValue(), (int) r5), null);
    L14:
        if (r7.m == false) goto L18;
        return new b(r0, new sx0.a.f(r7.j.f()), null);
    L18:
        return new b(r0, new sx0.a.d(r7.j.f()), null);
    L8:
        r3 = 0;
        goto L10
    }

    @Override // zx0.a
    public final RectF b(com.bytedance.android.live.revenue.common.player.vendor.link.c r6) {
        Intrinsics.checkNotNullParameter(r6, "reduceContext");
        JSONArray r7 = com.bytedance.android.live.revenue.common.player.utils.a.c(r6.j.d());
        if (r7 != null) goto L6;
        return null;
    L6:
        float r0 = (float) com.bytedance.android.live.revenue.common.player.utils.a.i(r7);
        float r1 = (float) com.bytedance.android.live.revenue.common.player.utils.a.d(r7);
        float r2 = (float) com.bytedance.android.live.revenue.common.player.utils.a.g(r7);
        float r8 = (float) com.bytedance.android.live.revenue.common.player.utils.a.h(r7);
        return new RectF(r2, r8, r0 + r2, r1 + r8);
    }

    @Override // zx0.a
    public final boolean c(com.bytedance.android.live.revenue.common.player.vendor.link.c r4) {
        Intrinsics.checkNotNullParameter(r4, "reduceContext");
        RevSeiFrame r5 = r4.j;
        Integer r0 = r5.n();
        if (r0 != null) goto L6;
    L7:
        Integer r1 = r5.n();
        if (r1 != null) goto L11;
    L12:
        return false;
    L11:
        if (r1.intValue() != 19) goto L12;
    L13:
        Integer r6 = r5.m();
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
    L18:
        if (r7 == 2) goto L20;
        return false;
    L20:
        return true;
    L16:
        r7 = 0;
        goto L18
    L6:
        if (r0.intValue() == 6) goto L13;
        goto L7
    }
}
