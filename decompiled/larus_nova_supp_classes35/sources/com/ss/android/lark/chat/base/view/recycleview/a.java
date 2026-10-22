package com.ss.android.lark.chat.base.view.recycleview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;
import g2b.g;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zdc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T extends c> implements g2b.a, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public T a;
    public RecyclerView.ViewHolder b;
    public View c;
    public int d;
    public Object e;
    public Drawable f;
    public g g;
    public Animator h;
    public final int i;
    public final RecyclerView j;
    public final g2b.c k;
    public final b.InterfaceC0030b l;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // g2b.a
    public final void a() {
        if (this.c != null) goto L5;
        return;
    L5:
        if (this.h != null) goto L10;
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{255.0f, 0.0f});
        r0.addUpdateListener(this);
        r0.addListener(this);
        r0.setDuration(1000);
        r0.setInterpolator(new g2b.b());
        r0.start();
        this.h = r0;
        return;
    }

    @Override // g2b.a
    public final void b() {
        RecyclerView r0 = this.j;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        RecyclerView.Adapter r1 = r0.getAdapter();
        if ((r1 instanceof ConcatAdapter) == false) goto L6;
        r1 = (RecyclerView.Adapter) CollectionsKt.getOrNull(((ConcatAdapter) r1).getAdapters(), 0);
    L6:
        T r2 = (T) r1;
        this.a = r2;
        if (r2 == null) goto L25;
        int r3 = this.k.b();
        this.d = r3;
        if (r3 < 0) goto L25;
        if (r3 >= this.a.getItemCount()) goto L25;
        Object r4 = this.a.getItem(this.d);
        this.e = r4;
        if (r4 == null) goto L25;
        RecyclerView.ViewHolder r5 = this.j.findViewHolderForAdapterPosition(this.d);
        this.b = r5;
        if (r5 == null) goto L25;
        View r6 = this.k.a(r5.itemView);
        this.c = r6;
        if (r6 != null) goto L23;
        this.c = this.b.itemView;
    L23:
        this.f = this.c.getBackground();
        this.g = new g(this.i, this.f);
    L25:
        if (this.c != null) goto L27;
        return;
    L27:
        Animator r7 = this.h;
        if (r7 == null) goto L30;
        r7.cancel();
        this.h = null;
    L30:
        this.c.setBackground(this.g);
    }

    @Override // g2b.a
    public final void cancel() {
        if (this.c == null) goto L9;
        Animator r0 = this.h;
        if (r0 == null) goto L7;
        r0.cancel();
        this.h = null;
    L7:
        Log.d("ItemConstantShineAnimator", "cancel called");
        this.c.setBackground(this.g.a);
        ItemShineManager.b(this.c);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        if (this.c == null) goto L5;
        Log.d("ItemConstantShineAnimator", "onAnimationEnd called");
        this.c.setBackground(this.g.a);
        ItemShineManager.b(this.c);
    L5:
        this.h = null;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        int r0 = this.b.getAdapterPosition();
        if (this.d == r0) goto L10;
        if (r0 < 0) goto L10;
        if (r0 >= this.a.getItemCount()) goto L10;
        Object r1 = this.a.getItem(r0);
        if (this.l.a(this.e, r1) == true) goto L10;
        Log.d("ItemConstantShineAnimator", "checkToCancelAnimIfNeed: cancel animation");
        r4.cancel();
    L10:
        float r5 = ((Float) r4.getAnimatedValue()).floatValue();
        this.g.setAlpha((int) r5);
        this.c.invalidate();
    }

    public a(RecyclerView r2, g2b.c r3, b.InterfaceC0030b r4) {
        this.d = 0;
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.i = j08.b.c(r2.getContext(), 2131108860, 1.0f);
    }
}
