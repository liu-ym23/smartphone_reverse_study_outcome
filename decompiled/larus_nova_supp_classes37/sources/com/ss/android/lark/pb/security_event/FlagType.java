package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FlagType extends Enum<FlagType> implements WireEnum {
    private static final /* synthetic */ FlagType[] $VALUES = null;
    public static final ProtoAdapter<FlagType> ADAPTER = null;
    public static final FlagType FlagNormal = null;
    public static final FlagType FlagStress = null;
    public static final FlagType FlagTest = null;
    private final int value;

    static {
        FlagType r0 = new FlagType("FlagNormal", 0, 0);
        FlagNormal = r0;
        FlagType r1 = new FlagType("FlagTest", 1, 1);
        FlagTest = r1;
        FlagType r3 = new FlagType("FlagStress", 2, 2);
        FlagStress = r3;
        $VALUES = new FlagType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(FlagType.class);
    }

    public static FlagType[] values() {
        return (FlagType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlagType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return FlagStress;
    L12:
        return FlagTest;
    L14:
        return FlagNormal;
    }

    public static FlagType valueOf(String r1) {
        return (FlagType) a.a(FlagType.class, r1);
    }

    private FlagType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
