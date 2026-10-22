package com.larus.voicecall.impl.autostop;

import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class UplinkAudioPlugin$setRecordStartTrace$1$1 extends FunctionReferenceImpl implements Function2<String, Long, Unit> {
    public UplinkAudioPlugin$setRecordStartTrace$1$1(Object r8) {
        super(2, r8, ObricBackTraceLogDelegate.class, "reportBackTraceRecorderConfig", "reportBackTraceRecorderConfig(Ljava/lang/String;J)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke((String) r3, ((Number) r4).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ObricBackTraceLogDelegate) ((CallableReference) this).receiver).a(r2, r3);
    }
}
