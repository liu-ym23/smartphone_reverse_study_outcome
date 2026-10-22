package com.larus.audio.tts;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/tts/DowngradeType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TTS_SOFT_DOWNGRADE", "TTS_AUTOPLAY_DOWNGRADE", "TTS_MANUALPLAY_DOWNGRADE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final enum DowngradeType extends Enum<DowngradeType> {
    public static final DowngradeType TTS_AUTOPLAY_DOWNGRADE = null;
    public static final DowngradeType TTS_MANUALPLAY_DOWNGRADE = null;
    public static final DowngradeType TTS_SOFT_DOWNGRADE = null;
    public static final /* synthetic */ DowngradeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<DowngradeType> getEntries() {
        return b;
    }

    static {
        DowngradeType r0 = new DowngradeType("TTS_SOFT_DOWNGRADE", 0, "tts_soft_downgrade");
        TTS_SOFT_DOWNGRADE = r0;
        DowngradeType r1 = new DowngradeType("TTS_AUTOPLAY_DOWNGRADE", 1, "tts_autoplay_downgrade");
        TTS_AUTOPLAY_DOWNGRADE = r1;
        DowngradeType r2 = new DowngradeType("TTS_MANUALPLAY_DOWNGRADE", 2, "tts_manualplay_downgrade");
        TTS_MANUALPLAY_DOWNGRADE = r2;
        DowngradeType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DowngradeType[] values() {
        return (DowngradeType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static DowngradeType valueOf(String r1) {
        return (DowngradeType) a.a(DowngradeType.class, r1);
    }

    public DowngradeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
