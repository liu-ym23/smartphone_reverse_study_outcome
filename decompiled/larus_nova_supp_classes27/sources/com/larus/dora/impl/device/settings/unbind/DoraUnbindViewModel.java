package com.larus.dora.impl.device.settings.unbind;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\"\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_unbindStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUnbindStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "unbind", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraUnbindViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "DoraUnbindViewModel";
    private final MutableSharedFlow<Pair<DoraUnbindState, DoraDevice>> _unbindStateFlow;
    private final d1<Pair<DoraUnbindState, DoraDevice>> unbindStateFlow;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.unbind.DoraUnbindViewModel$unbind$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.unbind.DoraUnbindViewModel$unbind$1", f = "DoraUnbindViewModel.kt", i = {1}, l = {28, 31, 33}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraUnbindViewModel this$0;

        public AnonymousClass1(DoraUnbindViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r7);
        L26:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r7);
        L22:
            DoraUnbindState r8 = (DoraUnbindState) r7;
            g49.d.d(DoraUnbindViewModel.TAG, "unbind finish, state: " + r8);
            MutableSharedFlow r4 = DoraUnbindViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r5 = new Pair(r8, r2);
            this.L$0 = null;
            this.label = 3;
            if (r4.emit(r5, this) != r0) goto L26;
            return r0;
        L11:
            ResultKt.throwOnFailure(r7);
        L18:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r7);
            r2 = kj4.a.g().c();
            if (r2 != null) goto L19;
            MutableSharedFlow r9 = DoraUnbindViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(DoraUnbindState.NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r9.emit(r3, this) != r0) goto L18;
            return r0;
        L19:
            DoraUnbindService r10 = DoraUnbindService.a;
            this.L$0 = r2;
            this.label = 2;
            r7 = r10.a(this);
            if (r7 != r0) goto L22;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public DoraUnbindViewModel() {
        MutableSharedFlow<Pair<DoraUnbindState, DoraDevice>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r0;
        this.unbindStateFlow = r0;
    }

    public final void unbind() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final d1<Pair<DoraUnbindState, DoraDevice>> getUnbindStateFlow() {
        return this.unbindStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(DoraUnbindViewModel r0) {
        return r0._unbindStateFlow;
    }
}
