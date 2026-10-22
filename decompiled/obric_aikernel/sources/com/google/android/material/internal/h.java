package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f3435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private b f3436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    ValueAnimator f3437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f3438d;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f3439c;

        a(h r10) {
            this.f3439c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            h r11 = this.f3439c;
            if (r11.f3437c != r10) goto L6;
            r11.f3437c = null;
            return;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f3440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f3441b;

        b(int[] r10, ValueAnimator r11) {
            this.f3440a = r10;
            this.f3441b = r11;
        }
    }

    public h() {
        this.f3435a = new ArrayList();
        this.f3436b = null;
        this.f3437c = null;
        this.f3438d = new a(this);
    }

    private void b() {
        ValueAnimator r10 = this.f3437c;
        if (r10 == null) goto L6;
        r10.cancel();
        this.f3437c = null;
        return;
    }

    private void e(@NonNull b r10) {
        ValueAnimator r11 = r10.f3441b;
        this.f3437c = r11;
        r11.start();
    }

    public void a(int[] r10, ValueAnimator r11) {
        b r12 = new b(r10, r11);
        r11.addListener(this.f3438d);
        this.f3435a.add(r12);
    }

    public void c() {
        ValueAnimator r10 = this.f3437c;
        if (r10 == null) goto L6;
        r10.end();
        this.f3437c = null;
        return;
    }

    public void d(int[] r10) {
        int r11 = this.f3435a.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        b r13 = this.f3435a.get(r12);
        if (StateSet.stateSetMatches(r13.f3440a, r10) == true) goto L9;
        r12 = r12 + 1;
    L9:
        b r14 = this.f3436b;
        if (r13 != r14) goto L12;
        return;
    L12:
        if (r14 == null) goto L14;
        b();
    L14:
        this.f3436b = r13;
        if (r13 == null) goto L20;
        e(r13);
        return;
    L20:
        return;
    L8:
        r13 = null;
        goto L9
    }
}
