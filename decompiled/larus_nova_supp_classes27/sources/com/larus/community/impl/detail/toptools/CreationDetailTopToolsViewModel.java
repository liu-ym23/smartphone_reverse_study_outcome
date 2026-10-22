package com.larus.community.impl.detail.toptools;

import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.network.bean.BizResponse;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/detail/toptools/CreationRefImagePublicState;", "<init>", "()V", "_refImagePublicState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "refImagePublicState", "Lkotlinx/coroutines/flow/StateFlow;", "getRefImagePublicState", "()Lkotlinx/coroutines/flow/StateFlow;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "init", "", "updateRefImagePublicState", "isPublic", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailTopToolsViewModel extends ComponentViewModel<CreationRefImagePublicState> {
    private final z0<CreationRefImagePublicState> _refImagePublicState;
    private final i1<CreationRefImagePublicState> refImagePublicState;
    private UserCreation userCreation;

    /* JADX INFO: renamed from: com.larus.community.impl.detail.toptools.CreationDetailTopToolsViewModel$updateRefImagePublicState$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsViewModel", f = "CreationDetailTopToolsViewModel.kt", i = {0}, l = {36, 37}, m = "updateRefImagePublicState", n = {"isPublic"}, s = {"Z$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationDetailTopToolsViewModel this$0;

        public AnonymousClass1(CreationDetailTopToolsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateRefImagePublicState(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.toptools.CreationDetailTopToolsViewModel$updateRefImagePublicState$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/community/impl/api/CreationPublishResponse;", "Lcom/larus/community/impl/api/CreationRecommendApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsViewModel$updateRefImagePublicState$3", f = "CreationDetailTopToolsViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CreationRecommendApi, Continuation<? super BizResponse<com.larus.community.impl.api.i>>, Object> {
        final /* synthetic */ boolean $isPublic;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationDetailTopToolsViewModel this$0;

        public AnonymousClass3(CreationDetailTopToolsViewModel r1, boolean r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$isPublic = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$isPublic, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(CreationRecommendApi r1, Continuation<? super BizResponse<com.larus.community.impl.api.i>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CreationRecommendApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CreationRecommendApi r11 = (CreationRecommendApi) this.L$0;
            UserCreation r3 = CreationDetailTopToolsViewModel.access$getUserCreation$p(this.this$0);
            if (r3 == null) goto L11;
            String r4 = r3.a;
        L12:
            com.larus.community.impl.api.g r2 = new com.larus.community.impl.api.g(r4, new com.larus.community.impl.api.h(Boxing.boxBoolean(this.$isPublic), null, Boxing.boxBoolean(this.$isPublic), 2));
            this.label = 1;
            r10 = r11.publishCreation(r2, this);
            if (r10 != r0) goto L15;
            return r0;
        L11:
            r4 = null;
            goto L12
        }
    }

    public static /* synthetic */ CreationRefImagePublicState No(CreationRefImagePublicState r0, CreationRefImagePublicState r1) {
        return updateRefImagePublicState$lambda$1(r0, r1);
    }

    public static /* synthetic */ CreationRefImagePublicState Oo(CreationRefImagePublicState r0, CreationRefImagePublicState r1) {
        return init$lambda$0(r0, r1);
    }

    private static final CreationRefImagePublicState init$lambda$0(CreationRefImagePublicState r1, CreationRefImagePublicState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    private static final CreationRefImagePublicState updateRefImagePublicState$lambda$1(CreationRefImagePublicState r1, CreationRefImagePublicState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    public CreationDetailTopToolsViewModel() {
        StateFlowImpl r0 = j1.a(new CreationRefImagePublicState(false, 1, null));
        this._refImagePublicState = r0;
        this.refImagePublicState = r0;
    }

    public final i1<CreationRefImagePublicState> getRefImagePublicState() {
        return this.refImagePublicState;
    }

    public static final /* synthetic */ UserCreation access$getUserCreation$p(CreationDetailTopToolsViewModel r0) {
        return r0.userCreation;
    }

    public final void init(UserCreation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.userCreation = r3;
        CreationRefImagePublicState r0 = (CreationRefImagePublicState) getState();
        CreationPublishExtra r4 = r3.p;
        if (r4 == null) goto L7;
        boolean r5 = Intrinsics.areEqual(r4.b, Boolean.TRUE);
    L8:
        final CreationRefImagePublicState r6 = r0.copy(r5);
        setState(new v(r6));
        this._refImagePublicState.setValue(r6);
        return;
    L7:
        r5 = false;
        goto L8
    }

    public final Object updateRefImagePublicState(boolean r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = r0.Z$0;
        ResultKt.throwOnFailure(r8);
    L19:
        CreationRecommendApi.a r9 = CreationRecommendApi.a;
        AnonymousClass3 r4 = new AnonymousClass3(this, r6, null);
        r0.label = 2;
        r9.getClass();
        if (CreationRecommendApi.a.c(r4, r0) != r2) goto L23;
        return r2;
    L16:
        ResultKt.throwOnFailure(r8);
        final CreationRefImagePublicState r10 = ((CreationRefImagePublicState) getState()).copy(r6);
        setState(new w(r10));
        z0<CreationRefImagePublicState> r5 = this._refImagePublicState;
        r0.Z$0 = r6;
        r0.label = 1;
        if (r5.emit(r10, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
