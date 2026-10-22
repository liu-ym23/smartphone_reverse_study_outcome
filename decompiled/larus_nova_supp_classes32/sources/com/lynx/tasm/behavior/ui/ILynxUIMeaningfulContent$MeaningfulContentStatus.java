package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum ILynxUIMeaningfulContent$MeaningfulContentStatus extends Enum<ILynxUIMeaningfulContent$MeaningfulContentStatus> {
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus IRRELEVANT = null;
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus PENDING = null;
    public static final ILynxUIMeaningfulContent$MeaningfulContentStatus PRESENTED = null;
    public static final /* synthetic */ ILynxUIMeaningfulContent$MeaningfulContentStatus[] a = null;

    static {
        ILynxUIMeaningfulContent$MeaningfulContentStatus r0 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("IRRELEVANT", 0);
        IRRELEVANT = r0;
        ILynxUIMeaningfulContent$MeaningfulContentStatus r1 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("PENDING", 1);
        PENDING = r1;
        ILynxUIMeaningfulContent$MeaningfulContentStatus r3 = new ILynxUIMeaningfulContent$MeaningfulContentStatus("PRESENTED", 2);
        PRESENTED = r3;
        a = new ILynxUIMeaningfulContent$MeaningfulContentStatus[]{r0, r1, r3};
    }

    public static ILynxUIMeaningfulContent$MeaningfulContentStatus[] values() {
        return (ILynxUIMeaningfulContent$MeaningfulContentStatus[]) a.clone();
    }

    public static ILynxUIMeaningfulContent$MeaningfulContentStatus valueOf(String r1) {
        return (ILynxUIMeaningfulContent$MeaningfulContentStatus) r27.a.a(ILynxUIMeaningfulContent$MeaningfulContentStatus.class, r1);
    }

    public ILynxUIMeaningfulContent$MeaningfulContentStatus(String r1, int r2) {
        super(r1, r2);
    }
}
