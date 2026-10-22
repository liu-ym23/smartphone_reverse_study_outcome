package com.larus.bmhome.chat.component.bottom.core;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s5 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ s5(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        int r1 = CoreInputComponent.d3;
        r0.invoke();
    }
}
