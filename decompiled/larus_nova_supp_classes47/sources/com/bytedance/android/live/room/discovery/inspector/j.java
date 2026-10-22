package com.bytedance.android.live.room.discovery.inspector;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ OfficialInspectorWidget a;

    public j(OfficialInspectorWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        TextView r0 = this.a.c;
        if (r0 == null) goto L13;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L13;
        Object r4 = r3.getAnimatedValue();
        if ((r4 instanceof Integer) == true) goto L9;
        r4 = null;
    L9:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L12;
        r1.width = r5.intValue();
        goto L13
    L12:
        return;
    L13:
        TextView r6 = this.a.c;
        if (r6 == null) goto L17;
        r6.requestLayout();
        return;
    }
}
