package com.bytedance.applog.monitor.exception;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum ExceptionScene extends Enum<ExceptionScene> {
    public static final ExceptionScene Common = null;
    public static final ExceptionScene DataCollection = null;
    public static final ExceptionScene DataPackaging = null;
    public static final ExceptionScene DataUpload = null;
    public static final /* synthetic */ ExceptionScene[] a = null;

    static {
        ExceptionScene r0 = new ExceptionScene("Common", 0);
        Common = r0;
        ExceptionScene r1 = new ExceptionScene("DataCollection", 1);
        DataCollection = r1;
        ExceptionScene r3 = new ExceptionScene("DataPackaging", 2);
        DataPackaging = r3;
        ExceptionScene r5 = new ExceptionScene("DataUpload", 3);
        DataUpload = r5;
        a = new ExceptionScene[]{r0, r1, r3, r5};
    }

    public static ExceptionScene[] values() {
        return (ExceptionScene[]) a.clone();
    }

    public static ExceptionScene valueOf(String r1) {
        return (ExceptionScene) a.a(ExceptionScene.class, r1);
    }

    public ExceptionScene(String r1, int r2) {
        super(r1, r2);
    }
}
