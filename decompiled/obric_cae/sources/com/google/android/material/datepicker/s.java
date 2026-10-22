package com.google.android.material.datepicker;

import android.view.View;
import j0.m0;

/* JADX INFO: loaded from: classes.dex */
public final class s implements j0.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f4725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4726c;

    public s(int r8, View r10, int r11) {
        this.f4724a = r8;
        this.f4725b = r10;
        this.f4726c = r11;
    }

    @Override // j0.q
    public final m0 a(View r8, m0 r10) {
        int r11 = r10.a(7).f5b;
        View r12 = this.f4725b;
        int r13 = this.f4724a;
        if (r13 < 0) goto L5;
        int r14 = r13 + r11;
        r12.getLayoutParams().height = r14;
        r12.setLayoutParams(r12.getLayoutParams());
    L5:
        r12.setPadding(r12.getPaddingLeft(), this.f4726c + r11, r12.getPaddingRight(), r12.getPaddingBottom());
        return r10;
    }
}
