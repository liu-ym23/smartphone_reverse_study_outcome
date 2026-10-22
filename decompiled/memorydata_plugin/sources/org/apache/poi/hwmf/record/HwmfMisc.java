package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Dimension2D;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfMisc {

    public static class WmfCreateBrushIndirect implements HwmfRecord {
        protected HwmfHatchStyle brushHatch;
        protected HwmfBrushStyle brushStyle;
        protected HwmfColorRef colorRef;

        public WmfCreateBrushIndirect() {
        }

        public HwmfHatchStyle getBrushHatch() {
            return this.brushHatch;
        }

        public HwmfBrushStyle getBrushStyle() {
            return this.brushStyle;
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("brushStyle", new $$Lambda$CtUbHCKUZLNZ6C6nHTDDiw2mFOg(this), "colorRef", new $$Lambda$RHRW7wNXBZbNuBNHvpfD5P87Kc(this), "brushHatch", new $$Lambda$BOKx3AhUeXRapZHVeCUgw4SJI0I(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createBrushIndirect;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfCreatePatternBrush implements HwmfRecord {
        private HwmfBitmap16 pattern;

        public WmfCreatePatternBrush() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(XSDatatype.FACET_PATTERN, new $$Lambda$nmyxtWEv02dThVeyWxw48ZD5c(this));
        }

        public HwmfBitmap16 getPattern() {
            return this.pattern;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createPatternBrush;
        }
    }

    public static class WmfCreatePenIndirect implements HwmfRecord {
        protected final HwmfColorRef colorRef;
        protected final Dimension2D dimension;
        protected HwmfPenStyle penStyle;

        public WmfCreatePenIndirect() {
            this.dimension = new Dimension2DDouble();
            this.colorRef = new HwmfColorRef();
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        public Dimension2D getDimension() {
            return this.dimension;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("penStyle", new $$Lambda$oRselAuTTaiLv0LtCUf_htxbDx0(this), TypedValues.Custom.S_DIMENSION, new $$Lambda$g00_tqYED4av0XO57pW_oDlNKr8(this), "colorRef", new $$Lambda$qGaLMydl14qtXaZKtXALG6tgnM(this));
        }

        public HwmfPenStyle getPenStyle() {
            return this.penStyle;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createPenIndirect;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfDeleteObject implements HwmfRecord {
        protected int objectIndex;

        public WmfDeleteObject() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("objectIndex", new $$Lambda$_DhtPH9Sd38d3lxIIjogKYr_j3E(this));
        }

        public int getObjectIndex() {
            return this.objectIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.deleteObject;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfDibCreatePatternBrush implements HwmfRecord {
        protected HwmfFill.ColorUsage colorUsage;
        private HwmfBitmap16 pattern16;
        protected HwmfBitmapDib patternDib;
        protected HwmfBrushStyle style;

        public WmfDibCreatePatternBrush() {
        }

        public byte[] getBMPData() {
            HwmfBitmapDib r0 = this.patternDib;
            if (r0 != null) goto L5;
        L8:
            HwmfBitmap16 r1 = this.pattern16;
            return null;
        L5:
            if (r0.isValid() == false) goto L8;
            return this.patternDib.getBMPData();
        }

        public HwmfFill.ColorUsage getColorUsage() {
            return this.colorUsage;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("style", new $$Lambda$81BY_ke9z5T3BzqhyPMEV0HT7o(this), "colorUsage", new $$Lambda$C50AAa7gpXPreqwb0HoDQcRUbWY(this), XSDatatype.FACET_PATTERN, new $$Lambda$HwmfMisc$WmfDibCreatePatternBrush$n7HW2Qbi7hT78F1OB7YFRrXtGI(this), "bmpData", new $$Lambda$aVxR_1M7DH_PyHn25pn3yF3qFw(this));
        }

        public HwmfBrushStyle getStyle() {
            return this.style;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.dibCreatePatternBrush;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfMisc$WmfDibCreatePatternBrush() {
            HwmfBitmapDib r0 = this.patternDib;
            if (r0 == null) goto L8;
            if (r0.isValid() == false) goto L8;
            return this.patternDib;
        L8:
            return this.pattern16;
        }
    }

    public static class WmfRestoreDc implements HwmfRecord {
        protected int nSavedDC;

        public WmfRestoreDc() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("nSavedDC", new $$Lambda$pVsUT34MOdSzSjhi58A5MZJ4WE(this));
        }

        public int getNSavedDC() {
            return this.nSavedDC;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.restoreDc;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSaveDc implements HwmfRecord {
        public WmfSaveDc() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.saveDc;
        }

        public String toString() {
            return "{}";
        }
    }

    public static class WmfSetBkColor implements HwmfRecord {
        protected final HwmfColorRef colorRef;

        public WmfSetBkColor() {
            this.colorRef = new HwmfColorRef();
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("colorRef", new $$Lambda$xjc1n1i3gCPUiNWVpAV7vLgoVs(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setBkColor;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetBkMode implements HwmfRecord {
        protected HwmfBkMode bkMode;

        public static final enum HwmfBkMode extends Enum<HwmfBkMode> {
            private static final /* synthetic */ HwmfBkMode[] $VALUES = null;
            public static final HwmfBkMode OPAQUE = null;
            public static final HwmfBkMode TRANSPARENT = null;
            final int flag;

            static {
                HwmfBkMode r0 = new HwmfBkMode("TRANSPARENT", 0, 1);
                TRANSPARENT = r0;
                HwmfBkMode r1 = new HwmfBkMode("OPAQUE", 1, 2);
                OPAQUE = r1;
                $VALUES = new HwmfBkMode[]{r0, r1};
            }

            private HwmfBkMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.flag = r3;
            }

            public static HwmfBkMode valueOf(int r5) {
                HwmfBkMode[] r0 = values();
                int r1 = r0.length;
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L8;
                HwmfBkMode r3 = r0[r2];
                if (r3.flag == r5) goto L6;
                r2 = r2 + 1;
                goto L3
            L6:
                return r3;
            L8:
                return null;
            }

            public static HwmfBkMode valueOf(String r2) {
                return (HwmfBkMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfBkMode.class, r2), HwmfBkMode.class, "com.obric.memorydata.plugin");
            }

            public static HwmfBkMode[] values() {
                return (HwmfBkMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfBkMode[].class, "com.obric.memorydata.plugin");
            }
        }

        public WmfSetBkMode() {
        }

        public HwmfBkMode getBkMode() {
            return this.bkMode;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bkMode", new $$Lambda$IKHJKcbIsagVN07e_cuB0MBSPts(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setBkMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetLayout implements HwmfRecord {
        private int layout;

        public WmfSetLayout() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("layout", new $$Lambda$HwmfMisc$WmfSetLayout$OgOTzQuEiXWoqeoIkGtZa7eKE(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setLayout;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfMisc$WmfSetLayout() {
            return Integer.valueOf(this.layout);
        }
    }

    public static class WmfSetMapMode implements HwmfRecord {
        protected HwmfMapMode mapMode;

        public WmfSetMapMode() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("mapMode", new $$Lambda$NeQRPSd57Dx6hpyviMUaSeRiaZE(this));
        }

        public HwmfMapMode getMapMode() {
            return this.mapMode;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setMapMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetMapperFlags implements HwmfRecord {
        private long mapperValues;

        public WmfSetMapperFlags() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("mapperValues", new $$Lambda$HwmfMisc$WmfSetMapperFlags$ixfLsOsVokoMcMjBGem4Q_sjU4E(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setMapperFlags;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfMisc$WmfSetMapperFlags() {
            return Long.valueOf(this.mapperValues);
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetRelabs implements HwmfRecord {
        public WmfSetRelabs() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setRelabs;
        }
    }

    public static class WmfSetRop2 implements HwmfRecord {
        protected HwmfBinaryRasterOp drawMode;

        public WmfSetRop2() {
        }

        public HwmfBinaryRasterOp getDrawMode() {
            return this.drawMode;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("drawMode", new $$Lambda$5A7rFan8gO9Irjs0fKWvv896Zao(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setRop2;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetStretchBltMode implements HwmfRecord {
        protected StretchBltMode stretchBltMode;

        public static final enum StretchBltMode extends Enum<StretchBltMode> {
            private static final /* synthetic */ StretchBltMode[] $VALUES = null;
            public static final StretchBltMode BLACKONWHITE = null;
            public static final StretchBltMode COLORONCOLOR = null;
            public static final StretchBltMode HALFTONE = null;
            public static final StretchBltMode WHITEONBLACK = null;
            public final int flag;

            static {
                StretchBltMode r0 = new StretchBltMode("BLACKONWHITE", 0, 1);
                BLACKONWHITE = r0;
                StretchBltMode r1 = new StretchBltMode("WHITEONBLACK", 1, 2);
                WHITEONBLACK = r1;
                StretchBltMode r4 = new StretchBltMode("COLORONCOLOR", 2, 3);
                COLORONCOLOR = r4;
                StretchBltMode r6 = new StretchBltMode("HALFTONE", 3, 4);
                HALFTONE = r6;
                $VALUES = new StretchBltMode[]{r0, r1, r4, r6};
            }

            private StretchBltMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.flag = r3;
            }

            public static StretchBltMode valueOf(int r5) {
                StretchBltMode[] r0 = values();
                int r1 = r0.length;
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L8;
                StretchBltMode r3 = r0[r2];
                if (r3.flag == r5) goto L6;
                r2 = r2 + 1;
                goto L3
            L6:
                return r3;
            L8:
                return null;
            }

            public static StretchBltMode valueOf(String r2) {
                return (StretchBltMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(StretchBltMode.class, r2), StretchBltMode.class, "com.obric.memorydata.plugin");
            }

            public static StretchBltMode[] values() {
                return (StretchBltMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StretchBltMode[].class, "com.obric.memorydata.plugin");
            }
        }

        public WmfSetStretchBltMode() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("stretchBltMode", new $$Lambda$KxQ8_LG949SqUOnDz6_54ZmH1E(this));
        }

        public StretchBltMode getStretchBltMode() {
            return this.stretchBltMode;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setStretchBltMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }
}
