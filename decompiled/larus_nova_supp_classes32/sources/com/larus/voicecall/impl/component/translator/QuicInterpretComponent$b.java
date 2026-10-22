package com.larus.voicecall.impl.component.translator;

import com.larus.audio.call.tracer.b;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class QuicInterpretComponent$b extends b {
    public final String a;
    public final String b;

    public final void a(String r1, String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "spanName");
    }

    public final void c() {
    }

    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spanName");
        Intrinsics.checkNotNullParameter(r3, "parentSpanName");
    }

    public QuicInterpretComponent$b() {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }
}
