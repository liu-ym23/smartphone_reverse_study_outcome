package com.larus.av_call.service;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.plugins.t0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import t1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DefaultRealtimeCallService extends com.larus.audio.call.a implements c {
    public static final /* synthetic */ int s = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.a
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tosKey");
    }

    @Override // com.larus.audio.call.a
    public final void b() {
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void a(RealtimeCallParam r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        FLogger.a.i("RealtimeCallService", "interruptAsr");
        LLMCallController.w(null, Reflection.getOrCreateKotlinClass(t0.class));
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void d(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r2, "params");
        LLMCallController.S(null, r2);
        throw null;
    }

    @Override // com.larus.audio.call.a
    public final void e(RealtimeCallParam r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r2, "params");
        throw null;
    }
}
