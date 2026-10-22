package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Arc2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.draw.HwmfGraphics;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HwmfDraw {

    /* JADX INFO: renamed from: org.apache.poi.hwmf.record.HwmfDraw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$draw$HwmfGraphics$FillDrawStyle = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$hwmf$record$HwmfRecordType = null;

        static {
            int[] r0 = new int[HwmfRecordType.values().length];
            $SwitchMap$org$apache$poi$hwmf$record$HwmfRecordType = r0;
            r0[HwmfRecordType.arc.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfRecordType[HwmfRecordType.chord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$org$apache$poi$hwmf$record$HwmfRecordType[HwmfRecordType.pie.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[HwmfGraphics.FillDrawStyle.values().length];
            $SwitchMap$org$apache$poi$hwmf$draw$HwmfGraphics$FillDrawStyle = r3;
            r3[HwmfGraphics.FillDrawStyle.DRAW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$org$apache$poi$hwmf$draw$HwmfGraphics$FillDrawStyle[HwmfGraphics.FillDrawStyle.FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$org$apache$poi$hwmf$draw$HwmfGraphics$FillDrawStyle[HwmfGraphics.FillDrawStyle.FILL_DRAW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static class WmfArc implements HwmfRecord {
        protected final Rectangle2D bounds;
        protected final Point2D endPoint;
        protected final Point2D startPoint;

        public static final enum WmfArcClosure extends Enum<WmfArcClosure> {
            private static final /* synthetic */ WmfArcClosure[] $VALUES = null;
            public static final WmfArcClosure ARC = null;
            public static final WmfArcClosure CHORD = null;
            public static final WmfArcClosure PIE = null;
            public final int awtType;
            public final HwmfGraphics.FillDrawStyle drawStyle;
            public final HwmfRecordType recordType;

            static {
                WmfArcClosure r6 = new WmfArcClosure("ARC", 0, HwmfRecordType.arc, 0, HwmfGraphics.FillDrawStyle.DRAW);
                ARC = r6;
                WmfArcClosure r0 = new WmfArcClosure("CHORD", 1, HwmfRecordType.chord, 1, HwmfGraphics.FillDrawStyle.FILL_DRAW);
                CHORD = r0;
                WmfArcClosure r1 = new WmfArcClosure("PIE", 2, HwmfRecordType.pie, 2, HwmfGraphics.FillDrawStyle.FILL_DRAW);
                PIE = r1;
                $VALUES = new WmfArcClosure[]{r6, r0, r1};
            }

            private WmfArcClosure(String r1, int r2, HwmfRecordType r3, int r4, HwmfGraphics.FillDrawStyle r5) {
                super(r1, r2);
                this.recordType = r3;
                this.awtType = r4;
                this.drawStyle = r5;
            }

            public static WmfArcClosure valueOf(String r2) {
                return (WmfArcClosure) ZeusTransformUtils.preCheckCast(Enum.valueOf(WmfArcClosure.class, r2), WmfArcClosure.class, "com.obric.memorydata.plugin");
            }

            public static WmfArcClosure[] values() {
                return (WmfArcClosure[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WmfArcClosure[].class, "com.obric.memorydata.plugin");
            }
        }

        public WmfArc() {
            this.startPoint = new Point2D.Double();
            this.endPoint = new Point2D.Double();
            this.bounds = new Rectangle2D.Double();
        }

        public static /* synthetic */ double lambda$7TOodIXpg5gvLah0HI4_N14kAtI(Arc2D r2) {
            return r2.getAngleStart();
        }

        /* JADX INFO: renamed from: lambda$odUJrOC8r2OTVt6B_BnffIBtv-A, reason: not valid java name */
        public static /* synthetic */ double m3168lambda$odUJrOC8r2OTVt6B_BnffIBtvA(Arc2D r2) {
            return r2.getAngleExtent();
        }

        public WmfArcClosure getArcClosure() {
            int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$hwmf$record$HwmfRecordType[getWmfRecordType().ordinal()];
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L9;
            return WmfArcClosure.ARC;
        L9:
            return WmfArcClosure.PIE;
        L11:
            return WmfArcClosure.CHORD;
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        public Point2D getEndPoint() {
            return this.endPoint;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            final Arc2D r0 = getShape();
            Supplier r2 = new $$Lambda$ZpC5vGTyrPVniHHiwo6Dh20y8(this);
            Supplier r4 = new $$Lambda$QiH10ctlC7IjpZSNIfKHqTDeHmI(this);
            r0.getClass();
            Supplier r6 = new $$Lambda$HwmfDraw$WmfArc$7TOodIXpg5gvLah0HI4_N14kAtI(r0);
            r0.getClass();
            return GenericRecordUtil.getGenericProperties("startPoint", r2, "endPoint", r4, "startAngle", r6, "extentAngle", new $$Lambda$HwmfDraw$WmfArc$odUJrOC8r2OTVt6B_BnffIBtvA(r0), "bounds", new $$Lambda$AzWu2EKMSJrvsX5CSrDgH0f7Dg(this));
        }

        public Arc2D getShape() {
            double r1 = Math.toDegrees(Math.atan2(-(this.startPoint.getY() - this.bounds.getCenterY()), this.startPoint.getX() - this.bounds.getCenterX()));
            double r3 = Math.toDegrees(Math.atan2(-(this.endPoint.getY() - this.bounds.getCenterY()), this.endPoint.getX() - this.bounds.getCenterX())) - r1;
            if (r3 <= 0.0d) goto L5;
            int r7 = 0;
        L6:
            double r20 = r3 + ((double) r7);
            if (r1 >= 0.0d) goto L9;
            r1 = r1 + 360.0d;
        L9:
            double r10 = this.bounds.getX();
            double r12 = this.bounds.getY();
            double r14 = this.bounds.getWidth();
            double r16 = this.bounds.getHeight();
            return new Arc2D.Double(r10, r12, r14, r16, r1, r20, getArcClosure().awtType);
        L5:
            r7 = 360;
            goto L6
        }

        public Point2D getStartPoint() {
            return this.startPoint;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.arc;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfChord extends WmfArc {
        public WmfChord() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfArc, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.chord;
        }
    }

    public static class WmfEllipse implements HwmfRecord {
        protected final Rectangle2D bounds;

        public WmfEllipse() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$J3eR9lnvDP9gZeRsF8ci8T7zbNY(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.ellipse;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfFrameRegion implements HwmfRecord {
        protected int brushIndex;
        protected final Dimension2D frame;
        protected int regionIndex;

        public WmfFrameRegion() {
            this.frame = new Dimension2DDouble();
        }

        public int getBrushIndex() {
            return this.brushIndex;
        }

        public Dimension2D getFrame() {
            return this.frame;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionIndex", new $$Lambda$pCLdgoxTb6muGmAwPF5EEjAgUy8(this), "brushIndex", new $$Lambda$FRdCDE9Id4S1kDiVKDSK7hHDwo0(this), TypedValues.AttributesType.S_FRAME, new $$Lambda$kM_aiPFY1amBcgwzzSvLQEmWKU(this));
        }

        public int getRegionIndex() {
            return this.regionIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.frameRegion;
        }
    }

    public static class WmfLineTo implements HwmfRecord {
        protected final Point2D point;

        public WmfLineTo() {
            this.point = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("point", new $$Lambda$SkXeb7FxC3it4oBvIroi1sseLBE(this));
        }

        public Point2D getPoint() {
            return this.point;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.lineTo;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfMoveTo implements HwmfRecord {
        protected final Point2D point;

        public WmfMoveTo() {
            this.point = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("point", new $$Lambda$Ezc5hTdJb_X2Ucw6kG_mjscWWRI(this));
        }

        public Point2D getPoint() {
            return this.point;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.moveTo;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfPie extends WmfArc {
        public WmfPie() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfArc, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.pie;
        }
    }

    public static class WmfPolyPolygon implements HwmfRecord {
        protected final List<Path2D> polyList;

        public WmfPolyPolygon() {
            this.polyList = new ArrayList();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("polyList", new $$Lambda$JgFhIr5orJD0C2FccULdlCaIQVs(this));
        }

        public List<Path2D> getPolyList() {
            return this.polyList;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.polyPolygon;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfPolygon implements HwmfRecord {
        protected Path2D poly;

        public WmfPolygon() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("poly", new $$Lambda$8q4Yy1JuVoysTL9pOYnnCM7Le0(this));
        }

        public Path2D getPoly() {
            return this.poly;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.polygon;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfPolyline extends WmfPolygon {
        public WmfPolyline() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfPolygon, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.polyline;
        }
    }

    public static class WmfRectangle implements HwmfRecord {
        protected final Rectangle2D bounds;

        public WmfRectangle() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$ErlI8d09GxI0FI0cpvazZ6OksgQ(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.rectangle;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfRoundRect implements HwmfRecord {
        protected final Rectangle2D bounds;
        protected final Dimension2D corners;

        public WmfRoundRect() {
            this.corners = new Dimension2DDouble();
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        public Dimension2D getCorners() {
            return this.corners;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$dRkVgrSFZvMzbA92NEvY0_DYLmE(this), "corners", new $$Lambda$wAFrfzA87Mv2TdGkNqB6e3SCPVI(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.roundRect;
        }
    }

    public static class WmfSelectObject implements HwmfRecord {
        protected int objectIndex;

        public WmfSelectObject() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("objectIndex", new $$Lambda$tzlR6ykePPYdn9yGoJDBGtpG57g(this));
        }

        public int getObjectIndex() {
            return this.objectIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.selectObject;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetPixel implements HwmfRecord {
        protected final HwmfColorRef colorRef;
        protected final Point2D point;

        public WmfSetPixel() {
            this.colorRef = new HwmfColorRef();
            this.point = new Point2D.Double();
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("colorRef", new $$Lambda$H0N07mk22zUMkT2jrumMnSiLUKw(this), "point", new $$Lambda$XTniEVP2VqS8jS5nJKtLp1xJweA(this));
        }

        public Point2D getPoint() {
            return this.point;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setPixel;
        }
    }
}
