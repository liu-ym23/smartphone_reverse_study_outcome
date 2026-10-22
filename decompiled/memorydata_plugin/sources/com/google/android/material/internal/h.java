package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ValueAnimator f3972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<a> f3973b;
    private a c;
    private final Animator.AnimatorListener d;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f3975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f3976b;

        a(int[] r1, ValueAnimator r2) {
            this.f3975a = r1;
            this.f3976b = r2;
        }
    }

    public h() {
        this.f3973b = new ArrayList();
        this.c = null;
        this.f3972a = null;
        this.d = new AnonymousClass1(this);
    }

    private void a(a r1) {
        ValueAnimator r2 = r1.f3976b;
        this.f3972a = r2;
        r2.start();
    }

    private void b() {
        ValueAnimator r0 = this.f3972a;
        if (r0 == null) goto L6;
        r0.cancel();
        this.f3972a = null;
        return;
    }

    public void a() {
        ValueAnimator r0 = this.f3972a;
        if (r0 == null) goto L6;
        r0.end();
        this.f3972a = null;
        return;
    }

    public void a(int[] r6) {
        int r0 = this.f3973b.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f3973b.get(r1), a.class, "com.obric.memorydata.plugin");
        if (StateSet.stateSetMatches(r2.f3975a, r6) == true) goto L9;
        r1 = r1 + 1;
    L9:
        a r7 = this.c;
        if (r2 != r7) goto L12;
        return;
    L12:
        if (r7 == null) goto L14;
        b();
    L14:
        this.c = r2;
        if (r2 == null) goto L20;
        a(r2);
        return;
    L20:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public void a(int[] r2, ValueAnimator r3) {
        a r0 = new a(r2, r3);
        r3.addListener(this.d);
        this.f3973b.add(r0);
    }
}
