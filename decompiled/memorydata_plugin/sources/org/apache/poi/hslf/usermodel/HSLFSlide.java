package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.record.SlideListWithText;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.TextShape;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFSlide extends HSLFSheet implements Slide<HSLFShape, HSLFTextParagraph> {
    private SlideListWithText.SlideAtomsSet _atomSet;
    private HSLFNotes _notes;
    private final List<List<HSLFTextParagraph>> _paragraphs;
    private int _slideNo;

    public HSLFSlide(org.apache.poi.hslf.record.Slide r1, HSLFNotes r2, SlideListWithText.SlideAtomsSet r3, int r4, int r5) {
        super(r1, r4);
        ArrayList r6 = new ArrayList();
        this._paragraphs = r6;
        this._notes = r2;
        this._atomSet = r3;
        this._slideNo = r5;
        if (r3 != null) goto L5;
    L11:
        Iterator<List<HSLFTextParagraph>> r7 = HSLFTextParagraph.findTextParagraphs(getPPDrawing(), this).iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        List<HSLFTextParagraph> r8 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        if (this._paragraphs.contains(r8) == true) goto L13;
        this._paragraphs.add(r8);
        goto L13
    L17:
        return;
    L5:
        if (r3.getSlideRecords().length <= 0) goto L11;
        r6.addAll(HSLFTextParagraph.findTextParagraphs(this._atomSet.getSlideRecords()));
        if (r6.isEmpty() == false) goto L11;
        throw new HSLFException("No text records found for slide");
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public int getSlideNumber() {
        return this._slideNo;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSheet
    public List<List<HSLFTextParagraph>> getTextParagraphs() {
        return this._paragraphs;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public String getTitle() {
        Iterator<List<HSLFTextParagraph>> r4 = getTextParagraphs().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r4.next(), List.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == true) goto L4;
        int r1 = ((HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r0.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin")).getRunType();
        if (TextShape.TextPlaceholder.isTitle(r1) == false) goto L4;
        return HSLFTextParagraph.toExternalString(HSLFTextParagraph.getRawText(r0), r1);
    L12:
        return null;
    }
}
