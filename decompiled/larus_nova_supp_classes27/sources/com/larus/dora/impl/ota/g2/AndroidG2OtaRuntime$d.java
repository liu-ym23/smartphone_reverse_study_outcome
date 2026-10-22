package com.larus.dora.impl.ota.g2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AndroidG2OtaRuntime$d implements p4$a {
    final /* synthetic */ q.m $effect;
    final /* synthetic */ Function1<s, Unit> $emit;
    final /* synthetic */ AndroidG2OtaRuntime $this_runCatching;

    @Override // com.larus.dora.impl.ota.g2.p4$a
    public final FailureReason a() {
        return (FailureReason) AndroidG2OtaRuntime.h(this.$this_runCatching).invoke(this.$effect.a(), this.$effect.c(), Long.valueOf(this.$effect.b()));
    }

    @Override // com.larus.dora.impl.ota.g2.p4$a
    public final void c(int r11) {
        this.$emit.invoke(new s$l0(this.$effect.a(), this.$effect.c(), this.$effect.b(), r11, ((Number) AndroidG2OtaRuntime.d(this.$this_runCatching).invoke()).longValue()));
    }

    @Override // com.larus.dora.impl.ota.g2.p4$a
    public final void b(boolean r12, FailureReason r13) {
        Intrinsics.checkNotNullParameter(r13, "reason");
        this.$emit.invoke(new s.k0(this.$effect.a(), this.$effect.c(), this.$effect.b(), r12, r13, ((Number) AndroidG2OtaRuntime.d(this.$this_runCatching).invoke()).longValue()));
    }

    public AndroidG2OtaRuntime$d(AndroidG2OtaRuntime r1, q.m r2, Function1<? super s, Unit> r3) {
        this.$this_runCatching = r1;
        this.$effect = r2;
        this.$emit = r3;
    }
}
