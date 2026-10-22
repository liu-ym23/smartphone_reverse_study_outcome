package com.larus.audio;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class t1 implements Runnable {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ t1(Function1 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1 r0 = this.a;
        u1 r1 = u1.a;
        u1.c(r0);
    }
}
