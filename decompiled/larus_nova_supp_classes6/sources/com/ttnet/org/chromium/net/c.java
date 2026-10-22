package com.ttnet.org.chromium.net;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ProxyChangeListener.ProxyReceiver a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ c(ProxyChangeListener.ProxyReceiver r1, Intent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProxyChangeListener.ProxyReceiver.a(this.a, this.b);
    }
}
