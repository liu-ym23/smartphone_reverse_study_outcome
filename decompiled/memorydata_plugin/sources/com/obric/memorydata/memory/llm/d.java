package com.obric.memorydata.memory.llm;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.at;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.da;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010+\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010.0,2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010-2\b\b\u0002\u00108\u001a\u000209H\u0086@¢\u0006\u0002\u0010:Jb\u0010;\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010.0,2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010-2\b\b\u0002\u00108\u001a\u000209H\u0082@¢\u0006\u0002\u0010:JT\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020#2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010B2\u001c\b\u0002\u0010C\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050B\u0018\u00010.H\u0002J\u0012\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050B*\u00020EH\u0002J&\u0010F\u001a\u00020=2\b\u0010G\u001a\u0004\u0018\u00010H2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010JH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelper;", "", "<init>", "()V", "TAG", "", "TIMEOUT_TASK", "", "TIMEOUT_MEMORY", "KEY_QUERY", "KEY_SCREENSHOT_PATH", "KEY_TEXT", "KEY_APP_NAME", "KEY_PACKAGE_NAME", "KEY_ACTIVITY_NAME", "KEY_CHAT_HISTORY", "KEY_REF_MEMORY_ENTITIES", "KEY_SUB_INTENT", "KEY_OUT_STAGE", "VALUE_OUT_STAGE_MEMORY", "VALUE_OUT_STAGE_STREAM", "VALUE_OUT_STAGE_FINISH", "VALUE_OUT_STAGE_ONCE", "VALUE_OUT_STAGE_INTERRUPT", "KEY_OUT_CONTENT", "KEY_OUT_EXTRAS", "KEY_OUT_TOS_COST", "KEY_OUT_CLASSIFY_COST", "KEY_OUT_EXTRACT_COST", "KEY_OUT_RETRIEVE_COST", "KEY_OUT_DATA", "KEY_OUT_MODIFIED_ID", "KEY_OUT_ACTION", "KEY_MODIFIED_IDS", "VALUE_ACTION_CREATE", "", "VALUE_ACTION_UPDATE", "KEY_OUT_SOURCE", "VALUE_OUT_SOURCE_USER_QUERY", "VALUE_OUT_SOURCE_CHAT_HISTORY", "VALUE_OUT_SOURCE_SCREENSHOT", "VALUE_OUT_SOURCE_SCREEN_CONTENT", "KEY_SCHEDULES", "executeMemoryBuildByLLM", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "", "trackingEvent", "Lcom/obric/memorydata/memory/tracker/MemoryLLMExtractTracker$TrackingEvent;", "inputData", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;", "memorySourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "pageContextResult", "Lcom/obric/memorydata/dc/PageContextResult;", "retryEntity", "isDebug", "", "(Lcom/obric/memorydata/memory/tracker/MemoryLLMExtractTracker$TrackingEvent;Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;Lcom/obric/memorydata/dc/PageContextResult;Lcom/obric/capabilitykit/entity/memory/MemoryEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "updateMemoryEntityIfNeeded", "", ObricMemoryConstants.KEY_SESSION_ID, "detailStatusType", "summary", "tags", "", "entities", "toStringList", "Lorg/json/JSONArray;", "buildExtraMapByExtras", "extras", "Lorg/json/JSONObject;", "extraMap", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10280a = null;

    static {
        f10280a = new d();
    }

    private d() {
    }

    public static final /* synthetic */ Object a(d r8, com.obric.memorydata.memory.tracker.d.b r9, e r10, com.obric.memorydata.memory.memoryentity.f r11, PageContextResult r12, MemoryEntity r13, boolean r14, Continuation r15) {
        return r8.b(r9, r10, r11, r12, r13, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List a(d r0, JSONArray r1) {
        return r0.a(r1);
    }

    private final List<String> a(JSONArray r4) {
        ArrayList r3 = new ArrayList(r4.length());
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        r3.add(r4.optString(r1));
        r1 = r1 + 1;
        goto L3
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(d r8, String r9, int r10, String r11, List r12, Map r13) {
        r8.a(r9, r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(d r7, String r8, int r9, String r10, List r11, Map r12, int r13, Object r14) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        List<String> r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        Map<String, ? extends List<String>> r6 = null;
    L14:
        r7.a(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r16;
        goto L14
    L9:
        r5 = r15;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public static final /* synthetic */ void a(d r2, JSONObject r3, Map r4) {
        r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r11, int r12, String r13, List<String> r14, Map<String, ? extends List<String>> r15) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<String>> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin");
        j r17 = k.f10296a.d(r11);
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("updateMemoryEntityIfNeeded sessionId: ").append(r11).append(", detailStatusType: ").append(r12).append(", session: ");
        boolean r8 = false;
        if (r17 == null) goto L5;
        boolean r3 = true;
    L6:
        IRunLog.a.a(r2, "MemoryLLMBuildHelper", r1.append(r3).toString(), false, 4, null);
        if (r17 == null) goto L40;
        MemoryEntity r4 = r17.f();
        if (r4 != null) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, CommonTextMemoryEntity.class) == false) goto L20;
        if (r10 == null) goto L17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).setTagList(r10);
    L17:
        if (at.a(r13) == false) goto L20;
        CommonTextMemoryEntity r5 = (CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r4, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r13);
        r5.setSummary(r13);
    L20:
        if (r12 != 2) goto L24;
        if (r16 == null) goto L23;
        r17.a(r16);
    L23:
        k.f10296a.a(r11);
    L24:
        r4.setDetailStatus(r12);
        r4.setLastModifiedTime(System.currentTimeMillis());
        if (com.obric.memorydata.memory.utils.f.f11537a.a(r4) == null) goto L38;
        MemoryEntityManager r18 = MemoryEntityManager.INSTANCE;
        if (at.a(r13) == true) goto L36;
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L31;
    L34:
        boolean r110 = true;
    L35:
        if (r110 == false) goto L36;
    L37:
        r18.indexDirectly(r4, r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "MemoryKeyInfoEntity insert result: " + MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryKeyInfoDao().batchUpsertManual(r4.getId(), r17.a()), false, 4, null);
        return;
    L31:
        if (r19.isEmpty() == true) goto L34;
        r110 = false;
    L36:
        r8 = true;
        goto L37
    L38:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "MemoryEntity with id " + r4.getId() + " not exist.", null, 4, null);
        return;
    L40:
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void a(JSONObject r12, Map<String, Object> r13) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        long r0 = 0;
        if (r12 == null) goto L5;
        long r2 = r12.optLong("tos_cost");
    L7:
        if (r12 == null) goto L9;
        long r5 = r12.optLong("retrieve_cost");
    L11:
        if (r12 == null) goto L13;
        long r8 = r12.optLong("classify_cost");
    L15:
        if (r12 == null) goto L17;
        r0 = r12.optLong("extract_cost");
    L17:
        r11.put("tos_cost", Long.valueOf(r2));
        r11.put("retrieve_cost", Long.valueOf(r5));
        r11.put("classify_cost", Long.valueOf(r8));
        r11.put("extract_cost", Long.valueOf(r0));
        return;
    L13:
        r8 = 0;
        goto L15
    L9:
        r5 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L7
    }

    private final Object b(com.obric.memorydata.memory.tracker.d.b r23, e r24, com.obric.memorydata.memory.memoryentity.f r25, PageContextResult r26, MemoryEntity r27, boolean r28, Continuation<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r29) {
        d r1 = this;
        boolean r2 = r28;
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r29, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MemoryLLMBuildHelper$execute$1.class) == false) goto L7;
        MemoryLLMBuildHelper$execute$1 r4 = (MemoryLLMBuildHelper$execute$1) ZeusTransformUtils.preCheckCast(r0, MemoryLLMBuildHelper$execute$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        boolean r7 = r4.Z$0;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r4.L$2, Map.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.tracker.d.b r10 = (com.obric.memorydata.memory.tracker.d.b) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.memorydata.memory.tracker.d.b.class, "com.obric.memorydata.plugin");
        d r11 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: TimeoutCancellationException -> L14
        String r12 = r8;
        com.obric.memorydata.memory.tracker.d.b r13 = r10;
        Object r21 = "errorCode";
        r2 = r7;
        r1 = r11;
    L78:
        return (Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin");
    L48:
        e = e;
        d r14 = r1;
    L60:
        RunLog.INSTANCE.warn("MemoryLLMBuildHelper", "executeMemoryBuildByLLM memory timeout", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Object r15 = r21;
        r9.put(r15, Boxing.boxInt(NetError.ERR_CERT_AUTHORITY_INVALID));
        if (r2 == true) goto L77;
        a(r14, r12, 3, null, null, null, 28, null);
        k.a(k.f10296a, r12, SessionStatus.FAILED, null, 4, null);
        Object r16 = r9.get(r15);
        if (ZeusTransformUtils.instanceOf(r16, Integer.class) == false) goto L65;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16, Integer.class, "com.obric.memorydata.plugin");
    L66:
        if (r17 == null) goto L68;
        int r18 = r17.intValue();
    L69:
        Object r19 = r9.get(DTraitConstant.ERROR);
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L72;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
    L73:
        if (r20 != null) goto L75;
        r20 = "";
    L75:
        r13.a(r18, r20);
        goto L77
    L72:
        r20 = null;
        goto L73
    L68:
        r18 = 0;
        goto L69
    L65:
        r17 = null;
    L77:
        return TuplesKt.to(null, r9);
    L14:
        e = e;
        r12 = r8;
        r14 = r11;
        r13 = r10;
        r21 = "errorCode";
        r2 = r7;
        goto L60
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        if (r27 != null) goto L25;
        if (r25 != null) goto L25;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "memorySourceInfo is null, skip build memory", null, 4, null);
        Map r22 = MapsKt.emptyMap();
    L23:
        return TuplesKt.to(null, r22);
    L25:
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "network not available", null, 4, null);
        r22 = MapsKt.mapOf(TuplesKt.to("errorCode", Boxing.boxInt(-200)));
        goto L23
    L27:
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L30;
    L32:
        String r110 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        if (r2 == false) goto L36;
        boolean r111 = true;
    L37:
        r21 = "errorCode";
        Function2 r31 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelper$execute$2(r24, r30, r25, r111, r110, r27, r26, r23, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: TimeoutCancellationException -> L54
        r4.L$0 = r1;     // Catch: TimeoutCancellationException -> L54
        r13 = r23;
        r4.L$1 = r13;     // Catch: TimeoutCancellationException -> L52
        r4.L$2 = r30;     // Catch: TimeoutCancellationException -> L52
        r12 = r110;
        r4.L$3 = r12;     // Catch: TimeoutCancellationException -> L50
        r4.Z$0 = r2;     // Catch: TimeoutCancellationException -> L50
        r4.label = 1;     // Catch: TimeoutCancellationException -> L50
        r3 = da.a(30000, r31, r4);     // Catch: TimeoutCancellationException -> L50
        if (r3 != r5) goto L45;
        return r5;
    L45:
        r9 = r30;
    L50:
        e = e;
    L59:
        r14 = r1;
        r9 = r30;
    L52:
        e = e;
    L56:
        r12 = r110;
    L54:
        e = e;
        r13 = r23;
        goto L56
    L36:
        r111 = false;
    L57:
        e = e;
        r13 = r23;
        r21 = "errorCode";
        r12 = r110;
        goto L59
    L30:
        if (com.obric.memorydata.utils.b.b(r24.h()) == false) goto L32;
        Integer r32 = r24.h();
        Intrinsics.checkNotNull(r32);
        r30.put("subIntent", r32);
    L7:
        r4 = new MemoryLLMBuildHelper$execute$1(r1, r0);
        goto L8
    }

    public final Object a(com.obric.memorydata.memory.tracker.d.b r18, e r19, com.obric.memorydata.memory.memoryentity.f r20, PageContextResult r21, MemoryEntity r22, boolean r23, Continuation<? super Pair<? extends MemoryEntity, ? extends Map<String, ? extends Object>>> r24) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MemoryLLMBuildHelper$executeMemoryBuildByLLM$1.class) == false) goto L7;
        MemoryLLMBuildHelper$executeMemoryBuildByLLM$1 r2 = (MemoryLLMBuildHelper$executeMemoryBuildByLLM$1) ZeusTransformUtils.preCheckCast(r0, MemoryLLMBuildHelper$executeMemoryBuildByLLM$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        MemoryLLMBuildHelper$executeMemoryBuildByLLM$1 r10 = r2;
        Object r1 = r10.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        boolean r5 = r10.Z$0;
        com.obric.memorydata.memory.tracker.d.b r6 = (com.obric.memorydata.memory.tracker.d.b) ZeusTransformUtils.preCheckCast(r10.L$0, com.obric.memorydata.memory.tracker.d.b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
        boolean r12 = r5;
        Object r7 = r1;
        com.obric.memorydata.memory.tracker.d.b r8 = r6;
    L17:
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(r7, Pair.class, "com.obric.memorydata.plugin");
        MemoryEntity r11 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r9.component1(), MemoryEntity.class, "com.obric.memorydata.plugin");
        Map<String, ? extends Object> r13 = (Map) ZeusTransformUtils.preCheckCast(r9.component2(), Map.class, "com.obric.memorydata.plugin");
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("executeMemoryBuildByLLM result: entity -> ");
        String r16 = null;
        if (r11 == null) goto L20;
        Integer r17 = Boxing.boxInt(r11.getType());
    L21:
        IRunLog.a.a(r14, "MemoryLLMBuildHelper", r15.append(r17).toString(), false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "executeMemoryBuildByLLM result: code -> " + r13.get("errorCode") + ", msg -> " + r13.get(DTraitConstant.ERROR), false, 4, null);
        if (r12 == true) goto L42;
        if (r11 == null) goto L27;
        r8.a(r11.getType(), r13);
        goto L42
    L27:
        if ((!r13.isEmpty()) == false) goto L41;
        Object r25 = r13.get("errorCode");
        if (ZeusTransformUtils.instanceOf(r25, Integer.class) == false) goto L31;
        Integer r26 = (Integer) ZeusTransformUtils.preCheckCast(r25, Integer.class, "com.obric.memorydata.plugin");
    L32:
        if (r26 == null) goto L34;
        int r27 = r26.intValue();
    L35:
        Object r28 = r13.get(DTraitConstant.ERROR);
        if (ZeusTransformUtils.instanceOf(r28, String.class) == false) goto L38;
        r16 = (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin");
    L38:
        if (r16 != null) goto L40;
        r16 = "";
    L40:
        r8.a(r27, r16);
        goto L42
    L34:
        r27 = -1000;
        goto L35
    L31:
        r26 = null;
        goto L32
    L41:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryLLMBuildHelper", "result is empty", null, 4, null);
    L42:
        return r7;
    L20:
        r17 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r8 = r18;
        r10.L$0 = r8;
        r12 = r23;
        r10.Z$0 = r12;
        r10.label = 1;
        r7 = b(r18, r19, r20, r21, r22, r23, r10);
        if (r7 != r3) goto L17;
        return r3;
    L7:
        r2 = new MemoryLLMBuildHelper$executeMemoryBuildByLLM$1(this, r0);
        goto L8
    }
}
