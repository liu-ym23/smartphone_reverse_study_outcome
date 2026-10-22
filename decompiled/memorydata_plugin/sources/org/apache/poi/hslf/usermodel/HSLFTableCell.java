package org.apache.poi.hslf.usermodel;

import org.apache.poi.ddf.AbstractEscherOptRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.sl.usermodel.TableCell;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFTableCell extends HSLFTextBox implements TableCell<HSLFShape, HSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    HSLFLine borderBottom;
    HSLFLine borderLeft;
    HSLFLine borderRight;
    HSLFLine borderTop;
    private int gridSpan;
    private int rowSpan;

    static {
    }

    public HSLFTableCell(EscherContainerRecord r1, HSLFTable r2) {
        super(r1, r2);
        this.gridSpan = 1;
        this.rowSpan = 1;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFTextBox, org.apache.poi.hslf.usermodel.HSLFSimpleShape, org.apache.poi.hslf.usermodel.HSLFShape
    public EscherContainerRecord createSpContainer(boolean r4) {
        EscherContainerRecord r5 = super.createSpContainer(r4);
        AbstractEscherOptRecord r3 = getEscherOptRecord();
        setEscherProperty(r3, EscherPropertyTypes.TEXT__TEXTID, 0);
        setEscherProperty(r3, EscherPropertyTypes.TEXT__SIZE_TEXT_TO_FIT_SHAPE, 131072);
        setEscherProperty(r3, EscherPropertyTypes.FILL__NOFILLHITTEST, 1376257);
        setEscherProperty(r3, EscherPropertyTypes.SHADOWSTYLE__SHADOWOBSURED, 131072);
        setEscherProperty(r3, EscherPropertyTypes.PROTECTION__LOCKAGAINSTGROUPING, 262144);
        return r5;
    }

    public void setGridSpan(int r1) {
        this.gridSpan = r1;
    }

    public void setRowSpan(int r1) {
        this.rowSpan = r1;
    }
}
