package com.larus.audio.ttsV2;

import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TtsClientManager$f implements n68.a {
    public static final TtsClientManager$f a = null;

    static {
        a = new TtsClientManager$f();
    }

    public TtsClientManager$f() {
    }

    public final void d(PlayStateEnum r1) {
    }

    public final void e(TtsErrorType r1) {
    }

    public final void c(PlayStateEnum r3) {
        if (r3 != PlayStateEnum.PLAY_STATE_STOPPED) goto L5;
    L6:
        FLogger r4 = FLogger.a;
        TtsClientManager r0 = TtsClientManager.a;
        r4.i("TtsClientManager", "addAudioPlayStateChangeCallback1: currentApplicant: " + TtsClientManager.m);
        Lazy r5 = MediaResourceManager.a;
        MediaResourceManager.a(TtsClientManager.m);
        ObricTtsControlDelegate.b.t();
        return;
    L5:
        if (r3 == PlayStateEnum.PLAY_STATE_FAIL) goto L6;
    }

    public final void a(boolean r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void b(boolean r1, String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }
}
