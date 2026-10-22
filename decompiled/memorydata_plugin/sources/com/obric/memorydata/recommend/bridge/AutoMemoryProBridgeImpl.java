package com.obric.memorydata.recommend.bridge;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ab;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.t;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.c;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.u;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\t123456789B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J$\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J.\u0010*\u001a\u00020\u00112\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0,2\u0006\u0010%\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010$H\u0002J\u001c\u0010.\u001a\u00020\u00112\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0/H\u0002J\b\u00100\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IAutoMemoryProBridgeAPI;", "<init>", "()V", "TAG", "", "AUTO_MEMORY_PRO_V2_COLLECTION_TASK", "SOURCE_TYPE_SCREEN_OBSERVATION", "getInst", "normalizeRuleIdList", "", "", "ruleIdList", "resolveV2SourceType", "sourceType", "resolveV2SourceType$recommend_obricRelease", "onAutoMemoryProExtractFinish", "", "data", "onCreateAutoMemoryRule", "title", Params.CONTENT, "onDeleteCollectionRule", "", "ruleId", "onUpdateCollectionRule", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "onAutoMemoryProV2ExtractFinish", "onAutoMemoryProV2CollectionFinish", "onAutoMemoryProClientEvaluationStats", "getImageFilterEnable", "isAutoMemoryProEnabled", "upsertAutoMemoryPro", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$UpsertedAutoMemoryPro;", SlardarSettingsConstants.PERF_KEY_MEMORY, "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "upsertOperation", "", "Lorg/json/JSONObject;", "appendAutoMemoryProTraceOp", "traceOpsByLogId", "", "upserted", "reportAutoMemoryProCollectionTrace", "", "emptyMemoryTraceOps", "UpsertedAutoMemoryPro", "AutoMemoryProExtractResultData", "AutoMemoryProData", "AutoMemoryProV2ExtractResultData", "AutoMemoryProV2EpisodicData", "AutoMemoryProV2SemanticData", "AutoMemoryProV2EpisodicExtraData", "AutoMemoryProV2CollectionResultData", "AutoMemoryProV2RuleResultData", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProBridgeImpl implements IAutoMemoryProBridgeAPI {
    private static final String AUTO_MEMORY_PRO_V2_COLLECTION_TASK = "auto_memory_pro_cloud_v2_collection";
    public static final AutoMemoryProBridgeImpl INSTANCE = null;
    private static final String SOURCE_TYPE_SCREEN_OBSERVATION = "screen_observation";
    private static final String TAG = "AutoMemoryProBridgeImpl";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jz\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00062"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "", "ruleId", "", "memoryId", "timestamp", "title", "", "subtitle", Params.CONTENT, InfoRequestQPSOptTraceLogger.REASON, "logId", "episodicIds", "semanticIds", "<init>", "(JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRuleId", "()J", "getMemoryId", "()Ljava/lang/Long;", "setMemoryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTimestamp", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getContent", "getReason", "getLogId", "getEpisodicIds", "getSemanticIds", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProData {
        private final String content;

        @SerializedName("episodic_ids")
        private final String episodicIds;

        @SerializedName("log_id")
        private final String logId;

        @SerializedName("memory_id")
        private Long memoryId;
        private final String reason;

        @SerializedName("rule_id")
        private final long ruleId;

        @SerializedName("semantic_ids")
        private final String semanticIds;
        private final String subtitle;
        private final long timestamp;
        private final String title;

        public AutoMemoryProData(long r2, Long r4, long r5, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r7, "title");
            Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r10, InfoRequestQPSOptTraceLogger.REASON);
            Intrinsics.checkNotNullParameter(r11, "logId");
            this.ruleId = r2;
            this.memoryId = r4;
            this.timestamp = r5;
            this.title = r7;
            this.subtitle = r8;
            this.content = r9;
            this.reason = r10;
            this.logId = r11;
            this.episodicIds = r12;
            this.semanticIds = r13;
        }

        public /* synthetic */ AutoMemoryProData(long r17, Long r19, long r20, String r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
            if ((r29 & 2) == 0) goto L5;
            Long r6 = null;
        L7:
            if ((r29 & 4) == 0) goto L9;
            long r7 = 0;
        L11:
            if ((r29 & 8) == 0) goto L13;
            String r9 = "";
        L15:
            if ((r29 & 16) == 0) goto L17;
            String r10 = "";
        L19:
            if ((r29 & 32) == 0) goto L21;
            String r11 = "";
        L23:
            if ((r29 & 64) == 0) goto L25;
            String r12 = "";
        L27:
            if ((r29 & 128) == 0) goto L29;
            String r13 = "";
        L31:
            if ((r29 & 256) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r29 & 512) == 0) goto L37;
            String r15 = null;
        L38:
            this(r17, r6, r7, r9, r10, r11, r12, r13, r14, r15);
            return;
        L37:
            r15 = r28;
            goto L38
        L33:
            r14 = r27;
            goto L35
        L29:
            r13 = r26;
            goto L31
        L25:
            r12 = r25;
            goto L27
        L21:
            r11 = r24;
            goto L23
        L17:
            r10 = r23;
            goto L19
        L13:
            r9 = r22;
            goto L15
        L9:
            r7 = r20;
            goto L11
        L5:
            r6 = r19;
            goto L7
        }

        public static /* synthetic */ AutoMemoryProData copy$default(AutoMemoryProData r13, long r14, Long r16, long r17, String r19, String r20, String r21, String r22, String r23, String r24, String r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L5;
            long r2 = r13.ruleId;
        L7:
            if ((r26 & 2) == 0) goto L9;
            Long r4 = r13.memoryId;
        L11:
            if ((r26 & 4) == 0) goto L13;
            long r5 = r13.timestamp;
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r7 = r13.title;
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r8 = r13.subtitle;
        L23:
            if ((r26 & 32) == 0) goto L25;
            String r9 = r13.content;
        L27:
            if ((r26 & 64) == 0) goto L29;
            String r10 = r13.reason;
        L31:
            if ((r26 & 128) == 0) goto L33;
            String r11 = r13.logId;
        L35:
            if ((r26 & 256) == 0) goto L37;
            String r12 = r13.episodicIds;
        L39:
            if ((r26 & 512) == 0) goto L41;
            String r1 = r13.semanticIds;
        L43:
            return r13.copy(r2, r4, r5, r7, r8, r9, r10, r11, r12, r1);
        L41:
            r1 = r25;
            goto L43
        L37:
            r12 = r24;
            goto L39
        L33:
            r11 = r23;
            goto L35
        L29:
            r10 = r22;
            goto L31
        L25:
            r9 = r21;
            goto L27
        L21:
            r8 = r20;
            goto L23
        L17:
            r7 = r19;
            goto L19
        L13:
            r5 = r17;
            goto L15
        L9:
            r4 = r16;
            goto L11
        L5:
            r2 = r14;
            goto L7
        }

        public final long component1() {
            return this.ruleId;
        }

        public final String component10() {
            return this.semanticIds;
        }

        public final Long component2() {
            return this.memoryId;
        }

        public final long component3() {
            return this.timestamp;
        }

        public final String component4() {
            return this.title;
        }

        public final String component5() {
            return this.subtitle;
        }

        public final String component6() {
            return this.content;
        }

        public final String component7() {
            return this.reason;
        }

        public final String component8() {
            return this.logId;
        }

        public final String component9() {
            return this.episodicIds;
        }

        public final AutoMemoryProData copy(long r15, Long r17, long r18, String r20, String r21, String r22, String r23, String r24, String r25, String r26) {
            Intrinsics.checkNotNullParameter(r20, "title");
            Intrinsics.checkNotNullParameter(r22, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r23, InfoRequestQPSOptTraceLogger.REASON);
            Intrinsics.checkNotNullParameter(r24, "logId");
            return new AutoMemoryProData(r15, r17, r18, r20, r21, r22, r23, r24, r25, r26);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProData r10 = (AutoMemoryProData) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProData.class, "com.obric.memorydata.plugin");
            if (this.ruleId == r10.ruleId) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.memoryId, r10.memoryId) == true) goto L15;
            return false;
        L15:
            if (this.timestamp == r10.timestamp) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.title, r10.title) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.subtitle, r10.subtitle) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r10.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.episodicIds, r10.episodicIds) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.semanticIds, r10.semanticIds) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getEpisodicIds() {
            return this.episodicIds;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final Long getMemoryId() {
            return this.memoryId;
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

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.ruleId) * 31;
            Long r1 = this.memoryId;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((r0 + r3) * 31) + Long.hashCode(this.timestamp)) * 31) + this.title.hashCode()) * 31;
            String r5 = this.subtitle;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((((((r4 + r6) * 31) + this.content.hashCode()) * 31) + this.reason.hashCode()) * 31) + this.logId.hashCode()) * 31;
            String r8 = this.episodicIds;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.semanticIds;
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

        public final void setMemoryId(Long r1) {
            this.memoryId = r1;
        }

        public String toString() {
            return "AutoMemoryProData(ruleId=" + this.ruleId + ", memoryId=" + this.memoryId + ", timestamp=" + this.timestamp + ", title=" + this.title + ", subtitle=" + this.subtitle + ", content=" + this.content + ", reason=" + this.reason + ", logId=" + this.logId + ", episodicIds=" + this.episodicIds + ", semanticIds=" + this.semanticIds + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProExtractResultData;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", SlardarSettingsConstants.PERF_KEY_MEMORY, "", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "batchScreenIds", "", "appPackages", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getMemory", "()Ljava/util/List;", "getBatchScreenIds", "getAppPackages", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProExtractResultData {

        @SerializedName("app_packages")
        private final String appPackages;

        @SerializedName("batch_screen_ids")
        private final List<Long> batchScreenIds;
        private final int code;
        private final List<AutoMemoryProData> memory;
        private final String msg;

        public AutoMemoryProExtractResultData(int r3, String r4, List<AutoMemoryProData> r5, List<Long> r6, String r7) {
            List<AutoMemoryProData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<Long> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r8, SlardarSettingsConstants.PERF_KEY_MEMORY);
            this.code = r3;
            this.msg = r4;
            this.memory = r8;
            this.batchScreenIds = r9;
            this.appPackages = r7;
        }

        public /* synthetic */ AutoMemoryProExtractResultData(int r7, String r8, List r9, List r10, String r11, int r12, DefaultConstructorMarker r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 4) == 0) goto L5;
            r14 = CollectionsKt.emptyList();
        L5:
            this(r7, r8, r14, r4, r11);
        }

        public static /* synthetic */ AutoMemoryProExtractResultData copy$default(AutoMemoryProExtractResultData r6, int r7, String r8, List r9, List r10, String r11, int r12, Object r13) {
            List<AutoMemoryProData> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            List<Long> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.code;
        L5:
            int r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.msg;
        L8:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r14 = r6.memory;
        L11:
            List<AutoMemoryProData> r3 = r14;
            if ((r12 & 8) == 0) goto L14;
            r15 = r6.batchScreenIds;
        L14:
            List<Long> r4 = r15;
            if ((r12 & 16) == 0) goto L18;
            r11 = r6.appPackages;
        L18:
            return r6.copy(r1, r2, r3, r4, r11);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final List<AutoMemoryProData> component3() {
            return this.memory;
        }

        public final List<Long> component4() {
            return this.batchScreenIds;
        }

        public final String component5() {
            return this.appPackages;
        }

        public final AutoMemoryProExtractResultData copy(int r8, String r9, List<AutoMemoryProData> r10, List<Long> r11, String r12) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r4, SlardarSettingsConstants.PERF_KEY_MEMORY);
            return new AutoMemoryProExtractResultData(r8, r9, r4, r5, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProExtractResultData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProExtractResultData r6 = (AutoMemoryProExtractResultData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProExtractResultData.class, "com.obric.memorydata.plugin");
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.memory, r6.memory) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.batchScreenIds, r6.batchScreenIds) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.appPackages, r6.appPackages) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final String getAppPackages() {
            return this.appPackages;
        }

        public final List<Long> getBatchScreenIds() {
            return this.batchScreenIds;
        }

        public final int getCode() {
            return this.code;
        }

        public final List<AutoMemoryProData> getMemory() {
            return this.memory;
        }

        public final String getMsg() {
            return this.msg;
        }

        public int hashCode() {
            int r0 = ((((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31) + this.memory.hashCode()) * 31;
            List<Long> r1 = this.batchScreenIds;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.appPackages;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AutoMemoryProExtractResultData(code=" + this.code + ", msg=" + this.msg + ", memory=" + this.memory + ", batchScreenIds=" + this.batchScreenIds + ", appPackages=" + this.appPackages + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2CollectionResultData;", "", "code", "", "ruleResults", "", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2RuleResultData;", "<init>", "(ILjava/util/List;)V", "getCode", "()I", "getRuleResults", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2CollectionResultData {
        private final int code;

        @SerializedName("rule_results")
        private final List<AutoMemoryProV2RuleResultData> ruleResults;

        public AutoMemoryProV2CollectionResultData(int r3, List<AutoMemoryProV2RuleResultData> r4) {
            List<AutoMemoryProV2RuleResultData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ruleResults");
            this.code = r3;
            this.ruleResults = r5;
        }

        public /* synthetic */ AutoMemoryProV2CollectionResultData(int r2, List r3, int r4, DefaultConstructorMarker r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 2) == 0) goto L5;
            r6 = CollectionsKt.emptyList();
        L5:
            this(r2, r6);
        }

        public static /* synthetic */ AutoMemoryProV2CollectionResultData copy$default(AutoMemoryProV2CollectionResultData r1, int r2, List r3, int r4, Object r5) {
            List<AutoMemoryProV2RuleResultData> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.code;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.ruleResults;
        L9:
            return r1.copy(r2, r6);
        }

        public final int component1() {
            return this.code;
        }

        public final List<AutoMemoryProV2RuleResultData> component2() {
            return this.ruleResults;
        }

        public final AutoMemoryProV2CollectionResultData copy(int r2, List<AutoMemoryProV2RuleResultData> r3) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "ruleResults");
            return new AutoMemoryProV2CollectionResultData(r2, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProV2CollectionResultData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2CollectionResultData r6 = (AutoMemoryProV2CollectionResultData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProV2CollectionResultData.class, "com.obric.memorydata.plugin");
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ruleResults, r6.ruleResults) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getCode() {
            return this.code;
        }

        public final List<AutoMemoryProV2RuleResultData> getRuleResults() {
            return this.ruleResults;
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.ruleResults.hashCode();
        }

        public String toString() {
            return "AutoMemoryProV2CollectionResultData(code=" + this.code + ", ruleResults=" + this.ruleResults + ')';
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b-\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u0010HÆ\u0003J\t\u00109\u001a\u00020\u0012HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0003J¤\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0012HÖ\u0001J\t\u0010A\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006B"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicData;", "", "memoryId", "", "createTimestamp", "modifyTimestamp", "startTimestamp", "endTimestamp", "observation", "", "title", Params.CONTENT, WsConstants.KEY_EXTRA, "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicExtraData;", "logId", "useLocation", "", EventBody.KEY_CATEGORY, "", "sourceType", "ruleIdList", "", "<init>", "(Ljava/lang/Long;JJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicExtraData;Ljava/lang/String;ZILjava/lang/String;Ljava/util/List;)V", "getMemoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreateTimestamp", "()J", "getModifyTimestamp", "getStartTimestamp", "getEndTimestamp", "getObservation", "()Ljava/lang/String;", "getTitle", "getContent", "getExtra", "()Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicExtraData;", "getLogId", "getUseLocation", "()Z", "getCategory", "()I", "getSourceType", "getRuleIdList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/Long;JJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicExtraData;Ljava/lang/String;ZILjava/lang/String;Ljava/util/List;)Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicData;", "equals", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2EpisodicData {
        private final int category;
        private final String content;

        @SerializedName("create_timestamp")
        private final long createTimestamp;

        @SerializedName("end_timestamp")
        private final long endTimestamp;
        private final AutoMemoryProV2EpisodicExtraData extra;

        @SerializedName("log_id")
        private final String logId;

        @SerializedName("memory_id")
        private final Long memoryId;

        @SerializedName("modify_timestamp")
        private final long modifyTimestamp;
        private final String observation;

        @SerializedName("rule_id_list")
        private final List<Long> ruleIdList;

        @SerializedName("source_type")
        private final String sourceType;

        @SerializedName("start_timestamp")
        private final long startTimestamp;
        private final String title;

        @SerializedName("use_location")
        private final boolean useLocation;

        public AutoMemoryProV2EpisodicData() {
            this(null, 0, 0, 0, 0, null, null, null, null, null, false, 0, null, null, 16383, null);
        }

        public AutoMemoryProV2EpisodicData(Long r10, long r11, long r13, long r15, long r17, String r19, String r20, String r21, AutoMemoryProV2EpisodicExtraData r22, String r23, boolean r24, int r25, String r26, List<Long> r27) {
            List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r19, "observation");
            Intrinsics.checkNotNullParameter(r20, "title");
            Intrinsics.checkNotNullParameter(r21, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r23, "logId");
            Intrinsics.checkNotNullParameter(r26, "sourceType");
            Intrinsics.checkNotNullParameter(r6, "ruleIdList");
            this.memoryId = r10;
            this.createTimestamp = r11;
            this.modifyTimestamp = r13;
            this.startTimestamp = r15;
            this.endTimestamp = r17;
            this.observation = r19;
            this.title = r20;
            this.content = r21;
            this.extra = r22;
            this.logId = r23;
            this.useLocation = r24;
            this.category = r25;
            this.sourceType = r26;
            this.ruleIdList = r6;
        }

        public /* synthetic */ AutoMemoryProV2EpisodicData(Long r18, long r19, long r21, long r23, long r25, String r27, String r28, String r29, AutoMemoryProV2EpisodicExtraData r30, String r31, boolean r32, int r33, String r34, List r35, int r36, DefaultConstructorMarker r37) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
            if ((r36 & 1) == 0) goto L5;
            Long r2 = null;
        L6:
            long r5 = 0;
            if ((r36 & 2) == 0) goto L9;
            long r7 = 0;
        L11:
            if ((r36 & 4) == 0) goto L13;
            long r9 = 0;
        L15:
            if ((r36 & 8) == 0) goto L17;
            long r11 = 0;
        L19:
            if ((r36 & 16) != 0) goto L22;
            r5 = r25;
        L22:
            String r13 = "";
            if ((r36 & 32) == 0) goto L25;
            String r4 = "";
        L27:
            if ((r36 & 64) == 0) goto L29;
            String r14 = "";
        L31:
            if ((r36 & 128) == 0) goto L33;
            String r15 = "";
        L35:
            if ((r36 & 256) == 0) goto L37;
            AutoMemoryProV2EpisodicExtraData r3 = null;
        L39:
            if ((r36 & 512) != 0) goto L42;
            r13 = r31;
        L42:
            int r16 = 0;
            if ((r36 & 1024) == 0) goto L45;
            boolean r6 = false;
        L46:
            boolean r38 = r6;
            if ((r36 & 2048) != 0) goto L51;
            r16 = r33;
        L51:
            if ((r36 & 4096) == 0) goto L53;
            String r8 = AutoMemoryProBridgeImpl.SOURCE_TYPE_SCREEN_OBSERVATION;
        L55:
            if ((r36 & 8192) == 0) goto L57;
            List r0 = CollectionsKt.emptyList();
        L58:
            this(r2, r7, r9, r11, r5, r4, r14, r15, r3, r13, r38, r16, r8, r0);
            return;
        L57:
            r0 = r1;
            goto L58
        L53:
            r8 = r34;
            goto L55
        L45:
            r6 = r32;
            goto L46
        L37:
            r3 = r30;
            goto L39
        L33:
            r15 = r29;
            goto L35
        L29:
            r14 = r28;
            goto L31
        L25:
            r4 = r27;
            goto L27
        L17:
            r11 = r23;
            goto L19
        L13:
            r9 = r21;
            goto L15
        L9:
            r7 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L6
        }

        public static /* synthetic */ AutoMemoryProV2EpisodicData copy$default(AutoMemoryProV2EpisodicData r16, Long r17, long r18, long r20, long r22, long r24, String r26, String r27, String r28, AutoMemoryProV2EpisodicExtraData r29, String r30, boolean r31, int r32, String r33, List r34, int r35, Object r36) {
            List<Long> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
            if ((r35 & 1) == 0) goto L5;
            Long r3 = r16.memoryId;
        L7:
            if ((r35 & 2) == 0) goto L9;
            long r4 = r16.createTimestamp;
        L11:
            if ((r35 & 4) == 0) goto L13;
            long r6 = r16.modifyTimestamp;
        L15:
            if ((r35 & 8) == 0) goto L17;
            long r8 = r16.startTimestamp;
        L19:
            if ((r35 & 16) == 0) goto L21;
            long r10 = r16.endTimestamp;
        L23:
            if ((r35 & 32) == 0) goto L25;
            String r12 = r16.observation;
        L27:
            if ((r35 & 64) == 0) goto L29;
            String r13 = r16.title;
        L31:
            if ((r35 & 128) == 0) goto L33;
            String r14 = r16.content;
        L35:
            if ((r35 & 256) == 0) goto L37;
            AutoMemoryProV2EpisodicExtraData r15 = r16.extra;
        L39:
            if ((r35 & 512) == 0) goto L41;
            String r5 = r16.logId;
        L42:
            String r37 = r5;
            if ((r35 & 1024) == 0) goto L45;
            boolean r7 = r16.useLocation;
        L46:
            boolean r38 = r7;
            if ((r35 & 2048) == 0) goto L49;
            int r9 = r16.category;
        L50:
            int r39 = r9;
            if ((r35 & 4096) == 0) goto L53;
            String r11 = r16.sourceType;
        L55:
            if ((r35 & 8192) == 0) goto L57;
            List<Long> r1 = r16.ruleIdList;
        L59:
            return r16.copy(r3, r4, r6, r8, r10, r12, r13, r14, r15, r37, r38, r39, r11, r1);
        L57:
            r1 = r2;
            goto L59
        L53:
            r11 = r33;
            goto L55
        L49:
            r9 = r32;
            goto L50
        L45:
            r7 = r31;
            goto L46
        L41:
            r5 = r30;
            goto L42
        L37:
            r15 = r29;
            goto L39
        L33:
            r14 = r28;
            goto L35
        L29:
            r13 = r27;
            goto L31
        L25:
            r12 = r26;
            goto L27
        L21:
            r10 = r24;
            goto L23
        L17:
            r8 = r22;
            goto L19
        L13:
            r6 = r20;
            goto L15
        L9:
            r4 = r18;
            goto L11
        L5:
            r3 = r17;
            goto L7
        }

        public final Long component1() {
            return this.memoryId;
        }

        public final String component10() {
            return this.logId;
        }

        public final boolean component11() {
            return this.useLocation;
        }

        public final int component12() {
            return this.category;
        }

        public final String component13() {
            return this.sourceType;
        }

        public final List<Long> component14() {
            return this.ruleIdList;
        }

        public final long component2() {
            return this.createTimestamp;
        }

        public final long component3() {
            return this.modifyTimestamp;
        }

        public final long component4() {
            return this.startTimestamp;
        }

        public final long component5() {
            return this.endTimestamp;
        }

        public final String component6() {
            return this.observation;
        }

        public final String component7() {
            return this.title;
        }

        public final String component8() {
            return this.content;
        }

        public final AutoMemoryProV2EpisodicExtraData component9() {
            return this.extra;
        }

        public final AutoMemoryProV2EpisodicData copy(Long r21, long r22, long r24, long r26, long r28, String r30, String r31, String r32, AutoMemoryProV2EpisodicExtraData r33, String r34, boolean r35, int r36, String r37, List<Long> r38) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r30, "observation");
            Intrinsics.checkNotNullParameter(r31, "title");
            Intrinsics.checkNotNullParameter(r32, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r34, "logId");
            Intrinsics.checkNotNullParameter(r37, "sourceType");
            Intrinsics.checkNotNullParameter(r0, "ruleIdList");
            return new AutoMemoryProV2EpisodicData(r21, r22, r24, r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r0);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProV2EpisodicData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2EpisodicData r10 = (AutoMemoryProV2EpisodicData) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProV2EpisodicData.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r10.memoryId) == true) goto L12;
            return false;
        L12:
            if (this.createTimestamp == r10.createTimestamp) goto L15;
            return false;
        L15:
            if (this.modifyTimestamp == r10.modifyTimestamp) goto L18;
            return false;
        L18:
            if (this.startTimestamp == r10.startTimestamp) goto L21;
            return false;
        L21:
            if (this.endTimestamp == r10.endTimestamp) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.observation, r10.observation) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.title, r10.title) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.content, r10.content) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.extra, r10.extra) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L39;
            return false;
        L39:
            if (this.useLocation == r10.useLocation) goto L42;
            return false;
        L42:
            if (this.category == r10.category) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.sourceType, r10.sourceType) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.ruleIdList, r10.ruleIdList) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final int getCategory() {
            return this.category;
        }

        public final String getContent() {
            return this.content;
        }

        public final long getCreateTimestamp() {
            return this.createTimestamp;
        }

        public final long getEndTimestamp() {
            return this.endTimestamp;
        }

        public final AutoMemoryProV2EpisodicExtraData getExtra() {
            return this.extra;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final Long getMemoryId() {
            return this.memoryId;
        }

        public final long getModifyTimestamp() {
            return this.modifyTimestamp;
        }

        public final String getObservation() {
            return this.observation;
        }

        public final List<Long> getRuleIdList() {
            return this.ruleIdList;
        }

        public final String getSourceType() {
            return this.sourceType;
        }

        public final long getStartTimestamp() {
            return this.startTimestamp;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean getUseLocation() {
            return this.useLocation;
        }

        public int hashCode() {
            Long r0 = this.memoryId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((((((((((((r2 * 31) + Long.hashCode(this.createTimestamp)) * 31) + Long.hashCode(this.modifyTimestamp)) * 31) + Long.hashCode(this.startTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31) + this.observation.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31;
            AutoMemoryProV2EpisodicExtraData r4 = this.extra;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((((((((((r3 + r1) * 31) + this.logId.hashCode()) * 31) + Boolean.hashCode(this.useLocation)) * 31) + Integer.hashCode(this.category)) * 31) + this.sourceType.hashCode()) * 31) + this.ruleIdList.hashCode();
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AutoMemoryProV2EpisodicData(memoryId=").append(this.memoryId).append(", createTimestamp=").append(this.createTimestamp).append(", modifyTimestamp=").append(this.modifyTimestamp).append(", startTimestamp=").append(this.startTimestamp).append(", endTimestamp=").append(this.endTimestamp).append(", observation=").append(this.observation).append(", title=").append(this.title).append(", content=").append(this.content).append(", extra=").append(this.extra).append(", logId=").append(this.logId).append(", useLocation=").append(this.useLocation).append(", category=");
            r0.append(this.category).append(", sourceType=").append(this.sourceType).append(", ruleIdList=").append(this.ruleIdList).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicExtraData;", "", "location", "", "<init>", "(Ljava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2EpisodicExtraData {
        private final String location;

        /* JADX WARN: Multi-variable type inference failed */
        public AutoMemoryProV2EpisodicExtraData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public AutoMemoryProV2EpisodicExtraData(String r1) {
            this.location = r1;
        }

        public /* synthetic */ AutoMemoryProV2EpisodicExtraData(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public static /* synthetic */ AutoMemoryProV2EpisodicExtraData copy$default(AutoMemoryProV2EpisodicExtraData r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.location;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.location;
        }

        public final AutoMemoryProV2EpisodicExtraData copy(String r1) {
            return new AutoMemoryProV2EpisodicExtraData(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProV2EpisodicExtraData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2EpisodicExtraData r6 = (AutoMemoryProV2EpisodicExtraData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProV2EpisodicExtraData.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.location, r6.location) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getLocation() {
            return this.location;
        }

        public int hashCode() {
            String r0 = this.location;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "AutoMemoryProV2EpisodicExtraData(location=" + this.location + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2ExtractResultData;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "batchScreenIds", "", "", "episodicList", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2EpisodicData;", "semanticList", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2SemanticData;", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getBatchScreenIds", "()Ljava/util/List;", "getEpisodicList", "getSemanticList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2ExtractResultData {

        @SerializedName("batch_screen_ids")
        private final List<Long> batchScreenIds;
        private final int code;

        @SerializedName("episodic_list")
        private final List<AutoMemoryProV2EpisodicData> episodicList;
        private final String msg;

        @SerializedName("semantic_list")
        private final List<AutoMemoryProV2SemanticData> semanticList;

        public AutoMemoryProV2ExtractResultData(int r3, String r4, List<Long> r5, List<AutoMemoryProV2EpisodicData> r6, List<AutoMemoryProV2SemanticData> r7) {
            List<Long> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProV2EpisodicData> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProV2SemanticData> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r9, "episodicList");
            Intrinsics.checkNotNullParameter(r10, "semanticList");
            this.code = r3;
            this.msg = r4;
            this.batchScreenIds = r8;
            this.episodicList = r9;
            this.semanticList = r10;
        }

        public /* synthetic */ AutoMemoryProV2ExtractResultData(int r7, String r8, List r9, List r10, List r11, int r12, DefaultConstructorMarker r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 2) == 0) goto L5;
            r8 = "";
        L5:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L8;
            r14 = null;
        L8:
            List r3 = r14;
            if ((r12 & 8) == 0) goto L11;
            r15 = CollectionsKt.emptyList();
        L11:
            List r4 = r15;
            if ((r12 & 16) == 0) goto L14;
            r16 = CollectionsKt.emptyList();
        L14:
            this(r7, r2, r3, r4, r16);
        }

        public static /* synthetic */ AutoMemoryProV2ExtractResultData copy$default(AutoMemoryProV2ExtractResultData r6, int r7, String r8, List r9, List r10, List r11, int r12, Object r13) {
            List<Long> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProV2EpisodicData> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProV2SemanticData> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.code;
        L5:
            int r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.msg;
        L8:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r14 = r6.batchScreenIds;
        L11:
            List<Long> r3 = r14;
            if ((r12 & 8) == 0) goto L14;
            r15 = r6.episodicList;
        L14:
            List<AutoMemoryProV2EpisodicData> r4 = r15;
            if ((r12 & 16) == 0) goto L18;
            r16 = r6.semanticList;
        L18:
            return r6.copy(r1, r2, r3, r4, r16);
        }

        public final int component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final List<Long> component3() {
            return this.batchScreenIds;
        }

        public final List<AutoMemoryProV2EpisodicData> component4() {
            return this.episodicList;
        }

        public final List<AutoMemoryProV2SemanticData> component5() {
            return this.semanticList;
        }

        public final AutoMemoryProV2ExtractResultData copy(int r8, String r9, List<Long> r10, List<AutoMemoryProV2EpisodicData> r11, List<AutoMemoryProV2SemanticData> r12) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r5, "episodicList");
            Intrinsics.checkNotNullParameter(r6, "semanticList");
            return new AutoMemoryProV2ExtractResultData(r8, r9, r4, r5, r6);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProV2ExtractResultData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2ExtractResultData r6 = (AutoMemoryProV2ExtractResultData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProV2ExtractResultData.class, "com.obric.memorydata.plugin");
            if (this.code == r6.code) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.batchScreenIds, r6.batchScreenIds) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.episodicList, r6.episodicList) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.semanticList, r6.semanticList) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final List<Long> getBatchScreenIds() {
            return this.batchScreenIds;
        }

        public final int getCode() {
            return this.code;
        }

        public final List<AutoMemoryProV2EpisodicData> getEpisodicList() {
            return this.episodicList;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final List<AutoMemoryProV2SemanticData> getSemanticList() {
            return this.semanticList;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
            List<Long> r1 = this.batchScreenIds;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.episodicList.hashCode()) * 31) + this.semanticList.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "AutoMemoryProV2ExtractResultData(code=" + this.code + ", msg=" + this.msg + ", batchScreenIds=" + this.batchScreenIds + ", episodicList=" + this.episodicList + ", semanticList=" + this.semanticList + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2RuleResultData;", "", "memories", "", "Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProData;", "<init>", "(Ljava/util/List;)V", "getMemories", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2RuleResultData {
        private final List<AutoMemoryProData> memories;

        /* JADX WARN: Multi-variable type inference failed */
        public AutoMemoryProV2RuleResultData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public AutoMemoryProV2RuleResultData(List<AutoMemoryProData> r3) {
            List<AutoMemoryProData> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "memories");
            this.memories = r4;
        }

        public /* synthetic */ AutoMemoryProV2RuleResultData(List r2, int r3, DefaultConstructorMarker r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = CollectionsKt.emptyList();
        L5:
            this(r5);
        }

        public static /* synthetic */ AutoMemoryProV2RuleResultData copy$default(AutoMemoryProV2RuleResultData r1, List r2, int r3, Object r4) {
            List<AutoMemoryProData> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = r1.memories;
        L6:
            return r1.copy(r5);
        }

        public final List<AutoMemoryProData> component1() {
            return this.memories;
        }

        public final AutoMemoryProV2RuleResultData copy(List<AutoMemoryProData> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "memories");
            return new AutoMemoryProV2RuleResultData(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProV2RuleResultData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2RuleResultData r6 = (AutoMemoryProV2RuleResultData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProV2RuleResultData.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memories, r6.memories) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final List<AutoMemoryProData> getMemories() {
            return this.memories;
        }

        public int hashCode() {
            return this.memories.hashCode();
        }

        public String toString() {
            return "AutoMemoryProV2RuleResultData(memories=" + this.memories + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011HÆ\u0003J\u0096\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u000bHÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b \u0010\u0015R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b!\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00069"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2SemanticData;", "", "memoryId", "", "description", "", "tagPath", "keyPhrase", "type", "sources", "evidenceCount", "", "createTime", "modifyTime", "logId", "sourceType", "ruleIdList", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMemoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "()Ljava/lang/String;", "getTagPath", "getKeyPhrase", "getType", "getSources", "getEvidenceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreateTime", "getModifyTime", "getLogId", "getSourceType", "getRuleIdList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$AutoMemoryProV2SemanticData;", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMemoryProV2SemanticData {
        private final Long createTime;
        private final String description;

        @SerializedName("evidenceCount")
        private final Integer evidenceCount;

        @SerializedName("key_phrase")
        private final String keyPhrase;

        @SerializedName("log_id")
        private final String logId;

        @SerializedName("memory_id")
        private final Long memoryId;
        private final Long modifyTime;

        @SerializedName("rule_id_list")
        private final List<Long> ruleIdList;

        @SerializedName("source_type")
        private final String sourceType;
        private final String sources;

        @SerializedName("tag_path")
        private final String tagPath;
        private final String type;

        public AutoMemoryProV2SemanticData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        }

        public AutoMemoryProV2SemanticData(Long r3, String r4, String r5, String r6, String r7, String r8, Integer r9, Long r10, Long r11, String r12, String r13, List<Long> r14) {
            List<Long> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "description");
            Intrinsics.checkNotNullParameter(r5, "tagPath");
            Intrinsics.checkNotNullParameter(r6, "keyPhrase");
            Intrinsics.checkNotNullParameter(r7, "type");
            Intrinsics.checkNotNullParameter(r12, "logId");
            Intrinsics.checkNotNullParameter(r13, "sourceType");
            Intrinsics.checkNotNullParameter(r15, "ruleIdList");
            this.memoryId = r3;
            this.description = r4;
            this.tagPath = r5;
            this.keyPhrase = r6;
            this.type = r7;
            this.sources = r8;
            this.evidenceCount = r9;
            this.createTime = r10;
            this.modifyTime = r11;
            this.logId = r12;
            this.sourceType = r13;
            this.ruleIdList = r15;
        }

        public /* synthetic */ AutoMemoryProV2SemanticData(Long r14, String r15, String r16, String r17, String r18, String r19, Integer r20, Long r21, Long r22, String r23, String r24, List r25, int r26, DefaultConstructorMarker r27) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
            Long r3 = null;
            if ((r26 & 1) == 0) goto L5;
            Long r2 = null;
        L6:
            String r5 = "";
            if ((r26 & 2) == 0) goto L9;
            String r4 = "";
        L11:
            if ((r26 & 4) == 0) goto L13;
            String r6 = "";
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r7 = "";
        L19:
            if ((r26 & 16) == 0) goto L21;
            String r8 = "";
        L23:
            if ((r26 & 32) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r26 & 64) == 0) goto L29;
            Integer r10 = null;
        L31:
            if ((r26 & 128) == 0) goto L33;
            Long r11 = null;
        L35:
            if ((r26 & 256) != 0) goto L39;
            r3 = r22;
        L39:
            if ((r26 & 512) != 0) goto L43;
            r5 = r23;
        L43:
            if ((r26 & 1024) == 0) goto L45;
            String r12 = AutoMemoryProBridgeImpl.SOURCE_TYPE_SCREEN_OBSERVATION;
        L47:
            if ((r26 & 2048) == 0) goto L49;
            r1 = CollectionsKt.emptyList();
        L49:
            this(r2, r4, r6, r7, r8, r9, r10, r11, r3, r5, r12, r1);
            return;
        L45:
            r12 = r24;
            goto L47
        L33:
            r11 = r21;
            goto L35
        L29:
            r10 = r20;
            goto L31
        L25:
            r9 = r19;
            goto L27
        L21:
            r8 = r18;
            goto L23
        L17:
            r7 = r17;
            goto L19
        L13:
            r6 = r16;
            goto L15
        L9:
            r4 = r15;
            goto L11
        L5:
            r2 = r14;
            goto L6
        }

        public static /* synthetic */ AutoMemoryProV2SemanticData copy$default(AutoMemoryProV2SemanticData r14, Long r15, String r16, String r17, String r18, String r19, String r20, Integer r21, Long r22, Long r23, String r24, String r25, List r26, int r27, Object r28) {
            List<Long> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
            if ((r27 & 1) == 0) goto L5;
            Long r3 = r14.memoryId;
        L7:
            if ((r27 & 2) == 0) goto L9;
            String r4 = r14.description;
        L11:
            if ((r27 & 4) == 0) goto L13;
            String r5 = r14.tagPath;
        L15:
            if ((r27 & 8) == 0) goto L17;
            String r6 = r14.keyPhrase;
        L19:
            if ((r27 & 16) == 0) goto L21;
            String r7 = r14.type;
        L23:
            if ((r27 & 32) == 0) goto L25;
            String r8 = r14.sources;
        L27:
            if ((r27 & 64) == 0) goto L29;
            Integer r9 = r14.evidenceCount;
        L31:
            if ((r27 & 128) == 0) goto L33;
            Long r10 = r14.createTime;
        L35:
            if ((r27 & 256) == 0) goto L37;
            Long r11 = r14.modifyTime;
        L39:
            if ((r27 & 512) == 0) goto L41;
            String r12 = r14.logId;
        L43:
            if ((r27 & 1024) == 0) goto L45;
            String r13 = r14.sourceType;
        L47:
            if ((r27 & 2048) == 0) goto L49;
            List<Long> r1 = r14.ruleIdList;
        L51:
            return r14.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
        L49:
            r1 = r2;
            goto L51
        L45:
            r13 = r25;
            goto L47
        L41:
            r12 = r24;
            goto L43
        L37:
            r11 = r23;
            goto L39
        L33:
            r10 = r22;
            goto L35
        L29:
            r9 = r21;
            goto L31
        L25:
            r8 = r20;
            goto L27
        L21:
            r7 = r19;
            goto L23
        L17:
            r6 = r18;
            goto L19
        L13:
            r5 = r17;
            goto L15
        L9:
            r4 = r16;
            goto L11
        L5:
            r3 = r15;
            goto L7
        }

        public final Long component1() {
            return this.memoryId;
        }

        public final String component10() {
            return this.logId;
        }

        public final String component11() {
            return this.sourceType;
        }

        public final List<Long> component12() {
            return this.ruleIdList;
        }

        public final String component2() {
            return this.description;
        }

        public final String component3() {
            return this.tagPath;
        }

        public final String component4() {
            return this.keyPhrase;
        }

        public final String component5() {
            return this.type;
        }

        public final String component6() {
            return this.sources;
        }

        public final Integer component7() {
            return this.evidenceCount;
        }

        public final Long component8() {
            return this.createTime;
        }

        public final Long component9() {
            return this.modifyTime;
        }

        public final AutoMemoryProV2SemanticData copy(Long r15, String r16, String r17, String r18, String r19, String r20, Integer r21, Long r22, Long r23, String r24, String r25, List<Long> r26) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "description");
            Intrinsics.checkNotNullParameter(r17, "tagPath");
            Intrinsics.checkNotNullParameter(r18, "keyPhrase");
            Intrinsics.checkNotNullParameter(r19, "type");
            Intrinsics.checkNotNullParameter(r24, "logId");
            Intrinsics.checkNotNullParameter(r25, "sourceType");
            Intrinsics.checkNotNullParameter(r13, "ruleIdList");
            return new AutoMemoryProV2SemanticData(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProV2SemanticData.class) == true) goto L8;
            return false;
        L8:
            AutoMemoryProV2SemanticData r6 = (AutoMemoryProV2SemanticData) ZeusTransformUtils.preCheckCast(r5, AutoMemoryProV2SemanticData.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.tagPath, r6.tagPath) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.keyPhrase, r6.keyPhrase) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.sources, r6.sources) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.evidenceCount, r6.evidenceCount) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.modifyTime, r6.modifyTime) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.sourceType, r6.sourceType) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.ruleIdList, r6.ruleIdList) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final Long getCreateTime() {
            return this.createTime;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Integer getEvidenceCount() {
            return this.evidenceCount;
        }

        public final String getKeyPhrase() {
            return this.keyPhrase;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final Long getMemoryId() {
            return this.memoryId;
        }

        public final Long getModifyTime() {
            return this.modifyTime;
        }

        public final List<Long> getRuleIdList() {
            return this.ruleIdList;
        }

        public final String getSourceType() {
            return this.sourceType;
        }

        public final String getSources() {
            return this.sources;
        }

        public final String getTagPath() {
            return this.tagPath;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            Long r0 = this.memoryId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((((((((r2 * 31) + this.description.hashCode()) * 31) + this.tagPath.hashCode()) * 31) + this.keyPhrase.hashCode()) * 31) + this.type.hashCode()) * 31;
            String r4 = this.sources;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.evidenceCount;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.createTime;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Long r13 = this.modifyTime;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return ((((((r12 + r1) * 31) + this.logId.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + this.ruleIdList.hashCode();
        L17:
            r11 = r10.hashCode();
            goto L18
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

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AutoMemoryProV2SemanticData(memoryId=").append(this.memoryId).append(", description=").append(this.description).append(", tagPath=").append(this.tagPath).append(", keyPhrase=").append(this.keyPhrase).append(", type=").append(this.type).append(", sources=").append(this.sources).append(", evidenceCount=").append(this.evidenceCount).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", logId=").append(this.logId).append(", sourceType=").append(this.sourceType).append(", ruleIdList=");
            r0.append(this.ruleIdList).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/AutoMemoryProBridgeImpl$UpsertedAutoMemoryPro;", "", "operateType", "", "entity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "previousLogId", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;Ljava/lang/String;)V", "getOperateType", "()Ljava/lang/String;", "getEntity", "()Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "getPreviousLogId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AutoMemoryProEntity f12499b;
        private final String c;

        public a(String r2, AutoMemoryProEntity r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "operateType");
            Intrinsics.checkNotNullParameter(r3, "entity");
            Intrinsics.checkNotNullParameter(r4, "previousLogId");
            this.f12498a = r2;
            this.f12499b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f12498a;
        }

        public final AutoMemoryProEntity b() {
            return this.f12499b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12498a, r6.f12498a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12499b, r6.f12499b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12498a.hashCode() * 31) + this.f12499b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "UpsertedAutoMemoryPro(operateType=" + this.f12498a + ", entity=" + this.f12499b + ", previousLogId=" + this.c + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProExtractFinish$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProExtractFinish$2", f = "AutoMemoryProBridgeImpl.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:12:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            long r4 = c.f9561a.b(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED).getCountByEntityType(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryProBridgeImpl.TAG, "onAutoMemoryProExtractFinish waiting pending: " + r4, false, 4, null);
            if (r4 == 0) goto L15;
        L9:
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(3000, r14) != r0) goto L12;
            return r0;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProV2CollectionFinish$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProV2CollectionFinish$2", f = "AutoMemoryProBridgeImpl.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    static final class C12182 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        C12182(Continuation<? super C12182> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12182((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12182) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12182.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:12:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            long r4 = c.f9561a.b(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED).getCountByEntityType(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryProBridgeImpl.TAG, "onAutoMemoryProV2CollectionFinish waiting pending: " + r4, false, 4, null);
            if (r4 == 0) goto L15;
        L9:
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(3000, r14) != r0) goto L12;
            return r0;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProV2ExtractFinish$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.bridge.AutoMemoryProBridgeImpl$onAutoMemoryProV2ExtractFinish$3", f = "AutoMemoryProBridgeImpl.kt", i = {}, l = {326}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:12:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L13:
            if (c.f9561a.b(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED).getCountByEntityType(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED) == 0) goto L15;
        L9:
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(3000, r9) != r0) goto L13;
            return r0;
        L15:
            if (c.f9561a.b(NetError.ERR_CACHE_READ_FAILURE).getCountByEntityType(NetError.ERR_CACHE_READ_FAILURE) != 0) goto L9;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            goto L9
        }
    }

    static {
        INSTANCE = new AutoMemoryProBridgeImpl();
    }

    private AutoMemoryProBridgeImpl() {
    }

    private final void appendAutoMemoryProTraceOp(Map<String, JSONObject> r3, AutoMemoryProData r4, a r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        String r6 = r4.getLogId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r6 = null;
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        Object r7 = r2.get(r6);
        if (r7 != null) goto L14;
        r7 = INSTANCE.emptyMemoryTraceOps();
        r2.put(r6, r7);
    L14:
        JSONArray r8 = ((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin")).getJSONArray(r5.a());
        AutoMemoryProEntity r9 = r5.b();
        JSONObject r10 = new JSONObject();
        r10.put("entityType", r9.getType());
        String r0 = r9.getUuid();
        if (r0 != null) goto L17;
        r0 = "";
    L17:
        r10.put(Api.KEY_UUID, r0);
        r10.put("entityId", r9.getEntityId());
        r10.put("memoryEntityJson", r9.toJsonObject().toString());
        r10.put("lastBuildLogId", r5.c());
        r10.put("toolName", AUTO_MEMORY_PRO_V2_COLLECTION_TASK);
        r10.put("operateType", r5.a());
        r8.put(r10);
    }

    private final JSONObject emptyMemoryTraceOps() {
        JSONObject r2 = new JSONObject().put("insert", new JSONArray()).put(BuildConfig.CHANNEL, new JSONArray()).put("delete", new JSONArray()).put("search", new JSONArray()).put(Params.PROMPT, new JSONArray());
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    @JvmStatic
    public static final AutoMemoryProBridgeImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ boolean lambda$DBT8Ge_34mtO8iIExtmUzjyslLA(AutoMemoryProEntity r0) {
        return upsertAutoMemoryPro$lambda$14(r0);
    }

    public static /* synthetic */ boolean lambda$I6v3LUGyqJxt6P8X4fwOekEFFeA(AutoMemoryProEntity r0) {
        return upsertAutoMemoryPro$lambda$16(r0);
    }

    public static /* synthetic */ boolean lambda$SRVRqhzoOVJKfNauLtuPdGe8oEM(AutoMemoryProEntity r0) {
        return onAutoMemoryProExtractFinish$lambda$6$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$lroqWP5lY21JWB-_jno3pX8mk8A, reason: not valid java name */
    public static /* synthetic */ boolean m1113lambda$lroqWP5lY21JWB_jno3pX8mk8A(AutoMemoryProEntity r0) {
        return onAutoMemoryProExtractFinish$lambda$6$lambda$2(r0);
    }

    private final List<Long> normalizeRuleIdList(List<Long> r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L12;
        Object r1 = r9.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r8.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L12:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean onAutoMemoryProExtractFinish$lambda$6$lambda$2(AutoMemoryProEntity r3) {
        return com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    private static final boolean onAutoMemoryProExtractFinish$lambda$6$lambda$4(AutoMemoryProEntity r3) {
        return com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    private final void reportAutoMemoryProCollectionTrace(Map<String, ? extends JSONObject> r5) {
        Iterator r4 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        JSONObject r7 = (JSONObject) ZeusTransformUtils.preCheckCast(r6.getValue(), JSONObject.class, "com.obric.memorydata.plugin");
        MemoryService r2 = MemoryService.INSTANCE;
        String r8 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        r2.reportMemoryTraceOps(r1, AUTO_MEMORY_PRO_V2_COLLECTION_TASK, r8);
        goto L4
    }

    private final a upsertAutoMemoryPro(AutoMemoryProData r14, List<JSONObject> r15) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List r16 = com.obric.memorydata.recommend.bridge.a.a(r14);
        Long r1 = r14.getMemoryId();
        if (r1 == null) goto L12;
        final AutoMemoryProEntity r2 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(r1.longValue()), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        String r12 = r2.getLogId();
        com.obric.memorydata.recommend.bridge.a.a(r2, r14, null, System.currentTimeMillis(), 2, null);
        boolean r17 = ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.bridge.a.a(r16, new $$Lambda$AutoMemoryProBridgeImpl$DBT8Ge_34mtO8iIExtmUzjyslLA(r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r13 == null) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("op", BuildConfig.CHANNEL);
        r0.put("entity", r2.toJsonObject());
        r13.add(r0);
    L9:
        if (r17 == true) goto L11;
        return null;
    L11:
        return new a(BuildConfig.CHANNEL, r2, r12);
    L12:
        final AutoMemoryProEntity r18 = com.obric.memorydata.recommend.bridge.a.a(r14, "", System.currentTimeMillis(), null, 4, null);
        boolean r19 = ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.bridge.a.a(r16, new $$Lambda$AutoMemoryProBridgeImpl$I6v3LUGyqJxt6P8X4fwOekEFFeA(r18)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r13 == null) goto L15;
        JSONObject r3 = new JSONObject();
        r3.put("op", "add");
        r3.put("entity", r18.toJsonObject());
        r13.add(r3);
    L15:
        if (r19 == true) goto L17;
        return null;
    L17:
        return new a("insert", r18, "");
    }

    static /* synthetic */ a upsertAutoMemoryPro$default(AutoMemoryProBridgeImpl r1, AutoMemoryProData r2, List r3, int r4, Object r5) {
        List<JSONObject> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = null;
    L6:
        return r1.upsertAutoMemoryPro(r2, r6);
    }

    private static final boolean upsertAutoMemoryPro$lambda$14(AutoMemoryProEntity r3) {
        return com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    private static final boolean upsertAutoMemoryPro$lambda$16(AutoMemoryProEntity r3) {
        return com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean getImageFilterEnable() {
        return AppSettingsManager.INSTANCE.getRecommendSettings().getImageFilterEnable();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean isAutoMemoryProEnabled() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(MemoryService.INSTANCE.autoMemoryEffectiveEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProClientEvaluationStats(String r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (AppContext.INSTANCE.isDebug() == true) goto L6;
        return;
    L6:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_screen_observation_evaluation_enable", false) == true) goto L8;
        return;
    L8:
        RunLog.INSTANCE.debug(TAG, "run onAutoMemoryProClientEvaluationStats " + r6);
        FilesKt.appendText$default(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt"), r6 + '\n', null, 2, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProExtractFinish(String r25) {
        Intrinsics.checkNotNullParameter(r25, "data");
        RunLog.INSTANCE.debug(TAG, "run onAutoMemoryProExtractFinish " + r25);
        IStore r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r14 = "is_screen_observation_evaluation_enable";
        String r15 = "auto_memory_collection_step_is_finish";
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProExtractFinish enter: evaluationMode=" + r7.getBoolean("is_screen_observation_evaluation_enable", false) + ", collectionStepFinished=" + r7.getBoolean("auto_memory_collection_step_is_finish", false), false, 4, null);
        if (r7.getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L5;
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L77:
    L55:
        e = e;
        IStore r23 = r7;
    L57:
        String r9 = r14;
        String r12 = r15;
    L59:
        if (AppContext.INSTANCE.isDebug() == false) goto L61;
    L70:
        throw e;
    L61:
        if (AppContext.INSTANCE.isRoot() == true) goto L70;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "process extract result error, e: " + e, null, 4, null);
    L64:
        if (AppContext.INSTANCE.isDebug() == true) goto L66;
    L68:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProExtractFinish exit: collectionStepFinished=" + r23.getBoolean(r12, false), false, 4, null);
        return;
    L66:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(r9, false) == false) goto L68;
        File r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt");
        StringBuilder r0 = new StringBuilder().append(r25).append('\n');
        Intrinsics.checkNotNull(r8);
        FilesKt.appendText$default(r2, r0.append(u.a(r8)).append('\n').toString(), null, 2, null);
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        goto L68
    L75:
        Object r1 = GsonUtil.INSTANCE.getGSON().fromJson(r25, AutoMemoryProExtractResultData.class);     // Catch: Exception -> L9
    L11:
        AutoMemoryProExtractResultData r3 = (AutoMemoryProExtractResultData) ZeusTransformUtils.preCheckCast(r1, AutoMemoryProExtractResultData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        if (r3 == null) goto L54;
        List<Long> r10 = r3.getBatchScreenIds();     // Catch: Exception -> L55
        if (r10 != null) goto L16;
        r10 = CollectionsKt.emptyList();     // Catch: Exception -> L55
    L16:
        List<AutoMemoryProData> r11 = r3.getMemory();     // Catch: Exception -> L55
        if (r11 != null) goto L19;
        r11 = CollectionsKt.emptyList();     // Catch: Exception -> L55
    L19:
        Iterator<AutoMemoryProData> r13 = r11.iterator();     // Catch: Exception -> L55
    L20:
        if (r13.hasNext() == false) goto L54;
        AutoMemoryProData r16 = (AutoMemoryProData) ZeusTransformUtils.preCheckCast(r13.next(), AutoMemoryProData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        Long r17 = r16.getMemoryId();     // Catch: Exception -> L55
        if (r17 != null) goto L26;
        r23 = r7;
        r9 = r14;
        r12 = r15;
        String r5 = r3.getAppPackages();     // Catch: Exception -> L52
        if (r5 != null) goto L44;
        String r18 = "";
    L45:
        final AutoMemoryProEntity r6 = com.obric.memorydata.recommend.bridge.a.a(r16, r18, System.currentTimeMillis(), null, 4, null);     // Catch: Exception -> L52
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.bridge.a.a(r10, new $$Lambda$AutoMemoryProBridgeImpl$SRVRqhzoOVJKfNauLtuPdGe8oEM(r6)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L50;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateMemoryRuleCountById(r16.getRuleId());     // Catch: Exception -> L52
        r16.setMemoryId(Long.valueOf(r6.getId()));     // Catch: Exception -> L52
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Exception -> L52
        if (r8 != null) goto L49;
    L37:
        r14 = r9;
        r15 = r12;
    L38:
        r7 = r23;
        goto L20
    L49:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L52
        r19.put("op", "add");     // Catch: Exception -> L52
        r19.put("entity", r6.toJsonObject());     // Catch: Exception -> L52
    L36:
        r8.add(r19);     // Catch: Exception -> L52
        goto L37
    L50:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProExtractFinish insert entity failed, ruleId=" + r6.getRuleId(), null, 4, null);     // Catch: Exception -> L52
        goto L37
    L44:
        r18 = r5;
        goto L45
    L26:
        r23 = r7;
        final AutoMemoryProEntity r20 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(r17.longValue()), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        if (r20 == null) goto L38;
        String r21 = r3.getAppPackages();     // Catch: Exception -> L39
        r9 = r14;
        r12 = r15;
        if (r21 != null) goto L73;
        r21 = "";
    L73:
        com.obric.memorydata.recommend.bridge.a.a(r20, r16, r21, System.currentTimeMillis());     // Catch: Exception -> L52
        com.obric.memorydata.recommend.bridge.a.a(r10, new $$Lambda$AutoMemoryProBridgeImpl$lroqWP5lY21JWB_jno3pX8mk8A(r20));     // Catch: Exception -> L52
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Exception -> L52
        if (r8 == null) goto L37;
        r19 = new JSONObject();     // Catch: Exception -> L52
        r19.put("op", BuildConfig.CHANNEL);     // Catch: Exception -> L52
        r19.put("entity", r20.toJsonObject());     // Catch: Exception -> L52
    L52:
        e = e;
    L39:
        e = e;
    L54:
        r23 = r7;
        r9 = r14;
        r12 = r15;
        goto L64
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);     // Catch: Exception -> L55
        r1 = null;
        goto L11
    L5:
        r8 = null;
        goto L77
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProV2CollectionFinish(String r17) {
        Intrinsics.checkNotNullParameter(r17, "data");
        RunLog.INSTANCE.debug(TAG, "run onAutoMemoryProV2CollectionFinish " + r17);
    L39:
        e = move-exception;
        if (AppContext.INSTANCE.isDebug() == false) goto L43;
    L46:
        throw e;
    L43:
        if (AppContext.INSTANCE.isRoot() == true) goto L46;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "process v2 collection result error, e: " + e, null, 4, null);
        return;
    L4:
        Long r4 = null;
        Object r0 = GsonUtil.INSTANCE.getGSON().fromJson(r17, AutoMemoryProV2CollectionResultData.class);     // Catch: Exception -> L7
    L9:
        AutoMemoryProV2CollectionResultData r1 = (AutoMemoryProV2CollectionResultData) ZeusTransformUtils.preCheckCast(r0, AutoMemoryProV2CollectionResultData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        if (r1 != null) goto L12;
        return;
    L12:
        IStore r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Exception -> L39
        boolean r6 = r5.getBoolean("is_screen_observation_evaluation_enable", false);     // Catch: Exception -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProV2CollectionFinish enter: code=" + r1.getCode() + ", evaluationMode=" + r6 + ", collectionStepFinished=" + r5.getBoolean("auto_memory_collection_step_is_finish", false), false, 4, null);     // Catch: Exception -> L39
        if (r1.getCode() == 0) goto L18;
        if (r6 == false) goto L56;
        FilesKt.appendText$default(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt"), r17 + '\n', null, 2, null);     // Catch: Exception -> L39
        r5.save("auto_memory_collection_step_is_finish", true);     // Catch: Exception -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProV2CollectionFinish failed but marked finished in evaluation mode", false, 4, null);     // Catch: Exception -> L39
        return;
    L56:
        return;
    L18:
        if (r6 == false) goto L20;
        List<JSONObject> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
    L21:
        Map<String, JSONObject> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getRuleResults(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L39
    L23:
        if (r2.hasNext() == false) goto L34;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(((AutoMemoryProV2RuleResultData) ZeusTransformUtils.preCheckCast(r2.next(), AutoMemoryProV2RuleResultData.class, "com.obric.memorydata.plugin")).getMemories(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L39
        Long r14 = r4;
    L26:
        if (r13.hasNext() == false) goto L31;
        AutoMemoryProData r10 = (AutoMemoryProData) ZeusTransformUtils.preCheckCast(r13.next(), AutoMemoryProData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L39
        AutoMemoryProBridgeImpl r15 = INSTANCE;     // Catch: Exception -> L39
        r15.appendAutoMemoryProTraceOp(r12, r10, r15.upsertAutoMemoryPro(r10, r8));     // Catch: Exception -> L39
        if (r14 != null) goto L26;
        r14 = Long.valueOf(r10.getRuleId());     // Catch: Exception -> L39
        goto L26
    L31:
        if (r14 == null) goto L33;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateMemoryRuleCountById(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L39
    L33:
        r4 = null;
        goto L23
    L34:
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Exception -> L39
        reportAutoMemoryProCollectionTrace(r12);     // Catch: Exception -> L39
        if (AppContext.INSTANCE.isDebug() == false) goto L57;
        if (r6 == false) goto L58;
        File r7 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt");     // Catch: Exception -> L39
        StringBuilder r3 = new StringBuilder().append(r17).append('\n');     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L39
        FilesKt.appendText$default(r7, r3.append(u.a(r8)).append('\n').toString(), null, 2, null);     // Catch: Exception -> L39
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C12182(null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L39
        r5.save("auto_memory_collection_step_is_finish", true);     // Catch: Exception -> L39
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProV2CollectionFinish exit: collectionStepFinished=true", false, 4, null);     // Catch: Exception -> L39
        return;
    L58:
        return;
    L57:
        return;
    L20:
        r8 = null;
        goto L21
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);     // Catch: Exception -> L39
        r0 = null;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProV2ExtractFinish(String r44) {
        String r2 = UserSettings.REPO_MEMORY_DATA;
        String r3 = "is_screen_observation_evaluation_enable";
        Intrinsics.checkNotNullParameter(r44, "data");
        String r6 = TAG;
        RunLog.INSTANCE.debug(TAG, "run onAutoMemoryProV2ExtractFinish " + r44);
    L67:
        e = move-exception;
        if (AppContext.INSTANCE.isDebug() == false) goto L71;
    L74:
        throw e;
    L71:
        if (AppContext.INSTANCE.isRoot() == true) goto L74;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "process v2 extract result error, e: " + e, null, 4, null);
        return;
    L76:
        Object r0 = GsonUtil.INSTANCE.getGSON().fromJson(r44, AutoMemoryProV2ExtractResultData.class);     // Catch: Exception -> L7
    L9:
        AutoMemoryProV2ExtractResultData r1 = (AutoMemoryProV2ExtractResultData) ZeusTransformUtils.preCheckCast(r0, AutoMemoryProV2ExtractResultData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        if (r1 != null) goto L12;
        return;
    L12:
        IStore r7 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Exception -> L67
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProV2ExtractFinish enter: code=" + r1.getCode() + ", evaluationMode=" + r7.getBoolean("is_screen_observation_evaluation_enable", false) + ", collectionStepFinished=" + r7.getBoolean("auto_memory_collection_step_is_finish", false), false, 4, null);     // Catch: Exception -> L67
        String r11 = "/extract_process.txt";
        if (r1.getCode() != 0) goto L16;
        List<Long> r10 = r1.getBatchScreenIds();     // Catch: Exception -> L67
        if (r10 != null) goto L23;
        r10 = CollectionsKt.emptyList();     // Catch: Exception -> L67
    L23:
        if (r7.getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L25;
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
    L26:
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getEpisodicList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L67
        int r9 = 0;
        int r12 = 0;
        int r15 = 0;
    L28:
        String r18 = r11;
        if (r14.hasNext() == false) goto L44;
        Iterator r19 = r14;
        AutoMemoryProV2EpisodicData r16 = (AutoMemoryProV2EpisodicData) ZeusTransformUtils.preCheckCast(r14.next(), AutoMemoryProV2EpisodicData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        EpisodicMemoryEntity r17 = com.obric.memorydata.recommend.bridge.a.a(r16, r8);     // Catch: Exception -> L67
        String r20 = r3;
        String r21 = r2;
        int r22 = r9;
        List<Long> r23 = r10;
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r17, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) == false) goto L42;
        r12 = r12 + 1;     // Catch: Exception -> L67
        AutoMemoryProBridgeImpl r4 = INSTANCE;     // Catch: Exception -> L67
        String r5 = r4.resolveV2SourceType$recommend_obricRelease(r16.getSourceType());     // Catch: Exception -> L67
        r13.put(r5, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13.getOrDefault(r5, 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));     // Catch: Exception -> L67
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.normalizeRuleIdList(r16.getRuleIdList()), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L67
        r9 = r22;
    L34:
        if (r24.hasNext() == false) goto L41;
        Iterator r110 = r24;
        int r36 = r12;
        Map r111 = r13;
        long r112 = ((Number) ZeusTransformUtils.preCheckCast(r24.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Exception -> L67
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryEpisodicRelevantDataDao().insertIfAbsent(new t(0, r17.getId(), r112, r16.getCreateTimestamp(), r5, 1, null)) == false) goto L39;
        int r25 = r9 + 1;     // Catch: Exception -> L67
        RunLog.INSTANCE.debug(r6, "insert AutoMemoryEpisodicRelevantData success, memoryId=" + r17.getId() + ", ruleId=" + r112 + ", sourceType=" + r5);     // Catch: Exception -> L67
        String r113 = r6;
    L38:
        r9 = r25;
        r6 = r113;
        r24 = r110;
        r8 = r8;
        r16 = r16;
        r12 = r36;
        r13 = r111;
        goto L34
    L39:
        r25 = r9;
        r113 = r6;
        RunLog.INSTANCE.debug(r113, "insert AutoMemoryEpisodicRelevantData skipped, relation exists, memoryId=" + r17.getId() + ", ruleId=" + r112 + ", sourceType=" + r5 + ", sourceTypeUpdated=" + MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryEpisodicRelevantDataDao().updateEmptySourceTypeByMemoryIdAndRuleId(r17.getId(), r112, r5));     // Catch: Exception -> L67
        goto L38
    L41:
        String r114 = r6;
        List r26 = r8;
        Map r37 = r13;
    L43:
        r6 = r114;
        r11 = r18;
        r14 = r19;
        r3 = r20;
        r2 = r21;
        r10 = r23;
        r8 = r26;
        r13 = r37;
        goto L28
    L42:
        r114 = r6;
        r26 = r8;
        r37 = r13;
        r15 = r15 + 1;     // Catch: Exception -> L67
        r9 = r22;
        goto L43
    L44:
        String r27 = r2;
        String r28 = r3;
        String r115 = r6;
        List r29 = r8;
        int r210 = r9;
        List<Long> r211 = r10;
        Map r38 = r13;
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getSemanticList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L67
        int r32 = 0;
        int r33 = 0;
        int r34 = 0;
    L46:
        if (r31.hasNext() == false) goto L60;
        AutoMemoryProV2SemanticData r116 = (AutoMemoryProV2SemanticData) ZeusTransformUtils.preCheckCast(r31.next(), AutoMemoryProV2SemanticData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        long r117 = System.currentTimeMillis();     // Catch: Exception -> L67
        Iterator r118 = r31;
        List r35 = r29;
        int r212 = r34;
        ip r39 = com.obric.memorydata.recommend.bridge.a.a(r116, r117, r35);     // Catch: Exception -> L67
        int r40 = r12;
        int r310 = r15;
        if (ij.a(r39, null, false, 3, null) == false) goto L58;
        int r41 = r33 + 1;     // Catch: Exception -> L67
        AutoMemoryProBridgeImpl r42 = INSTANCE;     // Catch: Exception -> L67
        String r119 = r42.resolveV2SourceType$recommend_obricRelease(r116.getSourceType());     // Catch: Exception -> L67
        r30.put(r119, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r30.getOrDefault(r119, 0), Number.class, "com.obric.memorydata.plugin")).intValue() + 1));     // Catch: Exception -> L67
        Iterator r43 = ((Iterable) ZeusTransformUtils.preCheckCast(r42.normalizeRuleIdList(r116.getRuleIdList()), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L67
    L51:
        if (r43.hasNext() == false) goto L57;
        Map r120 = r30;
        Iterator r121 = r43;
        long r45 = ((Number) ZeusTransformUtils.preCheckCast(r43.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Exception -> L67
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemorySemanticRelevantDataDao().insertIfAbsent(new ab(0, r39.getId(), r45, r117, r119, 1, null)) == false) goto L55;
        r212 = r212 + 1;     // Catch: Exception -> L67
        RunLog.INSTANCE.debug(r115, "insert AutoMemorySemanticRelevantData success, memoryId=" + r39.getId() + ", ruleId=" + r45 + ", sourceType=" + r119);     // Catch: Exception -> L67
    L56:
        r30 = r120;
        r117 = r117;
        r43 = r121;
        goto L51
    L55:
        r115 = r115;
        RunLog.INSTANCE.debug(r115, "insert AutoMemorySemanticRelevantData skipped, relation exists, memoryId=" + r39.getId() + ", ruleId=" + r45 + ", sourceType=" + r119 + ", sourceTypeUpdated=" + MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemorySemanticRelevantDataDao().updateEmptySourceTypeByMemoryIdAndRuleId(r39.getId(), r45, r119));     // Catch: Exception -> L67
        goto L56
    L57:
        Map r122 = r30;
        r34 = r212;
        r33 = r41;
    L59:
        r30 = r122;
        r31 = r118;
        r29 = r35;
        r15 = r310;
        r12 = r40;
        goto L46
    L58:
        r122 = r30;
        r32 = r32 + 1;     // Catch: Exception -> L67
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onAutoMemoryProV2ExtractFinish insert semantic entity failed, memoryId=" + r39.getId() + ", semanticType=" + r39.a() + ", sourceType=" + INSTANCE.resolveV2SourceType$recommend_obricRelease(r116.getSourceType()), null, 4, null);     // Catch: Exception -> L67
        r34 = r212;
        goto L59
    L60:
        List r311 = r29;
        IRunLog r213 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L67
        IRunLog.a.a(r213, TAG, "onAutoMemoryProV2ExtractFinish done, batch_count: " + r211.size() + ", episodic_count: " + r1.getEpisodicList().size() + ", episodic_indexed_count: " + r12 + ", episodic_index_failed_count: " + r15 + ", episodic_relation_count: " + r210 + ", episodic_source_type_count: " + r38 + ", semantic_count: " + r1.getSemanticList().size() + ", semantic_indexed_count: " + r33 + ", semantic_index_failed_count: " + r32 + ", semantic_relation_count: " + r34 + ", semantic_source_type_count: " + r30, false, 4, null);     // Catch: Exception -> L67
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Exception -> L67
        if (AppContext.INSTANCE.isDebug() == true) goto L63;
    L65:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(AUTO_MEMORY_PRO_V2_COLLECTION_TASK).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Exception -> L67
        return;
    L63:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r27, 0, 2, null).getBoolean(r28, false) == false) goto L65;
        File r46 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + r18);     // Catch: Exception -> L67
        StringBuilder r47 = new StringBuilder().append(r44).append('\n');     // Catch: Exception -> L67
        Intrinsics.checkNotNull(r311);     // Catch: Exception -> L67
        FilesKt.appendText$default(r46, r47.append(u.a(r311)).append('\n').toString(), null, 2, null);     // Catch: Exception -> L67
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L67
        goto L65
    L25:
        r8 = null;
        goto L26
    L16:
        if (r7.getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L88;
        FilesKt.appendText$default(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt"), r44 + '\n', null, 2, null);     // Catch: Exception -> L67
        return;
    L88:
        return;
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);     // Catch: Exception -> L67
        r0 = null;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public long onCreateAutoMemoryRule(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return MemoryService.INSTANCE.createAutoMemoryRule(r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean onDeleteCollectionRule(long r1) {
        return MemoryService.INSTANCE.deleteCollectionRule(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean onUpdateCollectionRule(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        return MemoryService.INSTANCE.updateCollectionRule(r1, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public String resolveAutoMemoryIconKey(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "semanticKey");
        Intrinsics.checkNotNullParameter(r2, "oldIconKey");
        Intrinsics.checkNotNullParameter(r3, "stableSeed");
        return MemoryService.INSTANCE.resolveAutoMemoryIconKey(r1, r2, r3);
    }

    public final String resolveV2SourceType$recommend_obricRelease(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceType");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L6;
        r1 = SOURCE_TYPE_SCREEN_OBSERVATION;
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    }
}
