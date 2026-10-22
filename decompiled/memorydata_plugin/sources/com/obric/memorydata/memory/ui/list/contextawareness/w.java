package com.obric.memorydata.memory.ui.list.contextawareness;

import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bH\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0014J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/DaoContextAwarenessAudioPageSource;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessAudioPageSource;", "daoProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/database/dao/AuditoryRecordingRawDbDao;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", ChatMessage.TYPE_QUERY, "", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "cursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessSourceCursor;", "limit", "", "queryBefore", "recordedDateStrings", "", "findEventTime", "", "entityId", "(Ljava/lang/String;)Ljava/lang/Long;", "querySelectionMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "ids", "withSpecifiedRange", "", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeCount", "Lkotlinx/coroutines/flow/Flow;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<AuditoryRecordingRawDbDao> f11296a;

    /* JADX WARN: Multi-variable type inference failed */
    public w() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public w(Function0<? extends AuditoryRecordingRawDbDao> r3) {
        Function0<AuditoryRecordingRawDbDao> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "daoProvider");
        this.f11296a = r4;
    }

    public /* synthetic */ w(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$w$FI64yZhIdcJM_neIzvlLbP1iSo.INSTANCE;
    L5:
        this(r5);
    }

    private static final AuditoryRecordingRawDbDao b() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao();
    }

    /* JADX INFO: renamed from: lambda$FI64yZh-IdcJM_neIzvlLbP1iSo, reason: not valid java name */
    public static /* synthetic */ AuditoryRecordingRawDbDao m944lambda$FI64yZhIdcJM_neIzvlLbP1iSo() {
        return b();
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public Long a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        fj r2 = ((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin")).queryByEntityId(r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r2.getCreateTime());
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public Object a(d r14, List<String> r15, boolean r16, Continuation<? super List<cu>> r17) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        if (r16 == false) goto L9;
        if (r3.isEmpty() == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return AuditoryRecordingRawDbDao.DefaultImpls.getAllRecordingsMetaInfoWithTimestamp$default((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin"), r3, r16, r14.a(), r14.b(), false, r10, 16, null);
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public List<String> a() {
        return ((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin")).getAudioMemoryDateList();
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public List<t> a(k r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "cursor");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin")).queryContextAwarenessAudioPageBefore(r13.d().a(), r13.d().b(), r13.a(), r13.b(), u.a(r13.c()), r14), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r12.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        r15.add(u.a((fj) ZeusTransformUtils.preCheckCast(r16.next(), fj.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        return CollectionsKt.asReversed((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public kotlinx.coroutines.flow.i<Integer> a(d r5) {
        Intrinsics.checkNotNullParameter(r5, "dayRange");
        return ((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin")).getAllRecordingsCount(r5.a(), r5.b());
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.a
    public List<t> query(k r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "cursor");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(((AuditoryRecordingRawDbDao) ZeusTransformUtils.preCheckCast(this.f11296a.invoke(), AuditoryRecordingRawDbDao.class, "com.obric.memorydata.plugin")).queryContextAwarenessAudioPage(r13.d().a(), r13.d().b(), r13.a(), r13.b(), u.a(r13.c()), r14), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r12.iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        r15.add(u.a((fj) ZeusTransformUtils.preCheckCast(r16.next(), fj.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    }
}
