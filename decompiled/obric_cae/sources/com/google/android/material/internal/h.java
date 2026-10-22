package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b> f4863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f4864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f4865c;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f4866a;

        public a(h r8) {
            this.f4866a = r8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            h r10 = this.f4866a;
            if (r10.f4864b != r8) goto L6;
            r10.f4864b = null;
            return;
        }
    }

    public static class b {
        public b(int[] r8, ValueAnimator r10) {
        }
    }

    public h() {
        this.f4863a = new ArrayList();
        this.f4864b = null;
        this.f4865c = new a(this);
    }

    public final void a(int[] r8, ValueAnimator r10) {
        b r11 = new b(r8, r10);
        r10.addListener(this.f4865c);
        this.f4863a.add(r11);
    }
}
