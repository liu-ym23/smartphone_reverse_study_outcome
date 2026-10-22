package com.ss.android.lark.pb.misc;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ActionType extends Enum<ActionType> implements WireEnum {
    private static final /* synthetic */ ActionType[] $VALUES = null;
    public static final ProtoAdapter<ActionType> ADAPTER = null;
    public static final ActionType ADD_CONTACT = null;
    public static final ActionType ALLOW_SETTING_AS_PUBLIC_GROUP = null;
    public static final ActionType BLOCK = null;
    public static final ActionType CALENDAR_PRIVATE_CHECK = null;
    public static final ActionType CCM_BOT_MESSAGE = null;
    public static final ActionType CCM_FEED_MESSAGE = null;
    public static final ActionType CCM_SEND_MESSAGE = null;
    public static final ActionType CHECK_BLOCK = null;
    public static final ActionType COOPERATION = null;
    public static final ActionType CRATE_P2P_CRYPTO_CHAT = null;
    public static final ActionType CREATE_P2P_CHAT = null;
    public static final ActionType CREATE_PRIVATE_CHAT_AND_INVITE = null;
    public static final ActionType CREATE_SINGLE_VIDEOCHAT = null;
    public static final ActionType DOC_SHARE_OR_CREATE = null;
    public static final ActionType INVITE_EVENT = null;
    public static final ActionType INVITE_SAME_CHAT = null;
    public static final ActionType INVITE_SAME_CROSS_TENANT_CHAT = null;
    public static final ActionType INVITE_SAME_CRYPTO_CHAT = null;
    public static final ActionType INVITE_VIDEO_CHAT = null;
    public static final ActionType JOIN_CHAT_VIA_SHARE = null;
    public static final ActionType MAKE_PHONE_CALL = null;
    public static final ActionType PRIVATE_CHAT = null;
    public static final ActionType PRIVATE_P2P_CHAT = null;
    public static final ActionType PRIVATE_SEND_PRIVATE_MESSAGE = null;
    public static final ActionType SEND_MESSAGE = null;
    public static final ActionType SEND_URGENT = null;
    public static final ActionType SHARE_EVENT = null;
    public static final ActionType SHARE_MESSAGE_SELECT_USER = null;
    public static final ActionType SHARE_NAME_CARD = null;
    public static final ActionType SHARE_VIDEO_CHAT = null;
    public static final ActionType TASK_ADD_MEMBER = null;
    public static final ActionType TRANSFER_EVENT = null;
    public static final ActionType UNKNOWN_ACTION = null;
    public static final ActionType VIEW_PERSONAL_STATUS = null;
    public static final ActionType VOIP_CALL = null;
    private final int value;

    static {
        ActionType r0 = new ActionType("UNKNOWN_ACTION", 0, 0);
        UNKNOWN_ACTION = r0;
        ActionType r1 = new ActionType("CREATE_P2P_CHAT", 1, 1);
        CREATE_P2P_CHAT = r1;
        ActionType r3 = new ActionType("INVITE_SAME_CHAT", 2, 2);
        INVITE_SAME_CHAT = r3;
        ActionType r5 = new ActionType("SEND_URGENT", 3, 3);
        SEND_URGENT = r5;
        ActionType r7 = new ActionType("SEND_MESSAGE", 4, 4);
        SEND_MESSAGE = r7;
        ActionType r9 = new ActionType("MAKE_PHONE_CALL", 5, 5);
        MAKE_PHONE_CALL = r9;
        ActionType r11 = new ActionType("CRATE_P2P_CRYPTO_CHAT", 6, 6);
        CRATE_P2P_CRYPTO_CHAT = r11;
        ActionType r13 = new ActionType("VIEW_PERSONAL_STATUS", 7, 7);
        VIEW_PERSONAL_STATUS = r13;
        ActionType r15 = new ActionType("VOIP_CALL", 8, 8);
        VOIP_CALL = r15;
        ActionType r14 = new ActionType("CREATE_SINGLE_VIDEOCHAT", 9, 9);
        CREATE_SINGLE_VIDEOCHAT = r14;
        ActionType r12 = new ActionType("INVITE_VIDEO_CHAT", 10, 10);
        INVITE_VIDEO_CHAT = r12;
        ActionType r10 = new ActionType("SHARE_VIDEO_CHAT", 11, 11);
        SHARE_VIDEO_CHAT = r10;
        ActionType r8 = new ActionType("INVITE_EVENT", 12, 12);
        INVITE_EVENT = r8;
        ActionType r6 = new ActionType("SHARE_EVENT", 13, 13);
        SHARE_EVENT = r6;
        ActionType r4 = new ActionType("TRANSFER_EVENT", 14, 14);
        TRANSFER_EVENT = r4;
        ActionType r2 = new ActionType("CCM_SEND_MESSAGE", 15, 15);
        CCM_SEND_MESSAGE = r2;
        ActionType r16 = new ActionType("CCM_BOT_MESSAGE", 16, 16);
        CCM_BOT_MESSAGE = r16;
        ActionType r17 = new ActionType("CCM_FEED_MESSAGE", 17, 17);
        CCM_FEED_MESSAGE = r17;
        ActionType r18 = new ActionType("INVITE_SAME_CRYPTO_CHAT", 18, 18);
        INVITE_SAME_CRYPTO_CHAT = r18;
        ActionType r19 = new ActionType("SHARE_MESSAGE_SELECT_USER", 19, 19);
        SHARE_MESSAGE_SELECT_USER = r19;
        ActionType r20 = new ActionType("DOC_SHARE_OR_CREATE", 20, 20);
        DOC_SHARE_OR_CREATE = r20;
        ActionType r21 = new ActionType("SHARE_NAME_CARD", 21, 21);
        SHARE_NAME_CARD = r21;
        ActionType r22 = new ActionType("CALENDAR_PRIVATE_CHECK", 22, 22);
        CALENDAR_PRIVATE_CHECK = r22;
        ActionType r23 = new ActionType("ADD_CONTACT", 23, 23);
        ADD_CONTACT = r23;
        ActionType r24 = new ActionType("JOIN_CHAT_VIA_SHARE", 24, 24);
        JOIN_CHAT_VIA_SHARE = r24;
        ActionType r25 = new ActionType("INVITE_SAME_CROSS_TENANT_CHAT", 25, 25);
        INVITE_SAME_CROSS_TENANT_CHAT = r25;
        ActionType r26 = new ActionType("BLOCK", 26, 30);
        BLOCK = r26;
        ActionType r27 = new ActionType("COOPERATION", 27, 31);
        COOPERATION = r27;
        ActionType r28 = new ActionType("ALLOW_SETTING_AS_PUBLIC_GROUP", 28, 32);
        ALLOW_SETTING_AS_PUBLIC_GROUP = r28;
        ActionType r29 = new ActionType("PRIVATE_CHAT", 29, 35);
        PRIVATE_CHAT = r29;
        ActionType r30 = new ActionType("PRIVATE_P2P_CHAT", 30, 36);
        PRIVATE_P2P_CHAT = r30;
        ActionType r31 = new ActionType("PRIVATE_SEND_PRIVATE_MESSAGE", 31, 37);
        PRIVATE_SEND_PRIVATE_MESSAGE = r31;
        ActionType r32 = new ActionType("CREATE_PRIVATE_CHAT_AND_INVITE", 32, 38);
        CREATE_PRIVATE_CHAT_AND_INVITE = r32;
        ActionType r33 = new ActionType("TASK_ADD_MEMBER", 33, 39);
        TASK_ADD_MEMBER = r33;
        ActionType r34 = new ActionType("CHECK_BLOCK", 34, 40);
        CHECK_BLOCK = r34;
        $VALUES = new ActionType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
        ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionType fromValue(int r0) {
        switch(r0) {
            case 0: goto L74;
            case 1: goto L72;
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L64;
            case 6: goto L62;
            case 7: goto L60;
            case 8: goto L58;
            case 9: goto L56;
            case 10: goto L54;
            case 11: goto L52;
            case 12: goto L50;
            case 13: goto L48;
            case 14: goto L46;
            case 15: goto L44;
            case 16: goto L42;
            case 17: goto L40;
            case 18: goto L38;
            case 19: goto L36;
            case 20: goto L34;
            case 21: goto L32;
            case 22: goto L30;
            case 23: goto L28;
            case 24: goto L26;
            case 25: goto L24;
            case 26: goto L3;
            case 27: goto L3;
            case 28: goto L3;
            case 29: goto L3;
            case 30: goto L22;
            case 31: goto L20;
            case 32: goto L18;
            case 33: goto L3;
            case 34: goto L3;
            case 35: goto L16;
            case 36: goto L14;
            case 37: goto L12;
            case 38: goto L10;
            case 39: goto L8;
            case 40: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CHECK_BLOCK;
    L8:
        return TASK_ADD_MEMBER;
    L10:
        return CREATE_PRIVATE_CHAT_AND_INVITE;
    L12:
        return PRIVATE_SEND_PRIVATE_MESSAGE;
    L14:
        return PRIVATE_P2P_CHAT;
    L16:
        return PRIVATE_CHAT;
    L18:
        return ALLOW_SETTING_AS_PUBLIC_GROUP;
    L20:
        return COOPERATION;
    L22:
        return BLOCK;
    L24:
        return INVITE_SAME_CROSS_TENANT_CHAT;
    L26:
        return JOIN_CHAT_VIA_SHARE;
    L28:
        return ADD_CONTACT;
    L30:
        return CALENDAR_PRIVATE_CHECK;
    L32:
        return SHARE_NAME_CARD;
    L34:
        return DOC_SHARE_OR_CREATE;
    L36:
        return SHARE_MESSAGE_SELECT_USER;
    L38:
        return INVITE_SAME_CRYPTO_CHAT;
    L40:
        return CCM_FEED_MESSAGE;
    L42:
        return CCM_BOT_MESSAGE;
    L44:
        return CCM_SEND_MESSAGE;
    L46:
        return TRANSFER_EVENT;
    L48:
        return SHARE_EVENT;
    L50:
        return INVITE_EVENT;
    L52:
        return SHARE_VIDEO_CHAT;
    L54:
        return INVITE_VIDEO_CHAT;
    L56:
        return CREATE_SINGLE_VIDEOCHAT;
    L58:
        return VOIP_CALL;
    L60:
        return VIEW_PERSONAL_STATUS;
    L62:
        return CRATE_P2P_CRYPTO_CHAT;
    L64:
        return MAKE_PHONE_CALL;
    L66:
        return SEND_MESSAGE;
    L68:
        return SEND_URGENT;
    L70:
        return INVITE_SAME_CHAT;
    L72:
        return CREATE_P2P_CHAT;
    L74:
        return UNKNOWN_ACTION;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    private ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
