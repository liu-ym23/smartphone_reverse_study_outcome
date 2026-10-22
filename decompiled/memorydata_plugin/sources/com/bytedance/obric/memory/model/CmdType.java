package com.bytedance.obric.memory.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CmdType extends Enum<CmdType> {
    private static final /* synthetic */ CmdType[] $VALUES = null;

    @SerializedName("12")
    public static final CmdType ConversationAdd = null;

    @SerializedName("11")
    public static final CmdType ConversationArchive = null;

    @SerializedName("14")
    public static final CmdType ConversationClearHistory = null;

    @SerializedName("13")
    public static final CmdType ConversationCreateSection = null;

    @SerializedName("15")
    public static final CmdType ConversationUpdate = null;

    @SerializedName("1")
    public static final CmdType MessageDelete = null;

    @SerializedName("3")
    public static final CmdType MessageDislike = null;

    @SerializedName("2")
    public static final CmdType MessageLike = null;

    @SerializedName("21")
    public static final CmdType OnboardingBegin = null;

    @SerializedName("23")
    public static final CmdType OnboardingCancel = null;

    @SerializedName(BDLocationException.ERROR_AMAP_FAIL)
    public static final CmdType OnboardingFail = null;

    @SerializedName("31")
    public static final CmdType UserBanned = null;
    private final int value;

    static {
        CmdType r0 = new CmdType("MessageDelete", 0, 1);
        MessageDelete = r0;
        CmdType r1 = new CmdType("MessageLike", 1, 2);
        MessageLike = r1;
        CmdType r4 = new CmdType("MessageDislike", 2, 3);
        MessageDislike = r4;
        CmdType r6 = new CmdType("ConversationArchive", 3, 11);
        ConversationArchive = r6;
        CmdType r8 = new CmdType("ConversationAdd", 4, 12);
        ConversationAdd = r8;
        CmdType r10 = new CmdType("ConversationCreateSection", 5, 13);
        ConversationCreateSection = r10;
        CmdType r13 = new CmdType("ConversationClearHistory", 6, 14);
        ConversationClearHistory = r13;
        CmdType r11 = new CmdType("ConversationUpdate", 7, 15);
        ConversationUpdate = r11;
        CmdType r7 = new CmdType("OnboardingBegin", 8, 21);
        OnboardingBegin = r7;
        CmdType r5 = new CmdType("OnboardingFail", 9, 22);
        OnboardingFail = r5;
        CmdType r3 = new CmdType("OnboardingCancel", 10, 23);
        OnboardingCancel = r3;
        CmdType r2 = new CmdType("UserBanned", 11, 31);
        UserBanned = r2;
        $VALUES = new CmdType[]{r0, r1, r4, r6, r8, r10, r13, r11, r7, r5, r3, r2};
    }

    private CmdType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static CmdType findByValue(int r1) {
        if (r1 == 1) goto L37;
        if (r1 == 2) goto L35;
        if (r1 == 3) goto L33;
        if (r1 == 31) goto L31;
        switch(r1) {
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            default: goto L11;
        };
    L11:
        switch(r1) {
            case 21: goto L19;
            case 22: goto L17;
            case 23: goto L15;
            default: goto L12;
        };
    L12:
        return null;
    L15:
        return OnboardingCancel;
    L17:
        return OnboardingFail;
    L19:
        return OnboardingBegin;
    L21:
        return ConversationUpdate;
    L23:
        return ConversationClearHistory;
    L25:
        return ConversationCreateSection;
    L27:
        return ConversationAdd;
    L29:
        return ConversationArchive;
    L31:
        return UserBanned;
    L33:
        return MessageDislike;
    L35:
        return MessageLike;
    L37:
        return MessageDelete;
    }

    public static CmdType valueOf(String r2) {
        return (CmdType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CmdType.class, r2), CmdType.class, "com.obric.memorydata.plugin");
    }

    public static CmdType[] values() {
        return (CmdType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CmdType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
