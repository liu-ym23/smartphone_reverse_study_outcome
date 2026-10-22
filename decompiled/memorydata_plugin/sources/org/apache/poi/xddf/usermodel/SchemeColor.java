package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;

/* JADX INFO: loaded from: classes7.dex */
public final enum SchemeColor extends Enum<SchemeColor> {
    private static final /* synthetic */ SchemeColor[] $VALUES = null;
    public static final SchemeColor ACCENT_1 = null;
    public static final SchemeColor ACCENT_2 = null;
    public static final SchemeColor ACCENT_3 = null;
    public static final SchemeColor ACCENT_4 = null;
    public static final SchemeColor ACCENT_5 = null;
    public static final SchemeColor ACCENT_6 = null;
    public static final SchemeColor BACKGROUND_1 = null;
    public static final SchemeColor BACKGROUND_2 = null;
    public static final SchemeColor DARK_1 = null;
    public static final SchemeColor DARK_2 = null;
    public static final SchemeColor FOLLOWED_LINK = null;
    public static final SchemeColor LIGHT_1 = null;
    public static final SchemeColor LIGHT_2 = null;
    public static final SchemeColor LINK = null;
    public static final SchemeColor PLACEHOLDER = null;
    public static final SchemeColor TEXT_1 = null;
    public static final SchemeColor TEXT_2 = null;
    private static final HashMap<STSchemeColorVal.Enum, SchemeColor> reverse = null;
    final STSchemeColorVal.Enum underlying;

    static {
        SchemeColor r0 = new SchemeColor("ACCENT_1", 0, STSchemeColorVal.g);
        ACCENT_1 = r0;
        SchemeColor r1 = new SchemeColor("ACCENT_2", 1, STSchemeColorVal.h);
        ACCENT_2 = r1;
        SchemeColor r2 = new SchemeColor("ACCENT_3", 2, STSchemeColorVal.i);
        ACCENT_3 = r2;
        SchemeColor r4 = new SchemeColor("ACCENT_4", 3, STSchemeColorVal.j);
        ACCENT_4 = r4;
        SchemeColor r6 = new SchemeColor("ACCENT_5", 4, STSchemeColorVal.k);
        ACCENT_5 = r6;
        SchemeColor r8 = new SchemeColor("ACCENT_6", 5, STSchemeColorVal.l);
        ACCENT_6 = r8;
        SchemeColor r10 = new SchemeColor("BACKGROUND_1", 6, STSchemeColorVal.c);
        BACKGROUND_1 = r10;
        SchemeColor r12 = new SchemeColor("BACKGROUND_2", 7, STSchemeColorVal.e);
        BACKGROUND_2 = r12;
        SchemeColor r14 = new SchemeColor("DARK_1", 8, STSchemeColorVal.p);
        DARK_1 = r14;
        SchemeColor r13 = new SchemeColor("DARK_2", 9, STSchemeColorVal.r);
        DARK_2 = r13;
        SchemeColor r11 = new SchemeColor("FOLLOWED_LINK", 10, STSchemeColorVal.n);
        FOLLOWED_LINK = r11;
        SchemeColor r9 = new SchemeColor("LINK", 11, STSchemeColorVal.m);
        LINK = r9;
        SchemeColor r7 = new SchemeColor("LIGHT_1", 12, STSchemeColorVal.q);
        LIGHT_1 = r7;
        SchemeColor r5 = new SchemeColor("LIGHT_2", 13, STSchemeColorVal.s);
        LIGHT_2 = r5;
        SchemeColor r3 = new SchemeColor("PLACEHOLDER", 14, STSchemeColorVal.o);
        PLACEHOLDER = r3;
        SchemeColor r15 = new SchemeColor("TEXT_1", 15, STSchemeColorVal.d);
        TEXT_1 = r15;
        SchemeColor r16 = new SchemeColor("TEXT_2", 16, STSchemeColorVal.f);
        TEXT_2 = r16;
        $VALUES = new SchemeColor[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16};
        reverse = new HashMap();
        SchemeColor[] r17 = values();
        int r18 = r17.length;
        int r19 = 0;
    L3:
        if (r19 >= r18) goto L5;
        SchemeColor r20 = r17[r19];
        reverse.put(r20.underlying, r20);
        r19 = r19 + 1;
        goto L3
    }

    private SchemeColor(String r1, int r2, STSchemeColorVal.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static SchemeColor valueOf(String r2) {
        return (SchemeColor) ZeusTransformUtils.preCheckCast(Enum.valueOf(SchemeColor.class, r2), SchemeColor.class, "com.obric.memorydata.plugin");
    }

    static SchemeColor valueOf(STSchemeColorVal.Enum r2) {
        return (SchemeColor) ZeusTransformUtils.preCheckCast(reverse.get(r2), SchemeColor.class, "com.obric.memorydata.plugin");
    }

    public static SchemeColor[] values() {
        return (SchemeColor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SchemeColor[].class, "com.obric.memorydata.plugin");
    }
}
