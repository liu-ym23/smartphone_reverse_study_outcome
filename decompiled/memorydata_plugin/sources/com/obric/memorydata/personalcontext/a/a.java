package com.obric.memorydata.personalcontext.a;

import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005J:\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/personalcontext/knowledgegraph/KnowledgeGraphUtils;", "", "<init>", "()V", "TAG", "", "kgSupportEntityTypeList", "", "", "PERSONAL_CONTEXT_KG_RETRIEVAL", "entitySupportList", "getEntitySupportList", "()Ljava/util/List;", "MAX_PENDING", "METHOD_INDEX", "METHOD_DELETE", "callPersonalContextKGConstructPapaya", "", "entityType", "rawId", "", "entityId", "method", "callPersonalContextKGConstructPapayaByIds", "rawIds", "entityIds", "callPersonalContextKGRetrievalPapaya", "Lorg/json/JSONObject;", "queryStr", "isOnlyModel", "", "isKGModelCouldRun", "callPersonalContextKGConstructPapayaDelay", "timeDelay", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12031b = null;
    private static final List<Integer> c = null;
    private static int d;

    static {
        f12030a = new a();
        f12031b = CollectionsKt.listOf(new Integer[]{101, 201, 202, 601});
        c = CollectionsKt.listOf(new Integer[]{101, 201, 202, 601});
        d = 5;
    }

    private a() {
    }

    private final boolean a() {
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L5;
    L7:
        return false;
    L5:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L7;
        return true;
    }

    public final void a(int r4, long r5, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "entityId");
        Intrinsics.checkNotNullParameter(r8, "method");
        if (a() == true) goto L5;
        return;
    L5:
        if (f12031b.contains(Integer.valueOf(r4)) == false) goto L9;
        JSONObject r3 = new JSONObject();
        r3.put("entityType", r4);
        r3.put("rawId", r5);
        r3.put("entityId", r7);
        r3.put("method", r8);
        RunLog.INSTANCE.debug("KnowledgeGraphUtils", "callPersonalContextKGConstructPapaya, method is: " + r8 + ", entityType is: " + r4 + ", rawId is: " + r5);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("personal_context_kg_construct").setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    }

    public final void a(int r7, List<Long> r8, List<String> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "rawIds");
        Intrinsics.checkNotNullParameter(r12, "entityIds");
        Intrinsics.checkNotNullParameter(r10, "method");
        if (a() == true) goto L5;
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L7;
        return;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L9;
        return;
    L9:
        if (f12031b.contains(Integer.valueOf(r7)) == false) goto L15;
        String r6 = u.a(r11);
        String r13 = u.a(r12);
        JSONObject r14 = new JSONObject();
        r14.put("entityType", r7);
        r14.put("rawIds", r6);
        r14.put("entityIds", r13);
        r14.put("method", r10);
        r14.put("bulkTask", true);
        RunLog.INSTANCE.debug("KnowledgeGraphUtils", "callPersonalContextKGConstructPapaya, method is: " + r10 + ", entityType is: " + r7 + ", rawEntityIds is: " + r13);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("personal_context_kg_construct").setInputParam(r14), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    }
}
