package l2a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends Transition {
    public final boolean a;

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues r1) {
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues r1) {
    }

    public a(boolean r1) {
        this.a = r1;
    }

    @Override // android.transition.Transition
    public final Animator createAnimator(ViewGroup r7, TransitionValues r8, TransitionValues r9) {
        Intrinsics.checkNotNullParameter(r7, "sceneRoot");
        View r10 = null;
        if (r8 == null) goto L7;
        View r11 = r8.view;
        if (r11 == null) goto L7;
        String r12 = r11.getTransitionName();
    L8:
        if (r12 != null) goto L11;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        if (r12.length() <= 0) goto L13;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L27;
        if (r8 == null) goto L18;
        r10 = r8.view;
    L18:
        float[] r14 = new float[2];
        boolean r15 = this.a;
        float r3 = 1.0f;
        if (r15 == false) goto L21;
        float r5 = 1.0f;
    L22:
        r14[0] = r5;
        if (r15 == false) goto L25;
        r3 = 0.0f;
    L25:
        r14[1] = r3;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r10, "alpha", r14);
        Intrinsics.checkNotNull(r16);
        return r16;
    L21:
        r5 = 0.0f;
        goto L22
    L27:
        return ObjectAnimator.ofFloat(null, "alpha", new float[]{1.0f, 1.0f});
    L13:
        r13 = false;
    L7:
        r12 = null;
        goto L8
    }
}
