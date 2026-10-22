package com.obric.memorydata.memory.memoryentity;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.bo;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.ew;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.memory.ui.list.PersonalTag;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J)\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150#0\"2\u0006\u0010 \u001a\u00020\u0005J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\"2\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u0006\u0010(\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemoryEntityViewPageDataManager;", "", "<init>", "()V", "TAG", "", "getMemoryEntityItems", "Landroidx/paging/Pager;", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "pageConfig", "Landroidx/paging/PagingConfig;", "tagType", "sourcePackageName", "sourceProductType", "(Lcom/obric/memorydata/memory/ui/list/MemoryTab;Landroidx/paging/PagingConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroidx/paging/Pager;", BuildConfig.CHANNEL, "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "delete", "deleteMethod", "expectedChangeSeq", "", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;Ljava/lang/Long;)Z", "deleteSemanticBatch", "expectedVersions", "", "markSemanticDeleteForSync", "", "entityId", "getRelatedMemoryEntityItems", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getPendingMemoryCalendarItems", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "memoryUUID", "deleteExpiredMemoryCalendarItems", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10317a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10318a = null;

        static {
            int[] r0 = new int[MemoryTab.values().length];
            r0[MemoryTab.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryTab.PROFILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10318a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements i<PagingData<MemoryEntity>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f10319a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.memoryentity.d$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f10320a;

            public AnonymousClass1(j r3) {
                this.f10320a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r8, Continuation r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$$inlined$map$1$2$1.class) == false) goto L7;
                MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$$inlined$map$1$2$1 r0 = (MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r10, MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L16;
                if (r3 == 1) goto L15;
                if (r3 != 2) goto L14;
                ResultKt.throwOnFailure(r11);
            L23:
                return Unit.INSTANCE;
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L15:
                j r7 = (j) ZeusTransformUtils.preCheckCast(r0.L$0, j.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r11);
            L19:
                PagingData<T> r12 = PagingData.Companion.from((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"));
                r0.L$0 = null;
                r0.label = 2;
                if (r7.emit(r12, r0) != r2) goto L23;
                return r2;
            L16:
                ResultKt.throwOnFailure(r11);
                r7 = this.f10320a;
                Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                List r14 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
                CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
                Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$1$memoryEntities$1(r14, null), Function2.class, "com.obric.memorydata.plugin");
                r0.L$0 = r7;
                r0.label = 1;
                r11 = kotlinx.coroutines.i.a(r15, r16, r0);
                if (r11 != r2) goto L19;
                return r2;
            L7:
                r0 = new MemoryEntityViewPageDataManager$getRelatedMemoryEntityItems$$inlined$map$1$2$1(this, r10);
                goto L8
            }
        }

        public b(i r3) {
            this.f10319a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super PagingData<MemoryEntity>> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10319a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
        f10317a = new d();
    }

    private d() {
    }

    public static /* synthetic */ Pager a(d r7, MemoryTab r8, PagingConfig r9, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r13 & 16) == 0) goto L13;
        Integer r6 = null;
    L15:
        return r7.a(r8, r9, r4, r5, r6);
    L13:
        r6 = r12;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    private static final PagingSource a(MemoryTab r3, String r4, Integer r5, String r6) {
        int r0 = a.f10318a[r3.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r7 != null) goto L19;
    L22:
        if (r1 == false) goto L24;
        PagingSource<Integer, bt> r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getAllCollectMemoryWithRelevantPojo();
    L28:
        MappingPagingSource r9 = new MappingPagingSource(r8, $$Lambda$d$c_k90T1bu2kzyPtsdAPzLeLkj_0.INSTANCE);
    L29:
        return (PagingSource) ZeusTransformUtils.preCheckCast(r9, PagingSource.class, "com.obric.memorydata.plugin");
    L24:
        EpisodicMemoryDao r10 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
        if (r5 == null) goto L27;
        r2 = r5.intValue();
    L27:
        r8 = r10.getCollectMemoryWithRelevantPojoBySource(r4, r2);
        goto L28
    L19:
        if (r7.length() == 0) goto L22;
        r1 = false;
        goto L22
    L5:
        if (r0 != 2) goto L15;
        if (Intrinsics.areEqual(r6, PersonalTag.f11118a.a()) == false) goto L10;
        r9 = new MappingPagingSource(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getInfoAllTypeMemoryWithRelevantPojo(), $$Lambda$d$IKn5kkeeLhtxfbmF05rx7Nj_eI.INSTANCE);
        goto L29
    L10:
        if (Intrinsics.areEqual(r6, PersonalTag.f11118a.i()) == false) goto L12;
        r9 = new MappingPagingSource(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getInfoOthersTypeMemoryWithRelevantPojo(PersonalTag.f11118a.l()), $$Lambda$d$Jj2YIpbRfxIvuXKnh7JTaQa1PxU.INSTANCE);
        goto L29
    L12:
        r9 = new MappingPagingSource(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getInfoSingleTagMemoryWithRelevantPojo(r6), $$Lambda$d$2f6lp3lT5Coj_vuqDwtEcG_9lN0.INSTANCE);
        goto L29
    L15:
        throw new RuntimeException("unsupported tab: " + r3 + " when getMemoryEntityItems");
    }

    private static final bo a(bt r2) {
        Intrinsics.checkNotNullParameter(r2, "pojo");
        return new bo(r2.a(), r2.b());
    }

    private static final ig a(ih r2) {
        Intrinsics.checkNotNullParameter(r2, "pojo");
        return new ig(r2.a(), r2.b());
    }

    public static /* synthetic */ boolean a(d r0, MemoryEntity r1, String r2, Long r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.delete(r1, r2, r3);
    }

    private static final ig b(ih r2) {
        Intrinsics.checkNotNullParameter(r2, "pojo");
        return new ig(r2.a(), r2.b());
    }

    private static final ig c(ih r2) {
        Intrinsics.checkNotNullParameter(r2, "pojo");
        return new ig(r2.a(), r2.b());
    }

    private final void c(String r2) {
        ew r1 = (ew) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().queryByTypeAndEntityId(2, r2)), ew.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(0);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().update(r1);
        return;
    }

    public static /* synthetic */ ig lambda$2f6lp3lT5Coj_vuqDwtEcG_9lN0(ih r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$IK-n5kkeeLhtxfbmF05rx7Nj_eI, reason: not valid java name */
    public static /* synthetic */ ig m741lambda$IKn5kkeeLhtxfbmF05rx7Nj_eI(ih r0) {
        return a(r0);
    }

    public static /* synthetic */ ig lambda$Jj2YIpbRfxIvuXKnh7JTaQa1PxU(ih r0) {
        return b(r0);
    }

    public static /* synthetic */ bo lambda$c_k90T1bu2kzyPtsdAPzLeLkj_0(bt r0) {
        return a(r0);
    }

    public static /* synthetic */ PagingSource lambda$uC3QndMCEZE0_RfZW2pyZM5zmBo(MemoryTab r0, String r1, Integer r2, String r3) {
        return a(r0, r1, r2, r3);
    }

    public final Pager<Integer, ? extends com.obric.memorydata.database.entity.d> a(final MemoryTab r7, PagingConfig r8, final String r9, final String r10, final Integer r11) {
        Intrinsics.checkNotNullParameter(r7, "tab");
        Intrinsics.checkNotNullParameter(r8, "pageConfig");
        Object r2 = null;
        return new Pager(r8, r2, new $$Lambda$d$uC3QndMCEZE0_RfZW2pyZM5zmBo(r7, r10, r11, r9), 2, null);
    }

    public final i<PagingData<MemoryEntity>> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return (i) ZeusTransformUtils.preCheckCast(new b(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryEntityCorrelationDao().getValidRelatedEntitiesWithOrder(r2)), i.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(Map<String, Long> r4, String r5) {
        Map<String, Long> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "expectedVersions");
        boolean r7 = MemoryEntityManager.INSTANCE.deleteSemanticMemories(r6, r5);
        if (r7 == false) goto L8;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        c((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"));
    L8:
        return r7;
    }

    public final i<List<PendingMemoryCalendar>> b(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return k.a();
    L12:
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getPendingMemoryCalendarDao().queryByMemoryUUIDGroupedAndSorted(r2);
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean delete(MemoryEntity r7, String r8, Long r9) {
        Intrinsics.checkNotNullParameter(r7, "memoryEntity");
        boolean r10 = MemoryEntityManager.INSTANCE.deleteDirectly(r7, r8, r9);
        if (r10 == false) goto L5;
        c(r7.getId());
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEntityViewPageDataManager", "delete local: " + r10, false, 4, null);
        return r10;
    }

    public final boolean update(MemoryEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "memoryEntity");
        return MemoryEntityManager.indexDirectly$default(MemoryEntityManager.INSTANCE, r4, false, 2, null);
    }
}
