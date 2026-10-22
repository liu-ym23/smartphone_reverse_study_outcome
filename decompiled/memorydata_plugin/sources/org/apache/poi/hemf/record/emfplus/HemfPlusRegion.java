package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusRegion {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class EmfPlusRegion implements HemfPlusObject.EmfPlusObjectData {
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private EmfPlusRegionNodeData regionNode;

        public EmfPlusRegion() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$5bkLTWko0OtI_ckTi3DQUAJXCrU(this), "regionNode", new $$Lambda$BbKakxicFfwnm21Z9AsBfJFNVQ0(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.REGION;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public EmfPlusRegionNodeData getRegionNode() {
            return this.regionNode;
        }
    }

    public static class EmfPlusRegionEmpty implements EmfPlusRegionNodeData {
        public EmfPlusRegionEmpty() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusRegionNodeDataType getGenericRecordType() {
            return EmfPlusRegionNodeDataType.EMPTY;
        }
    }

    public static class EmfPlusRegionInfinite implements EmfPlusRegionNodeData {
        public EmfPlusRegionInfinite() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusRegionNodeDataType getGenericRecordType() {
            return EmfPlusRegionNodeDataType.INFINITE;
        }
    }

    public static class EmfPlusRegionNode implements EmfPlusRegionNodeData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EmfPlusRegionNodeData left;
        private EmfPlusRegionNodeDataType nodeType;
        private EmfPlusRegionNodeData right;

        static {
        }

        public EmfPlusRegionNode() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("nodeType", new $$Lambda$M_5JqhV2ewyiMLCbTAwwxbo9Yww(this), "left", new $$Lambda$zoCW5SAzEifUQDKT4dnJy6blEqw(this), "right", new $$Lambda$xKCiU7QFL65Jtmlis4Ciujjg_I(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusRegionNodeDataType getGenericRecordType() {
            return this.nodeType;
        }

        public EmfPlusRegionNodeData getLeft() {
            return this.left;
        }

        public EmfPlusRegionNodeDataType getNodeType() {
            return this.nodeType;
        }

        public EmfPlusRegionNodeData getRight() {
            return this.right;
        }
    }

    public interface EmfPlusRegionNodeData extends GenericRecord {
    }

    public static final enum EmfPlusRegionNodeDataType extends Enum<EmfPlusRegionNodeDataType> {
        private static final /* synthetic */ EmfPlusRegionNodeDataType[] $VALUES = null;
        public static final EmfPlusRegionNodeDataType AND = null;
        public static final EmfPlusRegionNodeDataType COMPLEMENT = null;
        public static final EmfPlusRegionNodeDataType EMPTY = null;
        public static final EmfPlusRegionNodeDataType EXCLUDE = null;
        public static final EmfPlusRegionNodeDataType INFINITE = null;
        public static final EmfPlusRegionNodeDataType OR = null;
        public static final EmfPlusRegionNodeDataType PATH = null;
        public static final EmfPlusRegionNodeDataType RECT = null;
        public static final EmfPlusRegionNodeDataType XOR = null;
        public final Supplier<EmfPlusRegionNodeData> constructor;
        public final int id;
        public final BiConsumer<Area, Area> operation;

        static {
            EmfPlusRegionNodeDataType r6 = new EmfPlusRegionNodeDataType("AND", 0, 1, $$Lambda$AVJkt_DcO8WBRNB95mAMchbwDXE.INSTANCE, $$Lambda$HemfPlusRegion$EmfPlusRegionNodeDataType$8LDfCCq8lcw0469ujM5lxY7MII.INSTANCE);
            AND = r6;
            EmfPlusRegionNodeDataType r0 = new EmfPlusRegionNodeDataType("OR", 1, 2, $$Lambda$AVJkt_DcO8WBRNB95mAMchbwDXE.INSTANCE, $$Lambda$HemfPlusRegion$EmfPlusRegionNodeDataType$coVOhqiBMJ8LlNOw56jDc9TWFs.INSTANCE);
            OR = r0;
            EmfPlusRegionNodeDataType r1 = new EmfPlusRegionNodeDataType("XOR", 2, 3, $$Lambda$AVJkt_DcO8WBRNB95mAMchbwDXE.INSTANCE, $$Lambda$HemfPlusRegion$EmfPlusRegionNodeDataType$KnFvnUWDv9LIyJbKkY_jkVHgPD4.INSTANCE);
            XOR = r1;
            EmfPlusRegionNodeDataType r2 = new EmfPlusRegionNodeDataType("EXCLUDE", 3, 4, $$Lambda$AVJkt_DcO8WBRNB95mAMchbwDXE.INSTANCE, $$Lambda$HemfPlusRegion$EmfPlusRegionNodeDataType$DIoe1wGII4AwCqpGC4pacZhn70.INSTANCE);
            EXCLUDE = r2;
            EmfPlusRegionNodeDataType r3 = new EmfPlusRegionNodeDataType("COMPLEMENT", 4, 5, $$Lambda$AVJkt_DcO8WBRNB95mAMchbwDXE.INSTANCE, $$Lambda$HemfPlusRegion$EmfPlusRegionNodeDataType$DIoe1wGII4AwCqpGC4pacZhn70.INSTANCE);
            COMPLEMENT = r3;
            EmfPlusRegionNodeDataType r4 = new EmfPlusRegionNodeDataType("RECT", 5, SQLiteDatabase.CREATE_IF_NECESSARY, $$Lambda$JUCcVP_JUpLDNWlGvmgqFB_lq0.INSTANCE, null);
            RECT = r4;
            EmfPlusRegionNodeDataType r5 = new EmfPlusRegionNodeDataType("PATH", 6, 268435457, $$Lambda$fXldxuHc_m9JnOd6rpOWXMzotiw.INSTANCE, null);
            PATH = r5;
            EmfPlusRegionNodeDataType r13 = new EmfPlusRegionNodeDataType("EMPTY", 7, 268435458, $$Lambda$TGHg5xrecpZ92_i9x_SAFEuOKc.INSTANCE, null);
            EMPTY = r13;
            EmfPlusRegionNodeDataType r7 = new EmfPlusRegionNodeDataType("INFINITE", 8, 268435459, $$Lambda$6ETEWUfp6KPCw7bybY0OGBQPczA.INSTANCE, null);
            INFINITE = r7;
            $VALUES = new EmfPlusRegionNodeDataType[]{r6, r0, r1, r2, r3, r4, r5, r13, r7};
        }

        private EmfPlusRegionNodeDataType(String r3, int r4, int r5, Supplier r6, BiConsumer r7) {
            Supplier<EmfPlusRegionNodeData> r8 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
            BiConsumer<Area, Area> r9 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r7, BiConsumer.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.id = r5;
            this.constructor = r8;
            this.operation = r9;
        }

        /* JADX INFO: renamed from: lambda$8LDf-CCq8lcw0469ujM5lxY7MII, reason: not valid java name */
        public static /* synthetic */ void m3155lambda$8LDfCCq8lcw0469ujM5lxY7MII(Area r0, Area r1) {
            r0.intersect(r1);
        }

        /* JADX INFO: renamed from: lambda$DI-oe1wGII4AwCqpGC4pacZhn70, reason: not valid java name */
        public static /* synthetic */ void m3156lambda$DIoe1wGII4AwCqpGC4pacZhn70(Area r0, Area r1) {
            r0.subtract(r1);
        }

        public static /* synthetic */ void lambda$KnFvnUWDv9LIyJbKkY_jkVHgPD4(Area r0, Area r1) {
            r0.exclusiveOr(r1);
        }

        /* JADX INFO: renamed from: lambda$coVO-hqiBMJ8LlNOw56jDc9TWFs, reason: not valid java name */
        public static /* synthetic */ void m3157lambda$coVOhqiBMJ8LlNOw56jDc9TWFs(Area r0, Area r1) {
            r0.add(r1);
        }

        public static EmfPlusRegionNodeDataType valueOf(int r5) {
            EmfPlusRegionNodeDataType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EmfPlusRegionNodeDataType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EmfPlusRegionNodeDataType valueOf(String r2) {
            return (EmfPlusRegionNodeDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmfPlusRegionNodeDataType.class, r2), EmfPlusRegionNodeDataType.class, "com.obric.memorydata.plugin");
        }

        public static EmfPlusRegionNodeDataType[] values() {
            return (EmfPlusRegionNodeDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmfPlusRegionNodeDataType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class EmfPlusRegionPath extends HemfPlusPath.EmfPlusPath implements EmfPlusRegionNodeData {
        public EmfPlusRegionPath() {
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusPath.EmfPlusPath, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusPath.EmfPlusPath, org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusRegionNodeDataType getGenericRecordType() {
            return EmfPlusRegionNodeDataType.PATH;
        }
    }

    public static class EmfPlusRegionRect implements EmfPlusRegionNodeData {
        private final Rectangle2D rect;

        public EmfPlusRegionRect() {
            this.rect = new Rectangle2D.Double();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("rect", new $$Lambda$HemfPlusRegion$EmfPlusRegionRect$S8WE9nhJb5zAgkiuEev1NhJfoQ(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public EmfPlusRegionNodeDataType getGenericRecordType() {
            return EmfPlusRegionNodeDataType.RECT;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusRegion$EmfPlusRegionRect() {
            return this.rect;
        }
    }

    static {
    }

    public HemfPlusRegion() {
    }
}
