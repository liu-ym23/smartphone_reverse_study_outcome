package org.apache.poi.hslf.usermodel;

import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.hslf.record.SheetContainer;
import org.apache.poi.sl.usermodel.MasterSheet;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFMasterSheet extends HSLFSheet implements MasterSheet<HSLFShape, HSLFTextParagraph> {
    public HSLFMasterSheet(SheetContainer r1, int r2) {
        super(r1, r2);
    }

    public abstract TextPropCollection getPropCollection(int r1, int r2, String r3, boolean r4);
}
