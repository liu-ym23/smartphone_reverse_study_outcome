package com.ss.android.lark.forseti.util.animation;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.ss.android.lark.api.ui.e;
import com.ss.android.lark.forseti.animation.RenderProperty;
import com.ss.android.lark.forseti.animation.c;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiAnimatorLauncher {
    public static final Lazy a = null;
    public static final List<e> b = null;

    public ForsetiAnimatorLauncher() {
    }

    static {
        a = LazyKt.lazy(ForsetiAnimatorLauncher$asyncAnimationFG$2.INSTANCE);
        b = new ArrayList();
    }

    public static void b(ViewGroup r5) {
        if (r5 != null) goto L5;
        Log.e("ForsetiAnimatorLauncher", "skips change bounds for viewGroup is null.");
        return;
    L5:
        ChangeBounds r0 = new ChangeBounds();
        r0.setDuration(300);
        r0.setInterpolator(PathInterpolatorCompat.create(0.34f, 0.69f, 0.1f, 1.0f));
        r0.addListener(new ForsetiAnimatorLauncher$startChangeBounds$changeBounds$1$1());
        TransitionManager.beginDelayedTransition(r5, r0);
    }

    public static boolean a(Context r3, View r4, Float r5, Float r6, Animator.AnimatorListener r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (((Boolean) a.getValue()).booleanValue() == true) goto L6;
        Log.e("ForsetiAnimatorLauncher", "skips animation for async animation fg is false.");
        return false;
    L6:
        if (r4 != null) goto L9;
        Log.e("ForsetiAnimatorLauncher", "skips animation for view is null.");
        return false;
    L9:
        if (r5 == null) goto L35;
        if (r6 == null) goto L35;
        RenderProperty.VIEW_PROPERTY[0].set(r4, r5);
        int r8 = c.c;
        c r9 = c.a.a(r4, r6.floatValue());
        Interpolator r10 = PathInterpolatorCompat.create(0.34f, 0.69f, 0.1f, 1.0f);
        Animator r11 = r9.a;
        if (r11 != null) goto L15;
    L17:
        Animator r12 = r9.a;
        if (r12 != null) goto L20;
    L22:
        if (r7 == null) goto L26;
        Animator r13 = r9.a;
        if (r13 == null) goto L26;
        r13.addListener(r7);
    L26:
        Animator r14 = r9.a;
        if (r14 != null) goto L31;
        Log.e("ForsetiAnimatorLauncher", "skips animation for animator is null.");
        return false;
    L31:
        if (r14.isStarted() == true) goto L37;
        r9.a.start();
        return true;
    L37:
        return true;
    L20:
        if (r12.isStarted() == true) goto L22;
        r9.a.setDuration(300);
        goto L22
    L15:
        if (r11.isStarted() == true) goto L17;
        r9.a.setInterpolator(r10);
    L35:
        Log.e("ForsetiAnimatorLauncher", "skips animation for resetValue or targetValue is null.");
        return false;
    }
}
