package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.Notes;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFNotes extends HSLFSheet implements Notes<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;
    private final List<List<HSLFTextParagraph>> _paragraphs;

    static {
        LOG = b.a(HSLFNotes.class);
    }

    public HSLFNotes(org.apache.poi.hslf.record.Notes r4) {
        super(r4, r4.getNotesAtom().getSlideID());
        this._paragraphs = new ArrayList();
        Iterator<List<HSLFTextParagraph>> r5 = HSLFTextParagraph.findTextParagraphs(getPPDrawing(), this).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        List<HSLFTextParagraph> r0 = (List) ZeusTransformUtils.preCheckCast(r5.next(), List.class, "com.obric.memorydata.plugin");
        if (this._paragraphs.contains(r0) == true) goto L4;
        this._paragraphs.add(r0);
        goto L4
    L9:
        if (this._paragraphs.isEmpty() == false) goto L17;
        LOG.atWarn().a("No text records found for notes sheet");
        return;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSheet
    public List<List<HSLFTextParagraph>> getTextParagraphs() {
        return this._paragraphs;
    }
}
