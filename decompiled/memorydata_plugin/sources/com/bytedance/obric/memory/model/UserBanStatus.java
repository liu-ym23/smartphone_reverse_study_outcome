package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum UserBanStatus extends Enum<UserBanStatus> {
    private static final /* synthetic */ UserBanStatus[] $VALUES = null;

    @SerializedName("3")
    public static final UserBanStatus AppealFailed = null;

    @SerializedName("2")
    public static final UserBanStatus Appealing = null;

    @SerializedName("1")
    public static final UserBanStatus Baned = null;

    @SerializedName("0")
    public static final UserBanStatus Default = null;
    private final int value;

    static {
        UserBanStatus r0 = new UserBanStatus("Default", 0, 0);
        Default = r0;
        UserBanStatus r1 = new UserBanStatus("Baned", 1, 1);
        Baned = r1;
        UserBanStatus r3 = new UserBanStatus("Appealing", 2, 2);
        Appealing = r3;
        UserBanStatus r5 = new UserBanStatus("AppealFailed", 3, 3);
        AppealFailed = r5;
        $VALUES = new UserBanStatus[]{r0, r1, r3, r5};
    }

    private UserBanStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static UserBanStatus findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return AppealFailed;
    L14:
        return Appealing;
    L16:
        return Baned;
    L18:
        return Default;
    }

    public static UserBanStatus valueOf(String r2) {
        return (UserBanStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(UserBanStatus.class, r2), UserBanStatus.class, "com.obric.memorydata.plugin");
    }

    public static UserBanStatus[] values() {
        return (UserBanStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UserBanStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
