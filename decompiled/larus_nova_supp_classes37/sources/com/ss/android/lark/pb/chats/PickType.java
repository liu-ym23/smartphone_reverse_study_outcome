package com.ss.android.lark.pb.chats;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PickType extends Enum<PickType> implements WireEnum {
    private static final /* synthetic */ PickType[] $VALUES = null;
    public static final ProtoAdapter<PickType> ADAPTER = null;
    public static final PickType CHAT = null;
    public static final PickType DEPT = null;
    public static final PickType UNKNOWN = null;
    public static final PickType USER = null;
    private final int value;

    static {
        PickType r0 = new PickType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        PickType r1 = new PickType("USER", 1, 1);
        USER = r1;
        PickType r3 = new PickType("CHAT", 2, 2);
        CHAT = r3;
        PickType r5 = new PickType("DEPT", 3, 3);
        DEPT = r5;
        $VALUES = new PickType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(PickType.class);
    }

    public static PickType[] values() {
        return (PickType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PickType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return DEPT;
    L14:
        return CHAT;
    L16:
        return USER;
    L18:
        return UNKNOWN;
    }

    public static PickType valueOf(String r1) {
        return (PickType) a.a(PickType.class, r1);
    }

    private PickType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
