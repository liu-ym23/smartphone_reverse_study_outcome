package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes6.dex */
public interface ExtraFieldParsingBehavior extends UnparseableExtraFieldBehavior {
    ZipExtraField createExtraField(ZipShort r1);

    ZipExtraField fill(ZipExtraField r1, byte[] r2, int r3, int r4, boolean r5);
}
