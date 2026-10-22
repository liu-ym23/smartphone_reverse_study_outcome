package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType;

/* JADX INFO: loaded from: classes7.dex */
public final enum ErrorValueType extends Enum<ErrorValueType> {
    private static final /* synthetic */ ErrorValueType[] $VALUES = null;
    public static final ErrorValueType CUSTOM = null;
    public static final ErrorValueType FIXED_VALUE = null;
    public static final ErrorValueType PERCENTAGE = null;
    public static final ErrorValueType STANDARD_DEVIATION = null;
    public static final ErrorValueType STANDARD_ERROR = null;
    private static final HashMap<STErrValType.Enum, ErrorValueType> reverse = null;
    final STErrValType.Enum underlying;

    static {
        int r3 = 0;
        ErrorValueType r0 = new ErrorValueType("CUSTOM", 0, STErrValType.c);
        CUSTOM = r0;
        ErrorValueType r1 = new ErrorValueType("FIXED_VALUE", 1, STErrValType.d);
        FIXED_VALUE = r1;
        ErrorValueType r2 = new ErrorValueType("PERCENTAGE", 2, STErrValType.e);
        PERCENTAGE = r2;
        ErrorValueType r4 = new ErrorValueType("STANDARD_DEVIATION", 3, STErrValType.f);
        STANDARD_DEVIATION = r4;
        ErrorValueType r6 = new ErrorValueType("STANDARD_ERROR", 4, STErrValType.g);
        STANDARD_ERROR = r6;
        $VALUES = new ErrorValueType[]{r0, r1, r2, r4, r6};
        reverse = new HashMap();
        ErrorValueType[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        ErrorValueType r8 = r5[r3];
        reverse.put(r8.underlying, r8);
        r3 = r3 + 1;
        goto L3
    }

    private ErrorValueType(String r1, int r2, STErrValType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static ErrorValueType valueOf(String r2) {
        return (ErrorValueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorValueType.class, r2), ErrorValueType.class, "com.obric.memorydata.plugin");
    }

    static ErrorValueType valueOf(STErrValType.Enum r2) {
        return (ErrorValueType) ZeusTransformUtils.preCheckCast(reverse.get(r2), ErrorValueType.class, "com.obric.memorydata.plugin");
    }

    public static ErrorValueType[] values() {
        return (ErrorValueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorValueType[].class, "com.obric.memorydata.plugin");
    }
}
