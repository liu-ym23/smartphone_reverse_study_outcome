package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeAutoMemoryProEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bB\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 v2\u00020\u0001:\u0001vBá\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u00020NH\u0014J\u001a\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u0005H\u0016J\u0012\u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020WH\u0016J\f\u0010X\u001a\u00020Y*\u00020\u0005H\u0002J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\tHÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0005HÆ\u0003J\t\u0010i\u001a\u00020\tHÆ\u0003J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jã\u0001\u0010o\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010sHÖ\u0003J\t\u0010t\u001a\u00020\tHÖ\u0001J\t\u0010u\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001e\u0010\u0007\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001e\u0010\b\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001e\u0010\u000b\u001a\u00020\t8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R \u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001dR\u001e\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u0010#R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010!\"\u0004\b:\u0010#R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010!\"\u0004\b<\u0010#R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u001e\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010!\"\u0004\bD\u0010#R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010!\"\u0004\bF\u0010#R\u001e\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010!\"\u0004\bH\u0010#R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010!\"\u0004\bJ\u0010#¨\u0006w"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "ruleId", "timestamp", "title", Params.CONTENT, "subtitle", InfoRequestQPSOptTraceLogger.REASON, "logId", "traceId", "packageNames", "episodicIds", "semanticIds", "rawObservationIds", "fullContent", "<init>", "(JLjava/lang/String;JJILjava/lang/String;ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getCreateTime", "setCreateTime", "getModifyTime", "setModifyTime", "getType", "()I", "setType", "(I)V", "getPackageName", "setPackageName", "getHashCodeValue", "setHashCodeValue", "getUuid", "setUuid", "getRuleId", "getTimestamp", "setTimestamp", "getTitle", "setTitle", "getContent", "setContent", "getSubtitle", "setSubtitle", "getReason", "setReason", "getLogId", "setLogId", "getTraceId", "setTraceId", "getPackageNames", "setPackageNames", "getEpisodicIds", "setEpisodicIds", "getSemanticIds", "setSemanticIds", "getRawObservationIds", "setRawObservationIds", "getFullContent", "setFullContent", "toJsonObject", "Lorg/json/JSONObject;", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeAutoMemoryProEntity;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "toJsonArrayOrEmpty", "Lorg/json/JSONArray;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProEntity extends d {
    public static final a Companion = null;
    public static final String IS_AUTO_MEMORY_PRO_EXTRA_KEY = "isAutoMemoryPro";
    private String content;
    private long createTime;
    private String entityId;
    private String episodicIds;
    private String fullContent;
    private int hashCodeValue;
    private long id;
    private String logId;
    private long modifyTime;
    private String packageName;
    private String packageNames;
    private String rawObservationIds;
    private String reason;
    private final long ruleId;
    private String semanticIds;
    private String subtitle;
    private long timestamp;
    private String title;
    private int traceId;
    private int type;
    private String uuid;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProEntity$Companion;", "", "<init>", "()V", "IS_AUTO_MEMORY_PRO_EXTRA_KEY", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryProEntity() {
        this(0, null, 0, 0, 0, null, 0, null, 0, 0, null, null, null, null, null, 0, null, null, null, null, null, 2097151, null);
    }

    public AutoMemoryProEntity(long r28, String r30, long r31, long r33, int r35, String r36, int r37, String r38, long r39, long r41, String r43, String r44, String r45, String r46, String r47, int r48, String r49, String r50, String r51, String r52, String r53) {
        Intrinsics.checkNotNullParameter(r30, "entityId");
        Intrinsics.checkNotNullParameter(r36, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r43, "title");
        Intrinsics.checkNotNullParameter(r44, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r45, "subtitle");
        Intrinsics.checkNotNullParameter(r46, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r47, "logId");
        Intrinsics.checkNotNullParameter(r49, "packageNames");
        Intrinsics.checkNotNullParameter(r52, "rawObservationIds");
        Integer r7 = null;
        super(r28, r30, r31, r33, r35, r41, r36, r37, r38, r7, r7, null, 3584, null);
        this.id = r28;
        this.entityId = r30;
        this.createTime = r31;
        this.modifyTime = r33;
        this.type = r35;
        this.packageName = r36;
        this.hashCodeValue = r37;
        this.uuid = r38;
        this.ruleId = r39;
        this.timestamp = r41;
        this.title = r43;
        this.content = r44;
        this.subtitle = r45;
        this.reason = r46;
        this.logId = r47;
        this.traceId = r48;
        this.packageNames = r49;
        this.episodicIds = r50;
        this.semanticIds = r51;
        this.rawObservationIds = r52;
        this.fullContent = r53;
    }

    public /* synthetic */ AutoMemoryProEntity(long r26, String r28, long r29, long r31, int r33, String r34, int r35, String r36, long r37, long r39, String r41, String r42, String r43, String r44, String r45, int r46, String r47, String r48, String r49, String r50, String r51, int r52, DefaultConstructorMarker r53) {
        if ((r52 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r52 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r52 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r52 & 8) == 0) goto L17;
        long r9 = 0;
    L19:
        if ((r52 & 16) == 0) goto L21;
        int r11 = NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED;
    L23:
        if ((r52 & 32) == 0) goto L25;
        String r12 = BuildConfig.LIBRARY_PACKAGE_NAME;
    L27:
        if ((r52 & 64) == 0) goto L29;
        int r13 = 0;
    L31:
        if ((r52 & 128) == 0) goto L33;
        String r15 = UUID.randomUUID().toString();
    L35:
        if ((r52 & 256) == 0) goto L37;
        long r2 = 0;
    L39:
        if ((r52 & 512) == 0) goto L41;
        long r16 = 0;
    L43:
        if ((r52 & 1024) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r52 & 2048) == 0) goto L49;
        String r6 = "";
    L50:
        String r410 = r6;
        if ((r52 & 4096) == 0) goto L53;
        String r8 = "";
    L54:
        String r411 = r8;
        if ((r52 & 8192) == 0) goto L57;
        String r10 = "";
    L58:
        String r412 = r10;
        if ((r52 & 16384) == 0) goto L61;
        String r17 = "";
    L63:
        if ((r52 & 32768) == 0) goto L65;
        int r18 = 0;
    L67:
        if ((r52 & 65536) == 0) goto L69;
        String r19 = "";
    L70:
        String r21 = null;
        if ((r52 & 131072) == 0) goto L73;
        String r20 = null;
    L75:
        if ((r52 & 262144) == 0) goto L77;
        String r22 = null;
    L79:
        if ((r52 & 524288) == 0) goto L81;
        String r23 = "";
    L83:
        if ((r52 & 1048576) != 0) goto L86;
        r21 = r51;
    L86:
        this(r4, r1, r7, r9, r11, r12, r13, r15, r2, r16, r14, r410, r411, r412, r17, r18, r19, r20, r22, r23, r21);
        return;
    L81:
        r23 = r50;
        goto L83
    L77:
        r22 = r49;
        goto L79
    L73:
        r20 = r48;
        goto L75
    L69:
        r19 = r47;
        goto L70
    L65:
        r18 = r46;
        goto L67
    L61:
        r17 = r45;
        goto L63
    L57:
        r10 = r44;
        goto L58
    L53:
        r8 = r43;
        goto L54
    L49:
        r6 = r42;
        goto L50
    L45:
        r14 = r41;
        goto L47
    L41:
        r16 = r39;
        goto L43
    L37:
        r2 = r37;
        goto L39
    L33:
        r15 = r36;
        goto L35
    L29:
        r13 = r35;
        goto L31
    L25:
        r12 = r34;
        goto L27
    L21:
        r11 = r33;
        goto L23
    L17:
        r9 = r31;
        goto L19
    L13:
        r7 = r29;
        goto L15
    L9:
        r1 = r28;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }

    public static /* synthetic */ AutoMemoryProEntity copy$default(AutoMemoryProEntity r17, long r18, String r20, long r21, long r23, int r25, String r26, int r27, String r28, long r29, long r31, String r33, String r34, String r35, String r36, String r37, int r38, String r39, String r40, String r41, String r42, String r43, int r44, Object r45) {
        if ((r44 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r4 = r17.entityId;
    L11:
        if ((r44 & 4) == 0) goto L13;
        long r5 = r17.createTime;
    L15:
        if ((r44 & 8) == 0) goto L17;
        long r7 = r17.modifyTime;
    L19:
        if ((r44 & 16) == 0) goto L21;
        int r9 = r17.type;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r10 = r17.packageName;
    L27:
        if ((r44 & 64) == 0) goto L29;
        int r11 = r17.hashCodeValue;
    L31:
        if ((r44 & 128) == 0) goto L33;
        String r12 = r17.uuid;
    L35:
        if ((r44 & 256) == 0) goto L37;
        long r13 = r17.ruleId;
    L38:
        long r210 = r13;
        if ((r44 & 512) == 0) goto L41;
        long r14 = r17.timestamp;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r15 = r17.title;
    L46:
        String r310 = r15;
        if ((r44 & 2048) == 0) goto L49;
        String r16 = r17.content;
    L50:
        String r311 = r16;
        if ((r44 & 4096) == 0) goto L53;
        String r19 = r17.subtitle;
    L54:
        String r312 = r19;
        if ((r44 & 8192) == 0) goto L57;
        String r110 = r17.reason;
    L58:
        String r313 = r110;
        if ((r44 & 16384) == 0) goto L61;
        String r111 = r17.logId;
    L62:
        String r314 = r111;
        if ((r44 & 32768) == 0) goto L65;
        int r112 = r17.traceId;
    L66:
        int r315 = r112;
        if ((r44 & 65536) == 0) goto L69;
        String r113 = r17.packageNames;
    L70:
        String r316 = r113;
        if ((r44 & 131072) == 0) goto L73;
        String r114 = r17.episodicIds;
    L74:
        String r46 = r114;
        if ((r44 & 262144) == 0) goto L77;
        String r115 = r17.semanticIds;
    L78:
        String r47 = r115;
        if ((r44 & 524288) == 0) goto L81;
        String r116 = r17.rawObservationIds;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        String r1 = r17.fullContent;
    L87:
        return r17.copy(r2, r4, r5, r7, r9, r10, r11, r12, r210, r14, r310, r311, r312, r313, r314, r315, r316, r46, r47, r116, r1);
    L85:
        r1 = r43;
        goto L87
    L81:
        r116 = r42;
        goto L83
    L77:
        r115 = r41;
        goto L78
    L73:
        r114 = r40;
        goto L74
    L69:
        r113 = r39;
        goto L70
    L65:
        r112 = r38;
        goto L66
    L61:
        r111 = r37;
        goto L62
    L57:
        r110 = r36;
        goto L58
    L53:
        r19 = r35;
        goto L54
    L49:
        r16 = r34;
        goto L50
    L45:
        r15 = r33;
        goto L46
    L41:
        r14 = r31;
        goto L43
    L37:
        r13 = r29;
        goto L38
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    private final JSONArray toJsonArrayOrEmpty(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONArray(r2));     // Catch: Throwable -> L4
    L6:
        JSONArray r4 = new JSONArray();
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final long component1() {
        return this.id;
    }

    public final long component10() {
        return this.timestamp;
    }

    public final String component11() {
        return this.title;
    }

    public final String component12() {
        return this.content;
    }

    public final String component13() {
        return this.subtitle;
    }

    public final String component14() {
        return this.reason;
    }

    public final String component15() {
        return this.logId;
    }

    public final int component16() {
        return this.traceId;
    }

    public final String component17() {
        return this.packageNames;
    }

    public final String component18() {
        return this.episodicIds;
    }

    public final String component19() {
        return this.semanticIds;
    }

    public final String component2() {
        return this.entityId;
    }

    public final String component20() {
        return this.rawObservationIds;
    }

    public final String component21() {
        return this.fullContent;
    }

    public final long component3() {
        return this.createTime;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.packageName;
    }

    public final int component7() {
        return this.hashCodeValue;
    }

    public final String component8() {
        return this.uuid;
    }

    public final long component9() {
        return this.ruleId;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.subtitle, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = this.content + '\n' + this.subtitle;
    L9:
        ProactiveMemoryEntity r2 = new ProactiveMemoryEntity(getEntityId(), getCreateTime(), getModifyTime(), r1, this.title);
        r2.set_packageName(getPackageName());
        r2.setUuid(getUuid());
        JSONObject r11 = new JSONObject();
        r11.put(IS_AUTO_MEMORY_PRO_EXTRA_KEY, true);
        r2.setExtraData(r11.toString());
        return (AppEntity) ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.memorydata.plugin");
    L8:
        r1 = this.content;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.d
    public /* synthetic */ AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(convertToFakeAppEntity(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public FakeAutoMemoryProEntity convertToFakeAppEntity() {
        return new FakeAutoMemoryProEntity(this);
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new w(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new v(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final AutoMemoryProEntity copy(long r29, String r31, long r32, long r34, int r36, String r37, int r38, String r39, long r40, long r42, String r44, String r45, String r46, String r47, String r48, int r49, String r50, String r51, String r52, String r53, String r54) {
        Intrinsics.checkNotNullParameter(r31, "entityId");
        Intrinsics.checkNotNullParameter(r37, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r44, "title");
        Intrinsics.checkNotNullParameter(r45, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r46, "subtitle");
        Intrinsics.checkNotNullParameter(r47, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r48, "logId");
        Intrinsics.checkNotNullParameter(r50, "packageNames");
        Intrinsics.checkNotNullParameter(r53, "rawObservationIds");
        return new AutoMemoryProEntity(r29, r31, r32, r34, r36, r37, r38, r39, r40, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProEntity.class) == true) goto L8;
        return false;
    L8:
        AutoMemoryProEntity r10 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (this.modifyTime == r10.modifyTime) goto L21;
        return false;
    L21:
        if (this.type == r10.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L27;
        return false;
    L27:
        if (this.hashCodeValue == r10.hashCodeValue) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.uuid, r10.uuid) == true) goto L33;
        return false;
    L33:
        if (this.ruleId == r10.ruleId) goto L36;
        return false;
    L36:
        if (this.timestamp == r10.timestamp) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.subtitle, r10.subtitle) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L54;
        return false;
    L54:
        if (this.traceId == r10.traceId) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.packageNames, r10.packageNames) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.episodicIds, r10.episodicIds) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.semanticIds, r10.semanticIds) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.rawObservationIds, r10.rawObservationIds) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.fullContent, r10.fullContent) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.entityId;
    }

    public final String getEpisodicIds() {
        return this.episodicIds;
    }

    public final String getFullContent() {
        return this.fullContent;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.id;
    }

    public final String getLogId() {
        return this.logId;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.packageName;
    }

    public final String getPackageNames() {
        return this.packageNames;
    }

    public final String getRawObservationIds() {
        return this.rawObservationIds;
    }

    public final String getReason() {
        return this.reason;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    public final String getSemanticIds() {
        return this.semanticIds;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTraceId() {
        return this.traceId;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.type;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r0 = ((((((((((((Long.hashCode(this.id) * 31) + this.entityId.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Integer.hashCode(this.type)) * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.hashCodeValue)) * 31;
        String r1 = this.uuid;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((((((((((r0 + r3) * 31) + Long.hashCode(this.ruleId)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.logId.hashCode()) * 31) + Integer.hashCode(this.traceId)) * 31) + this.packageNames.hashCode()) * 31;
        String r5 = this.episodicIds;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.semanticIds;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.rawObservationIds.hashCode()) * 31;
        String r11 = this.fullContent;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setEpisodicIds(String r1) {
        this.episodicIds = r1;
    }

    public final void setFullContent(String r1) {
        this.fullContent = r1;
    }

    public void setHashCodeValue(int r1) {
        this.hashCodeValue = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.id = r1;
    }

    public final void setLogId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logId = r2;
    }

    public void setModifyTime(long r1) {
        this.modifyTime = r1;
    }

    public void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setPackageNames(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageNames = r2;
    }

    public final void setRawObservationIds(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rawObservationIds = r2;
    }

    public final void setReason(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reason = r2;
    }

    public final void setSemanticIds(String r1) {
        this.semanticIds = r1;
    }

    public final void setSubtitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.subtitle = r2;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public final void setTraceId(int r1) {
        this.traceId = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.uuid = r1;
    }

    public final JSONObject toJsonObject() {
        JSONObject r0 = new JSONObject();
        r0.put(OaidModel.KEY_ID, getId());
        r0.put("entityId", getEntityId());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getModifyTime());
        r0.put("type", getType());
        r0.put(ObricMemoryConstants.KEY_PACKAGE_NAME, getPackageName());
        r0.put("hashCodeValue", getHashCodeValue());
        r0.put(Api.KEY_UUID, getUuid());
        r0.put("ruleId", this.ruleId);
        r0.put("timestamp", getTimestamp());
        r0.put("title", this.title);
        r0.put(Params.CONTENT, this.content);
        r0.put("subtitle", this.subtitle);
        r0.put(InfoRequestQPSOptTraceLogger.REASON, this.reason);
        r0.put("logId", this.logId);
        r0.put("traceId", this.traceId);
        r0.put("packageNames", this.packageNames);
        r0.put("episodicIds", this.episodicIds);
        r0.put("semanticIds", this.semanticIds);
        r0.put("rawObservationIds", toJsonArrayOrEmpty(this.rawObservationIds));
        r0.put("fullContent", this.fullContent);
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AutoMemoryProEntity(id=").append(this.id).append(", entityId=").append(this.entityId).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", ruleId=").append(this.ruleId).append(", timestamp=").append(this.timestamp).append(", title=").append(this.title).append(", content=");
        r0.append(this.content).append(", subtitle=").append(this.subtitle).append(", reason=").append(this.reason).append(", logId=").append(this.logId).append(", traceId=").append(this.traceId).append(", packageNames=").append(this.packageNames).append(", episodicIds=").append(this.episodicIds).append(", semanticIds=").append(this.semanticIds).append(", rawObservationIds=").append(this.rawObservationIds).append(", fullContent=").append(this.fullContent).append(')');
        return r0.toString();
    }
}
