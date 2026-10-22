package com.ss.android.lark.pb.users;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserUpdatePermission extends Enum<UserUpdatePermission> implements WireEnum {
    private static final /* synthetic */ UserUpdatePermission[] $VALUES = null;
    public static final ProtoAdapter<UserUpdatePermission> ADAPTER = null;
    public static final UserUpdatePermission Avatar = null;
    private final int value;

    static {
        UserUpdatePermission r0 = new UserUpdatePermission("Avatar", 0, 1);
        Avatar = r0;
        $VALUES = new UserUpdatePermission[]{r0};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserUpdatePermission.class);
    }

    public static UserUpdatePermission[] values() {
        return (UserUpdatePermission[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserUpdatePermission fromValue(int r1) {
        if (r1 == 1) goto L7;
        return null;
    L7:
        return Avatar;
    }

    public static UserUpdatePermission valueOf(String r1) {
        return (UserUpdatePermission) a.a(UserUpdatePermission.class, r1);
    }

    private UserUpdatePermission(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
