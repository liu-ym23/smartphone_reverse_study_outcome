package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum BlockedFeature extends Enum<BlockedFeature> implements WireEnum {
    private static final /* synthetic */ BlockedFeature[] $VALUES = null;
    public static final ProtoAdapter<BlockedFeature> ADAPTER = null;
    public static final BlockedFeature ADD_MEMBER = null;
    public static final BlockedFeature BOT_POST = null;
    public static final BlockedFeature CHAT_MENU_TNS = null;
    public static final BlockedFeature CHAT_TAB = null;
    public static final BlockedFeature GROUP_TASK = null;
    public static final BlockedFeature MANAGE_BOT = null;
    public static final BlockedFeature MESSAGE_MENU = null;
    public static final BlockedFeature MODIFY_CHAT_INFO = null;
    public static final BlockedFeature REMOVE_MEMBER = null;
    public static final BlockedFeature UNKNOWN_BLOCKED_FEATURE = null;
    private final int value;

    static {
        BlockedFeature r0 = new BlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r0;
        BlockedFeature r1 = new BlockedFeature("ADD_MEMBER", 1, 1);
        ADD_MEMBER = r1;
        BlockedFeature r3 = new BlockedFeature("REMOVE_MEMBER", 2, 2);
        REMOVE_MEMBER = r3;
        BlockedFeature r5 = new BlockedFeature("CHAT_TAB", 3, 3);
        CHAT_TAB = r5;
        BlockedFeature r7 = new BlockedFeature("CHAT_MENU_TNS", 4, 4);
        CHAT_MENU_TNS = r7;
        BlockedFeature r9 = new BlockedFeature("MESSAGE_MENU", 5, 5);
        MESSAGE_MENU = r9;
        BlockedFeature r11 = new BlockedFeature("BOT_POST", 6, 6);
        BOT_POST = r11;
        BlockedFeature r13 = new BlockedFeature("MANAGE_BOT", 7, 7);
        MANAGE_BOT = r13;
        BlockedFeature r15 = new BlockedFeature("GROUP_TASK", 8, 8);
        GROUP_TASK = r15;
        BlockedFeature r14 = new BlockedFeature("MODIFY_CHAT_INFO", 9, 9);
        MODIFY_CHAT_INFO = r14;
        $VALUES = new BlockedFeature[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        ADAPTER = ProtoAdapter.newEnumAdapter(BlockedFeature.class);
    }

    public static BlockedFeature[] values() {
        return (BlockedFeature[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BlockedFeature fromValue(int r0) {
        switch(r0) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MODIFY_CHAT_INFO;
    L8:
        return GROUP_TASK;
    L10:
        return MANAGE_BOT;
    L12:
        return BOT_POST;
    L14:
        return MESSAGE_MENU;
    L16:
        return CHAT_MENU_TNS;
    L18:
        return CHAT_TAB;
    L20:
        return REMOVE_MEMBER;
    L22:
        return ADD_MEMBER;
    L24:
        return UNKNOWN_BLOCKED_FEATURE;
    }

    public static BlockedFeature valueOf(String r1) {
        return (BlockedFeature) a.a(BlockedFeature.class, r1);
    }

    private BlockedFeature(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
