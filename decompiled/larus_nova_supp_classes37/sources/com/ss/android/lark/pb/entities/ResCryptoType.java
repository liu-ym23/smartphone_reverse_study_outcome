package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ResCryptoType extends Enum<ResCryptoType> implements WireEnum {
    private static final /* synthetic */ ResCryptoType[] $VALUES = null;
    public static final ProtoAdapter<ResCryptoType> ADAPTER = null;
    public static final ResCryptoType BY_CLIENT = null;
    public static final ResCryptoType BY_FKMS = null;
    public static final ResCryptoType BY_SERVER = null;
    public static final ResCryptoType NOT = null;
    private final int value;

    static {
        ResCryptoType r0 = new ResCryptoType("NOT", 0, 0);
        NOT = r0;
        ResCryptoType r1 = new ResCryptoType("BY_CLIENT", 1, 1);
        BY_CLIENT = r1;
        ResCryptoType r3 = new ResCryptoType("BY_FKMS", 2, 2);
        BY_FKMS = r3;
        ResCryptoType r5 = new ResCryptoType("BY_SERVER", 3, 3);
        BY_SERVER = r5;
        $VALUES = new ResCryptoType[]{r0, r1, r3, r5};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResCryptoType.class);
    }

    public static ResCryptoType[] values() {
        return (ResCryptoType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResCryptoType fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return BY_SERVER;
    L14:
        return BY_FKMS;
    L16:
        return BY_CLIENT;
    L18:
        return NOT;
    }

    public static ResCryptoType valueOf(String r1) {
        return (ResCryptoType) a.a(ResCryptoType.class, r1);
    }

    private ResCryptoType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
