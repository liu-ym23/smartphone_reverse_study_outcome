package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusPath {

    public static class EmfPlusPath implements HemfPlusDraw.EmfPlusCompressed, HemfPlusDraw.EmfPlusRelativePosition, HemfPlusObject.EmfPlusObjectData {
        private static final int[] FLAGS_MASKS = null;
        private static final String[] FLAGS_NAMES = null;
        private static final BitField POINT_RLE_BEZIER = null;
        private static final BitField POINT_RLE_COUNT = null;
        private static final BitField POINT_TYPE_CLOSE = null;
        private static final BitField POINT_TYPE_DASHED = null;
        private static final BitField POINT_TYPE_ENUM = null;
        private static final BitField POINT_TYPE_MARKER = null;
        private static final BitField RLE_COMPRESSED = null;
        private static final int[] TYPE_MASKS = null;
        private static final String[] TYPE_NAMES = null;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private Point2D[] pathPoints;
        private int pointFlags;
        private byte[] pointTypes;

        static {
            RLE_COMPRESSED = BitFieldFactory.getInstance(4096);
            POINT_TYPE_DASHED = BitFieldFactory.getInstance(16);
            POINT_TYPE_MARKER = BitFieldFactory.getInstance(32);
            POINT_TYPE_CLOSE = BitFieldFactory.getInstance(128);
            POINT_TYPE_ENUM = BitFieldFactory.getInstance(15);
            POINT_RLE_BEZIER = BitFieldFactory.getInstance(128);
            POINT_RLE_COUNT = BitFieldFactory.getInstance(63);
            FLAGS_MASKS = new int[]{2048, 4096, 16384};
            FLAGS_NAMES = new String[]{"RELATIVE_POSITION", "RLE_COMPRESSED", "FORMAT_COMPRESSED"};
            TYPE_MASKS = new int[]{16, 32, 128};
            TYPE_NAMES = new String[]{"DASHED", "MARKER", "CLOSE"};
        }

        public EmfPlusPath() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        private GenericRecord getGenericPoint(final int r2) {
            return new $$Lambda$HemfPlusPath$EmfPlusPath$JV7qJMKDG5hAeVeYY1WlPWrc7M4(this, r2);
        }

        private List<GenericRecord> getGenericPoints() {
            return (List) ZeusTransformUtils.preCheckCast(IntStream.range(0, this.pathPoints.length).mapToObj(new $$Lambda$HemfPlusPath$EmfPlusPath$Hdw4VDUbGP3bG6a2EMuTsrKbB9o(this)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ GenericRecord lambda$Hdw4VDUbGP3bG6a2EMuTsrKbB9o(EmfPlusPath r0, int r1) {
            return r0.getGenericPoint(r1);
        }

        public static /* synthetic */ List lambda$pJUUzuyHWlLC4AUlgagVJg2Ds4A(EmfPlusPath r0) {
            return r0.getGenericPoints();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusCompressed, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.pointFlags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$PSY01l21rtyNinHEhtJzN6DKbeM(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$GMnM4w5IKcHgGWP8TYPiXmbbeqI(this), FLAGS_MASKS, FLAGS_NAMES), "points", new $$Lambda$HemfPlusPath$EmfPlusPath$pJUUzuyHWlLC4AUlgagVJg2Ds4A(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Enum getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.PATH;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public Point2D getPoint(int r1) {
            return this.pathPoints[r1];
        }

        public EmfPlusPathPointType getPointType(int r3) {
            return EmfPlusPathPointType.values()[POINT_TYPE_ENUM.getValue(this.pointTypes[r3])];
        }

        public long init(LittleEndianInputStream r6, long r7, HemfPlusObject.EmfPlusObjectType r9, int r10) {
            long r8 = this.graphicsVersion.init(r6);
            int r11 = r6.readInt();
            this.pointFlags = r6.readShort();
            r6.skipFully(2);
            long r12 = r8 + 8;
            if (isRelativePosition() == false) goto L6;
            BiFunction r13 = $$Lambda$4XV14rd1JBAhYLfNaCDE86cM.INSTANCE;
        L9:
            this.pathPoints = new Point2D[r11];
            int r0 = 0;
            int r1 = 0;
        L10:
            if (r1 >= r11) goto L12;
            this.pathPoints[r1] = new Point2D.Double();
            r12 = r12 + ((long) ((Integer) ZeusTransformUtils.preCheckCast(r13.apply(r6, this.pathPoints[r1]), Integer.class, "com.obric.memorydata.plugin")).intValue());
            r1 = r1 + 1;
            goto L10
        L12:
            this.pointTypes = new byte[r11];
            if (RLE_COMPRESSED.isSet(this.pointFlags) == false) goto L16;
        L14:
            if (r0 >= r11) goto L17;
            int r14 = POINT_RLE_COUNT.getValue(r6.readByte());
            Arrays.fill(this.pointTypes, r11, r11 + r14, r6.readByte());
            r0 = r0 + r14;
            r12 = r12 + 2;
        L17:
            int r5 = (int) ((4 - (r12 % 4)) % 4);
            r6.skipFully(r5);
            return r12 + ((long) r5);
        L16:
            r6.readFully(this.pointTypes);
            r12 = r12 + ((long) r11);
            goto L17
        L6:
            if (isCompressed() == false) goto L8;
            r13 = $$Lambda$9B410zWZInJtVhb0QyxChiWBHHY.INSTANCE;
            goto L9
        L8:
            r13 = $$Lambda$9abQMOoQOQJPQeNPxRHzfRye13M.INSTANCE;
            goto L9
        }

        public /* synthetic */ Map lambda$getGenericPoint$3$HemfPlusPath$EmfPlusPath(final int r10) {
            return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$HemfPlusPath$EmfPlusPath$kBuFtRCuNBYiSd9jxIfgYAYG2Q(this, r10), TYPE_MASKS, TYPE_NAMES), "type", new $$Lambda$HemfPlusPath$EmfPlusPath$VW4_DZqdhAz1CfjlgmNSKXHl8qc(this, r10), "point", new $$Lambda$HemfPlusPath$EmfPlusPath$6SXOoxamx0zgD_uaBqxXT3jqPFA(this, r10));
        }

        public /* synthetic */ Number lambda$null$0$HemfPlusPath$EmfPlusPath(int r1) {
            return Byte.valueOf(this.pointTypes[r1]);
        }

        public /* synthetic */ Object lambda$null$1$HemfPlusPath$EmfPlusPath(int r1) {
            return getPointType(r1);
        }

        public /* synthetic */ Object lambda$null$2$HemfPlusPath$EmfPlusPath(int r1) {
            return getPoint(r1);
        }
    }

    public static final enum EmfPlusPathPointType extends Enum<EmfPlusPathPointType> {
        private static final /* synthetic */ EmfPlusPathPointType[] $VALUES = null;
        public static final EmfPlusPathPointType BEZIER = null;
        public static final EmfPlusPathPointType LINE = null;
        public static final EmfPlusPathPointType START = null;
        public static final EmfPlusPathPointType UNUSED = null;

        static {
            EmfPlusPathPointType r0 = new EmfPlusPathPointType("START", 0);
            START = r0;
            EmfPlusPathPointType r1 = new EmfPlusPathPointType("LINE", 1);
            LINE = r1;
            EmfPlusPathPointType r3 = new EmfPlusPathPointType("UNUSED", 2);
            UNUSED = r3;
            EmfPlusPathPointType r5 = new EmfPlusPathPointType("BEZIER", 3);
            BEZIER = r5;
            $VALUES = new EmfPlusPathPointType[]{r0, r1, r3, r5};
        }

        private EmfPlusPathPointType(String r1, int r2) {
            super(r1, r2);
        }

        public static EmfPlusPathPointType valueOf(String r2) {
            return (EmfPlusPathPointType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusPathPointType.class, r2), EmfPlusPathPointType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusPathPointType[] values() {
            return (EmfPlusPathPointType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusPathPointType[].class, "com.obric.memorydata.plugin");
        }
    }
}
