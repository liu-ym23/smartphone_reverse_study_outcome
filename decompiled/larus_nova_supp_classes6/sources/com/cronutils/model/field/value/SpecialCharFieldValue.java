package com.cronutils.model.field.value;

import java.io.Serializable;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SpecialCharFieldValue extends FieldValue<SpecialChar> {
    private static final long serialVersionUID = -2177180413324528746L;
    private SpecialChar specialChar;

    @Override // com.cronutils.model.field.value.FieldValue
    public /* bridge */ /* synthetic */ Serializable getValue() {
        return getValue();
    }

    @Override // com.cronutils.model.field.value.FieldValue
    public SpecialChar getValue() {
        return this.specialChar;
    }

    public SpecialCharFieldValue(SpecialChar r2) {
        this.specialChar = SpecialChar.NONE;
        a.b(r2, "special char must not be null");
        this.specialChar = r2;
    }
}
