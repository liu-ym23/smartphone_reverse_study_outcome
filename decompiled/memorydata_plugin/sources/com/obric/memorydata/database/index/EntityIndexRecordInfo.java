package com.obric.memorydata.database.index;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CBs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010*\u001a\u00020+J\u001e\u0010 \u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\fJ\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0019\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0080\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u0002002\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006D"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexRecordInfo;", "", "entityId", "", "entityType", ObricMemoryConstants.KEY_PACKAGE_NAME, "initFastIndexTaskTimeStamp", "", "initSlowIndexTaskTimeStamp", "initSumIndexTaskTimeStamp", "subTaskCost", "", "Lcom/obric/memorydata/database/index/IndexTaskCostInfo;", "startTime", EntityIndexRecordInfo.TOTAL_INDEX_COST_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;JLcom/obric/memorydata/database/index/IndexTaskCostInfo;)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "getPackageName", "getInitFastIndexTaskTimeStamp", "()Ljava/lang/Long;", "setInitFastIndexTaskTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getInitSlowIndexTaskTimeStamp", "setInitSlowIndexTaskTimeStamp", "getInitSumIndexTaskTimeStamp", "setInitSumIndexTaskTimeStamp", "getSubTaskCost", "()Ljava/util/Map;", "setSubTaskCost", "(Ljava/util/Map;)V", "getStartTime", "()J", "setStartTime", "(J)V", "getTotalIndexCost", "()Lcom/obric/memorydata/database/index/IndexTaskCostInfo;", "setTotalIndexCost", "(Lcom/obric/memorydata/database/index/IndexTaskCostInfo;)V", "setInitIndexTaskTimeStamp", "", "buildType", "columnContent", "indexTaskCostInfo", "fillTotalIndexCost", "", "jsonObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;JLcom/obric/memorydata/database/index/IndexTaskCostInfo;)Lcom/obric/memorydata/database/index/EntityIndexRecordInfo;", "equals", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityIndexRecordInfo {
    public static final String ACTUAL_TOTAL_INDEX_COST_KEY = "actualTotalIndexCost";
    public static final a Companion = null;
    public static final String TOTAL_INDEX_COST_KEY = "totalIndexCost";
    private final String entityId;
    private final String entityType;
    private Long initFastIndexTaskTimeStamp;
    private Long initSlowIndexTaskTimeStamp;
    private Long initSumIndexTaskTimeStamp;
    private final String packageName;
    private long startTime;
    private Map<String, IndexTaskCostInfo> subTaskCost;
    private IndexTaskCostInfo totalIndexCost;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexRecordInfo$Companion;", "", "<init>", "()V", "TOTAL_INDEX_COST_KEY", "", "ACTUAL_TOTAL_INDEX_COST_KEY", "getSubTaskName", "buildType", "columnContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "buildType");
            Intrinsics.checkNotNullParameter(r2, "columnContent");
            return r1 + '-' + r2;
        }
    }

    static {
        Companion = new a(null);
    }

    public EntityIndexRecordInfo(String r3, String r4, String r5, Long r6, Long r7, Long r8, Map<String, IndexTaskCostInfo> r9, long r10, IndexTaskCostInfo r12) {
        Map<String, IndexTaskCostInfo> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r4, "entityType");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.entityId = r3;
        this.entityType = r4;
        this.packageName = r5;
        this.initFastIndexTaskTimeStamp = r6;
        this.initSlowIndexTaskTimeStamp = r7;
        this.initSumIndexTaskTimeStamp = r8;
        this.subTaskCost = r11;
        this.startTime = r10;
        this.totalIndexCost = r12;
        com.obric.memorydata.database.util.b.f9624a.a(r5, r3, r4);
    }

    public /* synthetic */ EntityIndexRecordInfo(String r16, String r17, String r18, Long r19, Long r20, Long r21, Map r22, long r23, IndexTaskCostInfo r25, int r26, DefaultConstructorMarker r27) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        if ((r26 & 8) == 0) goto L5;
        Long r8 = null;
    L7:
        if ((r26 & 16) == 0) goto L9;
        Long r9 = null;
    L11:
        if ((r26 & 32) == 0) goto L13;
        Long r10 = null;
    L15:
        if ((r26 & 64) == 0) goto L17;
        Map r11 = null;
    L19:
        if ((r26 & 128) == 0) goto L21;
        long r12 = System.currentTimeMillis();
    L23:
        if ((r26 & 256) == 0) goto L25;
        IndexTaskCostInfo r14 = null;
    L26:
        this(r16, r17, r18, r8, r9, r10, r11, r12, r14);
        return;
    L25:
        r14 = r25;
        goto L26
    L21:
        r12 = r23;
        goto L23
    L17:
        r11 = r1;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }

    public static /* synthetic */ EntityIndexRecordInfo copy$default(EntityIndexRecordInfo r11, String r12, String r13, String r14, Long r15, Long r16, Long r17, Map r18, long r19, IndexTaskCostInfo r21, int r22, Object r23) {
        Map<String, IndexTaskCostInfo> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        if ((r22 & 1) == 0) goto L5;
        String r3 = r11.entityId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r4 = r11.entityType;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r5 = r11.packageName;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Long r6 = r11.initFastIndexTaskTimeStamp;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Long r7 = r11.initSlowIndexTaskTimeStamp;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Long r8 = r11.initSumIndexTaskTimeStamp;
    L27:
        if ((r22 & 64) == 0) goto L30;
        r2 = r11.subTaskCost;
    L30:
        if ((r22 & 128) == 0) goto L32;
        long r9 = r11.startTime;
    L34:
        if ((r22 & 256) == 0) goto L36;
        IndexTaskCostInfo r1 = r11.totalIndexCost;
    L38:
        return r11.copy(r3, r4, r5, r6, r7, r8, r2, r9, r1);
    L36:
        r1 = r21;
        goto L38
    L32:
        r9 = r19;
        goto L34
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public final String component1() {
        return this.entityId;
    }

    public final String component2() {
        return this.entityType;
    }

    public final String component3() {
        return this.packageName;
    }

    public final Long component4() {
        return this.initFastIndexTaskTimeStamp;
    }

    public final Long component5() {
        return this.initSlowIndexTaskTimeStamp;
    }

    public final Long component6() {
        return this.initSumIndexTaskTimeStamp;
    }

    public final Map<String, IndexTaskCostInfo> component7() {
        return this.subTaskCost;
    }

    public final long component8() {
        return this.startTime;
    }

    public final IndexTaskCostInfo component9() {
        return this.totalIndexCost;
    }

    public final EntityIndexRecordInfo copy(String r13, String r14, String r15, Long r16, Long r17, Long r18, Map<String, IndexTaskCostInfo> r19, long r20, IndexTaskCostInfo r22) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "entityId");
        Intrinsics.checkNotNullParameter(r14, "entityType");
        Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new EntityIndexRecordInfo(r13, r14, r15, r16, r17, r18, r8, r20, r22);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EntityIndexRecordInfo.class) == true) goto L8;
        return false;
    L8:
        EntityIndexRecordInfo r10 = (EntityIndexRecordInfo) ZeusTransformUtils.preCheckCast(r9, EntityIndexRecordInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityType, r10.entityType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.initFastIndexTaskTimeStamp, r10.initFastIndexTaskTimeStamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.initSlowIndexTaskTimeStamp, r10.initSlowIndexTaskTimeStamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.initSumIndexTaskTimeStamp, r10.initSumIndexTaskTimeStamp) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.subTaskCost, r10.subTaskCost) == true) goto L30;
        return false;
    L30:
        if (this.startTime == r10.startTime) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.totalIndexCost, r10.totalIndexCost) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final boolean fillTotalIndexCost(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "jsonObject");
        IndexTaskCostInfo r0 = this.totalIndexCost;
        if (r0 == null) goto L8;
        Long r1 = this.initSumIndexTaskTimeStamp;
        if (r1 == null) goto L10;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        r8.put(TOTAL_INDEX_COST_KEY, Math.max(0, r0.getFinishTimeStamp() - this.startTime));
        r8.put(ACTUAL_TOTAL_INDEX_COST_KEY, Math.max(0, r0.getActualFinishTimeStamp() - r2));
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getEntityType() {
        return this.entityType;
    }

    public final Long getInitFastIndexTaskTimeStamp() {
        return this.initFastIndexTaskTimeStamp;
    }

    public final Long getInitSlowIndexTaskTimeStamp() {
        return this.initSlowIndexTaskTimeStamp;
    }

    public final Long getInitSumIndexTaskTimeStamp() {
        return this.initSumIndexTaskTimeStamp;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final Map<String, IndexTaskCostInfo> getSubTaskCost() {
        return this.subTaskCost;
    }

    public final IndexTaskCostInfo getTotalIndexCost() {
        return this.totalIndexCost;
    }

    public int hashCode() {
        int r0 = ((((this.entityId.hashCode() * 31) + this.entityType.hashCode()) * 31) + this.packageName.hashCode()) * 31;
        Long r1 = this.initFastIndexTaskTimeStamp;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.initSlowIndexTaskTimeStamp;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.initSumIndexTaskTimeStamp;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, IndexTaskCostInfo> r11 = this.subTaskCost;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Long.hashCode(this.startTime)) * 31;
        IndexTaskCostInfo r14 = this.totalIndexCost;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setInitFastIndexTaskTimeStamp(Long r1) {
        this.initFastIndexTaskTimeStamp = r1;
    }

    public final void setInitIndexTaskTimeStamp() {
        this.initFastIndexTaskTimeStamp = Long.valueOf(com.obric.memorydata.database.util.b.f9624a.c(com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME));
        this.initSlowIndexTaskTimeStamp = Long.valueOf(com.obric.memorydata.database.util.b.f9624a.c(com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME));
        this.initSumIndexTaskTimeStamp = Long.valueOf(com.obric.memorydata.database.util.b.f9624a.c(null));
    }

    public final void setInitSlowIndexTaskTimeStamp(Long r1) {
        this.initSlowIndexTaskTimeStamp = r1;
    }

    public final void setInitSumIndexTaskTimeStamp(Long r1) {
        this.initSumIndexTaskTimeStamp = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setSubTaskCost(String r6, String r7, IndexTaskCostInfo r8) {
        Intrinsics.checkNotNullParameter(r6, "buildType");
        Intrinsics.checkNotNullParameter(r7, "columnContent");
        Intrinsics.checkNotNullParameter(r8, "indexTaskCostInfo");
        if (this.subTaskCost != null) goto L5;
        this.subTaskCost = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L5:
        a r0 = Companion;
        String r1 = r0.a(r6, r7);
        Map<String, IndexTaskCostInfo> r2 = this.subTaskCost;
        boolean r3 = true;
        if (r2 != null) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        return;
    L13:
        Map<String, IndexTaskCostInfo> r5 = this.subTaskCost;
        if (r5 == null) goto L17;
        r5.put(r0.a(r6, r7), r8);
        return;
    L17:
        return;
    L8:
        if (r2.containsKey(r1) != true) goto L10;
        goto L10
    }

    public final void setSubTaskCost(Map<String, IndexTaskCostInfo> r3) {
        this.subTaskCost = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void setTotalIndexCost(IndexTaskCostInfo r1) {
        this.totalIndexCost = r1;
    }

    public String toString() {
        return "EntityIndexRecordInfo(entityId=" + this.entityId + ", entityType=" + this.entityType + ", packageName=" + this.packageName + ", initFastIndexTaskTimeStamp=" + this.initFastIndexTaskTimeStamp + ", initSlowIndexTaskTimeStamp=" + this.initSlowIndexTaskTimeStamp + ", initSumIndexTaskTimeStamp=" + this.initSumIndexTaskTimeStamp + ", subTaskCost=" + this.subTaskCost + ", startTime=" + this.startTime + ", totalIndexCost=" + this.totalIndexCost + ')';
    }
}
