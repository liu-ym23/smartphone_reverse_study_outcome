package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
public class UnicodeCommentExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UCOM_ID = null;

    static {
        UCOM_ID = new ZipShort(25461);
    }

    public UnicodeCommentExtraField() {
    }

    public UnicodeCommentExtraField(String r1, byte[] r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UCOM_ID;
    }
}
