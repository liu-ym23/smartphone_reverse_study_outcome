package com.larus.asr.session;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s1 implements z2a.a {
    public final /* synthetic */ QuicInterpretAsrSessionV2 a;
    public final /* synthetic */ p b;
    public final /* synthetic */ String c;

    public final void c() {
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
        FLogger.a.i("QuicInterpretAsrSessionV2", "simultaneousTranslator onAudioDataPlayComplete");
        xa8.d r0 = this.a.n();
        if (r0 == null) goto L6;
        r0.gq(this.a.m());
        return;
    }

    public final void a(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("simultaneousTranslator onSendAudioData ");
        r1.append(r4.length);
        r1.append(", isSpeaking=");
        xa8.d r2 = this.a.n();
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.K70());
    L6:
        r1.append(r3);
        r0.i("QuicInterpretAsrSessionV2", r1.toString());
        this.b.Ma(this.c, r4);
        xa8.d r5 = this.a.n();
        if (r5 == null) goto L10;
        r5.rV();
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void b(byte[] r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        QuicInterpretAsrSessionV2.l(this.a, r2, r3);
    }

    public s1(QuicInterpretAsrSessionV2 r1, p r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
