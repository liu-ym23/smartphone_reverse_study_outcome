package org.apache.poi.hslf.model.textproperties;

/* JADX INFO: loaded from: classes7.dex */
public class WrapFlagsTextProp extends BitMaskTextProp {
    public WrapFlagsTextProp() {
        super(2, 917504, "wrapFlags", new String[]{"charWrap", "wordWrap", "overflow"});
    }

    public WrapFlagsTextProp(WrapFlagsTextProp r1) {
        super(r1);
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ BitMaskTextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public WrapFlagsTextProp copy() {
        return new WrapFlagsTextProp(this);
    }
}
