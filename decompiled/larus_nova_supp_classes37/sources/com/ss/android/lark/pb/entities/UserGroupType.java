package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserGroupType extends Enum<UserGroupType> implements WireEnum {
    private static final /* synthetic */ UserGroupType[] $VALUES = null;
    public static final ProtoAdapter<UserGroupType> ADAPTER = null;
    public static final UserGroupType UserGroupType_ASSIGN = null;
    public static final UserGroupType UserGroupType_DYNAMIC = null;
    public static final UserGroupType UserGroupType_UNKNOWN = null;
    private final int value;

    static {
        UserGroupType r0 = new UserGroupType("UserGroupType_UNKNOWN", 0, 0);
        UserGroupType_UNKNOWN = r0;
        UserGroupType r1 = new UserGroupType("UserGroupType_ASSIGN", 1, 1);
        UserGroupType_ASSIGN = r1;
        UserGroupType r3 = new UserGroupType("UserGroupType_DYNAMIC", 2, 2);
        UserGroupType_DYNAMIC = r3;
        $VALUES = new UserGroupType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserGroupType.class);
    }

    public static UserGroupType[] values() {
        return (UserGroupType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserGroupType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return UserGroupType_DYNAMIC;
    L12:
        return UserGroupType_ASSIGN;
    L14:
        return UserGroupType_UNKNOWN;
    }

    public static UserGroupType valueOf(String r1) {
        return (UserGroupType) a.a(UserGroupType.class, r1);
    }

    private UserGroupType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
