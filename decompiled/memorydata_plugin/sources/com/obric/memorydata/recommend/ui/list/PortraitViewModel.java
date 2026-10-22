package com.obric.memorydata.recommend.ui.list;

import android.icu.text.SimpleDateFormat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.obric.memory.model.MemoryData;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J$\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\u00020\u001b*\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_listRefreshFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "listRefreshFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getListRefreshFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "cachedData", "", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "getMemoryList", "tagType", "", "clearCache", "", "clearData", "generateMemoryItemTime", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$Category;", "before", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$PortraitEntity;", "after", "(Lcom/obric/memorydata/recommend/ui/list/MemoryItem$PortraitEntity;Lcom/obric/memorydata/recommend/ui/list/MemoryItem$PortraitEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformToMemoryItemEntity", "Lcom/bytedance/obric/memory/model/MemoryData;", "deleteMemoryEntity", "memoryData", "(Lcom/bytedance/obric/memory/model/MemoryData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeLocalData", "timestampToDate", "timestamp", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PortraitViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "PortraitViewModel";
    private final ad<Boolean> _listRefreshFlow;
    private final Set<Long> cachedData;
    private kotlinx.coroutines.flow.i<PagingData<f>> flow;
    private final ai<Boolean> listRefreshFlow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/PortraitViewModel$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements kotlinx.coroutines.flow.i<PagingData<f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f12675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemoryData f12676b;

        /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f12677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MemoryData f12678b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, MemoryData r4) {
                this.f12677a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f12678b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, PortraitViewModel$deleteMemoryEntity$$inlined$map$1$2$1.class) == false) goto L7;
                PortraitViewModel$deleteMemoryEntity$$inlined$map$1$2$1 r0 = (PortraitViewModel$deleteMemoryEntity$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r9, PortraitViewModel$deleteMemoryEntity$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r11 = this.f12677a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.filter((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new PortraitViewModel$deleteMemoryEntity$2$1(this.f12678b, null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new PortraitViewModel$deleteMemoryEntity$$inlined$map$1$2$1(this, r9);
                goto L8
            }
        }

        public b(kotlinx.coroutines.flow.i r3, MemoryData r4) {
            this.f12675a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f12676b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<f>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f12675a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f12676b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<PagingData<f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f12679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PortraitViewModel f12680b;

        /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f12681a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PortraitViewModel f12682b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, PortraitViewModel r4) {
                this.f12681a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f12682b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, PortraitViewModel$deleteMemoryEntity$$inlined$map$2$2$1.class) == false) goto L7;
                PortraitViewModel$deleteMemoryEntity$$inlined$map$2$2$1 r0 = (PortraitViewModel$deleteMemoryEntity$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, PortraitViewModel$deleteMemoryEntity$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r11 = this.f12681a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new PortraitViewModel$deleteMemoryEntity$3$1(this.f12682b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new PortraitViewModel$deleteMemoryEntity$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3, PortraitViewModel r4) {
            this.f12679a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f12680b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<f>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f12679a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f12680b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<PagingData<f.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f12683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PortraitViewModel f12684b;

        /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f12685a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PortraitViewModel f12686b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, PortraitViewModel r4) {
                this.f12685a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f12686b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r8, Continuation r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, PortraitViewModel$getMemoryList$lambda$4$$inlined$map$1$2$1.class) == false) goto L7;
                PortraitViewModel$getMemoryList$lambda$4$$inlined$map$1$2$1 r0 = (PortraitViewModel$getMemoryList$lambda$4$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r10, PortraitViewModel$getMemoryList$lambda$4$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r11);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r12 = this.f12685a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r7 = PagingDataTransforms.map(PagingDataTransforms.filter((PagingData) ZeusTransformUtils.preCheckCast(r8, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new PortraitViewModel$getMemoryList$2$1$1(this.f12686b, null), Function2.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new PortraitViewModel$getMemoryList$2$1$2(this.f12686b, null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r12.emit(r7, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new PortraitViewModel$getMemoryList$lambda$4$$inlined$map$1$2$1(this, r10);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3, PortraitViewModel r4) {
            this.f12683a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f12684b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<f.c>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f12683a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f12684b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$deleteMemoryEntity$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.PortraitViewModel", f = "PortraitViewModel.kt", i = {0, 0}, l = {112, 127}, m = "deleteMemoryEntity", n = {"this", "memoryData"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PortraitViewModel this$0;

        AnonymousClass1(PortraitViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.deleteMemoryEntity(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements kotlinx.coroutines.flow.i<PagingData<f>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f12687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PortraitViewModel f12688b;

        /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f12689a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PortraitViewModel f12690b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, PortraitViewModel r4) {
                this.f12689a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f12690b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, PortraitViewModel$getMemoryList$lambda$4$$inlined$map$2$2$1.class) == false) goto L7;
                PortraitViewModel$getMemoryList$lambda$4$$inlined$map$2$2$1 r0 = (PortraitViewModel$getMemoryList$lambda$4$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, PortraitViewModel$getMemoryList$lambda$4$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
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
                kotlinx.coroutines.flow.j r11 = this.f12689a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new PortraitViewModel$getMemoryList$2$2$1(this.f12690b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new PortraitViewModel$getMemoryList$lambda$4$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3, PortraitViewModel r4) {
            this.f12687a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f12688b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<f>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f12687a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f12688b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.PortraitViewModel$generateMemoryItemTime$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$Category;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.PortraitViewModel$generateMemoryItemTime$2", f = "PortraitViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super f.a>, Object> {
        final /* synthetic */ f.c $after;
        final /* synthetic */ f.c $before;
        int label;
        final /* synthetic */ PortraitViewModel this$0;

        AnonymousClass2(f.c r3, f.c r4, PortraitViewModel r5, Continuation<? super AnonymousClass2> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$before = r3;
            this.$after = r4;
            this.this$0 = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$before, this.$after, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super f.a> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super f.a> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r6);
            RunLog.INSTANCE.debug(PortraitViewModel.TAG, "insertSeparators before:" + this.$before + ", after:" + this.$after);
            if (this.$after == null) goto L15;
            f.c r7 = this.$before;
            if (r7 != null) goto L10;
            return new f.a(PortraitViewModel.access$timestampToDate(this.this$0, com.obric.memorydata.recommend.model.a.b(this.$after.a())));
        L10:
            if (com.obric.memorydata.utils.h.a(com.obric.memorydata.recommend.model.a.b(r7.a()), com.obric.memorydata.recommend.model.a.b(this.$after.a())) == false) goto L12;
            return null;
        L12:
            return new f.a(PortraitViewModel.access$timestampToDate(this.this$0, com.obric.memorydata.recommend.model.a.b(this.$after.a())));
        L15:
            return null;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public PortraitViewModel() {
        ad<Boolean> r0 = ak.a(0, 0, null, 6, null);
        this._listRefreshFlow = r0;
        this.listRefreshFlow = (ai) ZeusTransformUtils.preCheckCast(r0, ai.class, "com.obric.memorydata.plugin");
        this.cachedData = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object access$generateMemoryItemTime(PortraitViewModel r2, f.c r3, f.c r4, Continuation r5) {
        return r2.generateMemoryItemTime(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Set access$getCachedData$p(PortraitViewModel r0) {
        return r0.cachedData;
    }

    public static final /* synthetic */ String access$timestampToDate(PortraitViewModel r0, long r1) {
        return r0.timestampToDate(r1);
    }

    public static final /* synthetic */ f.c access$transformToMemoryItemEntity(PortraitViewModel r0, MemoryData r1) {
        return r0.transformToMemoryItemEntity(r1);
    }

    private final Object generateMemoryItemTime(f.c r5, f.c r6, Continuation<? super f.a> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, r6, this, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public static /* synthetic */ void lambda$dOL2pHybcJa51_0Em1GYOD4mSS4(MemoryData r0) {
        removeLocalData$lambda$8(r0);
    }

    private final void removeLocalData(final MemoryData r2) {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$PortraitViewModel$dOL2pHybcJa51_0Em1GYOD4mSS4(r2));
    }

    private static final void removeLocalData$lambda$8(MemoryData r2) {
        String r3 = com.obric.memorydata.recommend.b.a.a(r2.id, r2.category);
        EpisodicMemoryEntity r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r3);
        if (r4 == null) goto L6;
        r4.delete();
        return;
    }

    private final String timestampToDate(long r5) {
        Calendar r4 = Calendar.getInstance();
        r4.setTimeInMillis(r5);
        int r1 = r4.get(1);
        Calendar r2 = Calendar.getInstance();
        if (r1 == r2.get(1)) goto L7;
        SimpleDateFormat r6 = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        Date r0 = new Date(r5);
    L5:
        String r7 = r6.format(r0);
        Intrinsics.checkNotNullExpressionValue(r7, "format(...)");
        return r7;
    L7:
        int r3 = r2.get(6);
        if (r4.get(6) == r3) goto L10;
        r6 = new SimpleDateFormat("MM/dd", Locale.getDefault());
        r0 = new Date(r5);
        goto L5
    L10:
        return "今日";
    }

    private final f.c transformToMemoryItemEntity(MemoryData r2) {
        return new f.c(r2, false);
    }

    public final void clearCache() {
        this.cachedData.clear();
    }

    public final void clearData() {
        this.flow = null;
        clearCache();
    }

    public final Object deleteMemoryEntity(MemoryData r9, Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r11, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (MemoryData) ZeusTransformUtils.preCheckCast(r0.L$1, MemoryData.class, "com.obric.memorydata.plugin");
        PortraitViewModel this = (PortraitViewModel) ZeusTransformUtils.preCheckCast(r0.L$0, PortraitViewModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
        this.removeLocalData(r9);
        this.cachedData.remove(Boxing.boxLong(r9.id));
        kotlinx.coroutines.flow.i<PagingData<f>> r13 = this.flow;
        if (r13 == null) goto L24;
        kotlinx.coroutines.flow.i<PagingData<f>> r14 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(r13, r9), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    L25:
        this.flow = r14;
        ad<Boolean> r8 = this._listRefreshFlow;
        Boolean r15 = Boxing.boxBoolean(true);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r8.emit(r15, r0) != r2) goto L29;
        return r2;
    L24:
        r14 = null;
        goto L25
    L31:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r12);
        com.obric.memorydata.recommend.model.c r16 = com.obric.memorydata.recommend.model.c.f12535a;
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.label = 1;
        r12 = r16.a(r9, r0);
        if (r12 != r2) goto L20;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r11);
        goto L8
    }

    public final ai<Boolean> getListRefreshFlow() {
        return this.listRefreshFlow;
    }

    public final kotlinx.coroutines.flow.i<PagingData<f>> getMemoryList(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tagType");
        kotlinx.coroutines.flow.i<PagingData<f>> r0 = this.flow;
        if (r0 == null) goto L5;
        return r0;
    L5:
        PortraitViewModel r2 = (PortraitViewModel) ZeusTransformUtils.preCheckCast(this, PortraitViewModel.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i<PagingData<f>> r4 = CachedPagingDataKt.cachedIn((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d(com.obric.memorydata.recommend.model.c.f12535a.a(r3), r2), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r2), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(r2, ViewModel.class, "com.obric.memorydata.plugin")));
        r2.flow = r4;
        return r4;
    }
}
