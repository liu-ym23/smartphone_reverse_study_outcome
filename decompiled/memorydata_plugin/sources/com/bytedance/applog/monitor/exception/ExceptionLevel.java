package com.bytedance.applog.monitor.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ExceptionLevel extends Enum<ExceptionLevel> {
    private static final /* synthetic */ ExceptionLevel[] $VALUES = null;
    public static final ExceptionLevel Fatal = null;
    public static final ExceptionLevel Notice = null;

    static {
        ExceptionLevel r0 = new ExceptionLevel("Fatal", 0);
        Fatal = r0;
        ExceptionLevel r1 = new ExceptionLevel("Notice", 1);
        Notice = r1;
        $VALUES = new ExceptionLevel[]{r0, r1};
    }

    private ExceptionLevel(String r1, int r2) {
        super(r1, r2);
    }

    public static ExceptionLevel valueOf(String r2) {
        return (ExceptionLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExceptionLevel.class, r2), ExceptionLevel.class, "com.obric.memorydata.plugin");
    }

    public static ExceptionLevel[] values() {
        return (ExceptionLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExceptionLevel[].class, "com.obric.memorydata.plugin");
    }
}
