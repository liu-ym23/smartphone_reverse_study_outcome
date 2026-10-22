package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.common.FormatRun;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFRichTextString implements Comparable<HSSFRichTextString>, RichTextString {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private InternalWorkbook _book;
    private LabelSSTRecord _record;
    private UnicodeString _string;

    static {
    }

    public HSSFRichTextString() {
        this("");
    }

    public HSSFRichTextString(String r2) {
        if (r2 != null) goto L5;
        this._string = new UnicodeString("");
        return;
    L5:
        this._string = new UnicodeString(r2);
    }

    HSSFRichTextString(InternalWorkbook r1, LabelSSTRecord r2) {
        setWorkbookReferences(r1, r2);
        this._string = r1.getSSTString(r2.getSSTIndex());
    }

    private void addToSSTIfRequired() {
        InternalWorkbook r0 = this._book;
        if (r0 == null) goto L6;
        int r1 = r0.addSSTString(this._string);
        this._record.setSSTIndex(r1);
        this._string = this._book.getSSTString(r1);
        return;
    }

    private UnicodeString cloneStringIfRequired() {
        InternalWorkbook r0 = this._book;
        UnicodeString r1 = this._string;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r1.copy();
    }

    public void applyFont(int r6, int r7, short r8) {
        if (r6 > r7) goto L28;
        if (r6 < 0) goto L26;
        if (r7 > length()) goto L26;
        if (r6 != r7) goto L8;
        return;
    L8:
        short r0 = 0;
        if (r7 == length()) goto L11;
        r0 = getFontAtIndex(r7);
    L11:
        UnicodeString r1 = cloneStringIfRequired();
        this._string = r1;
        Iterator<FormatRun> r2 = r1.formatIterator();
        if (r2 != null) goto L14;
    L20:
        this._string.addFormatRun(new FormatRun((short) r6, r8));
        if (r7 == length()) goto L23;
        this._string.addFormatRun(new FormatRun((short) r7, r0));
    L23:
        addToSSTIfRequired();
        return;
    L14:
        if (r2.hasNext() == false) goto L20;
        FormatRun r3 = (FormatRun) ZeusTransformUtils.preCheckCast(r2.next(), FormatRun.class, "com.obric.memorydata.plugin");
        if (r3.getCharacterPos() < r6) goto L14;
        if (r3.getCharacterPos() >= r7) goto L14;
        r2.remove();
    L26:
        throw new IllegalArgumentException("Start and end index not in range.");
    L28:
        throw new IllegalArgumentException("Start index must be less than end index.");
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(HSSFRichTextString r3) {
        return compareTo2((HSSFRichTextString) ZeusTransformUtils.preCheckCast(r3, HSSFRichTextString.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HSSFRichTextString r1) {
        return this._string.compareTo2(r1._string);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, HSSFRichTextString.class) == true) goto L5;
        return false;
    L5:
        return this._string.equals(((HSSFRichTextString) ZeusTransformUtils.preCheckCast(r3, HSSFRichTextString.class, "com.obric.memorydata.plugin"))._string);
    }

    public short getFontAtIndex(int r7) {
        int r0 = this._string.getFormatRunCount();
        FormatRun r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        FormatRun r4 = this._string.getFormatRun(r3);
        if (r4.getCharacterPos() > r7) goto L8;
        r3 = r3 + 1;
        r2 = r4;
    L8:
        if (r2 != null) goto L11;
        return 0;
    L11:
        return r2.getFontIndex();
    }

    public short getFontOfFormattingRun(int r1) {
        return this._string.getFormatRun(r1).getFontIndex();
    }

    public int getIndexOfFormattingRun(int r1) {
        return this._string.getFormatRun(r1).getCharacterPos();
    }

    @Override // org.apache.poi.ss.usermodel.RichTextString
    public String getString() {
        return this._string.getString();
    }

    UnicodeString getUnicodeString() {
        return cloneStringIfRequired();
    }

    public int hashCode() {
        return 42;
    }

    public int length() {
        return this._string.getCharCount();
    }

    public int numFormattingRuns() {
        return this._string.getFormatRunCount();
    }

    void setUnicodeString(UnicodeString r1) {
        this._string = r1;
    }

    void setWorkbookReferences(InternalWorkbook r1, LabelSSTRecord r2) {
        this._book = r1;
        this._record = r2;
    }

    public String toString() {
        return this._string.toString();
    }
}
