package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DeleteBtnAttrs;", "", "bias", "", "padding", "", "<init>", "(Ljava/lang/String;IFI)V", "getBias", "()F", "getPadding", "()I", "INIT", "FINAL", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AudioPluginEnums$DeleteBtnAttrs extends Enum<AudioPluginEnums$DeleteBtnAttrs> {
    public static final AudioPluginEnums$DeleteBtnAttrs FINAL = null;
    public static final AudioPluginEnums$DeleteBtnAttrs INIT = null;
    public static final /* synthetic */ AudioPluginEnums$DeleteBtnAttrs[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final float bias;
    private final int padding;

    public static EnumEntries<AudioPluginEnums$DeleteBtnAttrs> getEntries() {
        return b;
    }

    static {
        AudioPluginEnums$DeleteBtnAttrs r0 = new AudioPluginEnums$DeleteBtnAttrs("INIT", 0, 0.9f, 12);
        INIT = r0;
        AudioPluginEnums$DeleteBtnAttrs r1 = new AudioPluginEnums$DeleteBtnAttrs("FINAL", 1, 0.2f, 0);
        FINAL = r1;
        AudioPluginEnums$DeleteBtnAttrs[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AudioPluginEnums$DeleteBtnAttrs[] values() {
        return (AudioPluginEnums$DeleteBtnAttrs[]) a.clone();
    }

    public final float getBias() {
        return this.bias;
    }

    public final int getPadding() {
        return this.padding;
    }

    public static AudioPluginEnums$DeleteBtnAttrs valueOf(String r1) {
        return (AudioPluginEnums$DeleteBtnAttrs) r27.a.a(AudioPluginEnums$DeleteBtnAttrs.class, r1);
    }

    public AudioPluginEnums$DeleteBtnAttrs(String r1, int r2, float r3, int r4) {
        super(r1, r2);
        this.bias = r3;
        this.padding = r4;
    }
}
