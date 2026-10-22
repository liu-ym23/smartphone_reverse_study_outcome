package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n3 extends AnimatorListenerAdapter {
    public final /* synthetic */ l3 a;
    public final /* synthetic */ Map<View, Drawable> b;
    public final /* synthetic */ List<Pair<View, Rect>> c;
    public final /* synthetic */ List<Pair<View, Integer>> d;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (Intrinsics.areEqual(this.a.g, r3) == false) goto L5;
        this.a.g = null;
    L5:
        Iterator<Map.Entry<View, Drawable>> r4 = this.b.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<View, Drawable> r0 = r4.next();
        View r1 = r0.getKey();
        Drawable r2 = r0.getValue();
        r1.getOverlay().remove(r2);
        goto L7
    L9:
        Iterator<T> r5 = this.c.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Pair r6 = (Pair) r5.next();
        ((View) r6.component1()).setClipBounds((Rect) r6.component2());
        goto L11
    L13:
        Iterator<T> r7 = this.d.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        ((View) ((Pair) r7.next()).component1()).setAlpha(1.0f);
        goto L15
    L17:
        l3 r8 = this.a;
        r8.f(r8.i);
        int r9 = this.a.o;
    }

    public n3(l3 r1, Map<View, Drawable> r2, List<Pair<View, Rect>> r3, List<Pair<View, Integer>> r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
