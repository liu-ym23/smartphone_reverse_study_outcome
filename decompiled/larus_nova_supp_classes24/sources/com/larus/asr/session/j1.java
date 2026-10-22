package com.larus.asr.session;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j1 implements z2a.a {
    public final h1 a;
    public final /* synthetic */ i1 b;

    public final void c() {
        AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
        FLogger.a.i("QuicInterpretAsrSession", "simultaneousTranslator onAudioDataPlayComplete");
        xa8.d r0 = this.b.c();
        if (r0 == null) goto L6;
        r0.gq(this.b.b());
        return;
    }

    public j1(i1 r2) {
        this.b = r2;
        r2.getClass();
        this.a = new h1(r2);
    }

    public final void a(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("simultaneousTranslator onSendAudioData ");
        r1.append(r4.length);
        r1.append(" , isSpeaking = ");
        xa8.d r2 = this.b.c();
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.K70());
    L6:
        r1.append(r3);
        r0.i("QuicInterpretAsrSession", r1.toString());
        this.a.invoke(r4);
        xa8.d r5 = this.b.c();
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
        i1.a(this.b, r2, r3);
    }
}
