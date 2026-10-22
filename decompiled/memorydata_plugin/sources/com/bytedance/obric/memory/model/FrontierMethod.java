package com.bytedance.obric.memory.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum FrontierMethod extends Enum<FrontierMethod> {
    private static final /* synthetic */ FrontierMethod[] $VALUES = null;

    @SerializedName(BDLocationException.SUCCESS)
    public static final FrontierMethod FunctionCall = null;

    @SerializedName("101")
    public static final FrontierMethod Memory = null;

    @SerializedName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final FrontierMethod Profile = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final FrontierMethod Topic = null;

    @SerializedName("103")
    public static final FrontierMethod UserTodo = null;
    private final int value;

    static {
        FrontierMethod r0 = new FrontierMethod("Topic", 0, 100);
        Topic = r0;
        FrontierMethod r1 = new FrontierMethod("Memory", 1, 101);
        Memory = r1;
        FrontierMethod r3 = new FrontierMethod("Profile", 2, 102);
        Profile = r3;
        FrontierMethod r5 = new FrontierMethod("UserTodo", 3, 103);
        UserTodo = r5;
        FrontierMethod r7 = new FrontierMethod("FunctionCall", 4, 200);
        FunctionCall = r7;
        $VALUES = new FrontierMethod[]{r0, r1, r3, r5, r7};
    }

    private FrontierMethod(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static FrontierMethod findByValue(int r1) {
        if (r1 == 200) goto L16;
        switch(r1) {
            case 100: goto L14;
            case 101: goto L12;
            case 102: goto L10;
            case 103: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return UserTodo;
    L10:
        return Profile;
    L12:
        return Memory;
    L14:
        return Topic;
    L16:
        return FunctionCall;
    }

    public static FrontierMethod valueOf(String r2) {
        return (FrontierMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(FrontierMethod.class, r2), FrontierMethod.class, "com.obric.memorydata.plugin");
    }

    public static FrontierMethod[] values() {
        return (FrontierMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FrontierMethod[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
