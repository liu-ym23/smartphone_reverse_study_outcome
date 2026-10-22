package com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends com.bytedance.android.live.liveinteract.animation.b {
    public final /* synthetic */ VoiceCommonMultiLinkWindowManager a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Ref.ObjectRef d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.a.S.contains(Integer.valueOf(this.c)) == false) goto L5;
        this.a.S.remove(Integer.valueOf(this.c));
    L5:
        Iterator r4 = ((ArrayList) this.d.element).iterator();
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
        AnimatorSet r3 = (AnimatorSet) this.b.element;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }

    public c(VoiceCommonMultiLinkWindowManager r1, Ref.ObjectRef r2, int r3, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
