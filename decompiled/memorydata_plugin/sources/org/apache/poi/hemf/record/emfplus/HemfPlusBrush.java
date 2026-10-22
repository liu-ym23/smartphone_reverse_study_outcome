package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hemf.record.emf.HemfFill;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusBrush {

    public static class EmfPlusBrush implements HemfPlusObject.EmfPlusObjectData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private byte[] brushBytes;
        private EmfPlusBrushType brushType;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;

        static {
        }

        public EmfPlusBrush() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        public byte[] getBrushBytes() {
            return this.brushBytes;
        }

        public EmfPlusBrushData getBrushData(List<? extends HemfPlusObject.EmfPlusObjectData> r4) {
            List<? extends HemfPlusObject.EmfPlusObjectData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            EmfPlusBrushData r0 = (EmfPlusBrushData) ZeusTransformUtils.preCheckCast(this.brushType.constructor.get(), EmfPlusBrushData.class, "com.obric.memorydata.plugin");
            byte[] r3 = getRawData(r5);
            r0.init(new LittleEndianInputStream(new UnsynchronizedByteArrayInputStream(r3)), r3.length);     // Catch: IOException -> L5
            return r0;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$CK0bmVe7UDU5j17WyfA72rMjjM(this), "brushData", new $$Lambda$HemfPlusBrush$EmfPlusBrush$v7Mgq7HJF3IAxQv31DxdmWZdmY(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return this.brushType;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public byte[] getRawData(List<? extends HemfPlusObject.EmfPlusObjectData> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();     // Catch: IOException -> L21
            r0.write(getBrushBytes());     // Catch: Throwable -> L13
            if (r5 == null) goto L10;
            Iterator r3 = r5.iterator();     // Catch: Throwable -> L13
        L8:
            if (r3.hasNext() == false) goto L10;
            r0.write(((EmfPlusBrush) ZeusTransformUtils.preCheckCast((HemfPlusObject.EmfPlusObjectData) ZeusTransformUtils.preCheckCast(r3.next(), HemfPlusObject.EmfPlusObjectData.class, "com.obric.memorydata.plugin"), EmfPlusBrush.class, "com.obric.memorydata.plugin")).getBrushBytes());     // Catch: Throwable -> L13
        L10:
            byte[] r6 = r0.toByteArray();     // Catch: Throwable -> L13
            r0.close();     // Catch: IOException -> L21
            return r6;
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L18
        L20:
            throw th;     // Catch: IOException -> L21
        L18:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L21
        L21:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusBrush$EmfPlusBrush() {
            return getBrushData(null);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public interface EmfPlusBrushData extends GenericRecord {
        public static final BitField BLEND_FACTORS_H = null;
        public static final BitField BLEND_FACTORS_V = null;
        public static final BitField DO_NOT_TRANSFORM = null;
        public static final BitField FOCUS_SCALES = null;
        public static final BitField IS_GAMMA_CORRECTED = null;
        public static final BitField PATH = null;
        public static final BitField PRESET_COLORS = null;
        public static final BitField TRANSFORM = null;

        static {
            PATH = BitFieldFactory.getInstance(1);
            TRANSFORM = BitFieldFactory.getInstance(2);
            PRESET_COLORS = BitFieldFactory.getInstance(4);
            BLEND_FACTORS_H = BitFieldFactory.getInstance(8);
            BLEND_FACTORS_V = BitFieldFactory.getInstance(16);
            FOCUS_SCALES = BitFieldFactory.getInstance(64);
            IS_GAMMA_CORRECTED = BitFieldFactory.getInstance(128);
            DO_NOT_TRANSFORM = BitFieldFactory.getInstance(256);
        }

        long init(LittleEndianInputStream r1, long r2);
    }

    public static final enum EmfPlusBrushType extends Enum<EmfPlusBrushType> {
        private static final /* synthetic */ EmfPlusBrushType[] $VALUES = null;
        public static final EmfPlusBrushType HATCH_FILL = null;
        public static final EmfPlusBrushType LINEAR_GRADIENT = null;
        public static final EmfPlusBrushType PATH_GRADIENT = null;
        public static final EmfPlusBrushType SOLID_COLOR = null;
        public static final EmfPlusBrushType TEXTURE_FILL = null;
        public final Supplier<? extends EmfPlusBrushData> constructor;
        public final int id;

        static {
            EmfPlusBrushType r0 = new EmfPlusBrushType("SOLID_COLOR", 0, 0, $$Lambda$Et80jD6w16WSfKXmPk7IYpuBUk.INSTANCE);
            SOLID_COLOR = r0;
            EmfPlusBrushType r1 = new EmfPlusBrushType("HATCH_FILL", 1, 1, $$Lambda$aTx9kwyhIm1oLqDtVUnHS2W6yJE.INSTANCE);
            HATCH_FILL = r1;
            EmfPlusBrushType r2 = new EmfPlusBrushType("TEXTURE_FILL", 2, 2, $$Lambda$4DHMwaFtLeejGbZsYcBbxqZBleU.INSTANCE);
            TEXTURE_FILL = r2;
            EmfPlusBrushType r4 = new EmfPlusBrushType("PATH_GRADIENT", 3, 3, $$Lambda$GPQXcvvOCRl3O1kC_dZr1AwcFZI.INSTANCE);
            PATH_GRADIENT = r4;
            EmfPlusBrushType r6 = new EmfPlusBrushType("LINEAR_GRADIENT", 4, 4, $$Lambda$mJk79gZ1iJvgJDLeJuaqd4Mgzh0.INSTANCE);
            LINEAR_GRADIENT = r6;
            $VALUES = new EmfPlusBrushType[]{r0, r1, r2, r4, r6};
        }

        private EmfPlusBrushType(String r3, int r4, int r5, Supplier r6) {
            Supplier<? extends EmfPlusBrushData> r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.id = r5;
            this.constructor = r7;
        }

        public static EmfPlusBrushType valueOf(int r5) {
            EmfPlusBrushType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusBrushType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusBrushType valueOf(String r2) {
            return (EmfPlusBrushType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusBrushType.class, r2), EmfPlusBrushType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusBrushType[] values() {
            return (EmfPlusBrushType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusBrushType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusHatchBrushData implements EmfPlusBrushData {
        private Color backColor;
        private Color foreColor;
        private EmfPlusHatchStyle style;

        public EmfPlusHatchBrushData() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("style", new $$Lambda$HemfPlusBrush$EmfPlusHatchBrushData$xbCI6lvMshsHf6OiJ7MXcMKs7ug(this), "foreColor", new $$Lambda$HemfPlusBrush$EmfPlusHatchBrushData$3jWuU0ABdXBYwnOgBcbjn5CYbc(this), "backColor", new $$Lambda$HemfPlusBrush$EmfPlusHatchBrushData$hlgF7jXvi_DtkA93aUQZIiUD6DY(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return EmfPlusBrushType.HATCH_FILL;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusBrush.EmfPlusBrushData
        public long init(LittleEndianInputStream r1, long r2) {
            this.style = EmfPlusHatchStyle.valueOf(r1.readInt());
            this.foreColor = HemfPlusDraw.readARGB(r1.readInt());
            this.backColor = HemfPlusDraw.readARGB(r1.readInt());
            return 12;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusBrush$EmfPlusHatchBrushData() {
            return this.style;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusBrush$EmfPlusHatchBrushData() {
            return this.foreColor;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusBrush$EmfPlusHatchBrushData() {
            return this.backColor;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static final enum EmfPlusHatchStyle extends Enum<EmfPlusHatchStyle> {
        private static final /* synthetic */ EmfPlusHatchStyle[] $VALUES = null;
        public static final EmfPlusHatchStyle BACKWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle DARK_DOWNWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle DARK_HORIZONTAL = null;
        public static final EmfPlusHatchStyle DARK_UPWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle DARK_VERTICAL = null;
        public static final EmfPlusHatchStyle DASHED_DOWNWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle DASHED_HORIZONTAL = null;
        public static final EmfPlusHatchStyle DASHED_UPWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle DASHED_VERTICAL = null;
        public static final EmfPlusHatchStyle DIAGONAL_BRICK = null;
        public static final EmfPlusHatchStyle DIAGONAL_CROSS = null;
        public static final EmfPlusHatchStyle DIVOT = null;
        public static final EmfPlusHatchStyle DOTTED_DIAMOND = null;
        public static final EmfPlusHatchStyle DOTTED_GRID = null;
        public static final EmfPlusHatchStyle FORWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle HORIZONTAL = null;
        public static final EmfPlusHatchStyle HORIZONTAL_BRICK = null;
        public static final EmfPlusHatchStyle LARGE_CHECKER_BOARD = null;
        public static final EmfPlusHatchStyle LARGE_CONFETTI = null;
        public static final EmfPlusHatchStyle LARGE_GRID = null;
        public static final EmfPlusHatchStyle LIGHT_DOWNWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle LIGHT_HORIZONTAL = null;
        public static final EmfPlusHatchStyle LIGHT_UPWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle LIGHT_VERTICAL = null;
        public static final EmfPlusHatchStyle NARROW_HORIZONTAL = null;
        public static final EmfPlusHatchStyle NARROW_VERTICAL = null;
        public static final EmfPlusHatchStyle OUTLINED_DIAMOND = null;
        public static final EmfPlusHatchStyle PERCENT_05 = null;
        public static final EmfPlusHatchStyle PERCENT_10 = null;
        public static final EmfPlusHatchStyle PERCENT_20 = null;
        public static final EmfPlusHatchStyle PERCENT_25 = null;
        public static final EmfPlusHatchStyle PERCENT_30 = null;
        public static final EmfPlusHatchStyle PERCENT_40 = null;
        public static final EmfPlusHatchStyle PERCENT_50 = null;
        public static final EmfPlusHatchStyle PERCENT_60 = null;
        public static final EmfPlusHatchStyle PERCENT_70 = null;
        public static final EmfPlusHatchStyle PERCENT_75 = null;
        public static final EmfPlusHatchStyle PERCENT_80 = null;
        public static final EmfPlusHatchStyle PERCENT_90 = null;
        public static final EmfPlusHatchStyle PLAID = null;
        public static final EmfPlusHatchStyle SHINGLE = null;
        public static final EmfPlusHatchStyle SMALL_CHECKER_BOARD = null;
        public static final EmfPlusHatchStyle SMALL_CONFETTI = null;
        public static final EmfPlusHatchStyle SMALL_GRID = null;
        public static final EmfPlusHatchStyle SOLID_DIAMOND = null;
        public static final EmfPlusHatchStyle SPHERE = null;
        public static final EmfPlusHatchStyle TRELLIS = null;
        public static final EmfPlusHatchStyle VERTICAL = null;
        public static final EmfPlusHatchStyle WAVE = null;
        public static final EmfPlusHatchStyle WEAVE = null;
        public static final EmfPlusHatchStyle WIDE_DOWNWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle WIDE_UPWARD_DIAGONAL = null;
        public static final EmfPlusHatchStyle ZIGZAG = null;
        public final int id;

        static {
            HORIZONTAL = new EmfPlusHatchStyle("HORIZONTAL", 0, 0);
            VERTICAL = new EmfPlusHatchStyle("VERTICAL", 1, 1);
            FORWARD_DIAGONAL = new EmfPlusHatchStyle("FORWARD_DIAGONAL", 2, 2);
            BACKWARD_DIAGONAL = new EmfPlusHatchStyle("BACKWARD_DIAGONAL", 3, 3);
            LARGE_GRID = new EmfPlusHatchStyle("LARGE_GRID", 4, 4);
            DIAGONAL_CROSS = new EmfPlusHatchStyle("DIAGONAL_CROSS", 5, 5);
            PERCENT_05 = new EmfPlusHatchStyle("PERCENT_05", 6, 6);
            PERCENT_10 = new EmfPlusHatchStyle("PERCENT_10", 7, 7);
            PERCENT_20 = new EmfPlusHatchStyle("PERCENT_20", 8, 8);
            PERCENT_25 = new EmfPlusHatchStyle("PERCENT_25", 9, 9);
            PERCENT_30 = new EmfPlusHatchStyle("PERCENT_30", 10, 10);
            PERCENT_40 = new EmfPlusHatchStyle("PERCENT_40", 11, 11);
            PERCENT_50 = new EmfPlusHatchStyle("PERCENT_50", 12, 12);
            PERCENT_60 = new EmfPlusHatchStyle("PERCENT_60", 13, 13);
            PERCENT_70 = new EmfPlusHatchStyle("PERCENT_70", 14, 14);
            PERCENT_75 = new EmfPlusHatchStyle("PERCENT_75", 15, 15);
            PERCENT_80 = new EmfPlusHatchStyle("PERCENT_80", 16, 16);
            PERCENT_90 = new EmfPlusHatchStyle("PERCENT_90", 17, 17);
            LIGHT_DOWNWARD_DIAGONAL = new EmfPlusHatchStyle("LIGHT_DOWNWARD_DIAGONAL", 18, 18);
            LIGHT_UPWARD_DIAGONAL = new EmfPlusHatchStyle("LIGHT_UPWARD_DIAGONAL", 19, 19);
            DARK_DOWNWARD_DIAGONAL = new EmfPlusHatchStyle("DARK_DOWNWARD_DIAGONAL", 20, 20);
            DARK_UPWARD_DIAGONAL = new EmfPlusHatchStyle("DARK_UPWARD_DIAGONAL", 21, 21);
            WIDE_DOWNWARD_DIAGONAL = new EmfPlusHatchStyle("WIDE_DOWNWARD_DIAGONAL", 22, 22);
            WIDE_UPWARD_DIAGONAL = new EmfPlusHatchStyle("WIDE_UPWARD_DIAGONAL", 23, 23);
            LIGHT_VERTICAL = new EmfPlusHatchStyle("LIGHT_VERTICAL", 24, 24);
            LIGHT_HORIZONTAL = new EmfPlusHatchStyle("LIGHT_HORIZONTAL", 25, 25);
            NARROW_VERTICAL = new EmfPlusHatchStyle("NARROW_VERTICAL", 26, 26);
            NARROW_HORIZONTAL = new EmfPlusHatchStyle("NARROW_HORIZONTAL", 27, 27);
            DARK_VERTICAL = new EmfPlusHatchStyle("DARK_VERTICAL", 28, 28);
            DARK_HORIZONTAL = new EmfPlusHatchStyle("DARK_HORIZONTAL", 29, 29);
            DASHED_DOWNWARD_DIAGONAL = new EmfPlusHatchStyle("DASHED_DOWNWARD_DIAGONAL", 30, 30);
            DASHED_UPWARD_DIAGONAL = new EmfPlusHatchStyle("DASHED_UPWARD_DIAGONAL", 31, 31);
            DASHED_HORIZONTAL = new EmfPlusHatchStyle("DASHED_HORIZONTAL", 32, 32);
            DASHED_VERTICAL = new EmfPlusHatchStyle("DASHED_VERTICAL", 33, 33);
            SMALL_CONFETTI = new EmfPlusHatchStyle("SMALL_CONFETTI", 34, 34);
            LARGE_CONFETTI = new EmfPlusHatchStyle("LARGE_CONFETTI", 35, 35);
            ZIGZAG = new EmfPlusHatchStyle("ZIGZAG", 36, 36);
            WAVE = new EmfPlusHatchStyle("WAVE", 37, 37);
            DIAGONAL_BRICK = new EmfPlusHatchStyle("DIAGONAL_BRICK", 38, 38);
            HORIZONTAL_BRICK = new EmfPlusHatchStyle("HORIZONTAL_BRICK", 39, 39);
            WEAVE = new EmfPlusHatchStyle("WEAVE", 40, 40);
            PLAID = new EmfPlusHatchStyle("PLAID", 41, 41);
            DIVOT = new EmfPlusHatchStyle("DIVOT", 42, 42);
            DOTTED_GRID = new EmfPlusHatchStyle("DOTTED_GRID", 43, 43);
            DOTTED_DIAMOND = new EmfPlusHatchStyle("DOTTED_DIAMOND", 44, 44);
            SHINGLE = new EmfPlusHatchStyle("SHINGLE", 45, 45);
            TRELLIS = new EmfPlusHatchStyle("TRELLIS", 46, 46);
            SPHERE = new EmfPlusHatchStyle("SPHERE", 47, 47);
            SMALL_GRID = new EmfPlusHatchStyle("SMALL_GRID", 48, 48);
            SMALL_CHECKER_BOARD = new EmfPlusHatchStyle("SMALL_CHECKER_BOARD", 49, 49);
            LARGE_CHECKER_BOARD = new EmfPlusHatchStyle("LARGE_CHECKER_BOARD", 50, 50);
            OUTLINED_DIAMOND = new EmfPlusHatchStyle("OUTLINED_DIAMOND", 51, 51);
            SOLID_DIAMOND = new EmfPlusHatchStyle("SOLID_DIAMOND", 52, 52);
            $VALUES = new EmfPlusHatchStyle[]{HORIZONTAL, VERTICAL, FORWARD_DIAGONAL, BACKWARD_DIAGONAL, LARGE_GRID, DIAGONAL_CROSS, PERCENT_05, PERCENT_10, PERCENT_20, PERCENT_25, PERCENT_30, PERCENT_40, PERCENT_50, PERCENT_60, PERCENT_70, PERCENT_75, PERCENT_80, PERCENT_90, LIGHT_DOWNWARD_DIAGONAL, LIGHT_UPWARD_DIAGONAL, DARK_DOWNWARD_DIAGONAL, DARK_UPWARD_DIAGONAL, WIDE_DOWNWARD_DIAGONAL, WIDE_UPWARD_DIAGONAL, LIGHT_VERTICAL, LIGHT_HORIZONTAL, NARROW_VERTICAL, NARROW_HORIZONTAL, DARK_VERTICAL, DARK_HORIZONTAL, DASHED_DOWNWARD_DIAGONAL, DASHED_UPWARD_DIAGONAL, DASHED_HORIZONTAL, DASHED_VERTICAL, SMALL_CONFETTI, LARGE_CONFETTI, ZIGZAG, WAVE, DIAGONAL_BRICK, HORIZONTAL_BRICK, WEAVE, PLAID, DIVOT, DOTTED_GRID, DOTTED_DIAMOND, SHINGLE, TRELLIS, SPHERE, SMALL_GRID, SMALL_CHECKER_BOARD, LARGE_CHECKER_BOARD, OUTLINED_DIAMOND, SOLID_DIAMOND};
        }

        private EmfPlusHatchStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusHatchStyle valueOf(int r5) {
            EmfPlusHatchStyle[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusHatchStyle r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusHatchStyle valueOf(String r2) {
            return (EmfPlusHatchStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusHatchStyle.class, r2), EmfPlusHatchStyle.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusHatchStyle[] values() {
            return (EmfPlusHatchStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusHatchStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusLinearGradientBrushData implements EmfPlusBrushData {
        private static final int[] FLAG_MASKS = null;
        private static final String[] FLAG_NAMES = null;
        private Color[] blendColors;
        private float[] blendFactorsH;
        private float[] blendFactorsV;
        private AffineTransform blendTransform;
        private int dataFlags;
        private Color endColor;
        private float[] positions;
        private float[] positionsH;
        private float[] positionsV;
        private final Rectangle2D rect;
        private Color startColor;
        private HemfPlusImage.EmfPlusWrapMode wrapMode;

        static {
            FLAG_MASKS = new int[]{2, 4, 8, 16, 128};
            FLAG_NAMES = new String[]{"TRANSFORM", "PRESET_COLORS", "BLEND_FACTORS_H", "BLEND_FACTORS_V", "BRUSH_DATA_IS_GAMMA_CORRECTED"};
        }

        public EmfPlusLinearGradientBrushData() {
            this.rect = new Rectangle2D.Double();
        }

        private boolean isBlendH() {
            return BLEND_FACTORS_H.isSet(this.dataFlags);
        }

        private boolean isBlendV() {
            return BLEND_FACTORS_V.isSet(this.dataFlags);
        }

        private boolean isPreset() {
            return PRESET_COLORS.isSet(this.dataFlags);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$zruGtPugptv2QqKo70PnCvIIFd0(this), FLAG_MASKS, FLAG_NAMES));
            r0.put("wrapMode", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$l5qy9xPaNqDGIDYYBS64aczqd7Y(this));
            r0.put("rect", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$c5oyB3urNn6HNanncUooKSykOoc(this));
            r0.put("startColor", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$MET7LMHyn32vrXDz3fZFKdn8P3o(this));
            r0.put("endColor", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$7E7WHqtOXG4FX3BppQlcMnWAro(this));
            r0.put("blendTransform", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$7MogmJtt6s81YnO8fjWXpzpSG9Q(this));
            r0.put("positions", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$dad76XFBLUEb_XWS82PNsUijvwQ(this));
            r0.put("blendColors", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$Eypc1wKqxzylJ5NoxGm6XuPACk(this));
            r0.put("positionsV", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$h8bH1gztoCd2WtiwQJ4RuPTzP0Q(this));
            r0.put("blendFactorsV", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$pELfS3mEyQX85qSbLzKB2YOvftc(this));
            r0.put("positionsH", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$MsJFlfhPfTu3oHQ6M52ayJWxnB0(this));
            r0.put("blendFactorsH", new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$ifknc9B9aaIGxqPFOY91nlAjuI(this));
            return Collections.unmodifiableMap(r0);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return EmfPlusBrushType.LINEAR_GRADIENT;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusBrush.EmfPlusBrushData
        public long init(LittleEndianInputStream r6, long r7) {
            this.dataFlags = r6.readInt();
            this.wrapMode = HemfPlusImage.EmfPlusWrapMode.valueOf(r6.readInt());
            long r8 = ((long) HemfPlusDraw.readRectF(r6, this.rect)) + 8;
            this.startColor = HemfPlusDraw.readARGB(r6.readInt());
            this.endColor = HemfPlusDraw.readARGB(r6.readInt());
            r6.skipFully(8);
            long r9 = r8 + 16;
            if (TRANSFORM.isSet(this.dataFlags) == false) goto L6;
            AffineTransform r0 = new AffineTransform();
            this.blendTransform = r0;
            r9 = r9 + ((long) HemfFill.readXForm(r6, r0));
        L6:
            if (isPreset() == true) goto L8;
        L14:
            long r1 = 0;
            if (isPreset() == false) goto L17;
            long r3 = HemfPlusBrush.access$000(r6, new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$vqpNXbsVR22CxBEZIE1x_mY4N30(this), new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$SsOINQt488YamjTwAqLdjp7QsM(this));
        L18:
            long r10 = r9 + r3;
            if (isBlendV() == false) goto L21;
            long r4 = HemfPlusBrush.access$100(r6, new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$u7jam3CkhQ0DBqOXviWmV6cd_o4(this), new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$T9ImRf55jCt8SbINVi4j0nsUzs(this));
        L22:
            long r11 = r10 + r4;
            if (isBlendH() == false) goto L26;
            r1 = HemfPlusBrush.access$100(r6, new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$nMK4p1QtrlzrflyEQwQ4rHlOI4(this), new $$Lambda$HemfPlusBrush$EmfPlusLinearGradientBrushData$dhnfJO3NkVdRsQwS0mHhUZdyfk(this));
        L26:
            return r11 + r1;
        L21:
            r4 = 0;
            goto L22
        L17:
            r3 = 0;
            goto L18
        L8:
            if (isBlendH() == true) goto L13;
            if (isBlendV() == false) goto L14;
        L13:
            throw new RuntimeException("invalid combination of preset colors and blend factors v/h");
        }

        public /* synthetic */ Object lambda$getGenericProperties$10$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.endColor;
        }

        public /* synthetic */ Object lambda$getGenericProperties$11$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.blendTransform;
        }

        public /* synthetic */ Object lambda$getGenericProperties$12$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.positions;
        }

        public /* synthetic */ Object lambda$getGenericProperties$13$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.blendColors;
        }

        public /* synthetic */ Object lambda$getGenericProperties$14$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.positionsV;
        }

        public /* synthetic */ Object lambda$getGenericProperties$15$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.blendFactorsV;
        }

        public /* synthetic */ Object lambda$getGenericProperties$16$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.positionsH;
        }

        public /* synthetic */ Object lambda$getGenericProperties$17$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.blendFactorsH;
        }

        public /* synthetic */ Number lambda$getGenericProperties$6$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return Integer.valueOf(this.dataFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.wrapMode;
        }

        public /* synthetic */ Object lambda$getGenericProperties$8$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.rect;
        }

        public /* synthetic */ Object lambda$getGenericProperties$9$HemfPlusBrush$EmfPlusLinearGradientBrushData() {
            return this.startColor;
        }

        public /* synthetic */ void lambda$init$0$HemfPlusBrush$EmfPlusLinearGradientBrushData(float[] r1) {
            this.positions = r1;
        }

        public /* synthetic */ void lambda$init$1$HemfPlusBrush$EmfPlusLinearGradientBrushData(Color[] r1) {
            this.blendColors = r1;
        }

        public /* synthetic */ void lambda$init$2$HemfPlusBrush$EmfPlusLinearGradientBrushData(float[] r1) {
            this.positionsV = r1;
        }

        public /* synthetic */ void lambda$init$3$HemfPlusBrush$EmfPlusLinearGradientBrushData(float[] r1) {
            this.blendFactorsV = r1;
        }

        public /* synthetic */ void lambda$init$4$HemfPlusBrush$EmfPlusLinearGradientBrushData(float[] r1) {
            this.positionsH = r1;
        }

        public /* synthetic */ void lambda$init$5$HemfPlusBrush$EmfPlusLinearGradientBrushData(float[] r1) {
            this.blendFactorsH = r1;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusPathGradientBrushData implements EmfPlusBrushData {
        private Color[] blendColors;
        private float[] blendFactorsH;
        private AffineTransform blendTransform;
        private HemfPlusPath.EmfPlusPath boundaryPath;
        private Point2D[] boundaryPoints;
        private Color centerColor;
        private final Point2D centerPoint;
        private int dataFlags;
        private Double focusScaleX;
        private Double focusScaleY;
        private float[] positions;
        private Color[] surroundingColor;
        private HemfPlusImage.EmfPlusWrapMode wrapMode;

        public EmfPlusPathGradientBrushData() {
            this.centerPoint = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("flags", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$kRnYeIrFW8DDv2yprhe_TLhVrEY(this));
            r0.put("wrapMode", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$vxWXCzb1GdQ5uCAPiJqOHMxK6XA(this));
            r0.put("centerColor", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$u6cDMnH2APm9JPoOagGgs7jayw(this));
            r0.put("centerPoint", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$lOdeli3ZXJ0btevbz44qdaDiFIc(this));
            r0.put("surroundingColor", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$eRo97DXWM9xe7g0c3Ibk5wo9P8(this));
            r0.put("boundaryPath", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$B4B9h6m1z4AsaytBBCcZMRI3kg(this));
            r0.put("boundaryPoints", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$Hx_PucVr1BRUK2npiDXqjiIYI(this));
            r0.put("blendTransform", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$wC3ON3MLxkGSGJWMDNQTRIyNJpA(this));
            r0.put("positions", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$rtI514MVragOMLdYd4729yz91SE(this));
            r0.put("blendColors", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$9IFMj0NUBGLjCJ4k4AEt25OPzNs(this));
            r0.put("blendFactorsH", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$OqtAvzWdV_HKqcEEzjwaEpQ4uU(this));
            r0.put("focusScaleX", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$Df9DoUMj0_yqqLz1kJ_g2jXJJz8(this));
            r0.put("focusScaleY", new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$HHWA_zz5OIoZ1WO5GfS3htTA9gI(this));
            return Collections.unmodifiableMap(r0);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return EmfPlusBrushType.PATH_GRADIENT;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusBrush.EmfPlusBrushData
        public long init(LittleEndianInputStream r10, long r11) {
            this.dataFlags = r10.readInt();
            this.wrapMode = HemfPlusImage.EmfPlusWrapMode.valueOf(r10.readInt());
            this.centerColor = HemfPlusDraw.readARGB(r10.readInt());
            if (this.wrapMode != null) goto L5;
            return 12;
        L5:
            long r12 = ((long) HemfPlusDraw.readPointF(r10, this.centerPoint)) + 12;
            int r2 = r10.readInt();
            this.surroundingColor = new Color[r2];
            int r3 = 0;
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L8;
            this.surroundingColor[r4] = HemfPlusDraw.readARGB(r10.readInt());
            r4 = r4 + 1;
            goto L6
        L8:
            long r13 = r12 + ((((long) r2) + 1) * 4);
            if (PATH.isSet(this.dataFlags) == false) goto L11;
            int r5 = r10.readInt();
            HemfPlusPath.EmfPlusPath r6 = new HemfPlusPath.EmfPlusPath();
            this.boundaryPath = r6;
            long r14 = (r13 + 4) + r6.init(r10, r5, HemfPlusObject.EmfPlusObjectType.PATH, 0);
        L15:
            if (TRANSFORM.isSet(this.dataFlags) == false) goto L17;
            AffineTransform r7 = new AffineTransform();
            this.blendTransform = r7;
            r14 = r14 + ((long) HemfFill.readXForm(r10, r7));
        L17:
            boolean r8 = PRESET_COLORS.isSet(this.dataFlags);
            boolean r9 = BLEND_FACTORS_H.isSet(this.dataFlags);
            if (r8 == false) goto L23;
            if (r9 == false) goto L23;
            throw new RuntimeException("invalid combination of preset colors and blend factors h");
        L23:
            long r15 = 0;
            if (r8 == false) goto L26;
            long r16 = HemfPlusBrush.access$000(r10, new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$tO1wmnrXHBuSx90ju5p7X23pxqE(this), new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$McLQ0agyY5W2QvLLc3BctpET550(this));
        L27:
            long r17 = r14 + r16;
            if (r9 == false) goto L30;
            r15 = HemfPlusBrush.access$100(r10, new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$R7nrN_G_s3fdTuMwOcSu5o0W6s(this), new $$Lambda$HemfPlusBrush$EmfPlusPathGradientBrushData$sI5KwSwko_CTmm9OuLH7vg3P64w(this));
        L30:
            long r18 = r17 + r15;
            if (FOCUS_SCALES.isSet(this.dataFlags) == true) goto L33;
            return r18;
        L33:
            if (r10.readInt() != 2) goto L36;
            this.focusScaleX = Double.valueOf(r10.readFloat());
            this.focusScaleY = Double.valueOf(r10.readFloat());
            return r18 + 12;
        L36:
            throw new RuntimeException("invalid focus scale count");
        L26:
            r16 = 0;
            goto L27
        L11:
            int r19 = r10.readInt();
            r14 = r13 + 4;
            this.boundaryPoints = new Point2D[r19];
        L12:
            if (r3 >= r19) goto L15;
            Point2D[] r20 = this.boundaryPoints;
            Point2D.Double r21 = new Point2D.Double();
            r20[r3] = r21;
            r14 = r14 + ((long) HemfPlusDraw.readPointF(r10, r21));
            r3 = r3 + 1;
            goto L12
        }

        public /* synthetic */ Object lambda$getGenericProperties$10$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.boundaryPoints;
        }

        public /* synthetic */ Object lambda$getGenericProperties$11$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.blendTransform;
        }

        public /* synthetic */ Object lambda$getGenericProperties$12$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.positions;
        }

        public /* synthetic */ Object lambda$getGenericProperties$13$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.blendColors;
        }

        public /* synthetic */ Object lambda$getGenericProperties$14$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.blendFactorsH;
        }

        public /* synthetic */ Object lambda$getGenericProperties$15$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.focusScaleX;
        }

        public /* synthetic */ Object lambda$getGenericProperties$16$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.focusScaleY;
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return Integer.valueOf(this.dataFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.wrapMode;
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.centerColor;
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.centerPoint;
        }

        public /* synthetic */ Object lambda$getGenericProperties$8$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.surroundingColor;
        }

        public /* synthetic */ Object lambda$getGenericProperties$9$HemfPlusBrush$EmfPlusPathGradientBrushData() {
            return this.boundaryPath;
        }

        public /* synthetic */ void lambda$init$0$HemfPlusBrush$EmfPlusPathGradientBrushData(float[] r1) {
            this.positions = r1;
        }

        public /* synthetic */ void lambda$init$1$HemfPlusBrush$EmfPlusPathGradientBrushData(Color[] r1) {
            this.blendColors = r1;
        }

        public /* synthetic */ void lambda$init$2$HemfPlusBrush$EmfPlusPathGradientBrushData(float[] r1) {
            this.positions = r1;
        }

        public /* synthetic */ void lambda$init$3$HemfPlusBrush$EmfPlusPathGradientBrushData(float[] r1) {
            this.blendFactorsH = r1;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusSolidBrushData implements EmfPlusBrushData {
        private Color solidColor;

        public EmfPlusSolidBrushData() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("solidColor", new $$Lambda$HemfPlusBrush$EmfPlusSolidBrushData$wLEU6Ug8W9LBo6B5TjUM8VYmZ5s(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return EmfPlusBrushType.SOLID_COLOR;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusBrush.EmfPlusBrushData
        public long init(LittleEndianInputStream r1, long r2) {
            this.solidColor = HemfPlusDraw.readARGB(r1.readInt());
            return 4;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusBrush$EmfPlusSolidBrushData() {
            return this.solidColor;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusTextureBrushData implements EmfPlusBrushData {
        private AffineTransform brushTransform;
        private int dataFlags;
        private HemfPlusImage.EmfPlusImage image;
        private HemfPlusImage.EmfPlusWrapMode wrapMode;

        public EmfPlusTextureBrushData() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("dataFlags", new $$Lambda$HemfPlusBrush$EmfPlusTextureBrushData$2ifYn5L3tlUBcDatRQVcUdvYfw(this), "wrapMode", new $$Lambda$HemfPlusBrush$EmfPlusTextureBrushData$bqsEHuhfCksHBBW2VPZzGygeVYs(this), "brushTransform", new $$Lambda$HemfPlusBrush$EmfPlusTextureBrushData$aoS5mw8btvl2J3T2_SFRBFdKyA(this), "image", new $$Lambda$HemfPlusBrush$EmfPlusTextureBrushData$7ure1vkxXy0CJVOSmBeFSWuqlE0(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusBrushType getGenericRecordType() {
            return EmfPlusBrushType.TEXTURE_FILL;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusBrush.EmfPlusBrushData
        public long init(LittleEndianInputStream r10, long r11) {
            this.dataFlags = r10.readInt();
            this.wrapMode = HemfPlusImage.EmfPlusWrapMode.valueOf(r10.readInt());
            long r1 = 8;
            if (TRANSFORM.isSet(this.dataFlags) == false) goto L6;
            AffineTransform r0 = new AffineTransform();
            this.brushTransform = r0;
            r1 = 8 + ((long) HemfFill.readXForm(r10, r0));
        L6:
            if (r11 <= r1) goto L9;
            HemfPlusImage.EmfPlusImage r3 = new HemfPlusImage.EmfPlusImage();
            this.image = r3;
            r1 = r1 + r3.init(r10, r11 - r1, HemfPlusObject.EmfPlusObjectType.IMAGE, 0);
        L9:
            return Math.toIntExact(r1);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusBrush$EmfPlusTextureBrushData() {
            return Integer.valueOf(this.dataFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusBrush$EmfPlusTextureBrushData() {
            return this.wrapMode;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusBrush$EmfPlusTextureBrushData() {
            return this.brushTransform;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusBrush$EmfPlusTextureBrushData() {
            return this.image;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public HemfPlusBrush() {
    }

    static /* synthetic */ int access$000(LittleEndianInputStream r2, Consumer r3, Consumer r4) {
        return readColors(r2, (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin"), (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$100(LittleEndianInputStream r2, Consumer r3, Consumer r4) {
        return readFactors(r2, (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin"), (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void lambda$readColors$0(int[] r2, Consumer r3, float[] r4) {
        Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        r2[0] = r4.length;
        r5.accept(r4);
    }

    static /* synthetic */ void lambda$readFactors$1(int[] r2, Consumer r3, float[] r4) {
        Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        r2[0] = r4.length;
        r5.accept(r4);
    }

    private static int readColors(LittleEndianInputStream r4, Consumer<float[]> r5, Consumer<Color[]> r6) {
        final Consumer r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
        Consumer r8 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        final int[] r0 = {0};
        int r9 = readPositions(r4, new $$Lambda$HemfPlusBrush$hqLGJlMlkD3FhqocwUTfLI9J7Cw(r0, r7));
        int r2 = r0[0];
        Color[] r3 = new Color[r2];
    L3:
        if (r1 >= r2) goto L5;
        r3[r1] = HemfPlusDraw.readARGB(r4.readInt());
        r1 = r1 + 1;
        goto L3
    L5:
        r8.accept(r3);
        return r9 + (r2 * 4);
    }

    private static int readFactors(LittleEndianInputStream r4, Consumer<float[]> r5, Consumer<float[]> r6) {
        final Consumer r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
        Consumer r8 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        final int[] r0 = {0};
        int r9 = readPositions(r4, new $$Lambda$HemfPlusBrush$Ak4XF6dcibtjGSGMjYgi5AXXiU(r0, r7));
        int r2 = r0[0];
        float[] r3 = new float[r2];
    L3:
        if (r1 >= r2) goto L5;
        r3[r1] = r4.readFloat();
        r1 = r1 + 1;
        goto L3
    L5:
        r8.accept(r3);
        return r9 + (r2 * 4);
    }

    private static int readPositions(LittleEndianInputStream r5, Consumer<float[]> r6) {
        Consumer r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
        int r0 = r5.readInt();
        float[] r1 = new float[r0];
        int r2 = 4;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r5.readFloat();
        r2 = r2 + 4;
        r3 = r3 + 1;
        goto L3
    L5:
        r7.accept(r1);
        return r2;
    }
}
