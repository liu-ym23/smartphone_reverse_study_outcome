package com.larus.canvas.feature.component.logic.loading;

import com.larus.ui.arch.vm.ComponentViewModel;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressState;", "<init>", "()V", "localIdMockMap", "Ljava/util/HashMap;", "", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressMocker;", "Lkotlin/collections/HashMap;", "createProgressMocker", "", "localId", "startProgress", "startDelay", "", "cancelProgress", "onReceiveTaskId", "taskId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasProgressViewModel extends ComponentViewModel<CanvasProgressState> {
    private final HashMap<String, a> localIdMockMap;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel$cancelProgress$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel$cancelProgress$1", f = "CanvasProgressViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ a $progressMocker;
        int label;

        public AnonymousClass1(a r1, Continuation<? super AnonymousClass1> r2) {
            this.$progressMocker = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$progressMocker, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            a r7 = this.$progressMocker;
            Job r2 = r7.g;
            if (r2 == null) goto L14;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
        L14:
            r7.g = null;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(3000, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel$startProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel$startProgress$1", f = "CanvasProgressViewModel.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $localId;
        final /* synthetic */ com.larus.canvas.feature.component.logic.loading.a $progressMocker;
        int label;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel$startProgress$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ String a;

            public a(String r1) {
                this.a = r1;
            }

            public final Object emit(Object r8, Continuation r9) {
                int r10 = ((Number) r8).intValue();
                ConcurrentHashMap<String, Float> r11 = com.larus.canvas.service.b.a;
                String r12 = this.a;
                float r13 = r10;
                Intrinsics.checkNotNullParameter(r12, "localId");
                long r0 = System.currentTimeMillis();
                if ((r0 - com.larus.canvas.service.b.c) <= 300000) goto L5;
                com.larus.canvas.service.b.a.clear();
                com.larus.canvas.service.b.b.clear();
            L5:
                com.larus.canvas.service.b.a.put(r12, Float.valueOf(r13));
                com.larus.canvas.service.b.c = r0;
                return Unit.INSTANCE;
            }
        }

        public C02651(com.larus.canvas.feature.component.logic.loading.a r1, String r2, Continuation<? super C02651> r3) {
            this.$progressMocker = r1;
            this.$localId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02651(this.$progressMocker, this.$localId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            b1 r6 = this.$progressMocker.f;
            a r2 = new a(this.$localId);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ CanvasProgressState No(String r0, a r1, CanvasProgressState r2) {
        return createProgressMocker$lambda$0(r0, r1, r2);
    }

    public CanvasProgressViewModel() {
        this.localIdMockMap = new HashMap();
    }

    public final void cancelProgress(String r7) {
        Intrinsics.checkNotNullParameter(r7, "localId");
        a r8 = this.localIdMockMap.get(r7);
        if (r8 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass1(r8, null), 3, null);
    }

    public final void createProgressMocker(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "localId");
        final a r0 = new a(getViewModelScope());
        setState(new b(r3, r0));
        this.localIdMockMap.put(r3, r0);
    }

    public final void onReceiveTaskId(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "localId");
        ConcurrentHashMap<String, Float> r2 = com.larus.canvas.service.b.a;
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "localId");
        com.larus.canvas.service.b.b.put(r4, r5);
    }

    public final void startProgress(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "localId");
        a r0 = this.localIdMockMap.get(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        Job r1 = r0.g;
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.isActive() != true) goto L10;
    L12:
        if (r2 == true) goto L15;
        r0.g = BuildersKt.launch$default(r0.a, Dispatchers.getIO(), null, new CanvasProgressMocker$startProgress$1(r11, r0, null), 2, null);
    L15:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02651(r0, r10, null), 3, null);
        return;
    L10:
        r2 = false;
        goto L12
    }

    private static final CanvasProgressState createProgressMocker$lambda$0(String r1, a r2, CanvasProgressState r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$setState");
        return r3.copy(MapsKt.plus(r3.flowMap, TuplesKt.to(r1, r2.f)));
    }

    public static /* synthetic */ void startProgress$default(CanvasProgressViewModel r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.startProgress(r1, r2);
    }
}
