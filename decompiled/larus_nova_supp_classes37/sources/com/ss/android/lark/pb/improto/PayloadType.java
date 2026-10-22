package com.ss.android.lark.pb.improto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PayloadType extends Enum<PayloadType> implements WireEnum {
    private static final /* synthetic */ PayloadType[] $VALUES = null;
    public static final ProtoAdapter<PayloadType> ADAPTER = null;
    public static final PayloadType JSON = null;
    public static final PayloadType PB2 = null;
    public static final PayloadType TYPE_UNKNOWN = null;
    private final int value;

    static {
        PayloadType r0 = new PayloadType("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r0;
        PayloadType r1 = new PayloadType("PB2", 1, 1);
        PB2 = r1;
        PayloadType r3 = new PayloadType("JSON", 2, 2);
        JSON = r3;
        $VALUES = new PayloadType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(PayloadType.class);
    }

    public static PayloadType[] values() {
        return (PayloadType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PayloadType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return JSON;
    L12:
        return PB2;
    L14:
        return TYPE_UNKNOWN;
    }

    public static PayloadType valueOf(String r1) {
        return (PayloadType) a.a(PayloadType.class, r1);
    }

    private PayloadType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
