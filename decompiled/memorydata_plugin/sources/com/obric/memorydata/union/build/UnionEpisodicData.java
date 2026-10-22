package com.obric.memorydata.union.build;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.api.MemoryBuildApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0083\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u0012\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d¢\u0006\u0004\b$\u0010%J\b\u0010O\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010:\u001a\u0004\b;\u00109R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010:\u001a\u0004\b<\u00109R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00103\u001a\u0004\b=\u00102R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010'R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010:\u001a\u0004\bA\u00109R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010:\u001a\u0004\bB\u00109R!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR!\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010,R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010,R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R$\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010DR\u0011\u0010K\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/obric/memorydata/union/build/UnionEpisodicData;", "", "title", "", Params.CONTENT, "contentFrom", "observation", "entityIdList", "", "businessType", "action", ObricMemoryConstants.KEY_SESSION_ID, "logId", "poisonLabel", "", "poisonLabelVersion", "useLocation", "", "startTimestamp", "", "endTimestamp", "actionTimestamp", EventBody.KEY_CATEGORY, "location", "fullContent", ObricMemoryConstants.KEY_PACKAGE_NAME, "createTime", "modifyTime", "relevantData", "", "sourceInfo", "sceneIds", "importantRawRefIds", "sourceRawRefIds", "sourcePackageName", "speakerSummary", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getTitle", "()Ljava/lang/String;", "getContent", "getContentFrom", "getObservation", "getEntityIdList", "()Ljava/util/List;", "getBusinessType", "getAction", "getSessionId", "getLogId", "getPoisonLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPoisonLabelVersion", "getUseLocation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTimestamp", "getActionTimestamp", "getCategory", "getLocation", "getFullContent", "getPackageName", "getCreateTime", "getModifyTime", "getRelevantData", "()Ljava/util/Map;", "getSourceInfo", "getSceneIds", "getImportantRawRefIds", "getSourceRawRefIds", "getSourcePackageName", "getSpeakerSummary", "actionType", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "getActionType", "()Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class UnionEpisodicData {
    private final String action;
    private final Long actionTimestamp;
    private final String businessType;
    private final Integer category;
    private final String content;
    private final String contentFrom;
    private final Long createTime;
    private final Long endTimestamp;
    private final List<String> entityIdList;
    private final String fullContent;

    @SerializedName(alternate = {"important_raw_ref_ids", "important_raw_ref_id_list", "importantRawRefIdList"}, value = "importantRawRefIds")
    private final List<String> importantRawRefIds;
    private final String location;
    private final String logId;
    private final Long modifyTime;
    private final String observation;
    private final String packageName;
    private final Integer poisonLabel;
    private final Integer poisonLabelVersion;
    private final Map<String, Object> relevantData;

    @SerializedName(alternate = {"scene_ids", "scene_id_list", "sceneIdList"}, value = "sceneIds")
    private final List<String> sceneIds;
    private final String sessionId;
    private final Map<String, Object> sourceInfo;

    @SerializedName(alternate = {"source_package_name", "source_package_names", "sourcePackageNames"}, value = "sourcePackageName")
    private final List<String> sourcePackageName;

    @SerializedName(alternate = {"source_raw_ref_ids", "source_raw_ref_id_list", "sourceRawRefIdList"}, value = "sourceRawRefIds")
    private final List<String> sourceRawRefIds;

    @SerializedName(alternate = {"speaker_summary"}, value = "speakerSummary")
    private final Map<String, String> speakerSummary;
    private final Long startTimestamp;
    private final String title;
    private final Boolean useLocation;

    public UnionEpisodicData(String r17, String r18, String r19, String r20, List<String> r21, String r22, String r23, String r24, String r25, Integer r26, Integer r27, Boolean r28, Long r29, Long r30, Long r31, Integer r32, String r33, String r34, String r35, Long r36, Long r37, Map<String, ? extends Object> r38, Map<String, ? extends Object> r39, List<String> r40, List<String> r41, List<String> r42, List<String> r43, Map<String, String> r44) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r38, Map.class, "com.obric.memorydata.plugin");
        Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r39, Map.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r44, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r19, "contentFrom");
        Intrinsics.checkNotNullParameter(r20, "observation");
        Intrinsics.checkNotNullParameter(r22, "businessType");
        Intrinsics.checkNotNullParameter(r23, "action");
        this.title = r17;
        this.content = r18;
        this.contentFrom = r19;
        this.observation = r20;
        this.entityIdList = r7;
        this.businessType = r22;
        this.action = r23;
        this.sessionId = r24;
        this.logId = r25;
        this.poisonLabel = r26;
        this.poisonLabelVersion = r27;
        this.useLocation = r28;
        this.startTimestamp = r29;
        this.endTimestamp = r30;
        this.actionTimestamp = r31;
        this.category = r32;
        this.location = r33;
        this.fullContent = r34;
        this.packageName = r35;
        this.createTime = r36;
        this.modifyTime = r37;
        this.relevantData = r9;
        this.sourceInfo = r10;
        this.sceneIds = r11;
        this.importantRawRefIds = r12;
        this.sourceRawRefIds = r13;
        this.sourcePackageName = r14;
        this.speakerSummary = r8;
    }

    public /* synthetic */ UnionEpisodicData(String r33, String r34, String r35, String r36, List r37, String r38, String r39, String r40, String r41, Integer r42, Integer r43, Boolean r44, Long r45, Long r46, Long r47, Integer r48, String r49, String r50, String r51, Long r52, Long r53, Map r54, Map r55, List r56, List r57, List r58, List r59, Map r60, int r61, DefaultConstructorMarker r62) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r37, List.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r54, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r55, Map.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r56, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r57, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r58, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r59, List.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r60, Map.class, "com.obric.memorydata.plugin");
        if ((r61 & 128) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r61 & 256) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r61 & 512) == 0) goto L13;
        Integer r13 = null;
    L15:
        if ((r61 & 1024) == 0) goto L17;
        Integer r14 = null;
    L19:
        if ((r61 & 2048) == 0) goto L21;
        Boolean r15 = null;
    L23:
        if ((r61 & 4096) == 0) goto L25;
        Long r16 = null;
    L27:
        if ((r61 & 8192) == 0) goto L29;
        Long r17 = null;
    L31:
        if ((r61 & 16384) == 0) goto L33;
        Long r18 = null;
    L35:
        if ((32768 & r61) == 0) goto L37;
        Integer r19 = null;
    L39:
        if ((65536 & r61) == 0) goto L41;
        String r20 = null;
    L43:
        if ((131072 & r61) == 0) goto L45;
        String r21 = null;
    L47:
        if ((262144 & r61) == 0) goto L49;
        String r22 = null;
    L51:
        if ((524288 & r61) == 0) goto L53;
        Long r23 = null;
    L55:
        if ((1048576 & r61) == 0) goto L57;
        Long r24 = null;
    L59:
        if ((2097152 & r61) == 0) goto L61;
        Map r25 = null;
    L63:
        if ((4194304 & r61) == 0) goto L65;
        Map r26 = null;
    L67:
        if ((8388608 & r61) == 0) goto L69;
        List r27 = null;
    L71:
        if ((16777216 & r61) == 0) goto L73;
        List r28 = null;
    L75:
        if ((33554432 & r61) == 0) goto L77;
        List r29 = null;
    L79:
        if ((67108864 & r61) == 0) goto L81;
        List r30 = null;
    L83:
        if ((r61 & 134217728) == 0) goto L85;
        Map r31 = null;
    L86:
        this(r33, r34, r35, r36, r8, r38, r39, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
        return;
    L85:
        r31 = r2;
        goto L86
    L81:
        r30 = r7;
        goto L83
    L77:
        r29 = r6;
        goto L79
    L73:
        r28 = r5;
        goto L75
    L69:
        r27 = r4;
        goto L71
    L65:
        r26 = r3;
        goto L67
    L61:
        r25 = r1;
        goto L63
    L57:
        r24 = r53;
        goto L59
    L53:
        r23 = r52;
        goto L55
    L49:
        r22 = r51;
        goto L51
    L45:
        r21 = r50;
        goto L47
    L41:
        r20 = r49;
        goto L43
    L37:
        r19 = r48;
        goto L39
    L33:
        r18 = r47;
        goto L35
    L29:
        r17 = r46;
        goto L31
    L25:
        r16 = r45;
        goto L27
    L21:
        r15 = r44;
        goto L23
    L17:
        r14 = r43;
        goto L19
    L13:
        r13 = r42;
        goto L15
    L9:
        r12 = r41;
        goto L11
    L5:
        r11 = r40;
        goto L7
    }

    public final String getAction() {
        return this.action;
    }

    public final Long getActionTimestamp() {
        return this.actionTimestamp;
    }

    public final MemoryBuildApi.Action getActionType() {
        return MemoryBuildApi.Action.Companion.a(this.action);
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final Integer getCategory() {
        return this.category;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentFrom() {
        return this.contentFrom;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final List<String> getEntityIdList() {
        return this.entityIdList;
    }

    public final String getFullContent() {
        return this.fullContent;
    }

    public final List<String> getImportantRawRefIds() {
        return this.importantRawRefIds;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Long getModifyTime() {
        return this.modifyTime;
    }

    public final String getObservation() {
        return this.observation;
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

    public final Map<String, String> getSpeakerSummary() {
        return this.speakerSummary;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean getUseLocation() {
        return this.useLocation;
    }

    public String toString() {
        boolean r0 = m.f13098a.b(this.sourceInfo);
        StringBuilder r1 = new StringBuilder();
        r1.append("UnionEpisodicData(title='").append(this.title).append("', content='").append(this.content).append("', contentFrom='").append(this.contentFrom).append("', observation='").append(this.observation).append("', entityIdList=").append(this.entityIdList).append(", businessType='").append(this.businessType).append("', action='").append(this.action).append("', sessionId='").append(this.sessionId).append("', logId='").append(this.logId).append("', useLocation=").append(this.useLocation).append(", startTimestamp=").append(this.startTimestamp).append(", endTimestamp=");
        StringBuilder r2 = r1.append(this.endTimestamp).append(", actionTimestamp=").append(this.actionTimestamp).append(", category=").append(this.category).append(", location=").append(this.location).append(", fullContent='").append(this.fullContent).append("', packageName='").append(this.packageName).append("', createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", relevantData=").append(this.relevantData).append(", hasSource=").append(r0).append(", sourceRawRefCount=");
        List<String> r3 = this.sourceRawRefIds;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.size();
    L6:
        StringBuilder r6 = r2.append(r5).append(", sceneCount=");
        List<String> r7 = this.sceneIds;
        if (r7 == null) goto L9;
        r4 = r7.size();
    L9:
        r6.append(r4);
        r1.append(')');
        return r1.toString();
    L5:
        r5 = 0;
        goto L6
    }
}
