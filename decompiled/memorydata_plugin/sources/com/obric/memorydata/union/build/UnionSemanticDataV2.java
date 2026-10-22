package com.obric.memorydata.union.build;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001Bû\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0012\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b%\u0010&J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010Y\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00103J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010b\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aHÆ\u0003J\u0019\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aHÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u009c\u0003\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020\r2\b\u0010q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010r\u001a\u00020\u000bHÖ\u0001J\t\u0010s\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00108\u001a\u0004\b9\u00107R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b>\u00100R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b?\u00100R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010(R!\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR!\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010-R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010-R\u0011\u0010N\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006t"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticDataV2;", "", "description", "", "keyPhrase", "tagPath", "semanticType", "entityIdList", "", "sources", "evidenceCount", "", "userEdit", "", "contentFrom", "createTime", "", "modifyTime", "businessType", "action", ObricMemoryConstants.KEY_SESSION_ID, "logId", "poisonLabel", "poisonLabelVersion", ObricMemoryConstants.KEY_PACKAGE_NAME, "relevantData", "", "sourceInfo", "sceneIds", "importantRawRefIds", "sourceRawRefIds", "sourcePackageName", "confidence", "", "evidenceIds", "hotWords", "conflictEntityIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getKeyPhrase", "getTagPath", "getSemanticType", "getEntityIdList", "()Ljava/util/List;", "getSources", "getEvidenceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserEdit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getContentFrom", "getCreateTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getModifyTime", "getBusinessType", "getAction", "getSessionId", "getLogId", "getPoisonLabel", "getPoisonLabelVersion", "getPackageName", "getRelevantData", "()Ljava/util/Map;", "getSourceInfo", "getSceneIds", "getImportantRawRefIds", "getSourceRawRefIds", "getSourcePackageName", "getConfidence", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEvidenceIds", "getHotWords", "getConflictEntityIds", "actionType", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "getActionType", "()Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/obric/memorydata/union/build/UnionSemanticDataV2;", "equals", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionSemanticDataV2 {
    private final String action;
    private final String businessType;
    private final Float confidence;

    @SerializedName(alternate = {"conflict_entity_ids"}, value = "conflictEntityIds")
    private final List<String> conflictEntityIds;
    private final String contentFrom;
    private final Long createTime;
    private final String description;
    private final List<String> entityIdList;
    private final Integer evidenceCount;

    @SerializedName(alternate = {"evidence_ids"}, value = "evidenceIds")
    private final List<String> evidenceIds;

    @SerializedName(alternate = {"hot_words"}, value = "hotWords")
    private final List<String> hotWords;

    @SerializedName(alternate = {"important_raw_ref_ids", "important_raw_ref_id_list", "importantRawRefIdList"}, value = "importantRawRefIds")
    private final List<String> importantRawRefIds;
    private final String keyPhrase;
    private final String logId;
    private final Long modifyTime;
    private final String packageName;
    private final Integer poisonLabel;
    private final Integer poisonLabelVersion;
    private final Map<String, Object> relevantData;

    @SerializedName(alternate = {"scene_ids", "scene_id_list", "sceneIdList"}, value = "sceneIds")
    private final List<String> sceneIds;
    private final String semanticType;
    private final String sessionId;
    private final Map<String, Object> sourceInfo;

    @SerializedName(alternate = {"source_package_name", "source_package_names", "sourcePackageNames"}, value = "sourcePackageName")
    private final List<String> sourcePackageName;

    @SerializedName(alternate = {"source_raw_ref_ids", "source_raw_ref_id_list", "sourceRawRefIdList"}, value = "sourceRawRefIds")
    private final List<String> sourceRawRefIds;
    private final String sources;
    private final String tagPath;
    private final Boolean userEdit;

    public UnionSemanticDataV2(String r17, String r18, String r19, String r20, List<String> r21, String r22, Integer r23, Boolean r24, String r25, Long r26, Long r27, String r28, String r29, String r30, String r31, Integer r32, Integer r33, String r34, Map<String, ? extends Object> r35, Map<String, ? extends Object> r36, List<String> r37, List<String> r38, List<String> r39, List<String> r40, Float r41, List<String> r42, List<String> r43, List<String> r44) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.memorydata.plugin");
        Map<String, Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r37, List.class, "com.obric.memorydata.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        List<String> r110 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r44, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "description");
        Intrinsics.checkNotNullParameter(r18, "keyPhrase");
        Intrinsics.checkNotNullParameter(r19, "tagPath");
        Intrinsics.checkNotNullParameter(r20, "semanticType");
        Intrinsics.checkNotNullParameter(r25, "contentFrom");
        Intrinsics.checkNotNullParameter(r28, "businessType");
        Intrinsics.checkNotNullParameter(r29, "action");
        this.description = r17;
        this.keyPhrase = r18;
        this.tagPath = r19;
        this.semanticType = r20;
        this.entityIdList = r8;
        this.sources = r22;
        this.evidenceCount = r23;
        this.userEdit = r24;
        this.contentFrom = r25;
        this.createTime = r26;
        this.modifyTime = r27;
        this.businessType = r28;
        this.action = r29;
        this.sessionId = r30;
        this.logId = r31;
        this.poisonLabel = r32;
        this.poisonLabelVersion = r33;
        this.packageName = r34;
        this.relevantData = r10;
        this.sourceInfo = r11;
        this.sceneIds = r12;
        this.importantRawRefIds = r13;
        this.sourceRawRefIds = r14;
        this.sourcePackageName = r15;
        this.confidence = r41;
        this.evidenceIds = r16;
        this.hotWords = r110;
        this.conflictEntityIds = r9;
    }

    public /* synthetic */ UnionSemanticDataV2(String r33, String r34, String r35, String r36, List r37, String r38, Integer r39, Boolean r40, String r41, Long r42, Long r43, String r44, String r45, String r46, String r47, Integer r48, Integer r49, String r50, Map r51, Map r52, List r53, List r54, List r55, List r56, Float r57, List r58, List r59, List r60, int r61, DefaultConstructorMarker r62) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r37, List.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r51, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r52, Map.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r53, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r54, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r55, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r56, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r58, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r59, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r60, List.class, "com.obric.memorydata.plugin");
        if ((r61 & 8192) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r61 & 16384) == 0) goto L9;
        String r18 = null;
    L11:
        if ((32768 & r61) == 0) goto L13;
        Integer r19 = null;
    L15:
        if ((65536 & r61) == 0) goto L17;
        Integer r20 = null;
    L19:
        if ((131072 & r61) == 0) goto L21;
        String r21 = null;
    L23:
        if ((262144 & r61) == 0) goto L25;
        Map r22 = null;
    L27:
        if ((524288 & r61) == 0) goto L29;
        Map r23 = null;
    L31:
        if ((1048576 & r61) == 0) goto L33;
        List r24 = null;
    L35:
        if ((2097152 & r61) == 0) goto L37;
        List r25 = null;
    L39:
        if ((4194304 & r61) == 0) goto L41;
        List r26 = null;
    L43:
        if ((8388608 & r61) == 0) goto L45;
        List r27 = null;
    L47:
        if ((16777216 & r61) == 0) goto L49;
        Float r28 = null;
    L51:
        if ((33554432 & r61) == 0) goto L53;
        List r29 = null;
    L55:
        if ((67108864 & r61) == 0) goto L57;
        List r30 = null;
    L59:
        if ((r61 & 134217728) == 0) goto L61;
        List r31 = null;
    L62:
        this(r33, r34, r35, r36, r8, r38, r39, r40, r41, r42, r43, r44, r45, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
        return;
    L61:
        r31 = r2;
        goto L62
    L57:
        r30 = r10;
        goto L59
    L53:
        r29 = r9;
        goto L55
    L49:
        r28 = r57;
        goto L51
    L45:
        r27 = r7;
        goto L47
    L41:
        r26 = r6;
        goto L43
    L37:
        r25 = r5;
        goto L39
    L33:
        r24 = r4;
        goto L35
    L29:
        r23 = r3;
        goto L31
    L25:
        r22 = r1;
        goto L27
    L21:
        r21 = r50;
        goto L23
    L17:
        r20 = r49;
        goto L19
    L13:
        r19 = r48;
        goto L15
    L9:
        r18 = r47;
        goto L11
    L5:
        r17 = r46;
        goto L7
    }

    public static /* synthetic */ UnionSemanticDataV2 copy$default(UnionSemanticDataV2 r17, String r18, String r19, String r20, String r21, List r22, String r23, Integer r24, Boolean r25, String r26, Long r27, Long r28, String r29, String r30, String r31, String r32, Integer r33, Integer r34, String r35, Map r36, Map r37, List r38, List r39, List r40, List r41, Float r42, List r43, List r44, List r45, int r46, Object r47) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r37, Map.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r44, List.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.memorydata.plugin");
        if ((r46 & 1) == 0) goto L5;
        String r12 = r17.description;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r13 = r17.keyPhrase;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r14 = r17.tagPath;
    L15:
        if ((r46 & 8) == 0) goto L17;
        String r15 = r17.semanticType;
    L19:
        if ((r46 & 16) == 0) goto L22;
        r2 = r17.entityIdList;
    L22:
        if ((r46 & 32) == 0) goto L24;
        String r16 = r17.sources;
    L26:
        if ((r46 & 64) == 0) goto L28;
        Integer r48 = r17.evidenceCount;
    L30:
        if ((r46 & 128) == 0) goto L32;
        Boolean r49 = r17.userEdit;
    L34:
        if ((r46 & 256) == 0) goto L36;
        String r50 = r17.contentFrom;
    L38:
        if ((r46 & 512) == 0) goto L40;
        Long r51 = r17.createTime;
    L42:
        if ((r46 & 1024) == 0) goto L44;
        Long r52 = r17.modifyTime;
    L46:
        if ((r46 & 2048) == 0) goto L48;
        String r53 = r17.businessType;
    L50:
        if ((r46 & 4096) == 0) goto L52;
        String r110 = r17.action;
    L54:
        if ((r46 & 8192) == 0) goto L56;
        String r111 = r17.sessionId;
    L57:
        String r310 = r111;
        if ((r46 & 16384) == 0) goto L60;
        String r112 = r17.logId;
    L61:
        String r311 = r112;
        if ((r46 & 32768) == 0) goto L64;
        Integer r113 = r17.poisonLabel;
    L65:
        Integer r312 = r113;
        if ((r46 & 65536) == 0) goto L68;
        Integer r114 = r17.poisonLabelVersion;
    L69:
        Integer r313 = r114;
        if ((r46 & 131072) == 0) goto L72;
        String r115 = r17.packageName;
    L73:
        String r314 = r115;
        if ((r46 & 262144) == 0) goto L76;
        Map<String, ? extends Object> r116 = r17.relevantData;
    L77:
        Map<String, ? extends Object> r315 = r116;
        if ((r46 & 524288) == 0) goto L80;
        Map<String, ? extends Object> r117 = r17.sourceInfo;
    L81:
        Map<String, ? extends Object> r316 = r117;
        if ((r46 & 1048576) == 0) goto L84;
        List<String> r118 = r17.sceneIds;
    L85:
        List<String> r317 = r118;
        if ((r46 & 2097152) == 0) goto L88;
        List<String> r119 = r17.importantRawRefIds;
    L89:
        List<String> r318 = r119;
        if ((r46 & 4194304) == 0) goto L92;
        List<String> r120 = r17.sourceRawRefIds;
    L93:
        List<String> r410 = r120;
        if ((r46 & 8388608) == 0) goto L96;
        List<String> r121 = r17.sourcePackageName;
    L97:
        List<String> r411 = r121;
        if ((r46 & 16777216) == 0) goto L100;
        Float r122 = r17.confidence;
    L101:
        Float r412 = r122;
        if ((r46 & 33554432) == 0) goto L104;
        List<String> r123 = r17.evidenceIds;
    L105:
        List<String> r413 = r123;
        if ((r46 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L108;
        List<String> r124 = r17.hotWords;
    L110:
        if ((r46 & 134217728) == 0) goto L112;
        List<String> r1 = r17.conflictEntityIds;
    L114:
        return r17.copy(r12, r13, r14, r15, r2, r16, r48, r49, r50, r51, r52, r53, r110, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r124, r1);
    L112:
        r1 = r3;
        goto L114
    L108:
        r124 = r11;
        goto L110
    L104:
        r123 = r10;
        goto L105
    L100:
        r122 = r42;
        goto L101
    L96:
        r121 = r9;
        goto L97
    L92:
        r120 = r8;
        goto L93
    L88:
        r119 = r7;
        goto L89
    L84:
        r118 = r6;
        goto L85
    L80:
        r117 = r5;
        goto L81
    L76:
        r116 = r4;
        goto L77
    L72:
        r115 = r35;
        goto L73
    L68:
        r114 = r34;
        goto L69
    L64:
        r113 = r33;
        goto L65
    L60:
        r112 = r32;
        goto L61
    L56:
        r111 = r31;
        goto L57
    L52:
        r110 = r30;
        goto L54
    L48:
        r53 = r29;
        goto L50
    L44:
        r52 = r28;
        goto L46
    L40:
        r51 = r27;
        goto L42
    L36:
        r50 = r26;
        goto L38
    L32:
        r49 = r25;
        goto L34
    L28:
        r48 = r24;
        goto L30
    L24:
        r16 = r23;
        goto L26
    L17:
        r15 = r21;
        goto L19
    L13:
        r14 = r20;
        goto L15
    L9:
        r13 = r19;
        goto L11
    L5:
        r12 = r18;
        goto L7
    }

    public final String component1() {
        return this.description;
    }

    public final Long component10() {
        return this.createTime;
    }

    public final Long component11() {
        return this.modifyTime;
    }

    public final String component12() {
        return this.businessType;
    }

    public final String component13() {
        return this.action;
    }

    public final String component14() {
        return this.sessionId;
    }

    public final String component15() {
        return this.logId;
    }

    public final Integer component16() {
        return this.poisonLabel;
    }

    public final Integer component17() {
        return this.poisonLabelVersion;
    }

    public final String component18() {
        return this.packageName;
    }

    public final Map<String, Object> component19() {
        return this.relevantData;
    }

    public final String component2() {
        return this.keyPhrase;
    }

    public final Map<String, Object> component20() {
        return this.sourceInfo;
    }

    public final List<String> component21() {
        return this.sceneIds;
    }

    public final List<String> component22() {
        return this.importantRawRefIds;
    }

    public final List<String> component23() {
        return this.sourceRawRefIds;
    }

    public final List<String> component24() {
        return this.sourcePackageName;
    }

    public final Float component25() {
        return this.confidence;
    }

    public final List<String> component26() {
        return this.evidenceIds;
    }

    public final List<String> component27() {
        return this.hotWords;
    }

    public final List<String> component28() {
        return this.conflictEntityIds;
    }

    public final String component3() {
        return this.tagPath;
    }

    public final String component4() {
        return this.semanticType;
    }

    public final List<String> component5() {
        return this.entityIdList;
    }

    public final String component6() {
        return this.sources;
    }

    public final Integer component7() {
        return this.evidenceCount;
    }

    public final Boolean component8() {
        return this.userEdit;
    }

    public final String component9() {
        return this.contentFrom;
    }

    public final UnionSemanticDataV2 copy(String r32, String r33, String r34, String r35, List<String> r36, String r37, Integer r38, Boolean r39, String r40, Long r41, Long r42, String r43, String r44, String r45, String r46, Integer r47, Integer r48, String r49, Map<String, ? extends Object> r50, Map<String, ? extends Object> r51, List<String> r52, List<String> r53, List<String> r54, List<String> r55, Float r56, List<String> r57, List<String> r58, List<String> r59) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r36, List.class, "com.obric.memorydata.plugin");
        Map r19 = (Map) ZeusTransformUtils.wrapperContextForParams(r50, Map.class, "com.obric.memorydata.plugin");
        Map r20 = (Map) ZeusTransformUtils.wrapperContextForParams(r51, Map.class, "com.obric.memorydata.plugin");
        List r21 = (List) ZeusTransformUtils.wrapperContextForParams(r52, List.class, "com.obric.memorydata.plugin");
        List r22 = (List) ZeusTransformUtils.wrapperContextForParams(r53, List.class, "com.obric.memorydata.plugin");
        List r23 = (List) ZeusTransformUtils.wrapperContextForParams(r54, List.class, "com.obric.memorydata.plugin");
        List r24 = (List) ZeusTransformUtils.wrapperContextForParams(r55, List.class, "com.obric.memorydata.plugin");
        List r26 = (List) ZeusTransformUtils.wrapperContextForParams(r57, List.class, "com.obric.memorydata.plugin");
        List r27 = (List) ZeusTransformUtils.wrapperContextForParams(r58, List.class, "com.obric.memorydata.plugin");
        List r28 = (List) ZeusTransformUtils.wrapperContextForParams(r59, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r32, "description");
        Intrinsics.checkNotNullParameter(r33, "keyPhrase");
        Intrinsics.checkNotNullParameter(r34, "tagPath");
        Intrinsics.checkNotNullParameter(r35, "semanticType");
        Intrinsics.checkNotNullParameter(r40, "contentFrom");
        Intrinsics.checkNotNullParameter(r43, "businessType");
        Intrinsics.checkNotNullParameter(r44, "action");
        return new UnionSemanticDataV2(r32, r33, r34, r35, r0, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r19, r20, r21, r22, r23, r24, r56, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UnionSemanticDataV2.class) == true) goto L8;
        return false;
    L8:
        UnionSemanticDataV2 r6 = (UnionSemanticDataV2) ZeusTransformUtils.preCheckCast(r5, UnionSemanticDataV2.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keyPhrase, r6.keyPhrase) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagPath, r6.tagPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.semanticType, r6.semanticType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entityIdList, r6.entityIdList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sources, r6.sources) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.evidenceCount, r6.evidenceCount) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userEdit, r6.userEdit) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.contentFrom, r6.contentFrom) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.modifyTime, r6.modifyTime) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.businessType, r6.businessType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.sessionId, r6.sessionId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poisonLabel, r6.poisonLabel) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.poisonLabelVersion, r6.poisonLabelVersion) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.relevantData, r6.relevantData) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.sourceInfo, r6.sourceInfo) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.sceneIds, r6.sceneIds) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.importantRawRefIds, r6.importantRawRefIds) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.sourceRawRefIds, r6.sourceRawRefIds) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.sourcePackageName, r6.sourcePackageName) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.confidence, r6.confidence) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.evidenceIds, r6.evidenceIds) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.hotWords, r6.hotWords) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.conflictEntityIds, r6.conflictEntityIds) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final MemoryBuildApi.Action getActionType() {
        return MemoryBuildApi.Action.Companion.a(this.action);
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final Float getConfidence() {
        return this.confidence;
    }

    public final List<String> getConflictEntityIds() {
        return this.conflictEntityIds;
    }

    public final String getContentFrom() {
        return this.contentFrom;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getEntityIdList() {
        return this.entityIdList;
    }

    public final Integer getEvidenceCount() {
        return this.evidenceCount;
    }

    public final List<String> getEvidenceIds() {
        return this.evidenceIds;
    }

    public final List<String> getHotWords() {
        return this.hotWords;
    }

    public final List<String> getImportantRawRefIds() {
        return this.importantRawRefIds;
    }

    public final String getKeyPhrase() {
        return this.keyPhrase;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Long getModifyTime() {
        return this.modifyTime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Integer getPoisonLabel() {
        return this.poisonLabel;
    }

    public final Integer getPoisonLabelVersion() {
        return this.poisonLabelVersion;
    }

    public final Map<String, Object> getRelevantData() {
        return this.relevantData;
    }

    public final List<String> getSceneIds() {
        return this.sceneIds;
    }

    public final String getSemanticType() {
        return this.semanticType;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Map<String, Object> getSourceInfo() {
        return this.sourceInfo;
    }

    public final List<String> getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final List<String> getSourceRawRefIds() {
        return this.sourceRawRefIds;
    }

    public final String getSources() {
        return this.sources;
    }

    public final String getTagPath() {
        return this.tagPath;
    }

    public final Boolean getUserEdit() {
        return this.userEdit;
    }

    public int hashCode() {
        int r0 = ((((((this.description.hashCode() * 31) + this.keyPhrase.hashCode()) * 31) + this.tagPath.hashCode()) * 31) + this.semanticType.hashCode()) * 31;
        List<String> r1 = this.entityIdList;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.sources;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.evidenceCount;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.userEdit;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.contentFrom.hashCode()) * 31;
        Long r14 = this.createTime;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.modifyTime;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((((r16 + r18) * 31) + this.businessType.hashCode()) * 31) + this.action.hashCode()) * 31;
        String r20 = this.sessionId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.logId;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Integer r26 = this.poisonLabel;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.poisonLabelVersion;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.packageName;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        Map<String, Object> r35 = this.relevantData;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        Map<String, Object> r38 = this.sourceInfo;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        List<String> r41 = this.sceneIds;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        List<String> r44 = this.importantRawRefIds;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        List<String> r47 = this.sourceRawRefIds;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        List<String> r50 = this.sourcePackageName;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        Float r53 = this.confidence;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        List<String> r56 = this.evidenceIds;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        List<String> r59 = this.hotWords;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        List<String> r62 = this.conflictEntityIds;
        if (r62 == null) goto L87;
        r2 = r62.hashCode();
    L87:
        return r61 + r2;
    L81:
        r60 = r59.hashCode();
        goto L82
    L77:
        r57 = r56.hashCode();
        goto L78
    L73:
        r54 = r53.hashCode();
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UnionSemanticDataV2(description=").append(this.description).append(", keyPhrase=").append(this.keyPhrase).append(", tagPath=").append(this.tagPath).append(", semanticType=").append(this.semanticType).append(", entityIdList=").append(this.entityIdList).append(", sources=").append(this.sources).append(", evidenceCount=").append(this.evidenceCount).append(", userEdit=").append(this.userEdit).append(", contentFrom=").append(this.contentFrom).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", businessType=");
        r0.append(this.businessType).append(", action=").append(this.action).append(", sessionId=").append(this.sessionId).append(", logId=").append(this.logId).append(", poisonLabel=").append(this.poisonLabel).append(", poisonLabelVersion=").append(this.poisonLabelVersion).append(", packageName=").append(this.packageName).append(", relevantData=").append(this.relevantData).append(", sourceInfo=").append(this.sourceInfo).append(", sceneIds=").append(this.sceneIds).append(", importantRawRefIds=").append(this.importantRawRefIds).append(", sourceRawRefIds=").append(this.sourceRawRefIds);
        r0.append(", sourcePackageName=").append(this.sourcePackageName).append(", confidence=").append(this.confidence).append(", evidenceIds=").append(this.evidenceIds).append(", hotWords=").append(this.hotWords).append(", conflictEntityIds=").append(this.conflictEntityIds).append(')');
        return r0.toString();
    }
}
