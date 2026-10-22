package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y0 extends LiveTutorAsrOnlySession {
    public final maa.e k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySession
    public final void a() {
        super.a();
        this.d = true;
    }

    public y0(p r2, String r3, VoiceInputType r4, maa.e r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        super(r2, r3, r4);
        this.k = r5;
    }

    @Override // com.larus.asr.session.LiveTutorAsrOnlySession
    public final void b(Message r10, String r11, boolean r12, com.larus.audio.asr.c0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "itemId");
        Intrinsics.checkNotNullParameter(r13, "traceInfo");
        if (kga.b.a().c() == true) goto L16;
        ObricAsrDelegate r15 = ObricAsrDelegate.b;
        if (r15.isAiKeyPressing() == true) goto L16;
        if (r15.b() == true) goto L16;
        if (this.c != VoiceInputType.TouchSpeaker) goto L16;
        FLogger.a.i("OLiveTutorAsrOnlySession2", "pocket mode detected, block it!");
        kga.b.a().g();
        String r16 = r10.getLocalMessageId();
        if (r16 != null) goto L13;
        String r3 = "";
    L14:
        LiveTutorAsrOnlySession.d(this, r3, false, r10, "pocket_mode, traceId(" + r13.a + "), enterFrom(" + r13.b + ')', this.c, 16);
        return;
    L13:
        r3 = r16;
    L16:
        String r17 = r10.getLocalMessageId();
        if (r17 != null) goto L19;
        String r4 = "";
    L20:
        c(r4, true, r10, "perm_pass2", r12, this.c);
        if (r14 == null) goto L23;
        r14.invoke();
    L23:
        FLogger.a.i("OLiveTutorAsrOnlySession2", "checkSpeakPermission voiceInputType: " + this.c);
        maa.e r19 = this.k;
        if (r19 == null) goto L26;
        r19.v50("pressing bottom button");
    L26:
        a();
        return;
    L19:
        r4 = r17;
        goto L20
    }
}
