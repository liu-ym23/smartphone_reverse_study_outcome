package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p3 extends AnimatorListenerAdapter {
    public final /* synthetic */ Map<View, Drawable> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ l3 c;
    public final /* synthetic */ int d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        Map<View, Drawable> r0 = this.a;
        l3 r1 = this.c;
        Iterator<Map.Entry<View, Drawable>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Drawable r3 = r2.next().getValue();
        r1.a.getOverlay().remove(r3);
        goto L4
    L6:
        int r4 = this.b;
        l3 r6 = this.c;
        if (r4 == r6.o) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r6.h, r5) == false) goto L14;
        l3 r7 = this.c;
        r7.h = null;
        r7.f(Integer.valueOf(this.d));
        return;
    }

    public p3(Map<View, Drawable> r1, int r2, l3 r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
