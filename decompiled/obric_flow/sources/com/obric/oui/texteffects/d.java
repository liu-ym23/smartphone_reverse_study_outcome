package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import js.n;
import js.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f14735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ODimPointEffectTextView f14736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f14737c;

    public d(Ref.BooleanRef r5, ODimPointEffectTextView r10, s r11) {
        this.f14735a = r5;
        this.f14736b = r10;
        this.f14737c = r11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        this.f14735a.element = true;
        this.f14736b.getLogTag();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        ODimPointEffectTextView r10 = this.f14736b;
        r10.getLogTag();
        if (this.f14735a.element == true) goto L27;
        s r11 = this.f14737c;
        n r12 = n.d;
        if (Intrinsics.areEqual(r11.d, r12) == true) goto L28;
        r10.getLogTag();
        CharSequence r13 = r10.f;
        if (r13 == null) goto L10;
        r10.setText(r13);
    L10:
        r10.f14716c = null;
        r10.f14721l = "none";
        r10.e = 0;
        r10.f = null;
        r10.g = null;
        r10.f14717h = null;
        r10.f14719j = null;
        r10.f14720k = null;
        r10.d = null;
        ODimPointEffectTextView.DimPointMode r14 = r10.f14698r;
        r10.f14698r = ODimPointEffectTextView.DimPointMode.NONE;
        r10.f14700u = ODimPointEffectTextView.RewritePhase.NONE;
        if (r14 != ODimPointEffectTextView.DimPointMode.PROMPT_EXIT_TO_GENERATE) goto L16;
        CharSequence r15 = r10.f14699t;
        r10.f14699t = null;
        r10.s = ODimPointEffectTextView.PendingTextType.CONTENT;
        if (r15 == null) goto L25;
        r10.t(r15);
    L25:
        r10.invalidate();
        return;
    L16:
        if (r14 != ODimPointEffectTextView.DimPointMode.PROMPT_SWITCH) goto L19;
        r10.s = ODimPointEffectTextView.PendingTextType.PROMPT;
        goto L25
    L19:
        if (r14 != ODimPointEffectTextView.DimPointMode.REWRITE) goto L25;
        CharSequence r16 = r10.f14701v;
        r10.f14701v = null;
        if (r16 == null) goto L25;
        if (TextUtils.equals(r10.getText(), r16) == true) goto L25;
        r10.v(r16);
        goto L25
    L28:
        return;
    }
}
