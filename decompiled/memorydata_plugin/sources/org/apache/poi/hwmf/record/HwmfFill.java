package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfFill {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static final enum ColorUsage extends Enum<ColorUsage> {
        private static final /* synthetic */ ColorUsage[] $VALUES = null;
        public static final ColorUsage DIB_PAL_COLORS = null;
        public static final ColorUsage DIB_PAL_INDICES = null;
        public static final ColorUsage DIB_RGB_COLORS = null;
        public final int flag;

        static {
            ColorUsage r0 = new ColorUsage("DIB_RGB_COLORS", 0, 0);
            DIB_RGB_COLORS = r0;
            ColorUsage r1 = new ColorUsage("DIB_PAL_COLORS", 1, 1);
            DIB_PAL_COLORS = r1;
            ColorUsage r3 = new ColorUsage("DIB_PAL_INDICES", 2, 2);
            DIB_PAL_INDICES = r3;
            $VALUES = new ColorUsage[]{r0, r1, r3};
        }

        private ColorUsage(String r1, int r2, int r3) {
            super(r1, r2);
            this.flag = r3;
        }

        public static ColorUsage valueOf(int r5) {
            ColorUsage[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ColorUsage r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static ColorUsage valueOf(String r2) {
            return (ColorUsage) ZeusTransformUtils.preCheckCast(Enum.valueOf(ColorUsage.class, r2), ColorUsage.class, "com.obric.memorydata.plugin");
        }

        public static ColorUsage[] values() {
            return (ColorUsage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ColorUsage[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class WmfBitBlt extends WmfStretchBlt {
        public WmfBitBlt() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfStretchBlt, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.bitBlt;
        }
    }

    public static class WmfDibBitBlt extends WmfDibStretchBlt {
        public WmfDibBitBlt() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfDibStretchBlt, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.dibBitBlt;
        }
    }

    public static class WmfDibStretchBlt implements HwmfRecord {
        protected final Rectangle2D dstBounds;
        protected HwmfTernaryRasterOp rasterOperation;
        protected final Rectangle2D srcBounds;
        protected HwmfBitmapDib target;

        public WmfDibStretchBlt() {
            this.srcBounds = new Rectangle2D.Double();
            this.dstBounds = new Rectangle2D.Double();
        }

        public Rectangle2D getDstBounds() {
            return this.dstBounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("rasterOperation", new $$Lambda$vN6t2mTv_pcZACU3iuP5DZg8T8(this), "srcBounds", new $$Lambda$OWSh9_2u_oX7pr18Qz4_RvSmF9g(this), "dstBounds", new $$Lambda$mgoxzlcypENhXJrfCnO7RKDchAQ(this), TypedValues.AttributesType.S_TARGET, new $$Lambda$liLJQr8LDg3qztqKWvjYwr7sykE(this));
        }

        public HwmfTernaryRasterOp getRasterOperation() {
            return this.rasterOperation;
        }

        public Rectangle2D getSrcBounds() {
            return this.srcBounds;
        }

        public HwmfBitmapDib getTarget() {
            return this.target;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.dibStretchBlt;
        }
    }

    public static class WmfExtFloodFill extends WmfFloodFill {
        protected HwmfFloodFillMode mode;

        public static final enum HwmfFloodFillMode extends Enum<HwmfFloodFillMode> {
            private static final /* synthetic */ HwmfFloodFillMode[] $VALUES = null;
            public static final HwmfFloodFillMode FLOOD_FILL_BORDER = null;
            public static final HwmfFloodFillMode FLOOD_FILL_SURFACE = null;

            static {
                HwmfFloodFillMode r0 = new HwmfFloodFillMode("FLOOD_FILL_BORDER", 0);
                FLOOD_FILL_BORDER = r0;
                HwmfFloodFillMode r1 = new HwmfFloodFillMode("FLOOD_FILL_SURFACE", 1);
                FLOOD_FILL_SURFACE = r1;
                $VALUES = new HwmfFloodFillMode[]{r0, r1};
            }

            private HwmfFloodFillMode(String r1, int r2) {
                super(r1, r2);
            }

            public static HwmfFloodFillMode valueOf(String r2) {
                return (HwmfFloodFillMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfFloodFillMode.class, r2), HwmfFloodFillMode.class, "com.obric.memorydata.plugin");
            }

            public static HwmfFloodFillMode[] values() {
                return (HwmfFloodFillMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfFloodFillMode[].class, "com.obric.memorydata.plugin");
            }
        }

        public WmfExtFloodFill() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfFloodFill, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("mode", new $$Lambda$xAi8WMMnaboe8MKWbFnRgeyzGME(this));
        }

        public HwmfFloodFillMode getMode() {
            return this.mode;
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfFloodFill, org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.extFloodFill;
        }
    }

    public static class WmfFillRegion implements HwmfRecord {
        protected int brushIndex;
        protected int regionIndex;

        public WmfFillRegion() {
        }

        public int getBrushIndex() {
            return this.brushIndex;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionIndex", new $$Lambda$yNwbqLMldCa5t10CNDcoUIEfPE(this), "brushIndex", new $$Lambda$Le8Ie_D7YVZV1B_uPagLbWFyZDA(this));
        }

        public int getRegionIndex() {
            return this.regionIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.fillRegion;
        }
    }

    public static class WmfFloodFill implements HwmfRecord {
        protected final HwmfColorRef colorRef;
        protected final Point2D start;

        public WmfFloodFill() {
            this.colorRef = new HwmfColorRef();
            this.start = new Point2D.Double();
        }

        public HwmfColorRef getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("colorRef", new $$Lambda$GczmR1hDQwE9v0z3HYKMsKpzuDE(this), CommonConsts.APM_INNER_EVENT_COST_START, new $$Lambda$IQwOEXQHiHpQhV129UaTkDwO7A(this));
        }

        public Point2D getStart() {
            return this.start;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.floodFill;
        }
    }

    public static class WmfInvertRegion implements HwmfRecord {
        private int regionIndex;

        public WmfInvertRegion() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionIndex", new $$Lambda$mnB58WtcdG8wjNmHbqJZ41PbGo(this));
        }

        public int getRegionIndex() {
            return this.regionIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.invertRegion;
        }
    }

    public static class WmfPaintRegion implements HwmfRecord {
        int regionIndex;

        public WmfPaintRegion() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionIndex", new $$Lambda$wBND1e6ZyPNNQf1jCQAu9fBRoY(this));
        }

        public int getRegionIndex() {
            return this.regionIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.paintRegion;
        }
    }

    public static class WmfPatBlt implements HwmfRecord {
        private final Rectangle2D bounds;
        private HwmfTernaryRasterOp rasterOperation;

        public WmfPatBlt() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("rasterOperation", new $$Lambda$vs2w9l6XK5jMnlT3s9Oy6sFsW8(this), "bounds", new $$Lambda$0Po8bb8G3lIu7_vLAUL3WzfXCc(this));
        }

        public HwmfTernaryRasterOp getRasterOperation() {
            return this.rasterOperation;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.patBlt;
        }
    }

    public static class WmfSetDibToDev implements HwmfRecord {
        private ColorUsage colorUsage;
        private HwmfBitmapDib dib;
        protected final Rectangle2D dstBounds;
        private int scanCount;
        protected final Rectangle2D srcBounds;
        private int startScan;

        public WmfSetDibToDev() {
            this.srcBounds = new Rectangle2D.Double();
            this.dstBounds = new Rectangle2D.Double();
        }

        public ColorUsage getColorUsage() {
            return this.colorUsage;
        }

        public Rectangle2D getDstBounds() {
            return this.dstBounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("colorUsage", new $$Lambda$7qBdh2dHtwVOP9NbDSFQFjF7XE(this), "scanCount", new $$Lambda$qAXia15DMvw2zY_BGkGwvkwrts(this), "startScan", new $$Lambda$N9jSnvjaHasVSlh2Inh0VVoaREU(this), "srcBounds", new $$Lambda$Z5XqK6CZpM8S_A2ybErxwgIcGxw(this), "dstBounds", new $$Lambda$DD88N_83Y6vISSOyG_HxYNioh0(this), "dib", new $$Lambda$HwmfFill$WmfSetDibToDev$deaeoOAkEOmxUauOzaK6MxKLF4(this));
        }

        public int getScanCount() {
            return this.scanCount;
        }

        public Rectangle2D getSrcBounds() {
            return this.srcBounds;
        }

        public int getStartScan() {
            return this.startScan;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setDibToDev;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfFill$WmfSetDibToDev() {
            return this.dib;
        }
    }

    public static class WmfSetPolyfillMode implements HwmfRecord {
        protected HwmfPolyfillMode polyFillMode;

        public static final enum HwmfPolyfillMode extends Enum<HwmfPolyfillMode> {
            private static final /* synthetic */ HwmfPolyfillMode[] $VALUES = null;
            public static final HwmfPolyfillMode ALTERNATE = null;
            public static final HwmfPolyfillMode WINDING = null;
            public final int awtFlag;
            public final int wmfFlag;

            static {
                HwmfPolyfillMode r0 = new HwmfPolyfillMode("ALTERNATE", 0, 1, 0);
                ALTERNATE = r0;
                HwmfPolyfillMode r1 = new HwmfPolyfillMode("WINDING", 1, 2, 1);
                WINDING = r1;
                $VALUES = new HwmfPolyfillMode[]{r0, r1};
            }

            private HwmfPolyfillMode(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.wmfFlag = r3;
                this.awtFlag = r4;
            }

            public static HwmfPolyfillMode valueOf(int r5) {
                HwmfPolyfillMode[] r0 = values();
                int r1 = r0.length;
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L8;
                HwmfPolyfillMode r3 = r0[r2];
                if (r3.wmfFlag == r5) goto L6;
                r2 = r2 + 1;
                goto L3
            L6:
                return r3;
            L8:
                return null;
            }

            public static HwmfPolyfillMode valueOf(String r2) {
                return (HwmfPolyfillMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfPolyfillMode.class, r2), HwmfPolyfillMode.class, "com.obric.memorydata.plugin");
            }

            public static HwmfPolyfillMode[] values() {
                return (HwmfPolyfillMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfPolyfillMode[].class, "com.obric.memorydata.plugin");
            }
        }

        public WmfSetPolyfillMode() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("polyFillMode", new $$Lambda$PEAf0iEykChujikoyN6VySyLeuk(this));
        }

        public HwmfPolyfillMode getPolyFillMode() {
            return this.polyFillMode;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setPolyFillMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfStretchBlt implements HwmfRecord {
        protected final Rectangle2D dstBounds;
        protected HwmfTernaryRasterOp rasterOperation;
        protected final Rectangle2D srcBounds;
        protected HwmfBitmap16 target;

        public WmfStretchBlt() {
            this.srcBounds = new Rectangle2D.Double();
            this.dstBounds = new Rectangle2D.Double();
        }

        public Rectangle2D getDstBounds() {
            return this.dstBounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("rasterOperation", new $$Lambda$0AVAYzdToC66wqaJ7XmDs67Ato(this), "srcBounds", new $$Lambda$fwY8aDnQO1Go5J6nvC76ZeYw(this), "dstBounds", new $$Lambda$jWkpEXD_rUFS3pHVGrkXmku4mWg(this), TypedValues.AttributesType.S_TARGET, new $$Lambda$fj2j1G4KgtLD62GfIUPLhzaqiaA(this));
        }

        public HwmfTernaryRasterOp getRasterOperation() {
            return this.rasterOperation;
        }

        public Rectangle2D getSrcBounds() {
            return this.srcBounds;
        }

        public HwmfBitmap16 getTarget() {
            return this.target;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.stretchBlt;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfStretchDib implements HwmfRecord {
        protected final HwmfBitmapDib bitmap;
        protected ColorUsage colorUsage;
        protected final Rectangle2D dstBounds;
        protected HwmfTernaryRasterOp rasterOperation;
        protected final Rectangle2D srcBounds;

        public WmfStretchDib() {
            this.srcBounds = new Rectangle2D.Double();
            this.dstBounds = new Rectangle2D.Double();
            this.bitmap = new HwmfBitmapDib();
        }

        public ColorUsage getColorUsage() {
            return this.colorUsage;
        }

        public Rectangle2D getDstBounds() {
            return this.dstBounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("rasterOperation", new $$Lambda$z_KjH2vr_jzh12WluVVQ6AiHzM(this), "colorUsage", new $$Lambda$s9j0dvVoecPD2BmyVyGvrS2Atv4(this), "srcBounds", new $$Lambda$W1gtei9tizUPmHHEiIfxOS50mb0(this), "dstBounds", new $$Lambda$WcvpvvgSAUGOOtcegMvIDOFaPZQ(this));
        }

        public HwmfTernaryRasterOp getRasterOperation() {
            return this.rasterOperation;
        }

        public Rectangle2D getSrcBounds() {
            return this.srcBounds;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.stretchDib;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    static {
    }

    public HwmfFill() {
    }
}
