package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfText;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfText {
    private static int MAX_RECORD_LENGTH = 1000000;

    public static class EmfExtCreateFontIndirectW extends HwmfText.WmfCreateFontIndirect implements HemfRecord {
        int fontIdx;

        public EmfExtCreateFontIndirectW() {
            super(new HemfFont());
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extCreateFontIndirectW;
        }

        public int getFontIdx() {
            return this.fontIdx;
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfCreateFontIndirect, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfText$EmfExtCreateFontIndirectW$HI8dwbKADCA63FjTZtft1xebA3c(this), "fontIdx", new $$Lambda$sPt8t8ciKMpCbnFJhmO4cnAWRk(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfText$EmfExtCreateFontIndirectW() {
            return super.getGenericProperties();
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfCreateFontIndirect
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfExtTextOutA extends HwmfText.WmfExtTextOut implements HemfRecord {
        protected Rectangle2D boundsIgnored;
        protected EmfGraphicsMode graphicsMode;
        protected final Dimension2D scale;

        public EmfExtTextOutA() {
            super(new EmfExtTextOutOptions());
            this.boundsIgnored = new Rectangle2D.Double();
            this.scale = new Dimension2DDouble();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extTextOutA;
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfExtTextOut, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfText$EmfExtTextOutA$5lb9col0gxjQyA3v2WSsZ4BLZf0(this), "boundsIgnored", new $$Lambda$HemfText$EmfExtTextOutA$Sp1a7pnezjmGItCIv25aHAoEG_g(this), "graphicsMode", new $$Lambda$HyRjcIEJVwDkclLVkP824KkCGo(this), "scale", new $$Lambda$Ozn9Y3aMpcoDUH3pirFRMMFpQ8I(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public EmfGraphicsMode getGraphicsMode() {
            return this.graphicsMode;
        }

        public Dimension2D getScale() {
            return this.scale;
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfExtTextOut
        public String getText(Charset r1) {
            return super.getText(r1);
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfText$EmfExtTextOutA() {
            return super.getGenericProperties();
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfText$EmfExtTextOutA() {
            return this.boundsIgnored;
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfExtTextOut
        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfExtTextOutOptions extends HwmfText.WmfExtTextOutOptions {
        public EmfExtTextOutOptions() {
        }
    }

    public static class EmfExtTextOutW extends EmfExtTextOutA {
        public EmfExtTextOutW() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfText.EmfExtTextOutA, org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.extTextOutW;
        }

        @Override // org.apache.poi.hwmf.record.HwmfText.WmfExtTextOut
        public boolean isUnicode() {
            return true;
        }
    }

    public static final enum EmfGraphicsMode extends Enum<EmfGraphicsMode> {
        private static final /* synthetic */ EmfGraphicsMode[] $VALUES = null;
        public static final EmfGraphicsMode GM_ADVANCED = null;
        public static final EmfGraphicsMode GM_COMPATIBLE = null;

        static {
            EmfGraphicsMode r0 = new EmfGraphicsMode("GM_COMPATIBLE", 0);
            GM_COMPATIBLE = r0;
            EmfGraphicsMode r1 = new EmfGraphicsMode("GM_ADVANCED", 1);
            GM_ADVANCED = r1;
            $VALUES = new EmfGraphicsMode[]{r0, r1};
        }

        private EmfGraphicsMode(String r1, int r2) {
            super(r1, r2);
        }

        public static EmfGraphicsMode valueOf(String r2) {
            return (EmfGraphicsMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfGraphicsMode.class, r2), EmfGraphicsMode.class, "com.obric.memorydata.plugin");
        }

        public static EmfGraphicsMode[] values() {
            return (EmfGraphicsMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfGraphicsMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfSetTextAlign extends HwmfText.WmfSetTextAlign implements HemfRecord {
        public EmfSetTextAlign() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setTextAlign;
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

    public static class EmfSetTextColor extends HwmfText.WmfSetTextColor implements HemfRecord {
        public EmfSetTextColor() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setTextColor;
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

    public static class PolyTextOutA extends UnimplementedHemfRecord {
        public PolyTextOutA() {
        }
    }

    public static class PolyTextOutW extends UnimplementedHemfRecord {
        public PolyTextOutW() {
        }
    }

    public static class SetTextJustification extends UnimplementedHemfRecord {
        public SetTextJustification() {
        }
    }

    static {
    }
}
