package com.larus.avlink;

import com.larus.audio.audiov3.audio.record.AudioRecordState;
import com.larus.avlink.plugins.k4;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x extends k4 {
    public final /* synthetic */ w a;

    public final void d(int r1) {
    }

    public x(w r1) {
        this.a = r1;
    }

    public final void j(byte[] r4, byte[] r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        w r0 = this.a;
        AudioRecordState r1 = r0.b;
        if (r1 != AudioRecordState.INITIALIZED) goto L7;
    L15:
        r0.d.write(r4);     // Catch: Exception -> L12
        this.a.d.flush();     // Catch: Exception -> L12
        if (r5 == null) goto L18;
        ((LinkedBlockingQueue) this.a.e).offer(r5);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        n1.c("DoraAudioRecorder", "onVoiceData called", e);
        return;
    L7:
        if (r1 == AudioRecordState.STARTED) goto L15;
    }
}
