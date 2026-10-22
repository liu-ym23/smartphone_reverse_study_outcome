package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "RECORDING", "DISPLAY", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AudioPluginEnums$WaveformState extends Enum<AudioPluginEnums$WaveformState> {
    public static final AudioPluginEnums$WaveformState DISPLAY = null;
    public static final AudioPluginEnums$WaveformState INIT = null;
    public static final AudioPluginEnums$WaveformState RECORDING = null;
    public static final /* synthetic */ AudioPluginEnums$WaveformState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioPluginEnums$WaveformState> getEntries() {
        return b;
    }

    static {
        AudioPluginEnums$WaveformState r0 = new AudioPluginEnums$WaveformState("INIT", 0);
        INIT = r0;
        AudioPluginEnums$WaveformState r1 = new AudioPluginEnums$WaveformState("RECORDING", 1);
        RECORDING = r1;
        AudioPluginEnums$WaveformState r3 = new AudioPluginEnums$WaveformState("DISPLAY", 2);
        DISPLAY = r3;
        AudioPluginEnums$WaveformState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AudioPluginEnums$WaveformState[] values() {
        return (AudioPluginEnums$WaveformState[]) a.clone();
    }

    public static AudioPluginEnums$WaveformState valueOf(String r1) {
        return (AudioPluginEnums$WaveformState) r27.a.a(AudioPluginEnums$WaveformState.class, r1);
    }

    public AudioPluginEnums$WaveformState(String r1, int r2) {
        super(r1, r2);
    }
}
