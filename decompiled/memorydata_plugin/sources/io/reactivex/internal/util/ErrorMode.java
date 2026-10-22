package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum ErrorMode extends Enum<ErrorMode> {
    private static final /* synthetic */ ErrorMode[] $VALUES = null;
    public static final ErrorMode BOUNDARY = null;
    public static final ErrorMode END = null;
    public static final ErrorMode IMMEDIATE = null;

    static {
        ErrorMode r0 = new ErrorMode("IMMEDIATE", 0);
        IMMEDIATE = r0;
        ErrorMode r1 = new ErrorMode("BOUNDARY", 1);
        BOUNDARY = r1;
        ErrorMode r3 = new ErrorMode("END", 2);
        END = r3;
        $VALUES = new ErrorMode[]{r0, r1, r3};
    }

    private ErrorMode(String r1, int r2) {
        super(r1, r2);
    }

    public static ErrorMode valueOf(String r2) {
        return (ErrorMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorMode.class, r2), ErrorMode.class, "com.obric.memorydata.plugin");
    }

    public static ErrorMode[] values() {
        return (ErrorMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorMode[].class, "com.obric.memorydata.plugin");
    }
}
