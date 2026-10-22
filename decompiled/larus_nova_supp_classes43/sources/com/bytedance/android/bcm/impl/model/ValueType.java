package com.bytedance.android.bcm.impl.model;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/bcm/impl/model/ValueType;", "", "", a.KEY_LUBAN_VALUE, "I", "getValue", "()I", "UNDEFINED", "INT", "STRING", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ValueType extends Enum<ValueType> {
    public static final ValueType INT = null;
    public static final ValueType STRING = null;
    public static final ValueType UNDEFINED = null;
    public static final /* synthetic */ ValueType[] a = null;
    private final int value;

    static {
        ValueType r1 = new ValueType("UNDEFINED", 0, 0);
        UNDEFINED = r1;
        ValueType r10 = new ValueType("INT", 1, 1);
        INT = r10;
        ValueType r11 = new ValueType("STRING", 2, 2);
        STRING = r11;
        a = new ValueType[]{r1, r10, r11};
    }

    public static ValueType valueOf(String r1) {
        return (ValueType) r27.a.a(ValueType.class, r1);
    }

    public static ValueType[] values() {
        return (ValueType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ValueType(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
