package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfPalette;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPalette {

    public static class EmfCreatePalette extends HwmfPalette.WmfCreatePalette implements HemfRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected int paletteIndex;

        static {
        }

        public EmfCreatePalette() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.createPalette;
        }

        @Override // org.apache.poi.hwmf.record.HwmfPalette.WmfPaletteParent, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfPalette$EmfCreatePalette$aSIdymoMNSYHnhjlQtg3qPhjc(this), "paletteIndex", new $$Lambda$mlWHEvt2lYbgTM65JHxUrLFSUdY(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public int getPaletteIndex() {
            return this.paletteIndex;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPalette$EmfCreatePalette() {
            return super.getGenericProperties();
        }
    }

    public static class EmfRealizePalette extends HwmfPalette.WmfRealizePalette implements HemfRecord {
        public EmfRealizePalette() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.realizePalette;
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

    public static class EmfResizePalette extends HwmfPalette.WmfResizePalette implements HemfRecord {
        int paletteIndex;

        public EmfResizePalette() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.resizePalette;
        }

        @Override // org.apache.poi.hwmf.record.HwmfPalette.WmfResizePalette, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfPalette$EmfResizePalette$W9iHRrfUKnfZt4qVzpm6127x_s(this), "paletteIndex", new $$Lambda$ERBAlNdEzElBpYsHfgTyzfIqL4(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public int getPaletteIndex() {
            return this.paletteIndex;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPalette$EmfResizePalette() {
            return super.getGenericProperties();
        }
    }

    public static class EmfSelectPalette extends HwmfPalette.WmfSelectPalette implements HemfRecord {
        public EmfSelectPalette() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.selectPalette;
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

    public static class EmfSetIcmMode implements HemfRecord {
        private ICMMode icmMode;

        public static final enum ICMMode extends Enum<ICMMode> {
            private static final /* synthetic */ ICMMode[] $VALUES = null;
            public static final ICMMode ICM_DONE_OUTSIDEDC = null;
            public static final ICMMode ICM_OFF = null;
            public static final ICMMode ICM_ON = null;
            public static final ICMMode ICM_QUERY = null;
            public final int id;

            static {
                ICMMode r0 = new ICMMode("ICM_OFF", 0, 1);
                ICM_OFF = r0;
                ICMMode r1 = new ICMMode("ICM_ON", 1, 2);
                ICM_ON = r1;
                ICMMode r4 = new ICMMode("ICM_QUERY", 2, 3);
                ICM_QUERY = r4;
                ICMMode r6 = new ICMMode("ICM_DONE_OUTSIDEDC", 3, 4);
                ICM_DONE_OUTSIDEDC = r6;
                $VALUES = new ICMMode[]{r0, r1, r4, r6};
            }

            private ICMMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.id = r3;
            }

            public static ICMMode valueOf(int r5) {
                ICMMode[] r0 = values();
                int r1 = r0.length;
                int r2 = 0;
            L3:
                if (r2 >= r1) goto L8;
                ICMMode r3 = r0[r2];
                if (r3.id == r5) goto L6;
                r2 = r2 + 1;
                goto L3
            L6:
                return r3;
            L8:
                return null;
            }

            public static ICMMode valueOf(String r2) {
                return (ICMMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ICMMode.class, r2), ICMMode.class, "com.obric.memorydata.plugin");
            }

            public static ICMMode[] values() {
                return (ICMMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ICMMode[].class, "com.obric.memorydata.plugin");
            }
        }

        public EmfSetIcmMode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.seticmmode;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("icmMode", new $$Lambda$rnf_nYL9osgMoM5TRvx6pixrWRU(this));
        }

        public ICMMode getIcmMode() {
            return this.icmMode;
        }
    }

    public static class EmfSetPaletteEntries extends HwmfPalette.WmfSetPaletteEntries implements HemfRecord {
        int paletteIndex;

        public EmfSetPaletteEntries() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setPaletteEntries;
        }

        @Override // org.apache.poi.hwmf.record.HwmfPalette.WmfPaletteParent, org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("base", new $$Lambda$HemfPalette$EmfSetPaletteEntries$2wRtSgDA7m_kNiKygZqSmRVAraU(this), "paletteIndex", new $$Lambda$YnImcKAS52kn9qFGH53G3Jr6Q9E(this));
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord, org.apache.poi.common.usermodel.GenericRecord
        public HemfRecordType getGenericRecordType() {
            return getEmfRecordType();
        }

        public int getPaletteIndex() {
            return this.paletteIndex;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPalette$EmfSetPaletteEntries() {
            return super.getGenericProperties();
        }
    }

    public HemfPalette() {
    }
}
