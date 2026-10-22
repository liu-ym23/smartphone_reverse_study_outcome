package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfBitmapDib;
import org.apache.poi.hwmf.record.HwmfColorRef;
import org.apache.poi.hwmf.record.HwmfDraw;
import org.apache.poi.hwmf.record.HwmfFill;
import org.apache.poi.hwmf.record.HwmfRegionMode;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class HemfFill {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class EmfAlphaBlend implements HemfRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected byte alphaFormat;
        protected final HwmfBitmapDib bitmap;
        protected final HwmfColorRef bkColorSrc;
        protected byte blendFlags;
        protected byte blendOperation;
        protected final Rectangle2D bounds;
        protected final Rectangle2D destRect;
        protected int srcConstantAlpha;
        protected final Rectangle2D srcRect;
        protected HwmfFill.ColorUsage usageSrc;
        protected final AffineTransform xFormSrc;

        static {
        }

        public EmfAlphaBlend() {
            this.bounds = new Rectangle2D.Double();
            this.destRect = new Rectangle2D.Double();
            this.srcRect = new Rectangle2D.Double();
            this.xFormSrc = new AffineTransform();
            this.bkColorSrc = new HwmfColorRef();
            this.bitmap = new HwmfBitmapDib();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.alphaBlend;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("bounds", new $$Lambda$HemfFill$EmfAlphaBlend$s3ILucCLWLWsGpUUbNe4isIAyq4(this));
            r0.put("destRect", new $$Lambda$HemfFill$EmfAlphaBlend$jc1VMl5U4NHiEZKsXy7vRpWSmOE(this));
            r0.put("srcRect", new $$Lambda$HemfFill$EmfAlphaBlend$U_2Gd_ahrbzJDAS9olOw2CLRR0g(this));
            r0.put("blendOperation", new $$Lambda$HemfFill$EmfAlphaBlend$qDbcoPPvN9plmJ59CFU0PPQWPa4(this));
            r0.put("blendFlags", new $$Lambda$HemfFill$EmfAlphaBlend$q0yw6mRl7vktVWXdcBeyIwjHIRI(this));
            r0.put("srcConstantAlpha", new $$Lambda$HemfFill$EmfAlphaBlend$tP0fhyWCeFpCxh98PndLbvgTSI(this));
            r0.put("alphaFormat", new $$Lambda$HemfFill$EmfAlphaBlend$H7HhdsSm7hCQnaMBEiYWz4T2UB8(this));
            r0.put("xFormSrc", new $$Lambda$HemfFill$EmfAlphaBlend$KJSDidylOBwL0BK0erlqEL7BVE(this));
            r0.put("bkColorSrc", new $$Lambda$HemfFill$EmfAlphaBlend$DMGat4oa0lU3E7hFtiiPt5jVUNE(this));
            r0.put("usageSrc", new $$Lambda$HemfFill$EmfAlphaBlend$BNa0zRS0FosWQ5Ri7AHSr1CNhS4(this));
            r0.put("bitmap", new $$Lambda$HemfFill$EmfAlphaBlend$1tuJzr3Kxv4EM4UPoYzg06ZBNI(this));
            return Collections.unmodifiableMap(r0);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFill$EmfAlphaBlend() {
            return this.bounds;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfFill$EmfAlphaBlend() {
            return this.destRect;
        }

        public /* synthetic */ Object lambda$getGenericProperties$10$HemfFill$EmfAlphaBlend() {
            return this.bitmap;
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfFill$EmfAlphaBlend() {
            return this.srcRect;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfFill$EmfAlphaBlend() {
            return Byte.valueOf(this.blendOperation);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfFill$EmfAlphaBlend() {
            return Byte.valueOf(this.blendFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$5$HemfFill$EmfAlphaBlend() {
            return Integer.valueOf(this.srcConstantAlpha);
        }

        public /* synthetic */ Object lambda$getGenericProperties$6$HemfFill$EmfAlphaBlend() {
            return Byte.valueOf(this.alphaFormat);
        }

        public /* synthetic */ Object lambda$getGenericProperties$7$HemfFill$EmfAlphaBlend() {
            return this.xFormSrc;
        }

        public /* synthetic */ Object lambda$getGenericProperties$8$HemfFill$EmfAlphaBlend() {
            return this.bkColorSrc;
        }

        public /* synthetic */ Object lambda$getGenericProperties$9$HemfFill$EmfAlphaBlend() {
            return this.usageSrc;
        }
    }

    public static class EmfBitBlt extends EmfStretchBlt {
        public EmfBitBlt() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfFill.EmfStretchBlt, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.bitBlt;
        }
    }

    public static class EmfExtFloodFill extends HwmfFill.WmfExtFloodFill implements HemfRecord {
        public EmfExtFloodFill() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extFloodFill;
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

    public static class EmfExtSelectClipRgn implements HemfRecord {
        protected HwmfRegionMode regionMode;
        protected final List<Rectangle2D> rgnRects;

        public EmfExtSelectClipRgn() {
            this.rgnRects = new ArrayList();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extSelectClipRgn;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionMode", new $$Lambda$A9xsjNuLmnaUNzIccx7fJJDVRU8(this), "rgnRects", new $$Lambda$BlDlHDNWKcAkJgAeUbaakH7p9Uc(this));
        }

        public HwmfRegionMode getRegionMode() {
            return this.regionMode;
        }

        public List<Rectangle2D> getRgnRects() {
            return this.rgnRects;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfFillRgn extends HwmfFill.WmfFillRegion implements HemfRecord {
        protected final Rectangle2D bounds;
        protected final List<Rectangle2D> rgnRects;

        public EmfFillRgn() {
            this.bounds = new Rectangle2D.Double();
            this.rgnRects = new ArrayList();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.fillRgn;
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfFillRegion, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfFill$EmfFillRgn$zxlAFVXbfH0f0UqXiP7zRHNT9Do(this), "bounds", new $$Lambda$njZw5ZlSRk2dxakJrpUbspS6RLU(this), "rgnRects", new $$Lambda$PrVfKlkdgktsxP1kCh9y4zjmpU4(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public List<Rectangle2D> getRgnRects() {
            return this.rgnRects;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFill$EmfFillRgn() {
            return super.getGenericProperties();
        }
    }

    public static class EmfFrameRgn extends HwmfDraw.WmfFrameRegion implements HemfRecord {
        private final Rectangle2D bounds;
        private final List<Rectangle2D> rgnRects;

        public EmfFrameRgn() {
            this.bounds = new Rectangle2D.Double();
            this.rgnRects = new ArrayList();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.frameRgn;
        }

        @Override // org.apache.poi.hwmf.record.HwmfDraw.WmfFrameRegion, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfFill$EmfFrameRgn$lhSXQoI1t3ZJk80lobhXcnXKI(this), "bounds", new $$Lambda$DY0pYX55aYJ9q_6Rx8VIKRQxUtM(this), "rgnRects", new $$Lambda$sC8CKzNgWzbJfocrpbeozenPjI0(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public List<Rectangle2D> getRgnRects() {
            return this.rgnRects;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFill$EmfFrameRgn() {
            return super.getGenericProperties();
        }
    }

    public static class EmfInvertRgn implements HemfRecord {
        protected final Rectangle2D bounds;
        protected final List<Rectangle2D> rgnRects;

        public EmfInvertRgn() {
            this.bounds = new Rectangle2D.Double();
            this.rgnRects = new ArrayList();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.invertRgn;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$qUuFxjxVoi1GJWAvrkd90urHOc(this), "rgnRects", new $$Lambda$HqAH7LvBvCLI8vjo5M7Sdkhosb8(this));
        }

        public List<Rectangle2D> getRgnRects() {
            return this.rgnRects;
        }
    }

    public static class EmfPaintRgn extends EmfInvertRgn {
        public EmfPaintRgn() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfFill.EmfInvertRgn, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.paintRgn;
        }
    }

    public static class EmfSetDiBitsToDevice implements HemfRecord {
        protected final HwmfBitmapDib bitmap;
        protected final Rectangle2D bounds;
        protected final Point2D dest;
        protected final Rectangle2D src;
        protected HwmfFill.ColorUsage usageSrc;

        public EmfSetDiBitsToDevice() {
            this.bounds = new Rectangle2D.Double();
            this.dest = new Point2D.Double();
            this.src = new Rectangle2D.Double();
            this.bitmap = new HwmfBitmapDib();
        }

        public HwmfBitmapDib getBitmap() {
            return this.bitmap;
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        public Point2D getDest() {
            return this.dest;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setDiBitsToDevice;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$pBKwIwubm6QFohFqs_jlWFcCM1c(this), "dest", new $$Lambda$GCsD9yZwbE06lIxDWR4EpkYUmC0(this), "src", new $$Lambda$LjctrNCnx2i89l2oFdza49_n9cg(this), "usageSrc", new $$Lambda$LFb1TMmai2e2ugJYDADKAdGFhHU(this), "bitmap", new $$Lambda$JI7Y5b67bwratODkH16gRZwJrw(this));
        }

        public Rectangle2D getSrc() {
            return this.src;
        }

        public HwmfFill.ColorUsage getUsageSrc() {
            return this.usageSrc;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfSetPolyfillMode extends HwmfFill.WmfSetPolyfillMode implements HemfRecord {
        public EmfSetPolyfillMode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setPolyfillMode;
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

    public static class EmfStretchBlt extends HwmfFill.WmfStretchDib implements HemfRecord {
        protected final HwmfColorRef bkColorSrc;
        protected final Rectangle2D bounds;
        protected final AffineTransform xFormSrc;

        public EmfStretchBlt() {
            this.bounds = new Rectangle2D.Double();
            this.xFormSrc = new AffineTransform();
            this.bkColorSrc = new HwmfColorRef();
        }

        public HwmfColorRef getBkColorSrc() {
            return this.bkColorSrc;
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.stretchBlt;
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfStretchDib, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfFill$EmfStretchBlt$WfsKdEuWfGSogxvWknmYAtOxDE(this), "bounds", new $$Lambda$hMaQYk6Al5winp1nw9KNkf2isjI(this), "xFormSrc", new $$Lambda$l6qBzUmWoAOeqB0EbPEQ6Zqbo(this), "bkColorSrc", new $$Lambda$tjH0YJQ1DEV0ySBmmbcxdVqgJw(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public AffineTransform getXFormSrc() {
            return this.xFormSrc;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFill$EmfStretchBlt() {
            return super.getGenericProperties();
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfStretchDib
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfStretchDiBits extends HwmfFill.WmfStretchDib implements HemfRecord {
        protected final Rectangle2D bounds;

        public EmfStretchDiBits() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.stretchDiBits;
        }

        @Override // org.apache.poi.hwmf.record.HwmfFill.WmfStretchDib, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfFill$EmfStretchDiBits$NKD_fWmWgPZetU5eifN70JSsB8(this), "bounds", new $$Lambda$ivkAJQg7ChXMhzzrWLHsM4sqLHI(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfFill$EmfStretchDiBits() {
            return super.getGenericProperties();
        }
    }

    static {
    }

    private HemfFill() {
    }

    public static int readXForm(LittleEndianInputStream r16, AffineTransform r17) {
        AffineTransform r0 = (AffineTransform) ZeusTransformUtils.wrapperContextForParams(r17, AffineTransform.class, "com.obric.memorydata.plugin");
        double r2 = r16.readFloat();
        double r4 = r16.readFloat();
        r0.setTransform(r2, -r16.readFloat(), -r4, r16.readFloat(), r16.readFloat(), r16.readFloat());
        if (r0.isIdentity() == false) goto L7;
        r0.setToIdentity();
        return 24;
    L7:
        return 24;
    }
}
