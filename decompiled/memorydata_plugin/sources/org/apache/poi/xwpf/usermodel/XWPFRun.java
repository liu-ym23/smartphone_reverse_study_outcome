package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.a;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.c;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ae;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ag;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.al;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.aq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bu;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cb;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cq;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cx;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.fc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.k;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFRun implements IRunElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final IRunBody parent;
    private final String pictureText;
    private final List<XWPFPicture> pictures;
    private final cq run;

    public static final enum FontCharRange extends Enum<FontCharRange> {
        private static final /* synthetic */ FontCharRange[] $VALUES = null;
        public static final FontCharRange ascii = null;
        public static final FontCharRange cs = null;
        public static final FontCharRange eastAsia = null;
        public static final FontCharRange hAnsi = null;

        static {
            FontCharRange r0 = new FontCharRange("ascii", 0);
            ascii = r0;
            FontCharRange r1 = new FontCharRange("cs", 1);
            cs = r1;
            FontCharRange r3 = new FontCharRange("eastAsia", 2);
            eastAsia = r3;
            FontCharRange r5 = new FontCharRange("hAnsi", 3);
            hAnsi = r5;
            $VALUES = new FontCharRange[]{r0, r1, r3, r5};
        }

        private FontCharRange(String r1, int r2) {
            super(r1, r2);
        }

        public static FontCharRange valueOf(String r2) {
            return (FontCharRange) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontCharRange.class, r2), FontCharRange.class, "com.obric.memorydata.plugin");
        }

        public static FontCharRange[] values() {
            return (FontCharRange[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontCharRange[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public XWPFRun(cq r13, IRunBody r14) {
        cq r15 = (cq) ZeusTransformUtils.wrapperContextForParams(r13, cq.class, "com.obric.memorydata.plugin");
        IRunBody r16 = (IRunBody) ZeusTransformUtils.wrapperContextForParams(r14, IRunBody.class, "com.obric.memorydata.plugin");
        this.run = r15;
        this.parent = r16;
        ab[] r17 = r15.getDrawingArray();
        int r0 = r17.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L17;
        ab r4 = r17[r3];
        a[] r5 = r4.getAnchorArray();
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        a r8 = r5[r7];
        if (r8.getDocPr() == null) goto L9;
        getDocument().getDrawingIdManager().reserve(r8.getDocPr().getId());
    L9:
        r7 = r7 + 1;
        goto L5
    L10:
        c[] r9 = r4.getInlineArray();
        int r10 = r9.length;
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L16;
        c r12 = r9[r11];
        if (r12.getDocPr() == null) goto L15;
        getDocument().getDrawingIdManager().reserve(r12.getDocPr().getId());
    L15:
        r11 = r11 + 1;
        goto L11
    L16:
        r3 = r3 + 1;
        goto L3
    L17:
        StringBuilder r18 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        r1.addAll(Arrays.asList(r15.getPictArray()));
        r1.addAll(Arrays.asList(r15.getDrawingArray()));
        Iterator r19 = r1.iterator();
    L19:
        if (r19.hasNext() == false) goto L33;
        XmlObject[] r20 = ((XmlObject) ZeusTransformUtils.preCheckCast(r19.next(), XmlObject.class, "com.obric.memorydata.plugin")).selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t");
        int r21 = r20.length;
        int r22 = 0;
    L21:
        if (r22 >= r21) goto L19;
        NodeList r23 = r20[r22].getDomNode().getChildNodes();
        int r24 = 0;
    L24:
        if (r24 >= r23.getLength()) goto L32;
        if (ZeusTransformUtils.instanceOf(r23.item(r24), Text.class) == false) goto L31;
        if (r18.length() <= 0) goto L30;
        r18.append("\n");
    L30:
        r18.append(r23.item(r24).getNodeValue());
    L31:
        r24 = r24 + 1;
        goto L24
    L32:
        r22 = r22 + 1;
        goto L21
    L33:
        this.pictureText = r18.toString();
        this.pictures = new ArrayList();
        Iterator r110 = r1.iterator();
    L35:
        if (r110.hasNext() == false) goto L40;
        Iterator<org.openxmlformats.schemas.drawingml.x2006.picture.a> r111 = getCTPictures((XmlObject) ZeusTransformUtils.preCheckCast(r110.next(), XmlObject.class, "com.obric.memorydata.plugin")).iterator();
    L38:
        if (r111.hasNext() == false) goto L35;
        this.pictures.add(new XWPFPicture((org.openxmlformats.schemas.drawingml.x2006.picture.a) ZeusTransformUtils.preCheckCast(r111.next(), org.openxmlformats.schemas.drawingml.x2006.picture.a.class, "com.obric.memorydata.plugin"), this));
        goto L38
    }

    @Deprecated
    public XWPFRun(cq r3, XWPFParagraph r4) {
        this((cq) ZeusTransformUtils.wrapperContextForParams(r3, cq.class, "com.obric.memorydata.plugin"), r4);
    }

    private void _getText(XmlObject r6, StringBuilder r7) {
        XmlObject r8 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r6, XmlObject.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, fc.class) == false) goto L17;
        Node r0 = r8.getDomNode();
        if ("instrText".equals(r0.getLocalName()) == true) goto L7;
    L8:
        String r1 = ((fc) ZeusTransformUtils.preCheckCast(r8, fc.class, "com.obric.memorydata.plugin")).getStringValue();
        if (r1 == null) goto L17;
        if (isCapitalized() == false) goto L13;
    L14:
        r1 = r1.toUpperCase(LocaleUtil.getUserLocale());
    L15:
        r7.append(r1);
        goto L17
    L13:
        if (isSmallCaps() == false) goto L15;
    L7:
        if ("http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(r0.getNamespaceURI()) == false) goto L8;
    L17:
        if (ZeusTransformUtils.instanceOf(r8, al.class) == false) goto L33;
        al r5 = (al) ZeusTransformUtils.preCheckCast(r8, al.class, "com.obric.memorydata.plugin");
        if (r5.getFldCharType() != STFldCharType.c) goto L33;
        if (r5.getFfData() == null) goto L33;
        Iterator<ag> r9 = r5.getFfData().getCheckBoxList().iterator();
    L24:
        if (r9.hasNext() == false) goto L33;
        ag r2 = (ag) ZeusTransformUtils.preCheckCast(r9.next(), ag.class, "com.obric.memorydata.plugin");
        if (r2.getDefault() != null) goto L28;
    L30:
        String r3 = "|_|";
    L31:
        r7.append(r3);
        goto L24
    L28:
        if (POIXMLUnits.parseOnOff(r2.getDefault().xgetVal()) == false) goto L30;
        r3 = "|X|";
    L33:
        if (ZeusTransformUtils.instanceOf(r8, cb.class) == false) goto L36;
        r7.append('\t');
    L36:
        if (ZeusTransformUtils.instanceOf(r8, k.class) == false) goto L39;
        r7.append('\n');
    L39:
        if (ZeusTransformUtils.instanceOf(r8, ae.class) == false) goto L62;
        Node r10 = r8.getDomNode();
        if ("http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(r10.getNamespaceURI()) == false) goto L62;
        String r11 = r10.getLocalName();
        r11.hashCode();
        byte r4 = -1;
        switch(r11.hashCode()) {
            case 3152: goto L54;
            case 3183: goto L50;
            case 114581: goto L46;
            default: goto L57;
        };
    L57:
        switch(r4) {
            case 0: goto L60;
            case 1: goto L60;
            case 2: goto L59;
            default: goto L62;
        };
    L59:
        r7.append('\t');
        goto L62
    L60:
        r7.append('\n');
        goto L62
    L46:
        if (r11.equals("tab") == false) goto L57;
        r4 = 2;
        goto L57
    L50:
        if (r11.equals("cr") == false) goto L57;
        r4 = 1;
        goto L57
    L54:
        if (r11.equals("br") == false) goto L57;
        r4 = 0;
    L62:
        if (ZeusTransformUtils.instanceOf(r8, aq.class) == false) goto L72;
        aq r12 = (aq) ZeusTransformUtils.preCheckCast(r8, aq.class, "com.obric.memorydata.plugin");
        if (r12.getDomNode().getLocalName().equals("footnoteReference") == false) goto L66;
        StringBuilder r13 = new StringBuilder();
        String r14 = "[footnoteRef:";
    L67:
        r7.append(r13.append(r14).append(r12.getId().intValue()).append("]").toString());
        return;
    L66:
        r13 = new StringBuilder();
        r14 = "[endnoteRef:";
        goto L67
    }

    private List<org.openxmlformats.schemas.drawingml.x2006.picture.a> getCTPictures(XmlObject r7) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r7, XmlObject.class, "com.obric.memorydata.plugin");
        ArrayList r8 = new ArrayList();
        XmlObject[] r9 = r6.selectPath("declare namespace pic='" + org.openxmlformats.schemas.drawingml.x2006.picture.a.f19015b.getName().getNamespaceURI() + "' .//pic:pic");
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        XmlObject r3 = r9[r2];
        if (ZeusTransformUtils.instanceOf(r3, XmlAnyTypeImpl.class) == false) goto L12;
        r3 = (XmlObject) ZeusTransformUtils.preCheckCast(org.openxmlformats.schemas.drawingml.x2006.picture.a.f19014a.parse(r3.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L8
    L8:
        e = move-exception;
        throw new POIXMLException(e);
    L12:
        if (ZeusTransformUtils.instanceOf(r3, org.openxmlformats.schemas.drawingml.x2006.picture.a.class) == false) goto L14;
        r8.add((org.openxmlformats.schemas.drawingml.x2006.picture.a) ZeusTransformUtils.preCheckCast(r3, org.openxmlformats.schemas.drawingml.x2006.picture.a.class, "com.obric.memorydata.plugin"));
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        return r8;
    }

    private void handleRuby(XmlObject r7, StringBuilder r8, boolean r9) {
        XmlCursor r10 = ((XmlObject) ZeusTransformUtils.wrapperContextForParams(r7, XmlObject.class, "com.obric.memorydata.plugin")).newCursor();
        r10.selectPath(".//*");     // Catch: Throwable -> L26
        boolean r1 = false;
        boolean r2 = false;
    L4:
        if (r10.toNextSelection() == false) goto L23;
        XmlObject r3 = r10.getObject();     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r3, cz.class) == true) goto L8;
        if (r9 == false) goto L20;
        if (r1 == false) goto L20;
    L18:
        _getText(r3, r8);     // Catch: Throwable -> L26
    L20:
        if (r9 == true) goto L4;
        if (r2 == false) goto L4;
    L8:
        Node r4 = r3.getDomNode();     // Catch: Throwable -> L26
        if ("http://schemas.openxmlformats.org/wordprocessingml/2006/main".equals(r4.getNamespaceURI()) == false) goto L4;
        String r5 = r4.getLocalName();     // Catch: Throwable -> L26
        if ("rt".equals(r5) == true) goto L12;
        if ("rubyBase".equals(r5) == false) goto L4;
        r1 = false;
        r2 = true;
        goto L4
    L12:
        r1 = true;
        goto L4
    L23:
        if (r10 == null) goto L59;
        r10.close();
        return;
    L59:
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (r10 != null) goto L39;
    L34:
        throw th;
    L39:
        r10.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    }

    private static boolean isCTOnOff(bu r2) {
        bu r3 = (bu) ZeusTransformUtils.wrapperContextForParams(r2, bu.class, "com.obric.memorydata.plugin");
        if (r3.isSetVal() == true) goto L5;
    L8:
        return true;
    L5:
        if (POIXMLUnits.parseOnOff(r3) == true) goto L8;
        return false;
    }

    public cq getCTR() {
        return this.run;
    }

    public XWPFDocument getDocument() {
        IRunBody r0 = this.parent;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDocument();
    }

    public List<XWPFPicture> getEmbeddedPictures() {
        return this.pictures;
    }

    public IRunBody getParent() {
        return this.parent;
    }

    public String getPhonetic() {
        StringBuilder r1 = new StringBuilder(64);
        XmlCursor r2 = this.run.newCursor();
        r2.selectPath("./*");     // Catch: Throwable -> L18
    L5:
        if (r2.toNextSelection() == false) goto L9;
        XmlObject r3 = r2.getObject();     // Catch: Throwable -> L18
        if (ZeusTransformUtils.instanceOf(r3, cx.class) == false) goto L5;
        handleRuby(r3, r1, true);     // Catch: Throwable -> L18
        goto L5
    L9:
        String r4 = this.pictureText;     // Catch: Throwable -> L18
        if (r4 != null) goto L12;
    L14:
        if (r2 == null) goto L17;
        r2.close();
    L17:
        return r1.toString();
    L12:
        if (r4.length() <= 0) goto L14;
        r1.append("\n").append(this.pictureText).append("\n");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r2 != null) goto L27;
    L26:
        throw th;
    L27:
        r2.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    }

    public cr getRunProperties(boolean r2) {
        if (this.run.isSetRPr() == false) goto L5;
        cr r0 = this.run.getRPr();
    L6:
        if (r2 == false) goto L10;
        if (r0 == null) goto L9;
        return r0;
    L9:
        return this.run.addNewRPr();
    L10:
        return r0;
    L5:
        r0 = null;
        goto L6
    }

    public boolean isCapitalized() {
        cr r2 = getRunProperties(false);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.sizeOfCapsArray() > 0) goto L7;
        return false;
    L7:
        if (isCTOnOff(r2.getCapsArray(0)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isSmallCaps() {
        cr r2 = getRunProperties(false);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.sizeOfSmallCapsArray() > 0) goto L7;
        return false;
    L7:
        if (isCTOnOff(r2.getSmallCapsArray(0)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public String text() {
        StringBuilder r0 = new StringBuilder(64);
        XmlCursor r1 = this.run.newCursor();
        r1.selectPath("./*");     // Catch: Throwable -> L15
    L4:
        if (r1.toNextSelection() == false) goto L11;
        XmlObject r2 = r1.getObject();     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf(r2, cx.class) == true) goto L8;
        _getText(r2, r0);     // Catch: Throwable -> L15
        goto L4
    L8:
        handleRuby(r2, r0, false);     // Catch: Throwable -> L15
        goto L4
    L11:
        if (r1 == null) goto L14;
        r1.close();
    L14:
        return r0.toString();
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r1 != null) goto L24;
    L23:
        throw th;
    L24:
        r1.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    }

    public String toString() {
        String r0 = getPhonetic();
        if (r0.length() <= 0) goto L7;
        return text() + " (" + r0 + ")";
    L7:
        return text();
    }
}
