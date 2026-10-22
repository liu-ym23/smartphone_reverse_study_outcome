package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.types.CHPAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class CharacterProperties extends CHPAbstractType {
    public CharacterProperties() {
        setFUsePgsuSettings(true);
        setXstDispFldRMark(new byte[36]);
    }

    public CharacterProperties(CharacterProperties r1) {
        super(r1);
    }

    public CharacterProperties copy() {
        return new CharacterProperties(this);
    }
}
