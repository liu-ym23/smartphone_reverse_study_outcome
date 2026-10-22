package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformWidgetTheme;", "", "bgColorRes", "", "waveColorRes", "fadeColorRes", "textColorRes", "<init>", "(Ljava/lang/String;IIIII)V", "getBgColorRes", "()I", "getWaveColorRes", "getFadeColorRes", "getTextColorRes", "BLUE_SIMPLE", "BLUE", "GRAY", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AudioPluginEnums$WaveformWidgetTheme extends Enum<AudioPluginEnums$WaveformWidgetTheme> {
    public static final AudioPluginEnums$WaveformWidgetTheme BLUE = null;
    public static final AudioPluginEnums$WaveformWidgetTheme BLUE_SIMPLE = null;
    public static final AudioPluginEnums$WaveformWidgetTheme GRAY = null;
    public static final /* synthetic */ AudioPluginEnums$WaveformWidgetTheme[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int bgColorRes;
    private final int fadeColorRes;
    private final int textColorRes;
    private final int waveColorRes;

    public static EnumEntries<AudioPluginEnums$WaveformWidgetTheme> getEntries() {
        return b;
    }

    static {
        AudioPluginEnums$WaveformWidgetTheme r7 = new AudioPluginEnums$WaveformWidgetTheme("BLUE_SIMPLE", 0, 2131106784, 2131105542, 2131105544, 2131106784);
        BLUE_SIMPLE = r7;
        AudioPluginEnums$WaveformWidgetTheme r0 = new AudioPluginEnums$WaveformWidgetTheme("BLUE", 1, 2131102439, 2131105542, 2131105544, 2131106616);
        BLUE = r0;
        AudioPluginEnums$WaveformWidgetTheme r1 = new AudioPluginEnums$WaveformWidgetTheme("GRAY", 2, 2131102445, 2131106607, 2131106613, 2131106607);
        GRAY = r1;
        AudioPluginEnums$WaveformWidgetTheme[] r2 = {r7, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AudioPluginEnums$WaveformWidgetTheme[] values() {
        return (AudioPluginEnums$WaveformWidgetTheme[]) a.clone();
    }

    public final int getBgColorRes() {
        return this.bgColorRes;
    }

    public final int getFadeColorRes() {
        return this.fadeColorRes;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final int getWaveColorRes() {
        return this.waveColorRes;
    }

    public static AudioPluginEnums$WaveformWidgetTheme valueOf(String r1) {
        return (AudioPluginEnums$WaveformWidgetTheme) r27.a.a(AudioPluginEnums$WaveformWidgetTheme.class, r1);
    }

    public AudioPluginEnums$WaveformWidgetTheme(String r1, int r2, int r3, int r4, int r5, int r6) {
        super(r1, r2);
        this.bgColorRes = r3;
        this.waveColorRes = r4;
        this.fadeColorRes = r5;
        this.textColorRes = r6;
    }
}
