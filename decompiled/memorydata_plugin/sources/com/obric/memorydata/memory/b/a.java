package com.obric.memorydata.memory.b;

import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\tJ\u001d\u0010\u0013\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0000¢\u0006\u0002\b\u0014J'\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\f\u0010\u001b\u001a\u00020\t*\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/automemorypro/AutoMemoryProCollectionEnqueueHelper;", "", "<init>", "()V", "TAG", "", "AUTO_MEMORY_PRO_V2_COLLECTION_TASK", "KEY_APPFC_OPERATE_TYPE", "enqueueForLlmResultIfNeeded", "", "resultEntities", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "enqueueAppFcIfNeeded", "ret", "", "details", "entityCount", "enqueueForRuleStateChange", "shouldEnqueueForLlmResult", "shouldEnqueueForLlmResult$memory_obricRelease", "shouldEnqueueForAppFcResult", "shouldEnqueueForAppFcResult$memory_obricRelease", "enqueueCollectionTask", "triggerSource", "parseAppFcOperateType", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultOperateType;", "isInsertOrUpdateOperate", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10078a = null;

    static {
        f10078a = new a();
    }

    private a() {
    }

    private final boolean a(MemoryLLMBuildHelperV2.ResultOperateType r1) {
        if (r1 != MemoryLLMBuildHelperV2.ResultOperateType.INSERT) goto L5;
    L8:
        return true;
    L5:
        if (r1 == MemoryLLMBuildHelperV2.ResultOperateType.UPDATE) goto L8;
        return false;
    }

    private final boolean a(String r11) {
        if (AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, null, null, null, null, null, 63, null) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProCollectionEnqueueHelper", "collection enqueue skipped, reason=auto_memory_disabled, triggerSource=" + r11, false, 4, null);
        return false;
    L6:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("auto_memory_pro_cloud_v2_collection").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProCollectionEnqueueHelper", "collection enqueue requested, task=auto_memory_pro_cloud_v2_collection, triggerSource=" + r11, false, 4, null);
        return true;
    }

    private final MemoryLLMBuildHelperV2.ResultOperateType b(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L24;
        return null;
    L24:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r5 = Result.m1421constructorimpl(new JSONObject(r4));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r5) == false) goto L19;
        r5 = null;
    L19:
        JSONObject r6 = (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L23;
        return null;
    L23:
        return MemoryLLMBuildHelperV2.ResultOperateType.Companion.a(r6.optString("operate_type"));
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    public final boolean a() {
        return a("rule_state_change");
    }

    public final boolean a(int r7, String r8, int r9) {
        if (b(r7, r8, r9) == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProCollectionEnqueueHelper", "collection enqueue skipped, reason=appfc_no_insert_or_update, ret=" + r7 + ", entityCount=" + r9, false, 4, null);
        return false;
    L7:
        return a("mobile_mem_appfc");
    }

    public final boolean a(List<MemoryLLMBuildHelperV2.a> r8) {
        List<MemoryLLMBuildHelperV2.a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (b(r9) == true) goto L11;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder().append("collection enqueue skipped, reason=llm_no_insert_or_update, resultEntityCount=");
        if (r9 == null) goto L7;
        int r10 = r9.size();
    L8:
        IRunLog.a.a(r0, "AutoMemoryProCollectionEnqueueHelper", r7.append(r10).toString(), false, 4, null);
        return false;
    L7:
        r10 = 0;
        goto L8
    L11:
        return a("mobile_mem_build");
    }

    public final boolean b(int r2, String r3, int r4) {
        if (r2 == 0) goto L5;
        return false;
    L5:
        if (r4 > 0) goto L7;
        return false;
    L7:
        MemoryLLMBuildHelperV2.ResultOperateType r5 = b(r3);
        if (r5 != null) goto L10;
        return false;
    L10:
        if (a(r5) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public final boolean b(List<MemoryLLMBuildHelperV2.a> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L18;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L8;
        if (f10078a.a(((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r7.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).c()) == false) goto L11;
        boolean r8 = true;
    L15:
        if (r8 != true) goto L18;
        return true;
    L8:
        r8 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L18:
        return false;
    }
}
