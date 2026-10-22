package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final void a(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$cancelRunning");
        if (r1.isRunning() == false) goto L6;
        r1.cancel();
        r1.removeAllListeners();
        return;
    }

    public static final void b(AnimatorSet r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$clearAllListener");
        r2.removeAllListeners();
        ArrayList<Animator> r3 = r2.getChildAnimations();
        if (r3 == null) goto L12;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L21;
        Animator r0 = (Animator) r4.next();
        if ((r0 instanceof AnimatorSet) == true) goto L9;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
        goto L6
    L9:
        b((AnimatorSet) r0);
        goto L6
    L21:
        return;
    }

    public static final void c(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r2, "action");
        r1.addListener(new a(r2));
    }
}
