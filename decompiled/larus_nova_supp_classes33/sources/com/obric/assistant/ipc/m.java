package com.obric.assistant.ipc;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ SvaSdkContentProvider a;

    public /* synthetic */ m(SvaSdkContentProvider r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SvaSdkContentProvider r0 = this.a;
        AtomicBoolean r1 = SvaSdkContentProvider.a;
        r0.b(1);
    }
}
