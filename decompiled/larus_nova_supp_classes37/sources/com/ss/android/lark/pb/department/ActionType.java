package com.ss.android.lark.pb.department;

import com.google.protobuf.server.EnumOptions;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ActionType extends Enum<ActionType> implements WireEnum {
    private static final /* synthetic */ ActionType[] $VALUES = null;
    public static final ProtoAdapter<ActionType> ADAPTER = null;
    public static final ActionType ActionType_Group_Chat = null;
    public static final ActionType ActionType_Secret_Group_Chat = null;
    public static final ActionType ActionType_UNKNOWN = null;
    public static final EnumOptions ENUM_OPTIONS = null;
    private final int value;

    static {
        ActionType r0 = new ActionType("ActionType_UNKNOWN", 0, 0);
        ActionType_UNKNOWN = r0;
        ActionType r1 = new ActionType("ActionType_Group_Chat", 1, 1);
        ActionType_Group_Chat = r1;
        ActionType r3 = new ActionType("ActionType_Secret_Group_Chat", 2, 2);
        ActionType_Secret_Group_Chat = r3;
        $VALUES = new ActionType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        ENUM_OPTIONS = new EnumOptions.Builder().deprecated(Boolean.TRUE).build();
    }

    public static ActionType[] values() {
        return (ActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActionType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return ActionType_Secret_Group_Chat;
    L12:
        return ActionType_Group_Chat;
    L14:
        return ActionType_UNKNOWN;
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    private ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
