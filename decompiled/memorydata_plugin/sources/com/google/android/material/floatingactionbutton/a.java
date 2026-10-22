package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f3918a;

    a() {
    }

    public void a() {
        Animator r0 = this.f3918a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void a(Animator r1) {
        a();
        this.f3918a = r1;
    }

    public void b() {
        this.f3918a = null;
    }
}
