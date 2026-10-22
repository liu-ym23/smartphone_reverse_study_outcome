package org.apache.poi.xwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.av;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.f;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFHeaderFooterPolicy {
    public static final STHdrFtr.Enum DEFAULT = null;
    public static final STHdrFtr.Enum EVEN = null;
    public static final STHdrFtr.Enum FIRST = null;
    private XWPFFooter defaultFooter;
    private XWPFHeader defaultHeader;
    private XWPFDocument doc;
    private XWPFFooter evenPageFooter;
    private XWPFHeader evenPageHeader;
    private XWPFFooter firstPageFooter;
    private XWPFHeader firstPageHeader;
    private dr sectPr;

    static {
        DEFAULT = STHdrFtr.d;
        EVEN = STHdrFtr.c;
        FIRST = STHdrFtr.e;
    }

    public XWPFHeaderFooterPolicy(XWPFDocument r2) {
        this(r2, null);
    }

    public XWPFHeaderFooterPolicy(XWPFDocument r8, dr r9) {
        dr r10 = (dr) ZeusTransformUtils.wrapperContextForParams(r9, dr.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L8;
        f r11 = r8.getDocument().getBody();
        if (r11.isSetSectPr() == false) goto L7;
        r10 = r11.getSectPr();
        goto L8
    L7:
        r10 = r11.addNewSectPr();
    L8:
        this.doc = r8;
        this.sectPr = r10;
        int r0 = 0;
        int r2 = 0;
    L9:
        XWPFHeader r4 = null;
        if (r2 >= r10.sizeOfHeaderReferenceArray()) goto L19;
        av r3 = r10.getHeaderReferenceArray(r2);
        POIXMLDocumentPart r5 = r8.getRelationById(r3.getId());
        if (ZeusTransformUtils.instanceOf(r5, XWPFHeader.class) == false) goto L31;
        r4 = (XWPFHeader) ZeusTransformUtils.preCheckCast(r5, XWPFHeader.class, "com.obric.memorydata.plugin");
    L31:
        STHdrFtr.Enum r6 = r3.getType();     // Catch: XmlValueOutOfRangeException -> L16
    L17:
        assignHeader(r4, r6);
        r2 = r2 + 1;
    L16:
        r6 = STHdrFtr.d;
    L19:
        if (r0 >= r10.sizeOfFooterReferenceArray()) goto L28;
        av r7 = r10.getFooterReferenceArray(r0);
        POIXMLDocumentPart r12 = r8.getRelationById(r7.getId());
        if (ZeusTransformUtils.instanceOf(r12, XWPFFooter.class) == false) goto L23;
        XWPFFooter r13 = (XWPFFooter) ZeusTransformUtils.preCheckCast(r12, XWPFFooter.class, "com.obric.memorydata.plugin");
    L29:
        STHdrFtr.Enum r14 = r7.getType();     // Catch: XmlValueOutOfRangeException -> L26
    L27:
        assignFooter(r13, r14);
        r0 = r0 + 1;
    L26:
        r14 = STHdrFtr.d;
        goto L27
    L23:
        r13 = null;
        goto L29
    }

    private void assignFooter(XWPFFooter r2, STHdrFtr.Enum r3) {
        if (r3 != STHdrFtr.e) goto L6;
        this.firstPageFooter = r2;
        return;
    L6:
        if (r3 != STHdrFtr.c) goto L8;
        this.evenPageFooter = r2;
        return;
    L8:
        this.defaultFooter = r2;
    }

    private void assignHeader(XWPFHeader r2, STHdrFtr.Enum r3) {
        if (r3 != STHdrFtr.e) goto L6;
        this.firstPageHeader = r2;
        return;
    L6:
        if (r3 != STHdrFtr.c) goto L8;
        this.evenPageHeader = r2;
        return;
    L8:
        this.defaultHeader = r2;
    }
}
