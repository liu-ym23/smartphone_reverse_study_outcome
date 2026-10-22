package com.obric.memorydata.memory.contextsync;

import com.bytedance.obric.memory.model.BatchSyncOMemoryRequest;
import com.bytedance.obric.memory.model.BatchSyncOMemoryResponse;
import com.bytedance.obric.memory.model.OMemorySemanticSyncResult;
import com.bytedance.obric.memory.model.OMemorySettingsPatch;
import com.bytedance.obric.memory.model.UpdateOMemorySettingsRequest;
import com.bytedance.obric.memory.model.UpdateOMemorySettingsResponse;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\b\b\u0002\u0010\u0011\u001a\u00020\tJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\n\u0010\u001f\u001a\u00060 j\u0002`!H\u0002J\u000e\u0010\"\u001a\u00020\u0005*\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010#\u001a\u00020\u0005*\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/OMemoryExploreClient;", "", "<init>", "()V", "TAG", "", "SETTINGS_UPDATE_PATH", "BATCH_SYNC_PATH", "updateSettings", "", "snapshot", "Lcom/obric/memorydata/memory/contextsync/MemoryContextSwitchSnapshot;", "batchSync", "", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchResult;", "items", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchItem;", "full", "logBatchRequest", "", "requestId", "logBatchSemantics", "requestSettings", "Lcom/bytedance/obric/memory/model/UpdateOMemorySettingsResponse;", Ext.KEY_REQUEST, "Lcom/bytedance/obric/memory/model/UpdateOMemorySettingsRequest;", "requestBatchSync", "Lcom/bytedance/obric/memory/model/BatchSyncOMemoryResponse;", "Lcom/bytedance/obric/memory/model/BatchSyncOMemoryRequest;", "logRequestException", "path", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toLogText", "toDebugLogText", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10106a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Grouping<OMemorySemanticSyncResult, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f10107a;

        public a(Iterable r3) {
            this.f10107a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public Integer keyOf(OMemorySemanticSyncResult r2) {
            return Integer.valueOf(((OMemorySemanticSyncResult) ZeusTransformUtils.preCheckCast(r2, OMemorySemanticSyncResult.class, "com.obric.memorydata.plugin")).status);
        }

        @Override // kotlin.collections.Grouping
        public Iterator<OMemorySemanticSyncResult> sourceIterator() {
            return this.f10107a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Grouping<com.obric.memorydata.memory.contextsync.a, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f10108a;

        public b(Iterable r3) {
            this.f10108a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public Integer keyOf(com.obric.memorydata.memory.contextsync.a r2) {
            return Integer.valueOf(((com.obric.memorydata.memory.contextsync.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.contextsync.a.class, "com.obric.memorydata.plugin")).b());
        }

        @Override // kotlin.collections.Grouping
        public Iterator<com.obric.memorydata.memory.contextsync.a> sourceIterator() {
            return this.f10108a.iterator();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Grouping<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f10109a;

        public c(Iterable r3) {
            this.f10109a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(String r2) {
            return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public Iterator<String> sourceIterator() {
            return this.f10109a.iterator();
        }
    }

    static {
        f10106a = new i();
    }

    private i() {
    }

    private final BatchSyncOMemoryResponse a(String r5, BatchSyncOMemoryRequest r6) {
    L13:
        return com.bytedance.obric.memory.a.a.a(r6);
    L7:
        e = move-exception;
        e = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
    L9:
        a("/explore/api/o_memory/batch_sync", r5, e);
        return null;
    L5:
        e = e;
        goto L9
    }

    private final UpdateOMemorySettingsResponse a(String r5, UpdateOMemorySettingsRequest r6) {
    L13:
        return com.bytedance.obric.memory.a.a.a(r6);
    L7:
        e = move-exception;
        e = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
    L9:
        a("/explore/api/o_memory/settings/update", r5, e);
        return null;
    L5:
        e = e;
        goto L9
    }

    private final String a(String r13) {
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        return StringsKt.take(StringsKt.replace$default(StringsKt.replace$default(r13, '\n', ' ', false, 4, null), '\r', ' ', false, 4, null), 128);
    }

    private final void a(String r7, String r8, Exception r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_OMemoryExploreClient", "[code=sdk_request_exception] request exception, path=" + r7 + ", requestId=" + r8 + ", type=" + r9.getClass().getSimpleName(), null, 4, null);
    }

    private final void a(String r7, List<com.obric.memorydata.memory.contextsync.a> r8) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r9 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r1 = r6.next();
        int r2 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.memorydata.memory.contextsync.a r3 = (com.obric.memorydata.memory.contextsync.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.contextsync.a.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L11;
        RunLog.INSTANCE.debug("MeD_OMemoryExploreClient", "batch_sync semantic, requestId=" + r7 + ", index=" + r9 + ", uuid=" + r3.a() + ", operation=" + r3.b() + ", productType=" + r3.g() + ", sourceCreateTime=" + r3.d() + ", sourceEntityId=" + r3.e() + ", semanticType=" + r3.h() + ", tagPath=" + r3.i() + ", userEdit=" + r3.j() + ", content=" + f10106a.b(r3.f()));
    L11:
        r9 = r2;
        goto L4
    }

    private final void a(String r9, List<com.obric.memorydata.memory.contextsync.a> r10, boolean r11) {
        List<com.obric.memorydata.memory.contextsync.a> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        a(r9, r12);
        Map r8 = GroupingKt.eachCount((Grouping) ZeusTransformUtils.preCheckCast(new b((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")), Grouping.class, "com.obric.memorydata.plugin"));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r3 = ((com.obric.memorydata.memory.contextsync.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.memory.contextsync.a.class, "com.obric.memorydata.plugin")).g();
        if (r3 == null) goto L4;
        r2.add(r3);
        goto L4
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_OMemoryExploreClient", "batch_sync request, requestId=" + r9 + ", full=" + r11 + ", count=" + r12.size() + ", operationCounts=" + r8 + ", productTypeCounts=" + GroupingKt.eachCount((Grouping) ZeusTransformUtils.preCheckCast(new c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Grouping.class, "com.obric.memorydata.plugin")), false, 4, null);
    }

    private final String b(String r13) {
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        return StringsKt.take(StringsKt.replace$default(StringsKt.replace$default(r13, '\n', ' ', false, 4, null), '\r', ' ', false, 4, null), 512);
    }

    public final List<com.obric.memorydata.memory.contextsync.b> a(List<com.obric.memorydata.memory.contextsync.a> r20, boolean r21) {
        List<com.obric.memorydata.memory.contextsync.a> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "items");
        if (r2.isEmpty() == false) goto L7;
        if (r21 == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        String r4 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        BatchSyncOMemoryRequest r5 = j.a(r4, r2, r21);
        a(r4, r2, r21);
        BatchSyncOMemoryResponse r1 = a(r4, r5);
        if (r1 != null) goto L10;
        return null;
    L10:
        List<OMemorySemanticSyncResult> r6 = r1.semanticResults;
        if (r6 != null) goto L13;
        r6 = CollectionsKt.emptyList();
    L13:
        Map r7 = GroupingKt.eachCount((Grouping) ZeusTransformUtils.preCheckCast(new a((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), Grouping.class, "com.obric.memorydata.plugin"));
        if (r1.code == 0) goto L19;
        IRunLog r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[code=batch_business_failed] batch_sync response failed, requestId=").append(r4).append(", code=").append(r1.code).append(", msg=").append(a(r1.msg)).append(", resultCount=").append(r6.size()).append(", statusCounts=").append(r7);
    L16:
        IRunLog.a.a(r13, "MeD_OMemoryExploreClient", r0.toString(), null, 4, null);
        return null;
    L19:
        if (r6.size() == r2.size()) goto L21;
        r13 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r0 = new StringBuilder().append("[code=batch_result_count_mismatch] batch_sync result count mismatch, requestId=").append(r4).append(", requestCount=").append(r2.size()).append(", resultCount=").append(r6.size());
        goto L16
    L21:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Iterator r8 = r3.iterator();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r3, 10), CollectionsKt.collectionSizeOrDefault((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 10)));
    L23:
        if (r8.hasNext() == false) goto L27;
        if (r9.hasNext() == false) goto L27;
        r14.add(j.a((com.obric.memorydata.memory.contextsync.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.memory.contextsync.a.class, "com.obric.memorydata.plugin"), ((OMemorySemanticSyncResult) ZeusTransformUtils.preCheckCast(r8.next(), OMemorySemanticSyncResult.class, "com.obric.memorydata.plugin")).status));
    L27:
        List<com.obric.memorydata.memory.contextsync.b> r10 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_OMemoryExploreClient", "batch_sync response, requestId=" + r4 + ", code=" + r1.code + ", msg=" + f10106a.a(r1.msg) + ", resultCount=" + r6.size() + ", validResultCount=" + r10.size() + ", statusCounts=" + r7, false, 4, null);
        return r10;
    }

    public final boolean a(e r15) {
        Intrinsics.checkNotNullParameter(r15, "snapshot");
        String r0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        UpdateOMemorySettingsRequest r1 = new UpdateOMemorySettingsRequest();
        r1.requestId = r0;
        OMemorySettingsPatch r2 = new OMemorySettingsPatch();
        r2.globalMemory = r15.a();
        r2.personalInfoMemory = r15.b();
        r2.collectionMemory = r15.c();
        r1.settings = r2;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_OMemoryExploreClient", "settings/update request, requestId=" + r0 + ", globalMemory=" + r15.a() + ", personalInfoMemory=" + r15.b() + ", collectionMemory=" + r15.c(), false, 4, null);
        UpdateOMemorySettingsResponse r16 = a(r0, r1);
        boolean r3 = false;
        if (r16 != null) goto L6;
        return false;
    L6:
        if (r16.code != 0) goto L8;
        r3 = true;
    L8:
        String r7 = "settings/update response, requestId=" + r0 + ", success=" + r3 + ", code=" + r16.code + ", msg=" + a(r16.msg);
        Object r14 = ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L11;
        IRunLog.a.a((IRunLog) r14, "MeD_OMemoryExploreClient", r7, false, 4, null);
    L12:
        return r3;
    L11:
        IRunLog.a.a((IRunLog) r14, "MeD_OMemoryExploreClient", "[code=settings_business_failed] " + r7, null, 4, null);
        goto L12
    }
}
