package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.EntityProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B³\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0012HÆ\u0003J\t\u0010:\u001a\u00020\u0012HÆ\u0003J\t\u0010;\u001a\u00020\u0012HÆ\u0003Jµ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012HÆ\u0001J\u0013\u0010=\u001a\u00020\u00122\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020-HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0016\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0016\u0010\u0015\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'¨\u0006A"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchOperation;", "", "operationId", "", "businessId", "writePurpose", "requeueKeeperId", "operateType", "entityIds", "", "expectedChangeSeqs", "", "", "entity", "Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;", "hotWords", "retractionReason", "allowDuplicateMerge", "", "migrationOperation", "reuseSource", "writeRetraction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;Ljava/util/List;Ljava/lang/String;ZZZZ)V", "getOperationId", "()Ljava/lang/String;", "getBusinessId", "getWritePurpose", "getRequeueKeeperId", "getOperateType", "getEntityIds", "()Ljava/util/List;", "getExpectedChangeSeqs", "()Ljava/util/Map;", "getEntity", "()Lcom/obric/memorydata/union/build/storage/SemanticBatchEntityPayload;", "getHotWords", "getRetractionReason", "getAllowDuplicateMerge", "()Z", "getMigrationOperation", "getReuseSource", "getWriteRetraction", "stableId", "index", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticBatchOperation {

    @SerializedName(alternate = {"allowDuplicateMerge"}, value = "allow_duplicate_merge")
    private final boolean allowDuplicateMerge;

    @SerializedName(alternate = {"businessId"}, value = "business_id")
    private final String businessId;
    private final SemanticBatchEntityPayload entity;

    @SerializedName(alternate = {"entityIds"}, value = EntityProvider.KEY_ENTITY_IDS)
    private final List<String> entityIds;

    @SerializedName(alternate = {"expectedChangeSeqs"}, value = "expected_change_seqs")
    private final Map<String, Long> expectedChangeSeqs;

    @SerializedName(alternate = {"hotWords"}, value = "hot_words")
    private final List<String> hotWords;

    @SerializedName(alternate = {"migrationOperation"}, value = "migration_operation")
    private final boolean migrationOperation;

    @SerializedName(alternate = {"operateType"}, value = "operate_type")
    private final String operateType;

    @SerializedName(alternate = {"operationId"}, value = "operation_id")
    private final String operationId;

    @SerializedName(alternate = {"requeueKeeperId"}, value = "requeue_keeper_id")
    private final String requeueKeeperId;

    @SerializedName(alternate = {"retractionReason"}, value = "retraction_reason")
    private final String retractionReason;

    @SerializedName(alternate = {"reuseSource"}, value = "reuse_source")
    private final boolean reuseSource;

    @SerializedName(alternate = {"writePurpose"}, value = "write_purpose")
    private final String writePurpose;

    @SerializedName(alternate = {"writeRetraction"}, value = "write_retraction")
    private final boolean writeRetraction;

    public SemanticBatchOperation() {
        this(null, null, null, null, null, null, null, null, null, null, false, false, false, false, 16383, null);
    }

    public SemanticBatchOperation(String r10, String r11, String r12, String r13, String r14, List<String> r15, Map<String, Long> r16, SemanticBatchEntityPayload r17, List<String> r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Map<String, Long> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "businessId");
        Intrinsics.checkNotNullParameter(r12, "writePurpose");
        Intrinsics.checkNotNullParameter(r14, "operateType");
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        Intrinsics.checkNotNullParameter(r6, "expectedChangeSeqs");
        Intrinsics.checkNotNullParameter(r5, "hotWords");
        this.operationId = r10;
        this.businessId = r11;
        this.writePurpose = r12;
        this.requeueKeeperId = r13;
        this.operateType = r14;
        this.entityIds = r4;
        this.expectedChangeSeqs = r6;
        this.entity = r17;
        this.hotWords = r5;
        this.retractionReason = r19;
        this.allowDuplicateMerge = r20;
        this.migrationOperation = r21;
        this.reuseSource = r22;
        this.writeRetraction = r23;
    }

    public /* synthetic */ SemanticBatchOperation(String r16, String r17, String r18, String r19, String r20, List r21, Map r22, SemanticBatchEntityPayload r23, List r24, String r25, boolean r26, boolean r27, boolean r28, boolean r29, int r30, DefaultConstructorMarker r31) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        String r5 = null;
        if ((r30 & 1) == 0) goto L5;
        String r4 = null;
    L6:
        String r7 = "";
        if ((r30 & 2) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r30 & 16) != 0) goto L23;
        r7 = r20;
    L23:
        if ((r30 & 32) == 0) goto L26;
        r1 = CollectionsKt.emptyList();
    L26:
        if ((r30 & 64) == 0) goto L29;
        r3 = MapsKt.emptyMap();
    L29:
        if ((r30 & 128) == 0) goto L31;
        SemanticBatchEntityPayload r10 = null;
    L33:
        if ((r30 & 256) == 0) goto L36;
        r2 = CollectionsKt.emptyList();
    L36:
        if ((r30 & 512) != 0) goto L39;
        r5 = r25;
    L39:
        boolean r12 = true;
        if ((r30 & 1024) == 0) goto L42;
        boolean r11 = true;
    L44:
        if ((r30 & 2048) == 0) goto L46;
        boolean r13 = false;
    L48:
        if ((r30 & 4096) == 0) goto L50;
        boolean r14 = true;
    L52:
        if ((r30 & 8192) != 0) goto L55;
        r12 = r29;
    L55:
        this(r4, r6, r8, r9, r7, r1, r3, r10, r2, r5, r11, r13, r14, r12);
        return;
    L50:
        r14 = r28;
        goto L52
    L46:
        r13 = r27;
        goto L48
    L42:
        r11 = r26;
        goto L44
    L31:
        r10 = r23;
        goto L33
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L6
    }

    public static /* synthetic */ SemanticBatchOperation copy$default(SemanticBatchOperation r15, String r16, String r17, String r18, String r19, String r20, List r21, Map r22, SemanticBatchEntityPayload r23, List r24, String r25, boolean r26, boolean r27, boolean r28, boolean r29, int r30, Object r31) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Map<String, Long> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        if ((r30 & 1) == 0) goto L5;
        String r5 = r15.operationId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r6 = r15.businessId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r7 = r15.writePurpose;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r8 = r15.requeueKeeperId;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r9 = r15.operateType;
    L23:
        if ((r30 & 32) == 0) goto L26;
        r2 = r15.entityIds;
    L26:
        if ((r30 & 64) == 0) goto L29;
        r4 = r15.expectedChangeSeqs;
    L29:
        if ((r30 & 128) == 0) goto L31;
        SemanticBatchEntityPayload r10 = r15.entity;
    L33:
        if ((r30 & 256) == 0) goto L36;
        r3 = r15.hotWords;
    L36:
        if ((r30 & 512) == 0) goto L38;
        String r11 = r15.retractionReason;
    L40:
        if ((r30 & 1024) == 0) goto L42;
        boolean r12 = r15.allowDuplicateMerge;
    L44:
        if ((r30 & 2048) == 0) goto L46;
        boolean r13 = r15.migrationOperation;
    L48:
        if ((r30 & 4096) == 0) goto L50;
        boolean r14 = r15.reuseSource;
    L52:
        if ((r30 & 8192) == 0) goto L54;
        boolean r1 = r15.writeRetraction;
    L56:
        return r15.copy(r5, r6, r7, r8, r9, r2, r4, r10, r3, r11, r12, r13, r14, r1);
    L54:
        r1 = r29;
        goto L56
    L50:
        r14 = r28;
        goto L52
    L46:
        r13 = r27;
        goto L48
    L42:
        r12 = r26;
        goto L44
    L38:
        r11 = r25;
        goto L40
    L31:
        r10 = r23;
        goto L33
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    public final String component1() {
        return this.operationId;
    }

    public final String component10() {
        return this.retractionReason;
    }

    public final boolean component11() {
        return this.allowDuplicateMerge;
    }

    public final boolean component12() {
        return this.migrationOperation;
    }

    public final boolean component13() {
        return this.reuseSource;
    }

    public final boolean component14() {
        return this.writeRetraction;
    }

    public final String component2() {
        return this.businessId;
    }

    public final String component3() {
        return this.writePurpose;
    }

    public final String component4() {
        return this.requeueKeeperId;
    }

    public final String component5() {
        return this.operateType;
    }

    public final List<String> component6() {
        return this.entityIds;
    }

    public final Map<String, Long> component7() {
        return this.expectedChangeSeqs;
    }

    public final SemanticBatchEntityPayload component8() {
        return this.entity;
    }

    public final List<String> component9() {
        return this.hotWords;
    }

    public final SemanticBatchOperation copy(String r18, String r19, String r20, String r21, String r22, List<String> r23, Map<String, Long> r24, SemanticBatchEntityPayload r25, List<String> r26, String r27, boolean r28, boolean r29, boolean r30, boolean r31) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "businessId");
        Intrinsics.checkNotNullParameter(r20, "writePurpose");
        Intrinsics.checkNotNullParameter(r22, "operateType");
        Intrinsics.checkNotNullParameter(r8, "entityIds");
        Intrinsics.checkNotNullParameter(r9, "expectedChangeSeqs");
        Intrinsics.checkNotNullParameter(r11, "hotWords");
        return new SemanticBatchOperation(r18, r19, r20, r21, r22, r8, r9, r25, r11, r27, r28, r29, r30, r31);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticBatchOperation.class) == true) goto L8;
        return false;
    L8:
        SemanticBatchOperation r6 = (SemanticBatchOperation) ZeusTransformUtils.preCheckCast(r5, SemanticBatchOperation.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.operationId, r6.operationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.businessId, r6.businessId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.writePurpose, r6.writePurpose) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.requeueKeeperId, r6.requeueKeeperId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.operateType, r6.operateType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.entityIds, r6.entityIds) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.expectedChangeSeqs, r6.expectedChangeSeqs) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.entity, r6.entity) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.hotWords, r6.hotWords) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.retractionReason, r6.retractionReason) == true) goto L39;
        return false;
    L39:
        if (this.allowDuplicateMerge == r6.allowDuplicateMerge) goto L42;
        return false;
    L42:
        if (this.migrationOperation == r6.migrationOperation) goto L45;
        return false;
    L45:
        if (this.reuseSource == r6.reuseSource) goto L48;
        return false;
    L48:
        if (this.writeRetraction == r6.writeRetraction) goto L50;
        return false;
    L50:
        return true;
    }

    public final boolean getAllowDuplicateMerge() {
        return this.allowDuplicateMerge;
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final SemanticBatchEntityPayload getEntity() {
        return this.entity;
    }

    public final List<String> getEntityIds() {
        return this.entityIds;
    }

    public final Map<String, Long> getExpectedChangeSeqs() {
        return this.expectedChangeSeqs;
    }

    public final List<String> getHotWords() {
        return this.hotWords;
    }

    public final boolean getMigrationOperation() {
        return this.migrationOperation;
    }

    public final String getOperateType() {
        return this.operateType;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getRequeueKeeperId() {
        return this.requeueKeeperId;
    }

    public final String getRetractionReason() {
        return this.retractionReason;
    }

    public final boolean getReuseSource() {
        return this.reuseSource;
    }

    public final String getWritePurpose() {
        return this.writePurpose;
    }

    public final boolean getWriteRetraction() {
        return this.writeRetraction;
    }

    public int hashCode() {
        String r0 = this.operationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.businessId.hashCode()) * 31) + this.writePurpose.hashCode()) * 31;
        String r4 = this.requeueKeeperId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((r3 + r5) * 31) + this.operateType.hashCode()) * 31) + this.entityIds.hashCode()) * 31) + this.expectedChangeSeqs.hashCode()) * 31;
        SemanticBatchEntityPayload r7 = this.entity;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.hotWords.hashCode()) * 31;
        String r10 = this.retractionReason;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((((((((r9 + r1) * 31) + Boolean.hashCode(this.allowDuplicateMerge)) * 31) + Boolean.hashCode(this.migrationOperation)) * 31) + Boolean.hashCode(this.reuseSource)) * 31) + Boolean.hashCode(this.writeRetraction);
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String stableId(int r3) {
        String r2 = this.operationId;
        if (r2 == null) goto L10;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return String.valueOf(r3);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SemanticBatchOperation(operationId=").append(this.operationId).append(", businessId=").append(this.businessId).append(", writePurpose=").append(this.writePurpose).append(", requeueKeeperId=").append(this.requeueKeeperId).append(", operateType=").append(this.operateType).append(", entityIds=").append(this.entityIds).append(", expectedChangeSeqs=").append(this.expectedChangeSeqs).append(", entity=").append(this.entity).append(", hotWords=").append(this.hotWords).append(", retractionReason=").append(this.retractionReason).append(", allowDuplicateMerge=").append(this.allowDuplicateMerge).append(", migrationOperation=");
        r0.append(this.migrationOperation).append(", reuseSource=").append(this.reuseSource).append(", writeRetraction=").append(this.writeRetraction).append(')');
        return r0.toString();
    }
}
