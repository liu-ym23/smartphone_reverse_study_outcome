package com.xiphias.browser.scanner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/xiphias/browser/scanner/DocumentEnhancement;", "", "<init>", "(Ljava/lang/String;I)V", "DESHADING", "DEWARP", "DEMOIRE", "DEBLUR", "DEFINGER", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DocumentEnhancement extends Enum<DocumentEnhancement> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DocumentEnhancement[] $VALUES = null;
    public static final DocumentEnhancement DEBLUR = null;
    public static final DocumentEnhancement DEFINGER = null;
    public static final DocumentEnhancement DEMOIRE = null;
    public static final DocumentEnhancement DESHADING = null;
    public static final DocumentEnhancement DEWARP = null;

    private static final /* synthetic */ DocumentEnhancement[] $values() {
        return new DocumentEnhancement[]{DESHADING, DEWARP, DEMOIRE, DEBLUR, DEFINGER};
    }

    static {
        DESHADING = new DocumentEnhancement("DESHADING", 0);
        DEWARP = new DocumentEnhancement("DEWARP", 1);
        DEMOIRE = new DocumentEnhancement("DEMOIRE", 2);
        DEBLUR = new DocumentEnhancement("DEBLUR", 3);
        DEFINGER = new DocumentEnhancement("DEFINGER", 4);
        DocumentEnhancement[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private DocumentEnhancement(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<DocumentEnhancement> getEntries() {
        return $ENTRIES;
    }

    public static DocumentEnhancement valueOf(String r2) {
        return (DocumentEnhancement) ZeusTransformUtils.preCheckCast(Enum.valueOf(DocumentEnhancement.class, r2), DocumentEnhancement.class, "com.obric.memorydata.plugin");
    }

    public static DocumentEnhancement[] values() {
        return (DocumentEnhancement[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DocumentEnhancement[].class, "com.obric.memorydata.plugin");
    }
}
