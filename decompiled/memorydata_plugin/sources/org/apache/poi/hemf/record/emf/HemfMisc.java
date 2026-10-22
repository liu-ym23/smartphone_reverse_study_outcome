package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfBitmapDib;
import org.apache.poi.hwmf.record.HwmfBrushStyle;
import org.apache.poi.hwmf.record.HwmfFill;
import org.apache.poi.hwmf.record.HwmfHatchStyle;
import org.apache.poi.hwmf.record.HwmfMisc;
import org.apache.poi.hwmf.record.HwmfPalette;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfMisc {

    public static class EmfCreateBrushIndirect extends HwmfMisc.WmfCreateBrushIndirect implements HemfRecord {
        private int brushIdx;

        public EmfCreateBrushIndirect() {
        }

        public int getBrushIdx() {
            return this.brushIdx;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.createBrushIndirect;
        }

        @Override // org.apache.poi.hwmf.record.HwmfMisc.WmfCreateBrushIndirect, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfMisc$EmfCreateBrushIndirect$L0sXkNxBFxHU1n3hzRmb3M3WR8(this), "brushIdx", new $$Lambda$qC0_9qlnPwMapej7VkbVGtCJnQ8(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfMisc$EmfCreateBrushIndirect() {
            return super.getGenericProperties();
        }

        @Override // org.apache.poi.hwmf.record.HwmfMisc.WmfCreateBrushIndirect
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfCreateDibPatternBrushPt extends HwmfMisc.WmfDibCreatePatternBrush implements HemfRecord {
        protected int brushIdx;

        public EmfCreateDibPatternBrushPt() {
        }

        public int getBrushIdx() {
            return this.brushIdx;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.createDibPatternBrushPt;
        }

        @Override // org.apache.poi.hwmf.record.HwmfMisc.WmfDibCreatePatternBrush, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfMisc$EmfCreateDibPatternBrushPt$GIBi2DzQAGaUjzLeVa_XGHsRbQw(this), "brushIdx", new $$Lambda$MWR1SsL_F9uLZBMwznlN1eHyrp4(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfMisc$EmfCreateDibPatternBrushPt() {
            return super.getGenericProperties();
        }
    }

    public static class EmfCreateMonoBrush implements HemfRecord {
        protected final HwmfBitmapDib bitmap;
        protected HwmfFill.ColorUsage colorUsage;
        protected int penIndex;

        public EmfCreateMonoBrush() {
            this.bitmap = new HwmfBitmapDib();
        }

        public HwmfBitmapDib getBitmap() {
            return this.bitmap;
        }

        public HwmfFill.ColorUsage getColorUsage() {
            return this.colorUsage;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.createMonoBrush;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("penIndex", new $$Lambda$DbF5Gy8ZFKlN4up_NcWHqEfCB5Q(this), "colorUsage", new $$Lambda$ts8yHA__mPLcAz7sBvnGN8pXYhI(this), "bitmap", new $$Lambda$HeiKQe3WLJYgIz5rm7wuePIu71M(this));
        }

        public int getPenIndex() {
            return this.penIndex;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfCreatePen extends HwmfMisc.WmfCreatePenIndirect implements HemfRecord {
        protected int penIndex;

        public EmfCreatePen() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.createPen;
        }

        @Override // org.apache.poi.hwmf.record.HwmfMisc.WmfCreatePenIndirect, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfMisc$EmfCreatePen$6kq11Zo3mtJQRVLJ4Q4WTYyqcWQ(this), "penIndex", new $$Lambda$SN_yRn_vOzWN2CPjNn3bhkVW5wc(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public int getPenIndex() {
            return this.penIndex;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfMisc$EmfCreatePen() {
            return super.getGenericProperties();
        }

        @Override // org.apache.poi.hwmf.record.HwmfMisc.WmfCreatePenIndirect
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfDeleteObject extends HwmfMisc.WmfDeleteObject implements HemfRecord {
        public EmfDeleteObject() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.deleteobject;
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

    public static class EmfEof implements HemfRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final List<HwmfPalette.PaletteEntry> palette;

        static {
        }

        public EmfEof() {
            this.palette = new ArrayList();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.eof;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("palette", new $$Lambda$JKVVvHmaIPVEY_PjiWhriaT08UU(this));
        }

        public List<HwmfPalette.PaletteEntry> getPalette() {
            return this.palette;
        }
    }

    public static class EmfExtCreatePen extends EmfCreatePen {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected final HwmfBitmapDib bitmap;
        protected HwmfBrushStyle brushStyle;
        protected HwmfHatchStyle hatchStyle;

        static {
        }

        public EmfExtCreatePen() {
            this.bitmap = new HwmfBitmapDib();
        }

        public HwmfBitmapDib getBitmap() {
            return this.bitmap;
        }

        public HwmfBrushStyle getBrushStyle() {
            return this.brushStyle;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfMisc.EmfCreatePen, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extCreatePen;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfMisc.EmfCreatePen, org.apache.poi.hwmf.record.HwmfMisc.WmfCreatePenIndirect, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfMisc$EmfExtCreatePen$RQvHuUnHDkFdm6RuNNOuMing3M(this), "brushStyle", new $$Lambda$sNTZlEwkKyMiOtpxQHV_aPQgxV8(this), "hatchStyle", new $$Lambda$nCqoeRqW_5H466xhIlY4gGJq7I(this), "bitmap", new $$Lambda$IuNCr64a7XPYUS7JXrvTTCOqiDc(this));
        }

        @Override // org.apache.poi.hemf.record.emf.HemfMisc.EmfCreatePen, org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfMisc.EmfCreatePen, org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public HwmfHatchStyle getHatchStyle() {
            return this.hatchStyle;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfMisc$EmfExtCreatePen() {
            return super.getGenericProperties();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfMisc.EmfCreatePen, org.apache.poi.hwmf.record.HwmfMisc.WmfCreatePenIndirect
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfModifyWorldTransform implements HemfRecord {
        protected HemfModifyWorldTransformMode modifyWorldTransformMode;
        protected final AffineTransform xForm;

        public EmfModifyWorldTransform() {
            this.xForm = new AffineTransform();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.modifyWorldTransform;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("xForm", new $$Lambda$cr_tF1dQUjFBkfKiul2l6uV6RPM(this), "modifyWorldTransformMode", new $$Lambda$DGSFsD9qX7tBTDWTHewJD4ivCgM(this));
        }

        public HemfModifyWorldTransformMode getModifyWorldTransformMode() {
            return this.modifyWorldTransformMode;
        }

        public AffineTransform getXForm() {
            return this.xForm;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfRestoreDc extends HwmfMisc.WmfRestoreDc implements HemfRecord {
        public EmfRestoreDc() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.restoreDc;
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

    public static class EmfSaveDc extends HwmfMisc.WmfSaveDc implements HemfRecordWithoutProperties {
        public EmfSaveDc() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.saveDc;
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

    public static class EmfSetBkColor extends HwmfMisc.WmfSetBkColor implements HemfRecord {
        public EmfSetBkColor() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setBkColor;
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

    public static class EmfSetBkMode extends HwmfMisc.WmfSetBkMode implements HemfRecord {
        public EmfSetBkMode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setBkMode;
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

    public static class EmfSetBrushOrgEx implements HemfRecord {
        protected final Point2D origin;

        public EmfSetBrushOrgEx() {
            this.origin = new Point2D.Double();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setBrushOrgEx;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("origin", new $$Lambda$l8iTDiTeoHlu3VQCSYeB7wLsoL8(this));
        }

        public Point2D getOrigin() {
            return this.origin;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfSetMapMode extends HwmfMisc.WmfSetMapMode implements HemfRecord {
        public EmfSetMapMode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setMapMode;
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

    public static class EmfSetMapperFlags extends HwmfMisc.WmfSetMapperFlags implements HemfRecord {
        public EmfSetMapperFlags() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setMapperFlags;
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

    public static class EmfSetMiterLimit implements HemfRecord {
        protected int miterLimit;

        public EmfSetMiterLimit() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setMiterLimit;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("miterLimit", new $$Lambda$gLD2nYyMfqGC0flNwHFFbGdGM(this));
        }

        public int getMiterLimit() {
            return this.miterLimit;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfSetRop2 extends HwmfMisc.WmfSetRop2 implements HemfRecord {
        public EmfSetRop2() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setRop2;
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

    public static class EmfSetStretchBltMode extends HwmfMisc.WmfSetStretchBltMode implements HemfRecord {
        public EmfSetStretchBltMode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setStretchBltMode;
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

    public static class EmfSetWorldTransform implements HemfRecord {
        protected final AffineTransform xForm;

        public EmfSetWorldTransform() {
            this.xForm = new AffineTransform();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setWorldTransform;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("xForm", new $$Lambda$K6fRzJdpiwpIe9hwpTJDecBTTg(this));
        }

        public AffineTransform getXForm() {
            return this.xForm;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static final enum HemfModifyWorldTransformMode extends Enum<HemfModifyWorldTransformMode> {
        private static final /* synthetic */ HemfModifyWorldTransformMode[] $VALUES = null;
        public static final HemfModifyWorldTransformMode MWT_IDENTITY = null;
        public static final HemfModifyWorldTransformMode MWT_LEFTMULTIPLY = null;
        public static final HemfModifyWorldTransformMode MWT_RIGHTMULTIPLY = null;
        public static final HemfModifyWorldTransformMode MWT_SET = null;
        public final int id;

        static {
            HemfModifyWorldTransformMode r0 = new HemfModifyWorldTransformMode("MWT_IDENTITY", 0, 1);
            MWT_IDENTITY = r0;
            HemfModifyWorldTransformMode r1 = new HemfModifyWorldTransformMode("MWT_LEFTMULTIPLY", 1, 2);
            MWT_LEFTMULTIPLY = r1;
            HemfModifyWorldTransformMode r4 = new HemfModifyWorldTransformMode("MWT_RIGHTMULTIPLY", 2, 3);
            MWT_RIGHTMULTIPLY = r4;
            HemfModifyWorldTransformMode r6 = new HemfModifyWorldTransformMode("MWT_SET", 3, 4);
            MWT_SET = r6;
            $VALUES = new HemfModifyWorldTransformMode[]{r0, r1, r4, r6};
        }

        private HemfModifyWorldTransformMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static HemfModifyWorldTransformMode valueOf(int r5) {
            HemfModifyWorldTransformMode[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            HemfModifyWorldTransformMode r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static HemfModifyWorldTransformMode valueOf(String r2) {
            return (HemfModifyWorldTransformMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HemfModifyWorldTransformMode.class, r2), HemfModifyWorldTransformMode.class, "com.obric.memorydata.plugin");
        }

        public static HemfModifyWorldTransformMode[] values() {
            return (HemfModifyWorldTransformMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HemfModifyWorldTransformMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public HemfMisc() {
    }
}
