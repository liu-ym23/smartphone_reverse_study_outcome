package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrSessionComponentUtils;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z0 extends LiveTutorAsrOnlySessionV2 {
    public final maa.e k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySessionV2, com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final boolean m0() {
        return this.f.f.get();
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySessionV2
    public final boolean l(com.larus.asr.session.component.f0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (kga.b.a().c() == true) goto L19;
        ObricAsrDelegate r0 = ObricAsrDelegate.b;
        if (r0.isAiKeyPressing() == false) goto L7;
        return true;
    L7:
        if (r0.b() == false) goto L9;
        return true;
    L9:
        if (this.c != VoiceInputType.TouchSpeaker) goto L23;
        com.larus.audio.asr.c0 r1 = r5.b().d;
        FLogger.a.i("OLiveTutorAsrOnlySession2", "pocket mode detected, block it!");
        kga.b.a().g();
        r5.d();
        int r2 = AsrSessionComponentUtils.a;
        p r3 = this.a;
        Message r6 = r5.d;
        if (r6 == null) goto L14;
        String r7 = r6.getLocalMessageId();
    L15:
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        AsrSessionComponentUtils.b(r3, r7, this.c, "pocket_mode, traceId(" + r1.a + "), enterFrom(" + r1.b + ')', 8);
        this.a.vb();
        return false;
    L14:
        r7 = null;
        goto L15
    L23:
        return true;
    L19:
        return true;
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySessionV2
    public final boolean m(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r2.b().c;
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySessionV2
    public final void n(com.larus.asr.session.component.f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FLogger.a.i("OLiveTutorAsrOnlySession2", "checkSpeakPermission voiceInputType: " + this.c);
        maa.e r4 = this.k;
        if (r4 == null) goto L6;
        r4.v50("pressing bottom button");
        return;
    }

    public z0(p r2, String r3, VoiceInputType r4, c r5, maa.e r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        Intrinsics.checkNotNullParameter(r5, "isCurrentSession");
        super(r2, r3, r4, r5);
        this.k = r6;
    }
}
