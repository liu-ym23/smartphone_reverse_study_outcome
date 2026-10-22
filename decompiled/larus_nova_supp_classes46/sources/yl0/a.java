package yl0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Animator a(Integer r13, boolean r14, View r15) {
        if (r13 != null) goto L6;
    L35:
        if (r13 != null) goto L38;
    L55:
        return null;
    L38:
        if (r13.intValue() != 1) goto L55;
        Float r16 = Float.valueOf(0.0f);
        if (r15 == null) goto L42;
        r15.setPivotX(0.0f);
    L42:
        if (r15 == null) goto L52;
        if (r15.getHeight() != 0) goto L49;
        ViewGroup.LayoutParams r1 = r15.getLayoutParams();
        if (r1 == null) goto L48;
        int r2 = r1.height;
    L50:
        r15.setPivotY(r2);
        goto L52
    L48:
        r2 = 0;
        goto L50
    L49:
        r2 = r15.getHeight();
    L52:
        if (r14 == false) goto L54;
        AnimatorSet r17 = new AnimatorSet();
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r15, "alpha", new float[]{0.05f, 1.0f});
        r18.setDuration(250);
        Unit r19 = Unit.INSTANCE;
        r17.playTogether(new Animator[]{b.a(r15, 250, TuplesKt.to(r16, Float.valueOf(1.03f)), 140, TuplesKt.to(Float.valueOf(1.03f), Float.valueOf(1.0f))), r18});
        r17.setInterpolator(new AccelerateInterpolator());
        return r17;
    L54:
        Animator r110 = b.a(r15, 120, TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.03f)), 160, TuplesKt.to(Float.valueOf(1.03f), r16));
        r110.setInterpolator(new AccelerateInterpolator());
        return r110;
    L6:
        if (r13.intValue() != 0) goto L35;
        if (r14 == false) goto L22;
        AnimatorSet r111 = new AnimatorSet();
        if (r15 == null) goto L12;
        r15.setPivotX(0.0f);
    L12:
        if (r15 != null) goto L14;
    L21:
        r111.playTogether(new Animator[]{ObjectAnimator.ofFloat(r15, "scaleX", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(r15, "scaleY", new float[]{0.0f, 1.0f})});
        r111.setDuration(360);
        return r111;
    L14:
        if (r15.getHeight() != 0) goto L19;
        ViewGroup.LayoutParams r3 = r15.getLayoutParams();
        if (r3 == null) goto L18;
        int r4 = r3.height;
    L20:
        r15.setPivotY(r4 * 0.8f);
        goto L21
    L18:
        r4 = 0;
        goto L20
    L19:
        r4 = r15.getHeight();
        goto L20
    L22:
        AnimatorSet r112 = new AnimatorSet();
        if (r15 == null) goto L25;
        r15.setPivotX(0.0f);
    L25:
        if (r15 != null) goto L27;
    L34:
        r112.playTogether(new Animator[]{ObjectAnimator.ofFloat(r15, "scaleX", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r15, "scaleY", new float[]{1.0f, 0.0f})});
        r112.setDuration(440);
        return r112;
    L27:
        if (r15.getHeight() != 0) goto L32;
        ViewGroup.LayoutParams r5 = r15.getLayoutParams();
        if (r5 == null) goto L31;
        int r6 = r5.height;
    L33:
        r15.setPivotY(r6 * 0.8f);
        goto L34
    L31:
        r6 = 0;
        goto L33
    L32:
        r6 = r15.getHeight();
        goto L33
    }
}
