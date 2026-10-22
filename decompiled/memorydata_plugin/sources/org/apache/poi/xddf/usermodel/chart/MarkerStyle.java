package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

/* JADX INFO: loaded from: classes7.dex */
public final enum MarkerStyle extends Enum<MarkerStyle> {
    private static final /* synthetic */ MarkerStyle[] $VALUES = null;
    public static final MarkerStyle CIRCLE = null;
    public static final MarkerStyle DASH = null;
    public static final MarkerStyle DIAMOND = null;
    public static final MarkerStyle DOT = null;
    public static final MarkerStyle NONE = null;
    public static final MarkerStyle PICTURE = null;
    public static final MarkerStyle PLUS = null;
    public static final MarkerStyle SQUARE = null;
    public static final MarkerStyle STAR = null;
    public static final MarkerStyle TRIANGLE = null;
    public static final MarkerStyle X = null;
    private static final HashMap<STMarkerStyle.Enum, MarkerStyle> reverse = null;
    final STMarkerStyle.Enum underlying;

    static {
        int r3 = 0;
        MarkerStyle r0 = new MarkerStyle("CIRCLE", 0, STMarkerStyle.c);
        CIRCLE = r0;
        MarkerStyle r1 = new MarkerStyle("DASH", 1, STMarkerStyle.d);
        DASH = r1;
        MarkerStyle r2 = new MarkerStyle("DIAMOND", 2, STMarkerStyle.e);
        DIAMOND = r2;
        MarkerStyle r4 = new MarkerStyle("DOT", 3, STMarkerStyle.f);
        DOT = r4;
        MarkerStyle r6 = new MarkerStyle("NONE", 4, STMarkerStyle.g);
        NONE = r6;
        MarkerStyle r8 = new MarkerStyle("PICTURE", 5, STMarkerStyle.h);
        PICTURE = r8;
        MarkerStyle r10 = new MarkerStyle("PLUS", 6, STMarkerStyle.i);
        PLUS = r10;
        MarkerStyle r12 = new MarkerStyle("SQUARE", 7, STMarkerStyle.j);
        SQUARE = r12;
        MarkerStyle r14 = new MarkerStyle("STAR", 8, STMarkerStyle.k);
        STAR = r14;
        MarkerStyle r13 = new MarkerStyle("TRIANGLE", 9, STMarkerStyle.l);
        TRIANGLE = r13;
        MarkerStyle r11 = new MarkerStyle("X", 10, STMarkerStyle.m);
        X = r11;
        $VALUES = new MarkerStyle[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
        reverse = new HashMap();
        MarkerStyle[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        MarkerStyle r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private MarkerStyle(String r1, int r2, STMarkerStyle.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static MarkerStyle valueOf(String r2) {
        return (MarkerStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(MarkerStyle.class, r2), MarkerStyle.class, "com.obric.memorydata.plugin");
    }

    static MarkerStyle valueOf(STMarkerStyle.Enum r2) {
        return (MarkerStyle) ZeusTransformUtils.preCheckCast(reverse.get(r2), MarkerStyle.class, "com.obric.memorydata.plugin");
    }

    public static MarkerStyle[] values() {
        return (MarkerStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MarkerStyle[].class, "com.obric.memorydata.plugin");
    }
}
