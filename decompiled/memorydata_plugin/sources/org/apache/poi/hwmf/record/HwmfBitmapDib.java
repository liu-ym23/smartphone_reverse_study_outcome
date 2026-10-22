package org.apache.poi.hwmf.record;

import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hwmf.usermodel.HwmfPicture;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfBitmapDib implements GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private Color[] colorTable;
    private BitCount headerBitCount;
    private long headerColorImportant;
    private long headerColorUsed;
    private Compression headerCompression;
    private int headerHeight;
    private long headerImageSize;
    private int headerPlanes;
    private int headerSize;
    private int headerWidth;
    private int headerXPelsPerMeter;
    private int headerYPelsPerMeter;
    private byte[] imageData;
    private int introSize;

    public static final enum BitCount extends Enum<BitCount> {
        private static final /* synthetic */ BitCount[] $VALUES = null;
        public static final BitCount BI_BITCOUNT_0 = null;
        public static final BitCount BI_BITCOUNT_1 = null;
        public static final BitCount BI_BITCOUNT_2 = null;
        public static final BitCount BI_BITCOUNT_3 = null;
        public static final BitCount BI_BITCOUNT_4 = null;
        public static final BitCount BI_BITCOUNT_5 = null;
        public static final BitCount BI_BITCOUNT_6 = null;
        int flag;

        static {
            BitCount r0 = new BitCount("BI_BITCOUNT_0", 0, 0);
            BI_BITCOUNT_0 = r0;
            BitCount r1 = new BitCount("BI_BITCOUNT_1", 1, 1);
            BI_BITCOUNT_1 = r1;
            BitCount r3 = new BitCount("BI_BITCOUNT_2", 2, 4);
            BI_BITCOUNT_2 = r3;
            BitCount r5 = new BitCount("BI_BITCOUNT_3", 3, 8);
            BI_BITCOUNT_3 = r5;
            BitCount r8 = new BitCount("BI_BITCOUNT_4", 4, 16);
            BI_BITCOUNT_4 = r8;
            BitCount r10 = new BitCount("BI_BITCOUNT_5", 5, 24);
            BI_BITCOUNT_5 = r10;
            BitCount r11 = new BitCount("BI_BITCOUNT_6", 6, 32);
            BI_BITCOUNT_6 = r11;
            $VALUES = new BitCount[]{r0, r1, r3, r5, r8, r10, r11};
        }

        private BitCount(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        static BitCount valueOf(int r5) {
            BitCount[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            BitCount r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static BitCount valueOf(String r2) {
            return (BitCount) ZeusTransformUtils.preCheckCast(Enum.valueOf(BitCount.class, r2), BitCount.class, "com.obric.memorydata.plugin");
        }

        public static BitCount[] values() {
            return (BitCount[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BitCount[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Compression extends Enum<Compression> {
        private static final /* synthetic */ Compression[] $VALUES = null;
        public static final Compression BI_BITFIELDS = null;
        public static final Compression BI_CMYK = null;
        public static final Compression BI_CMYKRLE4 = null;
        public static final Compression BI_CMYKRLE8 = null;
        public static final Compression BI_JPEG = null;
        public static final Compression BI_PNG = null;
        public static final Compression BI_RGB = null;
        public static final Compression BI_RLE4 = null;
        public static final Compression BI_RLE8 = null;
        int flag;

        static {
            Compression r0 = new Compression("BI_RGB", 0, 0);
            BI_RGB = r0;
            Compression r1 = new Compression("BI_RLE8", 1, 1);
            BI_RLE8 = r1;
            Compression r3 = new Compression("BI_RLE4", 2, 2);
            BI_RLE4 = r3;
            Compression r5 = new Compression("BI_BITFIELDS", 3, 3);
            BI_BITFIELDS = r5;
            Compression r7 = new Compression("BI_JPEG", 4, 4);
            BI_JPEG = r7;
            Compression r9 = new Compression("BI_PNG", 5, 5);
            BI_PNG = r9;
            Compression r11 = new Compression("BI_CMYK", 6, 11);
            BI_CMYK = r11;
            Compression r13 = new Compression("BI_CMYKRLE8", 7, 12);
            BI_CMYKRLE8 = r13;
            Compression r12 = new Compression("BI_CMYKRLE4", 8, 13);
            BI_CMYKRLE4 = r12;
            $VALUES = new Compression[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
        }

        private Compression(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        static Compression valueOf(int r5) {
            Compression[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Compression r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static Compression valueOf(String r2) {
            return (Compression) ZeusTransformUtils.preCheckCast(Enum.valueOf(Compression.class, r2), Compression.class, "com.obric.memorydata.plugin");
        }

        public static Compression[] values() {
            return (Compression[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Compression[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(HwmfBitmapDib.class);
    }

    public HwmfBitmapDib() {
        this.headerImageSize = -1;
        this.headerXPelsPerMeter = -1;
        this.headerYPelsPerMeter = -1;
        this.headerColorUsed = -1;
        this.headerColorImportant = -1;
    }

    public byte[] getBMPData() {
        if (this.headerWidth > 0) goto L5;
        return null;
    L5:
        if (this.headerHeight <= 0) goto L15;
        byte[] r0 = this.imageData;
        if (r0 == null) goto L12;
        int r1 = (int) Math.max(r0.length, ((long) this.introSize) + this.headerImageSize);
        byte[] r2 = IOUtils.safelyAllocate(((long) r1) + 14, HwmfPicture.getMaxRecordLength());
        r2[0] = 66;
        r2[1] = 77;
        LittleEndian.putInt(r2, 2, r1 + 14);
        LittleEndian.putInt(r2, 6, 0);
        LittleEndian.putInt(r2, 10, this.introSize + 14);
        byte[] r6 = this.imageData;
        System.arraycopy(r6, 0, r2, 14, r6.length);
        return r2;
    L12:
        throw new RecordFormatException("used to throw exception: bitmap not initialized ... need to call init() before");
    L15:
        return null;
    }

    public InputStream getBMPStream() {
        return new ByteArrayInputStream(getBMPData());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("headerSize", new $$Lambda$HwmfBitmapDib$fFm8dTE3jqyj_H2DBez450b_i_E(this));
        r0.put("width", new $$Lambda$HwmfBitmapDib$MmKYoRTX2bfPTuGHApx0ffcluOM(this));
        r0.put("height", new $$Lambda$HwmfBitmapDib$RrBCq_ARezmtyqUblq3lTE_VP6s(this));
        r0.put("planes", new $$Lambda$HwmfBitmapDib$Ea3XaX9PYcEFzYLxcIJF8RV0HWM(this));
        r0.put("bitCount", new $$Lambda$HwmfBitmapDib$4Wgw1Add8086JijWWAsw0wmPMzw(this));
        r0.put("compression", new $$Lambda$HwmfBitmapDib$02xu20zHKn7P1tXKP8zmzVL8A_E(this));
        r0.put("imageSize", new $$Lambda$HwmfBitmapDib$nJP8qyg2lfGAO4CeA16vtl6l5R0(this));
        r0.put("xPelsPerMeter", new $$Lambda$HwmfBitmapDib$B9_Jfy6PuUqgCEtBt2CazPGRBRg(this));
        r0.put("yPelsPerMeter", new $$Lambda$HwmfBitmapDib$WQ8zkQwwMSCuLVO1RcI7M4qFaYY(this));
        r0.put("colorUsed", new $$Lambda$HwmfBitmapDib$wP3P3h5PmEI5Q4Gub_8SZFl5pSw(this));
        r0.put("colorImportant", new $$Lambda$HwmfBitmapDib$1SRL37T5n8mww7JAJBRaPk2d1Gg(this));
        r0.put("image", new $$Lambda$WNQ8m6v8pvhPwKFLVKuyGaqtd4U(this));
        r0.put("bmpData", new $$Lambda$72aBV6Iv5uPQ73lSoJUttdpPaFs(this));
        return Collections.unmodifiableMap(r0);
    }

    public BufferedImage getImage() {
        return getImage(null, null, false);
    }

    public BufferedImage getImage(Color r13, Color r14, boolean r15) {
        Color r16 = (Color) ZeusTransformUtils.wrapperContextForParams(r13, Color.class, "com.obric.memorydata.plugin");
        Color r17 = (Color) ZeusTransformUtils.wrapperContextForParams(r14, Color.class, "com.obric.memorydata.plugin");
        BufferedImage r0 = ImageIO.read(getBMPStream());     // Catch: Throwable -> L22
        if (r16 == null) goto L26;
        if (r17 != null) goto L7;
        return r0;
    L7:
        if (this.headerBitCount != BitCount.BI_BITCOUNT_1) goto L28;
        IndexColorModel r12 = (IndexColorModel) ZeusTransformUtils.preCheckCast(r0.getColorModel(), IndexColorModel.class, "com.obric.memorydata.plugin");
        int r18 = r16.getRGB();
        int r19 = r17.getRGB();
        if (r15 == false) goto L11;
        int r2 = 16777215;
    L12:
        int r110 = r19 & r2;
        if ((r12.getRGB(0) & ViewCompat.MEASURED_SIZE_MASK) != (16777215 & r110)) goto L15;
        int r111 = 1;
    L16:
        int r10 = r111 ^ 1;
        if (r111 == 0) goto L19;
        int[] r112 = {r110, r18};
    L21:
        return new BufferedImage(new IndexColorModel(1, 2, r112, 0, r15, r10, r0.getData().getTransferType()), r0.getRaster(), false, null);
    L19:
        r112 = new int[]{r18, r110};
        goto L21
    L15:
        r111 = 0;
        goto L16
    L11:
        r2 = -1;
        goto L12
    L28:
        return r0;
    L26:
        return r0;
    L22:
        LOG.atError().a("invalid bitmap data - returning placeholder image");
        return getPlaceholder();
    }

    public BufferedImage getPlaceholder() {
        if (this.headerHeight <= 0) goto L10;
        if (this.headerWidth <= 0) goto L10;
        BufferedImage r1 = new BufferedImage(this.headerWidth, this.headerHeight, 2);
        Graphics2D r4 = r1.createGraphics();
        r4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        r4.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        r4.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        r4.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        r4.setComposite(AlphaComposite.Clear);
        r4.fillRect(0, 0, this.headerWidth, this.headerHeight);
        int r5 = Math.min(this.headerWidth, this.headerHeight) / 7;
        Color r6 = Color.LIGHT_GRAY;
        Color r8 = Color.GRAY;
        LinearGradientPaint r15 = new LinearGradientPaint(0.0f, 0.0f, 5.0f, 5.0f, new float[]{0.0f, 0.1f, 0.1001f}, new Color[]{r8, r8, r6}, MultipleGradientPaint.CycleMethod.REFLECT);
        r4.setComposite(AlphaComposite.SrcOver.derive(0.4f));
        r4.setPaint(r15);
        r4.fillRoundRect(0, 0, this.headerWidth - 1, this.headerHeight - 1, r5, r5);
        r4.setColor(Color.DARK_GRAY);
        r4.setComposite(AlphaComposite.Src);
        r4.setStroke(new BasicStroke(2.0f));
        r4.drawRoundRect(0, 0, this.headerWidth - 1, this.headerHeight - 1, r5, r5);
        r4.dispose();
        return r1;
    L10:
        return new BufferedImage(1, 1, 2);
    }

    public boolean isValid() {
        if (this.imageData != null) goto L6;
        return false;
    L6:
        if (this.headerBitCount != BitCount.BI_BITCOUNT_1) goto L17;
        Color[] r6 = this.colorTable;
        if (r6 != null) goto L10;
        return false;
    L10:
        int r0 = r6.length;
        int r2 = 0;
    L11:
        if (r2 >= r0) goto L16;
        if (Color.BLACK.equals(r6[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    L17:
        return true;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HwmfBitmapDib() {
        return Integer.valueOf(this.headerSize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$HwmfBitmapDib() {
        return Integer.valueOf(this.headerWidth);
    }

    public /* synthetic */ Object lambda$getGenericProperties$10$HwmfBitmapDib() {
        return Long.valueOf(this.headerColorImportant);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$HwmfBitmapDib() {
        return Integer.valueOf(this.headerHeight);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$HwmfBitmapDib() {
        return Integer.valueOf(this.headerPlanes);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$HwmfBitmapDib() {
        return this.headerBitCount;
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$HwmfBitmapDib() {
        return this.headerCompression;
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$HwmfBitmapDib() {
        return Long.valueOf(this.headerImageSize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$HwmfBitmapDib() {
        return Integer.valueOf(this.headerXPelsPerMeter);
    }

    public /* synthetic */ Object lambda$getGenericProperties$8$HwmfBitmapDib() {
        return Integer.valueOf(this.headerYPelsPerMeter);
    }

    public /* synthetic */ Object lambda$getGenericProperties$9$HwmfBitmapDib() {
        return Long.valueOf(this.headerColorUsed);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
