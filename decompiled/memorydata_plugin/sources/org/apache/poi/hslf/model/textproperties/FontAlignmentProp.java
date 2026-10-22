package org.apache.poi.hslf.model.textproperties;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class FontAlignmentProp extends TextProp {
    public FontAlignmentProp() {
        super(2, 65536, "fontAlign");
    }

    public FontAlignmentProp(FontAlignmentProp r1) {
        super(r1);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public FontAlignmentProp copy() {
        return new FontAlignmentProp(this);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }

    public TextParagraph.FontAlign getFontAlign() {
        int r1 = getValue();
        if (r1 == 0) goto L19;
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L13;
        return TextParagraph.FontAlign.AUTO;
    L13:
        return TextParagraph.FontAlign.BOTTOM;
    L15:
        return TextParagraph.FontAlign.CENTER;
    L17:
        return TextParagraph.FontAlign.TOP;
    L19:
        return TextParagraph.FontAlign.BASELINE;
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$FontAlignmentProp$4T9ZaA6wSaQVXsZsVBM0b1Zpbps(this), "fontAlign", new $$Lambda$uavpnYZFxxqILV1v7aqyhZphiQA(this));
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FontAlignmentProp() {
        return super.getGenericProperties();
    }
}
