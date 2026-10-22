package org.apache.poi.hslf.model.textproperties;

/* JADX INFO: loaded from: classes7.dex */
public class CharFlagsTextProp extends BitMaskTextProp {
    public CharFlagsTextProp() {
        super(2, 65535, "char_flags", new String[]{"bold", "italic", "underline", "unused1", "shadow", "fehint", "unused2", "kumi", "strikethrough", "emboss", "pp9rt_1", "pp9rt_2", "pp9rt_3", "pp9rt_4", "unused4_1", "unused4_2"});
    }

    public CharFlagsTextProp(CharFlagsTextProp r1) {
        super(r1);
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ BitMaskTextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public CharFlagsTextProp copy() {
        return new CharFlagsTextProp(this);
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }
}
