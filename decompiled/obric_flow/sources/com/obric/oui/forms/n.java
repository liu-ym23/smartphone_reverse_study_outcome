package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OInputView f13345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f13346c;

    public /* synthetic */ n(OInputView r5, TextView r10, int r11) {
        this.f13344a = r11;
        this.f13345b = r5;
        this.f13346c = r10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        switch(this.f13344a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "animation");
        OInputView r10 = this.f13345b;
        boolean r11 = r10.getVInput().hasFocus();
        TextView r12 = this.f13346c;
        if (r11 == false) goto L7;
        r10.w(OInputView.LabelUIState.REAL_LABEL_SHOW, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L7:
        r10.w(OInputView.LabelUIState.FAKE_LABEL_SHOW, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "animation");
        OInputView r13 = this.f13345b;
        boolean r14 = r13.getVInput().hasFocus();
        TextView r15 = this.f13346c;
        if (r14 == false) goto L12;
        r13.w(OInputView.LabelUIState.REAL_LABEL_SHOW, r15, "LabelHideAnim, onAnimationCancel");
        return;
    L12:
        r13.w(OInputView.LabelUIState.FAKE_LABEL_SHOW, r15, "LabelHideAnim, onAnimationCancel");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f13344a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "animation");
        OInputView r10 = this.f13345b;
        boolean r11 = r10.getVInput().hasFocus();
        TextView r12 = this.f13346c;
        if (r11 == false) goto L7;
        r10.w(OInputView.LabelUIState.REAL_LABEL_SHOW, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L7:
        r10.w(OInputView.LabelUIState.FAKE_LABEL_SHOW, r12, "LabelShowAnim, onAnimationCancel");
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "animation");
        OInputView r13 = this.f13345b;
        boolean r14 = r13.getVInput().hasFocus();
        TextView r15 = this.f13346c;
        if (r14 == false) goto L12;
        r13.w(OInputView.LabelUIState.REAL_LABEL_SHOW, r15, "LabelHideAnim, onAnimationCancel");
        return;
    L12:
        r13.w(OInputView.LabelUIState.FAKE_LABEL_SHOW, r15, "LabelHideAnim, onAnimationCancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5, boolean r10) {
        TextView r11 = this.f13346c;
        OInputView r12 = this.f13345b;
        int r13 = this.f13344a;
        Intrinsics.checkNotNullParameter(r5, "animation");
        switch(r13) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OInputView.LabelUIState r14 = OInputView.LabelUIState.FAKE_LABEL_SHOW;
        int r15 = OInputView.f13274f0;
        r12.w(r14, r11, "LabelShowAnim, onAnimationStart");
        return;
    L6:
        OInputView.LabelUIState r16 = OInputView.LabelUIState.FAKE_LABEL_SHOW;
        int r17 = OInputView.f13274f0;
        r12.w(r16, r11, "LabelHideAnim, onAnimationStart");
    }
}
