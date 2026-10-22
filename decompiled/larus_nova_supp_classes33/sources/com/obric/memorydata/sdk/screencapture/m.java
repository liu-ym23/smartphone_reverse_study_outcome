package com.obric.memorydata.sdk.screencapture;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;

    public /* synthetic */ m(List r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCaptureManager.f(this.a, this.b);
    }
}
