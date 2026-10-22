package com.bytedance.android.livesdk.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.feed.feed.e;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveFeedFloatTabView extends LiveTabIndicator {
    public boolean h;
    public Animator i;
    public Animator j;
    public boolean k;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ LiveFeedFloatTabView a;

        public a(LiveFeedFloatTabView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.a.k = true;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ LiveFeedFloatTabView a;

        public b(LiveFeedFloatTabView r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            this.a.k = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.h = false;
        Animator r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        Animator r1 = this.j;
        if (r1 != null) goto L10;
    L12:
        super.onDetachedFromWindow();
        return;
    L10:
        if (r1.isRunning() == false) goto L12;
        this.j.cancel();
        goto L12
    L5:
        if (r0.isRunning() == false) goto L7;
        this.i.cancel();
        goto L7
    }

    public final void d() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.k == false) goto L15;
        Animator r0 = this.i;
        if (r0 != null) goto L10;
    L12:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, "translationY", new float[]{getTranslationY(), -getHeight()});
        this.j = r1;
        r1.addListener(new b(this));
        this.j.start();
        return;
    L10:
        if (r0.isRunning() == false) goto L12;
        this.i.cancel();
        goto L12
    }

    public final void e() {
        if (this.h == true) goto L5;
        return;
    L5:
        Animator r0 = this.i;
        if (r0 != null) goto L8;
    L10:
        setTranslationY(-getHeight());
        this.k = false;
        return;
    L8:
        if (r0.isRunning() == false) goto L10;
        this.i.cancel();
        goto L10
    }

    public final void f() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L15;
        Animator r0 = this.j;
        if (r0 != null) goto L10;
    L12:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, "translationY", new float[]{getTranslationY(), 0.0f});
        this.i = r1;
        r1.addListener(new a(this));
        this.i.start();
        return;
    L10:
        if (r0.isRunning() == false) goto L12;
        this.j.cancel();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = true;
    }

    public LiveFeedFloatTabView(Context r2) {
        this(r2, null);
    }

    public void setTabList(List<e> r1) {
        setTitles(r1);
    }

    public LiveFeedFloatTabView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LiveFeedFloatTabView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
