package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.paging.PagingSource;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c2\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010 J\u0010\u0010\u000b\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010'J$\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u0010-R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_currentSelectDate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/time/LocalDate;", "currentSelectDate", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentSelectDate", "()Lkotlinx/coroutines/flow/StateFlow;", "setCurrentSelectDate", "(Lkotlinx/coroutines/flow/StateFlow;)V", "_audioMemoryDate", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "audioMemoryDate", "getAudioMemoryDate", "_totalCountsChangeEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "totalCountsChangeEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getTotalCountsChangeEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "notifyTotalCountsChange", "", "date", "getMemoryList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "refreshAudioMemoryDateList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localDate", "deleteDirectly", "", "rawAuditoryRecordingEntity", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "deleteMemoryEntity", "(Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMemoryItemTime", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "before", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;", "after", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;Lcom/obric/memorydata/memory/ui/data/MemoryItem$AudioEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AudioMemoryListViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "AudioMemoryListViewModel";
    private final kotlinx.coroutines.flow.ae<List<p>> _audioMemoryDate;
    private final kotlinx.coroutines.flow.ae<LocalDate> _currentSelectDate;
    private final kotlinx.coroutines.flow.ad<LocalDate> _totalCountsChangeEvent;
    private final kotlinx.coroutines.flow.ar<List<p>> audioMemoryDate;
    private kotlinx.coroutines.flow.ar<LocalDate> currentSelectDate;
    private final kotlinx.coroutines.flow.ai<LocalDate> totalCountsChangeEvent;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AudioMemoryListViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a.C0539a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10985a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10986a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10986a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, AudioMemoryListViewModel$getMemoryList$$inlined$map$1$2$1.class) == false) goto L7;
                AudioMemoryListViewModel$getMemoryList$$inlined$map$1$2$1 r0 = (AudioMemoryListViewModel$getMemoryList$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, AudioMemoryListViewModel$getMemoryList$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10986a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r11 = PagingDataTransforms.flatMap((PagingData) ZeusTransformUtils.preCheckCast(r6, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AudioMemoryListViewModel$getMemoryList$2$1(null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AudioMemoryListViewModel$getMemoryList$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3) {
            this.f10985a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a.C0539a>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10985a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AudioMemoryListViewModel f10988b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10989a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AudioMemoryListViewModel f10990b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, AudioMemoryListViewModel r4) {
                this.f10989a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f10990b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, AudioMemoryListViewModel$getMemoryList$$inlined$map$2$2$1.class) == false) goto L7;
                AudioMemoryListViewModel$getMemoryList$$inlined$map$2$2$1 r0 = (AudioMemoryListViewModel$getMemoryList$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, AudioMemoryListViewModel$getMemoryList$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r11 = this.f10989a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new AudioMemoryListViewModel$getMemoryList$3$1(this.f10990b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new AudioMemoryListViewModel$getMemoryList$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3, AudioMemoryListViewModel r4) {
            this.f10987a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f10988b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f10987a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f10988b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$deleteMemoryEntity$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$deleteMemoryEntity$2", f = "AudioMemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ fj $rawAuditoryRecordingEntity;
        int label;

        AnonymousClass2(fj r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$rawAuditoryRecordingEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$rawAuditoryRecordingEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r5);
        L11:
            e = move-exception;
            RunLog.INSTANCE.error(AudioMemoryListViewModel.TAG, "deleteAudioEntity failed ...", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            e.printStackTrace();
        L14:
            return Unit.INSTANCE;
        L6:
            if (ZeusProviderTransform.delete(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.recorder.provider/recorderentry/recorder_files").buildUpon().appendPath(this.$rawAuditoryRecordingEntity.getEntityId()).build(), null, null, "com.obric.memorydata.plugin") <= 0) goto L9;
            RunLog r6 = RunLog.INSTANCE;     // Catch: Exception -> L11
            String r4 = "deleteAudioEntity successfully from source, entityId: " + this.$rawAuditoryRecordingEntity.getEntityId();     // Catch: Exception -> L11
        L8:
            r6.debug(AudioMemoryListViewModel.TAG, r4);     // Catch: Exception -> L11
            goto L14
        L9:
            r6 = RunLog.INSTANCE;     // Catch: Exception -> L11
            r4 = "deleteAudioEntity failed from source, entityId: " + this.$rawAuditoryRecordingEntity.getEntityId();     // Catch: Exception -> L11
            goto L8
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$generateMemoryItemTime$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$TimeLine;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$generateMemoryItemTime$2", f = "AudioMemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11522 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super com.obric.memorydata.memory.ui.data.a.l>, Object> {
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.C0539a $after;
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.C0539a $before;
        int label;

        C11522(com.obric.memorydata.memory.ui.data.a.C0539a r3, com.obric.memorydata.memory.ui.data.a.C0539a r4, Continuation<? super C11522> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$after = r3;
            this.$before = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11522(this.$after, this.$before, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r4) {
            return ((C11522) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11522.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            if (com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getCreateTime(), this.$after.b().getCreateTime()) == false) goto L19;
            return null;
        L19:
            return new com.obric.memorydata.memory.ui.data.a.l(com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getCreateTime()), false);
        L13:
            if (this.$before != null) goto L15;
            return null;
        L15:
            return new com.obric.memorydata.memory.ui.data.a.l(com.obric.memorydata.memory.utils.f.f11537a.a(this.$before.b().getCreateTime()), true);
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$notifyTotalCountsChange$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$notifyTotalCountsChange$1", f = "AudioMemoryListViewModel.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ LocalDate $date;
        int label;
        final /* synthetic */ AudioMemoryListViewModel this$0;

        AnonymousClass1(AudioMemoryListViewModel r3, LocalDate r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$date = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$date, r5), Continuation.class, "com.obric.memorydata.plugin");
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
            kotlinx.coroutines.flow.ad r7 = AudioMemoryListViewModel.access$get_totalCountsChangeEvent$p(this.this$0);
            LocalDate r2 = this.$date;
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.emit(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$refreshAudioMemoryDateList$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.AudioMemoryListViewModel$refreshAudioMemoryDateList$2", f = "AudioMemoryListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11532 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioMemoryListViewModel this$0;

        C11532(AudioMemoryListViewModel r3, Continuation<? super C11532> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11532(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11532) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11532.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            AudioMemoryListViewModel.access$get_audioMemoryDate$p(this.this$0).b(com.obric.memorydata.memory.ui.list.a.f11171a.a());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public AudioMemoryListViewModel() {
        kotlinx.coroutines.flow.ae<LocalDate> r1 = kotlinx.coroutines.flow.at.a(null);
        this._currentSelectDate = r1;
        this.currentSelectDate = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ae<List<p>> r2 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this._audioMemoryDate = r2;
        this.audioMemoryDate = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.ad<LocalDate> r0 = kotlinx.coroutines.flow.ak.a(0, 0, null, 7, null);
        this._totalCountsChangeEvent = r0;
        this.totalCountsChangeEvent = (kotlinx.coroutines.flow.ai) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.flow.ai.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object access$generateMemoryItemTime(AudioMemoryListViewModel r2, com.obric.memorydata.memory.ui.data.a.C0539a r3, com.obric.memorydata.memory.ui.data.a.C0539a r4, Continuation r5) {
        return r2.generateMemoryItemTime(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_audioMemoryDate$p(AudioMemoryListViewModel r0) {
        return r0._audioMemoryDate;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_totalCountsChangeEvent$p(AudioMemoryListViewModel r0) {
        return r0._totalCountsChangeEvent;
    }

    private final Object generateMemoryItemTime(com.obric.memorydata.memory.ui.data.a.C0539a r4, com.obric.memorydata.memory.ui.data.a.C0539a r5, Continuation<? super com.obric.memorydata.memory.ui.data.a.l> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11522(r5, r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final PagingSource getMemoryList$lambda$0(LocalDate r5) {
        ZoneId r0 = ZoneId.systemDefault();
        long r1 = r5.atStartOfDay(r0).toInstant().toEpochMilli();
        long r3 = r5.plusDays(1).atStartOfDay(r0).toInstant().toEpochMilli();
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().getAllRecordings(r1, r3);
    }

    public static /* synthetic */ PagingSource lambda$5Uiv7fYJWdWhzuNSb6qnHVs4PfY(LocalDate r0) {
        return getMemoryList$lambda$0(r0);
    }

    public final boolean deleteDirectly(fj r9) {
        Intrinsics.checkNotNullParameter(r9, "rawAuditoryRecordingEntity");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteDirectly type: " + r9.getType() + " id: " + r9.getId(), false, 4, null);
        RunLog.INSTANCE.debug(TAG, "deleteMemoryEntity detail, | name: " + r9.c() + " | summary: " + r9.h() + "| createTime: " + r9.getCreateTime() + " | entityId: " + r9.getEntityId() + " | packageName: " + r9.getPackageName());
        fj r8 = (fj) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityId(r9.getEntityId(), r9.getPackageName())), fj.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "deleteMemoryEntity not found, skip delete! type: " + r9.getType() + " id: " + r9.getId(), null, 4, null);
        return false;
    L7:
        return r8.delete();
    }

    public final Object deleteMemoryEntity(fj r4, Continuation<? super Unit> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final kotlinx.coroutines.flow.ar<List<p>> getAudioMemoryDate() {
        return this.audioMemoryDate;
    }

    public final kotlinx.coroutines.flow.ar<LocalDate> getCurrentSelectDate() {
        return this.currentSelectDate;
    }

    public final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getMemoryList(final LocalDate r12) {
        Intrinsics.checkNotNullParameter(r12, "date");
        Object r3 = null;
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(new Pager(new PagingConfig(20, 20, false, 20, 0, 0, 52, null), r3, new $$Lambda$AudioMemoryListViewModel$5Uiv7fYJWdWhzuNSb6qnHVs4PfY(r12), 2, null).getFlow()), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    public final kotlinx.coroutines.flow.ai<LocalDate> getTotalCountsChangeEvent() {
        return this.totalCountsChangeEvent;
    }

    public final void notifyTotalCountsChange(LocalDate r9) {
        Intrinsics.checkNotNullParameter(r9, "date");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final Object refreshAudioMemoryDateList(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11532(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
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
