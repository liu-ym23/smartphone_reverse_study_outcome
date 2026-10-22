package com.larus.bmhome.chat.list.cell.record;

import com.larus.audio.AudioServiceDelegate;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordCardCell$a implements com.larus.platform.api.b {
    public RecordCardCell$a() {
    }

    public final void a(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void b(com.larus.platform.api.c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        AudioServiceDelegate r5 = AudioServiceDelegate.a;
        if (r5.P().isRecording() == false) goto L6;
        FLogger.a.i("RecordCardBox", "user logout, stop recording");
        r5.P().a("user logout");
        return;
    }
}
