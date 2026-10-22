package org.apache.poi.hwpf.usermodel;

import java.util.NoSuchElementException;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.model.LFO;
import org.apache.poi.hwpf.model.ListLevel;
import org.apache.poi.hwpf.model.ListTables;
import org.apache.poi.hwpf.model.PAPX;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.sprm.ParagraphSprmUncompressor;
import org.apache.poi.hwpf.sprm.SprmBuffer;

/* JADX INFO: loaded from: classes7.dex */
public class Paragraph extends Range {
    private static final c LOGGER = null;
    protected short _istd;
    protected SprmBuffer _papx;
    protected ParagraphProperties _props;

    static {
        LOGGER = b.a(Paragraph.class);
    }

    Paragraph(PAPX r4, ParagraphProperties r5, Range r6) {
        super(Math.max(r6._start, r4.getStart()), Math.min(r6._end, r4.getEnd()), r6);
        this._props = r5;
        this._papx = r4.getSprmBuf();
        this._istd = r4.getIstd();
    }

    public static Paragraph newParagraph(Range r8, PAPX r9) {
        HWPFDocumentCore r0 = r8._doc;
        ListTables r1 = r0.getListTables();
        StyleSheet r2 = r0.getStyleSheet();
        ParagraphProperties r3 = new ParagraphProperties();
        r3.setIstd(r9.getIstd());
        ParagraphProperties r4 = ParagraphSprmUncompressor.uncompressPAP(newParagraph_applyStyleProperties(r2, r9, r3), r9.getGrpprl(), 2);
        if (r4.getIlfo() == 0) goto L16;
        if (r1 == null) goto L16;
        LFO r5 = null;
        r5 = r1.getLfo(r4.getIlfo());     // Catch: NoSuchElementException -> L8
    L9:
        if (r5 == null) goto L16;
        ListLevel r6 = r1.getLevel(r5.getLsid(), r4.getIlvl());
        if (r6 == null) goto L16;
        if (r6.getGrpprlPapx() == null) goto L16;
        r4 = ParagraphSprmUncompressor.uncompressPAP(newParagraph_applyStyleProperties(r2, r9, ParagraphSprmUncompressor.uncompressPAP(r4, r6.getGrpprlPapx(), 0)), r9.getGrpprl(), 2);
    L8:
        LOGGER.atWarn().a("Paragraph refers to LFO #{} that does not exists", v.a(r4.getIlfo()));
    L16:
        if (r4.getIlfo() <= 0) goto L20;
        return new ListEntry(r9, r4, r8);
    L20:
        return new Paragraph(r9, r4, r8);
    }

    public static ParagraphProperties newParagraph_applyStyleProperties(StyleSheet r0, PAPX r1, ParagraphProperties r2) {
        if (r0 != null) goto L5;
        return r2;
    L5:
        return ParagraphSprmUncompressor.uncompressPAP(r2, r0.getPAPX(r1.getIstd()), 2);
    }

    public int getLvl() {
        return this._props.getLvl();
    }

    @Override // org.apache.poi.hwpf.usermodel.Range
    public String toString() {
        return "Paragraph [" + getStartOffset() + "; " + getEndOffset() + ")";
    }
}
