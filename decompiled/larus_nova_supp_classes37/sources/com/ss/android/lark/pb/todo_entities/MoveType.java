package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MoveType extends Enum<MoveType> implements WireEnum {
    private static final /* synthetic */ MoveType[] $VALUES = null;
    public static final ProtoAdapter<MoveType> ADAPTER = null;
    public static final MoveType ANTI_CONFLICT = null;
    public static final MoveType NORMAL = null;
    public static final MoveType UNKNOWN_MOVE_TYPE = null;
    public static final MoveType WHOLE = null;
    private final int value;

    static {
        MoveType r0 = new MoveType("UNKNOWN_MOVE_TYPE", 0, 0);
        UNKNOWN_MOVE_TYPE = r0;
        MoveType r1 = new MoveType("NORMAL", 1, 1);
        NORMAL = r1;
        MoveType r3 = new MoveType("WHOLE", 2, 2);
        WHOLE = r3;
        MoveType r5 = new MoveType("ANTI_CONFLICT", 3, 3);
        ANTI_CONFLICT = r5;
        $VALUES = new MoveType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(MoveType.class);
    }

    public static MoveType[] values() {
        return (MoveType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MoveType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return ANTI_CONFLICT;
    L14:
        return WHOLE;
    L16:
        return NORMAL;
    L18:
        return UNKNOWN_MOVE_TYPE;
    }

    public static MoveType valueOf(String r1) {
        return (MoveType) a.a(MoveType.class, r1);
    }

    private MoveType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
