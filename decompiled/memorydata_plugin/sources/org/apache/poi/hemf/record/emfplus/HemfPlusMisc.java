package org.apache.poi.hemf.record.emfplus;

import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfRegionMode;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusMisc {

    public static final enum CombineMode extends Enum<CombineMode> {
        private static final /* synthetic */ CombineMode[] $VALUES = null;
        public static final CombineMode COMPLEMENT = null;
        public static final CombineMode EXCLUDE = null;
        public static final CombineMode INTERSECT = null;
        public static final CombineMode REPLACE = null;
        public static final CombineMode UNION = null;
        public static final CombineMode XOR = null;
        public final int id;
        public final HwmfRegionMode regionMode;

        static {
            CombineMode r0 = new CombineMode("REPLACE", 0, 0, HwmfRegionMode.RGN_COPY);
            REPLACE = r0;
            CombineMode r1 = new CombineMode("INTERSECT", 1, 1, HwmfRegionMode.RGN_AND);
            INTERSECT = r1;
            CombineMode r2 = new CombineMode("UNION", 2, 2, HwmfRegionMode.RGN_OR);
            UNION = r2;
            CombineMode r4 = new CombineMode("XOR", 3, 3, HwmfRegionMode.RGN_XOR);
            XOR = r4;
            CombineMode r6 = new CombineMode("EXCLUDE", 4, 4, HwmfRegionMode.RGN_DIFF);
            EXCLUDE = r6;
            CombineMode r8 = new CombineMode("COMPLEMENT", 5, 5, HwmfRegionMode.RGN_COMPLEMENT);
            COMPLEMENT = r8;
            $VALUES = new CombineMode[]{r0, r1, r2, r4, r6, r8};
        }

        private CombineMode(String r1, int r2, int r3, HwmfRegionMode r4) {
            super(r1, r2);
            this.id = r3;
            this.regionMode = r4;
        }

        public static CombineMode valueOf(int r5) {
            CombineMode[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            CombineMode r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static CombineMode valueOf(String r2) {
            return (CombineMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(CombineMode.class, r2), CombineMode.class, "com.obric.memorydata.plugin");
        }

        public static CombineMode[] values() {
            return (CombineMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CombineMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusEOF extends EmfPlusFlagOnly {
        public EmfPlusEOF() {
        }
    }

    public static abstract class EmfPlusFlagOnly implements HemfPlusRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int[] FLAGS_MASK = null;
        private static final String[] FLAGS_NAMES = null;
        private int flags;
        private HemfPlusRecordType recordType;

        static {
            FLAGS_MASK = new int[]{CaeNfcCardInfo.LIFE_CYCLE_INACTIVE};
            FLAGS_NAMES = new String[]{"COMBINE_MODE"};
        }

        public EmfPlusFlagOnly() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public final HemfPlusRecordType getEmfPlusRecordType() {
            return this.recordType;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$nr4BkYJMwpzkz1OedD4LOFCD_0(this), FLAGS_MASK, FLAGS_NAMES));
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusRecordType getGenericRecordType() {
            return getEmfPlusRecordType();
        }
    }

    public static class EmfPlusGetDC extends EmfPlusFlagOnly {
        public EmfPlusGetDC() {
        }
    }

    public static class EmfPlusMultiplyWorldTransform extends EmfPlusSetWorldTransform {
        public EmfPlusMultiplyWorldTransform() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusSetWorldTransform, org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.multiplyWorldTransform;
        }
    }

    public interface EmfPlusObjectId {
        public static final BitField OBJECT_ID = null;

        static {
            OBJECT_ID = BitFieldFactory.getInstance(255);
        }

        int getFlags();

        default int getObjectId() {
            return OBJECT_ID.getValue(getFlags());
        }
    }

    public static class EmfPlusResetClip extends EmfPlusFlagOnly {
        public EmfPlusResetClip() {
        }
    }

    public static class EmfPlusResetWorldTransform extends EmfPlusFlagOnly {
        public EmfPlusResetWorldTransform() {
        }
    }

    public static class EmfPlusRestore extends EmfPlusSave {
        public EmfPlusRestore() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusSave, org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.restore;
        }
    }

    public static class EmfPlusSave implements HemfPlusRecord {
        private int flags;
        private int stackIndex;

        public EmfPlusSave() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.save;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$yd6DLtU6VcLXAvvM0LgCDZZgrG0(this), "stackIndex", new $$Lambda$kzmoxJWm6cC0kAY1Nqf7_IuFf7g(this));
        }

        public int getStackIndex() {
            return this.stackIndex;
        }
    }

    public static class EmfPlusSetAntiAliasMode extends EmfPlusFlagOnly {
        public EmfPlusSetAntiAliasMode() {
        }
    }

    public static class EmfPlusSetClipPath extends EmfPlusFlagOnly implements EmfPlusObjectId {
        private static final BitField COMBINE_MODE = null;

        static {
            COMBINE_MODE = BitFieldFactory.getInstance(CaeNfcCardInfo.LIFE_CYCLE_INACTIVE);
        }

        public EmfPlusSetClipPath() {
        }
    }

    public static class EmfPlusSetClipRect implements HemfPlusRecord {
        private static final BitField COMBINE_MODE = null;
        private static final int[] FLAGS_MASK = null;
        private static final String[] FLAGS_NAMES = null;
        private final Rectangle2D clipRect;
        private int flags;

        static {
            COMBINE_MODE = BitFieldFactory.getInstance(CaeNfcCardInfo.LIFE_CYCLE_INACTIVE);
            FLAGS_MASK = new int[]{CaeNfcCardInfo.LIFE_CYCLE_INACTIVE};
            FLAGS_NAMES = new String[]{"COMBINE_MODE"};
        }

        public EmfPlusSetClipRect() {
            this.clipRect = new Rectangle2D.Double();
        }

        public Rectangle2D getClipRect() {
            return this.clipRect;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.setClipRect;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$i0rK5Z9RAcHMbmqXzOsokPbigqc(this), FLAGS_MASK, FLAGS_NAMES), "clipRect", new $$Lambda$bujRoIX1Ya3tXSbWsEvM5WIg8(this));
        }
    }

    public static class EmfPlusSetClipRegion extends EmfPlusSetClipPath {
        public EmfPlusSetClipRegion() {
        }
    }

    public static class EmfPlusSetCompositingMode extends EmfPlusFlagOnly {
        public EmfPlusSetCompositingMode() {
        }
    }

    public static class EmfPlusSetCompositingQuality extends EmfPlusFlagOnly {
        public EmfPlusSetCompositingQuality() {
        }
    }

    public static class EmfPlusSetInterpolationMode extends EmfPlusFlagOnly {
        public EmfPlusSetInterpolationMode() {
        }
    }

    public static class EmfPlusSetPageTransform implements HemfPlusRecord {
        private int flags;
        private double pageScale;

        public EmfPlusSetPageTransform() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.setPageTransform;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$FIc2GIOsM7lUB6jODs4FHZEjJ4(this), "pageScale", new $$Lambda$0bdQg82sUouuqThNZ2Wqoyyytc(this));
        }

        public double getPageScale() {
            return this.pageScale;
        }
    }

    public static class EmfPlusSetPixelOffsetMode extends EmfPlusFlagOnly {
        public EmfPlusSetPixelOffsetMode() {
        }
    }

    public static class EmfPlusSetRenderingOrigin implements HemfPlusRecord {
        int flags;
        Point2D origin;

        public EmfPlusSetRenderingOrigin() {
            this.origin = new Point2D.Double();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.setRenderingOrigin;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$n9kDjAcNGtrB6W4QA5mEbbV1SA(this), "origin", new $$Lambda$bB8lL0hR34f9E1jSttSLcydwcU(this));
        }

        public Point2D getOrigin() {
            return this.origin;
        }
    }

    public static class EmfPlusSetTextRenderingHint extends EmfPlusFlagOnly {
        public EmfPlusSetTextRenderingHint() {
        }
    }

    public static class EmfPlusSetWorldTransform implements HemfPlusRecord {
        private int flags;
        private final AffineTransform matrixData;

        public EmfPlusSetWorldTransform() {
            this.matrixData = new AffineTransform();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.setWorldTransform;
        }

        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$wa31rJPYiHqOTakzfB_vNpj2pjk(this), "matrixData", new $$Lambda$yAoK5D6aD4cLfJRNheBLyFOPwEo(this));
        }

        public AffineTransform getMatrixData() {
            return this.matrixData;
        }
    }

    public HemfPlusMisc() {
    }
}
