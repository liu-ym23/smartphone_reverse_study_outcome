package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.cs;
import org.openxmlformats.schemas.drawingml.x2006.main.df;
import org.openxmlformats.schemas.drawingml.x2006.main.dv;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTableCell extends XSLFTextShape implements TableCell<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int col;
    private int row;
    private final XSLFTable table;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTableCell$1, reason: invalid class name */
    class AnonymousClass1 implements StrokeStyle {
    }

    private final class XSLFCellTextParagraph extends XSLFTextParagraph {
        final /* synthetic */ XSLFTableCell this$0;

        private XSLFCellTextParagraph(XSLFTableCell r3, dv r4, XSLFTextShape r5) {
            dv r6 = (dv) ZeusTransformUtils.wrapperContextForParams(r4, dv.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r6, r5);
        }

        /* synthetic */ XSLFCellTextParagraph(XSLFTableCell r2, dv r3, XSLFTextShape r4, AnonymousClass1 r5) {
            this(r2, (dv) ZeusTransformUtils.wrapperContextForParams(r3, dv.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
    }

    XSLFTableCell(cs r3, XSLFTable r4) {
        super((cs) ZeusTransformUtils.wrapperContextForParams(r3, cs.class, "com.obric.memorydata.plugin"), r4.getSheet());
        this.table = r4;
    }

    private cs getCell() {
        return (cs) ZeusTransformUtils.preCheckCast(getXmlObject(), cs.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public df getTextBody(boolean r3) {
        cs r0 = getCell();
        df r1 = r0.getTxBody();
        if (r1 != null) goto L7;
        if (r3 == false) goto L8;
        r0.setTxBody(new XDDFTextBody(this).getXmlObject());
        return r0.getTxBody();
    L8:
        return r1;
    L7:
        return r1;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public XSLFCellTextParagraph newTextParagraph(dv r3) {
        return new XSLFCellTextParagraph(this, (dv) ZeusTransformUtils.wrapperContextForParams(r3, dv.class, "com.obric.memorydata.plugin"), this, null);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public /* synthetic */ XSLFTextParagraph newTextParagraph(dv r3) {
        return newTextParagraph((dv) ZeusTransformUtils.wrapperContextForParams(r3, dv.class, "com.obric.memorydata.plugin"));
    }

    void setRowColIndex(int r1, int r2) {
        this.row = r1;
        this.col = r2;
    }
}
