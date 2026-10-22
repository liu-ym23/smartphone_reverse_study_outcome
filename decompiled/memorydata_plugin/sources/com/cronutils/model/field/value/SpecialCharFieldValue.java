package com.cronutils.model.field.value;

import com.cronutils.utils.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialCharFieldValue extends FieldValue<SpecialChar> {
    private static final long serialVersionUID = -2177180413324528746L;
    private SpecialChar specialChar;

    public SpecialCharFieldValue(SpecialChar r2) {
        this.specialChar = SpecialChar.NONE;
        a.a(r2, "special char must not be null");
        this.specialChar = r2;
    }

    @Override // com.cronutils.model.field.value.FieldValue
    public SpecialChar getValue() {
        return this.specialChar;
    }

    @Override // com.cronutils.model.field.value.FieldValue
    public /* bridge */ /* synthetic */ Serializable getValue() {
        return getValue();
    }
}
