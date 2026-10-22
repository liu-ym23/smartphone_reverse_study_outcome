package com.obric.sva.framework.wrapper;

import android.media.AudioManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AudioManagerWrapper$AudioServerStateCallbackWrapper {
    public AudioManager.AudioServerStateCallback mAudioServerStateCallback;

    public void onAudioServerDownExt() {
    }

    public void onAudioServerUpExt() {
    }

    public AudioManagerWrapper$AudioServerStateCallbackWrapper() {
        this.mAudioServerStateCallback = new AnonymousClass1(this);
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return AudioManager.AudioServerStateCallback.class;
    }
}
