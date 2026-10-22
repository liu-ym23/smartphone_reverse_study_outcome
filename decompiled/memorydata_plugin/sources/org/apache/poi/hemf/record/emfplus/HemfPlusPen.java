package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusPen {

    public static abstract class EmfPlusCustomLineCap implements GenericRecord {
        private EmfPlusLineCapType endCap;
        private final Point2D fillHotSpot;
        private EmfPlusLineJoin join;
        private final Point2D lineHotSpot;
        private double miterLimit;
        private EmfPlusLineCapType startCap;
        private double widthScale;

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("startCap", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$Fz_6jvDiF23_ZAvatasAii5v8E(this));
            r0.put("endCap", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$UtxJVs1iSxEMGeabG5e0hgS29E(this));
            r0.put("join", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$EOu4Iuu67YpxjwWOGuOo3yb3tYE(this));
            r0.put("miterLimit", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$xDxYT5YwOVRa8mVqmJaP010oBL8(this));
            r0.put("widthScale", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$14dkAsVSTZ2ySnw_zRXPW8pXtyc(this));
            r0.put("fillHotSpot", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$sLjW1Nwoer8FXrY4iK_6GK0mSso(this));
            r0.put("lineHotSpot", new $$Lambda$HemfPlusPen$EmfPlusCustomLineCap$7v24Ecd58AQSLKpOauOkQ2mX9Q(this));
            return r0;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public final HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.CUSTOM_LINE_CAP;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusPen$EmfPlusCustomLineCap() {
            return this.startCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusPen$EmfPlusCustomLineCap() {
            return this.endCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusPen$EmfPlusCustomLineCap() {
            return this.join;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusPen$EmfPlusCustomLineCap() {
            return Double.valueOf(this.miterLimit);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusPen$EmfPlusCustomLineCap() {
            return Double.valueOf(this.widthScale);
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfPlusPen$EmfPlusCustomLineCap() {
            return this.fillHotSpot;
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfPlusPen$EmfPlusCustomLineCap() {
            return this.lineHotSpot;
        }
    }

    public static final enum EmfPlusDashedLineCapType extends Enum<EmfPlusDashedLineCapType> {
        private static final /* synthetic */ EmfPlusDashedLineCapType[] $VALUES = null;
        public static final EmfPlusDashedLineCapType FLAT = null;
        public static final EmfPlusDashedLineCapType ROUND = null;
        public static final EmfPlusDashedLineCapType TRIANGLE = null;
        public final int id;

        static {
            EmfPlusDashedLineCapType r0 = new EmfPlusDashedLineCapType("FLAT", 0, 0);
            FLAT = r0;
            EmfPlusDashedLineCapType r1 = new EmfPlusDashedLineCapType("ROUND", 1, 2);
            ROUND = r1;
            EmfPlusDashedLineCapType r3 = new EmfPlusDashedLineCapType("TRIANGLE", 2, 3);
            TRIANGLE = r3;
            $VALUES = new EmfPlusDashedLineCapType[]{r0, r1, r3};
        }

        private EmfPlusDashedLineCapType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusDashedLineCapType valueOf(int r5) {
            EmfPlusDashedLineCapType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusDashedLineCapType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusDashedLineCapType valueOf(String r2) {
            return (EmfPlusDashedLineCapType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusDashedLineCapType.class, r2), EmfPlusDashedLineCapType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusDashedLineCapType[] values() {
            return (EmfPlusDashedLineCapType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusDashedLineCapType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusLineCapType extends Enum<EmfPlusLineCapType> {
        private static final /* synthetic */ EmfPlusLineCapType[] $VALUES = null;
        public static final EmfPlusLineCapType ANCHOR_MASK = null;
        public static final EmfPlusLineCapType ARROW_ANCHOR = null;
        public static final EmfPlusLineCapType CUSTOM = null;
        public static final EmfPlusLineCapType DIAMOND_ANCHOR = null;
        public static final EmfPlusLineCapType FLAT = null;
        public static final EmfPlusLineCapType NO_ANCHOR = null;
        public static final EmfPlusLineCapType ROUND = null;
        public static final EmfPlusLineCapType ROUND_ANCHOR = null;
        public static final EmfPlusLineCapType SQUARE = null;
        public static final EmfPlusLineCapType SQUARE_ANCHOR = null;
        public static final EmfPlusLineCapType TRIANGLE = null;
        public final int id;

        static {
            EmfPlusLineCapType r0 = new EmfPlusLineCapType("FLAT", 0, 0);
            FLAT = r0;
            EmfPlusLineCapType r1 = new EmfPlusLineCapType("SQUARE", 1, 1);
            SQUARE = r1;
            EmfPlusLineCapType r3 = new EmfPlusLineCapType("ROUND", 2, 2);
            ROUND = r3;
            EmfPlusLineCapType r5 = new EmfPlusLineCapType("TRIANGLE", 3, 3);
            TRIANGLE = r5;
            EmfPlusLineCapType r7 = new EmfPlusLineCapType("NO_ANCHOR", 4, 16);
            NO_ANCHOR = r7;
            EmfPlusLineCapType r9 = new EmfPlusLineCapType("SQUARE_ANCHOR", 5, 17);
            SQUARE_ANCHOR = r9;
            EmfPlusLineCapType r11 = new EmfPlusLineCapType("ROUND_ANCHOR", 6, 18);
            ROUND_ANCHOR = r11;
            EmfPlusLineCapType r13 = new EmfPlusLineCapType("DIAMOND_ANCHOR", 7, 19);
            DIAMOND_ANCHOR = r13;
            EmfPlusLineCapType r12 = new EmfPlusLineCapType("ARROW_ANCHOR", 8, 20);
            ARROW_ANCHOR = r12;
            EmfPlusLineCapType r10 = new EmfPlusLineCapType("ANCHOR_MASK", 9, 240);
            ANCHOR_MASK = r10;
            EmfPlusLineCapType r8 = new EmfPlusLineCapType("CUSTOM", 10, 255);
            CUSTOM = r8;
            $VALUES = new EmfPlusLineCapType[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8};
        }

        private EmfPlusLineCapType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusLineCapType valueOf(int r5) {
            EmfPlusLineCapType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusLineCapType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusLineCapType valueOf(String r2) {
            return (EmfPlusLineCapType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusLineCapType.class, r2), EmfPlusLineCapType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusLineCapType[] values() {
            return (EmfPlusLineCapType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusLineCapType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusLineJoin extends Enum<EmfPlusLineJoin> {
        private static final /* synthetic */ EmfPlusLineJoin[] $VALUES = null;
        public static final EmfPlusLineJoin BEVEL = null;
        public static final EmfPlusLineJoin MITER = null;
        public static final EmfPlusLineJoin MITER_CLIPPED = null;
        public static final EmfPlusLineJoin ROUND = null;
        public final int id;

        static {
            EmfPlusLineJoin r0 = new EmfPlusLineJoin("MITER", 0, 0);
            MITER = r0;
            EmfPlusLineJoin r1 = new EmfPlusLineJoin("BEVEL", 1, 1);
            BEVEL = r1;
            EmfPlusLineJoin r3 = new EmfPlusLineJoin("ROUND", 2, 2);
            ROUND = r3;
            EmfPlusLineJoin r5 = new EmfPlusLineJoin("MITER_CLIPPED", 3, 3);
            MITER_CLIPPED = r5;
            $VALUES = new EmfPlusLineJoin[]{r0, r1, r3, r5};
        }

        private EmfPlusLineJoin(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusLineJoin valueOf(int r5) {
            EmfPlusLineJoin[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusLineJoin r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusLineJoin valueOf(String r2) {
            return (EmfPlusLineJoin) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusLineJoin.class, r2), EmfPlusLineJoin.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusLineJoin[] values() {
            return (EmfPlusLineJoin[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusLineJoin[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EmfPlusLineStyle extends Enum<EmfPlusLineStyle> {
        private static final /* synthetic */ EmfPlusLineStyle[] $VALUES = null;
        public static final EmfPlusLineStyle CUSTOM = null;
        public static final EmfPlusLineStyle DASH = null;
        public static final EmfPlusLineStyle DASH_DOT = null;
        public static final EmfPlusLineStyle DASH_DOT_DOT = null;
        public static final EmfPlusLineStyle DOT = null;
        public static final EmfPlusLineStyle SOLID = null;
        public final int id;

        static {
            EmfPlusLineStyle r0 = new EmfPlusLineStyle("SOLID", 0, 0);
            SOLID = r0;
            EmfPlusLineStyle r1 = new EmfPlusLineStyle("DASH", 1, 1);
            DASH = r1;
            EmfPlusLineStyle r3 = new EmfPlusLineStyle("DOT", 2, 2);
            DOT = r3;
            EmfPlusLineStyle r5 = new EmfPlusLineStyle("DASH_DOT", 3, 3);
            DASH_DOT = r5;
            EmfPlusLineStyle r7 = new EmfPlusLineStyle("DASH_DOT_DOT", 4, 4);
            DASH_DOT_DOT = r7;
            EmfPlusLineStyle r9 = new EmfPlusLineStyle("CUSTOM", 5, 5);
            CUSTOM = r9;
            $VALUES = new EmfPlusLineStyle[]{r0, r1, r3, r5, r7, r9};
        }

        private EmfPlusLineStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusLineStyle valueOf(int r5) {
            EmfPlusLineStyle[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusLineStyle r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusLineStyle valueOf(String r2) {
            return (EmfPlusLineStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusLineStyle.class, r2), EmfPlusLineStyle.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusLineStyle[] values() {
            return (EmfPlusLineStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusLineStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusPen implements HemfPlusObject.EmfPlusObjectData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BitField COMPOUND_LINE = null;
        private static final BitField CUSTOM_END_CAP = null;
        private static final BitField CUSTOM_START_CAP = null;
        private static final BitField DASHED_LINE = null;
        private static final BitField DASHED_LINE_CAP = null;
        private static final BitField DASHED_LINE_OFFSET = null;
        private static final BitField END_CAP = null;
        private static final int[] FLAGS_MASKS = null;
        private static final String[] FLAGS_NAMES = null;
        private static final BitField JOIN = null;
        private static final BitField LINE_STYLE = null;
        private static final BitField MITER_LIMIT = null;
        private static final BitField NON_CENTER = null;
        private static final BitField START_CAP = null;
        private static final BitField TRANSFORM = null;
        private final HemfPlusBrush.EmfPlusBrush brush;
        private double[] compoundLineData;
        private EmfPlusCustomLineCap customEndCap;
        private EmfPlusCustomLineCap customStartCap;
        private Double dashOffset;
        private EmfPlusDashedLineCapType dashedLineCapType;
        private float[] dashedLineData;
        private EmfPlusLineCapType endCap;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private EmfPlusLineJoin lineJoin;
        private Double miterLimit;
        private EmfPlusPenAlignment penAlignment;
        private int penDataFlags;
        private double penWidth;
        private EmfPlusLineCapType startCap;
        private EmfPlusLineStyle style;
        private final AffineTransform trans;
        private int type;
        private HemfPlusDraw.EmfPlusUnitType unitType;

        static {
            TRANSFORM = BitFieldFactory.getInstance(1);
            START_CAP = BitFieldFactory.getInstance(2);
            END_CAP = BitFieldFactory.getInstance(4);
            JOIN = BitFieldFactory.getInstance(8);
            MITER_LIMIT = BitFieldFactory.getInstance(16);
            LINE_STYLE = BitFieldFactory.getInstance(32);
            DASHED_LINE_CAP = BitFieldFactory.getInstance(64);
            DASHED_LINE_OFFSET = BitFieldFactory.getInstance(128);
            DASHED_LINE = BitFieldFactory.getInstance(256);
            NON_CENTER = BitFieldFactory.getInstance(512);
            COMPOUND_LINE = BitFieldFactory.getInstance(1024);
            CUSTOM_START_CAP = BitFieldFactory.getInstance(2048);
            CUSTOM_END_CAP = BitFieldFactory.getInstance(4096);
            FLAGS_MASKS = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
            FLAGS_NAMES = new String[]{"TRANSFORM", "START_CAP", "END_CAP", "JOIN", "MITER_LIMIT", "LINE_STYLE", "DASHED_LINE_CAP", "DASHED_LINE_OFFSET", "DASHED_LINE", "NON_CENTER", "COMPOUND_LINE", "CUSTOM_START_CAP", "CUSTOM_END_CAP"};
        }

        public EmfPlusPen() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
            this.trans = new AffineTransform();
            EmfPlusLineCapType r0 = EmfPlusLineCapType.FLAT;
            this.startCap = r0;
            this.endCap = r0;
            this.lineJoin = EmfPlusLineJoin.ROUND;
            this.miterLimit = Double.valueOf(1.0d);
            this.style = EmfPlusLineStyle.SOLID;
            this.brush = new HemfPlusBrush.EmfPlusBrush();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("type", new $$Lambda$HemfPlusPen$EmfPlusPen$SYim4fiCoubRDlMSADmgfnLEmo(this));
            r0.put("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$HemfPlusPen$EmfPlusPen$1E6agySQA7JPItbZzxVkMSqRVEs(this), FLAGS_MASKS, FLAGS_NAMES));
            r0.put("unitType", new $$Lambda$HemfPlusPen$EmfPlusPen$kOT_T0dyhtIrEmHAGwGo7twue8(this));
            r0.put("penWidth", new $$Lambda$HemfPlusPen$EmfPlusPen$rsQqcqHmKsKOXHNXOVIzlBYErUg(this));
            r0.put("trans", new $$Lambda$HemfPlusPen$EmfPlusPen$tbeDK1bOLSIx70DUTmL7OYAp3E(this));
            r0.put("startCap", new $$Lambda$HemfPlusPen$EmfPlusPen$JSCc4aVX9EcrxdZaDzbUTWnZY4(this));
            r0.put("endCap", new $$Lambda$HemfPlusPen$EmfPlusPen$HUOTaBKkVJManjI8iF8fC6_bwdo(this));
            r0.put("join", new $$Lambda$HemfPlusPen$EmfPlusPen$0XsKOJSi1E3lWrBW5TCPif1XN2E(this));
            r0.put("miterLimit", new $$Lambda$HemfPlusPen$EmfPlusPen$UoAQRFZVoJTeefz199lntSX7e1k(this));
            r0.put("style", new $$Lambda$HemfPlusPen$EmfPlusPen$93U0QZcz89J11qvCVCQnPH4pMo(this));
            r0.put("dashedLineCapType", new $$Lambda$HemfPlusPen$EmfPlusPen$JJCLTe3TZiD3VvF6hM7WasRLC5Y(this));
            r0.put("dashOffset", new $$Lambda$HemfPlusPen$EmfPlusPen$ijgF_MC5t_EkhHOvtbSyyzf97dM(this));
            r0.put("dashedLineData", new $$Lambda$HemfPlusPen$EmfPlusPen$FJ9izgf_5BM7XqpfxphlkKHb3qo(this));
            r0.put("penAlignment", new $$Lambda$HemfPlusPen$EmfPlusPen$nN8PUc5x08K8vAFaJvWzcBGI0A(this));
            r0.put("compoundLineData", new $$Lambda$HemfPlusPen$EmfPlusPen$KI376BOZNSyyKHOyJtG3VXt2RY(this));
            r0.put("customStartCap", new $$Lambda$HemfPlusPen$EmfPlusPen$7nHF0XH9Q3NtpxhmUf2L_G6CbM(this));
            r0.put("customEndCap", new $$Lambda$HemfPlusPen$EmfPlusPen$RnBB9VQb4SfY_hhn1yKIo1ZtPDQ(this));
            r0.put("brush", new $$Lambda$HemfPlusPen$EmfPlusPen$u_3CSqD1DWSF0rAHuDVT0omzHXo(this));
            return Collections.unmodifiableMap(r0);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.PEN;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$10$HemfPlusPen$EmfPlusPen() {
            return this.miterLimit;
        }

        public /* synthetic */ Object lambda$getGenericProperties$11$HemfPlusPen$EmfPlusPen() {
            return this.style;
        }

        public /* synthetic */ Object lambda$getGenericProperties$12$HemfPlusPen$EmfPlusPen() {
            return this.dashedLineCapType;
        }

        public /* synthetic */ Object lambda$getGenericProperties$13$HemfPlusPen$EmfPlusPen() {
            return this.dashOffset;
        }

        public /* synthetic */ Object lambda$getGenericProperties$14$HemfPlusPen$EmfPlusPen() {
            return this.dashedLineData;
        }

        public /* synthetic */ Object lambda$getGenericProperties$15$HemfPlusPen$EmfPlusPen() {
            return this.penAlignment;
        }

        public /* synthetic */ Object lambda$getGenericProperties$16$HemfPlusPen$EmfPlusPen() {
            return this.compoundLineData;
        }

        public /* synthetic */ Object lambda$getGenericProperties$17$HemfPlusPen$EmfPlusPen() {
            return this.customStartCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$18$HemfPlusPen$EmfPlusPen() {
            return this.customEndCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$19$HemfPlusPen$EmfPlusPen() {
            return this.brush;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusPen$EmfPlusPen() {
            return Integer.valueOf(this.type);
        }

        public /* synthetic */ Number lambda$getGenericProperties$3$HemfPlusPen$EmfPlusPen() {
            return Integer.valueOf(this.penDataFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusPen$EmfPlusPen() {
            return this.unitType;
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfPlusPen$EmfPlusPen() {
            return Double.valueOf(this.penWidth);
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfPlusPen$EmfPlusPen() {
            return this.trans;
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HemfPlusPen$EmfPlusPen() {
            return this.startCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$8$HemfPlusPen$EmfPlusPen() {
            return this.endCap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$9$HemfPlusPen$EmfPlusPen() {
            return this.lineJoin;
        }
    }

    public static final enum EmfPlusPenAlignment extends Enum<EmfPlusPenAlignment> {
        private static final /* synthetic */ EmfPlusPenAlignment[] $VALUES = null;
        public static final EmfPlusPenAlignment CENTER = null;
        public static final EmfPlusPenAlignment INSET = null;
        public static final EmfPlusPenAlignment LEFT = null;
        public static final EmfPlusPenAlignment OUTSET = null;
        public static final EmfPlusPenAlignment RIGHT = null;
        public final int id;

        static {
            EmfPlusPenAlignment r0 = new EmfPlusPenAlignment("CENTER", 0, 0);
            CENTER = r0;
            EmfPlusPenAlignment r1 = new EmfPlusPenAlignment("INSET", 1, 1);
            INSET = r1;
            EmfPlusPenAlignment r3 = new EmfPlusPenAlignment("LEFT", 2, 2);
            LEFT = r3;
            EmfPlusPenAlignment r5 = new EmfPlusPenAlignment("OUTSET", 3, 3);
            OUTSET = r5;
            EmfPlusPenAlignment r7 = new EmfPlusPenAlignment("RIGHT", 4, 4);
            RIGHT = r7;
            $VALUES = new EmfPlusPenAlignment[]{r0, r1, r3, r5, r7};
        }

        private EmfPlusPenAlignment(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusPenAlignment valueOf(int r5) {
            EmfPlusPenAlignment[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusPenAlignment r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusPenAlignment valueOf(String r2) {
            return (EmfPlusPenAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusPenAlignment.class, r2), EmfPlusPenAlignment.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusPenAlignment[] values() {
            return (EmfPlusPenAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusPenAlignment[].class, "com.obric.memorydata.plugin");
        }
    }

    public HemfPlusPen() {
    }
}
