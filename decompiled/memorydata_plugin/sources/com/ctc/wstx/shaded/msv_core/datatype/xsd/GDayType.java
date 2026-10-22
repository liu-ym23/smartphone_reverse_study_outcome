package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class GDayType extends DateTimeBaseType {
    private static final long serialVersionUID = 1;
    public static final GDayType theInstance = null;

    static {
        theInstance = new GDayType();
    }

    private GDayType() {
        super("gDay");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DateTimeBaseType, com.ctc.wstx.shaded.msv_core.datatype.xsd.a
    public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
        return super.compare(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DateTimeBaseType
    public final String getFormat() {
        return "---%D%z";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DateTimeBaseType, com.ctc.wstx.shaded.msv_core.datatype.a
    public /* bridge */ /* synthetic */ Class getJavaObjectType() {
        return super.getJavaObjectType();
    }
}
