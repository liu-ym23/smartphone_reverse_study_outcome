package com.obric.assistant.dora.record_minutes;

import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.callback.SpeechRecorderAudioConsumerCallback;
import com.mammon.speechaudiosdk.session.param.SpeechRecorderAudioConsumerCallbackParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements SpeechRecorderAudioConsumerCallback {
    public final /* synthetic */ DoraRecordMinutesService.d a;

    public f(DoraRecordMinutesService.d r1) {
        this.a = r1;
    }

    public final void onCallback(SpeechRecorderAudioConsumerCallbackParam r8) {
        Integer r0 = null;
        if (r8 == null) goto L5;
        Integer r1 = Integer.valueOf(r8.msgType);
    L6:
        boolean r3 = true;
        if (r1 != null) goto L10;
    L12:
        if (r1 != null) goto L15;
    L17:
        if (r1 != null) goto L20;
    L35:
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("pcm capture consumer unknown msg, wakeId=");
        r4.append(this.a.a);
        r4.append(", msgType=");
        if (r8 == null) goto L38;
        r0 = Integer.valueOf(r8.msgType);
    L38:
        r4.append(r0);
        r2.w("DoraRecordMinutesService", r4.toString());
        return;
    L20:
        if (r1.intValue() != 5000) goto L35;
        DoraRecordMinutesService.d r5 = this.a;
        byte[] r9 = r8.audioData;
        r5.getClass();
        if (r9 != null) goto L25;
        return;
    L25:
        if (r9.length == 0) goto L28;
        r3 = false;
    L28:
        if (r3 == false) goto L30;
        return;
    L30:
        if (r5.f.get() == true) goto L32;
        return;
    L32:
        if (r5.g.get() == true) goto L46;
        r5.c.a(r9, r5.b);
        return;
    L46:
        return;
    L15:
        if (r1.intValue() != 2) goto L17;
        FLogger.a.i("DoraRecordMinutesService", "pcm capture consumer stop, wakeId=" + this.a.a + ", sessionId=" + r8.sessionId);
        this.a.c.onStopped();
        return;
    L10:
        if (r1.intValue() != 1) goto L12;
        FLogger.a.i("DoraRecordMinutesService", "pcm capture consumer start, wakeId=" + this.a.a + ", sessionId=" + r8.sessionId);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
