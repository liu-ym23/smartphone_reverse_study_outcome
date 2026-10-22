package com.larus.bmhome.chat.component.list;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z3 implements Function1 {
    public /* synthetic */ z3() {
    }

    public final Object invoke(Object r5) {
        View r6 = (View) r5;
        int r0 = ChatListComponent.W3;
        if (r6 == null) goto L8;
        ViewPropertyAnimator r7 = r6.animate();
        r7.alpha(1.0f);
        r7.setDuration(150);
        r7.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r7.start();
        return null;
    L8:
        return null;
    }
}
