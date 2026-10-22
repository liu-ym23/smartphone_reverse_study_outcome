package com.obric.memorydata.personalcontext.model;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/model/ModelPreloadManager;", "", "<init>", "()V", "TAG", "", "BIZ_PACKAGE_LIST_FOR_ASSISTANT_SEARCH", "", "getBIZ_PACKAGE_LIST_FOR_ASSISTANT_SEARCH", "()Ljava/util/List;", "BIZ_PACKAGE_LIST_FOR_IN_APP_SEARCH", "getBIZ_PACKAGE_LIST_FOR_IN_APP_SEARCH", "startLoadAssistantSearchModels", "", "cancelUseAssistantSearchModels", "startLoadInAppSearchModels", ObricMemoryConstants.KEY_PACKAGE_NAME, "cancelUseInAppSearchModels", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12233b = null;
    private static final List<String> c = null;

    static {
        f12232a = new a();
        f12233b = CollectionsKt.listOf(new String[]{"search_app_entity", "common_global_search", "personal_context_search", "personal_context_kg_retrieval", "memory_react_agent", "memory_react_agent_second", "memory_react_agent_third", "bert_all_in_one", "time_extract", "in_app_search_message", "in_app_search_note", "in_app_search_photo", "in_app_search_contact", "in_app_search_alarm", "in_app_search_call_history", "in_app_search_recording", "in_app_search_file", "in_app_search_countdown"});
        c = CollectionsKt.listOf(new String[]{"time_extract", "bert_all_in_one"});
    }

    private a() {
    }

    public final List<String> a() {
        return f12233b;
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "startLoadInAppSearchModels", false, 4, null);
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r8 = true;
    L7:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L14;
        if (r8 == true) goto L10;
    L12:
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$startLoadInAppSearchModels$1(r9, r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L10:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L12;
        return;
    L14:
        return;
    L5:
        r8 = false;
        goto L7
    }

    public final List<String> b() {
        return c;
    }

    public final void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "cancelUseInAppSearchModels", false, 4, null);
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r8 = true;
    L7:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L14;
        if (r8 == true) goto L10;
    L12:
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$cancelUseInAppSearchModels$1(r9, r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L10:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L12;
        return;
    L14:
        return;
    L5:
        r8 = false;
        goto L7
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "startLoadAssistantSearchModels", false, 4, null);
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r8 = true;
    L7:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L14;
        if (r8 == true) goto L10;
    L12:
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$startLoadAssistantSearchModels$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L10:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L12;
        return;
    L14:
        return;
    L5:
        r8 = false;
        goto L7
    }

    public final void d() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ModelPreloadManager", "cancelUseAssistantSearchModels", false, 4, null);
        if (c.f12363a.b() != EmbeddingState.USE_VLM) goto L5;
        boolean r8 = true;
    L7:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L14;
        if (r8 == true) goto L10;
    L12:
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ModelPreloadManager$cancelUseAssistantSearchModels$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L10:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L12;
        return;
    L14:
        return;
    L5:
        r8 = false;
        goto L7
    }
}
