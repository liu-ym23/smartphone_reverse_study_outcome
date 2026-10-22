package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FSPADocumentPart extends Enum<FSPADocumentPart> {
    private static final /* synthetic */ FSPADocumentPart[] $VALUES = null;
    public static final FSPADocumentPart HEADER = null;
    public static final FSPADocumentPart MAIN = null;
    private final int fibFieldsField;

    static {
        FSPADocumentPart r0 = new FSPADocumentPart("HEADER", 0, 41);
        HEADER = r0;
        FSPADocumentPart r1 = new FSPADocumentPart("MAIN", 1, 40);
        MAIN = r1;
        $VALUES = new FSPADocumentPart[]{r0, r1};
    }

    private FSPADocumentPart(String r1, int r2, int r3) {
        super(r1, r2);
        this.fibFieldsField = r3;
    }

    public static FSPADocumentPart valueOf(String r2) {
        return (FSPADocumentPart) ZeusTransformUtils.preCheckCast(Enum.valueOf(FSPADocumentPart.class, r2), FSPADocumentPart.class, "com.obric.memorydata.plugin");
    }

    public static FSPADocumentPart[] values() {
        return (FSPADocumentPart[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FSPADocumentPart[].class, "com.obric.memorydata.plugin");
    }

    public int getFibFieldsField() {
        return this.fibFieldsField;
    }
}
