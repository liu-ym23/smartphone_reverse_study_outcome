package org.apache.poi.hwpf.usermodel;

import org.apache.poi.hwpf.model.types.PAPAbstractType;

/* JADX INFO: loaded from: classes7.dex */
public final class ParagraphProperties extends PAPAbstractType {
    private boolean jcLogical;

    public ParagraphProperties() {
        setAnld(new byte[84]);
        setPhe(new byte[12]);
    }

    public ParagraphProperties(ParagraphProperties r1) {
        super(r1);
        this.jcLogical = r1.jcLogical;
    }

    public ParagraphProperties copy() {
        return new ParagraphProperties(this);
    }

    public void setJustificationLogical(byte r1) {
        super.setJc(r1);
        this.jcLogical = true;
    }

    public void setShading(ShadingDescriptor r1) {
        super.setShd(r1);
    }
}
