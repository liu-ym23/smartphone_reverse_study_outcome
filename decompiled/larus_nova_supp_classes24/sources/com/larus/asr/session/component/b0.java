package com.larus.asr.session.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b0 {
    public final f0 a;
    public final b b;
    public final n0 c;
    public final Function0<Unit> d;
    public final Function0<Boolean> e;

    public final f0 getContext() {
        return this.a;
    }

    public b0(f0 r2, com.larus.asr.session.l r3, com.larus.asr.session.m r4, Function0 r5, com.larus.asr.session.h r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callbacks");
        Intrinsics.checkNotNullParameter(r4, "engineExtensions");
        Intrinsics.checkNotNullParameter(r5, "beforeEngineStart");
        Intrinsics.checkNotNullParameter(r6, "isActive");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
