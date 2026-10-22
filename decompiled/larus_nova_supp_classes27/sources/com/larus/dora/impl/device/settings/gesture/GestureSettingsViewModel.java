package com.larus.dora.impl.device.settings.gesture;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.util.t0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gestureSettingsStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsState;", "getGestureSettingsStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "gestureWakeupStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupSideType;", "getGestureWakeupStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_gestureWakeupSupportFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "gestureWakeupSupportFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getGestureWakeupSupportFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "linkCallback", "com/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel$linkCallback$1", "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel$linkCallback$1;", "onCleared", "", "load", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "GestureSettingsViewMode";
    private final z0<Boolean> _gestureWakeupSupportFlow;
    private final Flow<c0> gestureSettingsStateFlow;
    private final d1<com.larus.dora.impl.device.settings.gesture.wakeup.h> gestureWakeupStateFlow;
    private final i1<Boolean> gestureWakeupSupportFlow;
    private final b linkCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends t0 {
        public final /* synthetic */ GestureSettingsViewModel a;

        public b(GestureSettingsViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            if (r3 != 2) goto L6;
            GestureSettingsViewModel.access$load(this.a);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.GestureSettingsViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsViewModel$load$1", f = "GestureSettingsViewModel.kt", i = {}, l = {63, 64, 65, 68}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GestureSettingsViewModel this$0;

        public AnonymousClass1(GestureSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r7);
        L29:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r7);
        L22:
            GestureWakeupRepository r8 = GestureWakeupRepository.a;
            this.label = 3;
            if (r8.i(this) != r0) goto L29;
            return r0;
        L13:
            ResultKt.throwOnFailure(r7);
        L19:
            boolean r9 = ((Boolean) r7).booleanValue();
            z0 r2 = GestureSettingsViewModel.access$get_gestureWakeupSupportFlow$p(this.this$0);
            Boolean r10 = Boxing.boxBoolean(r9);
            this.label = 2;
            if (r2.emit(r10, this) != r0) goto L22;
            return r0;
        L14:
            ResultKt.throwOnFailure(r7);
            if (DoraAdapterExtKt.h(kj4.a.g()) == null) goto L25;
            sk4.e r11 = o0.a;
            this.label = 1;
            r7 = o0.g();
            if (r7 != r0) goto L19;
            return r0;
        L25:
            g49.d.b(GestureSettingsViewModel.TAG, "current device is null, should not reach here");
            z0 r12 = GestureSettingsViewModel.access$get_gestureWakeupSupportFlow$p(this.this$0);
            Boolean r3 = Boxing.boxBoolean(false);
            this.label = 4;
            if (r12.emit(r3, this) != r0) goto L29;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.GestureSettingsViewModel$load$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.GestureSettingsViewModel$load$2", f = "GestureSettingsViewModel.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
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
            GestureSettingsRepository r5 = GestureSettingsRepository.a;
            this.label = 1;
            if (r5.f(false, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public GestureSettingsViewModel() {
        GestureSettingsRepository.a.getClass();
        final StateFlowImpl r0 = GestureSettingsRepository.h;
        this.gestureSettingsStateFlow = new GestureSettingsViewModel$special$$inlined$map$1(r0);
        GestureWakeupRepository.a.getClass();
        this.gestureWakeupStateFlow = GestureWakeupRepository.i;
        StateFlowImpl r1 = j1.a(Boolean.TRUE);
        this._gestureWakeupSupportFlow = r1;
        this.gestureWakeupSupportFlow = r1;
        b r2 = new b(this);
        this.linkCallback = r2;
        kj4.a.g().registerDoraLinkCallback(r2);
        load();
    }

    private final void load() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        kj4.a.g().unregisterDoraLinkCallback(this.linkCallback);
    }

    public final Flow<c0> getGestureSettingsStateFlow() {
        return this.gestureSettingsStateFlow;
    }

    public final d1<com.larus.dora.impl.device.settings.gesture.wakeup.h> getGestureWakeupStateFlow() {
        return this.gestureWakeupStateFlow;
    }

    public final i1<Boolean> getGestureWakeupSupportFlow() {
        return this.gestureWakeupSupportFlow;
    }

    public static final /* synthetic */ z0 access$get_gestureWakeupSupportFlow$p(GestureSettingsViewModel r0) {
        return r0._gestureWakeupSupportFlow;
    }

    public static final /* synthetic */ void access$load(GestureSettingsViewModel r0) {
        r0.load();
    }
}
