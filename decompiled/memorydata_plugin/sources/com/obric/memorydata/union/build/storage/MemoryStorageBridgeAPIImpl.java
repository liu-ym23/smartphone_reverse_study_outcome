package com.obric.memorydata.union.build.storage;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryIslandService;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.union.build.EpisodicBuildResultItem;
import com.obric.memorydata.union.build.SemanticBuildResultItemV2;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0000H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0016\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u001cH\u0016J \u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/union/build/storage/MemoryStorageBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IMemoryStorageBridgeAPI;", "<init>", "()V", "TAG", "", "AUTO_MEMORY_PRO_V2_COLLECTION_TASK", "BUSINESS_TYPE_REGEX", "Lkotlin/text/Regex;", "getInst", "insertSemanticEntity", "payload", "updateSemanticEntity", "commitSemanticBatch", "commitConsumerOutput", "supersedeMemoryProcessSources", "", "batchFailure", "Lcom/obric/memorydata/union/build/storage/SemanticBatchCommitResult;", "code", "message", "delegateSemanticToV2Handler", "opLabel", "triggerAutoMemoryProV2CollectionEnqueueIfNeeded", "", "resultCode", MemoryInfoSectionEditActivity.EXTRA_KIND, "deleteSemanticEntity", "", "entityId", "insertEpisodicEntity", "updateEpisodicEntity", "upsertRuleEpisodicMemory", "delegateEpisodicToHandler", "deleteEpisodicEntity", "rebuildEntityIndex", "batchRebuildEntityIndex", "entityIds", "", "querySemanticByKeyPhrase", "keyPhrase", "limit", "queryEpisodicByEntityId", "triggerGlobalIndex", InfoRequestQPSOptTraceLogger.REASON, "showMemoryIsland", "showScreenshotEffect", "isMemoryTraceReportEnabled", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryStorageBridgeAPIImpl implements IMemoryStorageBridgeAPI {
    private static final String AUTO_MEMORY_PRO_V2_COLLECTION_TASK = "auto_memory_pro_cloud_v2_collection";
    private static final Regex BUSINESS_TYPE_REGEX = null;
    public static final MemoryStorageBridgeAPIImpl INSTANCE = null;
    private static final String TAG = "MemoryStorageBridgeAPI";

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends EpisodicBuildResultItem>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends SemanticBuildResultItemV2>> {
        public b() {
        }
    }

    static {
        INSTANCE = new MemoryStorageBridgeAPIImpl();
        BUSINESS_TYPE_REGEX = new Regex("\"businessType\"\\s*:\\s*\"([^\"]+)\"");
    }

    private MemoryStorageBridgeAPIImpl() {
    }

    private final SemanticBatchCommitResult batchFailure(String r3, String r4) {
        return new SemanticBatchCommitResult(0, CollectionsKt.listOf(new SemanticBatchFailure("batch", r3, r4)), null, CollectionsKt.emptyList());
    }

    private final String delegateEpisodicToHandler(String r26, String r27) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L100;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r27 + "EpisodicEntity rejected: blank payload", null, 4, null);
        return "";
    L100:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L54
        MemoryStorageBridgeAPIImpl r1 = (MemoryStorageBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, MemoryStorageBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        MatchResult r2 = Regex.find$default(new Regex("\"content\"\\s*:\\s*\"((?:[^\"\\\\]|\\\\.)*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L54
        if (r2 == null) goto L14;
        List<String> r3 = r2.getGroupValues();     // Catch: Throwable -> L54
        if (r3 == null) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r4 == null) goto L14;
    L15:
        int r11 = r4.length();     // Catch: Throwable -> L54
        String r5 = Integer.toString(r4.hashCode(), CharsKt.checkRadix(16));     // Catch: Throwable -> L54
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");     // Catch: Throwable -> L54
        MatchResult r13 = Regex.find$default(new Regex("\"entityIdList\"\\s*:\\s*(\\[[^\\]]*\\])"), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L54
        if (r13 == null) goto L22;
        List<String> r14 = r13.getGroupValues();     // Catch: Throwable -> L54
        if (r14 == null) goto L22;
        String r15 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r14, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r15 == null) goto L22;
    L23:
        MatchResult r16 = Regex.find$default(new Regex("\"logId\"\\s*:\\s*\"([^\"]*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L54
        if (r16 == null) goto L31;
        List<String> r17 = r16.getGroupValues();     // Catch: Throwable -> L54
        if (r17 == null) goto L31;
        String r7 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r17, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r7 == null) goto L31;
    L32:
        MatchResult r8 = Regex.find$default(new Regex("\"businessType\"\\s*:\\s*\"([^\"]*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L54
        if (r8 == null) goto L39;
        List<String> r9 = r8.getGroupValues();     // Catch: Throwable -> L54
        if (r9 == null) goto L39;
        String r10 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r9, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r10 == null) goto L39;
    L40:
        MatchResult r12 = Regex.find$default(new Regex("\"action\"\\s*:\\s*\"([^\"]*)\""), (CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L54
        if (r12 == null) goto L51;
        List<String> r18 = r12.getGroupValues();     // Catch: Throwable -> L48
        if (r18 == null) goto L51;
        String r19 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r18, 1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r19 == null) goto L51;
    L52:
        StackTraceElement[] r110 = Thread.currentThread().getStackTrace();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullExpressionValue(r110, "getStackTrace(...)");     // Catch: Throwable -> L54
        RunLog.INSTANCE.debug(TAG, "[LOGID_TRACE][ANDROID_STORAGE_IN] api=" + r27 + "EpisodicEntity businessType=" + r10 + " action=" + r19 + " logId=" + r7 + " payloadLen=" + r26.length() + " contentLen=" + r11 + " contentHash=" + r5 + " entityIdList=" + r15 + " stack=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.drop((Object[]) ZeusTransformUtils.preCheckCast(r110, Object[].class, "com.obric.memorydata.plugin"), 2), Iterable.class, "com.obric.memorydata.plugin"), 8), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" <- ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$MemoryStorageBridgeAPIImpl$21VUzLGnFAHYWlc7RaswushHw.INSTANCE, 30, null) + ']');     // Catch: Throwable -> L54
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L102:
        String r6 = new com.obric.memorydata.union.build.k('[' + r26 + ']').a();     // Catch: Throwable -> L93
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        if (r20 != null) goto L59;
    L62:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r27 + "EpisodicEntity handler returned blank", null, 4, null);     // Catch: Throwable -> L93
        return "";
    L66:
        GsonUtil r21 = GsonUtil.INSTANCE;     // Catch: Throwable -> L93
        if (r6 != null) goto L69;
    L77:
        List r22 = null;
    L78:
        if (r22 != null) goto L80;
        r22 = CollectionsKt.emptyList();     // Catch: Throwable -> L93
    L80:
        EpisodicBuildResultItem r23 = (EpisodicBuildResultItem) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r22), EpisodicBuildResultItem.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        if (r23 != null) goto L83;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r27 + "EpisodicEntity result array empty, raw=" + r6, null, 4, null);     // Catch: Throwable -> L93
        return "";
    L83:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[LOGID_TRACE][ANDROID_STORAGE_RESULT] api=" + r27 + "EpisodicEntity code=" + r23.getCode() + " newEntityId=" + r23.getNewEntityId() + " oldEntityIds=" + r23.getOldEntityIdList(), false, 4, null);     // Catch: Throwable -> L93
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L86
        ((MemoryStorageBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, MemoryStorageBridgeAPIImpl.class, "com.obric.memorydata.plugin")).triggerAutoMemoryProV2CollectionEnqueueIfNeeded(r23.getCode(), r26, "episodic");     // Catch: Throwable -> L86
        Object r25 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L86
    L88:
        Throwable r28 = Result.m1424exceptionOrNullimpl(r25);     // Catch: Throwable -> L93
        if (r28 == null) goto L104;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "triggerAutoMemoryProV2CollectionEnqueue(episodic) failed, err=" + r28.getMessage(), null, 4, null);     // Catch: Throwable -> L93
    L104:
        return GsonUtil.INSTANCE.toJson(r23);
    L86:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L93
        r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L93
        goto L88
    L69:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L71;
        boolean r30 = true;
    L72:
        if (r30 == false) goto L74;
        String r31 = r6;
    L75:
        if (r31 == null) goto L77;
        r22 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r31, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        goto L78
    L74:
        r31 = null;
        goto L75
    L71:
        r30 = false;
        goto L72
    L59:
        if (StringsKt.isBlank(r20) == true) goto L62;
        r111 = false;
    L93:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r27 + "EpisodicEntity failed, err=" + th.getMessage(), null, 4, null);
        return "";
    L48:
        th = th;
    L55:
        Result.Companion r32 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L51:
        r19 = "<missing>";
    L39:
        r10 = "<missing>";
    L31:
        r7 = "<missing>";
    L22:
        r15 = "<none>";
    L14:
        r4 = "";
    L54:
        th = th;
        goto L55
    }

    private static final CharSequence delegateEpisodicToHandler$lambda$5$lambda$4(StackTraceElement r5) {
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getClassName();
        Intrinsics.checkNotNullExpressionValue(r1, "getClassName(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.append(StringsKt.substringAfterLast$default(r1, '.', null, 2, null)).append('.').append(r5.getMethodName()).append(':').append(r5.getLineNumber()).toString(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String delegateSemanticToV2Handler(String r11, String r12) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L46;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r12 + "SemanticEntity rejected: blank payload", null, 4, null);
        return "";
    L46:
        String r0 = new com.obric.memorydata.union.build.o('[' + r11 + ']').a();     // Catch: Throwable -> L41
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        boolean r4 = false;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r12 + "SemanticEntity handler returned blank", null, 4, null);     // Catch: Throwable -> L41
        return "";
    L16:
        GsonUtil r6 = GsonUtil.INSTANCE;     // Catch: Throwable -> L41
        List r7 = null;
        if (r0 != null) goto L19;
    L26:
        if (r7 != null) goto L28;
        r7 = CollectionsKt.emptyList();     // Catch: Throwable -> L41
    L28:
        SemanticBuildResultItemV2 r8 = (SemanticBuildResultItemV2) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7), SemanticBuildResultItemV2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (r8 != null) goto L44;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r12 + "SemanticEntity result array empty, raw=" + r0, null, 4, null);     // Catch: Throwable -> L41
        return "";
    L44:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L34
        ((MemoryStorageBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, MemoryStorageBridgeAPIImpl.class, "com.obric.memorydata.plugin")).triggerAutoMemoryProV2CollectionEnqueueIfNeeded(r8.getCode(), r11, "semantic");     // Catch: Throwable -> L34
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r10);     // Catch: Throwable -> L41
        if (r13 == null) goto L47;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "triggerAutoMemoryProV2CollectionEnqueue(semantic) failed, err=" + r13.getMessage(), null, 4, null);     // Catch: Throwable -> L41
    L47:
        return GsonUtil.INSTANCE.toJson(r8);
    L34:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L41
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L36
    L19:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L21;
        r4 = true;
    L21:
        if (r4 == false) goto L23;
        String r9 = r0;
    L24:
        if (r9 == null) goto L26;
        r7 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r9, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        goto L26
    L23:
        r9 = null;
        goto L24
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r5 = false;
    L41:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r12 + "SemanticEntity failed, err=" + th.getMessage(), null, 4, null);
        return "";
    }

    @JvmStatic
    public static final MemoryStorageBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$2-1VUzLGnFAH-YWlc7RaswushHw, reason: not valid java name */
    public static /* synthetic */ CharSequence m1235lambda$21VUzLGnFAHYWlc7RaswushHw(StackTraceElement r0) {
        return delegateEpisodicToHandler$lambda$5$lambda$4(r0);
    }

    private final void triggerAutoMemoryProV2CollectionEnqueueIfNeeded(String r7, String r8, String r9) {
        if (Intrinsics.areEqual(r7, BDLocationException.SUCCESS) == true) goto L5;
        return;
    L5:
        String r2 = null;
        MatchResult r6 = Regex.find$default(BUSINESS_TYPE_REGEX, (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r6 == null) goto L11;
        List<String> r10 = r6.getGroupValues();
        if (r10 == null) goto L11;
        r2 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r10, 1), String.class, "com.obric.memorydata.plugin");
    L11:
        if (Intrinsics.areEqual(r2, "autoMemory") == true) goto L14;
        return;
    L14:
        if (((Boolean) ZeusTransformUtils.preCheckCast(MemoryService.INSTANCE.autoMemoryEffectiveEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L18;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("triggerAutoMemoryProV2CollectionEnqueue skipped, reason=auto_memory_disabled, kind=").append(r9);
    L16:
        IRunLog.a.a(r0, TAG, r11.toString(), false, 4, null);
        return;
    L18:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(AUTO_MEMORY_PRO_V2_COLLECTION_TASK).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r11 = new StringBuilder().append("triggerAutoMemoryProV2CollectionEnqueue ok, kind=").append(r9).append(", task=auto_memory_pro_cloud_v2_collection");
        goto L16
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean batchRebuildEntityIndex(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entityIds");
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "batchRebuildEntityIndex triggered, size=" + r7.size(), false, 4, null);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "batchRebuildEntityIndex failed, size=" + r7.size() + ", err=" + th.getMessage(), null, 4, null);
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String commitConsumerOutput(String r9) {
        Intrinsics.checkNotNullParameter(r9, "payload");
    L12:
        return GsonUtil.INSTANCE.toJson(m.f13129a.a(r9));
    L7:
        GsonUtil r8 = GsonUtil.INSTANCE;
        SemanticConsumerCommitResult r10 = new SemanticConsumerCommitResult(false, "INVALID_CONSUMER_OUTPUT", 0, 0, 8, null);
    L9:
        return r8.toJson(r10);
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "commitConsumerOutput failed, errorType=" + th.getClass().getSimpleName(), null, 4, null);
        r8 = GsonUtil.INSTANCE;
        r10 = new SemanticConsumerCommitResult(false, "CONSUMER_COMMIT_FAILED", 0, 0, 8, null);
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String commitSemanticBatch(String r10) {
        Intrinsics.checkNotNullParameter(r10, "payload");
        SemanticBatchCommitResult r11 = h.f13122a.a(r10);     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        if (r11.getAppliedCount() > 0) goto L19;
    L12:
    L23:
        return GsonUtil.INSTANCE.toJson(r11);
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        MemoryStorageBridgeAPIImpl r2 = (MemoryStorageBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, MemoryStorageBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L7
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        if (r4 == null) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "索引任务启动失败 code=INDEX_LAUNCH_FAILED committed=true error_class=" + r4.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        goto L12
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14 IllegalArgumentException -> L15
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L14 IllegalArgumentException -> L15
    L15:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "批量提交拒绝 code=INVALID_BATCH error_class=" + e.getClass().getSimpleName(), null, 4, null);
        GsonUtil r12 = GsonUtil.INSTANCE;
        String r0 = "INVALID_BATCH";
        String r6 = "invalid semantic batch";
    L18:
        return r12.toJson(batchFailure(r0, r6));
    L14:
        r12 = GsonUtil.INSTANCE;
        r0 = "BATCH_FAILED";
        r6 = "semantic batch transaction failed";
        goto L18
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean deleteEpisodicEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "entityId");
        boolean r1 = false;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteEpisodicEntity rejected: blank entityId", null, 4, null);
        return false;
    L15:
        EpisodicMemoryEntity r9 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r10);     // Catch: Throwable -> L11
        if (r9 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteEpisodicEntity skipped: entity not found, entityId=" + r10, false, 4, null);     // Catch: Throwable -> L11
    L14:
    L13:
        return r1;
    L9:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().deleteById(r9.getId());     // Catch: Throwable -> L11
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L11
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteEpisodicEntity ok, entityId=" + r10 + ", dbId=" + r9.getId(), false, 4, null);     // Catch: Throwable -> L11
        r1 = true;
    L11:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteEpisodicEntity failed, entityId=" + r10 + ", err=" + th.getMessage(), null, 4, null);
        goto L13
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean deleteSemanticEntity(String r9) {
        Intrinsics.checkNotNullParameter(r9, "entityId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteSemanticEntity rejected: blank entityId", null, 4, null);
        return false;
    L11:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().deleteByEntityIds(CollectionsKt.listOf(r9));     // Catch: Throwable -> L8
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L8
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteSemanticEntity ok, entityId=" + r9, false, 4, null);     // Catch: Throwable -> L8
        return true;
    L8:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteSemanticEntity failed, entityId=" + r9 + ", err=" + th.getMessage(), null, 4, null);
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String insertEpisodicEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return delegateEpisodicToHandler(r2, "insert");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String insertSemanticEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return delegateSemanticToV2Handler(r2, "insert");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean isMemoryTraceReportEnabled() {
        return com.obric.memorydata.database.c.b.f8850a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String queryEpisodicByEntityId(String r9) {
        Intrinsics.checkNotNullParameter(r9, "entityId");
        EpisodicMemoryEntity r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r9);     // Catch: Throwable -> L8
        if (r0 == null) goto L13;
        return GsonUtil.INSTANCE.toJson(CollectionsKt.listOf(r0));
    L13:
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L8:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryEpisodicByEntityId failed, entityId=" + r9 + ", err=" + th.getMessage(), null, 4, null);
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String querySemanticByKeyPhrase(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "keyPhrase");
        return GsonUtil.INSTANCE.toJson(CollectionsKt.listOfNotNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getSameMemory("", r7)));
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "querySemanticByKeyPhrase failed, keyPhrase=" + r7 + ", err=" + th.getMessage(), null, 4, null);
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean rebuildEntityIndex(String r8) {
        Intrinsics.checkNotNullParameter(r8, "entityId");
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "rebuildEntityIndex triggered, entityId=" + r8, false, 4, null);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "rebuildEntityIndex failed, entityId=" + r8 + ", err=" + th.getMessage(), null, 4, null);
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean reportMemoryTraceOps(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "logId");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "memoryOpsJson");
        return MemoryService.INSTANCE.reportMemoryTraceOps(r1, r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void showMemoryIsland(String r8) {
        Intrinsics.checkNotNullParameter(r8, "payload");
        JSONObject r0 = new JSONObject(r8);     // Catch: Throwable -> L34
        String r9 = r0.optString("entityId");     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L34
        MemoryEntity r2 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r9 = null;
    L7:
        if (r9 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showMemoryIsland ignored: entityId empty", null, 4, null);     // Catch: Throwable -> L34
        return;
    L10:
        JSONArray r1 = r0.optJSONArray("oldEntityIdList");     // Catch: Throwable -> L34
        if (r1 == null) goto L17;
        String r3 = r1.optString(0);     // Catch: Throwable -> L34
        if (r3 == null) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
    L18:
        if (r3 != null) goto L21;
        State r4 = State.SUCCESS_NEW;     // Catch: Throwable -> L34
    L20:
        int r5 = r4.ordinal();     // Catch: Throwable -> L34
        ip r6 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r9);     // Catch: Throwable -> L34
        if (r6 == null) goto L32;
        if (r3 == null) goto L26;
        ip r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r3);     // Catch: Throwable -> L34
    L27:
        MemoryIslandService r10 = MemoryIslandService.INSTANCE;     // Catch: Throwable -> L34
        MemoryEntity r11 = iq.a(r6);     // Catch: Throwable -> L34
        if (r7 == null) goto L30;
        r2 = iq.a(r7);     // Catch: Throwable -> L34
    L30:
        r10.showMemory(r9, r5, r11, r2);     // Catch: Throwable -> L34
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showMemoryIsland semantic ok, entityId=" + r9, false, 4, null);     // Catch: Throwable -> L34
        return;
    L26:
        r7 = null;
        goto L27
    L32:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showMemoryIsland skipped: entity not semantic, entityId=" + r9, false, 4, null);     // Catch: Throwable -> L34
        return;
    L21:
        r4 = State.SUCCESS_UPDATE;     // Catch: Throwable -> L34
    L17:
        r3 = null;
    L34:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showMemoryIsland failed, err=" + th.getMessage(), null, 4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void showScreenshotEffect() {
        MemoryIslandService.INSTANCE.showEffect();     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showScreenshotEffect ok", false, 4, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "showScreenshotEffect failed, err=" + th.getMessage(), null, 4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public int supersedeMemoryProcessSources(String r7) {
        Intrinsics.checkNotNullParameter(r7, "payload");
        return c.f13116a.a(r7);
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "supersedeMemoryProcessSources failed, errorType=" + th.getClass().getSimpleName(), null, 4, null);
        return -1;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void triggerGlobalIndex(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "triggerGlobalIndex done, reason=" + r8, false, 4, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "triggerGlobalIndex failed, reason=" + r8 + ", err=" + th.getMessage(), null, 4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String updateEpisodicEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return delegateEpisodicToHandler(r2, BuildConfig.CHANNEL);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String updateSemanticEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return delegateSemanticToV2Handler(r2, BuildConfig.CHANNEL);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String upsertRuleEpisodicMemory(String r14) {
        Intrinsics.checkNotNullParameter(r14, "payload");
        Object r15 = GsonUtil.INSTANCE.getGSON().fromJson(r14, RuleEpisodicMemoryPayload.class);     // Catch: Exception -> L5
    L7:
        RuleEpisodicMemoryPayload r16 = (RuleEpisodicMemoryPayload) ZeusTransformUtils.preCheckCast(r15, RuleEpisodicMemoryPayload.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L13;
        GsonUtil r13 = GsonUtil.INSTANCE;
        RuleEpisodicMemoryResult.a r17 = RuleEpisodicMemoryResult.Companion;
        String r0 = "invalid_payload";
    L11:
        return r13.toJson(r17.a(r0));
    L13:
        if (r16.isValid() == true) goto L35;
        r13 = GsonUtil.INSTANCE;
        r17 = RuleEpisodicMemoryResult.Companion;
        r0 = "missing_required_field";
        goto L11
    L35:
        EpisodicMemoryDao r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();     // Catch: Throwable -> L32
        String r2 = r16.getEntityId();     // Catch: Throwable -> L32
        if (r2 == null) goto L31;
        EpisodicMemoryEntity r3 = r1.queryByEntityId(r2);     // Catch: Throwable -> L32
        EpisodicMemoryEntity r18 = r16.toEntity(r3, System.currentTimeMillis());     // Catch: Throwable -> L32
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r18, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) == false) goto L20;
        EntityManager.INSTANCE.launchIndexTask();     // Catch: Throwable -> L32
        EpisodicMemoryEntity r19 = r1.queryByEntityId(r18.getEntityId());     // Catch: Throwable -> L32
        if (r19 == null) goto L24;
        GsonUtil r4 = GsonUtil.INSTANCE;     // Catch: Throwable -> L32
        String r6 = r19.getEntityId();     // Catch: Throwable -> L32
        Long r7 = Long.valueOf(r19.getId());     // Catch: Throwable -> L32
        if (r3 != null) goto L28;
        String r110 = "insert";
    L38:
        return r4.toJson(new RuleEpisodicMemoryResult(null, null, r6, r7, r110, true, true, 3, null));
    L28:
        r110 = BuildConfig.CHANNEL;
        goto L38
    L24:
        return GsonUtil.INSTANCE.toJson(RuleEpisodicMemoryResult.Companion.b("query_after_write_failed"));
    L20:
        return GsonUtil.INSTANCE.toJson(RuleEpisodicMemoryResult.Companion.b("index_failed"));
    L31:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.k.f11624a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "Rule episodic memory upsert failed", "rule_episodic_upsert", "write_failed", th, null, null, 48, null);
        return GsonUtil.INSTANCE.toJson(RuleEpisodicMemoryResult.Companion.b("write_failed"));
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r15 = null;
        goto L7
    }
}
