package com.obric.oui.panel;

import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f13994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13995c;
    public final /* synthetic */ BottomSheetBehavior d;

    public /* synthetic */ a(BottomSheetBehavior r5, View r10, int r11, int r12) {
        this.f13993a = r12;
        this.d = r5;
        this.f13994b = r10;
        this.f13995c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13993a) {
            case 0: goto L31;
            default: goto L4;
        };
    L4:
        BottomSheetBehavior r5 = this.d;
        j r10 = r5.f13964p;
        if (r10 == null) goto L29;
        boolean r11 = false;
        if (r10.f14011a != 2) goto L25;
        OverScroller r12 = r10.f14022p;
        boolean r13 = r12.computeScrollOffset();
        int r14 = r12.getCurrX();
        int r15 = r12.getCurrY();
        int r16 = r14 - r10.f14024r.getLeft();
        int r17 = r15 - r10.f14024r.getTop();
        if (r16 == 0) goto L11;
        ViewCompat.offsetLeftAndRight(r10.f14024r, r16);
    L11:
        if (r17 == 0) goto L13;
        ViewCompat.offsetTopAndBottom(r10.f14024r, r17);
    L13:
        if (r16 != 0) goto L15;
        if (r17 != 0) goto L15;
    L16:
        if (r13 == true) goto L18;
    L22:
        if (r13 == true) goto L25;
        r10.f14025t.post(r10.f14027v);
        goto L25
    L18:
        if (r14 != r12.getFinalX()) goto L22;
        if (r15 != r12.getFinalY()) goto L22;
        r12.abortAnimation();
        r13 = false;
    L15:
        r10.f14023q.p(r10.f14024r, r14, r15, r16, r17);
    L25:
        if (r10.f14011a != 2) goto L27;
        r11 = true;
    L27:
        if (r11 == false) goto L29;
        ViewCompat.postOnAnimation(this.f13994b, this);
        return;
    L29:
        r5.setStateInternal(this.f13995c);
        return;
    L31:
        View r18 = this.f13994b;
        this.d.b(this.f13995c, r18);
    }
}
