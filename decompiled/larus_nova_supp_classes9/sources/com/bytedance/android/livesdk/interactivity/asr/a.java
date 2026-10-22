package com.bytedance.android.livesdk.interactivity.asr;

import com.bytedance.speech.speechengine.SpeechEngineLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[SpeechEngineLoader.State.values().length];
        a = r0;
        r0[SpeechEngineLoader.State.UNKNOWN.ordinal()] = 1;
        r0[SpeechEngineLoader.State.PLUGIN_NOT_EXIST.ordinal()] = 2;
        r0[SpeechEngineLoader.State.PLUGIN_LOADED.ordinal()] = 3;
    }
}
