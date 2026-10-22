package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ SimpleGuestApplyViewHolder a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.e.getViewTreeObserver().removeOnPreDrawListener(this);
        int r0 = s1.f(162.0f);
        if (this.a.e.getWidth() < r0) goto L10;
        SimpleGuestApplyViewHolder r1 = this.a;
        int r2 = r0 - r1.c.getWidth();
        r1.getClass();
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(r1.e);
        if (r1.f.getWidth() <= r2) goto L7;
        r3.constrainWidth(r1.f.getId(), r2);
    L7:
        r3.applyTo(r1.e);
        this.a.g.setVisibility(0);
        return true;
    L10:
        return true;
    }

    public c(SimpleGuestApplyViewHolder r1) {
        this.a = r1;
    }
}
