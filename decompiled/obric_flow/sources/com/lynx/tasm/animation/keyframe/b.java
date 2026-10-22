package com.lynx.tasm.animation.keyframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f10084b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10085a;

    static {
        HashMap r5 = new HashMap();
        f10084b = r5;
        r5.put("animation_type", "keyframe-animation");
        r5.put("animation_name", "");
    }

    public b(g r5) {
        this.f10085a = new WeakReference(r5);
    }

    public static void a(LynxUI r5, String r10, String r11) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getEvents() != null) goto L7;
        return;
    L7:
        if (r5.getEvents().containsKey(r10) == false) goto L11;
        HashMap r12 = f10084b;
        r12.put("animation_name", r11);
        r5.getLynxContext().g.b(new on.b(r5.getSign(), r10, r12));
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        super.onAnimationCancel(r5);
        if (r5 == null) goto L6;
        r5.removeAllListeners();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        super.onAnimationEnd(r5);
        g r10 = (g) this.f10085a.get();
        if (r10 != null) goto L5;
        return;
    L5:
        tm.b r11 = r10.f10104i;
        if (r11 == null) goto L8;
        String r12 = r11.f22140a;
    L10:
        if (r10.f10103h != LynxKeyframeAnimator$LynxKFAnimatorState.f10079b) goto L15;
        LynxUI r13 = (LynxUI) r10.f10101b.get();
        a(r13, "animationend", r12);
        if (r13 == null) goto L14;
        r13.onAnimationEnd(r12);
    L14:
        r10.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.f10078a;
    L15:
        if (r11 == null) goto L22;
        int r14 = r11.f22147l;
        if (r14 == 1) goto L22;
        if (r14 == 3) goto L22;
        r10.j();
    L22:
        r10.g = null;
        return;
    L8:
        r12 = "";
        goto L10
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
        super.onAnimationRepeat(r5);
        g r10 = (g) this.f10085a.get();
        if (r10 != null) goto L5;
        return;
    L5:
        tm.b r11 = r10.f10104i;
        if (r11 == null) goto L8;
        String r12 = r11.f22140a;
    L9:
        a((LynxUI) r10.f10101b.get(), "animationiteration", r12);
        return;
    L8:
        r12 = "";
        goto L9
    }
}
