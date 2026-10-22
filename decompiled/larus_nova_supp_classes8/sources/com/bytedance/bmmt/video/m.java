package com.bytedance.bmmt.video;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ CountDownLatch a;

    public /* synthetic */ m(CountDownLatch r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.countDown();
    }
}
