package com.obric.oui.time;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/time/ClockFormat;", "", "(Ljava/lang/String;I)V", "H12", "H24", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ClockFormat extends Enum<ClockFormat> {
    private static final /* synthetic */ ClockFormat[] $VALUES = null;
    public static final ClockFormat H12 = null;
    public static final ClockFormat H24 = null;

    private static final /* synthetic */ ClockFormat[] $values() {
        return new ClockFormat[]{H12, H24};
    }

    static {
        H12 = new ClockFormat("H12", 0);
        H24 = new ClockFormat("H24", 1);
        $VALUES = $values();
    }

    private ClockFormat(String r1, int r2) {
        super(r1, r2);
    }

    public static ClockFormat valueOf(String r2) {
        return (ClockFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClockFormat.class, r2), ClockFormat.class, "com.obric.memorydata.plugin");
    }

    public static ClockFormat[] values() {
        return (ClockFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClockFormat[].class, "com.obric.memorydata.plugin");
    }
}
