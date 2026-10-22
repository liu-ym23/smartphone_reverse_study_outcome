package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETE", "SIMPLE", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AudioPluginEnums$DisplayMode extends Enum<AudioPluginEnums$DisplayMode> {
    public static final AudioPluginEnums$DisplayMode COMPLETE = null;
    public static final AudioPluginEnums$DisplayMode SIMPLE = null;
    public static final /* synthetic */ AudioPluginEnums$DisplayMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioPluginEnums$DisplayMode> getEntries() {
        return b;
    }

    static {
        AudioPluginEnums$DisplayMode r0 = new AudioPluginEnums$DisplayMode("COMPLETE", 0);
        COMPLETE = r0;
        AudioPluginEnums$DisplayMode r1 = new AudioPluginEnums$DisplayMode("SIMPLE", 1);
        SIMPLE = r1;
        AudioPluginEnums$DisplayMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AudioPluginEnums$DisplayMode[] values() {
        return (AudioPluginEnums$DisplayMode[]) a.clone();
    }

    public static AudioPluginEnums$DisplayMode valueOf(String r1) {
        return (AudioPluginEnums$DisplayMode) r27.a.a(AudioPluginEnums$DisplayMode.class, r1);
    }

    public AudioPluginEnums$DisplayMode(String r1, int r2) {
        super(r1, r2);
    }
}
