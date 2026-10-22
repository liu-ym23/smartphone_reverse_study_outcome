package com.obric.memorydata.memory.intent;

import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.b.a;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u001bJ4\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00052\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H\u0002J!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0002\u0010)J\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160+2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160+2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160+2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\"*\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010/\u001a\u000200H\u0002J.\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020\u001dH\u0002J\u0018\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/intent/MobileMemAppFcExecutor;", "", "<init>", "()V", "TAG", "", "PACKAGE_NAME", "DEFAULT_TIMEOUT_MS", "", "KEY_TOOL_NAME", "KEY_TOOL_PARAMS", "KEY_SOURCES", "KEY_EXTRAS", "KEY_DETAILS", "KEY_ENTITY", "KEY_ENABLE_SOURCE_LINK", "KEY_ENABLE_MEMORY_TRACE_REPORT", "TOOL_MEMORY_SEARCH", "TOOL_MEMORY_OPERATE_NEW", "execute", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "toolName", "toolParams", "sources", "extras", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executePackage", "Lcom/obric/memorydata/task/impl/TaskResult;", "normalizeDetails", "output", "Lorg/json/JSONObject;", "parseEntityRefs", "", "Lcom/obric/memorydata/memory/intent/MobileMemAppFcExecutor$EntityRef;", "enqueueAppFcCollectionIfNeeded", "", "intentResult", "queryAppEntities", "entityRefs", "(Ljava/util/List;)[Lcom/obric/capabilitykit/entity/app/AppEntity;", "queryEpisodicEntities", "", "querySemanticEntities", "queryAuditoryEntities", "idsByType", "entityType", "", "buildFailedResult", "details", "taskResult", "buildDetails", "code", "message", "EntityRef", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MobileMemAppFcExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MobileMemAppFcExecutor f10180a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0083\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/intent/MobileMemAppFcExecutor$EntityRef;", "", "entityId", "", "entityType", "", "<init>", "(Ljava/lang/String;I)V", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()I", "key", "getKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class EntityRef {
        private final String entityId;
        private final int entityType;
        private final String key;

        public EntityRef(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            this.entityId = r2;
            this.entityType = r3;
            this.key = r3 + ':' + r2;
        }

        public static /* synthetic */ EntityRef copy$default(EntityRef r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.entityId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.entityType;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.entityId;
        }

        public final int component2() {
            return this.entityType;
        }

        public final EntityRef copy(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "entityId");
            return new EntityRef(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, EntityRef.class) == true) goto L8;
            return false;
        L8:
            EntityRef r6 = (EntityRef) ZeusTransformUtils.preCheckCast(r5, EntityRef.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L12;
            return false;
        L12:
            if (this.entityType == r6.entityType) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getEntityId() {
            return this.entityId;
        }

        public final int getEntityType() {
            return this.entityType;
        }

        public final String getKey() {
            return this.key;
        }

        public int hashCode() {
            return (this.entityId.hashCode() * 31) + Integer.hashCode(this.entityType);
        }

        public String toString() {
            return "EntityRef(entityId=" + this.entityId + ", entityType=" + this.entityType + ')';
        }
    }

    static {
        f10180a = new MobileMemAppFcExecutor();
    }

    private MobileMemAppFcExecutor() {
    }

    private final IntentResult<AppEntity[]> a(String r15, String r16, TaskResult r17) {
        if (r16 != null) goto L4;
        String r5 = a(String.valueOf(r17.getCode()), "task failed, msg=" + r17.getMsg());
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileMemAppFcExecutor", "execute failed, toolName=" + r15 + ", details=" + r5, null, 4, null);
        return new IntentResult(1, new AppEntity[0], null, r5, false, false, 0, null, null, null, 1012, null);
    L4:
        r5 = r16;
        goto L5
    }

    public static final /* synthetic */ Object a(MobileMemAppFcExecutor r6, String r7, String r8, String r9, String r10, Continuation r11) {
        return r6.b(r7, r8, r9, r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(MobileMemAppFcExecutor r6, String r7, String r8, String r9, String r10, Continuation r11, int r12, Object r13) {
        Continuation<? super IntentResult<AppEntity[]>> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        String r4 = null;
    L11:
        return r6.a(r7, r8, r3, r4, r5);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    private final String a(String r2, String r3) {
        String r1 = new JSONObject().put("code", r2).put("message", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    private final String a(JSONObject r2) {
        String r1 = r2.optString("details");
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        return null;
    L7:
        return r1;
    }

    public static final /* synthetic */ List a(MobileMemAppFcExecutor r0, JSONObject r1) {
        return r0.b(r1);
    }

    private final List<String> a(List<EntityRef> r4, int r5) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Object r1 = r7.next();
        if (((EntityRef) ZeusTransformUtils.preCheckCast(r1, EntityRef.class, "com.obric.memorydata.plugin")).getEntityType() != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r6.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        r9.add(((EntityRef) ZeusTransformUtils.preCheckCast(r10.next(), EntityRef.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L13
    L16:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r4, IntentResult<AppEntity[]> r5) {
        if (Intrinsics.areEqual(r4, "Memory_OperateNew") == true) goto L5;
        return;
    L5:
        a r3 = a.f10078a;
        int r6 = r5.getRet();
        String r0 = r5.getDetails();
        AppEntity[] r7 = (AppEntity[]) ZeusTransformUtils.preCheckCast(r5.getEntity(), AppEntity[].class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        int r8 = r7.length;
    L9:
        r3.a(r6, r0, r8);
        return;
    L8:
        r8 = 0;
        goto L9
    }

    public static final /* synthetic */ AppEntity[] a(MobileMemAppFcExecutor r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final AppEntity[] a(List<EntityRef> r8) {
        List<EntityRef> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == true) goto L5;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, AppEntity>> r3 = b(r9).entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r4.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        Iterator<Map.Entry<String, AppEntity>> r5 = c(r9).entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r6.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        Iterator<Map.Entry<String, AppEntity>> r7 = d(r9).entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(r10.getValue(), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L16
    L18:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L20:
        if (r13.hasNext() == false) goto L25;
        AppEntity r14 = (AppEntity) ZeusTransformUtils.preCheckCast(r0.get(((EntityRef) ZeusTransformUtils.preCheckCast(r13.next(), EntityRef.class, "com.obric.memorydata.plugin")).getKey()), AppEntity.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L20;
        r12.add(r14);
        goto L20
    L25:
        return (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.memorydata.plugin");
    L5:
        return new AppEntity[0];
    }

    private final Object b(String r11, String r12, String r13, String r14, Continuation<? super TaskResult> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MobileMemAppFcExecutor$executePackage$1.class) == false) goto L7;
        MobileMemAppFcExecutor$executePackage$1 r0 = (MobileMemAppFcExecutor$executePackage$1) ZeusTransformUtils.preCheckCast(r16, MobileMemAppFcExecutor$executePackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r11 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L22
    L20:
        return (TaskResult) ZeusTransformUtils.preCheckCast(r10, TaskResult.class, "com.obric.memorydata.plugin");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        CoroutineContext r18 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        Function2 r19 = (Function2) ZeusTransformUtils.preCheckCast(new MobileMemAppFcExecutor$executePackage$2(r11, r12, r13, r14, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        r0.L$0 = r11;     // Catch: Exception -> L22
        r0.label = 1;     // Catch: Exception -> L22
        r10 = i.a(r18, r19, r0);     // Catch: Exception -> L22
        if (r10 != r17) goto L20;
        return r17;
    L22:
        e = move-exception;
        RunLog.INSTANCE.error("MobileMemAppFcExecutor", "executePackage exception, toolName=" + r11, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        String r110 = e.getMessage();
        if (r110 != null) goto L27;
        r110 = "Unknown Exception";
    L27:
        return new TaskResult(TaskResult.EXCEPTION, r110, null, null, 12, null);
    L7:
        r0 = new MobileMemAppFcExecutor$executePackage$1(this, r16);
        goto L8
    }

    private final List<EntityRef> b(JSONObject r8) {
        JSONArray r7 = r8.optJSONArray("entity");
        if (r7 == null) goto L5;
        List<EntityRef> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        int r2 = r7.length();
    L7:
        if (r0 >= r2) goto L22;
        JSONObject r3 = r7.optJSONObject(r0);
        if (r3 == null) goto L21;
        String r4 = r3.optString("entityId");
        Intrinsics.checkNotNull(r4);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L21;
        if (r3.has("entityType") == false) goto L21;
        r9.add(new EntityRef(r4, r3.optInt("entityType")));
    L21:
        r0 = r0 + 1;
        goto L7
    L22:
        return r9;
    L5:
        return CollectionsKt.emptyList();
    }

    private final Map<String, AppEntity> b(List<EntityRef> r6) {
        List<String> r5 = a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), -306);
        if (r5.isEmpty() == true) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L16;
        EpisodicMemoryEntity r2 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r9.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        AppEntity r3 = r2.convertToAppEntity();
        if (r3 == null) goto L12;
        Pair r4 = TuplesKt.to(new EntityRef(r2.getEntityId(), -306).getKey(), r3);
    L13:
        if (r4 == null) goto L8;
        r8.add(r4);
        goto L8
    L12:
        r4 = null;
        goto L13
    L16:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        return MapsKt.emptyMap();
    }

    private final Map<String, AppEntity> c(List<EntityRef> r6) {
        List<String> r5 = a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), NetError.ERR_CACHE_READ_FAILURE);
        if (r5.isEmpty() == true) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(r5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L16;
        ip r2 = (ip) ZeusTransformUtils.preCheckCast(r9.next(), ip.class, "com.obric.memorydata.plugin");
        AppEntity r3 = r2.convertToAppEntity();
        if (r3 == null) goto L12;
        Pair r4 = TuplesKt.to(new EntityRef(r2.getEntityId(), NetError.ERR_CACHE_READ_FAILURE).getKey(), r3);
    L13:
        if (r4 == null) goto L8;
        r8.add(r4);
        goto L8
    L12:
        r4 = null;
        goto L13
    L16:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        return MapsKt.emptyMap();
    }

    private final Map<String, AppEntity> d(List<EntityRef> r6) {
        List<String> r5 = a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), 502);
        if (r5.isEmpty() == true) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityIdList(r5), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L16;
        fj r2 = (fj) ZeusTransformUtils.preCheckCast(r9.next(), fj.class, "com.obric.memorydata.plugin");
        AppEntity r3 = r2.convertToAppEntity();
        if (r3 == null) goto L12;
        Pair r4 = TuplesKt.to(new EntityRef(r2.getEntityId(), 502).getKey(), r3);
    L13:
        if (r4 == null) goto L8;
        r8.add(r4);
        goto L8
    L12:
        r4 = null;
        goto L13
    L16:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        return MapsKt.emptyMap();
    }

    public final Object a(String r22, String r23, String r24, String r25, Continuation<? super IntentResult<AppEntity[]>> r26) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MobileMemAppFcExecutor$execute$1.class) == false) goto L7;
        MobileMemAppFcExecutor$execute$1 r2 = (MobileMemAppFcExecutor$execute$1) ZeusTransformUtils.preCheckCast(r1, MobileMemAppFcExecutor$execute$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        MobileMemAppFcExecutor$execute$1 r8 = r2;
        Object r3 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r8.L$2, String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r8.L$1, String.class, "com.obric.memorydata.plugin");
        MobileMemAppFcExecutor r0 = (MobileMemAppFcExecutor) ZeusTransformUtils.preCheckCast(r8.L$0, MobileMemAppFcExecutor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        String r12 = r5;
    L28:
        AppEntity[] r10 = (AppEntity[]) ZeusTransformUtils.preCheckCast(r3, AppEntity[].class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MobileMemAppFcExecutor", "execute success, toolName=" + r6 + ", entitySize=" + r10.length + ", details=" + r12, false, 4, null);
        IntentResult<AppEntity[]> r7 = new IntentResult(0, r10, null, r12, false, false, 0, null, null, null, 1012, null);
        r0.a(r6, r7);
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r8.L$1, String.class, "com.obric.memorydata.plugin");
        r0 = (MobileMemAppFcExecutor) ZeusTransformUtils.preCheckCast(r8.L$0, MobileMemAppFcExecutor.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        String r13 = r11;
    L20:
        TaskResult r14 = (TaskResult) ZeusTransformUtils.preCheckCast(r3, TaskResult.class, "com.obric.memorydata.plugin");
        String r15 = r0.a(r14.getOutput());
        if (r14.getCode() != 0) goto L23;
        CoroutineContext r16 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(new MobileMemAppFcExecutor$execute$entities$1(r14, null), Function2.class, "com.obric.memorydata.plugin");
        r8.L$0 = r0;
        r8.L$1 = r13;
        r8.L$2 = r15;
        r8.label = 2;
        r3 = i.a(r16, r17, r8);
        if (r3 != r9) goto L27;
        return r9;
    L27:
        r12 = r15;
        r6 = r13;
        goto L28
    L23:
        return r0.a(r13, r15, r14);
    L16:
        ResultKt.throwOnFailure(r3);
        r8.L$0 = this;
        r13 = r22;
        r8.L$1 = r13;
        r8.label = 1;
        r3 = b(r22, r23, r24, r25, r8);
        if (r3 != r9) goto L19;
        return r9;
    L19:
        r0 = this;
    L7:
        r2 = new MobileMemAppFcExecutor$execute$1(this, r1);
        goto L8
    }
}
