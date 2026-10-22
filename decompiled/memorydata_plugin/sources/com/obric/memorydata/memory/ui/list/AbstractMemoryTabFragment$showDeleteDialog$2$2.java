package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment$showDeleteDialog$2$2", f = "AbstractMemoryTabFragment.kt", i = {0, 1, 1}, l = {124, 134}, m = "invokeSuspend", n = {"queryStartTime", "entityMetaInfoList", "deletedIds"}, s = {"J$0", "L$0", "L$1"})
final class AbstractMemoryTabFragment$showDeleteDialog$2$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $confirmStartTime;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AbstractMemoryTabFragment this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment$showDeleteDialog$2$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AbstractMemoryTabFragment$showDeleteDialog$2$2$2", f = "AbstractMemoryTabFragment.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Object>, Object> {
        final /* synthetic */ List<cu> $entityMetaInfoList;
        Object L$0;
        int label;
        final /* synthetic */ AbstractMemoryTabFragment this$0;

        AnonymousClass2(List<cu> r3, AbstractMemoryTabFragment r4, Continuation<? super AnonymousClass2> r5) {
            List<cu> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$entityMetaInfoList = r6;
            this.this$0 = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$entityMetaInfoList, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Object> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<Object> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Long r13 = (Long) ZeusTransformUtils.preCheckCast(this.L$0, Long.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.$entityMetaInfoList, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete db start, metaSize=" + this.$entityMetaInfoList.size(), false, 4, null);
            List<cu> r15 = this.$entityMetaInfoList;
            long r4 = System.currentTimeMillis();
            com.obric.memorydata.memory.utils.d.f11534a.a((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin"), MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
            Long r16 = Boxing.boxLong(System.currentTimeMillis() - r4);
            List<cu> r2 = this.$entityMetaInfoList;
            AbstractMemoryTabFragment r5 = this.this$0;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete db finished, cost=" + ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue() + " ms, metaSize=" + r2.size(), false, 4, null);
            kotlinx.coroutines.flow.ad<Unit> r3 = r5.getShareViewModel().get_memoryDeleteFlow();
            Unit r6 = Unit.INSTANCE;
            this.L$0 = r16;
            this.label = 1;
            if (r3.emit(r6, this) != r0) goto L17;
            return r0;
        L17:
            return r16;
        L14:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete skip, metaSize=0", null, 4, null);
            return Unit.INSTANCE;
        }
    }

    AbstractMemoryTabFragment$showDeleteDialog$2$2(AbstractMemoryTabFragment r3, long r4, Continuation<? super AbstractMemoryTabFragment$showDeleteDialog$2$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$confirmStartTime = r4;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AbstractMemoryTabFragment$showDeleteDialog$2$2(this.this$0, this.$confirmStartTime, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((AbstractMemoryTabFragment$showDeleteDialog$2$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AbstractMemoryTabFragment$showDeleteDialog$2$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(this.L$1, Set.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L56
    L26:
        SelectionStateManager r4 = this.this$0.getShareViewModel().getSelectionManager();     // Catch: Throwable -> L56
        AbstractMemoryTabFragment r5 = this.this$0;     // Catch: Throwable -> L56
        monitor-enter(r4);     // Catch: Throwable -> L56
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5.getShareViewModel().getSelectionManager().d(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L53
        Iterator r8 = r6.entrySet().iterator();     // Catch: Throwable -> L53
    L30:
        if (r8.hasNext() == false) goto L34;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r1.contains(((cu) ZeusTransformUtils.preCheckCast(r9.getValue(), cu.class, "com.obric.memorydata.plugin")).a()) == false) goto L30;
        r7.put(r9.getKey(), r9.getValue());     // Catch: Throwable -> L53
        goto L30
    L34:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        ConcurrentHashMap<String, cu> r11 = r5.getShareViewModel().getSelectionManager().d();     // Catch: Throwable -> L53
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L53
    L36:
        if (r12.hasNext() == false) goto L38;
        r11.remove((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
        goto L36
    L38:
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(r5.getShareViewModel().getSelectionManager().e(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: Throwable -> L53
        Iterator r15 = r13.entrySet().iterator();     // Catch: Throwable -> L53
    L40:
        if (r15.hasNext() == false) goto L44;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r1.contains(((cu) ZeusTransformUtils.preCheckCast(r16.getValue(), cu.class, "com.obric.memorydata.plugin")).a()) == false) goto L40;
        r14.put(r16.getKey(), r16.getValue());     // Catch: Throwable -> L53
        goto L40
    L44:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        ConcurrentHashMap<String, cu> r19 = r5.getShareViewModel().getSelectionManager().e();     // Catch: Throwable -> L53
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L53
    L46:
        if (r20.hasNext() == false) goto L48;
        r19.remove((String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
        goto L46
    L48:
        r5.getShareViewModel().getSelectionManager().n();     // Catch: Throwable -> L53
        r5.getShareViewModel().getSelectionManager().m();     // Catch: Throwable -> L53
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L53
        monitor-exit(r4);     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "delete entityMetaInfoList size: " + r3.size(), false, 4, null);     // Catch: Throwable -> L56
        RunLog.INSTANCE.debug("AbstractMemoryTabFragment", "delete entityMetaInfoList: " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L56
        this.this$0.getShareViewModel().getSelectionManager().j();     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete finished, totalCost=" + (System.currentTimeMillis() - this.$confirmStartTime) + " ms", false, 4, null);     // Catch: Throwable -> L56
        AbstractMemoryTabFragment.access$setBulkDeleting$p(this.this$0, false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete state reset", false, 4, null);
        return Unit.INSTANCE;
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r22 = this.J$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L56
        Object r23 = r17;
    L18:
        r3 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        long r24 = System.currentTimeMillis() - r22;     // Catch: Throwable -> L56
        MemoryListShareViewModel r25 = this.this$0.getShareViewModel();     // Catch: Throwable -> L56
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete meta query finished, cost=" + r24 + " ms, metaSize=" + r3.size() + ", selectAllState=" + r25.getSelectionManager().c().c() + ", selectedTab=" + MemoryListShareViewModel.getMixTab$default(r25, null, 1, null) + ", selectedTag=" + r25.getSelectedTag(), false, 4, null);     // Catch: Throwable -> L56
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Iterator r28 = r26.iterator();     // Catch: Throwable -> L56
    L20:
        if (r28.hasNext() == false) goto L22;
        r27.add(((cu) ZeusTransformUtils.preCheckCast(r28.next(), cu.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L56
        goto L20
    L22:
        Set r29 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L56
        CoroutineContext r30 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Function2 r31 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Continuation r32 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        this.L$0 = r3;     // Catch: Throwable -> L56
        this.L$1 = r29;     // Catch: Throwable -> L56
        this.label = 2;     // Catch: Throwable -> L56
        if (kotlinx.coroutines.i.a(r30, r31, r32) != r0) goto L25;
        return r0;
    L25:
        r1 = r29;
        goto L26
    L14:
        ResultKt.throwOnFailure(r17);
        r22 = System.currentTimeMillis();     // Catch: Throwable -> L56
        AbstractMemoryTabFragment r33 = this.this$0;     // Catch: Throwable -> L56
        Continuation<? super List<cu>> r34 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        this.J$0 = r22;     // Catch: Throwable -> L56
        this.label = 1;     // Catch: Throwable -> L56
        r23 = r33.getEntityMetaInfo(r34);     // Catch: Throwable -> L56
        if (r23 != r0) goto L18;
        return r0;
    L56:
        th = move-exception;
        AbstractMemoryTabFragment.access$setBulkDeleting$p(this.this$0, false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AbstractMemoryTabFragment", "bulk delete state reset", false, 4, null);
        throw th;
    }
}
