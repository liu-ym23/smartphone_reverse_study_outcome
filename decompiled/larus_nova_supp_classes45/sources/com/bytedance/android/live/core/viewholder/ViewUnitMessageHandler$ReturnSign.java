package com.bytedance.android.live.core.viewholder;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum ViewUnitMessageHandler$ReturnSign extends Enum<ViewUnitMessageHandler$ReturnSign> {
    public static final ViewUnitMessageHandler$ReturnSign RESULT_INTERREPT = null;
    public static final ViewUnitMessageHandler$ReturnSign RESULT_NEXT = null;
    public static final /* synthetic */ ViewUnitMessageHandler$ReturnSign[] a = null;

    static {
        ViewUnitMessageHandler$ReturnSign r0 = new ViewUnitMessageHandler$ReturnSign("RESULT_NEXT", 0);
        RESULT_NEXT = r0;
        ViewUnitMessageHandler$ReturnSign r1 = new ViewUnitMessageHandler$ReturnSign("RESULT_INTERREPT", 1);
        RESULT_INTERREPT = r1;
        a = new ViewUnitMessageHandler$ReturnSign[]{r0, r1};
    }

    public static ViewUnitMessageHandler$ReturnSign[] values() {
        return (ViewUnitMessageHandler$ReturnSign[]) a.clone();
    }

    public static ViewUnitMessageHandler$ReturnSign valueOf(String r1) {
        return (ViewUnitMessageHandler$ReturnSign) a.a(ViewUnitMessageHandler$ReturnSign.class, r1);
    }

    public ViewUnitMessageHandler$ReturnSign(String r1, int r2) {
        super(r1, r2);
    }
}
