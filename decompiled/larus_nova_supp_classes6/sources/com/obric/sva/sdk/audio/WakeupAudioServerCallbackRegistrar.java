package com.obric.sva.sdk.audio;

import android.media.AudioManager;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.framework.wrapper.AudioManagerWrapper$AudioServerStateCallbackWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class WakeupAudioServerCallbackRegistrar {
    private WakeupAudioServerCallbackRegistrar() {
    }

    public static void clear(AudioManager r1) {
        ISvaFrameworkKt.getSvaFrameworkDelegate().clearAudioServerStateCallback(r1);
    }

    public static void register(AudioManager r1, Executor r2, AudioManagerWrapper$AudioServerStateCallbackWrapper r3) {
        ISvaFrameworkKt.getSvaFrameworkDelegate().setAudioServerStateCallback(r1, r2, r3);
    }
}
