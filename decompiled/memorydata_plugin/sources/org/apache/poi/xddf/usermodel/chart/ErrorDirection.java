package org.apache.poi.xddf.usermodel.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir;

/* JADX INFO: loaded from: classes7.dex */
public final enum ErrorDirection extends Enum<ErrorDirection> {
    private static final /* synthetic */ ErrorDirection[] $VALUES = null;
    public static final ErrorDirection X = null;
    public static final ErrorDirection Y = null;
    private static final HashMap<STErrDir.Enum, ErrorDirection> reverse = null;
    final STErrDir.Enum underlying;

    static {
        int r3 = 0;
        ErrorDirection r0 = new ErrorDirection("X", 0, STErrDir.c);
        X = r0;
        ErrorDirection r1 = new ErrorDirection("Y", 1, STErrDir.d);
        Y = r1;
        $VALUES = new ErrorDirection[]{r0, r1};
        reverse = new HashMap();
        ErrorDirection[] r2 = values();
        int r4 = r2.length;
    L3:
        if (r3 >= r4) goto L5;
        ErrorDirection r5 = r2[r3];
        reverse.put(r5.underlying, r5);
        r3 = r3 + 1;
        goto L3
    }

    private ErrorDirection(String r1, int r2, STErrDir.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static ErrorDirection valueOf(String r2) {
        return (ErrorDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorDirection.class, r2), ErrorDirection.class, "com.obric.memorydata.plugin");
    }

    static ErrorDirection valueOf(STErrDir.Enum r2) {
        return (ErrorDirection) ZeusTransformUtils.preCheckCast(reverse.get(r2), ErrorDirection.class, "com.obric.memorydata.plugin");
    }

    public static ErrorDirection[] values() {
        return (ErrorDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorDirection[].class, "com.obric.memorydata.plugin");
    }
}
