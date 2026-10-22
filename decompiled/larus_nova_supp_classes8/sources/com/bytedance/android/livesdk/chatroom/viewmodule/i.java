package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class i<T extends Widget> implements x0 {
    public final Lazy a;
    public T b;
    public final View c;
    public WidgetManager d;
    public boolean e;
    public boolean f;
    public final ValueAnimator g;
    public final ValueAnimator h;
    public final ObjectAnimator i;
    public final ViewGroup j;
    public final int k;
    public final b l;

    public static final class a {
    }

    public interface b {
        void He(i<? extends Widget> r1);

        void Oa(i r1);
    }

    static {
    }

    public final View c() {
        return (View) this.a.getValue();
    }

    public final void a() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.g.cancel();
        this.i.cancel();
        ((j) this).p.reverseTransition((int) 300);
        j.q = true;
        ValueAnimator r1 = this.g;
        Intrinsics.checkNotNullParameter(r1, "animator");
        int[] r2 = new int[2];
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        if (r3 == null) goto L10;
        r2[0] = ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
        r2[1] = -this.c.getHeight();
        r1.setIntValues(r2);
        this.g.start();
        this.i.reverse();
        this.f = true;
        this.l.Oa(this);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.g.cancel();
        this.i.cancel();
        ((j) this).p.startTransition((int) 300);
        j.q = false;
        ValueAnimator r1 = this.h;
        Intrinsics.checkNotNullParameter(r1, "animator");
        int[] r2 = new int[2];
        ViewGroup.LayoutParams r3 = this.c.getLayoutParams();
        if (r3 == null) goto L10;
        r2[0] = ((ViewGroup.MarginLayoutParams) r3).bottomMargin;
        r2[1] = 0;
        r1.setIntValues(r2);
        this.h.start();
        this.i.start();
        this.f = false;
        this.l.Oa(this);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x0
    public final void hide() {
        if (this.e == true) goto L5;
        return;
    L5:
        TransitionManager.beginDelayedTransition(this.j, new AutoTransition());
        this.j.setVisibility(8);
        this.e = false;
        this.l.He(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x0
    public final void show() {
        if (this.e == false) goto L5;
        return;
    L5:
        TransitionManager.beginDelayedTransition(this.j, new AutoTransition());
        this.j.setVisibility(0);
        this.e = true;
        this.l.He(this);
    }

    public i(ViewGroup r9, b r10) {
        Intrinsics.checkNotNullParameter(r9, "parentView");
        Intrinsics.checkNotNullParameter(r10, "stateChangeListener");
        this.j = r9;
        this.k = 2131384186;
        this.l = r10;
        this.a = InfraKotlinExtsKt.mainThreadLazy(new BannerHolder$holderView$2(this));
        View r11 = c().findViewById(2131384186);
        this.c = r11;
        ValueAnimator r12 = new ValueAnimator();
        j r1 = (j) this;
        r12.addUpdateListener(new e(r1));
        r12.addListener(new f(r1));
        r12.setDuration(300);
        r12.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        Unit r7 = Unit.INSTANCE;
        this.g = r12;
        ValueAnimator r13 = new ValueAnimator();
        r13.addUpdateListener(new g(r1));
        r13.addListener(new h(r1));
        r13.setDuration(300);
        r13.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.h = r13;
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r11, "alpha", new float[]{0.0f, 1.0f});
        r14.setDuration(300);
        r14.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.i = r14;
    }
}
