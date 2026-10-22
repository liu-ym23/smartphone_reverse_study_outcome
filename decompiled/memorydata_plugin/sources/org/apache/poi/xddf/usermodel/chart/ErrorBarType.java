package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrBarType;

/* JADX INFO: loaded from: classes7.dex */
public final enum ErrorBarType extends Enum<ErrorBarType> {
    private static final /* synthetic */ ErrorBarType[] $VALUES = null;
    public static final ErrorBarType BOTH = null;
    public static final ErrorBarType MINUS = null;
    public static final ErrorBarType PLUS = null;
    private static final HashMap<STErrBarType.Enum, ErrorBarType> reverse = null;
    final STErrBarType.Enum underlying;

    static {
        int r3 = 0;
        ErrorBarType r0 = new ErrorBarType("BOTH", 0, STErrBarType.c);
        BOTH = r0;
        ErrorBarType r1 = new ErrorBarType("MINUS", 1, STErrBarType.d);
        MINUS = r1;
        ErrorBarType r2 = new ErrorBarType("PLUS", 2, STErrBarType.e);
        PLUS = r2;
        $VALUES = new ErrorBarType[]{r0, r1, r2};
        reverse = new HashMap();
        ErrorBarType[] r4 = values();
        int r5 = r4.length;
    L3:
        if (r3 >= r5) goto L5;
        ErrorBarType r6 = r4[r3];
        reverse.put(r6.underlying, r6);
        r3 = r3 + 1;
        goto L3
    }

    private ErrorBarType(String r1, int r2, STErrBarType.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static ErrorBarType valueOf(String r2) {
        return (ErrorBarType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorBarType.class, r2), ErrorBarType.class, "com.obric.memorydata.plugin");
    }

    static ErrorBarType valueOf(STErrBarType.Enum r2) {
        return (ErrorBarType) ZeusTransformUtils.preCheckCast(reverse.get(r2), ErrorBarType.class, "com.obric.memorydata.plugin");
    }

    public static ErrorBarType[] values() {
        return (ErrorBarType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorBarType[].class, "com.obric.memorydata.plugin");
    }
}
