package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PaymentType extends Enum<PaymentType> implements WireEnum {
    private static final /* synthetic */ PaymentType[] $VALUES = null;
    public static final ProtoAdapter<PaymentType> ADAPTER = null;
    public static final PaymentType Free = null;
    public static final PaymentType Paid = null;
    public static final PaymentType Redemption = null;
    private final int value;

    static {
        PaymentType r0 = new PaymentType("Free", 0, 0);
        Free = r0;
        PaymentType r1 = new PaymentType("Redemption", 1, 1);
        Redemption = r1;
        PaymentType r3 = new PaymentType("Paid", 2, 2);
        Paid = r3;
        $VALUES = new PaymentType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(PaymentType.class);
    }

    public static PaymentType[] values() {
        return (PaymentType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PaymentType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Paid;
    L12:
        return Redemption;
    L14:
        return Free;
    }

    public static PaymentType valueOf(String r1) {
        return (PaymentType) a.a(PaymentType.class, r1);
    }

    private PaymentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
