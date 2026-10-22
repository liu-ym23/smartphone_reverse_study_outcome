package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ChatPostType extends Enum<ChatPostType> implements WireEnum {
    private static final /* synthetic */ ChatPostType[] $VALUES = null;
    public static final ProtoAdapter<ChatPostType> ADAPTER = null;
    public static final ChatPostType ANYONE = null;
    public static final ChatPostType ONLY_ADMIN = null;
    public static final ChatPostType UNKNOWN_POST_TYPE = null;
    public static final ChatPostType WHITE_LIST = null;
    private final int value;

    static {
        ChatPostType r0 = new ChatPostType("UNKNOWN_POST_TYPE", 0, 0);
        UNKNOWN_POST_TYPE = r0;
        ChatPostType r1 = new ChatPostType("ANYONE", 1, 1);
        ANYONE = r1;
        ChatPostType r3 = new ChatPostType("ONLY_ADMIN", 2, 2);
        ONLY_ADMIN = r3;
        ChatPostType r5 = new ChatPostType("WHITE_LIST", 3, 3);
        WHITE_LIST = r5;
        $VALUES = new ChatPostType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatPostType.class);
    }

    public static ChatPostType[] values() {
        return (ChatPostType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatPostType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return WHITE_LIST;
    L14:
        return ONLY_ADMIN;
    L16:
        return ANYONE;
    L18:
        return UNKNOWN_POST_TYPE;
    }

    public static ChatPostType valueOf(String r1) {
        return (ChatPostType) a.a(ChatPostType.class, r1);
    }

    private ChatPostType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
