package org.apache.poi.hemf.record.emfplus;

import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusImage {

    /* JADX INFO: renamed from: org.apache.poi.hemf.record.emfplus.HemfPlusImage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = null;

        static {
            int[] r0 = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = r0;
            r0[FileMagic.GIF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L56:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.TIFF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.PNG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L52:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.JPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L58:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.BMP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L12:
            int[] r5 = new int[EmfPlusMetafileDataType.values().length];
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType = r5;
            r5[EmfPlusMetafileDataType.Wmf.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L60:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType[EmfPlusMetafileDataType.WmfPlaceable.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L64:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType[EmfPlusMetafileDataType.Emf.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L38:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType[EmfPlusMetafileDataType.EmfPlusDual.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L46:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusMetafileDataType[EmfPlusMetafileDataType.EmfPlusOnly.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L18:
            int[] r4 = new int[EmfPlusImageDataType.values().length];
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType = r4;
            r4[EmfPlusImageDataType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType[EmfPlusImageDataType.CONTINUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L54:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType[EmfPlusImageDataType.BITMAP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L62:
            $SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType[EmfPlusImageDataType.METAFILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    public static final enum EmfPlusBitmapDataType extends Enum<EmfPlusBitmapDataType> {
        private static final /* synthetic */ EmfPlusBitmapDataType[] $VALUES = null;
        public static final EmfPlusBitmapDataType COMPRESSED = null;
        public static final EmfPlusBitmapDataType PIXEL = null;
        public final int id;

        static {
            EmfPlusBitmapDataType r0 = new EmfPlusBitmapDataType("PIXEL", 0, 0);
            PIXEL = r0;
            EmfPlusBitmapDataType r1 = new EmfPlusBitmapDataType("COMPRESSED", 1, 1);
            COMPRESSED = r1;
            $VALUES = new EmfPlusBitmapDataType[]{r0, r1};
        }

        private EmfPlusBitmapDataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusBitmapDataType valueOf(int r5) {
            EmfPlusBitmapDataType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusBitmapDataType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusBitmapDataType valueOf(String r2) {
            return (EmfPlusBitmapDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusBitmapDataType.class, r2), EmfPlusBitmapDataType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusBitmapDataType[] values() {
            return (EmfPlusBitmapDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusBitmapDataType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusImage implements HemfPlusObject.EmfPlusObjectData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int bitmapHeight;
        private int bitmapStride;
        private EmfPlusBitmapDataType bitmapType;
        private int bitmapWidth;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private byte[] imageData;
        private EmfPlusImageDataType imageDataType;
        private int metafileDataSize;
        private EmfPlusMetafileDataType metafileType;
        private EmfPlusPixelFormat pixelFormat;

        static {
        }

        public EmfPlusImage() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        public int getBitmapHeight() {
            return this.bitmapHeight;
        }

        public int getBitmapStride() {
            return this.bitmapStride;
        }

        public EmfPlusBitmapDataType getBitmapType() {
            return this.bitmapType;
        }

        public int getBitmapWidth() {
            return this.bitmapWidth;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("graphicsVersion", new $$Lambda$VaEkC_fA6sIMxwHPtFUeIrKkdHE(this));
            r0.put("imageDataType", new $$Lambda$0h8VJhi8JT_vMve_5bzsUjxEKL8(this));
            r0.put("bitmapWidth", new $$Lambda$52K6IztSCv735xLZdNnK0gKoGo(this));
            r0.put("bitmapHeight", new $$Lambda$XkIW_Ad0hjN23YSHIXkho9VZndk(this));
            r0.put("bitmapStride", new $$Lambda$ySuy89RvGNqv7AOOuZj7qTUxyzE(this));
            r0.put("pixelFormat", new $$Lambda$x3SqUmxbYbnHaVwKl_c21FALg5o(this));
            r0.put("bitmapType", new $$Lambda$eY5Yxcg2Y3ten34E4hxrrNpVgZc(this));
            r0.put("imageData", new $$Lambda$tXYsCgcgoT9MibYxLtWt_OfXXw0(this));
            r0.put("metafileType", new $$Lambda$pSPl213Srb_H2Nu37nmckOkATQ(this));
            r0.put("metafileDataSize", new $$Lambda$HemfPlusImage$EmfPlusImage$MkQmGhNpT_mij38QiCphsjc(this));
            return Collections.unmodifiableMap(r0);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.IMAGE;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public byte[] getImageData() {
            return this.imageData;
        }

        public EmfPlusImageDataType getImageDataType() {
            return this.imageDataType;
        }

        public EmfPlusMetafileDataType getMetafileType() {
            return this.metafileType;
        }

        public EmfPlusPixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        public long init(LittleEndianInputStream r5, long r6, HemfPlusObject.EmfPlusObjectType r8, int r9) {
            r5.mark(4);
            long r0 = this.graphicsVersion.init(r5);
            if (isContinuedRecord() == false) goto L5;
            this.imageDataType = EmfPlusImageDataType.CONTINUED;
            r5.reset();
            long r1 = 0;
        L7:
            if (this.imageDataType != null) goto L9;
            this.imageDataType = EmfPlusImageDataType.UNKNOWN;
        L9:
            int r10 = AnonymousClass1.$SwitchMap$org$apache$poi$hemf$record$emfplus$HemfPlusImage$EmfPlusImageDataType[this.imageDataType.ordinal()];
            if (r10 == 3) goto L16;
            if (r10 == 4) goto L14;
            this.bitmapWidth = -1;
            this.bitmapHeight = -1;
            this.bitmapStride = -1;
            this.bitmapType = null;
            this.pixelFormat = null;
        L13:
            int r7 = (int) r6;
            this.imageData = IOUtils.toByteArray(r5, r7, 50000000);
            return r1 + ((long) r7);
        L14:
            this.metafileType = EmfPlusMetafileDataType.valueOf(r5.readInt());
            this.metafileDataSize = r5.readInt();
            r1 = r1 + 8;
        L15:
            r6 = r6 - r1;
            goto L13
        L16:
            this.bitmapWidth = r5.readInt();
            this.bitmapHeight = r5.readInt();
            this.bitmapStride = r5.readInt();
            int r11 = r5.readInt();
            EmfPlusBitmapDataType r12 = EmfPlusBitmapDataType.valueOf(r5.readInt());
            this.bitmapType = r12;
            r1 = r1 + 20;
            if (r12 != EmfPlusBitmapDataType.PIXEL) goto L19;
            EmfPlusPixelFormat r13 = EmfPlusPixelFormat.valueOf(r11);
        L20:
            this.pixelFormat = r13;
            goto L15
        L19:
            r13 = EmfPlusPixelFormat.UNDEFINED;
            goto L20
        L5:
            this.imageDataType = EmfPlusImageDataType.valueOf(r5.readInt());
            r1 = r0 + 4;
            goto L7
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusImage$EmfPlusImage() {
            return Integer.valueOf(this.metafileDataSize);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusImageAttributes implements HemfPlusObject.EmfPlusObjectData {
        private Color clampColor;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private EmfPlusObjectClamp objectClamp;
        private EmfPlusWrapMode wrapMode;

        public EmfPlusImageAttributes() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        public Color getClampColor() {
            return this.clampColor;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$LIgwcIKGI8Aqn5vEQJZxTXYFvCg(this), "wrapMode", new $$Lambda$Li8Pc9Nbx8xFKQhkeac45_hnCc(this), "clampColor", new $$Lambda$VMvMiDML3Wq5Ioiq1GxxUzWJwlI(this), "objectClamp", new $$Lambda$iYd4xgJulnQNtxF64OPEF5frjVk(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.IMAGE_ATTRIBUTES;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public EmfPlusObjectClamp getObjectClamp() {
            return this.objectClamp;
        }

        public EmfPlusWrapMode getWrapMode() {
            return this.wrapMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static final enum EmfPlusImageDataType extends Enum<EmfPlusImageDataType> {
        private static final /* synthetic */ EmfPlusImageDataType[] $VALUES = null;
        public static final EmfPlusImageDataType BITMAP = null;
        public static final EmfPlusImageDataType CONTINUED = null;
        public static final EmfPlusImageDataType METAFILE = null;
        public static final EmfPlusImageDataType UNKNOWN = null;
        public final int id;

        static {
            EmfPlusImageDataType r0 = new EmfPlusImageDataType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            EmfPlusImageDataType r1 = new EmfPlusImageDataType("BITMAP", 1, 1);
            BITMAP = r1;
            EmfPlusImageDataType r3 = new EmfPlusImageDataType("METAFILE", 2, 2);
            METAFILE = r3;
            EmfPlusImageDataType r5 = new EmfPlusImageDataType("CONTINUED", 3, -1);
            CONTINUED = r5;
            $VALUES = new EmfPlusImageDataType[]{r0, r1, r3, r5};
        }

        private EmfPlusImageDataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusImageDataType valueOf(int r5) {
            EmfPlusImageDataType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusImageDataType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusImageDataType valueOf(String r2) {
            return (EmfPlusImageDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusImageDataType.class, r2), EmfPlusImageDataType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusImageDataType[] values() {
            return (EmfPlusImageDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusImageDataType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusMetafileDataType extends Enum<EmfPlusMetafileDataType> {
        private static final /* synthetic */ EmfPlusMetafileDataType[] $VALUES = null;
        public static final EmfPlusMetafileDataType Emf = null;
        public static final EmfPlusMetafileDataType EmfPlusDual = null;
        public static final EmfPlusMetafileDataType EmfPlusOnly = null;
        public static final EmfPlusMetafileDataType Wmf = null;
        public static final EmfPlusMetafileDataType WmfPlaceable = null;
        public final int id;

        static {
            EmfPlusMetafileDataType r0 = new EmfPlusMetafileDataType("Wmf", 0, 1);
            Wmf = r0;
            EmfPlusMetafileDataType r1 = new EmfPlusMetafileDataType("WmfPlaceable", 1, 2);
            WmfPlaceable = r1;
            EmfPlusMetafileDataType r4 = new EmfPlusMetafileDataType("Emf", 2, 3);
            Emf = r4;
            EmfPlusMetafileDataType r6 = new EmfPlusMetafileDataType("EmfPlusOnly", 3, 4);
            EmfPlusOnly = r6;
            EmfPlusMetafileDataType r8 = new EmfPlusMetafileDataType("EmfPlusDual", 4, 5);
            EmfPlusDual = r8;
            $VALUES = new EmfPlusMetafileDataType[]{r0, r1, r4, r6, r8};
        }

        private EmfPlusMetafileDataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusMetafileDataType valueOf(int r5) {
            EmfPlusMetafileDataType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusMetafileDataType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusMetafileDataType valueOf(String r2) {
            return (EmfPlusMetafileDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusMetafileDataType.class, r2), EmfPlusMetafileDataType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusMetafileDataType[] values() {
            return (EmfPlusMetafileDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusMetafileDataType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusObjectClamp extends Enum<EmfPlusObjectClamp> {
        private static final /* synthetic */ EmfPlusObjectClamp[] $VALUES = null;
        public static final EmfPlusObjectClamp BitmapClamp = null;
        public static final EmfPlusObjectClamp RectClamp = null;
        public final int id;

        static {
            EmfPlusObjectClamp r0 = new EmfPlusObjectClamp("RectClamp", 0, 0);
            RectClamp = r0;
            EmfPlusObjectClamp r1 = new EmfPlusObjectClamp("BitmapClamp", 1, 1);
            BitmapClamp = r1;
            $VALUES = new EmfPlusObjectClamp[]{r0, r1};
        }

        private EmfPlusObjectClamp(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusObjectClamp valueOf(int r5) {
            EmfPlusObjectClamp[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusObjectClamp r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusObjectClamp valueOf(String r2) {
            return (EmfPlusObjectClamp) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusObjectClamp.class, r2), EmfPlusObjectClamp.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusObjectClamp[] values() {
            return (EmfPlusObjectClamp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusObjectClamp[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusPixelFormat extends Enum<EmfPlusPixelFormat> {
        private static final /* synthetic */ EmfPlusPixelFormat[] $VALUES = null;
        private static final BitField ALPHA = null;
        public static final EmfPlusPixelFormat ARGB1555_16BPP = null;
        public static final EmfPlusPixelFormat ARGB_32BPP = null;
        public static final EmfPlusPixelFormat ARGB_64BPP = null;
        private static final BitField BPP = null;
        private static final BitField CANONICAL = null;
        private static final BitField EXTCOLORS = null;
        private static final BitField GDI = null;
        public static final EmfPlusPixelFormat GRAYSCALE_16BPP = null;
        private static final BitField INDEX = null;
        public static final EmfPlusPixelFormat INDEXED_1BPP = null;
        public static final EmfPlusPixelFormat INDEXED_4BPP = null;
        public static final EmfPlusPixelFormat INDEXED_8BPP = null;
        private static final BitField PALETTE = null;
        public static final EmfPlusPixelFormat PARGB_32BPP = null;
        public static final EmfPlusPixelFormat PARGB_64BPP = null;
        private static final BitField PREMULTI = null;
        public static final EmfPlusPixelFormat RGB555_16BPP = null;
        public static final EmfPlusPixelFormat RGB565_16BPP = null;
        public static final EmfPlusPixelFormat RGB_24BPP = null;
        public static final EmfPlusPixelFormat RGB_32BPP = null;
        public static final EmfPlusPixelFormat RGB_48BPP = null;
        public static final EmfPlusPixelFormat UNDEFINED = null;
        public final int id;

        static {
            EmfPlusPixelFormat r0 = new EmfPlusPixelFormat("UNDEFINED", 0, 0);
            UNDEFINED = r0;
            EmfPlusPixelFormat r1 = new EmfPlusPixelFormat("INDEXED_1BPP", 1, 196865);
            INDEXED_1BPP = r1;
            EmfPlusPixelFormat r3 = new EmfPlusPixelFormat("INDEXED_4BPP", 2, 197634);
            INDEXED_4BPP = r3;
            EmfPlusPixelFormat r5 = new EmfPlusPixelFormat("INDEXED_8BPP", 3, 198659);
            INDEXED_8BPP = r5;
            EmfPlusPixelFormat r7 = new EmfPlusPixelFormat("GRAYSCALE_16BPP", 4, 1052676);
            GRAYSCALE_16BPP = r7;
            EmfPlusPixelFormat r9 = new EmfPlusPixelFormat("RGB555_16BPP", 5, 135173);
            RGB555_16BPP = r9;
            EmfPlusPixelFormat r11 = new EmfPlusPixelFormat("RGB565_16BPP", 6, 135174);
            RGB565_16BPP = r11;
            EmfPlusPixelFormat r13 = new EmfPlusPixelFormat("ARGB1555_16BPP", 7, 397319);
            ARGB1555_16BPP = r13;
            EmfPlusPixelFormat r12 = new EmfPlusPixelFormat("RGB_24BPP", 8, 137224);
            RGB_24BPP = r12;
            EmfPlusPixelFormat r10 = new EmfPlusPixelFormat("RGB_32BPP", 9, 139273);
            RGB_32BPP = r10;
            EmfPlusPixelFormat r8 = new EmfPlusPixelFormat("ARGB_32BPP", 10, 2498570);
            ARGB_32BPP = r8;
            EmfPlusPixelFormat r6 = new EmfPlusPixelFormat("PARGB_32BPP", 11, 925707);
            PARGB_32BPP = r6;
            EmfPlusPixelFormat r4 = new EmfPlusPixelFormat("RGB_48BPP", 12, 1060876);
            RGB_48BPP = r4;
            EmfPlusPixelFormat r2 = new EmfPlusPixelFormat("ARGB_64BPP", 13, 3424269);
            ARGB_64BPP = r2;
            EmfPlusPixelFormat r14 = new EmfPlusPixelFormat("PARGB_64BPP", 14, 1720334);
            PARGB_64BPP = r14;
            $VALUES = new EmfPlusPixelFormat[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14};
            CANONICAL = BitFieldFactory.getInstance(2097152);
            EXTCOLORS = BitFieldFactory.getInstance(1048576);
            PREMULTI = BitFieldFactory.getInstance(524288);
            ALPHA = BitFieldFactory.getInstance(262144);
            GDI = BitFieldFactory.getInstance(131072);
            PALETTE = BitFieldFactory.getInstance(65536);
            BPP = BitFieldFactory.getInstance(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
            INDEX = BitFieldFactory.getInstance(255);
        }

        private EmfPlusPixelFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusPixelFormat valueOf(int r5) {
            EmfPlusPixelFormat[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusPixelFormat r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusPixelFormat valueOf(String r2) {
            return (EmfPlusPixelFormat) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusPixelFormat.class, r2), EmfPlusPixelFormat.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusPixelFormat[] values() {
            return (EmfPlusPixelFormat[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusPixelFormat[].class, "com.obric.memorydata.plugin");
        }

        public int getBitsPerPixel() {
            int r1 = this.id;
            if (r1 != (-1)) goto L6;
            return -1;
        L6:
            return BPP.getValue(r1);
        }

        public int getGDIEnumIndex() {
            int r1 = this.id;
            if (r1 != (-1)) goto L6;
            return -1;
        L6:
            return INDEX.getValue(r1);
        }

        public boolean isAlpha() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (ALPHA.isSet(r1) == false) goto L7;
            return true;
        }

        public boolean isCanonical() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (CANONICAL.isSet(r1) == false) goto L7;
            return true;
        }

        public boolean isExtendedColors() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (EXTCOLORS.isSet(r1) == false) goto L7;
            return true;
        }

        public boolean isGDISupported() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (GDI.isSet(r1) == false) goto L7;
            return true;
        }

        public boolean isPaletteIndexed() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (PALETTE.isSet(r1) == false) goto L7;
            return true;
        }

        public boolean isPreMultiplied() {
            int r1 = this.id;
            if (r1 != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (PREMULTI.isSet(r1) == false) goto L7;
            return true;
        }
    }

    public static final enum EmfPlusWrapMode extends Enum<EmfPlusWrapMode> {
        private static final /* synthetic */ EmfPlusWrapMode[] $VALUES = null;
        public static final EmfPlusWrapMode WRAP_MODE_CLAMP = null;
        public static final EmfPlusWrapMode WRAP_MODE_TILE = null;
        public static final EmfPlusWrapMode WRAP_MODE_TILE_FLIP_X = null;
        public static final EmfPlusWrapMode WRAP_MODE_TILE_FLIP_XY = null;
        public static final EmfPlusWrapMode WRAP_MODE_TILE_FLIP_Y = null;
        public final int id;

        static {
            EmfPlusWrapMode r0 = new EmfPlusWrapMode("WRAP_MODE_TILE", 0, 0);
            WRAP_MODE_TILE = r0;
            EmfPlusWrapMode r1 = new EmfPlusWrapMode("WRAP_MODE_TILE_FLIP_X", 1, 1);
            WRAP_MODE_TILE_FLIP_X = r1;
            EmfPlusWrapMode r3 = new EmfPlusWrapMode("WRAP_MODE_TILE_FLIP_Y", 2, 2);
            WRAP_MODE_TILE_FLIP_Y = r3;
            EmfPlusWrapMode r5 = new EmfPlusWrapMode("WRAP_MODE_TILE_FLIP_XY", 3, 3);
            WRAP_MODE_TILE_FLIP_XY = r5;
            EmfPlusWrapMode r7 = new EmfPlusWrapMode("WRAP_MODE_CLAMP", 4, 4);
            WRAP_MODE_CLAMP = r7;
            $VALUES = new EmfPlusWrapMode[]{r0, r1, r3, r5, r7};
        }

        private EmfPlusWrapMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusWrapMode valueOf(int r5) {
            EmfPlusWrapMode[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusWrapMode r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusWrapMode valueOf(String r2) {
            return (EmfPlusWrapMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusWrapMode.class, r2), EmfPlusWrapMode.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusWrapMode[] values() {
            return (EmfPlusWrapMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusWrapMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public HemfPlusImage() {
    }
}
