package com.bytedance.android.live.liveinteract.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AnimatorSet a(ArrayList r8, float r9, float r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, "views");
        AnimatorSet r0 = new AnimatorSet();
        ArrayList r1 = new ArrayList();
        Iterator r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        View r2 = (View) r12.next();
        if (r2 == null) goto L4;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{r9, r10});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{r9, r10});
        r4.setRepeatCount(0);
        r3.setRepeatCount(0);
        r1.add(r4);
        r1.add(r3);
        goto L4
    L8:
        r0.setDuration(r11);
        r0.playTogether(r1);
        return r0;
    }
}
