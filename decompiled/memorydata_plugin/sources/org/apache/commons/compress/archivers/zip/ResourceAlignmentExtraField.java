package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
public class ResourceAlignmentExtraField implements ZipExtraField {
    public static final ZipShort ID = null;
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    static {
        ID = new ZipShort(41246);
    }

    public ResourceAlignmentExtraField() {
    }

    public ResourceAlignmentExtraField(int r2, boolean r3, int r4) {
        if (r2 < 0) goto L12;
        if (r2 > 32767) goto L12;
        if (r4 < 0) goto L10;
        this.alignment = (short) r2;
        this.allowMethodChange = r3;
        this.padding = r4;
        return;
    L10:
        throw new IllegalArgumentException("Padding must not be negative, was: " + r4);
    L12:
        throw new IllegalArgumentException("Alignment must be between 0 and 0x7fff, was: " + r2);
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    public short getAlignment() {
        return this.alignment;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        short r0 = this.alignment;
        if (this.allowMethodChange == false) goto L5;
        short r1 = ShortCompanionObject.MIN_VALUE;
    L7:
        return ZipShort.getBytes(r1 | r0);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] r0 = new byte[this.padding + 2];
        short r1 = this.alignment;
        if (this.allowMethodChange == false) goto L5;
        short r3 = ShortCompanionObject.MIN_VALUE;
    L6:
        ZipShort.putShort(r3 | r1, r0, 0);
        return r0;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] r2, int r3, int r4) {
        if (r4 < 2) goto L11;
        int r5 = ZipShort.getValue(r2, r3);
        this.alignment = (short) (r5 & 32767);
        if ((r5 & 32768) == 0) goto L7;
        boolean r6 = true;
    L8:
        this.allowMethodChange = r6;
        return;
    L7:
        r6 = false;
        goto L8
    L11:
        throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + r4);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] r1, int r2, int r3) {
        parseFromCentralDirectoryData(r1, r2, r3);
        this.padding = r3 - 2;
    }
}
