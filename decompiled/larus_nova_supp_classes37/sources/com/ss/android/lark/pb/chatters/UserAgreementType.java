package com.ss.android.lark.pb.chatters;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserAgreementType extends Enum<UserAgreementType> implements WireEnum {
    private static final /* synthetic */ UserAgreementType[] $VALUES = null;
    public static final ProtoAdapter<UserAgreementType> ADAPTER = null;
    public static final UserAgreementType PERSONAL_INFO_TRANSFER_TO_ABROAD = null;
    private final int value;

    static {
        UserAgreementType r0 = new UserAgreementType("PERSONAL_INFO_TRANSFER_TO_ABROAD", 0, 1);
        PERSONAL_INFO_TRANSFER_TO_ABROAD = r0;
        $VALUES = new UserAgreementType[]{r0};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserAgreementType.class);
    }

    public static UserAgreementType[] values() {
        return (UserAgreementType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserAgreementType fromValue(int r1) {
        if (r1 == 1) goto L7;
        return null;
    L7:
        return PERSONAL_INFO_TRANSFER_TO_ABROAD;
    }

    public static UserAgreementType valueOf(String r1) {
        return (UserAgreementType) a.a(UserAgreementType.class, r1);
    }

    private UserAgreementType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
