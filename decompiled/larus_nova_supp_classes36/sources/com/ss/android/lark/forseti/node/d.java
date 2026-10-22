package com.ss.android.lark.forseti.node;

import android.os.Bundle;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forseti.node.piece.ForsetiNodePiece;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Animation.AnimationListener {
    public final /* synthetic */ ForsetiNode a;
    public final /* synthetic */ Function2<Fragment, Integer, Unit> b;
    public final /* synthetic */ ForsetiNodePiece c;
    public final /* synthetic */ int d;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r1) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r3) {
        this.a.d(this.c, this.d);
        Bundle r4 = this.c.g.getArguments();
        if (r4 == null) goto L5;
        r4.putBoolean("isRemoving", false);
    L5:
        ForsetiNode r5 = this.a;
        r5.o = false;
        ForsetiNode.a(r5);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r3) {
        this.a.o = true;
        Function2<Fragment, Integer, Unit> r4 = this.b;
        if (r4 == null) goto L6;
        r4.invoke(this.c.g, Integer.valueOf(this.d));
        return;
    }

    public d(ForsetiNode r1, Function2<? super Fragment, ? super Integer, Unit> r2, ForsetiNodePiece r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
