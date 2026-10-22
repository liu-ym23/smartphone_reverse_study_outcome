package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum UserType extends Enum<UserType> {
    private static final /* synthetic */ UserType[] $VALUES = null;

    @SerializedName("2")
    public static final UserType Bot = null;

    @SerializedName("1")
    public static final UserType User = null;
    private final int value;

    static {
        UserType r0 = new UserType("User", 0, 1);
        User = r0;
        UserType r1 = new UserType("Bot", 1, 2);
        Bot = r1;
        $VALUES = new UserType[]{r0, r1};
    }

    private UserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static UserType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Bot;
    L11:
        return User;
    }

    public static UserType valueOf(String r2) {
        return (UserType) ZeusTransformUtils.preCheckCast(Enum.valueOf(UserType.class, r2), UserType.class, "com.obric.memorydata.plugin");
    }

    public static UserType[] values() {
        return (UserType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UserType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
