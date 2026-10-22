package com.larus.community.impl.detail.loading;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/community/impl/detail/loading/CreationDetailLoadingViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/detail/loading/CreationLoadingState;", "<init>", "()V", "creationId", "", "init", "", "retry", "requestCreationDetail", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailLoadingViewModel extends ComponentViewModel<CreationLoadingState> {
    private String creationId;

    /* JADX INFO: renamed from: com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$init$2", f = "CreationDetailLoadingViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationDetailLoadingViewModel this$0;

        public AnonymousClass2(CreationDetailLoadingViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CreationDetailLoadingViewModel r5 = this.this$0;
            this.label = 1;
            if (CreationDetailLoadingViewModel.access$requestCreationDetail(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$requestCreationDetail$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel", f = "CreationDetailLoadingViewModel.kt", i = {0}, l = {49}, m = "requestCreationDetail", n = {"previousState"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationDetailLoadingViewModel this$0;

        public AnonymousClass1(CreationDetailLoadingViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return CreationDetailLoadingViewModel.access$requestCreationDetail(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$retry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.loading.CreationDetailLoadingViewModel$retry$1", f = "CreationDetailLoadingViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationDetailLoadingViewModel this$0;

        public C01601(CreationDetailLoadingViewModel r1, Continuation<? super C01601> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01601(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CreationDetailLoadingViewModel r5 = this.this$0;
            this.label = 1;
            if (CreationDetailLoadingViewModel.access$requestCreationDetail(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ CreationLoadingState No(dm9.a r0, CreationLoadingState r1, CreationLoadingState r2) {
        return requestCreationDetail$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ CreationLoadingState Oo(CreationLoadingState r0, CreationLoadingState r1) {
        return requestCreationDetail$lambda$3(r0, r1);
    }

    public static /* synthetic */ CreationLoadingState Po(CreationLoadingState r0, CreationLoadingState r1) {
        return requestCreationDetail$lambda$1(r0, r1);
    }

    public static /* synthetic */ CreationLoadingState Qo(CreationLoadingState r0, CreationLoadingState r1) {
        return requestCreationDetail$lambda$5(r0, r1);
    }

    public static /* synthetic */ CreationLoadingState So(String r0, CreationLoadingState r1) {
        return init$lambda$0(r0, r1);
    }

    public static /* synthetic */ CreationLoadingState To(CreationLoadingState r0, CreationLoadingState r1) {
        return requestCreationDetail$lambda$4(r0, r1);
    }

    public final void retry() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C01601(this, null), 3, null);
    }

    public CreationDetailLoadingViewModel() {
    }

    public static final /* synthetic */ String access$getCreationId$p(CreationDetailLoadingViewModel r0) {
        return r0.creationId;
    }

    private final Object requestCreationDetail(Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        final CreationLoadingState r5 = (CreationLoadingState) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L18:
        final dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.b) == false) goto L34;
        dm9.a.b r6 = r10;
        if (r6.a.isSuccess() == false) goto L33;
        com.larus.community.impl.api.e r7 = (com.larus.community.impl.api.e) r6.a.getData();
        if (r7 == null) goto L29;
        List<UserCreation> r11 = r7.a();
        if (r11 == null) goto L29;
        if ((!r11.isEmpty()) != true) goto L29;
    L30:
        if (r4 == false) goto L32;
        setState(new g(r10, r5));
    L36:
        return Unit.INSTANCE;
    L32:
        setState(new h(r5));
    L29:
        r4 = false;
        goto L30
    L33:
        setState(new i(r5));
        goto L36
    L34:
        setState(new j(r5));
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        final CreationLoadingState r12 = (CreationLoadingState) getState();
        FLogger.a.i("ComponentViewModel", "requestCreationDetail previousState is " + r12.getCreationId() + " ; creationId is " + this.creationId);
        setState(new f(r12));
        CreationRecommendApi.a r13 = CreationRecommendApi.a;
        CreationDetailLoadingViewModel$requestCreationDetail$result$1 r14 = new CreationDetailLoadingViewModel$requestCreationDetail$result$1(r12, this, null);
        r0.L$0 = r12;
        r0.label = 1;
        r13.getClass();
        Object r15 = CreationRecommendApi.a.c(r14, r0);
        if (r15 != r2) goto L17;
        return r2;
    L17:
        r5 = r12;
        r9 = r15;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public final void init(final String r8) {
        Intrinsics.checkNotNullParameter(r8, "creationId");
        FLogger.a.i("ComponentViewModel", "init creationId is " + r8);
        this.creationId = r8;
        setState(new k(r8));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public static final /* synthetic */ Object access$requestCreationDetail(CreationDetailLoadingViewModel r0, Continuation r1) {
        return r0.requestCreationDetail(r1);
    }

    private static final CreationLoadingState init$lambda$0(String r2, CreationLoadingState r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$setState");
        return new CreationLoadingState(r2, null, 1);
    }

    private static final CreationLoadingState requestCreationDetail$lambda$1(CreationLoadingState r7, CreationLoadingState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        return CreationLoadingState.copy$default(r7, null, null, 1, 3, null);
    }

    private static final CreationLoadingState requestCreationDetail$lambda$3(CreationLoadingState r7, CreationLoadingState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        return CreationLoadingState.copy$default(r7, null, null, 4, 3, null);
    }

    private static final CreationLoadingState requestCreationDetail$lambda$4(CreationLoadingState r7, CreationLoadingState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        return CreationLoadingState.copy$default(r7, null, null, 3, 1, null);
    }

    private static final CreationLoadingState requestCreationDetail$lambda$5(CreationLoadingState r7, CreationLoadingState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        return CreationLoadingState.copy$default(r7, null, null, 3, 1, null);
    }

    private static final CreationLoadingState requestCreationDetail$lambda$2(dm9.a r6, CreationLoadingState r7, CreationLoadingState r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$setState");
        com.larus.community.impl.api.e r9 = (com.larus.community.impl.api.e) ((dm9.a.b) r6).a.getData();
        if (r9 == null) goto L7;
        List<UserCreation> r10 = r9.a();
        if (r10 == null) goto L7;
        UserCreation r11 = (UserCreation) CollectionsKt.firstOrNull(r10);
    L9:
        return CreationLoadingState.copy$default(r7, null, r11, 2, 1, null);
    L7:
        r11 = null;
        goto L9
    }
}
