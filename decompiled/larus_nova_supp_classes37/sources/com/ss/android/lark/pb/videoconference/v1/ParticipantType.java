package com.ss.android.lark.pb.videoconference.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ParticipantType extends Enum<ParticipantType> implements WireEnum {
    private static final /* synthetic */ ParticipantType[] $VALUES = null;
    public static final ProtoAdapter<ParticipantType> ADAPTER = null;
    public static final ParticipantType DOC_USER = null;
    public static final ParticipantType LARK_USER = null;
    public static final ParticipantType NEO_GUEST_USER = null;
    public static final ParticipantType NEO_USER = null;
    public static final ParticipantType PSTN_USER = null;
    public static final ParticipantType RESERVED_USER_1 = null;
    public static final ParticipantType RESERVED_USER_10 = null;
    public static final ParticipantType RESERVED_USER_11 = null;
    public static final ParticipantType RESERVED_USER_12 = null;
    public static final ParticipantType RESERVED_USER_13 = null;
    public static final ParticipantType RESERVED_USER_14 = null;
    public static final ParticipantType RESERVED_USER_15 = null;
    public static final ParticipantType RESERVED_USER_16 = null;
    public static final ParticipantType RESERVED_USER_17 = null;
    public static final ParticipantType RESERVED_USER_18 = null;
    public static final ParticipantType RESERVED_USER_19 = null;
    public static final ParticipantType RESERVED_USER_2 = null;
    public static final ParticipantType RESERVED_USER_20 = null;
    public static final ParticipantType RESERVED_USER_3 = null;
    public static final ParticipantType RESERVED_USER_4 = null;
    public static final ParticipantType RESERVED_USER_5 = null;
    public static final ParticipantType RESERVED_USER_6 = null;
    public static final ParticipantType RESERVED_USER_7 = null;
    public static final ParticipantType RESERVED_USER_8 = null;
    public static final ParticipantType RESERVED_USER_9 = null;
    public static final ParticipantType ROOM = null;
    public static final ParticipantType SIP_USER = null;
    public static final ParticipantType UNKNOW = null;
    private final int value;

    static {
        ParticipantType r0 = new ParticipantType("UNKNOW", 0, 0);
        UNKNOW = r0;
        ParticipantType r1 = new ParticipantType("LARK_USER", 1, 1);
        LARK_USER = r1;
        ParticipantType r3 = new ParticipantType("ROOM", 2, 2);
        ROOM = r3;
        ParticipantType r5 = new ParticipantType("DOC_USER", 3, 3);
        DOC_USER = r5;
        ParticipantType r7 = new ParticipantType("NEO_USER", 4, 4);
        NEO_USER = r7;
        ParticipantType r9 = new ParticipantType("NEO_GUEST_USER", 5, 5);
        NEO_GUEST_USER = r9;
        ParticipantType r11 = new ParticipantType("PSTN_USER", 6, 6);
        PSTN_USER = r11;
        ParticipantType r13 = new ParticipantType("SIP_USER", 7, 7);
        SIP_USER = r13;
        ParticipantType r15 = new ParticipantType("RESERVED_USER_1", 8, 8);
        RESERVED_USER_1 = r15;
        ParticipantType r14 = new ParticipantType("RESERVED_USER_2", 9, 9);
        RESERVED_USER_2 = r14;
        ParticipantType r12 = new ParticipantType("RESERVED_USER_3", 10, 10);
        RESERVED_USER_3 = r12;
        ParticipantType r10 = new ParticipantType("RESERVED_USER_4", 11, 11);
        RESERVED_USER_4 = r10;
        ParticipantType r8 = new ParticipantType("RESERVED_USER_5", 12, 12);
        RESERVED_USER_5 = r8;
        ParticipantType r6 = new ParticipantType("RESERVED_USER_6", 13, 13);
        RESERVED_USER_6 = r6;
        ParticipantType r4 = new ParticipantType("RESERVED_USER_7", 14, 14);
        RESERVED_USER_7 = r4;
        ParticipantType r2 = new ParticipantType("RESERVED_USER_8", 15, 15);
        RESERVED_USER_8 = r2;
        ParticipantType r16 = new ParticipantType("RESERVED_USER_9", 16, 16);
        RESERVED_USER_9 = r16;
        ParticipantType r17 = new ParticipantType("RESERVED_USER_10", 17, 17);
        RESERVED_USER_10 = r17;
        ParticipantType r18 = new ParticipantType("RESERVED_USER_11", 18, 18);
        RESERVED_USER_11 = r18;
        ParticipantType r19 = new ParticipantType("RESERVED_USER_12", 19, 19);
        RESERVED_USER_12 = r19;
        ParticipantType r20 = new ParticipantType("RESERVED_USER_13", 20, 20);
        RESERVED_USER_13 = r20;
        ParticipantType r21 = new ParticipantType("RESERVED_USER_14", 21, 21);
        RESERVED_USER_14 = r21;
        ParticipantType r22 = new ParticipantType("RESERVED_USER_15", 22, 22);
        RESERVED_USER_15 = r22;
        ParticipantType r23 = new ParticipantType("RESERVED_USER_16", 23, 23);
        RESERVED_USER_16 = r23;
        ParticipantType r24 = new ParticipantType("RESERVED_USER_17", 24, 24);
        RESERVED_USER_17 = r24;
        ParticipantType r25 = new ParticipantType("RESERVED_USER_18", 25, 25);
        RESERVED_USER_18 = r25;
        ParticipantType r26 = new ParticipantType("RESERVED_USER_19", 26, 26);
        RESERVED_USER_19 = r26;
        ParticipantType r27 = new ParticipantType("RESERVED_USER_20", 27, 27);
        RESERVED_USER_20 = r27;
        $VALUES = new ParticipantType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
        ADAPTER = ProtoAdapter.newEnumAdapter(ParticipantType.class);
    }

    public static ParticipantType[] values() {
        return (ParticipantType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ParticipantType fromValue(int r0) {
        switch(r0) {
            case 0: goto L60;
            case 1: goto L58;
            case 2: goto L56;
            case 3: goto L54;
            case 4: goto L52;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            case 8: goto L44;
            case 9: goto L42;
            case 10: goto L40;
            case 11: goto L38;
            case 12: goto L36;
            case 13: goto L34;
            case 14: goto L32;
            case 15: goto L30;
            case 16: goto L28;
            case 17: goto L26;
            case 18: goto L24;
            case 19: goto L22;
            case 20: goto L20;
            case 21: goto L18;
            case 22: goto L16;
            case 23: goto L14;
            case 24: goto L12;
            case 25: goto L10;
            case 26: goto L8;
            case 27: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RESERVED_USER_20;
    L8:
        return RESERVED_USER_19;
    L10:
        return RESERVED_USER_18;
    L12:
        return RESERVED_USER_17;
    L14:
        return RESERVED_USER_16;
    L16:
        return RESERVED_USER_15;
    L18:
        return RESERVED_USER_14;
    L20:
        return RESERVED_USER_13;
    L22:
        return RESERVED_USER_12;
    L24:
        return RESERVED_USER_11;
    L26:
        return RESERVED_USER_10;
    L28:
        return RESERVED_USER_9;
    L30:
        return RESERVED_USER_8;
    L32:
        return RESERVED_USER_7;
    L34:
        return RESERVED_USER_6;
    L36:
        return RESERVED_USER_5;
    L38:
        return RESERVED_USER_4;
    L40:
        return RESERVED_USER_3;
    L42:
        return RESERVED_USER_2;
    L44:
        return RESERVED_USER_1;
    L46:
        return SIP_USER;
    L48:
        return PSTN_USER;
    L50:
        return NEO_GUEST_USER;
    L52:
        return NEO_USER;
    L54:
        return DOC_USER;
    L56:
        return ROOM;
    L58:
        return LARK_USER;
    L60:
        return UNKNOW;
    }

    public static ParticipantType valueOf(String r1) {
        return (ParticipantType) a.a(ParticipantType.class, r1);
    }

    private ParticipantType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
