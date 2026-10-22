package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRadarStyle;

/* JADX INFO: loaded from: classes7.dex */
public final enum RadarStyle extends Enum<RadarStyle> {
    private static final /* synthetic */ RadarStyle[] $VALUES = null;
    public static final RadarStyle FILLED = null;
    public static final RadarStyle MARKER = null;
    public static final RadarStyle STANDARD = null;
    private static final HashMap<STRadarStyle.Enum, RadarStyle> reverse = null;
    final STRadarStyle.Enum underlying;

    static {
        int r3 = 0;
        RadarStyle r0 = new RadarStyle("FILLED", 0, STRadarStyle.e);
        FILLED = r0;
        RadarStyle r1 = new RadarStyle("MARKER", 1, STRadarStyle.d);
        MARKER = r1;
        RadarStyle r2 = new RadarStyle("STANDARD", 2, STRadarStyle.c);
        STANDARD = r2;
        $VALUES = new RadarStyle[]{r0, r1, r2};
        reverse = new HashMap();
        RadarStyle[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        RadarStyle r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private RadarStyle(String r1, int r2, STRadarStyle.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static RadarStyle valueOf(String r2) {
        return (RadarStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(RadarStyle.class, r2), RadarStyle.class, "com.obric.memorydata.plugin");
    }

    static RadarStyle valueOf(STRadarStyle.Enum r2) {
        return (RadarStyle) ZeusTransformUtils.preCheckCast(reverse.get(r2), RadarStyle.class, "com.obric.memorydata.plugin");
    }

    public static RadarStyle[] values() {
        return (RadarStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RadarStyle[].class, "com.obric.memorydata.plugin");
    }
}
