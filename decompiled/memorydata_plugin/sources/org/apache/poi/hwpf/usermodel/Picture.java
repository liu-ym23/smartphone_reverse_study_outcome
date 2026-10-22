package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.hwpf.model.PICF;
import org.apache.poi.hwpf.model.PICFAndOfficeArtData;
import org.apache.poi.sl.image.ImageHeaderPNG;
import org.apache.poi.util.IOUtils;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public final class Picture {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] COMPRESSED1 = null;
    private static final byte[] COMPRESSED2 = null;
    private static final byte[] IHDR = null;
    private static final c LOGGER = null;

    @Deprecated
    private static final byte[] PNG = null;
    private final List<? extends EscherRecord> _blipRecords;
    private PICF _picf;
    private PICFAndOfficeArtData _picfAndOfficeArtData;
    private byte[] content;
    private int dataBlockStartOfsset;
    private int height;
    private int width;

    /* JADX INFO: renamed from: org.apache.poi.hwpf.usermodel.Picture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwpf$usermodel$PictureType = null;

        static {
            int[] r0 = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = r0;
            r0[EscherRecordTypes.BLIP_EMF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_WMF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_PICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L40:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_JPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L26:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_PNG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_DIB.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L34:
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.BLIP_TIFF.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L11:
            int[] r2 = new int[PictureType.values().length];
            $SwitchMap$org$apache$poi$hwpf$usermodel$PictureType = r2;
            r2[PictureType.JPEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L28:
            $SwitchMap$org$apache$poi$hwpf$usermodel$PictureType[PictureType.PNG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    static {
        LOGGER = b.a(Picture.class);
        COMPRESSED1 = new byte[]{-2, 120, MessagePack.Code.STR16};
        COMPRESSED2 = new byte[]{-2, 120, -100};
        IHDR = new byte[]{73, 72, 68, 82};
        PNG = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    public Picture(int r2, byte[] r3, boolean r4) {
        this.height = -1;
        this.width = -1;
        PICFAndOfficeArtData r0 = new PICFAndOfficeArtData(r3, r2);
        this._picfAndOfficeArtData = r0;
        this._picf = r0.getPicf();
        this.dataBlockStartOfsset = r2;
        this._blipRecords = this._picfAndOfficeArtData.getBlipRecords();
        if (r4 == false) goto L6;
        fillImageContent();
        return;
    }

    public Picture(EscherBlipRecord r2) {
        this.height = -1;
        this.width = -1;
        this._blipRecords = Collections.singletonList(r2);
    }

    private void fillImageContent() {
        byte[] r0 = this.content;
        if (r0 != null) goto L5;
    L7:
        byte[] r1 = getRawContent();
        if (matchSignature(r1, COMPRESSED1, 32) == false) goto L10;
    L56:
        UnsynchronizedByteArrayInputStream r2 = new UnsynchronizedByteArrayInputStream(r1, 33, r1.length - 33);     // Catch: IOException -> L45
        InflaterInputStream r3 = new InflaterInputStream(r2);     // Catch: Throwable -> L37
        UnsynchronizedByteArrayOutputStream r4 = new UnsynchronizedByteArrayOutputStream();     // Catch: Throwable -> L29
        IOUtils.copy(r3, r4);     // Catch: Throwable -> L21
        this.content = r4.toByteArray();     // Catch: Throwable -> L21
        r4.close();     // Catch: Throwable -> L29
        r3.close();     // Catch: Throwable -> L37
        r2.close();     // Catch: IOException -> L45
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L29
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Throwable -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L42
    L44:
        throw th;     // Catch: IOException -> L45
    L42:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L45
    L45:
        e = move-exception;
        LOGGER.atInfo().a(e).a("Possibly corrupt compression or non-compressed data");
        return;
    L10:
        if (matchSignature(r1, COMPRESSED2, 32) == true) goto L56;
        this.content = new ImageHeaderPNG(r1).extractPNG();
        return;
    L5:
        if (r0.length <= 0) goto L7;
    }

    private static boolean matchSignature(byte[] r5, byte[] r6, int r7) {
        if (r7 >= r5.length) goto L5;
        boolean r0 = true;
    L6:
        int r2 = 0;
    L7:
        int r3 = r2 + r7;
        if (r3 >= r5.length) goto L16;
        if (r2 >= r6.length) goto L16;
        if (r5[r3] != r6[r2]) goto L20;
        r2 = r2 + 1;
        goto L7
    L20:
        return false;
    L16:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public byte[] getContent() {
        fillImageContent();
        return this.content;
    }

    public byte[] getRawContent() {
        if (this._blipRecords.size() != 1) goto L5;
        EscherRecord r3 = (EscherRecord) ZeusTransformUtils.preCheckCast(this._blipRecords.get(0), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, EscherBlipRecord.class) == false) goto L11;
        return ((EscherBlipRecord) ZeusTransformUtils.preCheckCast(r3, EscherBlipRecord.class, "com.obric.memorydata.plugin")).getPicturedata();
    L11:
        if (ZeusTransformUtils.instanceOf(r3, EscherBSERecord.class) == false) goto L17;
        EscherBlipRecord r4 = ((EscherBSERecord) ZeusTransformUtils.preCheckCast(r3, EscherBSERecord.class, "com.obric.memorydata.plugin")).getBlipRecord();
        if (r4 == null) goto L17;
        return r4.getPicturedata();
    L17:
        return new byte[0];
    L5:
        return new byte[0];
    }

    public String suggestFileExtension() {
        return suggestPictureType().getExtension();
    }

    public PictureType suggestPictureType() {
        if (this._blipRecords.size() != 1) goto L5;
        EscherRecord r3 = (EscherRecord) ZeusTransformUtils.preCheckCast(this._blipRecords.get(0), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, EscherBSERecord.class) == false) goto L35;
        byte r4 = ((EscherBSERecord) ZeusTransformUtils.preCheckCast(r3, EscherBSERecord.class, "com.obric.memorydata.plugin")).getBlipTypeWin32();
        if (r4 == 17) goto L34;
        if (r4 == 18) goto L32;
        switch(r4) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            default: goto L14;
        };
    L14:
        return PictureType.UNKNOWN;
    L16:
        return PictureType.BMP;
    L18:
        return PictureType.PNG;
    L20:
        return PictureType.JPEG;
    L22:
        return PictureType.PICT;
    L24:
        return PictureType.WMF;
    L26:
        return PictureType.EMF;
    L28:
        return PictureType.UNKNOWN;
    L30:
        return PictureType.UNKNOWN;
    L32:
        return PictureType.JPEG;
    L34:
        return PictureType.TIFF;
    L35:
        Enum<?> r5 = r3.getGenericRecordType();
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[((EscherRecordTypes) ZeusTransformUtils.preCheckCast(r5, EscherRecordTypes.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            default: goto L38;
        };
    L38:
        return PictureType.UNKNOWN;
    L40:
        return PictureType.TIFF;
    L42:
        return PictureType.BMP;
    L44:
        return PictureType.PNG;
    L46:
        return PictureType.JPEG;
    L48:
        return PictureType.PICT;
    L50:
        return PictureType.WMF;
    L52:
        return PictureType.EMF;
    L5:
        return PictureType.UNKNOWN;
    }
}
