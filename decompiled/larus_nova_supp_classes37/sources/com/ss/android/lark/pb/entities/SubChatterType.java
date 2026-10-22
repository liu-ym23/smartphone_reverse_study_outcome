package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SubChatterType extends Enum<SubChatterType> implements WireEnum {
    private static final /* synthetic */ SubChatterType[] $VALUES = null;
    public static final ProtoAdapter<SubChatterType> ADAPTER = null;
    public static final SubChatterType AI_COMMON = null;
    public static final SubChatterType BOT_COMMON = null;
    public static final SubChatterType DOUBAO_COMMON = null;
    public static final SubChatterType UNKNOWN_SUB_CHATTER = null;
    public static final SubChatterType USER_AGENT_EMPLOYEE = null;
    public static final SubChatterType USER_ANONYMOUS = null;
    public static final SubChatterType USER_COMMON = null;
    private final int value;

    static {
        SubChatterType r0 = new SubChatterType("UNKNOWN_SUB_CHATTER", 0, 0);
        UNKNOWN_SUB_CHATTER = r0;
        SubChatterType r1 = new SubChatterType("USER_COMMON", 1, 10001);
        USER_COMMON = r1;
        SubChatterType r3 = new SubChatterType("USER_ANONYMOUS", 2, 10002);
        USER_ANONYMOUS = r3;
        SubChatterType r4 = new SubChatterType("USER_AGENT_EMPLOYEE", 3, 10003);
        USER_AGENT_EMPLOYEE = r4;
        SubChatterType r6 = new SubChatterType("BOT_COMMON", 4, 20001);
        BOT_COMMON = r6;
        SubChatterType r8 = new SubChatterType("AI_COMMON", 5, 30001);
        AI_COMMON = r8;
        SubChatterType r10 = new SubChatterType("DOUBAO_COMMON", 6, 40001);
        DOUBAO_COMMON = r10;
        $VALUES = new SubChatterType[]{r0, r1, r3, r4, r6, r8, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(SubChatterType.class);
    }

    public static SubChatterType[] values() {
        return (SubChatterType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SubChatterType fromValue(int r1) {
        if (r1 == 0) goto L25;
        if (r1 == 20001) goto L23;
        if (r1 == 30001) goto L21;
        if (r1 == 40001) goto L19;
        switch(r1) {
            case 10001: goto L17;
            case 10002: goto L15;
            case 10003: goto L13;
            default: goto L10;
        };
    L10:
        return null;
    L13:
        return USER_AGENT_EMPLOYEE;
    L15:
        return USER_ANONYMOUS;
    L17:
        return USER_COMMON;
    L19:
        return DOUBAO_COMMON;
    L21:
        return AI_COMMON;
    L23:
        return BOT_COMMON;
    L25:
        return UNKNOWN_SUB_CHATTER;
    }

    public static SubChatterType valueOf(String r1) {
        return (SubChatterType) a.a(SubChatterType.class, r1);
    }

    private SubChatterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
