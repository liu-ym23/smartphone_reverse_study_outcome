package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserType extends Enum<UserType> implements WireEnum {
    private static final /* synthetic */ UserType[] $VALUES = null;
    public static final ProtoAdapter<UserType> ADAPTER = null;
    public static final UserType UserTypeAnonymity = null;
    public static final UserType UserTypeApp = null;
    public static final UserType UserTypePeople = null;
    public static final UserType UserTypeTemp = null;
    public static final UserType UserTypeUnknown = null;
    private final int value;

    static {
        UserType r0 = new UserType("UserTypeUnknown", 0, 0);
        UserTypeUnknown = r0;
        UserType r1 = new UserType("UserTypeAnonymity", 1, 1);
        UserTypeAnonymity = r1;
        UserType r3 = new UserType("UserTypeTemp", 2, 2);
        UserTypeTemp = r3;
        UserType r5 = new UserType("UserTypeApp", 3, 3);
        UserTypeApp = r5;
        UserType r7 = new UserType("UserTypePeople", 4, 42);
        UserTypePeople = r7;
        $VALUES = new UserType[]{r0, r1, r3, r5, r7};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserType.class);
    }

    public static UserType[] values() {
        return (UserType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserType fromValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 42) goto L14;
        return null;
    L14:
        return UserTypePeople;
    L16:
        return UserTypeApp;
    L18:
        return UserTypeTemp;
    L20:
        return UserTypeAnonymity;
    L22:
        return UserTypeUnknown;
    }

    public static UserType valueOf(String r1) {
        return (UserType) a.a(UserType.class, r1);
    }

    private UserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
