package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ConsumeType extends Enum<ConsumeType> implements WireEnum {
    private static final /* synthetic */ ConsumeType[] $VALUES = null;
    public static final ProtoAdapter<ConsumeType> ADAPTER = null;
    public static final ConsumeType ALL = null;
    public static final ConsumeType UNKNOWN = null;
    private final int value;

    static {
        ConsumeType r0 = new ConsumeType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ConsumeType r1 = new ConsumeType("ALL", 1, 1);
        ALL = r1;
        $VALUES = new ConsumeType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(ConsumeType.class);
    }

    public static ConsumeType[] values() {
        return (ConsumeType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConsumeType fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return ALL;
    L10:
        return UNKNOWN;
    }

    public static ConsumeType valueOf(String r1) {
        return (ConsumeType) a.a(ConsumeType.class, r1);
    }

    private ConsumeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
