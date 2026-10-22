package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.ValueAnimator;
import com.bytedance.android.livesdk.chatroom.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ UserinfoWidthServiceElement a;

    public p(UserinfoWidthServiceElement r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "va");
        Object r0 = r3.getAnimatedValue();
        if ((r0 instanceof Integer) == true) goto L5;
        r0 = null;
    L5:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
        this.a.c.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r2));
    L8:
        r r4 = z51.a.e(this.a.getDataCenter());
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.n r5 = r4.A();
        if (r5 == null) goto L15;
        r5.setValue(Float.valueOf(r3.getAnimatedFraction()));
        return;
    L15:
        return;
    }
}
