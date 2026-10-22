package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfWindowing {

    public static class WmfCreateRegion implements HwmfRecord {
        private final Rectangle2D bounds;
        private int maxScan;
        private int nextInChain;
        private int objectCount;
        private int objectType;
        private int regionSize;
        private int scanCount;
        private WmfScanObject[] scanObjects;

        public WmfCreateRegion() {
            this.bounds = new Rectangle2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("nextInChain", new $$Lambda$HwmfWindowing$WmfCreateRegion$3NJiWr_tV2Xze3kaPhN00DVn4Y(this));
            r0.put("objectType", new $$Lambda$HwmfWindowing$WmfCreateRegion$btOU_kH0hIjOcEx9Id5TYyzamJ4(this));
            r0.put("objectCount", new $$Lambda$HwmfWindowing$WmfCreateRegion$xSRRy5XqUI2te0q15BqxhyQqb_o(this));
            r0.put("regionSize", new $$Lambda$HwmfWindowing$WmfCreateRegion$yBcx9JNgqCAp40qpjIn9bOLgIhM(this));
            r0.put("scanCount", new $$Lambda$HwmfWindowing$WmfCreateRegion$g2qiKDttFACE7PTUoD6_0Ltuot8(this));
            r0.put("maxScan", new $$Lambda$HwmfWindowing$WmfCreateRegion$gqJxTJh4YD62xKt03AE5svDqVfo(this));
            r0.put("bounds", new $$Lambda$HwmfWindowing$WmfCreateRegion$cnU4lDPTiPn03FEVTxBC5ICYHK4(this));
            r0.put("scanObjects", new $$Lambda$HwmfWindowing$WmfCreateRegion$C9OZLcAD2ZJvo2mQF0Z3knPfZ6A(this));
            return Collections.unmodifiableMap(r0);
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createRegion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.nextInChain);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.objectType);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.objectCount);
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.regionSize);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.scanCount);
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HwmfWindowing$WmfCreateRegion() {
            return Integer.valueOf(this.maxScan);
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HwmfWindowing$WmfCreateRegion() {
            return this.bounds;
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HwmfWindowing$WmfCreateRegion() {
            return Arrays.asList(this.scanObjects);
        }
    }

    public static class WmfExcludeClipRect implements HwmfRecord {
        protected final Rectangle2D bounds;

        public WmfExcludeClipRect() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$TcoI3VHfH7MbpRLrbrsNKLEs_I(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.excludeClipRect;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfIntersectClipRect implements HwmfRecord {
        protected final Rectangle2D bounds;

        public WmfIntersectClipRect() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$C8WKZBJIu6v612aHJMIy_qH912I(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.intersectClipRect;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfOffsetClipRgn implements HwmfRecord {
        protected final Point2D offset;

        public WmfOffsetClipRgn() {
            this.offset = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$9O63fWYC3G2q962UN8WRYLvOHco(this));
        }

        public Point2D getOffset() {
            return this.offset;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.offsetClipRgn;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfOffsetViewportOrg implements HwmfRecord {
        protected final Point2D offset;

        public WmfOffsetViewportOrg() {
            this.offset = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$xMA52PIC0ZpOBl5X2m6jC0J5uoU(this));
        }

        public Point2D getOffset() {
            return this.offset;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.offsetViewportOrg;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfOffsetWindowOrg implements HwmfRecord {
        protected final Point2D offset;

        public WmfOffsetWindowOrg() {
            this.offset = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$ds4jUL6P515aBqlX25z9_gU0TZ0(this));
        }

        public Point2D getOffset() {
            return this.offset;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.offsetWindowOrg;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfScaleViewportExt implements HwmfRecord {
        protected final Dimension2D scale;

        public WmfScaleViewportExt() {
            this.scale = new Dimension2DDouble();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("scale", new $$Lambda$SKW2zBEyGHykBBySagRfBg4uCV8(this));
        }

        public Dimension2D getScale() {
            return this.scale;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.scaleViewportExt;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfScaleWindowExt implements HwmfRecord {
        protected final Dimension2D scale;

        public WmfScaleWindowExt() {
            this.scale = new Dimension2DDouble();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("scale", new $$Lambda$lECg2_GYzFPuQyQgaOswpEpwDc(this));
        }

        public Dimension2D getScale() {
            return this.scale;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.scaleWindowExt;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfScanObject implements GenericRecord {
        private int bottom;
        private int count;
        private int count2;
        private int[] left_scanline;
        private int[] right_scanline;
        private int top;

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(CommonConsts.COUNT_TYPE, new $$Lambda$HwmfWindowing$WmfScanObject$0HwrDjodDZJhsgW6Hq93MdaTWM(this), "top", new $$Lambda$HwmfWindowing$WmfScanObject$f3DgD62IyysX72rbXf0QSupX7Gs(this), "bottom", new $$Lambda$HwmfWindowing$WmfScanObject$FguvdOG9VyoNhyxiRtshpzUS2pA(this), "left_scanline", new $$Lambda$HwmfWindowing$WmfScanObject$3yO2bWazqJtZsyLVBrvxb1OBHtc(this), "right_scanline", new $$Lambda$HwmfWindowing$WmfScanObject$vB63s1AatxQsQck95tAyHW5NyI(this), "count2", new $$Lambda$HwmfWindowing$WmfScanObject$OXlF6Asv7utAVE_7M4Ftjt72530(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfWindowing$WmfScanObject() {
            return Integer.valueOf(this.count);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfWindowing$WmfScanObject() {
            return Integer.valueOf(this.top);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HwmfWindowing$WmfScanObject() {
            return Integer.valueOf(this.bottom);
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HwmfWindowing$WmfScanObject() {
            return Arrays.asList(new int[][]{this.left_scanline});
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HwmfWindowing$WmfScanObject() {
            return Arrays.asList(new int[][]{this.right_scanline});
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HwmfWindowing$WmfScanObject() {
            return Integer.valueOf(this.count2);
        }
    }

    public static class WmfSelectClipRegion implements HwmfRecord {
        private int region;

        public WmfSelectClipRegion() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(Api.KEY_REGION, new $$Lambda$5YABL7kUarVpgmuq6dWkYuA5VE(this));
        }

        public int getRegion() {
            return this.region;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.selectClipRegion;
        }
    }

    public static class WmfSetViewportExt implements HwmfRecord {
        protected final Dimension2D extents;

        public WmfSetViewportExt() {
            this.extents = new Dimension2DDouble();
        }

        public Dimension2D getExtents() {
            return this.extents;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("extents", new $$Lambda$oFfAEWnC206ZqGa6OCmjsrwEltc(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setViewportExt;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetViewportOrg implements HwmfRecord {
        protected final Point2D origin;

        public WmfSetViewportOrg() {
            this.origin = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("origin", new $$Lambda$FZIcS3PqZcrFZT80oyMBnp3qk(this));
        }

        public Point2D getOrigin() {
            return this.origin;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setViewportOrg;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetWindowExt implements HwmfRecord {
        protected final Dimension2D size;

        public WmfSetWindowExt() {
            this.size = new Dimension2DDouble();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("size", new $$Lambda$p43wE1UKSvLcZdV0ignbfBYBok(this));
        }

        public Dimension2D getSize() {
            return this.size;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setWindowExt;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class WmfSetWindowOrg implements HwmfRecord {
        protected final Point2D origin;

        public WmfSetWindowOrg() {
            this.origin = new Point2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("origin", new $$Lambda$BtkFiFPT7TUZ9w0lsA8Fy2NSI7M(this));
        }

        public Point2D getOrigin() {
            return this.origin;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setWindowOrg;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }
}
