package org.apache.poi.hemf.record.emfplus;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class HemfPlusDraw {

    public interface EmfPlusCompressed {
        public static final BitField COMPRESSED = null;

        static {
            COMPRESSED = BitFieldFactory.getInstance(16384);
        }

        int getFlags();

        default boolean isCompressed() {
            return COMPRESSED.isSet(getFlags());
        }
    }

    public static class EmfPlusDrawDriverString implements EmfPlusSolidColor, HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        private static final BitField CMAP_LOOKUP = null;
        private static final BitField LIMIT_SUBPIXEL = null;
        private static final int[] OPTIONS_MASK = null;
        private static final String[] OPTIONS_NAMES = null;
        private static final BitField REALIZED_ADVANCE = null;
        private static final BitField VERTICAL = null;
        private int brushId;
        private int flags;
        private final List<Point2D> glyphPos;
        private String glyphs;
        private int optionsFlags;
        private final AffineTransform transformMatrix;

        static {
            CMAP_LOOKUP = BitFieldFactory.getInstance(1);
            VERTICAL = BitFieldFactory.getInstance(2);
            REALIZED_ADVANCE = BitFieldFactory.getInstance(4);
            LIMIT_SUBPIXEL = BitFieldFactory.getInstance(8);
            OPTIONS_MASK = new int[]{1, 2, 4, 8};
            OPTIONS_NAMES = new String[]{"CMAP_LOOKUP", "VERTICAL", "REALIZED_ADVANCE", "LIMIT_SUBPIXEL"};
        }

        public EmfPlusDrawDriverString() {
            this.glyphPos = new ArrayList();
            this.transformMatrix = new AffineTransform();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusSolidColor
        public int getBrushIdValue() {
            return this.brushId;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.drawDriverString;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusSolidColor, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$tn_0lBCYxJxmlBU7v8hcAG58cAw(this), "brushId", new $$Lambda$9GV3sxBwGnslV9__ERjNXzYhHlQ(this), "optionsFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$HemfPlusDraw$EmfPlusDrawDriverString$lZgxWMi3MmpOKrHQc8xUSD0wUFM(this), OPTIONS_MASK, OPTIONS_NAMES), "glyphs", new $$Lambda$HemfPlusDraw$EmfPlusDrawDriverString$OGnezrkJBpnLg3o_WQDXe8ntiO0(this), "glyphPos", new $$Lambda$HemfPlusDraw$EmfPlusDrawDriverString$9DZN8iLBD0LZLBlVzoMQZdwMv_w(this), "transform", new $$Lambda$HemfPlusDraw$EmfPlusDrawDriverString$9cBIMMNMCbbbw2ZJECVBMUq5wkI(this));
        }

        public /* synthetic */ Number lambda$getGenericProperties$1$HemfPlusDraw$EmfPlusDrawDriverString() {
            return Integer.valueOf(this.optionsFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusDraw$EmfPlusDrawDriverString() {
            return this.glyphs;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusDraw$EmfPlusDrawDriverString() {
            return this.glyphPos;
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusDraw$EmfPlusDrawDriverString() {
            return this.transformMatrix;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusDrawImage implements EmfPlusCompressed, HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int flags;
        private int imageAttributesID;
        private final Rectangle2D rectData;
        private final Rectangle2D srcRect;
        private EmfPlusUnitType srcUnit;

        static {
        }

        public EmfPlusDrawImage() {
            this.srcRect = new Rectangle2D.Double();
            this.rectData = new Rectangle2D.Double();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.drawImage;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusCompressed, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$8VfOoMRICHGXyDW0LJfQndLfyAY(this), "imageAttributesID", new $$Lambda$HemfPlusDraw$EmfPlusDrawImage$cHweIjPx2Pc8_X98Hofm__GtTMc(this), "srcUnit", new $$Lambda$HemfPlusDraw$EmfPlusDrawImage$SrAAlZMU3OIEZecxF8_SvpLEKhU(this), "srcRect", new $$Lambda$HemfPlusDraw$EmfPlusDrawImage$eFeiZRtxGBFH61GPCy8IsWa8NE(this), "rectData", new $$Lambda$HemfPlusDraw$EmfPlusDrawImage$Ph6h1pEKfy_wWfgQ20ML7Dw514(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusDraw$EmfPlusDrawImage() {
            return Integer.valueOf(this.imageAttributesID);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusDraw$EmfPlusDrawImage() {
            return this.srcUnit;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusDraw$EmfPlusDrawImage() {
            return this.srcRect;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusDraw$EmfPlusDrawImage() {
            return this.rectData;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusDrawImagePoints implements EmfPlusCompressed, EmfPlusRelativePosition, HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BitField EFFECT = null;
        private int flags;
        private int imageAttributesID;
        private final Point2D lowerLeft;
        private final Point2D lowerRight;
        private final Rectangle2D srcRect;
        private EmfPlusUnitType srcUnit;
        private final AffineTransform trans;
        private final Point2D upperLeft;

        static {
            EFFECT = BitFieldFactory.getInstance(8192);
        }

        public EmfPlusDrawImagePoints() {
            this.srcRect = new Rectangle2D.Double();
            this.upperLeft = new Point2D.Double();
            this.lowerRight = new Point2D.Double();
            this.lowerLeft = new Point2D.Double();
            this.trans = new AffineTransform();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.drawImagePoints;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusCompressed, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("flags", new $$Lambda$KMQOA5wcbHFYnle1tSJWNFEVPE(this));
            r0.put("imageAttributesID", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$0J7Oy1iKj0A70xn_1F_8Thyb2FU(this));
            r0.put("srcUnit", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$EhRAbVYcmS3YURQIAfLdoVjAlAE(this));
            r0.put("srcRect", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$HVTmMcXXqyI2e8GrrLR0pmAYKoU(this));
            r0.put("upperLeft", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$GeG2XZXuqge8kOcRTSRaFuW4S0(this));
            r0.put("lowerLeft", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$YXRler1MBOj3IO84LZWIIGWmUp8(this));
            r0.put("lowerRight", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$F380gtRys1PkG9j0m0tw72tJuDU(this));
            r0.put("transform", new $$Lambda$HemfPlusDraw$EmfPlusDrawImagePoints$tG9xcTSfdRHKGIxqgoIIUitv1rI(this));
            return Collections.unmodifiableMap(r0);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return Integer.valueOf(this.imageAttributesID);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.srcUnit;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.srcRect;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.upperLeft;
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.lowerLeft;
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.lowerRight;
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfPlusDraw$EmfPlusDrawImagePoints() {
            return this.trans;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusDrawPath implements HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int flags;
        private int penId;

        static {
        }

        public EmfPlusDrawPath() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.drawPath;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$TjyXXIkqCH6AE0NPo5lCXrlI4s(this), "penId", new $$Lambda$3nPcOgD8fUIF82b6ltRLzQJXdDk(this));
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusRecordType getGenericRecordType() {
            return getEmfPlusRecordType();
        }

        public int getPenId() {
            return this.penId;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusDrawRects implements EmfPlusCompressed, HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        private int flags;
        private final List<Rectangle2D> rectData;

        public EmfPlusDrawRects() {
            this.rectData = new ArrayList();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.drawRects;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusCompressed, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$sVG9WqWztuZWFQbCEMfRff21L8(this), "rectData", new $$Lambda$HemfPlusDraw$EmfPlusDrawRects$O2KTKQSnFvz1q8TU0ERvbC7m5_k(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusDraw$EmfPlusDrawRects() {
            return this.rectData;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusFillPath extends EmfPlusFillRegion {
        public EmfPlusFillPath() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusFillRegion, org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.fillPath;
        }
    }

    public static class EmfPlusFillRects implements EmfPlusCompressed, EmfPlusSolidColor, HemfPlusRecord {
        private int brushId;
        private int flags;
        private final ArrayList<Rectangle2D> rectData;

        public EmfPlusFillRects() {
            this.rectData = new ArrayList();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusSolidColor
        public int getBrushIdValue() {
            return this.brushId;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.fillRects;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusCompressed, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$OZznzfbJAE26r7EToh_3dAfQk(this), "brushId", new $$Lambda$loso65_1l49CtXQMwD8UJqIAnKM(this), "brushColor", new $$Lambda$3LgaVzbRQ7paZkZ2bMWMd6PpOc(this), "rectData", new $$Lambda$LnXB5BWKdwT5dmZbx0Qpy8X2jB4(this));
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusRecordType getGenericRecordType() {
            return getEmfPlusRecordType();
        }

        public List<Rectangle2D> getRectData() {
            return this.rectData;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfPlusFillRegion implements EmfPlusSolidColor, HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        private int brushId;
        private int flags;

        public EmfPlusFillRegion() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusSolidColor
        public int getBrushIdValue() {
            return this.brushId;
        }

        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.fillRegion;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusDraw.EmfPlusSolidColor, org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$qbacsDk1dLSOfzmHvATLCVXFyFw(this), "brushId", new $$Lambda$HemfPlusDraw$EmfPlusFillRegion$E3uRsEn0zQtC_J5NZ7I1pH8LHs(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusDraw$EmfPlusFillRegion() {
            return Integer.valueOf(this.brushId);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public interface EmfPlusRelativePosition {
        public static final BitField POSITION = null;

        static {
            POSITION = BitFieldFactory.getInstance(2048);
        }

        int getFlags();

        default boolean isRelativePosition() {
            return POSITION.isSet(getFlags());
        }
    }

    public interface EmfPlusSolidColor {
        public static final BitField SOLID_COLOR = null;

        static {
            SOLID_COLOR = BitFieldFactory.getInstance(32768);
        }

        default int getBrushId() {
            if (isSolidColor() == false) goto L6;
            return -1;
        L6:
            return getBrushIdValue();
        }

        int getBrushIdValue();

        int getFlags();

        default Color getSolidColor() {
            if (isSolidColor() == true) goto L7;
            return null;
        L7:
            return HemfPlusDraw.readARGB(getBrushIdValue());
        }

        default boolean isSolidColor() {
            return SOLID_COLOR.isSet(getFlags());
        }
    }

    public static final enum EmfPlusUnitType extends Enum<EmfPlusUnitType> {
        private static final /* synthetic */ EmfPlusUnitType[] $VALUES = null;
        public static final EmfPlusUnitType Display = null;
        public static final EmfPlusUnitType Document = null;
        public static final EmfPlusUnitType Inch = null;
        public static final EmfPlusUnitType Millimeter = null;
        public static final EmfPlusUnitType Pixel = null;
        public static final EmfPlusUnitType Point = null;
        public static final EmfPlusUnitType World = null;
        public final int id;

        static {
            EmfPlusUnitType r0 = new EmfPlusUnitType("World", 0, 0);
            World = r0;
            EmfPlusUnitType r1 = new EmfPlusUnitType("Display", 1, 1);
            Display = r1;
            EmfPlusUnitType r3 = new EmfPlusUnitType("Pixel", 2, 2);
            Pixel = r3;
            EmfPlusUnitType r5 = new EmfPlusUnitType("Point", 3, 3);
            Point = r5;
            EmfPlusUnitType r7 = new EmfPlusUnitType("Inch", 4, 4);
            Inch = r7;
            EmfPlusUnitType r9 = new EmfPlusUnitType(i.f16175a, 5, 5);
            Document = r9;
            EmfPlusUnitType r11 = new EmfPlusUnitType("Millimeter", 6, 6);
            Millimeter = r11;
            $VALUES = new EmfPlusUnitType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private EmfPlusUnitType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfPlusUnitType valueOf(int r5) {
            EmfPlusUnitType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusUnitType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusUnitType valueOf(String r2) {
            return (EmfPlusUnitType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusUnitType.class, r2), EmfPlusUnitType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusUnitType[] values() {
            return (EmfPlusUnitType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusUnitType[].class, "com.obric.memorydata.plugin");
        }
    }

    private HemfPlusDraw() {
    }

    static Color readARGB(int r4) {
        return new Color((r4 >>> 16) & 255, (r4 >>> 8) & 255, r4 & 255, (r4 >>> 24) & 255);
    }

    private static int readEmfPlusInteger(LittleEndianInputStream r2, int[] r3) {
        r3[0] = r2.readByte();
        if ((r3[0] & 128) != 0) goto L6;
        return 1;
    L6:
        int r0 = r3[0] << 8;
        r3[0] = ((r2.readByte() & 255) | r0) & 32767;
        return 2;
    }

    static int readPointF(LittleEndianInputStream r4, Point2D r5) {
        ((Point2D) ZeusTransformUtils.wrapperContextForParams(r5, Point2D.class, "com.obric.memorydata.plugin")).setLocation(r4.readFloat(), r4.readFloat());
        return 8;
    }

    static int readPointR(LittleEndianInputStream r5, Point2D r6) {
        Point2D r7 = (Point2D) ZeusTransformUtils.wrapperContextForParams(r6, Point2D.class, "com.obric.memorydata.plugin");
        int[] r0 = {0};
        int r2 = readEmfPlusInteger(r5, r0);
        double r3 = r0[0];
        int r4 = r2 + readEmfPlusInteger(r5, r0);
        r7.setLocation(r3, r0[0]);
        return r4;
    }

    static int readPointS(LittleEndianInputStream r4, Point2D r5) {
        ((Point2D) ZeusTransformUtils.wrapperContextForParams(r5, Point2D.class, "com.obric.memorydata.plugin")).setLocation(r4.readShort(), r4.readShort());
        return 4;
    }

    static int readRectF(LittleEndianInputStream r9, Rectangle2D r10) {
        ((Rectangle2D) ZeusTransformUtils.wrapperContextForParams(r10, Rectangle2D.class, "com.obric.memorydata.plugin")).setRect(r9.readFloat(), r9.readFloat(), r9.readFloat(), r9.readFloat());
        return 16;
    }
}
