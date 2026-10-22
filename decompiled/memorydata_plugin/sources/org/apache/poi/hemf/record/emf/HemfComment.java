package org.apache.poi.hemf.record.emf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hemf.record.emfplus.HemfPlusRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfComment {
    private static final c LOG = null;

    public static class EmfComment implements HemfRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EmfCommentData data;

        static {
        }

        public EmfComment() {
        }

        public EmfCommentData getCommentData() {
            return this.data;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfRecord
        public HemfRecordType getEmfRecordType() {
            return HemfRecordType.comment;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("data", new $$Lambda$18Jx0DFOCe90CxZpOQVyKcaTBg(this));
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public interface EmfCommentData extends GenericRecord {
        HemfCommentRecordType getCommentRecordType();

        @Override // org.apache.poi.common.usermodel.GenericRecord
        /* bridge */ /* synthetic */ default Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        default HemfCommentRecordType getGenericRecordType() {
            return getCommentRecordType();
        }
    }

    public static class EmfCommentDataBeginGroup implements EmfCommentData {
        private final Rectangle2D bounds;
        private String description;

        public EmfCommentDataBeginGroup() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfBeginGroup;
        }

        public String getDescription() {
            return this.description;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$gtgHsgm4BiPXPnBsXLcEEPoBzPU(this), "description", new $$Lambda$vSvGCmdD_XF7MOi5chl83DsQuxM(this));
        }
    }

    public static class EmfCommentDataEndGroup implements EmfCommentData {
        public EmfCommentDataEndGroup() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfEndGroup;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }
    }

    public static class EmfCommentDataGeneric implements EmfCommentData {
        private Supplier<Charset> charsetProvider;
        private byte[] privateData;

        public EmfCommentDataGeneric() {
            this.charsetProvider = $$Lambda$HemfComment$EmfCommentDataGeneric$P0W493ELaa5rBby7JSFmf6do_YY.INSTANCE;
        }

        static /* synthetic */ Charset lambda$new$0() {
            return LocaleUtil.CHARSET_1252;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfGeneric;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("privateData", new $$Lambda$J5MieMx7kgWqwgcYfrcdWwkSee4(this), "privateDataAsString", new $$Lambda$POprvcHeDGUietAleBLv2kJ2lNQ(this));
        }

        public byte[] getPrivateData() {
            return this.privateData;
        }

        public String getPrivateDataAsString() {
            return new String(this.privateData, (Charset) ZeusTransformUtils.preCheckCast(this.charsetProvider.get(), Charset.class, "com.obric.memorydata.plugin"));
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static class EmfCommentDataMultiformats implements EmfCommentData {
        private final Rectangle2D bounds;
        private final List<Object> formats;

        public EmfCommentDataMultiformats() {
            this.bounds = new Rectangle2D.Double();
            this.formats = new ArrayList();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfMultiFormats;
        }

        public List<Object> getFormats() {
            return Collections.unmodifiableList(this.formats);
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public List<Object> getGenericChildren() {
            return getFormats();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$oHtxr02UhOqBSQ8xTPVUJU1YTjA(this));
        }
    }

    public static class EmfCommentDataPlus implements EmfCommentData {
        private final List<HemfPlusRecord> records;

        public EmfCommentDataPlus() {
            this.records = new ArrayList();
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfPlus;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public List<HemfPlusRecord> getGenericChildren() {
            return getRecords();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        public List<HemfPlusRecord> getRecords() {
            return Collections.unmodifiableList(this.records);
        }
    }

    public static class EmfCommentDataUnicode implements EmfCommentData {
        public EmfCommentDataUnicode() {
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfUnicodeString;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }
    }

    public static class EmfCommentDataWMF implements EmfCommentData {
        private final Rectangle2D bounds;
        private byte[] wmfData;

        public EmfCommentDataWMF() {
            this.bounds = new Rectangle2D.Double();
        }

        public Rectangle2D getBounds() {
            return this.bounds;
        }

        @Override // org.apache.poi.hemf.record.emf.HemfComment.EmfCommentData
        public HemfCommentRecordType getCommentRecordType() {
            return HemfCommentRecordType.emfWMF;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("bounds", new $$Lambda$tgVsSN5hSw2eLswAvmqBiZpQIcY(this), "wmfData", new $$Lambda$GlbKOS_aw6mLMRufHWWvcaA4lI(this));
        }

        public byte[] getWMFData() {
            return this.wmfData;
        }
    }

    public static final enum EmfFormatSignature extends Enum<EmfFormatSignature> {
        private static final /* synthetic */ EmfFormatSignature[] $VALUES = null;
        public static final EmfFormatSignature ENHMETA_SIGNATURE = null;
        public static final EmfFormatSignature EPS_SIGNATURE = null;
        int id;

        static {
            EmfFormatSignature r0 = new EmfFormatSignature("ENHMETA_SIGNATURE", 0, 1179469088);
            ENHMETA_SIGNATURE = r0;
            EmfFormatSignature r1 = new EmfFormatSignature("EPS_SIGNATURE", 1, 1179865157);
            EPS_SIGNATURE = r1;
            $VALUES = new EmfFormatSignature[]{r0, r1};
        }

        private EmfFormatSignature(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static EmfFormatSignature getById(int r5) {
            EmfFormatSignature[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfFormatSignature r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfFormatSignature valueOf(String r2) {
            return (EmfFormatSignature) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfFormatSignature.class, r2), EmfFormatSignature.class, "com.obric.memorydata.plugin");
        }

        public static EmfFormatSignature[] values() {
            return (EmfFormatSignature[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfFormatSignature[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HemfCommentRecordType extends Enum<HemfCommentRecordType> {
        private static final /* synthetic */ HemfCommentRecordType[] $VALUES = null;
        public static final HemfCommentRecordType emfBeginGroup = null;
        public static final HemfCommentRecordType emfEndGroup = null;
        public static final HemfCommentRecordType emfGeneric = null;
        public static final HemfCommentRecordType emfMultiFormats = null;
        public static final HemfCommentRecordType emfPlus = null;
        public static final HemfCommentRecordType emfPublic = null;
        public static final HemfCommentRecordType emfSpool = null;
        public static final HemfCommentRecordType emfUnicodeEnd = null;
        public static final HemfCommentRecordType emfUnicodeString = null;
        public static final HemfCommentRecordType emfWMF = null;
        public final Supplier<? extends EmfCommentData> constructor;
        public final long id;
        public final boolean isEmfPublic;

        static {
            HemfCommentRecordType r7 = new HemfCommentRecordType("emfGeneric", 0, -1, $$Lambda$aEfulkmzkd1hihOAymS_ytDvEKY.INSTANCE, false);
            emfGeneric = r7;
            HemfCommentRecordType r0 = new HemfCommentRecordType("emfSpool", 1, 0, $$Lambda$aEfulkmzkd1hihOAymS_ytDvEKY.INSTANCE, false);
            emfSpool = r0;
            HemfCommentRecordType r1 = new HemfCommentRecordType("emfPlus", 2, 726027589, $$Lambda$tpAZgP1PH2QF8eRyum6rf4IA8k.INSTANCE, false);
            emfPlus = r1;
            HemfCommentRecordType r2 = new HemfCommentRecordType("emfPublic", 3, 1128875079, null, false);
            emfPublic = r2;
            HemfCommentRecordType r3 = new HemfCommentRecordType("emfBeginGroup", 4, 2, $$Lambda$cZfHdOHL96SncbZ4hqGYovjX0V0.INSTANCE, true);
            emfBeginGroup = r3;
            HemfCommentRecordType r4 = new HemfCommentRecordType("emfEndGroup", 5, 3, $$Lambda$IutwG7M0gRCbNVxMlatB2EYXuM.INSTANCE, true);
            emfEndGroup = r4;
            HemfCommentRecordType r5 = new HemfCommentRecordType("emfMultiFormats", 6, 1073741828, $$Lambda$4ngPg_EG0yRORmzFruBWGawZluU.INSTANCE, true);
            emfMultiFormats = r5;
            HemfCommentRecordType r6 = new HemfCommentRecordType("emfWMF", 7, -2147483647L, $$Lambda$8AREN37bs4p8hrin9htdFvHQ.INSTANCE, true);
            emfWMF = r6;
            HemfCommentRecordType r8 = new HemfCommentRecordType("emfUnicodeString", 8, 64, $$Lambda$mhxXVXKuOC_ap33eRJQRlqt1NLs.INSTANCE, true);
            emfUnicodeString = r8;
            HemfCommentRecordType r16 = new HemfCommentRecordType("emfUnicodeEnd", 9, 128, $$Lambda$mhxXVXKuOC_ap33eRJQRlqt1NLs.INSTANCE, true);
            emfUnicodeEnd = r16;
            $VALUES = new HemfCommentRecordType[]{r7, r0, r1, r2, r3, r4, r5, r6, r8, r16};
        }

        private HemfCommentRecordType(String r3, int r4, long r5, Supplier r7, boolean r8) {
            Supplier<? extends EmfCommentData> r9 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r7, Supplier.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.id = r5;
            this.constructor = r9;
            this.isEmfPublic = r8;
        }

        public static HemfCommentRecordType getById(long r6, boolean r8) {
            HemfCommentRecordType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L11;
            HemfCommentRecordType r3 = r0[r2];
            if (r3.id != r6) goto L9;
            if (r3.isEmfPublic != r8) goto L9;
            return r3;
        L9:
            r2 = r2 + 1;
            goto L3
        L11:
            return emfGeneric;
        }

        public static HemfCommentRecordType valueOf(String r2) {
            return (HemfCommentRecordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HemfCommentRecordType.class, r2), HemfCommentRecordType.class, "com.obric.memorydata.plugin");
        }

        public static HemfCommentRecordType[] values() {
            return (HemfCommentRecordType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HemfCommentRecordType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(HemfComment.class);
    }

    public HemfComment() {
    }
}
