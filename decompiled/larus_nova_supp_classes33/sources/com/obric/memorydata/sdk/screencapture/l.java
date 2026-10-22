package com.obric.memorydata.sdk.screencapture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ d a;

    public /* synthetic */ l(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCaptureManager.d(this.a);
    }
}
