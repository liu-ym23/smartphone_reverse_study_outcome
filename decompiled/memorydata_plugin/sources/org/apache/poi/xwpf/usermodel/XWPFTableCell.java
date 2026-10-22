package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dp;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ew;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFTableCell implements IBody, ICell {
    private static final EnumMap<XWPFVertAlign, STVerticalJc.Enum> alignMap = null;
    private static final HashMap<Integer, XWPFVertAlign> stVertAlignTypeMap = null;
    protected List<IBodyElement> bodyElements;
    private final ew ctTc;
    protected List<XWPFParagraph> paragraphs;
    protected IBody part;
    private final XWPFTableRow tableRow;
    protected List<XWPFTable> tables;

    public static final enum XWPFVertAlign extends Enum<XWPFVertAlign> {
        private static final /* synthetic */ XWPFVertAlign[] $VALUES = null;
        public static final XWPFVertAlign BOTH = null;
        public static final XWPFVertAlign BOTTOM = null;
        public static final XWPFVertAlign CENTER = null;
        public static final XWPFVertAlign TOP = null;

        static {
            XWPFVertAlign r0 = new XWPFVertAlign("TOP", 0);
            TOP = r0;
            XWPFVertAlign r1 = new XWPFVertAlign("CENTER", 1);
            CENTER = r1;
            XWPFVertAlign r3 = new XWPFVertAlign("BOTH", 2);
            BOTH = r3;
            XWPFVertAlign r5 = new XWPFVertAlign("BOTTOM", 3);
            BOTTOM = r5;
            $VALUES = new XWPFVertAlign[]{r0, r1, r3, r5};
        }

        private XWPFVertAlign(String r1, int r2) {
            super(r1, r2);
        }

        public static XWPFVertAlign valueOf(String r2) {
            return (XWPFVertAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(XWPFVertAlign.class, r2), XWPFVertAlign.class, "com.obric.memorydata.plugin");
        }

        public static XWPFVertAlign[] values() {
            return (XWPFVertAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XWPFVertAlign[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        EnumMap<XWPFVertAlign, STVerticalJc.Enum> r0 = new EnumMap(XWPFVertAlign.class);
        alignMap = r0;
        r0.put(XWPFVertAlign.TOP, STVerticalJc.c);
        r0.put(XWPFVertAlign.CENTER, STVerticalJc.d);
        r0.put(XWPFVertAlign.BOTH, STVerticalJc.e);
        r0.put(XWPFVertAlign.BOTTOM, STVerticalJc.f);
        HashMap<Integer, XWPFVertAlign> r1 = new HashMap();
        stVertAlignTypeMap = r1;
        r1.put(1, XWPFVertAlign.TOP);
        r1.put(2, XWPFVertAlign.CENTER);
        r1.put(3, XWPFVertAlign.BOTH);
        r1.put(4, XWPFVertAlign.BOTTOM);
    }

    public XWPFTableCell(ew r3, XWPFTableRow r4, IBody r5) {
        ew r6 = (ew) ZeusTransformUtils.wrapperContextForParams(r3, ew.class, "com.obric.memorydata.plugin");
        IBody r7 = (IBody) ZeusTransformUtils.wrapperContextForParams(r5, IBody.class, "com.obric.memorydata.plugin");
        this.ctTc = r6;
        this.part = r7;
        this.tableRow = r4;
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor r8 = r6.newCursor();
        r8.selectPath("./*");     // Catch: Throwable -> L22
    L4:
        if (r8.toNextSelection() == false) goto L19;
        XmlObject r9 = r8.getObject();     // Catch: Throwable -> L22
        if (ZeusTransformUtils.instanceOf(r9, bv.class) == false) goto L10;
        XWPFParagraph r10 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r9, bv.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L22
        this.paragraphs.add(r10);     // Catch: Throwable -> L22
        this.bodyElements.add(r10);     // Catch: Throwable -> L22
    L10:
        if (ZeusTransformUtils.instanceOf(r9, eh.class) == false) goto L13;
        XWPFTable r11 = new XWPFTable((eh) ZeusTransformUtils.preCheckCast(r9, eh.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L22
        this.tables.add(r11);     // Catch: Throwable -> L22
        this.bodyElements.add(r11);     // Catch: Throwable -> L22
    L13:
        if (ZeusTransformUtils.instanceOf(r9, dc.class) == false) goto L16;
        XWPFSDT r12 = new XWPFSDT((dc) ZeusTransformUtils.preCheckCast(r9, dc.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L22
        this.bodyElements.add(r12);     // Catch: Throwable -> L22
    L16:
        if (ZeusTransformUtils.instanceOf(r9, dp.class) == false) goto L4;
        XWPFSDT r13 = new XWPFSDT((dp) ZeusTransformUtils.preCheckCast(r9, dp.class, "com.obric.memorydata.plugin"), this);     // Catch: Throwable -> L22
        this.bodyElements.add(r13);     // Catch: Throwable -> L22
        goto L4
    L19:
        if (r8 == null) goto L42;
        r8.close();
        return;
    L42:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r8 != null) goto L31;
    L30:
        throw th;
    L31:
        r8.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);
        goto L30
    }

    private void appendBodyElementText(StringBuilder r9, IBodyElement r10, boolean r11) {
        IBodyElement r12 = (IBodyElement) ZeusTransformUtils.wrapperContextForParams(r10, IBodyElement.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, XWPFParagraph.class) == false) goto L8;
        r9.append(((XWPFParagraph) ZeusTransformUtils.preCheckCast(r12, XWPFParagraph.class, "com.obric.memorydata.plugin")).getText());
        if (r11 == true) goto L30;
    L6:
        r9.append('\t');
        return;
    L30:
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r12, XWPFTable.class) == false) goto L26;
        Iterator<XWPFTableRow> r13 = ((XWPFTable) ZeusTransformUtils.preCheckCast(r12, XWPFTable.class, "com.obric.memorydata.plugin")).getRows().iterator();
    L11:
        if (r13.hasNext() == false) goto L23;
        Iterator<XWPFTableCell> r0 = ((XWPFTableRow) ZeusTransformUtils.preCheckCast(r13.next(), XWPFTableRow.class, "com.obric.memorydata.plugin")).getTableCells().iterator();
    L14:
        if (r0.hasNext() == false) goto L11;
        List<IBodyElement> r2 = ((XWPFTableCell) ZeusTransformUtils.preCheckCast(r0.next(), XWPFTableCell.class, "com.obric.memorydata.plugin")).getBodyElements();
        int r4 = 0;
    L17:
        if (r4 >= r2.size()) goto L14;
        boolean r6 = true;
        if (r4 == (r2.size() - 1)) goto L22;
        r6 = false;
    L22:
        appendBodyElementText(r9, (IBodyElement) ZeusTransformUtils.preCheckCast(r2.get(r4), IBodyElement.class, "com.obric.memorydata.plugin"), r6);
        r4 = r4 + 1;
        goto L17
    L23:
        if (r11 == true) goto L37;
        r9.append('\n');
        return;
    L37:
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r12, XWPFSDT.class) == false) goto L39;
        r9.append(((XWPFSDT) ZeusTransformUtils.preCheckCast(r12, XWPFSDT.class, "com.obric.memorydata.plugin")).getContent().getText());
        if (r11 == false) goto L6;
        return;
    }

    public XWPFParagraph addParagraph() {
        XWPFParagraph r0 = new XWPFParagraph(this.ctTc.addNewP(), this);
        addParagraph(r0);
        return r0;
    }

    public void addParagraph(XWPFParagraph r2) {
        this.paragraphs.add(r2);
        this.bodyElements.add(r2);
    }

    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.tableRow.getTable().getPart();
    }

    public String getTextRecursively() {
        StringBuilder r0 = new StringBuilder(64);
        int r2 = 0;
    L4:
        if (r2 >= this.bodyElements.size()) goto L11;
        boolean r4 = true;
        if (r2 == (this.bodyElements.size() - 1)) goto L9;
        r4 = false;
    L9:
        appendBodyElementText(r0, (IBodyElement) ZeusTransformUtils.preCheckCast(this.bodyElements.get(r2), IBodyElement.class, "com.obric.memorydata.plugin"), r4);
        r2 = r2 + 1;
        goto L4
    L11:
        return r0.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.part.getXWPFDocument();
    }
}
