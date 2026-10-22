package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PermissionActionType extends Enum<PermissionActionType> implements WireEnum {
    private static final /* synthetic */ PermissionActionType[] $VALUES = null;
    public static final ProtoAdapter<PermissionActionType> ADAPTER = null;
    public static final PermissionActionType AddChat = null;
    public static final PermissionActionType AddDepartment = null;
    public static final PermissionActionType AddUser = null;
    public static final PermissionActionType PermissionActionTypeUnknown = null;
    public static final PermissionActionType RemoveChat = null;
    public static final PermissionActionType RemoveDepartment = null;
    public static final PermissionActionType RemoveUser = null;
    private final int value;

    static {
        PermissionActionType r0 = new PermissionActionType("PermissionActionTypeUnknown", 0, 0);
        PermissionActionTypeUnknown = r0;
        PermissionActionType r1 = new PermissionActionType("AddUser", 1, 1);
        AddUser = r1;
        PermissionActionType r3 = new PermissionActionType("RemoveUser", 2, 2);
        RemoveUser = r3;
        PermissionActionType r5 = new PermissionActionType("AddChat", 3, 3);
        AddChat = r5;
        PermissionActionType r7 = new PermissionActionType("RemoveChat", 4, 4);
        RemoveChat = r7;
        PermissionActionType r9 = new PermissionActionType("AddDepartment", 5, 5);
        AddDepartment = r9;
        PermissionActionType r11 = new PermissionActionType("RemoveDepartment", 6, 6);
        RemoveDepartment = r11;
        $VALUES = new PermissionActionType[]{r0, r1, r3, r5, r7, r9, r11};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionActionType.class);
    }

    public static PermissionActionType[] values() {
        return (PermissionActionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PermissionActionType fromValue(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RemoveDepartment;
    L8:
        return AddDepartment;
    L10:
        return RemoveChat;
    L12:
        return AddChat;
    L14:
        return RemoveUser;
    L16:
        return AddUser;
    L18:
        return PermissionActionTypeUnknown;
    }

    public static PermissionActionType valueOf(String r1) {
        return (PermissionActionType) a.a(PermissionActionType.class, r1);
    }

    private PermissionActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
