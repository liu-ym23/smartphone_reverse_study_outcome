package com.airbnb.lottie;

import android.graphics.ColorFilter;

/* JADX INFO: loaded from: classes.dex */
public final class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.e f1332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ColorFilter f1333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v.c f1334c;
    public final /* synthetic */ w d;

    public s(w r5, o.e r10, ColorFilter r11, v.c r12) {
        this.d = r5;
        this.f1332a = r10;
        this.f1333b = r11;
        this.f1334c = r12;
    }

    @Override // com.airbnb.lottie.v
    public final void run() {
        v.c r5 = this.f1334c;
        o.e r10 = this.f1332a;
        this.d.a(r10, this.f1333b, r5);
    }
}
