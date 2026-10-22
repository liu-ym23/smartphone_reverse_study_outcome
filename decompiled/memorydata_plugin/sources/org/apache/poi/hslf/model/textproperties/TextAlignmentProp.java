package org.apache.poi.hslf.model.textproperties;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class TextAlignmentProp extends TextProp {
    public TextAlignmentProp() {
        super(2, 2048, "alignment");
    }

    public TextAlignmentProp(TextAlignmentProp r1) {
        super(r1);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public TextAlignmentProp copy() {
        return new TextAlignmentProp(this);
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp
    public /* bridge */ /* synthetic */ TextProp copy() {
        return copy();
    }

    @Override // org.apache.poi.hslf.model.textproperties.TextProp, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$TextAlignmentProp$cINUBxQMEq3iS3DHaHmFOS9D7M(this), "textAlign", new $$Lambda$abG1YnuwVlAZdwg9UMGloMo6icw(this));
    }

    public TextParagraph.TextAlign getTextAlign() {
        int r1 = getValue();
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return TextParagraph.TextAlign.LEFT;
    L15:
        return TextParagraph.TextAlign.THAI_DIST;
    L17:
        return TextParagraph.TextAlign.DIST;
    L19:
        return TextParagraph.TextAlign.JUSTIFY;
    L21:
        return TextParagraph.TextAlign.RIGHT;
    L23:
        return TextParagraph.TextAlign.CENTER;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TextAlignmentProp() {
        return super.getGenericProperties();
    }
}
