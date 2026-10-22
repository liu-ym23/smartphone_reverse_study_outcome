package com.obric.assistant.ipc;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ SvaSdkContentProvider a;
    public final /* synthetic */ int b;

    public /* synthetic */ n(SvaSdkContentProvider r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SvaSdkContentProvider r0 = this.a;
        int r1 = this.b;
        AtomicBoolean r2 = SvaSdkContentProvider.a;
        r0.b(r1 + 1);
    }
}
