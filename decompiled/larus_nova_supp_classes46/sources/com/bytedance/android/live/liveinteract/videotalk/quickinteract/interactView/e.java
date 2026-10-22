package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ConstraintLayout a;
    public final /* synthetic */ LinkMicQuickInteractView b;
    public final /* synthetic */ boolean c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r0 = this.a.getWidth();
        View r1 = this.b.findViewById(2131379435);
        View r2 = this.b.findViewById(2131372014);
        if (r1 == null) goto L5;
        r1.measure(0, 0);
    L5:
        if (r2 == null) goto L7;
        r2.measure(0, 0);
    L7:
        if (r1 == null) goto L9;
        int r3 = r1.getMeasuredWidth();
    L10:
        if (r2 != null) goto L12;
    L16:
        int r4 = 0;
    L17:
        int r5 = r3 + r4;
        ConstraintSet r6 = new ConstraintSet();
        r6.clone(this.a);
        if (r5 <= r0) goto L22;
        r6.clear(this.b.getId(), 6);
        r6.connect(this.b.getId(), 7, 0, 7);
        r6.applyTo(this.a);
        ViewGroup.LayoutParams r7 = this.b.getLayoutParams();
        if (r7 == null) goto L24;
        r7.width = r5;
        this.b.setLayoutParams(r7);
    L24:
        this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L22:
        if (r5 >= r0) goto L24;
        this.b.f(this.a);
        goto L24
    L12:
        if (r2.getVisibility() != 0) goto L16;
        if (this.c == true) goto L16;
        r4 = r2.getMeasuredWidth();
        goto L17
    L9:
        r3 = 0;
        goto L10
    }

    public e(ConstraintLayout r1, LinkMicQuickInteractView r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
