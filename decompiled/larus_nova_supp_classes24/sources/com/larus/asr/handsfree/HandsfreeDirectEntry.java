package com.larus.asr.handsfree;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/handsfree/HandsfreeDirectEntry;", "", "<init>", "(Ljava/lang/String;I)V", "MIC_ICON_CLICK", "VOICE_INPUT_BUTTON_PRESS", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum HandsfreeDirectEntry extends Enum<HandsfreeDirectEntry> {
    public static final HandsfreeDirectEntry MIC_ICON_CLICK = null;
    public static final HandsfreeDirectEntry VOICE_INPUT_BUTTON_PRESS = null;
    public static final /* synthetic */ HandsfreeDirectEntry[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HandsfreeDirectEntry> getEntries() {
        return b;
    }

    static {
        HandsfreeDirectEntry r0 = new HandsfreeDirectEntry("MIC_ICON_CLICK", 0);
        MIC_ICON_CLICK = r0;
        HandsfreeDirectEntry r1 = new HandsfreeDirectEntry("VOICE_INPUT_BUTTON_PRESS", 1);
        VOICE_INPUT_BUTTON_PRESS = r1;
        HandsfreeDirectEntry[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static HandsfreeDirectEntry[] values() {
        return (HandsfreeDirectEntry[]) a.clone();
    }

    public static HandsfreeDirectEntry valueOf(String r1) {
        return (HandsfreeDirectEntry) r27.a.a(HandsfreeDirectEntry.class, r1);
    }

    public HandsfreeDirectEntry(String r1, int r2) {
        super(r1, r2);
    }
}
