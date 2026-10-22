package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
public class UnicodePathExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UPATH_ID = null;

    static {
        UPATH_ID = new ZipShort(28789);
    }

    public UnicodePathExtraField() {
    }

    public UnicodePathExtraField(String r1, byte[] r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UPATH_ID;
    }
}
