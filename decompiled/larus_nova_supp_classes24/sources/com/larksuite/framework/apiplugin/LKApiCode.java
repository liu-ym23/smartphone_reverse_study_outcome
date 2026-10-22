package com.larksuite.framework.apiplugin;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum LKApiCode extends Enum<LKApiCode> {
    public static final LKApiCode GENERAL_PARAM = null;
    public static final LKApiCode GENERAL_UNKONW_ERROR = null;
    public static final LKApiCode GENERAL_USER_AUTH_DENIED = null;
    public static final /* synthetic */ LKApiCode[] a = null;
    public int code;
    public String msg;

    static {
        LKApiCode r0 = new LKApiCode("GENERAL_PARAM", 0, 10001, "invalid parameter");
        GENERAL_PARAM = r0;
        LKApiCode r1 = new LKApiCode("GENERAL_USER_AUTH_DENIED", 1, 10006, "user auth denied");
        GENERAL_USER_AUTH_DENIED = r1;
        LKApiCode r2 = new LKApiCode("GENERAL_UNKONW_ERROR", 2, 10010, "unknown error");
        GENERAL_UNKONW_ERROR = r2;
        a = new LKApiCode[]{r0, r1, r2};
    }

    public static LKApiCode[] values() {
        return (LKApiCode[]) a.clone();
    }

    public static LKApiCode valueOf(String r1) {
        return (LKApiCode) a.a(LKApiCode.class, r1);
    }

    public LKApiCode(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.msg = r4;
    }
}
