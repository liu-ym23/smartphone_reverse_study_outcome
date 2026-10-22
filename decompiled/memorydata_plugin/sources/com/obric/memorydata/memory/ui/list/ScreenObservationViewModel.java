package com.obric.memorydata.memory.ui.list;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ew;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0014J\u000e\u0010+\u001a\u00020)H\u0086@¢\u0006\u0002\u0010,J\u0010\u0010!\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u0014J\u0016\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u001a\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010*\u001a\u00020\u0014J\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u00020)J\u000e\u00106\u001a\u00020)H\u0086@¢\u0006\u0002\u0010,J$\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:H\u0082@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0086@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u001a¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\n¨\u0006C"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_listRefreshFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "listRefreshFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getListRefreshFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "cachedData", "", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "flowByDate", "", "Ljava/time/LocalDate;", "_screenMemoryDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "screenMemoryDate", "Lkotlinx/coroutines/flow/StateFlow;", "getScreenMemoryDate", "()Lkotlinx/coroutines/flow/StateFlow;", "_screenMemoryValidateDay", "_currentSelectDate", "currentSelectDate", "getCurrentSelectDate", "setCurrentSelectDate", "(Lkotlinx/coroutines/flow/StateFlow;)V", "screenMemoryValidateDay", "getScreenMemoryValidateDay", "_totalCountsChangeEvent", "totalCountsChangeEvent", "getTotalCountsChangeEvent", "notifyTotalCountsChange", "", "date", "refreshScreenMemoryValidateDay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localDate", "changeMemoryDateByEntity", "entity", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getMemoryListByDate", "clearCache", "clearData", "refreshScreenMemoryDateList", "generateMemoryItemTime", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "before", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "after", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMemoryEntity", "shortMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "(Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLocalData", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationViewModel";
    private final kotlinx.coroutines.flow.ae<LocalDate> _currentSelectDate;
    private final kotlinx.coroutines.flow.ad<Boolean> _listRefreshFlow;
    private final kotlinx.coroutines.flow.ae<List<p>> _screenMemoryDate;
    private final kotlinx.coroutines.flow.ae<Long> _screenMemoryValidateDay;
    private final kotlinx.coroutines.flow.ad<LocalDate> _totalCountsChangeEvent;
    private final Set<Long> cachedData;
    private kotlinx.coroutines.flow.ar<LocalDate> currentSelectDate;
    private kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> flow;
    private Map<LocalDate, kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>>> flowByDate;
    private final kotlinx.coroutines.flow.ai<Boolean> listRefreshFlow;
    private final kotlinx.coroutines.flow.ar<List<p>> screenMemoryDate;
    private final kotlinx.coroutines.flow.ar<Long> screenMemoryValidateDay;
    private final kotlinx.coroutines.flow.ai<LocalDate> totalCountsChangeEvent;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/ScreenObservationViewModel$Companion;", "", "<init>", "()V", "TAG", "", "deleteEntity", "", "shortMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(EpisodicMemoryEntity r2) {
            Intrinsics.checkNotNullParameter(r2, "shortMemoryEntity");
            String r1 = r2.getEntityId();
            EpisodicMemoryEntity r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r1);
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.delete() == false) goto L11;
            ew r4 = (ew) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().queryByTypeAndEntityId(1, r1)), ew.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L12;
            r4.a(0);
            MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().update(r4);
            return;
        L12:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EpisodicMemoryEntity f11141b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11142a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EpisodicMemoryEntity f11143b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, EpisodicMemoryEntity r4) {
                this.f11142a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11143b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$1$2$1.class) == false) goto L7;
                ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$1$2$1 r0 = (ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r9, ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f11142a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.filter((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationViewModel$deleteMemoryEntity$2$1(this.f11143b, null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$1$2$1(this, r9);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3, EpisodicMemoryEntity r4) {
            this.f11140a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11141b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11140a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11141b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScreenObservationViewModel f11145b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11146a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScreenObservationViewModel f11147b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, ScreenObservationViewModel r4) {
                this.f11146a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11147b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$2$2$1.class) == false) goto L7;
                ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$2$2$1 r0 = (ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f11146a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new ScreenObservationViewModel$deleteMemoryEntity$3$1(this.f11147b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new ScreenObservationViewModel$deleteMemoryEntity$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3, ScreenObservationViewModel r4) {
            this.f11144a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11145b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11144a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11145b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$changeMemoryDateByEntity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$changeMemoryDateByEntity$1", f = "ScreenObservationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveMemoryEntity $entity;
        final /* synthetic */ MemoryListShareViewModel $shareViewModel;
        int label;
        final /* synthetic */ ScreenObservationViewModel this$0;

        AnonymousClass1(ProactiveMemoryEntity r3, ScreenObservationViewModel r4, MemoryListShareViewModel r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$entity = r3;
            this.this$0 = r4;
            this.$shareViewModel = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$entity, this.this$0, this.$shareViewModel, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            EpisodicMemoryEntity r6 = bd.f11226a.a(this.$entity.getId());
            if (r6 == null) goto L8;
            ScreenObservationViewModel r0 = this.this$0;
            MemoryListShareViewModel r1 = this.$shareViewModel;
            ProactiveMemoryEntity r4 = this.$entity;
            LocalDate r7 = Instant.ofEpochMilli(r6.getStartTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate();
            ScreenObservationViewModel.access$get_currentSelectDate$p(r0).b(r7);
            r1.setTargetEntity(MemoryTab.OBSERVATION, (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin"), r7);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a.i>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScreenObservationViewModel f11149b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11150a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScreenObservationViewModel f11151b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, ScreenObservationViewModel r4) {
                this.f11150a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11151b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$1$2$1.class) == false) goto L7;
                ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$1$2$1 r0 = (ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r9, ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f11150a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.map(PagingDataTransforms.filter((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationViewModel$getMemoryListByDate$1$1$1(this.f11151b, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationViewModel$getMemoryListByDate$1$1$2(null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$1$2$1(this, r9);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3, ScreenObservationViewModel r4) {
            this.f11148a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11149b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a.i>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11148a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11149b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScreenObservationViewModel f11153b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11154a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScreenObservationViewModel f11155b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, ScreenObservationViewModel r4) {
                this.f11154a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11155b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$2$2$1.class) == false) goto L7;
                ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$2$2$1 r0 = (ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f11154a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new ScreenObservationViewModel$getMemoryListByDate$1$2$1(this.f11155b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new ScreenObservationViewModel$getMemoryListByDate$lambda$3$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3, ScreenObservationViewModel r4) {
            this.f11152a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11153b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11152a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11153b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$generateMemoryItemTime$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$generateMemoryItemTime$2", f = "ScreenObservationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super com.obric.memorydata.memory.ui.data.a.l>, Object> {
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.i $after;
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.i $before;
        int label;

        AnonymousClass2(com.obric.memorydata.memory.ui.data.a.i r3, com.obric.memorydata.memory.ui.data.a.i r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$after = r3;
            this.$before = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$after, this.$before, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r6);
            if (this.$after == null) goto L13;
            if (this.$before != null) goto L10;
            return null;
        L10:
            if (com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getStartTimestamp(), this.$after.b().getStartTimestamp()) == false) goto L19;
            return null;
        L19:
            return new com.obric.memorydata.memory.ui.data.a.l(com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getStartTimestamp()), false);
        L13:
            if (this.$before != null) goto L15;
            return null;
        L15:
            return new com.obric.memorydata.memory.ui.data.a.l(com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getStartTimestamp()), true);
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$notifyTotalCountsChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$notifyTotalCountsChange$1", f = "ScreenObservationViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class C11891 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LocalDate $date;
        int label;
        final /* synthetic */ ScreenObservationViewModel this$0;

        C11891(ScreenObservationViewModel r3, LocalDate r4, Continuation<? super C11891> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$date = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11891(this.this$0, this.$date, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11891) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11891.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ad r7 = ScreenObservationViewModel.access$get_totalCountsChangeEvent$p(this.this$0);
            LocalDate r2 = this.$date;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$refreshScreenMemoryDateList$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$refreshScreenMemoryDateList$2", f = "ScreenObservationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11902 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationViewModel this$0;

        C11902(ScreenObservationViewModel r3, Continuation<? super C11902> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11902(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11902) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11902.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            ScreenObservationViewModel.access$get_screenMemoryDate$p(this.this$0).b(bd.f11226a.b());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$refreshScreenMemoryValidateDay$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.ScreenObservationViewModel$refreshScreenMemoryValidateDay$2", f = "ScreenObservationViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    static final class C11912 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ScreenObservationViewModel this$0;

        C11912(ScreenObservationViewModel r3, Continuation<? super C11912> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11912(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11912) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11912.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            kotlinx.coroutines.flow.ae r7 = (kotlinx.coroutines.flow.ae) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.ae.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L12:
            r7.b(r8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.ae r9 = ScreenObservationViewModel.access$get_screenMemoryValidateDay$p(this.this$0);
            bd r2 = bd.f11226a;
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r9;
            this.label = 1;
            Object r10 = bd.a(r2, false, r3, 1, null);
            if (r10 != r0) goto L11;
            return r0;
        L11:
            r8 = r10;
            r7 = r9;
            goto L12
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationViewModel() {
        kotlinx.coroutines.flow.ad<Boolean> r2 = kotlinx.coroutines.flow.ak.a(0, 0, null, 6, null);
        this._listRefreshFlow = r2;
        this.listRefreshFlow = (kotlinx.coroutines.flow.ai) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.flow.ai.class, "com.obric.memorydata.plugin");
        this.cachedData = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.flowByDate = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ae<List<p>> r3 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this._screenMemoryDate = r3;
        this.screenMemoryDate = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ae<Long> r4 = kotlinx.coroutines.flow.at.a(0L);
        this._screenMemoryValidateDay = r4;
        kotlinx.coroutines.flow.ae<LocalDate> r5 = kotlinx.coroutines.flow.at.a(null);
        this._currentSelectDate = r5;
        this.currentSelectDate = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        this.screenMemoryValidateDay = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ad<LocalDate> r0 = kotlinx.coroutines.flow.ak.a(0, 0, null, 7, null);
        this._totalCountsChangeEvent = r0;
        this.totalCountsChangeEvent = (kotlinx.coroutines.flow.ai) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.flow.ai.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object access$generateMemoryItemTime(ScreenObservationViewModel r2, com.obric.memorydata.memory.ui.data.a.i r3, com.obric.memorydata.memory.ui.data.a.i r4, Continuation r5) {
        return r2.generateMemoryItemTime(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Set access$getCachedData$p(ScreenObservationViewModel r0) {
        return r0.cachedData;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_currentSelectDate$p(ScreenObservationViewModel r0) {
        return r0._currentSelectDate;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_screenMemoryDate$p(ScreenObservationViewModel r0) {
        return r0._screenMemoryDate;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_screenMemoryValidateDay$p(ScreenObservationViewModel r0) {
        return r0._screenMemoryValidateDay;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_totalCountsChangeEvent$p(ScreenObservationViewModel r0) {
        return r0._totalCountsChangeEvent;
    }

    private final Object generateMemoryItemTime(com.obric.memorydata.memory.ui.data.a.i r4, com.obric.memorydata.memory.ui.data.a.i r5, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void lambda$3OcsfM6T0UZxu8USkdQYpHACWLs(EpisodicMemoryEntity r0) {
        removeLocalData$lambda$7(r0);
    }

    private final void removeLocalData(final EpisodicMemoryEntity r2) {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$ScreenObservationViewModel$3OcsfM6T0UZxu8USkdQYpHACWLs(r2));
    }

    private static final void removeLocalData$lambda$7(EpisodicMemoryEntity r1) {
        Companion.a(r1);
    }

    public final void changeMemoryDateByEntity(ProactiveMemoryEntity r9, MemoryListShareViewModel r10) {
        Intrinsics.checkNotNullParameter(r9, "entity");
        Intrinsics.checkNotNullParameter(r10, "shareViewModel");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final void clearCache() {
        this.cachedData.clear();
    }

    public final void clearData() {
        this.flow = null;
        clearCache();
    }

    public final Object deleteMemoryEntity(EpisodicMemoryEntity r5, Continuation<? super Unit> r6) {
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        removeLocalData(r5);
        this.cachedData.remove(Boxing.boxLong(r5.getId()));
        kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r0 = this.flow;
        if (r0 == null) goto L5;
        kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(r0, r5), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    L6:
        this.flow = r8;
        Object r4 = this._listRefreshFlow.emit(Boxing.boxBoolean(true), r7);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    L5:
        r8 = null;
        goto L6
    }

    public final kotlinx.coroutines.flow.ar<LocalDate> getCurrentSelectDate() {
        return this.currentSelectDate;
    }

    public final kotlinx.coroutines.flow.ai<Boolean> getListRefreshFlow() {
        return this.listRefreshFlow;
    }

    public final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getMemoryListByDate(LocalDate r4) {
        Intrinsics.checkNotNullParameter(r4, "date");
        kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r0 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.flowByDate.get(r4), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ScreenObservationViewModel r3 = (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(this, ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r1 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d(bd.f11226a.a(r4), r3), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r3), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        r3.flowByDate.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public final kotlinx.coroutines.flow.ar<List<p>> getScreenMemoryDate() {
        return this.screenMemoryDate;
    }

    public final kotlinx.coroutines.flow.ar<Long> getScreenMemoryValidateDay() {
        return this.screenMemoryValidateDay;
    }

    public final kotlinx.coroutines.flow.ai<LocalDate> getTotalCountsChangeEvent() {
        return this.totalCountsChangeEvent;
    }

    public final void notifyTotalCountsChange(LocalDate r9) {
        Intrinsics.checkNotNullParameter(r9, "date");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11891(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final Object refreshScreenMemoryDateList(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11902(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object refreshScreenMemoryValidateDay(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11912(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final void setCurrentSelectDate(LocalDate r1) {
        this._currentSelectDate.b(r1);
    }

    public final void setCurrentSelectDate(kotlinx.coroutines.flow.ar<LocalDate> r3) {
        kotlinx.coroutines.flow.ar<LocalDate> r4 = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.currentSelectDate = r4;
    }
}
