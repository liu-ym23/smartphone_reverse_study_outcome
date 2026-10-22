package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.ss.android.lark.log.Log;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n extends KeyboardMenu implements h {
    public final FrameLayout p;
    public View q;

    public static final class a {
    }

    static {
    }

    public n(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        View r3 = this.f;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.p = (FrameLayout) r3;
    }

    public final void K(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.p.indexOfChild(r3) == (-1)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.p.addView(r3);
        r3.setVisibility(8);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void L(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.q == null) goto L6;
        Log.i("OverlayKeyboardMenu", "showOverlay: keyboardMenu has overlay displayed, method return");
        return;
    L6:
        Pair r0 = TuplesKt.to(this.g, r4);
        View r1 = (View) r0.getSecond();
        ((View) r0.getFirst()).setVisibility(8);
        r1.setVisibility(0);
        r1.bringToFront();
        this.q = r4;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.h
    public final void a(Transition r3) {
        View r0 = this.q;
        if (r0 != null) goto L6;
        Log.i("OverlayKeyboardMenu", "hideOverlay: current overlay is null, method return");
        return;
    L6:
        if (r3 == null) goto L8;
        TransitionManager.beginDelayedTransition(this.p, r3);
    L8:
        Pair r4 = TuplesKt.to(r0, this.g);
        View r1 = (View) r4.getSecond();
        ((View) r4.getFirst()).setVisibility(8);
        r1.setVisibility(0);
        r1.bringToFront();
        this.q = null;
    }
}
