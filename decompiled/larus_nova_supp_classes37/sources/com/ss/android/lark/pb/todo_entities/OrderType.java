package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OrderType extends Enum<OrderType> implements WireEnum {
    private static final /* synthetic */ OrderType[] $VALUES = null;
    public static final ProtoAdapter<OrderType> ADAPTER = null;
    public static final OrderType ASC = null;
    public static final OrderType DESC = null;
    private final int value;

    static {
        OrderType r0 = new OrderType("ASC", 0, 0);
        ASC = r0;
        OrderType r1 = new OrderType("DESC", 1, 1);
        DESC = r1;
        $VALUES = new OrderType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(OrderType.class);
    }

    public static OrderType[] values() {
        return (OrderType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static OrderType fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return DESC;
    L10:
        return ASC;
    }

    public static OrderType valueOf(String r1) {
        return (OrderType) a.a(OrderType.class, r1);
    }

    private OrderType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
