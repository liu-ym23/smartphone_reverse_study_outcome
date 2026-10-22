package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Animator f3255a;

    a() {
    }

    public void a() {
        Animator r10 = this.f3255a;
        if (r10 == null) goto L6;
        r10.cancel();
        return;
    }

    public void b() {
        this.f3255a = null;
    }

    public void c(Animator r10) {
        a();
        this.f3255a = r10;
    }
}
