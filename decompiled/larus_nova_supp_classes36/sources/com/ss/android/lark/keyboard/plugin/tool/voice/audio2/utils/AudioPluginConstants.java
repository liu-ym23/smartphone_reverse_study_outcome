package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioPluginConstants {
    public static final int a = 0;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        AudioPluginFeature r0 = AudioPluginFeature.RECORD;
        a = r0.getIndex();
        b = AudioPluginFeature.WITH_TEXT.getIndex();
        c = r0.getIndex();
        d = AudioPluginFeature.RECOGNIZE.getIndex();
        e = LazyKt.lazy(AudioPluginConstants$ASR_WAITING_TIPS_IN_MILLIS$2.INSTANCE);
        f = LazyKt.lazy(AudioPluginConstants$ASR_TIMEOUT_IN_MILLIS$2.INSTANCE);
    }

    public static long a() {
        return ((Number) f.getValue()).longValue();
    }
}
