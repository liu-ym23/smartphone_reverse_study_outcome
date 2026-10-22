package com.ss.android.lark.forseti.node;

import android.animation.Animator;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Animator.AnimatorListener {
    public final /* synthetic */ ForsetiNode a;
    public final /* synthetic */ Function2<Fragment, Integer, Unit> b;
    public final /* synthetic */ ForsetiNodePiece c;
    public final /* synthetic */ int d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.d(this.c, this.d);
        Bundle r4 = this.c.g.getArguments();
        if (r4 == null) goto L5;
        r4.putBoolean("isRemoving", false);
    L5:
        ForsetiNode r5 = this.a;
        r5.o = false;
        ForsetiNode.a(r5);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.o = true;
        Function2<Fragment, Integer, Unit> r4 = this.b;
        if (r4 == null) goto L6;
        r4.invoke(this.c.g, Integer.valueOf(this.d));
        return;
    }

    public e(ForsetiNode r1, Function2<? super Fragment, ? super Integer, Unit> r2, ForsetiNodePiece r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
