package org.apache.poi.hslf.usermodel;

import androidx.core.net.MailTo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hslf.record.ExHyperlink;
import org.apache.poi.hslf.record.ExObjList;
import org.apache.poi.hslf.record.HSLFEscherClientDataRecord;
import org.apache.poi.hslf.record.InteractiveInfo;
import org.apache.poi.hslf.record.InteractiveInfoAtom;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.TxInteractiveInfoAtom;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFHyperlink {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ExHyperlink exHyper;
    private final InteractiveInfo info;
    private TxInteractiveInfoAtom txinfo;

    static {
    }

    public HSLFHyperlink(ExHyperlink r1, InteractiveInfo r2) {
        this.info = r2;
        this.exHyper = r1;
    }

    public static List<HSLFHyperlink> find(List<HSLFTextParagraph> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r5 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r5.isEmpty() == true) goto L10;
        HSLFTextParagraph r6 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r5.get(0), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        ExObjList r1 = r6.getSheet().getSlideShow().getDocumentRecord().getExObjList(false);
        if (r1 == null) goto L10;
        find(Arrays.asList(r6.getRecords()), r1, r0);
        goto L10
    }

    public static HSLFHyperlink find(HSLFShape r4) {
        ExObjList r0 = r4.getSheet().getSlideShow().getDocumentRecord().getExObjList(false);
        HSLFEscherClientDataRecord r5 = r4.getClientData(false);
        if (r0 == null) goto L10;
        if (r5 == null) goto L11;
        ArrayList r3 = new ArrayList();
        find(r5.getHSLFChildRecords(), r0, r3);
        if (r3.isEmpty() == false) goto L9;
        return null;
    L9:
        return (HSLFHyperlink) ZeusTransformUtils.preCheckCast(r3.get(0), HSLFHyperlink.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    L10:
        return null;
    }

    private static void find(List<? extends Record> r4, ExObjList r5, List<HSLFHyperlink> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ListIterator r9 = r7.listIterator();
    L4:
        if (r9.hasNext() == false) goto L20;
        Record r0 = (Record) ZeusTransformUtils.preCheckCast(r9.next(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, InteractiveInfo.class) == false) goto L4;
        InteractiveInfo r1 = (InteractiveInfo) ZeusTransformUtils.preCheckCast(r0, InteractiveInfo.class, "com.obric.memorydata.plugin");
        InteractiveInfoAtom r2 = r1.getInteractiveInfoAtom();
        if (r2 == null) goto L4;
        ExHyperlink r3 = r5.get(r2.getHyperlinkID());
        if (r3 == null) goto L4;
        HSLFHyperlink r10 = new HSLFHyperlink(r3, r1);
        r8.add(r10);
        if (r9.hasNext() == false) goto L4;
        Record r11 = (Record) ZeusTransformUtils.preCheckCast(r9.next(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, TxInteractiveInfoAtom.class) == false) goto L18;
        r10.setTextRunInfo((TxInteractiveInfoAtom) ZeusTransformUtils.preCheckCast(r11, TxInteractiveInfoAtom.class, "com.obric.memorydata.plugin"));
        goto L4
    L18:
        r9.previous();
        goto L4
    }

    public int getEndIndex() {
        TxInteractiveInfoAtom r0 = this.txinfo;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getEndIndex();
    }

    public int getStartIndex() {
        TxInteractiveInfoAtom r0 = this.txinfo;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getStartIndex();
    }

    public HyperlinkType getType() {
        switch(this.info.getInteractiveInfoAtom().getHyperlinkType()) {
            case 0: goto L14;
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L12;
            case 7: goto L14;
            case 8: goto L7;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L5;
        };
    L5:
        return HyperlinkType.NONE;
    L7:
        if (this.exHyper.getLinkURL().startsWith(MailTo.MAILTO_SCHEME) == false) goto L10;
        return HyperlinkType.EMAIL;
    L10:
        return HyperlinkType.URL;
    L12:
        return HyperlinkType.FILE;
    L14:
        return HyperlinkType.DOCUMENT;
    }

    public void setTextRunInfo(TxInteractiveInfoAtom r1) {
        this.txinfo = r1;
    }
}
