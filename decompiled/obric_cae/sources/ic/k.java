package ic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f8325b;

    public k(OInputView r8, TextView r10) {
        this.f8324a = r8;
        this.f8325b = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        he.i.f(r8, "animation");
        OInputView r10 = this.f8324a;
        boolean r11 = r10.getVInput().hasFocus();
        TextView r12 = this.f8325b;
        if (r11 == false) goto L6;
        OInputView.a r13 = OInputView.a.f6312a;
    L5:
        r10.C(r13, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L6:
        r13 = OInputView.a.f6313b;
        goto L5
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        he.i.f(r8, "animation");
        OInputView r10 = this.f8324a;
        boolean r11 = r10.getVInput().hasFocus();
        TextView r12 = this.f8325b;
        if (r11 == false) goto L6;
        OInputView.a r13 = OInputView.a.f6312a;
    L5:
        r10.C(r13, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L6:
        r13 = OInputView.a.f6313b;
        goto L5
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8, boolean r10) {
        he.i.f(r8, "animation");
        OInputView.a r11 = OInputView.a.f6313b;
        int r12 = OInputView.f6291v0;
        this.f8324a.C(r11, this.f8325b, "LabelShowAnim, onAnimationStart");
    }
}
