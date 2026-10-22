package org.apache.poi.hemf.record.emf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hwmf.record.HwmfRegionMode;
import org.apache.poi.hwmf.record.HwmfWindowing;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfWindowing {

    public static class EmfScaleViewportExtEx extends HwmfWindowing.WmfScaleViewportExt implements HemfRecord {
        public EmfScaleViewportExtEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.scaleViewportExtEx;
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

    public static class EmfScaleWindowExtEx extends HwmfWindowing.WmfScaleWindowExt implements HemfRecord {
        public EmfScaleWindowExtEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.scaleWindowExtEx;
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

    public static class EmfSelectClipPath implements HemfRecord {
        protected HwmfRegionMode regionMode;

        public EmfSelectClipPath() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.selectClipPath;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("regionMode", new $$Lambda$MCswCFlL1Ypw9kOUMmF3pB9wh4(this));
        }

        public HwmfRegionMode getRegionMode() {
            return this.regionMode;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfSetExcludeClipRect extends HwmfWindowing.WmfExcludeClipRect implements HemfRecord {
        public EmfSetExcludeClipRect() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setExcludeClipRect;
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

    public static class EmfSetIntersectClipRect extends HwmfWindowing.WmfIntersectClipRect implements HemfRecord {
        public EmfSetIntersectClipRect() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setIntersectClipRect;
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

    public static class EmfSetOffsetClipRgn extends HwmfWindowing.WmfOffsetClipRgn implements HemfRecord {
        public EmfSetOffsetClipRgn() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setOffsetClipRgn;
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

    public static class EmfSetViewportExtEx extends HwmfWindowing.WmfSetViewportExt implements HemfRecord {
        public EmfSetViewportExtEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setViewportExtEx;
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

    public static class EmfSetViewportOrgEx extends HwmfWindowing.WmfSetViewportOrg implements HemfRecord {
        public EmfSetViewportOrgEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setViewportOrgEx;
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

    public static class EmfSetWindowExtEx extends HwmfWindowing.WmfSetWindowExt implements HemfRecord {
        public EmfSetWindowExtEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setWindowExtEx;
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

    public static class EmfSetWindowOrgEx extends HwmfWindowing.WmfSetWindowOrg implements HemfRecord {
        public EmfSetWindowOrgEx() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.setWindowOrgEx;
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
}
