package com.larus.audio.call.arch;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ LLMCallController a;
    public final /* synthetic */ long b;

    public /* synthetic */ i(LLMCallController r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return Boolean.valueOf(this.a.E(this.b));
    }
}
