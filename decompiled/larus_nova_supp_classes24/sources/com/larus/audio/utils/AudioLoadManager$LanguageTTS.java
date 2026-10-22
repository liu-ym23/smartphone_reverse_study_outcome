package com.larus.audio.utils;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/audio/utils/AudioLoadManager$LanguageTTS;", "", "language", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "LANGUAGE_ZH", "LANGUAGE_EN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioLoadManager$LanguageTTS extends Enum<AudioLoadManager$LanguageTTS> {
    public static final AudioLoadManager$LanguageTTS LANGUAGE_EN = null;
    public static final AudioLoadManager$LanguageTTS LANGUAGE_ZH = null;
    public static final /* synthetic */ AudioLoadManager$LanguageTTS[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String language;

    public static EnumEntries<AudioLoadManager$LanguageTTS> getEntries() {
        return b;
    }

    static {
        AudioLoadManager$LanguageTTS r0 = new AudioLoadManager$LanguageTTS("LANGUAGE_ZH", 0, "zh");
        LANGUAGE_ZH = r0;
        AudioLoadManager$LanguageTTS r1 = new AudioLoadManager$LanguageTTS("LANGUAGE_EN", 1, "en");
        LANGUAGE_EN = r1;
        AudioLoadManager$LanguageTTS[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AudioLoadManager$LanguageTTS[] values() {
        return (AudioLoadManager$LanguageTTS[]) a.clone();
    }

    public final String getLanguage() {
        return this.language;
    }

    public static AudioLoadManager$LanguageTTS valueOf(String r1) {
        return (AudioLoadManager$LanguageTTS) r27.a.a(AudioLoadManager$LanguageTTS.class, r1);
    }

    public AudioLoadManager$LanguageTTS(String r1, int r2, String r3) {
        super(r1, r2);
        this.language = r3;
    }
}
