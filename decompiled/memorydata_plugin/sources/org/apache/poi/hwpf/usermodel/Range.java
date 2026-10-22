package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.model.CHPX;
import org.apache.poi.hwpf.model.FileInformationBlock;
import org.apache.poi.hwpf.model.PAPX;
import org.apache.poi.hwpf.model.PropertyNode;
import org.apache.poi.hwpf.model.SEPX;
import org.apache.poi.hwpf.model.SubdocumentType;
import org.apache.poi.util.DocumentFormatException;

/* JADX INFO: loaded from: classes7.dex */
public class Range {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    protected int _charEnd;
    protected boolean _charRangeFound;
    protected int _charStart;
    protected List<CHPX> _characters;
    protected final HWPFDocumentCore _doc;
    protected int _end;
    protected int _parEnd;
    protected boolean _parRangeFound;
    protected int _parStart;
    protected final List<PAPX> _paragraphs;
    private final Range _parent;
    protected int _sectionEnd;
    boolean _sectionRangeFound;
    protected int _sectionStart;
    protected final List<SEPX> _sections;
    protected final int _start;
    protected StringBuilder _text;

    static {
        LOG = b.a(Range.class);
    }

    public Range(int r1, int r2, HWPFDocumentCore r3) {
        this._start = r1;
        this._end = r2;
        this._doc = r3;
        this._sections = r3.getSectionTable().getSections();
        this._paragraphs = r3.getParagraphTable().getParagraphs();
        this._characters = r3.getCharacterTable().getTextRuns();
        this._text = r3.getText();
        this._parent = null;
        sanityCheckStartEnd();
    }

    public Range(int r1, int r2, Range r3) {
        this._start = r1;
        this._end = r2;
        this._doc = r3._doc;
        this._sections = r3._sections;
        this._paragraphs = r3._paragraphs;
        this._characters = r3._characters;
        this._text = r3._text;
        this._parent = r3;
        sanityCheckStartEnd();
        sanityCheck();
    }

    private void adjustForInsert(int r2) {
        this._end += r2;
        reset();
        Range r1 = this._parent;
        if (r1 == null) goto L6;
        r1.adjustForInsert(r2);
        return;
    }

    private static int binarySearchEnd(List<? extends PropertyNode<?>> r5, int r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r8.get(r8.size() - 1), PropertyNode.class, "com.obric.memorydata.plugin")).getEnd() <= r7) goto L5;
        int r0 = r8.size() - 1;
    L7:
        if (r6 > r0) goto L15;
        int r2 = (r6 + r0) >>> 1;
        PropertyNode r3 = (PropertyNode) ZeusTransformUtils.preCheckCast(r8.get(r2), PropertyNode.class, "com.obric.memorydata.plugin");
        if (r3.getEnd() < r7) goto L10;
        if (r3.getEnd() <= r7) goto L14;
        r0 = r2 - 1;
        goto L7
    L14:
        return r2;
    L10:
        r6 = r2 + 1;
        goto L7
    L15:
        return r6;
    L5:
        return r8.size() - 1;
    }

    private static int binarySearchStart(List<? extends PropertyNode<?>> r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = 0;
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r8.get(0), PropertyNode.class, "com.obric.memorydata.plugin")).getStart() < r7) goto L9;
        return 0;
    L9:
        int r2 = r8.size() - 1;
    L10:
        if (r0 > r2) goto L19;
        int r3 = (r0 + r2) >>> 1;
        PropertyNode r4 = (PropertyNode) ZeusTransformUtils.preCheckCast(r8.get(r3), PropertyNode.class, "com.obric.memorydata.plugin");
        if (r4.getStart() < r7) goto L13;
        if (r4.getStart() <= r7) goto L17;
        r2 = r3 - 1;
        goto L10
    L17:
        return r3;
    L13:
        r0 = r3 + 1;
        goto L10
    L19:
        return r0 - 1;
    }

    private int[] findRange(List<? extends PropertyNode<?>> r6, int r7, int r8) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r9 = binarySearchStart(r5, r7);
    L3:
        if (r9 <= 0) goto L7;
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r5.get(r9 - 1), PropertyNode.class, "com.obric.memorydata.plugin")).getStart() < r7) goto L7;
        r9 = r9 - 1;
    L7:
        int r10 = binarySearchEnd(r5, r9, r8);
    L9:
        if (r10 >= (r5.size() - 1)) goto L13;
        int r1 = r10 + 1;
        if (((PropertyNode) ZeusTransformUtils.preCheckCast(r5.get(r1), PropertyNode.class, "com.obric.memorydata.plugin")).getEnd() > r8) goto L13;
        r10 = r1;
    L13:
        if (r9 < 0) goto L23;
        if (r9 >= r5.size()) goto L23;
        if (r9 > r10) goto L23;
        if (r10 < 0) goto L23;
        if (r10 >= r5.size()) goto L23;
        return new int[]{r9, r10 + 1};
    L23:
        throw new DocumentFormatException("problem finding range");
    }

    private int[] findRange(List<? extends PropertyNode<?>> r6, int r7, int r8, int r9) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r5.size() == r7) goto L5;
    L6:
        PropertyNode r10 = (PropertyNode) ZeusTransformUtils.preCheckCast(r5.get(r7), PropertyNode.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L9;
    L40:
        r7 = r7 + 1;
        if (r7 < r5.size()) goto L6;
        return new int[]{0, 0};
    L9:
        if (r10.getEnd() > r8) goto L14;
        if (r7 < (r5.size() - 1)) goto L40;
    L14:
        if (r10.getStart() <= r9) goto L18;
        return new int[]{0, 0};
    L18:
        if (r10.getEnd() <= r8) goto L20;
        int r11 = r7;
    L23:
        if (r11 >= r5.size()) goto L39;
        PropertyNode r12 = (PropertyNode) ZeusTransformUtils.preCheckCast(r5.get(r11), PropertyNode.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L31;
        if (r12.getStart() >= r9) goto L33;
        if (r12.getEnd() <= r9) goto L31;
    L33:
        if (r12.getStart() >= r9) goto L37;
        return new int[]{r7, r11 + 1};
    L37:
        return new int[]{r7, r11};
    L31:
        r11 = r11 + 1;
        goto L23
    L39:
        return new int[]{r7, r5.size()};
    L20:
        return new int[]{r5.size(), r5.size()};
    L5:
        return new int[]{r7, r7};
    }

    private void initCharacterRuns() {
        if (this._charRangeFound == true) goto L6;
        int[] r0 = findRange(this._characters, this._start, this._end);
        this._charStart = r0[0];
        this._charEnd = r0[1];
        this._charRangeFound = true;
        return;
    }

    private void initParagraphs() {
        if (this._parRangeFound == true) goto L6;
        int[] r0 = findRange(this._paragraphs, this._start, this._end);
        this._parStart = r0[0];
        this._parEnd = r0[1];
        this._parRangeFound = true;
        return;
    }

    private void initSections() {
        if (this._sectionRangeFound == true) goto L6;
        int[] r0 = findRange(this._sections, this._sectionStart, this._start, this._end);
        this._sectionStart = r0[0];
        this._sectionEnd = r0[1];
        this._sectionRangeFound = true;
        return;
    }

    private void sanityCheckStartEnd() {
        int r0 = this._start;
        if (r0 < 0) goto L10;
        if (this._end < r0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("The end (" + this._end + ") must not be before the start (" + this._start + ")");
    L10:
        throw new IllegalArgumentException("Range start must not be negative. Given " + this._start);
    }

    public void adjustFIB(int r7) {
        if (ZeusTransformUtils.instanceOf(this._doc, HWPFDocument.class) == false) goto L13;
        FileInformationBlock r0 = this._doc.getFileInformationBlock();
        int r1 = 0;
        Iterator<SubdocumentType> r2 = SubdocumentType.ORDERED.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        SubdocumentType r3 = (SubdocumentType) ZeusTransformUtils.preCheckCast(r2.next(), SubdocumentType.class, "com.obric.memorydata.plugin");
        int r4 = r0.getSubdocumentTextStreamLength(r3);
        r1 = r1 + r4;
        if (this._start > r1) goto L6;
        r0.setSubdocumentTextStreamLength(r3, r4 + r7);
        return;
    L17:
        return;
    L13:
        throw new IllegalArgumentException("doc must be instance of HWPFDocument");
    }

    public void delete() {
        initAll();
        int r0 = this._sections.size();
        int r1 = this._characters.size();
        int r2 = this._paragraphs.size();
        int r3 = this._charStart;
    L4:
        if (r3 >= r1) goto L6;
        CHPX r4 = (CHPX) ZeusTransformUtils.preCheckCast(this._characters.get(r3), CHPX.class, "com.obric.memorydata.plugin");
        int r5 = this._start;
        r4.adjustForDelete(r5, this._end - r5);
        r3 = r3 + 1;
        goto L4
    L6:
        int r6 = this._parStart;
    L7:
        if (r6 >= r2) goto L9;
        PAPX r7 = (PAPX) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r6), PAPX.class, "com.obric.memorydata.plugin");
        int r8 = this._start;
        r7.adjustForDelete(r8, this._end - r8);
        r6 = r6 + 1;
        goto L7
    L9:
        int r9 = this._sectionStart;
    L10:
        if (r9 >= r0) goto L13;
        SEPX r10 = (SEPX) ZeusTransformUtils.preCheckCast(this._sections.get(r9), SEPX.class, "com.obric.memorydata.plugin");
        int r11 = this._start;
        r10.adjustForDelete(r11, this._end - r11);
        r9 = r9 + 1;
        goto L10
    L13:
        if (ZeusTransformUtils.instanceOf(this._doc, HWPFDocument.class) == false) goto L15;
        BookmarksImpl r12 = (BookmarksImpl) ZeusTransformUtils.preCheckCast(((HWPFDocument) ZeusTransformUtils.preCheckCast(this._doc, HWPFDocument.class, "com.obric.memorydata.plugin")).getBookmarks(), BookmarksImpl.class, "com.obric.memorydata.plugin");
        int r13 = this._start;
        r12.afterDelete(r13, this._end - r13);
    L15:
        this._text.delete(this._start, this._end);
        Range r14 = this._parent;
        if (r14 == null) goto L18;
        r14.adjustForInsert(-(this._end - this._start));
    L18:
        adjustFIB(-(this._end - this._start));
    }

    public CharacterRun getCharacterRun(int r7) {
        initCharacterRuns();
        int r0 = this._charStart;
        if ((r7 + r0) >= this._charEnd) goto L17;
        CHPX r8 = (CHPX) ZeusTransformUtils.preCheckCast(this._characters.get(r7 + r0), CHPX.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(this, Paragraph.class) == false) goto L10;
        short r1 = ((Paragraph) ZeusTransformUtils.preCheckCast(this, Paragraph.class, "com.obric.memorydata.plugin"))._istd;
    L15:
        return new CharacterRun(r8, this._doc.getStyleSheet(), r1, this);
    L10:
        int[] r2 = findRange(this._paragraphs, Math.max(r8.getStart(), this._start), Math.min(r8.getEnd(), this._end));
        initParagraphs();
        if (Math.max(r2[0], this._parStart) < this._paragraphs.size()) goto L13;
        return null;
    L13:
        r1 = ((PAPX) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r2[0]), PAPX.class, "com.obric.memorydata.plugin")).getIstd();
        goto L15
    L17:
        throw new IndexOutOfBoundsException("CHPX #" + r7 + " (" + (r7 + this._charStart) + ") not in range [" + this._charStart + "; " + this._charEnd + ")");
    }

    public int getEndOffset() {
        return this._end;
    }

    public Paragraph getParagraph(int r4) {
        initParagraphs();
        int r0 = this._parStart;
        if ((r4 + r0) >= this._parEnd) goto L7;
        return Paragraph.newParagraph(this, (PAPX) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r4 + r0), PAPX.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IndexOutOfBoundsException("Paragraph #" + r4 + " (" + (r4 + this._parStart) + ") not in range [" + this._parStart + "; " + this._parEnd + ")");
    }

    public int getStartOffset() {
        return this._start;
    }

    public void initAll() {
        initCharacterRuns();
        initParagraphs();
        initSections();
    }

    public int numCharacterRuns() {
        initCharacterRuns();
        return this._charEnd - this._charStart;
    }

    public int numParagraphs() {
        initParagraphs();
        return this._parEnd - this._parStart;
    }

    public void reset() {
        this._charRangeFound = false;
        this._parRangeFound = false;
        this._sectionRangeFound = false;
    }

    public boolean sanityCheck() {
        if (this._start < 0) goto L5;
        boolean r0 = true;
    L6:
        DocumentFormatException.check(r0, "start can't be < 0");
        if (this._start > this._text.length()) goto L9;
        boolean r1 = true;
    L10:
        DocumentFormatException.check(r1, "start can't be > text length");
        if (this._end < 0) goto L13;
        boolean r2 = true;
    L14:
        DocumentFormatException.check(r2, "end can't be < 0");
        if (this._end > this._text.length()) goto L17;
        boolean r3 = true;
    L18:
        DocumentFormatException.check(r3, "end can't be > text length");
        if (this._start > this._end) goto L21;
        boolean r4 = true;
    L22:
        DocumentFormatException.check(r4, "start can't be > end");
        if (this._charRangeFound == false) goto L33;
        int r5 = this._charStart;
    L26:
        if (r5 >= this._charEnd) goto L33;
        CHPX r6 = (CHPX) ZeusTransformUtils.preCheckCast(this._characters.get(r5), CHPX.class, "com.obric.memorydata.plugin");
        if (Math.max(this._start, r6.getStart()) >= Math.min(this._end, r6.getEnd())) goto L30;
        boolean r7 = true;
    L31:
        DocumentFormatException.check(r7, "left must be < right");
        r5 = r5 + 1;
        goto L26
    L30:
        r7 = false;
    L33:
        if (this._parRangeFound == false) goto L42;
        int r8 = this._parStart;
    L36:
        if (r8 >= this._parEnd) goto L42;
        PAPX r9 = (PAPX) ZeusTransformUtils.preCheckCast(this._paragraphs.get(r8), PAPX.class, "com.obric.memorydata.plugin");
        if (Math.max(this._start, r9.getStart()) >= Math.min(this._end, r9.getEnd())) goto L40;
        boolean r10 = true;
    L41:
        DocumentFormatException.check(r10, "left must be < right");
        r8 = r8 + 1;
        goto L36
    L40:
        r10 = false;
    L42:
        return true;
    L21:
        r4 = false;
        goto L22
    L17:
        r3 = false;
        goto L18
    L13:
        r2 = false;
        goto L14
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public String text() {
        return this._text.substring(this._start, this._end);
    }

    public String toString() {
        return "Range from " + getStartOffset() + " to " + getEndOffset() + " (chars)";
    }
}
