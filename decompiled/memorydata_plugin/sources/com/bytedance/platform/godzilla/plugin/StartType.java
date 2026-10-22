package com.bytedance.platform.godzilla.plugin;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum StartType extends Enum<StartType> {
    private static final /* synthetic */ StartType[] $VALUES = null;
    public static final StartType IMMEDIATE = null;
    public static final StartType REGISTER_EXCEPTION = null;

    static {
        StartType r0 = new StartType("IMMEDIATE", 0);
        IMMEDIATE = r0;
        StartType r1 = new StartType("REGISTER_EXCEPTION", 1);
        REGISTER_EXCEPTION = r1;
        $VALUES = new StartType[]{r0, r1};
    }

    private StartType(String r1, int r2) {
        super(r1, r2);
    }

    public static StartType valueOf(String r2) {
        return (StartType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StartType.class, r2), StartType.class, "com.obric.memorydata.plugin");
    }

    public static StartType[] values() {
        return (StartType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StartType[].class, "com.obric.memorydata.plugin");
    }
}
