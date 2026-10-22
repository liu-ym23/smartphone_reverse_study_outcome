package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class r extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4896a;

    public final void b(int r8, boolean r10) {
        super.setVisibility(r8);
        if (r10 == false) goto L6;
        this.f4896a = r8;
        return;
    }

    public final int getUserSetVisibility() {
        return this.f4896a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r8) {
        b(r8, true);
    }
}
