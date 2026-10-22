package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.bv;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cw;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.eh;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ei;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.er;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ew;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFTable implements IBodyElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<Integer, XWPFBorderType> stBorderTypeMap = null;
    private static final EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap = null;
    private final eh ctTbl;
    protected IBody part;
    protected final List<XWPFTableRow> tableRows;
    protected StringBuilder text;

    private static final enum Border extends Enum<Border> {
        private static final /* synthetic */ Border[] $VALUES = null;
        public static final Border BOTTOM = null;
        public static final Border INSIDE_H = null;
        public static final Border INSIDE_V = null;
        public static final Border LEFT = null;
        public static final Border RIGHT = null;
        public static final Border TOP = null;

        static {
            Border r0 = new Border("INSIDE_V", 0);
            INSIDE_V = r0;
            Border r1 = new Border("INSIDE_H", 1);
            INSIDE_H = r1;
            Border r3 = new Border("LEFT", 2);
            LEFT = r3;
            Border r5 = new Border("TOP", 3);
            TOP = r5;
            Border r7 = new Border("BOTTOM", 4);
            BOTTOM = r7;
            Border r9 = new Border("RIGHT", 5);
            RIGHT = r9;
            $VALUES = new Border[]{r0, r1, r3, r5, r7, r9};
        }

        private Border(String r1, int r2) {
            super(r1, r2);
        }

        public static Border valueOf(String r2) {
            return (Border) ZeusTransformUtils.preCheckCast(Enum.valueOf(Border.class, r2), Border.class, "com.obric.memorydata.plugin");
        }

        public static Border[] values() {
            return (Border[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Border[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum XWPFBorderType extends Enum<XWPFBorderType> {
        private static final /* synthetic */ XWPFBorderType[] $VALUES = null;
        public static final XWPFBorderType DASHED = null;
        public static final XWPFBorderType DASH_DOT_STROKED = null;
        public static final XWPFBorderType DASH_SMALL_GAP = null;
        public static final XWPFBorderType DOTTED = null;
        public static final XWPFBorderType DOT_DASH = null;
        public static final XWPFBorderType DOT_DOT_DASH = null;
        public static final XWPFBorderType DOUBLE = null;
        public static final XWPFBorderType DOUBLE_WAVE = null;
        public static final XWPFBorderType INSET = null;
        public static final XWPFBorderType NIL = null;
        public static final XWPFBorderType NONE = null;
        public static final XWPFBorderType OUTSET = null;
        public static final XWPFBorderType SINGLE = null;
        public static final XWPFBorderType THICK = null;
        public static final XWPFBorderType THICK_THIN_LARGE_GAP = null;
        public static final XWPFBorderType THICK_THIN_MEDIUM_GAP = null;
        public static final XWPFBorderType THICK_THIN_SMALL_GAP = null;
        public static final XWPFBorderType THIN_THICK_LARGE_GAP = null;
        public static final XWPFBorderType THIN_THICK_MEDIUM_GAP = null;
        public static final XWPFBorderType THIN_THICK_SMALL_GAP = null;
        public static final XWPFBorderType THIN_THICK_THIN_LARGE_GAP = null;
        public static final XWPFBorderType THIN_THICK_THIN_MEDIUM_GAP = null;
        public static final XWPFBorderType THIN_THICK_THIN_SMALL_GAP = null;
        public static final XWPFBorderType THREE_D_EMBOSS = null;
        public static final XWPFBorderType THREE_D_ENGRAVE = null;
        public static final XWPFBorderType TRIPLE = null;
        public static final XWPFBorderType WAVE = null;

        static {
            XWPFBorderType r0 = new XWPFBorderType("NIL", 0);
            NIL = r0;
            XWPFBorderType r1 = new XWPFBorderType("NONE", 1);
            NONE = r1;
            XWPFBorderType r3 = new XWPFBorderType("SINGLE", 2);
            SINGLE = r3;
            XWPFBorderType r5 = new XWPFBorderType("THICK", 3);
            THICK = r5;
            XWPFBorderType r7 = new XWPFBorderType("DOUBLE", 4);
            DOUBLE = r7;
            XWPFBorderType r9 = new XWPFBorderType("DOTTED", 5);
            DOTTED = r9;
            XWPFBorderType r11 = new XWPFBorderType("DASHED", 6);
            DASHED = r11;
            XWPFBorderType r13 = new XWPFBorderType("DOT_DASH", 7);
            DOT_DASH = r13;
            XWPFBorderType r15 = new XWPFBorderType("DOT_DOT_DASH", 8);
            DOT_DOT_DASH = r15;
            XWPFBorderType r14 = new XWPFBorderType("TRIPLE", 9);
            TRIPLE = r14;
            XWPFBorderType r12 = new XWPFBorderType("THIN_THICK_SMALL_GAP", 10);
            THIN_THICK_SMALL_GAP = r12;
            XWPFBorderType r10 = new XWPFBorderType("THICK_THIN_SMALL_GAP", 11);
            THICK_THIN_SMALL_GAP = r10;
            XWPFBorderType r8 = new XWPFBorderType("THIN_THICK_THIN_SMALL_GAP", 12);
            THIN_THICK_THIN_SMALL_GAP = r8;
            XWPFBorderType r6 = new XWPFBorderType("THIN_THICK_MEDIUM_GAP", 13);
            THIN_THICK_MEDIUM_GAP = r6;
            XWPFBorderType r4 = new XWPFBorderType("THICK_THIN_MEDIUM_GAP", 14);
            THICK_THIN_MEDIUM_GAP = r4;
            XWPFBorderType r2 = new XWPFBorderType("THIN_THICK_THIN_MEDIUM_GAP", 15);
            THIN_THICK_THIN_MEDIUM_GAP = r2;
            XWPFBorderType r16 = new XWPFBorderType("THIN_THICK_LARGE_GAP", 16);
            THIN_THICK_LARGE_GAP = r16;
            XWPFBorderType r17 = new XWPFBorderType("THICK_THIN_LARGE_GAP", 17);
            THICK_THIN_LARGE_GAP = r17;
            XWPFBorderType r18 = new XWPFBorderType("THIN_THICK_THIN_LARGE_GAP", 18);
            THIN_THICK_THIN_LARGE_GAP = r18;
            XWPFBorderType r19 = new XWPFBorderType("WAVE", 19);
            WAVE = r19;
            XWPFBorderType r20 = new XWPFBorderType("DOUBLE_WAVE", 20);
            DOUBLE_WAVE = r20;
            XWPFBorderType r21 = new XWPFBorderType("DASH_SMALL_GAP", 21);
            DASH_SMALL_GAP = r21;
            XWPFBorderType r22 = new XWPFBorderType("DASH_DOT_STROKED", 22);
            DASH_DOT_STROKED = r22;
            XWPFBorderType r23 = new XWPFBorderType("THREE_D_EMBOSS", 23);
            THREE_D_EMBOSS = r23;
            XWPFBorderType r24 = new XWPFBorderType("THREE_D_ENGRAVE", 24);
            THREE_D_ENGRAVE = r24;
            XWPFBorderType r25 = new XWPFBorderType("OUTSET", 25);
            OUTSET = r25;
            XWPFBorderType r26 = new XWPFBorderType("INSET", 26);
            INSET = r26;
            $VALUES = new XWPFBorderType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26};
        }

        private XWPFBorderType(String r1, int r2) {
            super(r1, r2);
        }

        public static XWPFBorderType valueOf(String r2) {
            return (XWPFBorderType) ZeusTransformUtils.preCheckCast(Enum.valueOf(XWPFBorderType.class, r2), XWPFBorderType.class, "com.obric.memorydata.plugin");
        }

        public static XWPFBorderType[] values() {
            return (XWPFBorderType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XWPFBorderType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        EnumMap<XWPFBorderType, STBorder.Enum> r0 = new EnumMap(XWPFBorderType.class);
        xwpfBorderTypeMap = r0;
        r0.put(XWPFBorderType.NIL, STBorder.c);
        r0.put(XWPFBorderType.NONE, STBorder.d);
        r0.put(XWPFBorderType.SINGLE, STBorder.e);
        r0.put(XWPFBorderType.THICK, STBorder.f);
        r0.put(XWPFBorderType.DOUBLE, STBorder.g);
        r0.put(XWPFBorderType.DOTTED, STBorder.h);
        r0.put(XWPFBorderType.DASHED, STBorder.i);
        r0.put(XWPFBorderType.DOT_DASH, STBorder.j);
        r0.put(XWPFBorderType.DOT_DOT_DASH, STBorder.k);
        r0.put(XWPFBorderType.TRIPLE, STBorder.l);
        r0.put(XWPFBorderType.THIN_THICK_SMALL_GAP, STBorder.m);
        r0.put(XWPFBorderType.THICK_THIN_SMALL_GAP, STBorder.n);
        r0.put(XWPFBorderType.THIN_THICK_THIN_SMALL_GAP, STBorder.o);
        r0.put(XWPFBorderType.THIN_THICK_MEDIUM_GAP, STBorder.p);
        r0.put(XWPFBorderType.THICK_THIN_MEDIUM_GAP, STBorder.q);
        r0.put(XWPFBorderType.THIN_THICK_THIN_MEDIUM_GAP, STBorder.r);
        r0.put(XWPFBorderType.THIN_THICK_LARGE_GAP, STBorder.s);
        r0.put(XWPFBorderType.THICK_THIN_LARGE_GAP, STBorder.t);
        r0.put(XWPFBorderType.THIN_THICK_THIN_LARGE_GAP, STBorder.u);
        r0.put(XWPFBorderType.WAVE, STBorder.v);
        r0.put(XWPFBorderType.DOUBLE_WAVE, STBorder.w);
        r0.put(XWPFBorderType.DASH_SMALL_GAP, STBorder.x);
        r0.put(XWPFBorderType.DASH_DOT_STROKED, STBorder.y);
        r0.put(XWPFBorderType.THREE_D_EMBOSS, STBorder.z);
        r0.put(XWPFBorderType.THREE_D_ENGRAVE, STBorder.A);
        r0.put(XWPFBorderType.OUTSET, STBorder.B);
        r0.put(XWPFBorderType.INSET, STBorder.C);
        HashMap<Integer, XWPFBorderType> r1 = new HashMap();
        stBorderTypeMap = r1;
        r1.put(1, XWPFBorderType.NIL);
        r1.put(2, XWPFBorderType.NONE);
        r1.put(3, XWPFBorderType.SINGLE);
        r1.put(4, XWPFBorderType.THICK);
        r1.put(5, XWPFBorderType.DOUBLE);
        r1.put(6, XWPFBorderType.DOTTED);
        r1.put(7, XWPFBorderType.DASHED);
        r1.put(8, XWPFBorderType.DOT_DASH);
        r1.put(9, XWPFBorderType.DOT_DOT_DASH);
        r1.put(10, XWPFBorderType.TRIPLE);
        r1.put(11, XWPFBorderType.THIN_THICK_SMALL_GAP);
        r1.put(12, XWPFBorderType.THICK_THIN_SMALL_GAP);
        r1.put(13, XWPFBorderType.THIN_THICK_THIN_SMALL_GAP);
        r1.put(14, XWPFBorderType.THIN_THICK_MEDIUM_GAP);
        r1.put(15, XWPFBorderType.THICK_THIN_MEDIUM_GAP);
        r1.put(16, XWPFBorderType.THIN_THICK_THIN_MEDIUM_GAP);
        r1.put(17, XWPFBorderType.THIN_THICK_LARGE_GAP);
        r1.put(18, XWPFBorderType.THICK_THIN_LARGE_GAP);
        r1.put(19, XWPFBorderType.THIN_THICK_THIN_LARGE_GAP);
        r1.put(20, XWPFBorderType.WAVE);
        r1.put(21, XWPFBorderType.DOUBLE_WAVE);
        r1.put(22, XWPFBorderType.DASH_SMALL_GAP);
        r1.put(23, XWPFBorderType.DASH_DOT_STROKED);
        r1.put(24, XWPFBorderType.THREE_D_EMBOSS);
        r1.put(25, XWPFBorderType.THREE_D_ENGRAVE);
        r1.put(26, XWPFBorderType.OUTSET);
        r1.put(27, XWPFBorderType.INSET);
    }

    public XWPFTable(eh r7, IBody r8) {
        eh r9 = (eh) ZeusTransformUtils.wrapperContextForParams(r7, eh.class, "com.obric.memorydata.plugin");
        IBody r10 = (IBody) ZeusTransformUtils.wrapperContextForParams(r8, IBody.class, "com.obric.memorydata.plugin");
        this.text = new StringBuilder(64);
        this.tableRows = new ArrayList();
        this.part = r10;
        this.ctTbl = r9;
        if (r9.sizeOfTrArray() != 0) goto L5;
        createEmptyTable(r9);
    L5:
        Iterator<cw> r11 = r9.getTrList().iterator();
    L7:
        if (r11.hasNext() == false) goto L21;
        cw r0 = (cw) ZeusTransformUtils.preCheckCast(r11.next(), cw.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder();
        XWPFTableRow r3 = new XWPFTableRow(r0, this);
        this.tableRows.add(r3);
        Iterator<ew> r1 = r0.getTcList().iterator();
    L10:
        if (r1.hasNext() == false) goto L19;
        Iterator<bv> r4 = ((ew) ZeusTransformUtils.preCheckCast(r1.next(), ew.class, "com.obric.memorydata.plugin")).getPList().iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        XWPFParagraph r5 = new XWPFParagraph((bv) ZeusTransformUtils.preCheckCast(r4.next(), bv.class, "com.obric.memorydata.plugin"), r10);
        if (r2.length() <= 0) goto L17;
        r2.append('\t');
    L17:
        r2.append(r5.getText());
        goto L13
    L19:
        if (r2.length() <= 0) goto L7;
        this.text.append(r2);
        this.text.append('\n');
        goto L7
    }

    private void createEmptyTable(eh r3) {
        eh r2 = (eh) ZeusTransformUtils.wrapperContextForParams(r3, eh.class, "com.obric.memorydata.plugin");
        r2.addNewTr().addNewTc().addNewP();
        er r4 = r2.addNewTblPr();
        r4.addNewTblW().setW(BigInteger.valueOf(0));
        r4.getTblW().setType(STTblWidth.f);
        ei r5 = r4.addNewTblBorders();
        r5.addNewBottom().setVal(STBorder.e);
        r5.addNewInsideH().setVal(STBorder.e);
        r5.addNewInsideV().setVal(STBorder.e);
        r5.addNewLeft().setVal(STBorder.e);
        r5.addNewRight().setVal(STBorder.e);
        r5.addNewTop().setVal(STBorder.e);
    }

    public IBody getBody() {
        return this.part;
    }

    public POIXMLDocumentPart getPart() {
        IBody r0 = this.part;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPart();
    }

    public List<XWPFTableRow> getRows() {
        return Collections.unmodifiableList(this.tableRows);
    }
}
