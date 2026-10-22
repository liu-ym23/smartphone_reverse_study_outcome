package com.obric.cae.location.geosdk.bytedance;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BdLocationManager f5666b;

    public /* synthetic */ d(BdLocationManager r8, int r10) {
        this.f5665a = r10;
        this.f5666b = r8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r8 = this.f5665a;
        BdLocationManager r10 = this.f5666b;
        switch(r8) {
            case 0: goto L5;
            default: goto L8;
        };
    L5:
        boolean r11 = BdLocationManager.j(r10);
    L7:
        return Boolean.valueOf(r11);
    L8:
        r11 = BdLocationManager.f(r10);
        goto L7
    }
}
