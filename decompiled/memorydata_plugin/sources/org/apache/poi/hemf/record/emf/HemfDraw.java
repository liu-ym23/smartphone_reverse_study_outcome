package org.apache.poi.hemf.record.emf;

import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import org.apache.poi.hwmf.record.HwmfDraw;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HemfDraw {

    public static class EmfAbortPath implements HemfRecordWithoutProperties {
        public EmfAbortPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.abortPath;
        }

        public String toString() {
            return "{}";
        }
    }

    public static class EmfArc extends HwmfDraw.WmfArc implements HemfRecord {
        public EmfArc() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.arc;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfArcTo extends HwmfDraw.WmfArc implements HemfRecord {
        public EmfArcTo() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.arcTo;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfBeginPath implements HemfRecordWithoutProperties {
        public EmfBeginPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.beginPath;
        }

        public String toString() {
            return "{}";
        }
    }

    public static class EmfChord extends HwmfDraw.WmfChord implements HemfRecord {
        public EmfChord() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.chord;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfCloseFigure implements HemfRecordWithoutProperties {
        public EmfCloseFigure() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.closeFigure;
        }

        public String toString() {
            return "{}";
        }
    }

    public static class EmfEllipse extends HwmfDraw.WmfEllipse implements HemfRecord {
        public EmfEllipse() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.ellipse;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfEndPath implements HemfRecordWithoutProperties {
        public EmfEndPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.endPath;
        }

        public String toString() {
            return "{}";
        }
    }

    public static class EmfFillPath extends EmfStrokePath {
        public EmfFillPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfStrokePath, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.fillPath;
        }
    }

    public static class EmfFlattenPath implements HemfRecordWithoutProperties {
        public EmfFlattenPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.flattenPath;
        }
    }

    public static class EmfLineTo extends HwmfDraw.WmfLineTo implements HemfRecord {
        public EmfLineTo() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.lineTo;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfPie extends HwmfDraw.WmfPie implements HemfRecord {
        public EmfPie() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.pie;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfPolyBezier extends HwmfDraw.WmfPolygon implements HemfRecord {
        private final Rectangle2D bounds;

        public EmfPolyBezier() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyBezier;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfPolygon, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfDraw$EmfPolyBezier$WguLy5R7Tc3fn7Zwb7TPYHbJ3fg(this), "bounds", new $$Lambda$QyjkZWBNCBRAHbsENfIhKHNE56M(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfDraw$EmfPolyBezier() {
            return super.getGenericProperties();
        }
    }

    public static class EmfPolyBezier16 extends EmfPolyBezier {
        public EmfPolyBezier16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyBezier, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyBezier16;
        }
    }

    public static class EmfPolyBezierTo extends EmfPolyBezier {
        public EmfPolyBezierTo() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyBezier, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyBezierTo;
        }
    }

    public static class EmfPolyBezierTo16 extends EmfPolyBezierTo {
        public EmfPolyBezierTo16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyBezierTo, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyBezier, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyBezierTo16;
        }
    }

    public static class EmfPolyDraw extends HwmfDraw.WmfPolygon implements HemfRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Rectangle2D bounds;

        static {
        }

        public EmfPolyDraw() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyDraw;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfPolygon, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfDraw$EmfPolyDraw$0eI_a68yWw_pXPVGVbGzF3ph52w(this), "bounds", new $$Lambda$6fmLjo_4TApafUzk8_mUXcx_dLU(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfDraw$EmfPolyDraw() {
            return super.getGenericProperties();
        }
    }

    public static class EmfPolyDraw16 extends EmfPolyDraw {
        public EmfPolyDraw16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyDraw, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyDraw16;
        }
    }

    public static class EmfPolyPolygon extends HwmfDraw.WmfPolyPolygon implements HemfRecord {
        private final Rectangle2D bounds;

        public EmfPolyPolygon() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyPolygon;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfPolyPolygon, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfDraw$EmfPolyPolygon$uNdbG_2CxON448iofmFzbeG2z0(this), "bounds", new $$Lambda$DFnZyVPtexzxF2aNcKdLR0yjgjQ(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfDraw$EmfPolyPolygon() {
            return super.getGenericProperties();
        }
    }

    public static class EmfPolyPolygon16 extends EmfPolyPolygon {
        public EmfPolyPolygon16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyPolygon16;
        }
    }

    public static class EmfPolyPolyline extends EmfPolyPolygon {
        public EmfPolyPolyline() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyPolyline;
        }
    }

    public static class EmfPolyPolyline16 extends EmfPolyPolyline {
        public EmfPolyPolyline16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyPolyline, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyPolyline16;
        }
    }

    public static class EmfPolygon extends HwmfDraw.WmfPolygon implements HemfRecord {
        private final Rectangle2D bounds;

        public EmfPolygon() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polygon;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfPolygon, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfDraw$EmfPolygon$VQkR9LWLkq1HMKXl80gceufzzXM(this), "bounds", new $$Lambda$ZXVYuqkh4caBgC1KHVubn9TUESw(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfDraw$EmfPolygon() {
            return super.getGenericProperties();
        }
    }

    public static class EmfPolygon16 extends EmfPolygon {
        public EmfPolygon16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polygon16;
        }
    }

    public static class EmfPolyline extends EmfPolygon {
        public EmfPolyline() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyline;
        }
    }

    public static class EmfPolyline16 extends EmfPolyline {
        public EmfPolyline16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyline, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polyline16;
        }
    }

    public static class EmfPolylineTo extends EmfPolyline {
        public EmfPolylineTo() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyline, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polylineTo;
        }
    }

    public static class EmfPolylineTo16 extends EmfPolylineTo {
        public EmfPolylineTo16() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfPolylineTo, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolyline, org.apache.poi.hemf.record.emf.HemfDraw.EmfPolygon, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.polylineTo16;
        }
    }

    public static class EmfRectangle extends HwmfDraw.WmfRectangle implements HemfRecord {
        public EmfRectangle() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.rectangle;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfRoundRect extends HwmfDraw.WmfRoundRect implements HemfRecord {
        public EmfRoundRect() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.roundRect;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfSelectObject extends HwmfDraw.WmfSelectObject implements HemfRecord {
        private static final int[] IDX_MASKS = null;
        private static final String[] IDX_NAMES = null;

        static {
            IDX_MASKS = IntStream.rangeClosed(Integer.MIN_VALUE, -2147483629).toArray();
            IDX_NAMES = new String[]{"WHITE_BRUSH", "LTGRAY_BRUSH", "GRAY_BRUSH", "DKGRAY_BRUSH", "BLACK_BRUSH", "NULL_BRUSH", "WHITE_PEN", "BLACK_PEN", "NULL_PEN", "INVALID", "OEM_FIXED_FONT", "ANSI_FIXED_FONT", "ANSI_VAR_FONT", "SYSTEM_FONT", "DEVICE_DEFAULT_FONT", "DEFAULT_PALETTE", "SYSTEM_FIXED_FONT", "DEFAULT_GUI_FONT", "DC_BRUSH", "DC_PEN"};
        }

        public EmfSelectObject() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.selectObject;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfSelectObject, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("objectIndex", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$ka_ggaq2UOxX1FvGTzrDKFKKq6U(this), IDX_MASKS, IDX_NAMES));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfSelectObject
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfSetMoveToEx extends HwmfDraw.WmfMoveTo implements HemfRecord {
        public EmfSetMoveToEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setMoveToEx;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfSetPixelV extends HwmfDraw.WmfSetPixel implements HemfRecord {
        public EmfSetPixelV() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setPixelV;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }
    }

    public static class EmfStrokeAndFillPath extends EmfStrokePath {
        public EmfStrokeAndFillPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfDraw.EmfStrokePath, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.strokeAndFillPath;
        }
    }

    public static class EmfStrokePath implements HemfRecord {
        protected final Rectangle2D bounds;

        public EmfStrokePath() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.strokePath;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$i4j7Oib3ZNrdzX8JXJAjp2nsXbc(this));
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfWidenPath implements HemfRecordWithoutProperties {
        public EmfWidenPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.widenPath;
        }

        public String toString() {
            return "{}";
        }
    }

    private HemfDraw() {
    }
}
