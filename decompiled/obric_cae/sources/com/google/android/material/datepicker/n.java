package com.google.android.material.datepicker;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f4712a;

    public n(i r8) {
        this.f4712a = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        i r10 = this.f4712a;
        i.e r11 = r10.f4689q;
        i.e r12 = i.e.f4701b;
        if (r11 != r12) goto L6;
        r10.d(i.e.f4700a);
        return;
    L6:
        if (r11 != i.e.f4700a) goto L10;
        r10.d(r12);
        return;
    }
}
