package com.larus.audio.call.play.abs;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/play/abs/TtsPlayEndType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TIMEOUT", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TtsPlayEndType extends Enum<TtsPlayEndType> {
    public static final TtsPlayEndType NORMAL = null;
    public static final TtsPlayEndType TIMEOUT = null;
    public static final /* synthetic */ TtsPlayEndType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TtsPlayEndType> getEntries() {
        return b;
    }

    static {
        TtsPlayEndType r0 = new TtsPlayEndType("NORMAL", 0);
        NORMAL = r0;
        TtsPlayEndType r1 = new TtsPlayEndType("TIMEOUT", 1);
        TIMEOUT = r1;
        TtsPlayEndType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static TtsPlayEndType[] values() {
        return (TtsPlayEndType[]) a.clone();
    }

    public static TtsPlayEndType valueOf(String r1) {
        return (TtsPlayEndType) a.a(TtsPlayEndType.class, r1);
    }

    public TtsPlayEndType(String r1, int r2) {
        super(r1, r2);
    }
}
