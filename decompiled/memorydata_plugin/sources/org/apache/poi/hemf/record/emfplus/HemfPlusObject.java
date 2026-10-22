package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusObject {

    public static class EmfPlusObject implements HemfPlusMisc.EmfPlusObjectId, HemfPlusRecord {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BitField CONTINUABLE = null;
        private static final int[] FLAGS_MASKS = null;
        private static final String[] FLAGS_NAMES = null;
        private static final BitField OBJECT_TYPE = null;
        private int flags;
        private EmfPlusObjectData objectData;
        private int totalObjectSize;

        static {
            CONTINUABLE = BitFieldFactory.getInstance(32768);
            OBJECT_TYPE = BitFieldFactory.getInstance(32512);
            FLAGS_MASKS = new int[]{32512, 32768};
            FLAGS_NAMES = new String[]{"OBJECT_TYPE", "CONTINUABLE"};
        }

        public EmfPlusObject() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
        public HemfPlusRecordType getEmfPlusRecordType() {
            return HemfPlusRecordType.object;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusMisc.EmfPlusObjectId
        public int getFlags() {
            return this.flags;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            Supplier<GenericRecordUtil.AnnotatedFlag> r4 = GenericRecordUtil.getBitsAsString(new $$Lambda$OZauCGxhs72CtkrpdsNbnXGdbI(this), FLAGS_MASKS, FLAGS_NAMES);
            Supplier r6 = new $$Lambda$E6OCielrgqD7_1TkcOcg2zPem1M(this);
            Supplier r8 = new $$Lambda$HemfPlusObject$EmfPlusObject$IRvwon4H7gMAIv36_sOObefE8oI(this);
            final EmfPlusObjectData r0 = this.objectData;
            r0.getClass();
            return GenericRecordUtil.getGenericProperties("flags", r4, "objectId", r6, "objectData", r8, "continuedObject", new $$Lambda$YN9O2868kdMkQleOkEmm7kzgUpo(r0), "totalObjectSize", new $$Lambda$TN7G1lNSGWvafrZwQKjX8KkH84(this));
        }

        public <T extends EmfPlusObjectData> T getObjectData() {
            return (T) this.objectData;
        }

        public int getTotalObjectSize() {
            return this.totalObjectSize;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusObject$EmfPlusObject() {
            if (this.objectData.isContinuedRecord() == false) goto L6;
            return null;
        L6:
            return getObjectData();
        }
    }

    public interface EmfPlusObjectData extends GenericRecord {
        HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion();

        default boolean isContinuedRecord() {
            HemfPlusHeader.EmfPlusGraphicsVersion r1 = getGraphicsVersion();
            if (r1.getGraphicsVersion() != null) goto L5;
        L8:
            return true;
        L5:
            if (r1.getMetafileSignature() != 900097) goto L8;
            return false;
        }
    }

    public static final enum EmfPlusObjectType extends Enum<EmfPlusObjectType> {
        private static final /* synthetic */ EmfPlusObjectType[] $VALUES = null;
        public static final EmfPlusObjectType BRUSH = null;
        public static final EmfPlusObjectType CUSTOM_LINE_CAP = null;
        public static final EmfPlusObjectType FONT = null;
        public static final EmfPlusObjectType IMAGE = null;
        public static final EmfPlusObjectType IMAGE_ATTRIBUTES = null;
        public static final EmfPlusObjectType INVALID = null;
        public static final EmfPlusObjectType PATH = null;
        public static final EmfPlusObjectType PEN = null;
        public static final EmfPlusObjectType REGION = null;
        public static final EmfPlusObjectType STRING_FORMAT = null;
        public final Supplier<? extends EmfPlusObjectData> constructor;
        public final int id;

        static {
            EmfPlusObjectType r0 = new EmfPlusObjectType("INVALID", 0, 0, $$Lambda$DABzdwBNB54rj43z9f5whzZcUk.INSTANCE);
            INVALID = r0;
            EmfPlusObjectType r1 = new EmfPlusObjectType("BRUSH", 1, 1, $$Lambda$_Auh8qy2OOIBtno1C2MG_CvSEW0.INSTANCE);
            BRUSH = r1;
            EmfPlusObjectType r2 = new EmfPlusObjectType("PEN", 2, 2, $$Lambda$M_kKSxTYydyHZqv9XmRnfFpkBys.INSTANCE);
            PEN = r2;
            EmfPlusObjectType r4 = new EmfPlusObjectType("PATH", 3, 3, $$Lambda$Qv42DHWFs_WWyohjqf7gO_xfYt8.INSTANCE);
            PATH = r4;
            EmfPlusObjectType r6 = new EmfPlusObjectType("REGION", 4, 4, $$Lambda$tiSnCBwc1_jVpsCBvya8Z02DSZs.INSTANCE);
            REGION = r6;
            EmfPlusObjectType r8 = new EmfPlusObjectType("IMAGE", 5, 5, $$Lambda$Bl_GPW2YP1o0ghKjcf_0QG2LCg.INSTANCE);
            IMAGE = r8;
            EmfPlusObjectType r10 = new EmfPlusObjectType("FONT", 6, 6, $$Lambda$fA8xjaUAZ_qs95kK0Lh6bftrwg.INSTANCE);
            FONT = r10;
            EmfPlusObjectType r12 = new EmfPlusObjectType("STRING_FORMAT", 7, 7, $$Lambda$DABzdwBNB54rj43z9f5whzZcUk.INSTANCE);
            STRING_FORMAT = r12;
            EmfPlusObjectType r14 = new EmfPlusObjectType("IMAGE_ATTRIBUTES", 8, 8, $$Lambda$UXKkwuGc6gmImuBVuURWS0lL2U.INSTANCE);
            IMAGE_ATTRIBUTES = r14;
            EmfPlusObjectType r13 = new EmfPlusObjectType("CUSTOM_LINE_CAP", 9, 9, $$Lambda$DABzdwBNB54rj43z9f5whzZcUk.INSTANCE);
            CUSTOM_LINE_CAP = r13;
            $VALUES = new EmfPlusObjectType[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13};
        }

        private EmfPlusObjectType(String r3, int r4, int r5, Supplier r6) {
            Supplier<? extends EmfPlusObjectData> r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.id = r5;
            this.constructor = r7;
        }

        public static EmfPlusObjectType valueOf(int r5) {
            EmfPlusObjectType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusObjectType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusObjectType valueOf(String r2) {
            return (EmfPlusObjectType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusObjectType.class, r2), EmfPlusObjectType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusObjectType[] values() {
            return (EmfPlusObjectType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusObjectType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusUnknownData implements EmfPlusObjectData {
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private byte[] objectDataBytes;
        private EmfPlusObjectType objectType;

        public EmfPlusUnknownData() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$EctVHRZI1YGtiJY0Sp4Ih_6JslM(this), "objectDataBytes", new $$Lambda$HemfPlusObject$EmfPlusUnknownData$11SODWFr8xyT4dGqstpG46DqMP0(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusObjectType getGenericRecordType() {
            return this.objectType;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusObject$EmfPlusUnknownData() {
            return this.objectDataBytes;
        }
    }

    public HemfPlusObject() {
    }
}
