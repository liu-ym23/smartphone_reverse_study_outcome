package com.obric.assistant.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View.OnLayoutChangeListener b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View.OnLayoutChangeListener d;
    public final /* synthetic */ ObricChatListComponent.b e;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.removeOnLayoutChangeListener(this.b);
        View r3 = this.c;
        if (r3 == null) goto L5;
        r3.removeOnLayoutChangeListener(this.d);
    L5:
        this.a.getOverlay().remove(this.e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.removeOnLayoutChangeListener(this.b);
        View r3 = this.c;
        if (r3 == null) goto L5;
        r3.removeOnLayoutChangeListener(this.d);
    L5:
        this.a.getOverlay().remove(this.e);
    }

    public l(com.larus.bmhome.chat.layout.item.i r1, j r2, View r3, k r4, ObricChatListComponent.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
