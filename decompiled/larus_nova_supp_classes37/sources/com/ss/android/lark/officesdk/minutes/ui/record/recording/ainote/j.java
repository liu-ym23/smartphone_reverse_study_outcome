package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements MmAINotePanelGestureInterceptLayout.a {
    public final /* synthetic */ MmAINotePanelAnimator a;

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final boolean a() {
        if (this.a.o != MmAINoteSheetState.HALF) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void d() {
        MmAINotePanelAnimator r0 = this.a;
        if (r0.y == false) goto L13;
        r0.j();
        r0.y = false;
        if (r0.u == 0) goto L8;
        return;
    L8:
        if (r0.L == false) goto L12;
        r0.L = false;
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final boolean onDragStart() {
        MmAINotePanelAnimator r0 = this.a;
        if (r0.K == false) goto L5;
    L14:
        return false;
    L5:
        if (r0.o == MmAINoteSheetState.CLOSED) goto L14;
        ValueAnimator r1 = r0.q;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        ValueAnimator r2 = r0.r;
        if (r2 == null) goto L13;
        r2.cancel();
    L13:
        r0.y("content");
        int r3 = r0.m();
        r0.z = r3;
        r0.B(r3);
        r0.i();
        r0.y = true;
        return true;
    }

    public j(MmAINotePanelAnimator r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void b(float r3) {
        MmAINotePanelAnimator r0 = this.a;
        if (r0.y == false) goto L6;
        r0.G(r3);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINotePanelGestureInterceptLayout.a
    public final void c(float r3) {
        MmAINotePanelAnimator r0 = this.a;
        if (r0.y == false) goto L13;
        r0.D(r3, 0.0f);
        r0.y = false;
        if (r0.u == 0) goto L8;
        return;
    L8:
        if (r0.L == false) goto L12;
        r0.L = false;
        return;
    L12:
        return;
    }
}
