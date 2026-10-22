package com.larus.voice_setting.voice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class SingleTtsSpeakerSettingFragment$perfTracer$2$1 extends FunctionReferenceImpl implements Function1<String, x2a.a> {
    public static final SingleTtsSpeakerSettingFragment$perfTracer$2$1 INSTANCE = null;

    static {
        INSTANCE = new SingleTtsSpeakerSettingFragment$perfTracer$2$1();
    }

    public SingleTtsSpeakerSettingFragment$perfTracer$2$1() {
        super(1, x2a.c.class, "voiceSettingFpsTraceDelegate", "voiceSettingFpsTraceDelegate(Ljava/lang/String;)Lcom/larus/voice_setting/voice/perf/FpsTraceDelegate;", 1);
    }

    public final x2a.a invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        Intrinsics.checkNotNullParameter(r4, "sceneName");
        return new x2a.b(new et3.c(r4, false, null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
