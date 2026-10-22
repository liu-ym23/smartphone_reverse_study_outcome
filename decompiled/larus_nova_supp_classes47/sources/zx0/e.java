package zx0;

import android.graphics.RectF;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.livesdk.model.p0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements zx0.a {
    public final float a;

    public static final class a {
    }

    static {
    }

    public e() {
        this.a = com.bytedance.android.live.revlink.impl.settings.live.a.j.a();
    }

    @Override // zx0.a
    public final b a(com.bytedance.android.live.revenue.common.player.vendor.link.c r13) {
        Intrinsics.checkNotNullParameter(r13, "reduceContext");
        RectF r0 = b(r13);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r13.b == false) goto L8;
        int r2 = (int) ((r13.e * 9.0f) / 16.0f);
    L10:
        if (r13.a == true) goto L12;
        Number r3 = Float.valueOf(this.a * ((int) (r2 / 0.5625f)));
    L17:
        float r5 = r13.j.f();
        if (r13.k == false) goto L32;
        int r6 = ay0.a.a();
        if (r6 == 1) goto L32;
        if (r6 != 2) goto L30;
        int r7 = r13.g;
        if (r7 == 0) goto L30;
        int r8 = r13.f;
        if (r8 == 0) goto L30;
        float r9 = r8 * 1.0f;
        float r10 = r7;
    L31:
        r5 = r9 / r10;
    L30:
        r10 = r5;
        r9 = 1;
    L32:
        int r4 = r3.intValue() + r13.h;
        if (Intrinsics.areEqual(r13.j.o(), Boolean.TRUE) == false) goto L47;
        if (r13.c == false) goto L38;
        sx0.a r12 = new sx0.a.b(r13.j.f(), r4);
    L60:
        return new b(r0, r12, null);
    L38:
        if (r13.a == false) goto L41;
        sx0.a.c r14 = new sx0.a.c(r13.j.f());
    L40:
        r12 = r14;
        goto L60
    L41:
        p0 r15 = r13.j.b();
        if (r15 == null) goto L44;
        float r16 = r15.g();
    L45:
        r14 = new sx0.a.c(r16);
        goto L40
    L44:
        r16 = r13.d / r13.e;
        goto L45
    L47:
        if (r13.a == false) goto L52;
        if (r13.c == true) goto L52;
        r12 = new sx0.a.c(r5);
    L52:
        if (r13.b == false) goto L58;
        float r17 = (((((r13.e * 9.0f) / 16.0f) / r0.width()) / r5) * r0.height()) / r13.e;
        com.bytedance.android.live.revlink.impl.settings.live.a r18 = com.bytedance.android.live.revlink.impl.settings.live.a.j;
        r18.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.h.getValue(r18, com.bytedance.android.live.revlink.impl.settings.live.a.a[6])).booleanValue() == true) goto L57;
        r17 = (9.0f / (16.0f * r5)) * r0.height();
    L57:
        r12 = new sx0.a.C0316a(r5, r4, r17);
        goto L60
    L58:
        r12 = new sx0.a.b(r5, r4);
        goto L60
    L12:
        if (r13.c == false) goto L14;
        int r19 = i.b(134);
    L15:
        r3 = Integer.valueOf(r19);
        goto L17
    L14:
        r19 = 0;
        goto L15
    L8:
        r2 = r13.d;
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
        if (r7 != 2) goto L20;
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
