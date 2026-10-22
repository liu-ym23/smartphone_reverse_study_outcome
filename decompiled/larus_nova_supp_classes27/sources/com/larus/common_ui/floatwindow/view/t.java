package com.larus.common_ui.floatwindow.view;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements HorizontalDragFrameLayout.b {
    public final /* synthetic */ HorizontalDragFrameLayout a;
    public final /* synthetic */ FullScreenFloatWindowHandler b;

    @Override // com.larus.common_ui.floatwindow.view.HorizontalDragFrameLayout.b
    public final void a(float r4) {
        float r0 = this.a.getTranslationX();
        FullScreenFloatWindowHandler r1 = this.b;
        float r2 = RangesKt.coerceAtLeast(r1.t - r1.m, 0.0f);
        float r5 = RangesKt.coerceIn(r0 + r4, 0.0f, r2);
        this.a.setTranslationX(r5);
        float r3 = 1.0f;
        if (r2 <= 0.0f) goto L5;
        r3 = 1.0f - (r5 / r2);
    L5:
        this.b.y(r3, true);
    }

    @Override // com.larus.common_ui.floatwindow.view.HorizontalDragFrameLayout.b
    public final void c(float r8) {
        float r0 = this.a.getTranslationX();
        FullScreenFloatWindowHandler r1 = this.b;
        Integer r2 = r1.r;
        if (r2 == null) goto L5;
        float r3 = r2.intValue();
    L6:
        FullScreenFloatWindowHandler r4 = this.b;
        float r5 = RangesKt.coerceAtLeast(r4.t - r4.m, 0.0f);
        FullScreenFloatWindowHandler r6 = this.b;
        Float r7 = r6.s;
        boolean r9 = true;
        if (r6.k == false) goto L19;
        if (r0 >= r3) goto L14;
        if (r7 != null) goto L12;
    L15:
        if (r9 == false) goto L17;
        this.b.n();
        return;
    L17:
        this.b.m();
        return;
    L12:
        if (r8 < r7.floatValue()) goto L15;
    L14:
        r9 = false;
        goto L15
    L19:
        if (r0 <= (r5 - r3)) goto L24;
        if (r7 != null) goto L22;
    L25:
        if (r9 == false) goto L27;
        this.b.m();
        return;
    L27:
        this.b.n();
        return;
    L22:
        if (r8 > (-r7.floatValue())) goto L25;
    L24:
        r9 = false;
        goto L25
    L5:
        r3 = RangesKt.coerceAtLeast(r1.t - r1.m, 0.0f) / 2.0f;
        goto L6
    }

    public t(HorizontalDragFrameLayout r1, FullScreenFloatWindowHandler r2) {
        this.a = r1;
        this.b = r2;
    }
}
