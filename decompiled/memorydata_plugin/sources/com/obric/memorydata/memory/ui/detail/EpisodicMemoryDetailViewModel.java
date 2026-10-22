package com.obric.memorydata.memory.ui.detail;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.list.ScreenObservationViewModel;
import com.obric.memorydata.memory.ui.list.bd;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0002H\u0002R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\f0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\n¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/EpisodicMemoryDetailViewModel;", "Lcom/obric/memorydata/memory/ui/detail/AbsMemoryDetailViewModel;", "", "<init>", "()V", "memoryCalendarItemsFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "getMemoryCalendarItemsFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "memoryKeyInfo", "", "getMemoryKeyInfo", "_memoryEntityStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ObservationEntity;", "get_memoryEntityStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "initEntityId", "pagingDataFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getPagingDataFlow$annotations", "getPagingDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "memoryEntityStateFlow", "getMemoryEntityStateFlow", "deleteMemoryEntity", "", "memoryEntity", "deleteExpiredMemoryCalendarItems", CommonConsts.APM_INNER_EVENT_COST_INIT, "sourceData", "enterFrom", "refresh", "getRelationMemoryEntity", "sourceEpisodicMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "initObservationEntity", "entityId", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EpisodicMemoryDetailViewModel extends AbsMemoryDetailViewModel<String> {
    public static final a Companion = null;
    private static final String TAG = "EpisodicMemoryDetailViewModel";
    private final kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.i> _memoryEntityStateFlow;
    private String initEntityId;
    private final ar<List<com.obric.memorydata.memory.ui.data.a.c>> memoryCalendarItemsFlow;
    private final ar<com.obric.memorydata.memory.ui.data.a.i> memoryEntityStateFlow;
    private final ar<Map<String, List<String>>> memoryKeyInfo;
    private final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> pagingDataFlow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/EpisodicMemoryDetailViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EpisodicMemoryEntity f10800b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10801a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EpisodicMemoryEntity f10802b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, EpisodicMemoryEntity r4) {
                this.f10801a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f10802b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r20, Continuation r21) {
                Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r1, EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1.class) == false) goto L7;
                EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1 r3 = (EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r1, EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
                r3.label -= Integer.MIN_VALUE;
            L8:
                Object r2 = r3.result;
                Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r5 = r3.label;
                if (r5 == 0) goto L14;
                if (r5 != 1) goto L13;
                ResultKt.throwOnFailure(r2);
            L43:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r2);
                kotlinx.coroutines.flow.j r6 = this.f10801a;
                Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin");
                List<bp> r8 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
                List<EpisodicMemoryEntity> r9 = bd.f11226a.a(r8);
                List<? extends T> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                Iterator<T> r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            L16:
                if (r11.hasNext() == false) goto L39;
                bp r12 = (bp) ZeusTransformUtils.preCheckCast(r11.next(), bp.class, "com.obric.memorydata.plugin");
                Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
                Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r15 = r13.iterator();
            L19:
                if (r15.hasNext() == false) goto L30;
                T r16 = r15.next();
                EpisodicMemoryEntity r17 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r16, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
                boolean r18 = false;
                Iterator<T> r19 = r11;
                List<EpisodicMemoryEntity> r110 = r9;
                if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r12.b(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r17.getId()), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L23;
            L27:
                if (r18 == false) goto L29;
                r14.add(r16);
            L29:
                r11 = r19;
                r9 = r110;
                goto L19
            L23:
                if (Intrinsics.areEqual(r17.getEntityId(), this.f10802b.getEntityId()) == true) goto L27;
                if (r17.getProductType() != this.f10802b.getProductType()) goto L27;
                r18 = true;
                goto L27
            L30:
                Iterator<T> r111 = r11;
                List<EpisodicMemoryEntity> r112 = r9;
                List r22 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
                if (r22.isEmpty() == true) goto L38;
                r10.add(new com.obric.memorydata.memory.ui.data.a.f(r12));
                Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin");
                Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r25 = r23.iterator();
            L35:
                if (r25.hasNext() == false) goto L37;
                r24.add(new com.obric.memorydata.memory.ui.data.a.i((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r25.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), null, 2, null));
                goto L35
            L37:
                r10.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
            L38:
                r11 = r111;
                r9 = r112;
                goto L16
            L39:
                PagingData<T> r0 = PagingData.Companion.from(r10);
                r3.label = 1;
                if (r6.emit(r0, r3) != r4) goto L43;
                return r4;
            L7:
                r3 = new EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1(this, r1);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3, EpisodicMemoryEntity r4) {
            this.f10799a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f10800b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f10799a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f10800b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10803a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10804a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10804a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1.class) == false) goto L7;
                EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1 r0 = (EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r6 = this.f10804a;
                Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r12 = PagingDataTransforms.insertFooterItem$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, new com.obric.memorydata.memory.ui.data.a.g(at.a(ZeusTransformUtils.mapRes(R.string.memory_detail_footer_text, TypedValues.Custom.S_STRING, "memory_detail_footer_text"))), 1, null);
                r0.label = 1;
                if (r6.emit(r12, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new EpisodicMemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3) {
            this.f10803a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10803a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$deleteMemoryEntity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$deleteMemoryEntity$1", f = "EpisodicMemoryDetailViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EpisodicMemoryDetailViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$deleteMemoryEntity$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$deleteMemoryEntity$1$1", f = "EpisodicMemoryDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05401 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EpisodicMemoryDetailViewModel this$0;

            C05401(EpisodicMemoryDetailViewModel r3, Continuation<? super C05401> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05401(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05401) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05401.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L18;
                ResultKt.throwOnFailure(r3);
                String r2 = EpisodicMemoryDetailViewModel.access$getInitEntityId$p(this.this$0);
                if (r2 == null) goto L7;
                EpisodicMemoryEntity r4 = bd.f11226a.a(r2);
            L8:
                if (r4 == null) goto L16;
                String r5 = r4.getUuid();
                if (r5 != null) goto L12;
            L14:
                ScreenObservationViewModel.Companion.a(r4);
                goto L16
            L12:
                if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
                MemoryEventTracker.f10515a.a(CollectionsKt.listOf(r5), MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
            L16:
                return Unit.INSTANCE;
            L7:
                r4 = null;
                goto L8
            L18:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(EpisodicMemoryDetailViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05401(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$initObservationEntity$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.EpisodicMemoryDetailViewModel$initObservationEntity$1", f = "EpisodicMemoryDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11431 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $entityId;
        int label;
        final /* synthetic */ EpisodicMemoryDetailViewModel this$0;

        C11431(String r3, EpisodicMemoryDetailViewModel r4, Continuation<? super C11431> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$entityId = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11431(this.$entityId, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11431) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11431.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r8);
            EpisodicMemoryEntity r9 = bd.f11226a.a(this.$entityId);
            if (r9 == null) goto L7;
            this.this$0.get_memoryEntityStateFlow().b(new com.obric.memorydata.memory.ui.data.a.i(r9, null, 2, null));
        L9:
            return Unit.INSTANCE;
        L7:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), EpisodicMemoryDetailViewModel.TAG, "initObservationEntity entityId = " + this.$entityId + ", can not found", null, 4, null);
            this.this$0.get_memoryEntityStateFlow().b(null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public EpisodicMemoryDetailViewModel() {
        this.memoryCalendarItemsFlow = (ar) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList()), ar.class, "com.obric.memorydata.plugin");
        this.memoryKeyInfo = (ar) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.flow.at.a(MapsKt.emptyMap()), ar.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.i> r1 = kotlinx.coroutines.flow.at.a(null);
        this._memoryEntityStateFlow = r1;
        this.pagingDataFlow = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new EpisodicMemoryDetailViewModel$special$$inlined$flatMapLatest$1(null, this), Function3.class, "com.obric.memorydata.plugin"));
        this.memoryEntityStateFlow = (ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String access$getInitEntityId$p(EpisodicMemoryDetailViewModel r0) {
        return r0.initEntityId;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.i access$getRelationMemoryEntity(EpisodicMemoryDetailViewModel r0, EpisodicMemoryEntity r1) {
        return r0.getRelationMemoryEntity(r1);
    }

    public static /* synthetic */ void getPagingDataFlow$annotations() {
    }

    private final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getRelationMemoryEntity(EpisodicMemoryEntity r3) {
        return kotlinx.coroutines.flow.k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(bd.f11226a.a(r3.getId()), r3), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    private final void initObservationEntity(String r9) {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11431(r9, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public void deleteExpiredMemoryCalendarItems() {
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* synthetic */ void deleteMemoryEntity(String r3) {
        deleteMemoryEntity2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: deleteMemoryEntity, reason: avoid collision after fix types in other method */
    public void deleteMemoryEntity2(String r8) {
        Intrinsics.checkNotNullParameter(r8, "memoryEntity");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<List<com.obric.memorydata.memory.ui.data.a.c>> getMemoryCalendarItemsFlow() {
        return this.memoryCalendarItemsFlow;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<com.obric.memorydata.memory.ui.data.a.i> getMemoryEntityStateFlow() {
        return this.memoryEntityStateFlow;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<Map<String, List<String>>> getMemoryKeyInfo() {
        return this.memoryKeyInfo;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getPagingDataFlow() {
        return this.pagingDataFlow;
    }

    public final kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.i> get_memoryEntityStateFlow() {
        return this._memoryEntityStateFlow;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* synthetic */ void init(String r3, String r4) {
        init2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sourceData");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        super.init(r2, r3);
        this.initEntityId = r2;
        initObservationEntity(r2);
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* bridge */ /* synthetic */ String refresh() {
        return refresh2();
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    /* JADX INFO: renamed from: refresh, reason: avoid collision after fix types in other method */
    public String refresh2() {
        String r0 = this.initEntityId;
        if (r0 == null) goto L5;
        EpisodicMemoryEntity r1 = bd.f11226a.a(r0);
    L6:
        if (r1 == null) goto L9;
        this._memoryEntityStateFlow.b(new com.obric.memorydata.memory.ui.data.a.i(r1, null, 2, null));
        return this.initEntityId;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refreshObservationEntity entityId = " + this.initEntityId + ", can not found", null, 4, null);
        this._memoryEntityStateFlow.b(null);
        return null;
    L5:
        r1 = null;
        goto L6
    }
}
