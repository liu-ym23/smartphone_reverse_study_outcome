package com.obric.oui.panel;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.bytedance.android.anniex.base.service.e {
    public final /* synthetic */ BottomSheetBehavior f;

    public b(BottomSheetBehavior r5) {
        this.f = r5;
    }

    public final int n(View r5, int r10, int r11) {
        BottomSheetBehavior r12 = this.f;
        int r13 = r12.a();
        if (r12.f13959k == false) goto L5;
        int r14 = r12.f13967t;
    L7:
        return MathUtils.clamp(r10, r13, r14);
    L5:
        r14 = r12.f13958j;
        goto L7
    }

    public final int o(View r5) {
        BottomSheetBehavior r10 = this.f;
        if (r10.f13959k == false) goto L7;
        return r10.f13967t;
    L7:
        return r10.f13958j;
    }

    public final void p(View r5, int r10, int r11, int r12, int r13) {
        this.f.dispatchOnSlide(r11);
    }

    public final void q(View r10, float r11, float r12) {
        BottomSheetBehavior r13 = this.f;
        int r5 = 0;
        int r14 = 6;
        int r15 = 3;
        if (r12 >= 0.0f) goto L15;
        r13.getClass();
        if (Math.abs(r12) <= 1500.0f) goto L15;
        if (r13.f13953a == false) goto L9;
        int r16 = r13.f13956h;
    L46:
        int[] r17 = {r16, r15};
        int r18 = r17[0];
        int r19 = r17[1];
        r13.f13963o = r19;
        j r20 = r13.f13964p;
        int r21 = r10.getLeft();
        if (r20.s == false) goto L54;
        if (r20.f(r21, r18, (int) r20.f14018l.getXVelocity(r20.f14013c), (int) r20.f14018l.getYVelocity(r20.f14013c)) == false) goto L51;
        r13.setStateInternal(2);
        ViewCompat.postOnAnimation(r10, new a(r13, r10, r19, 1));
        return;
    L51:
        r13.setStateInternal(r19);
        return;
    L54:
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    L9:
        int r22 = r10.getTop();
        int r23 = r13.f13957i;
        if (r22 <= r23) goto L12;
        r5 = r23;
    L13:
        r16 = r5;
        r15 = r14;
    L12:
        r14 = 3;
    L15:
        if (r13.f13959k == false) goto L24;
        if (r13.shouldHide(r10, r12) == false) goto L24;
        if (r10.getTop() <= r13.f13958j) goto L21;
    L22:
        r16 = r13.f13967t;
        r15 = 5;
        goto L46
    L21:
        if (Math.abs(r11) < Math.abs(r12)) goto L22;
    L24:
        if (r12 != 0.0f) goto L26;
    L29:
        int r24 = r10.getTop();
        if (r13.f13953a == true) goto L32;
        int r25 = r13.f13957i;
        if (r24 >= r25) goto L43;
        if (r24 < Math.abs(r24 - r13.f13958j)) goto L12;
        r5 = r13.f13957i;
        goto L13
    L43:
        if (Math.abs(r24 - r25) >= Math.abs(r24 - r13.f13958j)) goto L45;
        r5 = r13.f13957i;
        goto L13
    L45:
        r5 = r13.f13958j;
    L35:
        r14 = 4;
        goto L13
    L32:
        if (Math.abs(r24 - r13.f13956h) >= Math.abs(r24 - r13.f13958j)) goto L34;
        r5 = r13.f13956h;
        goto L12
    L34:
        r5 = r13.f13958j;
        goto L35
    L26:
        if (Math.abs(r11) > Math.abs(r12)) goto L29;
        r16 = r13.f13958j;
        r15 = 4;
        goto L46
    }
}
