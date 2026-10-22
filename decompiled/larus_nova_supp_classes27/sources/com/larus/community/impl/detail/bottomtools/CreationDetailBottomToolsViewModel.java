package com.larus.community.impl.detail.bottomtools;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.platform.api.creation.CreationCommunityInfo;
import com.larus.platform.api.creation.CreationLikeInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "<init>", "()V", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "init", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "forceFetchCount", "", "isFromAnchor", "handleLikeAction", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailBottomToolsViewModel extends ComponentViewModel<CreationLikeState> {
    private final z0<CreationLikeState> _currentStateFlow;
    private final i1<CreationLikeState> stateFlow;

    /* JADX INFO: renamed from: com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewModel$handleLikeAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewModel", f = "CreationDetailBottomToolsViewModel.kt", i = {0}, l = {86, 88}, m = "handleLikeAction", n = {"previousState"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationDetailBottomToolsViewModel this$0;

        public AnonymousClass1(CreationDetailBottomToolsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleLikeAction(this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewModel$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.bottomtools.CreationDetailBottomToolsViewModel$init$2", f = "CreationDetailBottomToolsViewModel.kt", i = {}, l = {41, 65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFromAnchor;
        final /* synthetic */ UserCreation $userCreation;
        int label;
        final /* synthetic */ CreationDetailBottomToolsViewModel this$0;

        public AnonymousClass2(CreationDetailBottomToolsViewModel r1, UserCreation r2, boolean r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$userCreation = r2;
            this.$isFromAnchor = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$userCreation, this.$isFromAnchor, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r4 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r15);
        L65:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r15);
        L13:
            dm9.a.b r16 = (dm9.a) r15;
            if ((r16 instanceof dm9.a.b) == false) goto L65;
            dm9.a.b r17 = r16;
            if (r17.a.isSuccess() == false) goto L65;
            CreationLikeState r5 = (CreationLikeState) this.this$0.getState();
            com.larus.community.impl.api.e r18 = (com.larus.community.impl.api.e) r17.a.getData();
            if (r18 == null) goto L38;
            List<UserCreation> r110 = r18.a();
            if (r110 == null) goto L38;
            UserCreation r111 = (UserCreation) CollectionsKt.firstOrNull(r110);
            if (r111 == null) goto L38;
            UserCreation r2 = r5.getCreation();
            if (r2 == null) goto L26;
            UserCreationTrackParams r3 = r2.n;
        L27:
            r111.n = r3;
            UserCreation r6 = r5.getCreation();
            if (r6 == null) goto L30;
            String r7 = r6.i;
        L32:
            if (o0.d(r7) == false) goto L37;
            UserCreation r8 = r5.getCreation();
            if (r8 == null) goto L36;
            r4 = r8.i;
        L36:
            r111.i = r4;
        L37:
            UserCreation r10 = r111;
        L40:
            if (r10 == null) goto L51;
            CreationCommunityInfo r9 = r10.k;
            if (r9 == null) goto L51;
            CreationLikeInfo r11 = r9.a;
            if (r11 == null) goto L51;
            Integer r12 = r11.b;
            if (r12 == null) goto L51;
            if (r12.intValue() != 1) goto L51;
            boolean r13 = true;
        L52:
            if (r10 == null) goto L60;
            CreationCommunityInfo r14 = r10.k;
            if (r14 == null) goto L60;
            CreationLikeInfo r20 = r14.a;
            if (r20 == null) goto L60;
            Long r21 = r20.a;
            if (r21 == null) goto L60;
            long r22 = r21.longValue();
        L61:
            final CreationLikeState r112 = CreationLikeState.copy$default(r5, null, r13, r22, r10, Boxing.boxBoolean(false), 1, null);
            CreationDetailBottomToolsViewModel.access$setState(this.this$0, new v(r112));
            z0 r23 = CreationDetailBottomToolsViewModel.access$get_currentStateFlow$p(this.this$0);
            this.label = 2;
            if (r23.emit(r112, this) != r0) goto L65;
            return r0;
        L60:
            r22 = 0;
        L51:
            r13 = false;
            goto L52
        L30:
            r7 = null;
            goto L32
        L26:
            r3 = null;
        L38:
            r10 = null;
            goto L40
        L10:
            ResultKt.throwOnFailure(r15);
            CreationRecommendApi.a r113 = CreationRecommendApi.a;
            CreationDetailBottomToolsViewModel$init$2$result$1 r24 = new CreationDetailBottomToolsViewModel$init$2$result$1(this.$userCreation, this.$isFromAnchor, null);
            this.label = 1;
            r113.getClass();
            r15 = CreationRecommendApi.a.c(r24, this);
            if (r15 != r0) goto L13;
            return r0;
        }
    }

    public static /* synthetic */ CreationLikeState No(CreationLikeState r0, CreationLikeState r1) {
        return handleLikeAction$lambda$1(r0, r1);
    }

    public static /* synthetic */ CreationLikeState Oo(CreationLikeState r0, CreationLikeState r1) {
        return init$lambda$0(r0, r1);
    }

    private static final CreationLikeState handleLikeAction$lambda$1(CreationLikeState r1, CreationLikeState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    private static final CreationLikeState init$lambda$0(CreationLikeState r1, CreationLikeState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    public CreationDetailBottomToolsViewModel() {
        StateFlowImpl r0 = j1.a(new CreationLikeState(null, false, 0, null, null, 31, null));
        this._currentStateFlow = r0;
        this.stateFlow = r0;
    }

    public final i1<CreationLikeState> getStateFlow() {
        return this.stateFlow;
    }

    public static final /* synthetic */ z0 access$get_currentStateFlow$p(CreationDetailBottomToolsViewModel r0) {
        return r0._currentStateFlow;
    }

    public final Object handleLikeAction(Continuation<? super Unit> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L26:
        dm9.a.b r17 = (dm9.a) r16;
        if ((r17 instanceof dm9.a.b) == false) goto L32;
        dm9.a.b r18 = r17;
        if (r18.a.isSuccess() == false) goto L31;
        FLogger.a.i("ComponentViewModel", "success in like action");
    L34:
        return Unit.INSTANCE;
    L31:
        FLogger.a.e("ComponentViewModel", "success in like fail,response:" + r18.a);
        goto L34
    L32:
        FLogger.a.e("ComponentViewModel", "success in like fail,result is " + r17);
        goto L34
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        CreationLikeState r4 = (CreationLikeState) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L23:
        CreationRecommendApi.a r110 = CreationRecommendApi.a;
        CreationDetailBottomToolsViewModel$handleLikeAction$result$1 r5 = new CreationDetailBottomToolsViewModel$handleLikeAction$result$1(r4, null);
        r0.L$0 = null;
        r0.label = 2;
        r110.getClass();
        r16 = CreationRecommendApi.a.c(r5, r0);
        if (r16 != r2) goto L26;
        return r2;
    L16:
        ResultKt.throwOnFailure(r16);
        r4 = (CreationLikeState) getState();
        if (r4.getLiked() == true) goto L19;
        final CreationLikeState r111 = CreationLikeState.copy$default(r4, null, true, r4.getLikeCount() + 1, null, Boxing.boxBoolean(true), 9, null);
    L20:
        setState(new u(r111));
        z0<CreationLikeState> r6 = this._currentStateFlow;
        r0.L$0 = r4;
        r0.label = 1;
        if (r6.emit(r111, r0) != r2) goto L23;
        return r2;
    L19:
        r111 = CreationLikeState.copy$default(r4, null, false, r4.getLikeCount() - 1, null, Boxing.boxBoolean(true), 9, null);
    L7:
        r0 = new AnonymousClass1(this, r15);
        goto L8
    }

    public static final /* synthetic */ void access$setState(CreationDetailBottomToolsViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public final void init(UserCreation r10, boolean r11, boolean r12) {
        CreationLikeState r1 = (CreationLikeState) getState();
        if (r10 == null) goto L7;
        String r2 = r10.a;
        if (r2 == null) goto L7;
    L8:
        boolean r3 = false;
        if (r10 == null) goto L20;
        CreationCommunityInfo r4 = r10.k;
        if (r4 == null) goto L20;
        CreationLikeInfo r5 = r4.a;
        if (r5 == null) goto L20;
        Integer r6 = r5.b;
        if (r6 == null) goto L20;
        if (r6.intValue() != 1) goto L20;
        r3 = true;
    L20:
        if (r10 == null) goto L28;
        CreationCommunityInfo r7 = r10.k;
        if (r7 == null) goto L28;
        CreationLikeInfo r8 = r7.a;
        if (r8 == null) goto L28;
        Long r9 = r8.a;
        if (r9 == null) goto L28;
        long r13 = r9.longValue();
    L29:
        final CreationLikeState r14 = r1.copy(r2, r3, r13, r10, Boolean.FALSE);
        setState(new t(r14));
        this._currentStateFlow.setValue(r14);
        if (r11 == false) goto L33;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, r10, r12, null), 3, null);
        return;
    L33:
        return;
    L28:
        r13 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public static /* synthetic */ void init$default(CreationDetailBottomToolsViewModel r1, UserCreation r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        r1.init(r2, r3, r4);
    }
}
