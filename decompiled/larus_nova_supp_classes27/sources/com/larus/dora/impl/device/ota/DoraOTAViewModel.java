package com.larus.dora.impl.device.ota;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/device/ota/DoraOTAViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_autoOTASwitchStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "autoOTASwitchStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getAutoOTASwitchStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_updateAutoOTASwitchResultSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "updateAutoOTASwitchResultSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUpdateAutoOTASwitchResultSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadAutoOTASwitch", "", "updateAutoOTASwitch", "isAutoOTA", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOTAViewModel extends ViewModel {
    private final z0<Boolean> _autoOTASwitchStateFlow;
    private final MutableSharedFlow<Boolean> _updateAutoOTASwitchResultSharedFlow;
    private final i1<Boolean> autoOTASwitchStateFlow;
    private final d1<Boolean> updateAutoOTASwitchResultSharedFlow;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAViewModel$loadAutoOTASwitch$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAViewModel$loadAutoOTASwitch$1", f = "DoraOTAViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraOTAViewModel this$0;

        public AnonymousClass1(DoraOTAViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            com.larus.dora.impl.util.b0.a.getClass();
            boolean r5 = com.larus.dora.impl.util.b0.j().getBoolean("dora_auto_ota_switch_", true);
            z0 r2 = DoraOTAViewModel.access$get_autoOTASwitchStateFlow$p(this.this$0);
            Boolean r6 = Boxing.boxBoolean(r5);
            this.label = 1;
            if (r2.emit(r6, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAViewModel$updateAutoOTASwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAViewModel$updateAutoOTASwitch$1", f = "DoraOTAViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isAutoOTA;
        int label;
        final /* synthetic */ DoraOTAViewModel this$0;

        public C02491(boolean r1, DoraOTAViewModel r2, Continuation<? super C02491> r3) {
            this.$isAutoOTA = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02491(this.$isAutoOTA, this.this$0, r4);
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
            t39.c r7 = j49.b.a;
            boolean r8 = this.$isAutoOTA;
            DoraBuryPointManager.J(DoraBuryPointManager.a, "dm_auto_ota_switch", MapsKt.mapOf(new Pair[]{TuplesKt.to("auto_ota_switch", j49.b.l(r8)), TuplesKt.to("result", FlowDoraConnectReason.SUCCESS)}), false, 12);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            com.larus.dora.impl.util.b0 r9 = com.larus.dora.impl.util.b0.a;
            boolean r2 = this.$isAutoOTA;
            r9.getClass();
            com.larus.dora.impl.util.b0.j().storeBoolean("dora_auto_ota_switch_", r2);
            z0 r10 = DoraOTAViewModel.access$get_autoOTASwitchStateFlow$p(this.this$0);
            Boolean r3 = Boxing.boxBoolean(this.$isAutoOTA);
            this.label = 1;
            if (r10.emit(r3, this) != r0) goto L11;
            return r0;
        }
    }

    public DoraOTAViewModel() {
        StateFlowImpl r0 = j1.a(Boolean.TRUE);
        this._autoOTASwitchStateFlow = r0;
        this.autoOTASwitchStateFlow = r0;
        MutableSharedFlow<Boolean> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._updateAutoOTASwitchResultSharedFlow = r1;
        this.updateAutoOTASwitchResultSharedFlow = r1;
    }

    public final void loadAutoOTASwitch() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final i1<Boolean> getAutoOTASwitchStateFlow() {
        return this.autoOTASwitchStateFlow;
    }

    public final d1<Boolean> getUpdateAutoOTASwitchResultSharedFlow() {
        return this.updateAutoOTASwitchResultSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_autoOTASwitchStateFlow$p(DoraOTAViewModel r0) {
        return r0._autoOTASwitchStateFlow;
    }

    public final void updateAutoOTASwitch(boolean r8) {
        if (r8 != ((Boolean) this._autoOTASwitchStateFlow.getValue()).booleanValue()) goto L6;
        g49.d.b("DoraOTA", "updateAutoOTASwitch: switch state already " + r8);
        return;
    L6:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02491(r8, this, null), 2, null);
    }
}
