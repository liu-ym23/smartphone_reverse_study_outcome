package com.bytedance.android.live.liveinteract.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import fd0.a;
import fd0.b;
import fd0.f;
import fd0.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveAnimator {
    public final List<f> a;
    public long b;
    public long c;
    public Interpolator d;
    public int e;
    public int f;
    public AnimatorSet g;
    public a h;
    public b i;
    public LiveAnimator j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public final void b() {
        AnimatorSet r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final void c() {
        LiveAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.c();
        return;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) this.a).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.addAll(((f) r2.next()).c);
        goto L7
    L9:
        Iterator r3 = ((ArrayList) this.a).iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((f) r3.next()).getClass();
        goto L11
    L13:
        Iterator r4 = r1.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        Animator r5 = (Animator) r4.next();
        if ((r5 instanceof ValueAnimator) == false) goto L15;
        ValueAnimator r6 = (ValueAnimator) r5;
        r6.setRepeatCount(this.e);
        r6.setRepeatMode(this.f);
        goto L15
    L19:
        AnimatorSet r7 = new AnimatorSet();
        r7.playTogether(r1);
        r7.setDuration(this.b);
        r7.setStartDelay(this.c);
        Interpolator r8 = this.d;
        if (r8 == null) goto L22;
        r7.setInterpolator(r8);
    L22:
        r7.addListener(new g(this));
        this.g = r7;
        r7.start();
    }

    public LiveAnimator() {
        this.a = new ArrayList();
        this.b = 3000;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = 1;
        this.j = null;
    }

    public static f a(View... r2) {
        LiveAnimator r0 = new LiveAnimator();
        f r1 = new f(r0, r2);
        ((ArrayList) r0.a).add(r1);
        return r1;
    }
}
