package com.cronutils.model.field.value;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IntegerFieldValue extends FieldValue<Integer> {
    private static final long serialVersionUID = -1305795676868267699L;
    private final int value;

    @Override // com.cronutils.model.field.value.FieldValue
    public Integer getValue() {
        return Integer.valueOf(this.value);
    }

    @Override // com.cronutils.model.field.value.FieldValue
    public /* bridge */ /* synthetic */ Serializable getValue() {
        return getValue();
    }

    public IntegerFieldValue(int r1) {
        this.value = r1;
    }
}
