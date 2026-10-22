package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.hslf.record.Slide;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFTitleMaster extends HSLFMasterSheet {
    private final List<List<HSLFTextParagraph>> _paragraphs;

    public HSLFTitleMaster(Slide r3, int r4) {
        super(r3, r4);
        this._paragraphs = new ArrayList();
        Iterator<List<HSLFTextParagraph>> r5 = HSLFTextParagraph.findTextParagraphs(getPPDrawing(), this).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        List<HSLFTextParagraph> r6 = (List) ZeusTransformUtils.preCheckCast(r5.next(), List.class, "com.obric.memorydata.plugin");
        if (this._paragraphs.contains(r6) == true) goto L4;
        this._paragraphs.add(r6);
        goto L4
    }

    public HSLFMasterSheet getMasterSheet() {
        int r0 = ((Slide) ZeusTransformUtils.preCheckCast(getSheetContainer(), Slide.class, "com.obric.memorydata.plugin")).getSlideAtom().getMasterID();
        Iterator<HSLFSlideMaster> r4 = getSlideShow().getSlideMasters().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        HSLFSlideMaster r1 = (HSLFSlideMaster) ZeusTransformUtils.preCheckCast(r4.next(), HSLFSlideMaster.class, "com.obric.memorydata.plugin");
        if (r0 != r1._getSheetNumber()) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFMasterSheet
    public TextPropCollection getPropCollection(int r1, int r2, String r3, boolean r4) {
        HSLFMasterSheet r0 = getMasterSheet();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getPropCollection(r1, r2, r3, r4);
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSheet
    public List<List<HSLFTextParagraph>> getTextParagraphs() {
        return this._paragraphs;
    }
}
