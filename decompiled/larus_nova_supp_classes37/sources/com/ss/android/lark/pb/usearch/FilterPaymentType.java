package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FilterPaymentType extends Enum<FilterPaymentType> implements WireEnum {
    private static final /* synthetic */ FilterPaymentType[] $VALUES = null;
    public static final ProtoAdapter<FilterPaymentType> ADAPTER = null;
    public static final FilterPaymentType FREE = null;
    public static final FilterPaymentType PAID = null;
    private final int value;

    static {
        FilterPaymentType r0 = new FilterPaymentType("FREE", 0, 1);
        FREE = r0;
        FilterPaymentType r1 = new FilterPaymentType("PAID", 1, 2);
        PAID = r1;
        $VALUES = new FilterPaymentType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterPaymentType.class);
    }

    public static FilterPaymentType[] values() {
        return (FilterPaymentType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterPaymentType fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return PAID;
    L11:
        return FREE;
    }

    public static FilterPaymentType valueOf(String r1) {
        return (FilterPaymentType) a.a(FilterPaymentType.class, r1);
    }

    private FilterPaymentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
