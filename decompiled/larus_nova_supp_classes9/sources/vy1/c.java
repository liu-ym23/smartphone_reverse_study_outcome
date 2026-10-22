package vy1;

import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements ry1.a.b {
    public Pair<? extends RegionId, j80.d> a;
    public Pair<? extends RegionId, j80.d> b;
    public final /* synthetic */ a c;
    public final /* synthetic */ GroupComponentState.Style d;
    public final /* synthetic */ int e;

    @Override // ry1.a.b
    public final void a(Pair<? extends RegionId, j80.d> r10) {
        this.b = r10;
        Pair<? extends RegionId, j80.d> r11 = this.a;
        ty1.c r0 = null;
        if (r11 == null) goto L5;
        RegionId r13 = (RegionId) r11.getFirst();
    L6:
        Pair<? extends RegionId, j80.d> r1 = this.b;
        if (r1 == null) goto L9;
        RegionId r2 = (RegionId) r1.getFirst();
    L11:
        if (r13 != r2) goto L24;
        Pair<? extends RegionId, j80.d> r14 = this.a;
        if (r14 == null) goto L15;
        j80.d r15 = (j80.d) r14.getSecond();
    L16:
        Pair<? extends RegionId, j80.d> r3 = this.b;
        if (r3 == null) goto L19;
        j80.d r4 = (j80.d) r3.getSecond();
    L21:
        if ((!Intrinsics.areEqual(r15, r4)) == true) goto L24;
        boolean r16 = false;
    L25:
        if (r16 == false) goto L45;
        a r17 = this.c;
        GroupComponentState.Style r5 = this.d;
        int r6 = this.e;
        FrameLayout r7 = r17.k;
        if (r7 != null) goto L30;
    L41:
        if (r0 != null) goto L43;
        return;
    L43:
        this.c.o(new com.bytedance.android.livesdk.gift.grouplive.component.b(r0, true));
        return;
    L30:
        if (r7.getWidth() == 0) goto L41;
        if (r7.getHeight() == 0) goto L41;
        if (r7.getVisibility() != 0) goto L41;
        float r8 = r7.getWidth();
        float r9 = r7.getHeight() / r8;
        float r18 = r8 / r17.q();
        float r19 = (r9 * r18) * 0.46182266f;
        if (r5 != GroupComponentState.Style.HORIZONTAL) goto L39;
        float r20 = r7.getY();
        int r21 = r17.h.getHeight() - r6;
    L40:
        float r23 = r20 / r21;
        float r24 = r7.getX() / r17.h.getWidth();
        float r25 = (r7.getY() + r7.getHeight()) / r17.h.getHeight();
        float r26 = (r7.getX() + r7.getWidth()) / r17.h.getWidth();
        ty1.c r110 = new ty1.c(0);
        r110.j(j80.a.a(r23, 4));
        r110.h(j80.a.a(r24, 4));
        r110.i(j80.a.a(r26, 4));
        r110.f(j80.a.a(r25, 4));
        r110.k(j80.a.a(r18, 4));
        r110.g(j80.a.a(r19, 4));
        r0 = r110;
        goto L41
    L39:
        r20 = r7.getY();
        r21 = r17.h.getHeight();
        goto L40
    L45:
        return;
    L19:
        r4 = null;
        goto L21
    L15:
        r15 = null;
    L24:
        r16 = true;
        goto L25
    L9:
        r2 = null;
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    @Override // ry1.a.b
    public final void b(Pair<? extends RegionId, j80.d> r2) {
        this.a = r2;
        a r3 = this.c;
        r3.s(r3.j.getWidth());
    }

    @Override // ry1.a.b
    public final void c(RegionId r3) {
        Intrinsics.checkNotNullParameter(r3, "currentRegion");
        a r0 = this.c;
        r0.r(r3, r0.j.getWidth());
    }

    public c(a r1, GroupComponentState.Style r2, int r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
