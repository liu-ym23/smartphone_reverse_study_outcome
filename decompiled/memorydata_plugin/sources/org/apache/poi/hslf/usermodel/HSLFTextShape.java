package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.hslf.record.EscherTextboxWrapper;
import org.apache.poi.hslf.record.PPDrawing;
import org.apache.poi.hslf.record.StyleTextPropAtom;
import org.apache.poi.hslf.record.TextBytesAtom;
import org.apache.poi.hslf.record.TextCharsAtom;
import org.apache.poi.hslf.record.TextHeaderAtom;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFTextShape extends HSLFSimpleShape implements TextShape<HSLFShape, HSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private List<HSLFTextParagraph> _paragraphs;
    private EscherTextboxWrapper _txtbox;

    private static final enum HSLFTextAnchor extends Enum<HSLFTextAnchor> {
        private static final /* synthetic */ HSLFTextAnchor[] $VALUES = null;
        public static final HSLFTextAnchor BOTTOM = null;
        public static final HSLFTextAnchor BOTTOM_BASELINE = null;
        public static final HSLFTextAnchor BOTTOM_CENTER = null;
        public static final HSLFTextAnchor BOTTOM_CENTER_BASELINE = null;
        public static final HSLFTextAnchor MIDDLE = null;
        public static final HSLFTextAnchor MIDDLE_CENTER = null;
        public static final HSLFTextAnchor TOP = null;
        public static final HSLFTextAnchor TOP_BASELINE = null;
        public static final HSLFTextAnchor TOP_CENTER = null;
        public static final HSLFTextAnchor TOP_CENTER_BASELINE = null;
        public final Boolean baseline;
        public final boolean centered;
        public final int nativeId;
        public final VerticalAlignment vAlign;

        static {
            HSLFTextAnchor r7 = new HSLFTextAnchor("TOP", 0, 0, VerticalAlignment.TOP, false, false);
            TOP = r7;
            HSLFTextAnchor r0 = new HSLFTextAnchor("MIDDLE", 1, 1, VerticalAlignment.MIDDLE, false, false);
            MIDDLE = r0;
            HSLFTextAnchor r1 = new HSLFTextAnchor("BOTTOM", 2, 2, VerticalAlignment.BOTTOM, false, false);
            BOTTOM = r1;
            HSLFTextAnchor r2 = new HSLFTextAnchor("TOP_CENTER", 3, 3, VerticalAlignment.TOP, true, false);
            TOP_CENTER = r2;
            HSLFTextAnchor r3 = new HSLFTextAnchor("MIDDLE_CENTER", 4, 4, VerticalAlignment.MIDDLE, true, false);
            MIDDLE_CENTER = r3;
            HSLFTextAnchor r4 = new HSLFTextAnchor("BOTTOM_CENTER", 5, 5, VerticalAlignment.BOTTOM, true, false);
            BOTTOM_CENTER = r4;
            HSLFTextAnchor r5 = new HSLFTextAnchor("TOP_BASELINE", 6, 6, VerticalAlignment.TOP, false, true);
            TOP_BASELINE = r5;
            HSLFTextAnchor r17 = new HSLFTextAnchor("BOTTOM_BASELINE", 7, 7, VerticalAlignment.BOTTOM, false, true);
            BOTTOM_BASELINE = r17;
            HSLFTextAnchor r18 = new HSLFTextAnchor("TOP_CENTER_BASELINE", 8, 8, VerticalAlignment.TOP, true, true);
            TOP_CENTER_BASELINE = r18;
            HSLFTextAnchor r19 = new HSLFTextAnchor("BOTTOM_CENTER_BASELINE", 9, 9, VerticalAlignment.BOTTOM, true, true);
            BOTTOM_CENTER_BASELINE = r19;
            $VALUES = new HSLFTextAnchor[]{r7, r0, r1, r2, r3, r4, r5, r17, r18, r19};
        }

        private HSLFTextAnchor(String r1, int r2, int r3, VerticalAlignment r4, boolean r5, Boolean r6) {
            super(r1, r2);
            this.nativeId = r3;
            this.vAlign = r4;
            this.centered = r5;
            this.baseline = r6;
        }

        static HSLFTextAnchor fromNativeId(int r5) {
            HSLFTextAnchor[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            HSLFTextAnchor r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static HSLFTextAnchor valueOf(String r2) {
            return (HSLFTextAnchor) ZeusTransformUtils.preCheckCast(Enum.valueOf(HSLFTextAnchor.class, r2), HSLFTextAnchor.class, "com.obric.memorydata.plugin");
        }

        public static HSLFTextAnchor[] values() {
            return (HSLFTextAnchor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HSLFTextAnchor[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(HSLFTextShape.class);
    }

    public HSLFTextShape() {
        this(null);
    }

    public HSLFTextShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
        this._paragraphs = new ArrayList();
    }

    public HSLFTextShape(ShapeContainer<HSLFShape, HSLFTextParagraph> r3) {
        ShapeContainer r4 = (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r3, ShapeContainer.class, "com.obric.memorydata.plugin");
        super(null, r4);
        this._paragraphs = new ArrayList();
        createSpContainer(ZeusTransformUtils.instanceOf(r4, HSLFGroupShape.class));
    }

    private void createEmptyParagraph() {
        TextHeaderAtom r0 = (TextHeaderAtom) ZeusTransformUtils.preCheckCast(this._txtbox.findFirstOfType(TextHeaderAtom._type), TextHeaderAtom.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new TextHeaderAtom();
        r0.setParentRecord(this._txtbox);
        this._txtbox.appendChildRecord(r0);
    L5:
        TextBytesAtom r1 = (TextBytesAtom) ZeusTransformUtils.preCheckCast(this._txtbox.findFirstOfType(TextBytesAtom._type), TextBytesAtom.class, "com.obric.memorydata.plugin");
        TextCharsAtom r3 = (TextCharsAtom) ZeusTransformUtils.preCheckCast(this._txtbox.findFirstOfType(TextCharsAtom._type), TextCharsAtom.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        if (r3 != null) goto L9;
        r1 = new TextBytesAtom();
        r1.setText(new byte[0]);
        this._txtbox.appendChildRecord(r1);
    L9:
        if (r1 == null) goto L11;
        String r5 = r1.getText();
    L12:
        StyleTextPropAtom r6 = (StyleTextPropAtom) ZeusTransformUtils.preCheckCast(this._txtbox.findFirstOfType(StyleTextPropAtom._type), StyleTextPropAtom.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L27;
        int r7 = r5.length() + 1;
        StyleTextPropAtom r8 = new StyleTextPropAtom(r7);
        if (this._paragraphs.isEmpty() == false) goto L17;
        TextPropCollection r2 = r8.addParagraphTextPropCollection(r7);
        TextPropCollection r4 = r8.addCharacterTextPropCollection(r7);
    L26:
        this._txtbox.appendChildRecord(r8);
    L29:
        if (this._paragraphs.isEmpty() == false) goto L34;
        HSLFTextParagraph r9 = new HSLFTextParagraph(r0, r1, r3, this._paragraphs);
        r9.setParagraphStyle(r2);
        r9.setParentShape(this);
        this._paragraphs.add(r9);
        HSLFTextRun r13 = new HSLFTextRun(r9);
        r13.setCharacterStyle(r4);
        r13.setText(r5);
        r9.addTextRun(r13);
        return;
    L34:
        return;
    L17:
        Iterator<HSLFTextParagraph> r10 = this._paragraphs.iterator();
        TextPropCollection r11 = null;
        TextPropCollection r12 = null;
    L19:
        if (r10.hasNext() == false) goto L25;
        HSLFTextParagraph r14 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r10.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        Iterator<HSLFTextRun> r15 = r14.getTextRuns().iterator();
        int r16 = 0;
    L22:
        if (r15.hasNext() == false) goto L24;
        HSLFTextRun r17 = (HSLFTextRun) ZeusTransformUtils.preCheckCast(r15.next(), HSLFTextRun.class, "com.obric.memorydata.plugin");
        r16 = r16 + r17.getLength();
        TextPropCollection r18 = r8.addCharacterTextPropCollection(r17.getLength());
        r17.setCharacterStyle(r18);
        r12 = r18;
        goto L22
    L24:
        TextPropCollection r19 = r8.addParagraphTextPropCollection(r16);
        r14.setParagraphStyle(r19);
        r11 = r19;
        goto L19
    L25:
        r2 = r11;
        r4 = r12;
        goto L26
    L27:
        TextPropCollection r20 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r6.getParagraphStyles().get(0), TextPropCollection.class, "com.obric.memorydata.plugin");
        r4 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r6.getCharacterStyles().get(0), TextPropCollection.class, "com.obric.memorydata.plugin");
        r2 = r20;
        goto L29
    L11:
        r5 = r3.getText();
        goto L12
    }

    public EscherTextboxWrapper getEscherTextboxWrapper() {
        EscherTextboxWrapper r0 = this._txtbox;
        if (r0 == null) goto L5;
        return r0;
    L5:
        EscherTextboxRecord r1 = (EscherTextboxRecord) ZeusTransformUtils.preCheckCast(getEscherChild(EscherTextboxRecord.RECORD_ID), EscherTextboxRecord.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return null;
    L9:
        HSLFSheet r2 = getSheet();
        if (r2 == null) goto L22;
        PPDrawing r3 = r2.getPPDrawing();
        if (r3 == null) goto L22;
        EscherTextboxWrapper[] r4 = r3.getTextboxWrappers();
        if (r4 == null) goto L22;
        int r5 = r4.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L22;
        EscherTextboxWrapper r7 = r4[r6];
        if (r1 == r7.getEscherRecord()) goto L19;
        r6 = r6 + 1;
        goto L16
    L19:
        this._txtbox = r7;
        return r7;
    L22:
        EscherTextboxWrapper r8 = new EscherTextboxWrapper(r1);
        this._txtbox = r8;
        return r8;
    }

    public String getRawText() {
        return HSLFTextParagraph.getRawText(getTextParagraphs());
    }

    public int getRunType() {
        getEscherTextboxWrapper();
        EscherTextboxWrapper r0 = this._txtbox;
        if (r0 != null) goto L5;
        return -1;
    L5:
        List<HSLFTextParagraph> r5 = HSLFTextParagraph.findTextParagraphs(r0, getSheet());
        if (r5.isEmpty() == false) goto L8;
        return -1;
    L8:
        if (((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r5.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).getIndex() != (-1)) goto L11;
        return -1;
    L11:
        return ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r5.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).getRunType();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public String getText() {
        return HSLFTextParagraph.toExternalString(getRawText(), getRunType());
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public List<HSLFTextParagraph> getTextParagraphs() {
        if (this._paragraphs.isEmpty() == false) goto L5;
        EscherTextboxWrapper r0 = getEscherTextboxWrapper();
        this._txtbox = r0;
        if (r0 != null) goto L9;
        this._txtbox = new EscherTextboxWrapper();
        createEmptyParagraph();
    L16:
        Iterator<HSLFTextParagraph> r1 = this._paragraphs.iterator();
    L18:
        if (r1.hasNext() == false) goto L21;
        ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r1.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).setParentShape(this);
        goto L18
    L21:
        return this._paragraphs;
    L9:
        List<HSLFTextParagraph> r2 = HSLFTextParagraph.findTextParagraphs(r0, getSheet());
        if (r2 != null) goto L12;
        createEmptyParagraph();
    L14:
        if (this._paragraphs.isEmpty() == false) goto L16;
        LOG.atWarn().a("TextRecord didn't contained any text lines");
        goto L16
    L12:
        this._paragraphs = r2;
        goto L14
    L5:
        return this._paragraphs;
    }

    @Override // java.lang.Iterable
    public Iterator<HSLFTextParagraph> iterator() {
        return this._paragraphs.iterator();
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public void setSheet(HSLFSheet r1) {
        super.setSheet(r1);
        HSLFTextParagraph.supplySheet(getTextParagraphs(), r1);
    }

    @Override // java.lang.Iterable
    public Spliterator<HSLFTextParagraph> spliterator() {
        return this._paragraphs.spliterator();
    }
}
