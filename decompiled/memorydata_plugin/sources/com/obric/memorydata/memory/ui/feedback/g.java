package com.obric.memorydata.memory.ui.feedback;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00052\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0082\bJ\u001e\u0010\u001b\u001a\u00020\u0019*\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\u0017\u0010\u001e\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b\u001fJ(\u0010\u001e\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"H\u0002J5\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010%H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackEntityJson;", "", "<init>", "()V", "TAG", "", "KEY_TRANSCRIPT_TEXT", "MAX_FEEDBACK_JSON_NESTING_DEPTH", "", "fromScreenMemory", "Lorg/json/JSONObject;", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "fromAudioMemory", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "transcriptText", "fromRawObservations", "Lorg/json/JSONArray;", "entities", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "buildFeedbackJson", "entityType", "build", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "putFeedbackValue", "key", EventBody.KEY_VALUE, "toFeedbackJsonValue", "toFeedbackJsonValue$memory_obricRelease", "depth", "visiting", "", "withFeedbackJsonContainer", "container", "Lkotlin/Function0;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10949a = null;

    static {
        f10949a = new g();
    }

    private g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r10v2, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r10v3, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    private final Object a(Object r8, int r9, Set<Object> r10) {
        Set<Object> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
    L4:
        Object r11 = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(r11, "NULL");
        return r11;
    L6:
        if (Intrinsics.areEqual(r8, JSONObject.NULL) == true) goto L4;
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r8, JSONObject.class) == false) goto L22;
        if (r9 >= 16) goto L4;
        if (r7.add(r8) == false) goto L4;
        ?? r12 = new JSONObject();     // Catch: Throwable -> L19
        Iterator<String> r1 = ((JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")).keys();     // Catch: Throwable -> L19
    L16:
        if (r1.hasNext() == false) goto L32;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r12.put(r2, f10949a.a(((JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin")).opt(r2), r9 + 1, r7));     // Catch: Throwable -> L19
    L32:
        r7.remove(r8);
        return r12;
    L19:
        th = move-exception;
        r7.remove(r8);
        throw th;
    L22:
        int r4 = 0;
        if (ZeusTransformUtils.instanceOf(r8, JSONArray.class) == false) goto L37;
        if (r9 >= 16) goto L4;
        if (r7.add(r8) == false) goto L4;
        r12 = new JSONArray();     // Catch: Throwable -> L33
        int r5 = ((JSONArray) ZeusTransformUtils.preCheckCast(r8, JSONArray.class, "com.obric.memorydata.plugin")).length();     // Catch: Throwable -> L33
    L29:
        if (r4 >= r5) goto L32;
        r12.put(f10949a.a(((JSONArray) ZeusTransformUtils.preCheckCast(r8, JSONArray.class, "com.obric.memorydata.plugin")).opt(r4), r9 + 1, r7));     // Catch: Throwable -> L33
        r4 = r4 + 1;
    L33:
        th = move-exception;
        r7.remove(r8);
        throw th;
    L37:
        if (ZeusTransformUtils.instanceOf(r8, Double.class) == false) goto L53;
        double r13 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (Double.isInfinite(r13) == false) goto L41;
    L43:
        r3 = false;
    L44:
        if (r3 == true) goto L47;
        r8 = null;
    L47:
        Object r14 = (Double) ZeusTransformUtils.preCheckCast(r8, Double.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L50;
        r14 = JSONObject.NULL;
    L50:
        Object r15 = r14;
    L51:
        Intrinsics.checkNotNull(r15);
        return r15;
    L41:
        if (Double.isNaN(r13) == true) goto L43;
    L53:
        if (ZeusTransformUtils.instanceOf(r8, Float.class) == false) goto L67;
        float r16 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (Float.isInfinite(r16) == false) goto L57;
    L59:
        r3 = false;
    L60:
        if (r3 == true) goto L63;
        r8 = null;
    L63:
        r14 = (Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L50;
        r14 = JSONObject.NULL;
        goto L50
    L57:
        if (Float.isNaN(r16) == true) goto L59;
    L67:
        if (ZeusTransformUtils.instanceOf(r8, Byte.class) == false) goto L69;
        return r8;
    L69:
        if (ZeusTransformUtils.instanceOf(r8, Short.class) == false) goto L71;
        return r8;
    L71:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L73;
        return r8;
    L73:
        if (ZeusTransformUtils.instanceOf(r8, Long.class) == false) goto L75;
        return r8;
    L75:
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == false) goto L77;
        return r8;
    L77:
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L80;
        return r8;
    L80:
        if (ZeusTransformUtils.instanceOf(r8, Character.class) == false) goto L83;
        return String.valueOf(((Character) ZeusTransformUtils.preCheckCast(r8, Character.class, "com.obric.memorydata.plugin")).charValue());
    L83:
        if (ZeusTransformUtils.instanceOf(r8, Map.class) == false) goto L112;
        if (r9 >= 16) goto L4;
        if (r7.add(r8) == false) goto L4;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L91;
    L93:
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L108
    L95:
        if (r18.hasNext() == false) goto L99;
        if ((!ZeusTransformUtils.instanceOf(r18.next(), String.class)) == false) goto L95;
        r4 = 1;
    L99:
        if (r4 == 0) goto L101;
        Object r19 = JSONObject.NULL;     // Catch: Throwable -> L108
    L106:
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L108
        r7.remove(r8);
        return r19;
    L101:
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L108
        Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L108
    L103:
        if (r6.hasNext() == false) goto L105;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        Object r21 = r20.getKey();     // Catch: Throwable -> L108
        Object r22 = r20.getValue();     // Catch: Throwable -> L108
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L108
        r110.put((String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin"), f10949a.a(r22, r9 + 1, r7));     // Catch: Throwable -> L108
        goto L103
    L105:
        r19 = r110;
        goto L106
    L91:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L93;
    L108:
        th = move-exception;
        r7.remove(r8);
        throw th;
    L112:
        if (ZeusTransformUtils.instanceOf(r8, Iterable.class) == false) goto L126;
        if (r9 >= 16) goto L4;
        if (r7.add(r8) == false) goto L4;
        r12 = new JSONArray();     // Catch: Throwable -> L122
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L122
    L119:
        if (r0.hasNext() == false) goto L32;
        r12.put(f10949a.a(r0.next(), r9 + 1, r7));     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        r7.remove(r8);
        throw th;
    L126:
        if (r8.getClass().isArray() == false) goto L138;
        if (r9 >= 16) goto L4;
        if (r7.add(r8) == false) goto L4;
        r12 = new JSONArray();     // Catch: Throwable -> L135
        int r23 = Array.getLength(r8);     // Catch: Throwable -> L135
    L132:
        if (r4 >= r23) goto L32;
        r12.put(f10949a.a(Array.get(r8, r4), r9 + 1, r7));     // Catch: Throwable -> L135
        r4 = r4 + 1;
    L135:
        th = move-exception;
        r7.remove(r8);
        throw th;
    L138:
        r15 = JSONObject.NULL;
        goto L51
    }

    private final void a(JSONObject r1, String r2, Object r3) {
        r1.put(r2, a(r3));
    }

    public final Object a(Object r4) {
        Set<Object> r0 = Collections.newSetFromMap((Map) ZeusTransformUtils.preCheckCast(new IdentityHashMap(), Map.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r0);
        return a(r4, 0, r0);
    }

    public final JSONArray a(List<RawObservationEntity> r7) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entities");
        JSONArray r8 = new JSONArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        RawObservationEntity r1 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r9.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        r8.put(new JSONObject().put(OaidModel.KEY_ID, r1.getId()).put("device_id", r1.getDeviceId()).put(AILabCheckPermissionTask.KEY_SOURCE, r1.getSource()).put("timestamp", r1.getTimestamp()).put("span_start", r1.getSpanStart()).put("span_end", r1.getSpanEnd()).put("payload", r1.getPayload()).put("meta", r1.getMeta()).put("state", r1.getState()).put("client_state", r1.getClientState()).put("retry_count", r1.getRetryCount()).put("last_error_code", r1.getLastErrorCode()));
        goto L4
    L6:
        return r8;
    }

    public final JSONObject a(EpisodicMemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "entity");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        g r5 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L5
        g r2 = f10949a;     // Catch: Throwable -> L5
        r2.a(r7, OaidModel.KEY_ID, Long.valueOf(r6.getId()));     // Catch: Throwable -> L5
        r2.a(r7, "actionTimestamp", Long.valueOf(r6.getActionTimestamp()));     // Catch: Throwable -> L5
        r2.a(r7, "uid", Long.valueOf(r6.getUid()));     // Catch: Throwable -> L5
        r2.a(r7, "title", r6.getTitle());     // Catch: Throwable -> L5
        r2.a(r7, Params.CONTENT, r6.getContent());     // Catch: Throwable -> L5
        r2.a(r7, "contentWithTime", r6.getContentWithTime());     // Catch: Throwable -> L5
        r2.a(r7, "fullContent", r6.getFullContent());     // Catch: Throwable -> L5
        r2.a(r7, "observation", r6.getObservation());     // Catch: Throwable -> L5
        r2.a(r7, "location", r6.getLocation());     // Catch: Throwable -> L5
        r2.a(r7, "appNames", r6.getAppNames());     // Catch: Throwable -> L5
        r2.a(r7, EventBody.KEY_CATEGORY, r6.getCategory());     // Catch: Throwable -> L5
        r2.a(r7, "profileType", r6.getProfileType());     // Catch: Throwable -> L5
        r2.a(r7, "profileTag", r6.getProfileTag());     // Catch: Throwable -> L5
        r2.a(r7, "tagOther", r6.getTagOther());     // Catch: Throwable -> L5
        r2.a(r7, "logId", r6.getLogId());     // Catch: Throwable -> L5
        r2.a(r7, "usedForPortrait", r6.getUsedForPortrait());     // Catch: Throwable -> L5
        r2.a(r7, "useLocation", r6.getUseLocation());     // Catch: Throwable -> L5
        r2.a(r7, "useForUserKeyword", Boolean.valueOf(r6.getUseForUserKeyword()));     // Catch: Throwable -> L5
        r2.a(r7, "startTimestamp", Long.valueOf(r6.getStartTimestamp()));     // Catch: Throwable -> L5
        r2.a(r7, "endTimestamp", Long.valueOf(r6.getEndTimestamp()));     // Catch: Throwable -> L5
        r2.a(r7, "useForTopic", r6.getUseForTopic());     // Catch: Throwable -> L5
        r2.a(r7, "entityId", r6.getEntityId());     // Catch: Throwable -> L5
        r2.a(r7, "createTime", Long.valueOf(r6.getCreateTime()));     // Catch: Throwable -> L5
        r2.a(r7, "modifyTime", Long.valueOf(r6.getModifyTime()));     // Catch: Throwable -> L5
        r2.a(r7, "type", Integer.valueOf(r6.getType()));     // Catch: Throwable -> L5
        r2.a(r7, "timestamp", Long.valueOf(r6.getTimestamp()));     // Catch: Throwable -> L5
        r2.a(r7, ObricMemoryConstants.KEY_PACKAGE_NAME, r6.getPackageName());     // Catch: Throwable -> L5
        r2.a(r7, "hashCodeValue", Integer.valueOf(r6.getHashCodeValue()));     // Catch: Throwable -> L5
        r2.a(r7, Api.KEY_UUID, r6.getUuid());     // Catch: Throwable -> L5
        r2.a(r7, "userEdit", r6.getUserEdit());     // Catch: Throwable -> L5
        r2.a(r7, "productType", Integer.valueOf(r6.getProductType()));     // Catch: Throwable -> L5
        r2.a(r7, "importantRawRefIds", r6.getImportantRawRefIds());     // Catch: Throwable -> L5
        r2.a(r7, "sourceRawRefIds", r6.getSourceRawRefIds());     // Catch: Throwable -> L5
        r2.a(r7, "sceneIds", r6.getSceneIds());     // Catch: Throwable -> L5
        r2.a(r7, "sourcePackageName", r6.getSourcePackageName());     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L12;
        RunLog.INSTANCE.warn("MemoryFeedbackEntityJson", "serialize screen memory failed", r9);
        r8 = new JSONObject();
    L12:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r8, JSONObject.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final JSONObject a(fj r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "entity");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        g r5 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L13
        g r2 = f10949a;     // Catch: Throwable -> L13
        r2.a(r8, OaidModel.KEY_ID, Long.valueOf(r6.getId()));     // Catch: Throwable -> L13
        r2.a(r8, "entityId", r6.getEntityId());     // Catch: Throwable -> L13
        r2.a(r8, "createTime", Long.valueOf(r6.getCreateTime()));     // Catch: Throwable -> L13
        r2.a(r8, "modifyTime", Long.valueOf(r6.getModifyTime()));     // Catch: Throwable -> L13
        r2.a(r8, "type", Integer.valueOf(r6.getType()));     // Catch: Throwable -> L13
        r2.a(r8, "timestamp", Long.valueOf(r6.getTimestamp()));     // Catch: Throwable -> L13
        r2.a(r8, ObricMemoryConstants.KEY_PACKAGE_NAME, r6.getPackageName());     // Catch: Throwable -> L13
        r2.a(r8, "hashCodeValue", Integer.valueOf(r6.getHashCodeValue()));     // Catch: Throwable -> L13
        r2.a(r8, ActivityLifecycle.NAME, r6.c());     // Catch: Throwable -> L13
        r2.a(r8, "state", Integer.valueOf(r6.d()));     // Catch: Throwable -> L13
        r2.a(r8, "file", r6.e());     // Catch: Throwable -> L13
        r2.a(r8, "duration", Integer.valueOf(r6.f()));     // Catch: Throwable -> L13
        r2.a(r8, "transcript", r6.g());     // Catch: Throwable -> L13
        r2.a(r8, "summary", r6.h());     // Catch: Throwable -> L13
        r2.a(r8, "todoList", r6.i());     // Catch: Throwable -> L13
        r2.a(r8, "markers", r6.j());     // Catch: Throwable -> L13
        r2.a(r8, "sourceAppName", r6.k());     // Catch: Throwable -> L13
        r2.a(r8, "sourceAppPackage", r6.l());     // Catch: Throwable -> L13
        r2.a(r8, "requestTime", r6.m());     // Catch: Throwable -> L13
        r2.a(r8, "did", r6.n());     // Catch: Throwable -> L13
        r2.a(r8, "docNodeJson", r6.a());     // Catch: Throwable -> L13
        r2.a(r8, Api.KEY_UUID, r6.getUuid());     // Catch: Throwable -> L13
        if (r7 != null) goto L6;
    L11:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L13
    L15:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L20;
        RunLog.INSTANCE.warn("MemoryFeedbackEntityJson", "serialize audio memory failed", r10);
        r9 = new JSONObject();
    L20:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r9, JSONObject.class, "com.obric.memorydata.plugin");
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r7 = null;
    L9:
        if (r7 == null) goto L11;
        r2.a(r8, "transcriptText", r7);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
