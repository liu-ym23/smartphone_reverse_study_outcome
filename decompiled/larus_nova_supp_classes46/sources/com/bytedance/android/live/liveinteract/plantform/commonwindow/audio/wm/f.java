package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm;

import android.animation.Animator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Ref.ObjectRef c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.S.contains(Integer.valueOf(this.b)) == false) goto L5;
        this.a.S.remove(Integer.valueOf(this.b));
    L5:
        Iterator r4 = ((ArrayList) this.c.element).iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        View r0 = (View) r4.next();
        if (r0 == null) goto L11;
        r0.setScaleY(1.0f);
    L11:
        if (r0 == null) goto L7;
        r0.setScaleX(1.0f);
        goto L7
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a.S.contains(Integer.valueOf(this.b)) == false) goto L6;
        this.a.S.remove(Integer.valueOf(this.b));
        return;
    }

    public f(VoiceCommonMultiLinkWindowManager r1, int r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
