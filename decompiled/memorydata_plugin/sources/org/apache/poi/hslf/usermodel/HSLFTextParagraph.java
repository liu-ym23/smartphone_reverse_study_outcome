package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.model.textproperties.IndentProp;
import org.apache.poi.hslf.model.textproperties.TextProp;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.hslf.record.EscherTextboxWrapper;
import org.apache.poi.hslf.record.MasterTextPropAtom;
import org.apache.poi.hslf.record.OutlineTextRefAtom;
import org.apache.poi.hslf.record.PPDrawing;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.RecordContainer;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.hslf.record.SlideListWithText;
import org.apache.poi.hslf.record.SlidePersistAtom;
import org.apache.poi.hslf.record.StyleTextProp9Atom;
import org.apache.poi.hslf.record.StyleTextPropAtom;
import org.apache.poi.hslf.record.TextBytesAtom;
import org.apache.poi.hslf.record.TextCharsAtom;
import org.apache.poi.hslf.record.TextHeaderAtom;
import org.apache.poi.hslf.record.TextRulerAtom;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.sl.usermodel.TextShape;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFTextParagraph implements TextParagraph<HSLFShape, HSLFTextParagraph, HSLFTextRun> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private TextBytesAtom _byteAtom;
    private TextCharsAtom _charAtom;
    private boolean _dirty;
    private final TextHeaderAtom _headerAtom;
    private TextPropCollection _paragraphStyle;
    protected HSLFTextShape _parentShape;
    protected TextRulerAtom _ruler;
    protected final List<HSLFTextRun> _runs;
    private HSLFSheet _sheet;
    private final List<HSLFTextParagraph> parentList;
    private int shapeId;
    private StyleTextProp9Atom styleTextProp9Atom;

    static {
        LOG = b.a(HSLFTextParagraph.class);
    }

    HSLFTextParagraph(TextHeaderAtom r3, TextBytesAtom r4, TextCharsAtom r5, List<HSLFTextParagraph> r6) {
        List<HSLFTextParagraph> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this._runs = new ArrayList();
        if (r3 == null) goto L7;
        this._headerAtom = r3;
        this._byteAtom = r4;
        this._charAtom = r5;
        this.parentList = r7;
        setParagraphStyle(new TextPropCollection(1, TextPropCollection.TextPropType.paragraph));
        return;
    L7:
        throw new IllegalArgumentException("TextHeaderAtom must be set.");
    }

    public static void applyCharacterStyles(List<HSLFTextParagraph> r14, List<TextPropCollection> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2 >= r17.size()) goto L28;
        TextPropCollection r5 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r17.get(r2), TextPropCollection.class, "com.obric.memorydata.plugin");
        int r6 = r5.getCharactersCovered();
        if (r6 > 20000) goto L27;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L25;
        HSLFTextParagraph r8 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r16.get(r3), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        List<HSLFTextRun> r9 = r8.getTextRuns();
        HSLFTextRun r10 = (HSLFTextRun) ZeusTransformUtils.preCheckCast(r9.get(r4), HSLFTextRun.class, "com.obric.memorydata.plugin");
        int r11 = r10.getLength() + r7;
        if (r11 <= r6) goto L13;
        String r12 = r10.getRawText();
        int r13 = r6 - r7;
        r10.setText(r12.substring(0, r13));
        HSLFTextRun r18 = new HSLFTextRun(r8);
        r18.setText(r12.substring(r13));
        r9.add(r4 + 1, r18);
        r11 = r7 + r13;
    L13:
        r10.setCharacterStyle(r5);
        if (r3 == (r16.size() - 1)) goto L16;
    L22:
        r7 = r11;
        r4 = r4 + 1;
        if (r4 != r9.size()) goto L8;
        r3 = r3 + 1;
        r4 = 0;
        goto L8
    L16:
        if (r4 != (r9.size() - 1)) goto L22;
        if (r2 >= (r17.size() - 1)) goto L20;
        HSLFTextRun r19 = new HSLFTextRun(r8);
        r19.setText("");
        r9.add(r19);
    L21:
        r11 = r11 + 1;
        goto L22
    L20:
        r10.getCharacterStyle().updateTextSize(r10.getLength() + 1);
        goto L21
    L25:
        r2 = r2 + 1;
        goto L4
    L27:
        throw new IllegalStateException("Cannot process more than 20000 styles, but had paragraph with " + r6);
    }

    public static void applyHyperlinks(List<HSLFTextParagraph> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Iterator<HSLFHyperlink> r0 = HSLFHyperlink.find(r15).iterator();
    L4:
        if (r0.hasNext() == false) goto L26;
        HSLFHyperlink r2 = (HSLFHyperlink) ZeusTransformUtils.preCheckCast(r0.next(), HSLFHyperlink.class, "com.obric.memorydata.plugin");
        Iterator r3 = r15.iterator();
        int r5 = 0;
    L7:
        if (r3.hasNext() == false) goto L4;
        HSLFTextParagraph r6 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r3.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        if (r5 > r2.getEndIndex()) goto L4;
        List<HSLFTextRun> r7 = r6.getTextRuns();
        int r8 = 0;
    L13:
        if (r8 >= r7.size()) goto L7;
        HSLFTextRun r9 = (HSLFTextRun) ZeusTransformUtils.preCheckCast(r7.get(r8), HSLFTextRun.class, "com.obric.memorydata.plugin");
        int r10 = r9.getLength();
        if (r5 >= r2.getEndIndex()) goto L25;
        if (r2.getStartIndex() >= (r5 + r10)) goto L25;
        String r11 = r9.getRawText();
        int r12 = r2.getStartIndex() - r5;
        if (r12 <= 0) goto L21;
        HSLFTextRun r13 = new HSLFTextRun(r6);
        r13.setCharacterStyle(r9.getCharacterStyle());
        r13.setText(r11.substring(r12));
        r9.setText(r11.substring(0, r12));
        r7.add(r8 + 1, r13);
        r10 = r12;
        goto L25
    L21:
        int r16 = Math.min(r10, r2.getEndIndex() - r2.getStartIndex());
        if (r16 >= r10) goto L24;
        HSLFTextRun r17 = new HSLFTextRun(r6);
        r17.setCharacterStyle(r9.getCharacterStyle());
        r17.setText(r11.substring(0, r16));
        r9.setText(r11.substring(r16));
        r7.add(r8, r17);
        r9 = r17;
        r10 = r16;
    L24:
        r9.setHyperlink(r2);
    L25:
        r5 = r5 + r10;
        r8 = r8 + 1;
        goto L13
    }

    public static void applyParagraphIndents(List<HSLFTextParagraph> r11, List<IndentProp> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L4:
        if (r14.hasNext() == false) goto L17;
        IndentProp r3 = (IndentProp) ZeusTransformUtils.preCheckCast(r14.next(), IndentProp.class, "com.obric.memorydata.plugin");
        int r4 = r3.getCharactersCovered();
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L4;
        if (r2 >= r13.size()) goto L25;
        if (r5 >= (r4 - 1)) goto L26;
        HSLFTextParagraph r6 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r13.get(r2), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        Iterator<HSLFTextRun> r7 = r6.getTextRuns().iterator();
        int r8 = 0;
    L14:
        if (r7.hasNext() == false) goto L16;
        r8 = r8 + ((HSLFTextRun) ZeusTransformUtils.preCheckCast(r7.next(), HSLFTextRun.class, "com.obric.memorydata.plugin")).getLength();
        goto L14
    L16:
        r6.setIndentLevel(r3.getIndentLevel());
        r5 = r5 + (r8 + 1);
        r2 = r2 + 1;
        goto L6
    L26:
        return;
    L25:
        return;
    }

    public static void applyParagraphStyles(List<HSLFTextParagraph> r11, List<TextPropCollection> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L4:
        if (r14.hasNext() == false) goto L18;
        TextPropCollection r3 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r14.next(), TextPropCollection.class, "com.obric.memorydata.plugin");
        int r4 = r3.getCharactersCovered();
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L4;
        if (r2 >= r13.size()) goto L9;
        HSLFTextParagraph r6 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r13.get(r2), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        TextPropCollection r7 = r3.copy();
        r6.setParagraphStyle(r7);
        Iterator<HSLFTextRun> r8 = r6.getTextRuns().iterator();
        int r9 = 0;
    L12:
        if (r8.hasNext() == false) goto L15;
        r9 = r9 + ((HSLFTextRun) ZeusTransformUtils.preCheckCast(r8.next(), HSLFTextRun.class, "com.obric.memorydata.plugin")).getLength();
        goto L12
    L15:
        if (r2 != (r13.size() - 1)) goto L17;
        r9 = r9 + 1;
    L17:
        r7.updateTextSize(r9);
        r5 = r5 + r9;
        r2 = r2 + 1;
        goto L6
    L9:
        return;
    }

    private static StyleTextPropAtom findStyleAtomPresent(TextHeaderAtom r12, int r13) {
        Record[] r0 = r12.getParentRecord().getChildRecords();
        int r1 = r0.length;
        StyleTextPropAtom r3 = null;
        int r4 = 0;
        boolean r5 = false;
    L3:
        boolean r6 = true;
        if (r4 >= r1) goto L19;
        Record r7 = r0[r4];
        long r8 = r7.getRecordType();
        if (r5 == true) goto L8;
    L10:
        if (r12 == r7) goto L13;
        r6 = false;
    L13:
        r5 = r5 | r6;
        if (r5 == false) goto L18;
        if (r8 != RecordTypes.StyleTextPropAtom.typeID) goto L18;
        r3 = (StyleTextPropAtom) ZeusTransformUtils.preCheckCast(r7, StyleTextPropAtom.class, "com.obric.memorydata.plugin");
    L18:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r8 != RecordTypes.TextHeaderAtom.typeID) goto L10;
    L19:
        if (r3 != null) goto L24;
        LOG.atInfo().a("styles atom doesn't exist. Creating dummy record for later saving.");
        if (r13 >= 0) goto L23;
        r13 = 1;
    L23:
        r3 = new StyleTextPropAtom(r13);
    L26:
        return r3;
    L24:
        if (r13 < 0) goto L26;
        r3.setParentTextSize(r13);
        goto L26
    }

    public static List<HSLFTextParagraph> findTextParagraphs(EscherTextboxWrapper r8, HSLFSheet r9) {
        RecordContainer.handleParentAwareRecords(r8);
        int r1 = r8.getShapeId();
        OutlineTextRefAtom r2 = (OutlineTextRefAtom) ZeusTransformUtils.preCheckCast(r8.findFirstOfType(RecordTypes.OutlineTextRefAtom.typeID), OutlineTextRefAtom.class, "com.obric.memorydata.plugin");
        List<HSLFTextParagraph> r5 = null;
        if (r2 == null) goto L24;
        if (r9 == null) goto L23;
        List<List<HSLFTextParagraph>> r10 = r9.getTextParagraphs();
        int r3 = r2.getTextIndex();
        Iterator<List<HSLFTextParagraph>> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L18;
        List<HSLFTextParagraph> r6 = (List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == true) goto L7;
        int r7 = ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r6.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).getIndex();
        if (r7 > r3) goto L18;
        if (r7 != r3) goto L7;
        if (r5 == null) goto L16;
        ArrayList r12 = new ArrayList(r5);
        r12.addAll(r6);
        r5 = r12;
        goto L7
    L16:
        r5 = r6;
    L18:
        if (r5 != null) goto L20;
    L21:
        LOG.atWarn().a("text run not found for OutlineTextRefAtom.TextIndex={}", v.a(r3));
    L41:
        if (r5 == null) goto L46;
        StyleTextProp9Atom r13 = r8.getStyleTextProp9Atom();
        Iterator<HSLFTextParagraph> r14 = r5.iterator();
    L44:
        if (r14.hasNext() == false) goto L46;
        HSLFTextParagraph r4 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r14.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        r4.setShapeId(r1);
        r4.setStyleTextProp9Atom(r13);
    L46:
        return r5;
    L20:
        if (r5.isEmpty() == false) goto L41;
    L23:
        throw new HSLFException("Outline atom reference can't be solved without a sheet record");
    L24:
        if (r9 == null) goto L33;
        Iterator<List<HSLFTextParagraph>> r15 = r9.getTextParagraphs().iterator();
    L27:
        if (r15.hasNext() == false) goto L33;
        List<HSLFTextParagraph> r16 = (List) ZeusTransformUtils.preCheckCast(r15.next(), List.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == true) goto L27;
        if (((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r16.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin"))._headerAtom.getParentRecord() != r8) goto L27;
        r5 = r16;
    L33:
        if (r5 != null) goto L41;
        List<List<HSLFTextParagraph>> r17 = findTextParagraphs(r8.getChildRecords());
        int r18 = r17.size();
        if (r18 == 0) goto L41;
        if (r18 != 1) goto L40;
        r5 = (List) ZeusTransformUtils.preCheckCast(r17.get(0), List.class, "com.obric.memorydata.plugin");
        goto L41
    L40:
        throw new HSLFException("TextBox contains more than one list of paragraphs.");
    }

    public static List<List<HSLFTextParagraph>> findTextParagraphs(PPDrawing r4, HSLFSheet r5) {
        if (r4 == null) goto L11;
        ArrayList r0 = new ArrayList();
        EscherTextboxWrapper[] r6 = r4.getTextboxWrappers();
        int r1 = r6.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        List<HSLFTextParagraph> r3 = findTextParagraphs(r6[r2], r5);
        if (r3 == null) goto L8;
        r0.add(r3);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    L11:
        throw new IllegalArgumentException("Did not receive a valid drawing for sheet " + r5._getSheetNumber());
    }

    public static List<List<HSLFTextParagraph>> findTextParagraphs(Record[] r19) {
        ArrayList r1 = new ArrayList();
        int r3 = 0;
        int[] r2 = {0};
        int r4 = 0;
    L4:
        if (r2[r3] >= r19.length) goto L43;
        TextHeaderAtom r5 = null;
        Record[] r6 = getRecords(r19, r2, null);
        int r7 = r6.length;
        int r12 = r3;
        TextBytesAtom r8 = null;
        TextCharsAtom r9 = null;
        TextRulerAtom r10 = null;
        MasterTextPropAtom r11 = null;
    L6:
        if (r12 >= r7) goto L23;
        Record r13 = r6[r12];
        long r14 = r13.getRecordType();
        int[] r16 = r2;
        if (RecordTypes.TextHeaderAtom.typeID != r14) goto L10;
        r5 = (TextHeaderAtom) ZeusTransformUtils.preCheckCast(r13, TextHeaderAtom.class, "com.obric.memorydata.plugin");
        Record[] r17 = r6;
        int r18 = r7;
    L22:
        r12 = r12 + 1;
        r2 = r16;
        r6 = r17;
        r7 = r18;
        goto L6
    L10:
        r17 = r6;
        r18 = r7;
        if (RecordTypes.TextBytesAtom.typeID != r14) goto L14;
        r8 = (TextBytesAtom) ZeusTransformUtils.preCheckCast(r13, TextBytesAtom.class, "com.obric.memorydata.plugin");
        goto L22
    L14:
        if (RecordTypes.TextCharsAtom.typeID != r14) goto L17;
        r9 = (TextCharsAtom) ZeusTransformUtils.preCheckCast(r13, TextCharsAtom.class, "com.obric.memorydata.plugin");
        goto L22
    L17:
        if (RecordTypes.TextRulerAtom.typeID != r14) goto L20;
        r10 = (TextRulerAtom) ZeusTransformUtils.preCheckCast(r13, TextRulerAtom.class, "com.obric.memorydata.plugin");
        goto L22
    L20:
        if (RecordTypes.MasterTextPropAtom.typeID != r14) goto L22;
        r11 = (MasterTextPropAtom) ZeusTransformUtils.preCheckCast(r13, MasterTextPropAtom.class, "com.obric.memorydata.plugin");
        goto L22
    L23:
        int[] r110 = r2;
        if (r5 == null) goto L43;
        if (ZeusTransformUtils.instanceOf(r5.getParentRecord(), SlideListWithText.class) == false) goto L29;
        r5.setIndex(r4);
    L29:
        if (r8 != null) goto L32;
        if (r9 != null) goto L32;
        r8 = new TextBytesAtom();
        LOG.atInfo().a("bytes nor chars atom doesn't exist. Creating dummy record for later saving.");
    L32:
        if (r9 == null) goto L34;
        String r15 = r9.getText();
    L35:
        StyleTextPropAtom r20 = findStyleAtomPresent(r5, r15.length());
        ArrayList r21 = new ArrayList();
        r1.add(r21);
        String[] r22 = r15.split("(?<=\r)");
        int r23 = r22.length;
        int r111 = 0;
    L36:
        if (r111 >= r23) goto L38;
        String r112 = r22[r111];
        HSLFTextParagraph r113 = new HSLFTextParagraph(r5, r8, r9, r21);
        r21.add(r113);
        r113._ruler = r10;
        r113.getParagraphStyle().updateTextSize(r112.length());
        HSLFTextRun r0 = new HSLFTextRun(r113);
        r113.addTextRun(r0);
        r0.setText(r112);
        r111 = r111 + 1;
        goto L36
    L38:
        applyCharacterStyles(r21, r20.getCharacterStyles());
        applyParagraphStyles(r21, r20.getParagraphStyles());
        if (r11 == null) goto L41;
        applyParagraphIndents(r21, r11.getIndents());
    L41:
        r4 = r4 + 1;
        r2 = r110;
        r3 = 0;
        goto L4
    L34:
        r15 = r8.getText();
    L43:
        if (r1.isEmpty() == false) goto L45;
        LOG.atDebug().a("No text records found.");
    L45:
        return r1;
    }

    public static String getRawText(List<HSLFTextParagraph> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        Iterator<HSLFTextRun> r2 = ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r7.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).getTextRuns().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r0.append(((HSLFTextRun) ZeusTransformUtils.preCheckCast(r2.next(), HSLFTextRun.class, "com.obric.memorydata.plugin")).getRawText());
        goto L7
    L10:
        return r0.toString();
    }

    private static Record[] getRecords(Record[] r4, int[] r5, TextHeaderAtom r6) {
        Objects.requireNonNull(r4, "records need to be set.");
    L3:
        int r3 = 1;
        if (r5[0] >= r4.length) goto L12;
        Record r1 = r4[r5[0]];
        if (ZeusTransformUtils.instanceOf(r1, TextHeaderAtom.class) == false) goto L10;
        if (r6 == null) goto L12;
        if (r1 == r6) goto L12;
    L10:
        r5[0] = r5[0] + 1;
    L12:
        if (r5[0] < r4.length) goto L16;
        LOG.atInfo().a("header atom wasn't found - container might contain only an OutlineTextRefAtom");
        return new Record[0];
    L16:
        if ((r5[0] + r3) >= r4.length) goto L23;
        Record r7 = r4[r5[0] + r3];
        if (ZeusTransformUtils.instanceOf(r7, TextHeaderAtom.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, SlidePersistAtom.class) == true) goto L23;
        r3 = r3 + 1;
    L23:
        Record[] r8 = (Record[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r4, r5[0], r5[0] + r3, Record[].class), Record[].class, "com.obric.memorydata.plugin");
        r5[0] = r5[0] + r3;
        return r8;
    }

    static /* synthetic */ void lambda$setPropVal$2(Integer r0, TextProp r1) {
        r1.setValue(r0.intValue());
    }

    private void setPropValInner(TextPropCollection r5, String r6, Consumer<? extends TextProp> r7) {
        Consumer r8 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r7, Consumer.class, "com.obric.memorydata.plugin");
        if (r5.getTextPropType() != TextPropCollection.TextPropType.character) goto L5;
        boolean r0 = true;
    L7:
        if (ZeusTransformUtils.instanceOf(this._sheet, HSLFMasterSheet.class) == false) goto L13;
        r5 = ((HSLFMasterSheet) ZeusTransformUtils.preCheckCast(this._sheet, HSLFMasterSheet.class, "com.obric.memorydata.plugin")).getPropCollection(getRunType(), getIndentLevel(), "*", r0);
        if (r5 != null) goto L13;
        throw new HSLFException("Master text property collection can't be determined.");
    L13:
        if (r8 != null) goto L15;
        r5.removeByName(r6);
    L16:
        setDirty();
        return;
    L15:
        r8.accept(r5.addWithName(r6));
        goto L16
    L5:
        r0 = false;
        goto L7
    }

    public static void supplySheet(List<HSLFTextParagraph> r3, HSLFSheet r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r6.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).supplySheet(r4);
        goto L7
    }

    private void supplySheet(HSLFSheet r3) {
        this._sheet = r3;
        Iterator<HSLFTextRun> r2 = this._runs.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((HSLFTextRun) ZeusTransformUtils.preCheckCast(r2.next(), HSLFTextRun.class, "com.obric.memorydata.plugin")).updateSheet();
        goto L4
    }

    public static String toExternalString(String r2, int r3) {
        char r1 = '\n';
        String r4 = r2.replace('\r', '\n');
        if (r3 == (-1)) goto L11;
        if (r3 == TextShape.TextPlaceholder.TITLE.nativeId) goto L11;
        if (r3 == TextShape.TextPlaceholder.CENTER_TITLE.nativeId) goto L11;
        r1 = ' ';
    L11:
        return r4.replace(11, r1);
    }

    public static String toInternalString(String r2) {
        return r2.replaceAll("\\r?\\n", "\r");
    }

    public void addTextRun(HSLFTextRun r1) {
        this._runs.add(r1);
    }

    public int getIndentLevel() {
        TextPropCollection r0 = this._paragraphStyle;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getIndentLevel();
    }

    public int getIndex() {
        TextHeaderAtom r0 = this._headerAtom;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getIndex();
    }

    public TextPropCollection getParagraphStyle() {
        return this._paragraphStyle;
    }

    public Record[] getRecords() {
        return getRecords(this._headerAtom.getParentRecord().getChildRecords(), new int[]{0}, this._headerAtom);
    }

    public int getRunType() {
        TextHeaderAtom r0 = this._headerAtom;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getTextType();
    }

    public HSLFSheet getSheet() {
        return this._sheet;
    }

    public List<HSLFTextRun> getTextRuns() {
        return this._runs;
    }

    @Override // java.lang.Iterable
    public Iterator<HSLFTextRun> iterator() {
        return this._runs.iterator();
    }

    public void setDirty() {
        this._dirty = true;
    }

    public void setIndentLevel(int r1) {
        TextPropCollection r0 = this._paragraphStyle;
        if (r0 == null) goto L6;
        r0.setIndentLevel((short) r1);
        return;
    }

    public void setParagraphStyle(TextPropCollection r1) {
        this._paragraphStyle = r1;
    }

    public void setParentShape(HSLFTextShape r1) {
        this._parentShape = r1;
    }

    public void setPropVal(TextPropCollection r2, String r3, final Integer r4) {
        if (r4 != null) goto L4;
        Consumer<? extends TextProp> r5 = null;
    L5:
        setPropValInner(r2, r3, r5);
        return;
    L4:
        r5 = new $$Lambda$HSLFTextParagraph$6iHTvrVwmkjMSdOgUVVeWuibEFo(r4);
        goto L5
    }

    public void setShapeId(int r1) {
        this.shapeId = r1;
    }

    public void setStyleTextProp9Atom(StyleTextProp9Atom r1) {
        this.styleTextProp9Atom = r1;
    }

    @Override // java.lang.Iterable
    public Spliterator<HSLFTextRun> spliterator() {
        return this._runs.spliterator();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<HSLFTextRun> r1 = getTextRuns().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.append(((HSLFTextRun) ZeusTransformUtils.preCheckCast(r1.next(), HSLFTextRun.class, "com.obric.memorydata.plugin")).getRawText());
        goto L4
    L7:
        return toExternalString(r0.toString(), getRunType());
    }
}
