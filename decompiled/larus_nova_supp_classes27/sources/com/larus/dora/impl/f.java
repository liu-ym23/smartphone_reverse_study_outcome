package com.larus.dora.impl;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ f(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.invoke();
    }
}
