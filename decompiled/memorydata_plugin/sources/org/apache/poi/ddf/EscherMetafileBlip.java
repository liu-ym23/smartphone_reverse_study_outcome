package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public final class EscherMetafileBlip extends EscherBlipRecord {
    private static final c LOGGER = null;
    private static int MAX_RECORD_LENGTH;

    @Deprecated
    public static final short RECORD_ID_EMF = 0;

    @Deprecated
    public static final short RECORD_ID_PICT = 0;

    @Deprecated
    public static final short RECORD_ID_WMF = 0;
    private final byte[] field_1_UID;
    private final byte[] field_2_UID;
    private int field_2_cb;
    private int field_3_rcBounds_x1;
    private int field_3_rcBounds_x2;
    private int field_3_rcBounds_y1;
    private int field_3_rcBounds_y2;
    private int field_4_ptSize_h;
    private int field_4_ptSize_w;
    private int field_5_cbSave;
    private byte field_6_fCompression;
    private byte field_7_fFilter;
    private byte[] raw_pictureData;
    private byte[] remainingData;

    /* JADX INFO: renamed from: org.apache.poi.ddf.EscherMetafileBlip$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = null;

        static {
            int[] r0 = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = r0;
            r0[EscherRecordTypes.BLIP_EMF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_WMF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_PICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        LOGGER = b.a(EscherMetafileBlip.class);
        MAX_RECORD_LENGTH = 100000000;
        RECORD_ID_EMF = EscherRecordTypes.BLIP_EMF.typeID;
        RECORD_ID_WMF = EscherRecordTypes.BLIP_WMF.typeID;
        RECORD_ID_PICT = EscherRecordTypes.BLIP_PICT.typeID;
    }

    public EscherMetafileBlip() {
        this.field_1_UID = new byte[16];
        this.field_2_UID = new byte[16];
    }

    private static byte[] inflatePictureData(byte[] r4) {
        InflaterInputStream r0 = new InflaterInputStream(new UnsynchronizedByteArrayInputStream(r4));     // Catch: IOException -> L24
        UnsynchronizedByteArrayOutputStream r1 = new UnsynchronizedByteArrayOutputStream();     // Catch: Throwable -> L16
        IOUtils.copy(r0, r1);     // Catch: Throwable -> L8
        byte[] r2 = r1.toByteArray();     // Catch: Throwable -> L8
        r1.close();     // Catch: Throwable -> L16
        r0.close();     // Catch: IOException -> L24
        return r2;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L16
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L24
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        LOGGER.atWarn().a(e).a("Possibly corrupt compression or non-compressed data");
        return r4;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r6, int r7, EscherRecordFactory r8) {
        EscherRecordFactory r9 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r8, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r10 = readHeader(r6, r7);
        int r0 = r7 + 8;
        System.arraycopy(r6, r0, this.field_1_UID, 0, 16);
        int r1 = r0 + 16;
        if ((getOptions() ^ getSignature()) != 16) goto L5;
        System.arraycopy(r6, r1, this.field_2_UID, 0, 16);
        r1 = r1 + 16;
    L5:
        this.field_2_cb = LittleEndian.getInt(r6, r1);
        int r2 = r1 + 4;
        this.field_3_rcBounds_x1 = LittleEndian.getInt(r6, r2);
        int r3 = r2 + 4;
        this.field_3_rcBounds_y1 = LittleEndian.getInt(r6, r3);
        int r4 = r3 + 4;
        this.field_3_rcBounds_x2 = LittleEndian.getInt(r6, r4);
        int r5 = r4 + 4;
        this.field_3_rcBounds_y2 = LittleEndian.getInt(r6, r5);
        int r11 = r5 + 4;
        this.field_4_ptSize_w = LittleEndian.getInt(r6, r11);
        int r12 = r11 + 4;
        this.field_4_ptSize_h = LittleEndian.getInt(r6, r12);
        int r13 = r12 + 4;
        int r14 = LittleEndian.getInt(r6, r13);
        this.field_5_cbSave = r14;
        int r15 = r13 + 4;
        this.field_6_fCompression = r6[r15];
        int r16 = r15 + 1;
        this.field_7_fFilter = r6[r16];
        int r17 = r16 + 1;
        byte[] r18 = IOUtils.safelyClone(r6, r17, r14, MAX_RECORD_LENGTH);
        this.raw_pictureData = r18;
        int r19 = r17 + this.field_5_cbSave;
        if (this.field_6_fCompression != 0) goto L8;
        super.setPictureData(inflatePictureData(r18));
    L9:
        int r20 = ((r10 - r19) + r7) + 8;
        if (r20 <= 0) goto L13;
        this.remainingData = IOUtils.safelyClone(r6, r19, r20, MAX_RECORD_LENGTH);
    L13:
        return r10 + 8;
    L8:
        super.setPictureData(r18);
        goto L9
    }

    public Rectangle getBounds() {
        int r1 = this.field_3_rcBounds_x1;
        int r2 = this.field_3_rcBounds_y1;
        return new Rectangle(r1, r2, this.field_3_rcBounds_x2 - r1, this.field_3_rcBounds_y2 - r2);
    }

    public int getCompressedSize() {
        return this.field_5_cbSave;
    }

    public byte getFilter() {
        return this.field_7_fFilter;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap(super.getGenericProperties());
        r0.put("uid", new $$Lambda$gw6oJZspBGFHA9fg48cka5hPzsY(this));
        r0.put("uncompressedSize", new $$Lambda$KKUrwLUhV46WtKiBQj25a3ZeDI(this));
        r0.put("bounds", new $$Lambda$LbGNfmw1FBWmjZ3T89NWsJpGWo(this));
        r0.put("sizeInEMU", new $$Lambda$OciJnQTZwAvNHh1x8b9PVSLRqzA(this));
        r0.put("compressedSize", new $$Lambda$qr1WdmzDxLcmLrPgVc77eIN688(this));
        r0.put("isCompressed", new $$Lambda$YMIlKGXFUhKVd2EXS2MC5QExnfs(this));
        r0.put("filter", new $$Lambda$0kLF3NLHjXFYH_VjBdmjug1O42c(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        int r0 = this.raw_pictureData.length + 58;
        byte[] r1 = this.remainingData;
        if (r1 == null) goto L6;
        r0 = r0 + r1.length;
    L6:
        if ((getOptions() ^ getSignature()) == 16) goto L8;
        return r0;
    L8:
        return r0 + this.field_2_UID.length;
    }

    public short getSignature() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(getRecordId()).ordinal()];
        if (r0 != 1) goto L5;
        return 15680;
    L5:
        if (r0 != 2) goto L7;
        return 8544;
    L7:
        if (r0 == 3) goto L10;
        LOGGER.atWarn().a("Unknown metafile: {}", v.a(getRecordId()));
        return 0;
    L10:
        return 21536;
    }

    public Dimension getSizeEMU() {
        return new Dimension(this.field_4_ptSize_w, this.field_4_ptSize_h);
    }

    public byte[] getUID() {
        return this.field_1_UID;
    }

    public int getUncompressedSize() {
        return this.field_2_cb;
    }

    public boolean isCompressed() {
        if (this.field_6_fCompression != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord, org.apache.poi.ddf.EscherRecord
    public int serialize(int r5, byte[] r6, EscherSerializationListener r7) {
        EscherSerializationListener r8 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r7, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r8.beforeRecordSerialize(r5, getRecordId(), this);
        LittleEndian.putShort(r6, r5, getOptions());
        int r0 = r5 + 2;
        LittleEndian.putShort(r6, r0, getRecordId());
        int r1 = r0 + 2;
        LittleEndian.putInt(r6, r1, getRecordSize() - 8);
        int r2 = r1 + 4;
        byte[] r3 = this.field_1_UID;
        System.arraycopy(r3, 0, r6, r2, r3.length);
        int r4 = r2 + this.field_1_UID.length;
        if ((getOptions() ^ getSignature()) != 16) goto L5;
        byte[] r9 = this.field_2_UID;
        System.arraycopy(r9, 0, r6, r4, r9.length);
        r4 = r4 + this.field_2_UID.length;
    L5:
        LittleEndian.putInt(r6, r4, this.field_2_cb);
        int r10 = r4 + 4;
        LittleEndian.putInt(r6, r10, this.field_3_rcBounds_x1);
        int r11 = r10 + 4;
        LittleEndian.putInt(r6, r11, this.field_3_rcBounds_y1);
        int r12 = r11 + 4;
        LittleEndian.putInt(r6, r12, this.field_3_rcBounds_x2);
        int r13 = r12 + 4;
        LittleEndian.putInt(r6, r13, this.field_3_rcBounds_y2);
        int r14 = r13 + 4;
        LittleEndian.putInt(r6, r14, this.field_4_ptSize_w);
        int r15 = r14 + 4;
        LittleEndian.putInt(r6, r15, this.field_4_ptSize_h);
        int r16 = r15 + 4;
        LittleEndian.putInt(r6, r16, this.field_5_cbSave);
        int r17 = r16 + 4;
        r6[r17] = this.field_6_fCompression;
        int r18 = r17 + 1;
        r6[r18] = this.field_7_fFilter;
        int r19 = r18 + 1;
        byte[] r20 = this.raw_pictureData;
        System.arraycopy(r20, 0, r6, r19, r20.length);
        int r21 = r19 + this.raw_pictureData.length;
        byte[] r22 = this.remainingData;
        if (r22 == null) goto L8;
        System.arraycopy(r22, 0, r6, r21, r22.length);
    L8:
        r8.afterRecordSerialize(r5 + getRecordSize(), getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public void setCompressed(boolean r1) {
        if (r1 == false) goto L4;
        byte r2 = 0;
    L5:
        this.field_6_fCompression = r2;
        return;
    L4:
        r2 = -2;
        goto L5
    }

    public void setCompressedSize(int r1) {
        this.field_5_cbSave = r1;
    }

    @Override // org.apache.poi.ddf.EscherBlipRecord
    public void setPictureData(byte[] r3) {
        super.setPictureData(r3);
        setUncompressedSize(r3.length);
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();     // Catch: IOException -> L26
        DeflaterOutputStream r1 = new DeflaterOutputStream(r0);     // Catch: Throwable -> L18
        r1.write(r3);     // Catch: Throwable -> L10
        r1.close();     // Catch: Throwable -> L18
        this.raw_pictureData = r0.toByteArray();     // Catch: Throwable -> L18
        r0.close();     // Catch: IOException -> L26
        setCompressedSize(this.raw_pictureData.length);
        setCompressed(true);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L18
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        throw new RuntimeException("Can't compress metafile picture data", e);
    }

    public void setUncompressedSize(int r1) {
        this.field_2_cb = r1;
    }
}
