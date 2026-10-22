package org.apache.poi.hslf.model.textproperties;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class TextPFException9 implements GenericRecord {
    private static final AutoNumberingScheme DEFAULT_AUTONUMBER_SCHEME = null;
    private static final Short DEFAULT_START_NUMBER = null;
    private final AutoNumberingScheme autoNumberScheme;
    private final Short autoNumberStartNumber;
    private final Short bulletBlipRef;
    private final Short fBulletHasAutoNumber;
    private final byte mask3;
    private final byte mask4;
    private final int recordLength;

    static {
        DEFAULT_AUTONUMBER_SCHEME = AutoNumberingScheme.arabicPeriod;
        DEFAULT_START_NUMBER = 1;
    }

    public TextPFException9(byte[] r5, int r6) {
        byte r0 = r5[r6 + 2];
        this.mask3 = r0;
        byte r1 = r5[r6 + 3];
        this.mask4 = r1;
        int r2 = 4;
        int r7 = r6 + 4;
        if ((r0 & (-128)) != 0) goto L5;
        this.bulletBlipRef = null;
    L7:
        if ((r1 & 2) != 0) goto L9;
        this.fBulletHasAutoNumber = null;
    L11:
        if ((r1 & 1) != 0) goto L13;
        this.autoNumberScheme = null;
        this.autoNumberStartNumber = null;
    L14:
        this.recordLength = r2;
        return;
    L13:
        this.autoNumberScheme = AutoNumberingScheme.forNativeID(LittleEndian.getShort(r5, r7));
        this.autoNumberStartNumber = Short.valueOf(LittleEndian.getShort(r5, r7 + 2));
        r2 = r2 + 4;
        goto L14
    L9:
        this.fBulletHasAutoNumber = Short.valueOf(LittleEndian.getShort(r5, r7));
        r7 = r7 + 2;
        r2 = r2 + 2;
        goto L11
    L5:
        this.bulletBlipRef = Short.valueOf(LittleEndian.getShort(r5, r7));
        r7 = r7 + 2;
        r2 = 6;
        goto L7
    }

    private boolean hasBulletAutoNumber() {
        Short r0 = 1;
        return r0.equals(this.fBulletHasAutoNumber);
    }

    public static /* synthetic */ boolean lambda$_DMr05Tsu6f1mnsa7VJCXZliIm0(TextPFException9 r0) {
        return r0.hasBulletAutoNumber();
    }

    public AutoNumberingScheme getAutoNumberScheme() {
        AutoNumberingScheme r0 = this.autoNumberScheme;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (hasBulletAutoNumber() == true) goto L10;
        return null;
    L10:
        return DEFAULT_AUTONUMBER_SCHEME;
    }

    public Short getAutoNumberStartNumber() {
        Short r0 = this.autoNumberStartNumber;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (hasBulletAutoNumber() == true) goto L10;
        return null;
    L10:
        return DEFAULT_START_NUMBER;
    }

    public Short getBulletBlipRef() {
        return this.bulletBlipRef;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("bulletBlipRef", new $$Lambda$HgtoVje2_hisP4N4yoQ2nMLPog(this), "bulletHasAutoNumber", new $$Lambda$TextPFException9$_DMr05Tsu6f1mnsa7VJCXZliIm0(this), "autoNumberScheme", new $$Lambda$VjieBPCGt4bb1gyApK9pq1DzqbA(this), "autoNumberStartNumber", new $$Lambda$aNJqhIa_CEsydVc4Lq_QSzWJPE(this));
    }

    public int getRecordLength() {
        return this.recordLength;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Record length: ").append(this.recordLength).append(" bytes\n");
        r0.append("bulletBlipRef: ").append(this.bulletBlipRef).append("\n");
        r0.append("fBulletHasAutoNumber: ").append(this.fBulletHasAutoNumber).append("\n");
        r0.append("autoNumberScheme: ").append(this.autoNumberScheme).append("\n");
        r0.append("autoNumberStartNumber: ").append(this.autoNumberStartNumber).append("\n");
        return r0.toString();
    }
}
