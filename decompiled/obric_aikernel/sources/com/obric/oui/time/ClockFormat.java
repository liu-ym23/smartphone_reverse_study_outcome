package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/time/ClockFormat;", "", "<init>", "(Ljava/lang/String;I)V", "H12", "H24", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClockFormat extends Enum<ClockFormat> {
    private static final /* synthetic */ ClockFormat[] $VALUES = null;
    public static final ClockFormat H12 = null;
    public static final ClockFormat H24 = null;

    static {
        ClockFormat r10 = new ClockFormat("H12", 0);
        H12 = r10;
        ClockFormat r11 = new ClockFormat("H24", 1);
        H24 = r11;
        $VALUES = new ClockFormat[]{r10, r11};
    }

    private ClockFormat(String r10, int r11) {
        super(r10, r11);
    }

    public static ClockFormat valueOf(String r10) {
        return (ClockFormat) Enum.valueOf(ClockFormat.class, r10);
    }

    public static ClockFormat[] values() {
        return (ClockFormat[]) $VALUES.clone();
    }
}
