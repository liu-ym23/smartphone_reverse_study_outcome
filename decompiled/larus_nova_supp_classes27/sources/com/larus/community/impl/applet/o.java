package com.larus.community.impl.applet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ CountDownLatch e;

    public /* synthetic */ o(AtomicBoolean r1, String r2, Function0 r3, Function0 r4, CountDownLatch r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean r0 = this.a;
        String r1 = this.b;
        Function0 r2 = this.c;
        Function0 r3 = this.d;
        CountDownLatch r4 = this.e;
        AICreationAppletNavigator.a.getClass();
        r0.set(AICreationAppletNavigator.d(r1, r2, r3));
        r4.countDown();
    }
}
