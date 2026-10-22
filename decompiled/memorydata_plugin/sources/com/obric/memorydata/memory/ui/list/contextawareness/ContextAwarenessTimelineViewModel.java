package com.obric.memorydata.memory.ui.list.contextawareness;

import android.database.sqlite.SQLiteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.paging.PagingSource;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.cu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\bJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\bJ\u0017\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\"J\u0018\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J@\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\u001e\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020/2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020/2\u0006\u00104\u001a\u00020 H\u0086@¢\u0006\u0002\u00105J\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001b2\u0006\u0010\u001e\u001a\u00020\bJ\u001e\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006="}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;", "zoneId", "Ljava/time/ZoneId;", "todayProvider", "Lkotlin/Function0;", "Ljava/time/LocalDate;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;Ljava/time/ZoneId;Lkotlin/jvm/functions/Function0;)V", "initialDate", "_selectedDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedDate", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedDate", "()Lkotlinx/coroutines/flow/StateFlow;", "_calendarState", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessCalendarState;", "calendarState", "getCalendarState", "_resolvedTarget", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessResolvedTarget;", "resolvedTarget", "getResolvedTarget", "timeline", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "date", "selectDate", "", "publishResolvedTarget", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "clearResolvedTarget", "requestId", "", "(Ljava/lang/Long;)V", "refreshCalendar", "resolveTargetDate", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySelectionMetaInfo", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "screenIds", "", "audioIds", "withSpecifiedRange", "(Ljava/time/LocalDate;Ljava/util/List;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTotalCount", "", "createTimeLine", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "before", "after", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessTimelineViewModel extends ViewModel {
    private static final a Companion = null;

    @Deprecated
    public static final int PAGE_SIZE = 30;
    private final ae<c> _calendarState;
    private final ae<h> _resolvedTarget;
    private final ae<LocalDate> _selectedDate;
    private final ar<c> calendarState;
    private final LocalDate initialDate;
    private final q repository;
    private final ar<h> resolvedTarget;
    private final ar<LocalDate> selectedDate;
    private final Function0<LocalDate> todayProvider;
    private final ZoneId zoneId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineViewModel$Companion;", "", "<init>", "()V", "PAGE_SIZE", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessTimelineViewModel f11259b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ContextAwarenessTimelineViewModel f11261b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, ContextAwarenessTimelineViewModel r4) {
                this.f11260a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11261b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, ContextAwarenessTimelineViewModel$timeline$$inlined$map$1$2$1.class) == false) goto L7;
                ContextAwarenessTimelineViewModel$timeline$$inlined$map$1$2$1 r0 = (ContextAwarenessTimelineViewModel$timeline$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r9, ContextAwarenessTimelineViewModel$timeline$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r11 = this.f11260a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default(PagingDataTransforms.map((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineViewModel$timeline$2$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin")), null, (Function3) ZeusTransformUtils.preCheckCast(new ContextAwarenessTimelineViewModel$timeline$2$2(this.f11261b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new ContextAwarenessTimelineViewModel$timeline$$inlined$map$1$2$1(this, r9);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3, ContextAwarenessTimelineViewModel r4) {
            this.f11258a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11259b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f11258a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f11259b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$querySelectionMetaInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$querySelectionMetaInfo$2", f = "ContextAwarenessTimelineViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends cu>>, Object> {
        final /* synthetic */ List<String> $audioIds;
        final /* synthetic */ LocalDate $date;
        final /* synthetic */ List<String> $screenIds;
        final /* synthetic */ boolean $withSpecifiedRange;
        int label;
        final /* synthetic */ ContextAwarenessTimelineViewModel this$0;

        AnonymousClass2(ContextAwarenessTimelineViewModel r3, LocalDate r4, List<String> r5, List<String> r6, boolean r7, Continuation<? super AnonymousClass2> r8) {
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$date = r4;
            this.$screenIds = r9;
            this.$audioIds = r10;
            this.$withSpecifiedRange = r7;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$date, this.$screenIds, this.$audioIds, this.$withSpecifiedRange, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends cu>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<cu>> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            q r3 = ContextAwarenessTimelineViewModel.access$getRepository$p(this.this$0);
            d r4 = d.f11265a.a(this.$date, ContextAwarenessTimelineViewModel.access$getZoneId$p(this.this$0));
            List<String> r5 = this.$screenIds;
            List<String> r6 = this.$audioIds;
            boolean r7 = this.$withSpecifiedRange;
            Continuation<? super List<cu>> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r10 = r3.a(r4, r5, r6, r7, r8);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$refreshCalendar$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$refreshCalendar$1", f = "ContextAwarenessTimelineViewModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessTimelineViewModel this$0;

        AnonymousClass1(ContextAwarenessTimelineViewModel r3, Continuation<? super AnonymousClass1> r4) {
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
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: SQLiteException -> L16
        L13:
            Set<LocalDate> r8 = (Set) ZeusTransformUtils.preCheckCast(r7, Set.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L16
            LocalDate r2 = (LocalDate) ZeusTransformUtils.preCheckCast(ContextAwarenessTimelineViewModel.access$getTodayProvider$p(this.this$0).invoke(), LocalDate.class, "com.obric.memorydata.plugin");
            ContextAwarenessTimelineViewModel.access$get_calendarState$p(this.this$0).b(new c(com.obric.memorydata.memory.ui.list.contextawareness.b.f11262a.a(r8, r2), r8.size(), r2));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L16
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new ContextAwarenessTimelineViewModel$refreshCalendar$1$recordedDates$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L16
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L16
            this.label = 1;     // Catch: SQLiteException -> L16
            r7 = kotlinx.coroutines.i.a(r9, r3, r4);     // Catch: SQLiteException -> L16
            if (r7 != r0) goto L13;
            return r0;
        L17:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$resolveTargetDate$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/time/LocalDate;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineViewModel$resolveTargetDate$2", f = "ContextAwarenessTimelineViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12072 extends SuspendLambda implements Function2<al, Continuation<? super LocalDate>, Object> {
        final /* synthetic */ v $target;
        int label;
        final /* synthetic */ ContextAwarenessTimelineViewModel this$0;

        C12072(ContextAwarenessTimelineViewModel r3, v r4, Continuation<? super C12072> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$target = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12072(this.this$0, this.$target, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super LocalDate> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super LocalDate> r4) {
            return ((C12072) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12072.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return ContextAwarenessTimelineViewModel.access$getRepository$p(this.this$0).a(this.$target, ContextAwarenessTimelineViewModel.access$getZoneId$p(this.this$0));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public ContextAwarenessTimelineViewModel() {
        this(null, null, null, 7, null);
    }

    public ContextAwarenessTimelineViewModel(q r3, ZoneId r4, Function0<LocalDate> r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin");
        Function0<LocalDate> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "repository");
        Intrinsics.checkNotNullParameter(r4, "zoneId");
        Intrinsics.checkNotNullParameter(r7, "todayProvider");
        this.repository = r6;
        this.zoneId = r4;
        this.todayProvider = r7;
        LocalDate r8 = (LocalDate) ZeusTransformUtils.preCheckCast(r7.invoke(), LocalDate.class, "com.obric.memorydata.plugin");
        this.initialDate = r8;
        ae<LocalDate> r9 = at.a(r8);
        this._selectedDate = r9;
        this.selectedDate = kotlinx.coroutines.flow.k.a(r9);
        ae<c> r10 = at.a(new c(com.obric.memorydata.memory.ui.list.contextawareness.b.f11262a.a(SetsKt.emptySet(), r8), 0, r8));
        this._calendarState = r10;
        this.calendarState = kotlinx.coroutines.flow.k.a(r10);
        ae<h> r11 = at.a(null);
        this._resolvedTarget = r11;
        this.resolvedTarget = kotlinx.coroutines.flow.k.a(r11);
    }

    public /* synthetic */ ContextAwarenessTimelineViewModel(q r8, final ZoneId r9, Function0 r10, int r11, DefaultConstructorMarker r12) {
        q r13 = (q) ZeusTransformUtils.wrapperContextForParams(r8, q.class, "com.obric.memorydata.plugin");
        Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        if ((r11 & 1) == 0) goto L6;
        r13 = (q) ZeusTransformUtils.preCheckCast(new y(null, null, null, 7, null), q.class, "com.obric.memorydata.plugin");
    L6:
        if ((r11 & 2) == 0) goto L9;
        r9 = ZoneId.systemDefault();
    L9:
        if ((r11 & 4) == 0) goto L11;
        r14 = new $$Lambda$ContextAwarenessTimelineViewModel$_JcmV40cYtIVsUujun2Uvt35gQ(r9);
    L11:
        this(r13, r9, r14);
    }

    private static final LocalDate _init_$lambda$0(ZoneId r0) {
        return LocalDate.now(r0);
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.data.a.l access$createTimeLine(ContextAwarenessTimelineViewModel r0, com.obric.memorydata.memory.ui.data.a r1, com.obric.memorydata.memory.ui.data.a r2) {
        return r0.createTimeLine(r1, r2);
    }

    public static final /* synthetic */ q access$getRepository$p(ContextAwarenessTimelineViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ Function0 access$getTodayProvider$p(ContextAwarenessTimelineViewModel r0) {
        return r0.todayProvider;
    }

    public static final /* synthetic */ ZoneId access$getZoneId$p(ContextAwarenessTimelineViewModel r0) {
        return r0.zoneId;
    }

    public static final /* synthetic */ ae access$get_calendarState$p(ContextAwarenessTimelineViewModel r0) {
        return r0._calendarState;
    }

    public static final /* synthetic */ Object access$timeline$lambda$2$toMemoryItem(t r2, Continuation r3) {
        return timeline$lambda$2$toMemoryItem(r2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void clearResolvedTarget$default(ContextAwarenessTimelineViewModel r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.clearResolvedTarget(r1);
    }

    private final com.obric.memorydata.memory.ui.data.a.l createTimeLine(com.obric.memorydata.memory.ui.data.a r8, com.obric.memorydata.memory.ui.data.a r9) {
        if (r8 == null) goto L18;
        long r1 = s.f11287a.a(r8);
        if (r9 == null) goto L7;
        Long r10 = Long.valueOf(s.f11287a.a(r9));
    L8:
        if (r10 != null) goto L10;
    L12:
        String r11 = com.obric.memorydata.memory.utils.f.f11537a.a(r1);
        if (r9 != null) goto L15;
        boolean r12 = true;
    L17:
        return new com.obric.memorydata.memory.ui.data.a.l(r11, r12);
    L15:
        r12 = false;
        goto L17
    L10:
        if (Intrinsics.areEqual(s.f11287a.b(r1, this.zoneId), s.f11287a.b(r10.longValue(), this.zoneId)) == false) goto L12;
        return null;
    L7:
        r10 = null;
        goto L8
    L18:
        return null;
    }

    /* JADX INFO: renamed from: lambda$_JcmV40cYtI-VsUujun2Uvt35gQ, reason: not valid java name */
    public static /* synthetic */ LocalDate m942lambda$_JcmV40cYtIVsUujun2Uvt35gQ(ZoneId r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ PagingSource lambda$zf0oSvuSLp7zhBhuQwsAkoiUSZ4(ContextAwarenessTimelineViewModel r0, LocalDate r1) {
        return timeline$lambda$1(r0, r1);
    }

    private static final PagingSource timeline$lambda$1(ContextAwarenessTimelineViewModel r3, LocalDate r4) {
        return (PagingSource) ZeusTransformUtils.preCheckCast(new ContextAwarenessTimelinePagingSource(r3.repository, d.f11265a.a(r4, r3.zoneId)), PagingSource.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ Object timeline$lambda$2$toMemoryItem(t r2, Continuation r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return r2.d();
    }

    public final void clearResolvedTarget(Long r5) {
        if (r5 == null) goto L12;
        h r1 = (h) ZeusTransformUtils.preCheckCast(this._resolvedTarget.c(), h.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        l r2 = r1.a();
        if (r2 == null) goto L9;
        Long r3 = Long.valueOf(r2.a());
    L11:
        if (Intrinsics.areEqual(r3, r5) == true) goto L12;
        return;
    L9:
        r3 = null;
    L12:
        this._resolvedTarget.b(null);
    }

    public final ar<c> getCalendarState() {
        return this.calendarState;
    }

    public final ar<h> getResolvedTarget() {
        return this.resolvedTarget;
    }

    public final ar<LocalDate> getSelectedDate() {
        return this.selectedDate;
    }

    public final kotlinx.coroutines.flow.i<Integer> observeTotalCount(LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "date");
        return this.repository.a(d.f11265a.a(r3, this.zoneId));
    }

    public final void publishResolvedTarget(l r2, LocalDate r3) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r3, "date");
        this._resolvedTarget.b(new h(r2, r3));
    }

    public final Object querySelectionMetaInfo(LocalDate r10, List<String> r11, List<String> r12, boolean r13, Continuation<? super List<cu>> r14) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r10, r5, r6, r13, null), Function2.class, "com.obric.memorydata.plugin"), r15);
    }

    public final void refreshCalendar() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final Object resolveTargetDate(v r5, Continuation<? super LocalDate> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C12072(this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    public final boolean selectDate(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        if (Intrinsics.areEqual(this._selectedDate.c(), r2) == false) goto L6;
        return false;
    L6:
        this._selectedDate.b(r2);
        return true;
    }

    public final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> timeline(final LocalDate r12) {
        Intrinsics.checkNotNullParameter(r12, "date");
        Object r3 = null;
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(new Pager(new PagingConfig(30, 15, false, 30, 0, 0, 48, null), r3, new $$Lambda$ContextAwarenessTimelineViewModel$zf0oSvuSLp7zhBhuQwsAkoiUSZ4(this, r12), 2, null).getFlow(), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }
}
