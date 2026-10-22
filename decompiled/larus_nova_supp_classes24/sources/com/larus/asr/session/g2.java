package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class g2 implements Function4 {
    public final /* synthetic */ SamiCallAsrSession a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ VoiceInputType d;
    public final /* synthetic */ com.larus.audio.asr.c0 e;

    public /* synthetic */ g2(SamiCallAsrSession r1, Message r2, boolean r3, VoiceInputType r4, com.larus.audio.asr.c0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.asr.session.i2] */
    public final Object invoke(Object r17, Object r19, Object r110, Object r20) {
        final SamiCallAsrSession r2 = this.a;
        final Message r3 = this.b;
        final boolean r5 = this.c;
        final VoiceInputType r6 = this.d;
        final com.larus.audio.asr.c0 r4 = this.e;
        String r8 = (String) r17;
        String r9 = (String) r19;
        long r10 = ((Long) r110).longValue();
        String r12 = (String) r20;
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "taskId");
        Intrinsics.checkNotNullParameter(r12, "msgId");
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r6, "voiceInputType");
        Intrinsics.checkNotNullParameter(r4, "traceInfo");
        new i2(r2, r3, r4, r5, r6).invoke(new com.larus.audio.b(r8, r9, r10, r12, "", null, 64));
        return Unit.INSTANCE;
    }
}
