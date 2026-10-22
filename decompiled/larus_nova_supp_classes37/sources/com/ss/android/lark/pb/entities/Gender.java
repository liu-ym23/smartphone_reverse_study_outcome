package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Gender extends Enum<Gender> implements WireEnum {
    private static final /* synthetic */ Gender[] $VALUES = null;
    public static final ProtoAdapter<Gender> ADAPTER = null;
    public static final Gender DEFAULT = null;
    public static final Gender MAN = null;
    public static final Gender WOMAN = null;
    private final int value;

    static {
        Gender r0 = new Gender("DEFAULT", 0, 0);
        DEFAULT = r0;
        Gender r1 = new Gender("MAN", 1, 1);
        MAN = r1;
        Gender r3 = new Gender("WOMAN", 2, 2);
        WOMAN = r3;
        $VALUES = new Gender[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(Gender.class);
    }

    public static Gender[] values() {
        return (Gender[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Gender fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return WOMAN;
    L12:
        return MAN;
    L14:
        return DEFAULT;
    }

    public static Gender valueOf(String r1) {
        return (Gender) a.a(Gender.class, r1);
    }

    private Gender(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
