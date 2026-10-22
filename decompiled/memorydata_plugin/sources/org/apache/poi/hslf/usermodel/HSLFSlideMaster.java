package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.hslf.record.MainMaster;
import org.apache.poi.hslf.record.TxMasterStyleAtom;
import org.apache.poi.sl.usermodel.TextShape;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFSlideMaster extends HSLFMasterSheet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<List<HSLFTextParagraph>> _paragraphs;
    private TxMasterStyleAtom[] _txmaster;

    /* JADX INFO: renamed from: org.apache.poi.hslf.usermodel.HSLFSlideMaster$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder = null;

        static {
            int[] r0 = new int[TextShape.TextPlaceholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder = r0;
            r0[TextShape.TextPlaceholder.BODY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.HALF_BODY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.QUARTER_BODY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.TITLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_TITLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
    }

    public HSLFSlideMaster(MainMaster r3, int r4) {
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

    private TextPropCollection getPropHelper(int r3, int r4, String r5, boolean r6) {
        TxMasterStyleAtom[] r2 = this._txmaster;
        if (r3 < r2.length) goto L5;
        return null;
    L5:
        TxMasterStyleAtom r7 = r2[r3];
        if (r6 == false) goto L8;
        List<TextPropCollection> r8 = r7.getCharacterStyles();
    L9:
        int r9 = Math.min(r4, r8.size() - 1);
        if ("*".equals(r5) == true) goto L12;
    L13:
        if (r9 < 0) goto L18;
        TextPropCollection r10 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r8.get(r9), TextPropCollection.class, "com.obric.memorydata.plugin");
        if (r10.findByName(r5) != null) goto L16;
        r9 = r9 - 1;
        goto L13
    L16:
        return r10;
    L18:
        return null;
    L12:
        return (TextPropCollection) ZeusTransformUtils.preCheckCast(r8.get(r9), TextPropCollection.class, "com.obric.memorydata.plugin");
    L8:
        r8 = r7.getParagraphStyles();
        goto L9
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFMasterSheet
    public TextPropCollection getPropCollection(int r2, int r3, String r4, boolean r5) {
        TextPropCollection r0 = getPropHelper(r2, r3, r4, r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        TextShape.TextPlaceholder r6 = TextShape.TextPlaceholder.fromNativeId(r2);
        int[] r1 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder;
        if (r6 != null) goto L9;
        r6 = TextShape.TextPlaceholder.BODY;
    L9:
        switch(r1[r6.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L12;
            case 6: goto L12;
            default: goto L10;
        };
    L10:
        return null;
    L12:
        TextShape.TextPlaceholder r7 = TextShape.TextPlaceholder.TITLE;
    L14:
        return getPropHelper(r7.nativeId, r3, r4, r5);
    L15:
        r7 = TextShape.TextPlaceholder.BODY;
        goto L14
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSheet
    public List<List<HSLFTextParagraph>> getTextParagraphs() {
        return this._paragraphs;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFSheet
    public void setSlideShow(HSLFSlideShow r8) {
        super.setSlideShow(r8);
        this._txmaster = new TxMasterStyleAtom[9];
        if (getSlideShow() == null) goto L44;
        if (getSlideShow().getDocumentRecord() == null) goto L44;
        if (getSlideShow().getDocumentRecord().getEnvironment() == null) goto L44;
        TxMasterStyleAtom r9 = getSlideShow().getDocumentRecord().getEnvironment().getTxMasterStyleAtom();
        if (r9 == null) goto L42;
        this._txmaster[r9.getTextType()] = r9;
        TxMasterStyleAtom[] r10 = ((MainMaster) ZeusTransformUtils.preCheckCast(getSheetContainer(), MainMaster.class, "com.obric.memorydata.plugin")).getTxMasterStyleAtoms();
        int r0 = r10.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L18;
        TxMasterStyleAtom r3 = r10[r2];
        int r4 = r3.getTextType();
        TxMasterStyleAtom[] r5 = this._txmaster;
        if (r4 >= r5.length) goto L17;
        if (r5[r4] != null) goto L17;
        r5[r4] = r3;
    L17:
        r2 = r2 + 1;
        goto L11
    L18:
        Iterator<List<HSLFTextParagraph>> r11 = getTextParagraphs().iterator();
    L20:
        if (r11.hasNext() == false) goto L40;
        Iterator r1 = ((List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r1.hasNext() == false) goto L20;
        HSLFTextParagraph r6 = (HSLFTextParagraph) ZeusTransformUtils.preCheckCast(r1.next(), HSLFTextParagraph.class, "com.obric.memorydata.plugin");
        int r7 = r6.getRunType();
        TxMasterStyleAtom[] r12 = this._txmaster;
        if (r7 >= r12.length) goto L39;
        if (r12[r7] == null) goto L39;
        int r13 = r6.getIndentLevel();
        List<TextPropCollection> r14 = this._txmaster[r7].getCharacterStyles();
        List<TextPropCollection> r15 = this._txmaster[r7].getParagraphStyles();
        if (r14 == null) goto L37;
        if (r15 == null) goto L37;
        if (r14.size() <= r13) goto L37;
        if (r15.size() > r13) goto L23;
    L37:
        throw new HSLFException("Master styles not initialized");
    L39:
        throw new HSLFException("Master styles not initialized");
    L40:
        return;
    L42:
        throw new IllegalStateException("Did not find a TxMasterStyleAtom in the current slide show");
    L44:
        throw new IllegalStateException("Did not find a TxMasterStyleAtom in the current slide show");
    }
}
