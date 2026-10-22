package com.ss.android.lark.pb.settings;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserPermissionObjectType extends Enum<UserPermissionObjectType> implements WireEnum {
    private static final /* synthetic */ UserPermissionObjectType[] $VALUES = null;
    public static final ProtoAdapter<UserPermissionObjectType> ADAPTER = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_CHAT = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_TEAM = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_USER = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_USER_TYPE = null;
    private final int value;

    static {
        UserPermissionObjectType r0 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_USER", 0, 1);
        USER_PERMISSION_OBJECT_TYPE_USER = r0;
        UserPermissionObjectType r1 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_CHAT", 1, 2);
        USER_PERMISSION_OBJECT_TYPE_CHAT = r1;
        UserPermissionObjectType r4 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_USER_TYPE", 2, 3);
        USER_PERMISSION_OBJECT_TYPE_USER_TYPE = r4;
        UserPermissionObjectType r6 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_TEAM", 3, 4);
        USER_PERMISSION_OBJECT_TYPE_TEAM = r6;
        UserPermissionObjectType r8 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP", 4, 5);
        USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP = r8;
        $VALUES = new UserPermissionObjectType[]{r0, r1, r4, r6, r8};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserPermissionObjectType.class);
    }

    public static UserPermissionObjectType[] values() {
        return (UserPermissionObjectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserPermissionObjectType fromValue(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return null;
    L15:
        return USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP;
    L17:
        return USER_PERMISSION_OBJECT_TYPE_TEAM;
    L19:
        return USER_PERMISSION_OBJECT_TYPE_USER_TYPE;
    L21:
        return USER_PERMISSION_OBJECT_TYPE_CHAT;
    L23:
        return USER_PERMISSION_OBJECT_TYPE_USER;
    }

    public static UserPermissionObjectType valueOf(String r1) {
        return (UserPermissionObjectType) a.a(UserPermissionObjectType.class, r1);
    }

    private UserPermissionObjectType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
