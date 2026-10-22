package com.bytedance.applog.monitor.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ExceptionScene extends Enum<ExceptionScene> {
    private static final /* synthetic */ ExceptionScene[] $VALUES = null;
    public static final ExceptionScene Common = null;
    public static final ExceptionScene DataCollection = null;
    public static final ExceptionScene DataPackaging = null;
    public static final ExceptionScene DataUpload = null;

    static {
        ExceptionScene r0 = new ExceptionScene("Common", 0);
        Common = r0;
        ExceptionScene r1 = new ExceptionScene("DataCollection", 1);
        DataCollection = r1;
        ExceptionScene r3 = new ExceptionScene("DataPackaging", 2);
        DataPackaging = r3;
        ExceptionScene r5 = new ExceptionScene("DataUpload", 3);
        DataUpload = r5;
        $VALUES = new ExceptionScene[]{r0, r1, r3, r5};
    }

    private ExceptionScene(String r1, int r2) {
        super(r1, r2);
    }

    public static ExceptionScene valueOf(String r2) {
        return (ExceptionScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExceptionScene.class, r2), ExceptionScene.class, "com.obric.memorydata.plugin");
    }

    public static ExceptionScene[] values() {
        return (ExceptionScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExceptionScene[].class, "com.obric.memorydata.plugin");
    }
}
