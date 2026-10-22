package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes8.dex */
public final class STPageBorderZOrder$Enum extends StringEnumAbstractBase {
    static final int INT_BACK = 2;
    static final int INT_FRONT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = null;

    static {
        table = new StringEnumAbstractBase.Table(new STPageBorderZOrder$Enum[]{new STPageBorderZOrder$Enum(CpuReportEvent.VALUE_FRONT, 1), new STPageBorderZOrder$Enum(CpuReportEvent.VALUE_BACK, 2)});
    }

    private STPageBorderZOrder$Enum(String r1, int r2) {
        super(r1, r2);
    }

    public static STPageBorderZOrder$Enum forInt(int r2) {
        return (STPageBorderZOrder$Enum) ZeusTransformUtils.preCheckCast(table.forInt(r2), STPageBorderZOrder$Enum.class, "com.obric.memorydata.plugin");
    }

    public static STPageBorderZOrder$Enum forString(String r2) {
        return (STPageBorderZOrder$Enum) ZeusTransformUtils.preCheckCast(table.forString(r2), STPageBorderZOrder$Enum.class, "com.obric.memorydata.plugin");
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
