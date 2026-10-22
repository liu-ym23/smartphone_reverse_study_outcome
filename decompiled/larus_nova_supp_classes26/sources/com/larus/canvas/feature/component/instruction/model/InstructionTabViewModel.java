package com.larus.canvas.feature.component.instruction.model;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.canvas.feature.api.CanvasApi;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.network.FlowHttpConnection;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/InstructionTabViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/canvas/feature/component/instruction/model/InstructionTabState;", "<init>", "()V", "_keva", "Lcom/bytedance/keva/Keva;", "get_keva", "()Lcom/bytedance/keva/Keva;", "_keva$delegate", "Lkotlin/Lazy;", "_gson", "Lcom/google/gson/Gson;", "get_gson", "()Lcom/google/gson/Gson;", "_gson$delegate", "fetchInstructionTabList", "", "canvasType", "", "getKevaKey", "", "storeInstructionTabList", "instructionTabList", "", "Lcom/larus/canvas/service/bean/InstructionTab;", "fetchRemoteInstructionTabList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionTabViewModel extends ComponentViewModel<InstructionTabState> {
    public static final a Companion = null;
    private static final String INSTRUCTION_TAB_KEVA_REPO_NAME = "instruction_tab_keva_repo";
    private final Lazy _gson$delegate;
    private final Lazy _keva$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.instruction.model.InstructionTabViewModel$fetchRemoteInstructionTabList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.instruction.model.InstructionTabViewModel$fetchRemoteInstructionTabList$1", f = "InstructionTabViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $canvasType;
        int label;
        final /* synthetic */ InstructionTabViewModel this$0;

        public AnonymousClass1(InstructionTabViewModel r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$canvasType = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$canvasType, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            dm9.a.b r14 = (dm9.a) r13;
            if ((r14 instanceof dm9.a.b) == false) goto L23;
            gy8.b r15 = (gy8.b) r14.a.getData();
            if (r15 == null) goto L26;
            final List<InstructionTab> r16 = r15.a();
            if (r16 == null) goto L26;
            InstructionTabViewModel r2 = this.this$0;
            int r3 = this.$canvasType;
            if ((true ^ r16.isEmpty()) == false) goto L20;
        L21:
            InstructionTabViewModel.access$storeInstructionTabList(r2, r3, r16);
            InstructionTabViewModel.access$setState(r2, new e(r16));
            goto L26
        L20:
            if (((InstructionTabState) r2.getState()).getTabUiState() == TabUIState.STATE_LOADING) goto L21;
        L26:
            return Unit.INSTANCE;
        L23:
            if (((InstructionTabState) this.this$0.getState()).getTabUiState() == TabUIState.STATE_SHOW) goto L26;
            InstructionTabViewModel.access$setState(this.this$0, new f());
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CanvasApi.a r17 = CanvasApi.a;
            InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1 r5 = new InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1(this.$canvasType, null);
            this.label = 1;
            r17.getClass();
            FlowHttpConnection r18 = FlowHttpConnection.a;
            r13 = FlowHttpConnection.g("Social", CanvasApi.class, r5, true, null, null, null, this, 224);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ InstructionTabState No(InstructionTabState r0) {
        return fetchInstructionTabList$lambda$5(r0);
    }

    public static /* synthetic */ InstructionTabState Oo(List r0, InstructionTabState r1) {
        return fetchInstructionTabList$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Keva Po() {
        return _keva_delegate$lambda$0();
    }

    public static /* synthetic */ Gson Qo() {
        return _gson_delegate$lambda$1();
    }

    private static final Gson _gson_delegate$lambda$1() {
        return new Gson();
    }

    private static final Keva _keva_delegate$lambda$0() {
        return Keva.getRepo(INSTRUCTION_TAB_KEVA_REPO_NAME, 0);
    }

    private final Gson get_gson() {
        return (Gson) this._gson$delegate.getValue();
    }

    private final Keva get_keva() {
        return (Keva) this._keva$delegate.getValue();
    }

    public InstructionTabViewModel() {
        this._keva$delegate = LazyKt.lazy(new com.larus.canvas.feature.component.instruction.model.a());
        this._gson$delegate = LazyKt.lazy(new b());
    }

    private static final InstructionTabState fetchInstructionTabList$lambda$5(InstructionTabState r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$setState");
        return InstructionTabState.copy$default(r7, TabUIState.STATE_LOADING, null, null, 6, null);
    }

    private final void fetchRemoteInstructionTabList(int r7) {
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getIO(), null, new AnonymousClass1(this, r7, null), 2, null);
    }

    private final String getKevaKey(int r3) {
        return "canvas_type_" + r3;
    }

    public final void fetchInstructionTabList(int r7) {
        String r2 = getKevaKey(r7);
        String r3 = get_keva().getString(r2, null);
        if (o0.d(r3) == true) goto L15;
        setState(new d());
    L13:
        fetchRemoteInstructionTabList(r7);
        return;
    L15:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L6
        final List r5 = (List) get_gson().fromJson(r3, new InstructionTabViewModel$fetchInstructionTabList$1$localTabList$1().getType());     // Catch: Throwable -> L6
        setState(new c(r5));     // Catch: Throwable -> L6
        FLogger.a.i("ComponentViewModel", "[getInstructionTabList] success, key = " + r2);     // Catch: Throwable -> L6
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.exceptionOrNull-impl(r1);
        if (r6 == null) goto L11;
        FLogger.a.i("ComponentViewModel", "[getInstructionTabList] failure, error = " + r6.getMessage());
    L11:
        Result.box-impl(r1);
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final /* synthetic */ void access$setState(InstructionTabViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    private static final InstructionTabState fetchInstructionTabList$lambda$3$lambda$2(List r2, InstructionTabState r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$setState");
        TabUIState r0 = TabUIState.STATE_SHOW;
        TabDataSource r1 = TabDataSource.FROM_LOCAL;
        Intrinsics.checkNotNull(r2);
        return r3.copy(r0, r1, r2);
    }

    private final void storeInstructionTabList(int r4, List<InstructionTab> r5) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        String r6 = get_gson().toJson(r5);     // Catch: Throwable -> L5
        String r7 = getKevaKey(r4);     // Catch: Throwable -> L5
        get_keva().storeString(r7, r6);     // Catch: Throwable -> L5
        FLogger.a.i("ComponentViewModel", "[storeInstructionTabList] success, key = " + r7);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        FLogger.a.i("ComponentViewModel", "[storeInstructionTabList] failure, error = " + r9.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ void access$storeInstructionTabList(InstructionTabViewModel r0, int r1, List r2) {
        r0.storeInstructionTabList(r1, r2);
    }
}
