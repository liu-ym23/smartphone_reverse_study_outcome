package com.larus.voicecall.impl.continue_talk;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class x0 implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ x0(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatContinuousTalkComponentViewModel.Yo(this.a);
    }
}
