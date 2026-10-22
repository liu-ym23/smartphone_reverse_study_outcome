package org.apache.poi.hslf.model.textproperties;

/* JADX INFO: loaded from: classes7.dex */
public final class ParagraphFlagsTextProp extends BitMaskTextProp {
    public ParagraphFlagsTextProp() {
        super(2, 15, "paragraph_flags", new String[]{"bullet", "bullet.hardfont", "bullet.hardcolor", "bullet.hardsize"});
    }

    public ParagraphFlagsTextProp(ParagraphFlagsTextProp r1) {
        super(r1);
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ BitMaskTextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public ParagraphFlagsTextProp copy() {
        return new ParagraphFlagsTextProp(this);
    }

    @Override // org.apache.poi.hslf.model.textproperties.BitMaskTextProp, org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }
}
