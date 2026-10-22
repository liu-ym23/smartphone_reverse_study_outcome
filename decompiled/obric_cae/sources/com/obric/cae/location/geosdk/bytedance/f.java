package com.obric.cae.location.geosdk.bytedance;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdLocationManager f5674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f5678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5679g;

    public /* synthetic */ f(BdLocationManager r8, String r10, int r11, int r12, String r13, String r14, int r15) {
        this.f5673a = r15;
        this.f5674b = r8;
        this.f5675c = r10;
        this.f5676d = r11;
        this.f5677e = r12;
        this.f5678f = r13;
        this.f5679g = r14;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f5673a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return BdLocationManager.b(this.f5674b, this.f5675c, this.f5676d, this.f5677e, this.f5678f, this.f5679g);
    L8:
        return BdLocationManager.h(this.f5674b, this.f5675c, this.f5676d, this.f5677e, this.f5678f, this.f5679g);
    }
}
