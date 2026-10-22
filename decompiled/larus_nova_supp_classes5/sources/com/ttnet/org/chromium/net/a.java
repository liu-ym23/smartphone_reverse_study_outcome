package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ NetworkChangeNotifierAutoDetect a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(NetworkChangeNotifierAutoDetect r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NetworkChangeNotifierAutoDetect.a(this.a, this.b);
    }
}
