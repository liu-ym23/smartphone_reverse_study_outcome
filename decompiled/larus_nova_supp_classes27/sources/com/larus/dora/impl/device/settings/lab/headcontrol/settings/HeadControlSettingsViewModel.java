package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.serviceimpl.HealthService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t39.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0010\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "optionState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlOptionState;", "getOptionState", "()Lkotlinx/coroutines/flow/StateFlow;", "_showBehaviorAwareBannerFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "showBehaviorAwareBannerFlow", "getShowBehaviorAwareBannerFlow", "isHealthCallbackRegistered", "healthCallback", "com/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel$healthCallback$1", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel$healthCallback$1;", "loadHeadGestureOptions", "", "refreshBehaviorAwareBannerState", "syncBehaviorAwareEnable", "isEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerHealthCallback", "unregisterHealthCallback", "isSupportBehaviorAware", "takeBehaviorAwareToggleOnce", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "HeadControlSettingsVM";
    private static final int TOGGLE_ON = 1;
    private static volatile Boolean cachedBehaviorAwareEnabled;
    private final z0<Boolean> _showBehaviorAwareBannerFlow;
    private final b healthCallback;
    private boolean isHealthCallbackRegistered;
    private final i1<w49.c> optionState;
    private final i1<Boolean> showBehaviorAwareBannerFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements q {
        public final /* synthetic */ HeadControlSettingsViewModel a;

        @Override // t39.q
        public final void b(int r1) {
        }

        public b(HeadControlSettingsViewModel r1) {
            this.a = r1;
        }

        @Override // t39.q
        public final void a(boolean r4) {
            a r0 = HeadControlSettingsViewModel.Companion;
            HeadControlSettingsViewModel.access$setCachedBehaviorAwareEnabled$cp(Boolean.valueOf(r4));
            if (HeadControlSettingsViewModel.access$isSupportBehaviorAware(this.a) == false) goto L6;
            if (r4 == true) goto L6;
            boolean r1 = true;
        L7:
            g49.d.d(HeadControlSettingsViewModel.TAG, "onBehaviorAwareToggleChanged: isEnabled=" + r4 + ", shouldShow=" + r1);
            HeadControlSettingsViewModel.access$get_showBehaviorAwareBannerFlow$p(this.a).setValue(Boolean.valueOf(r1));
            return;
        L6:
            r1 = false;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel$loadHeadGestureOptions$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel$loadHeadGestureOptions$1", f = "HeadControlSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            zj4.a r5 = zj4.a.a.a;
            w49.c r0 = null;
            if (r5 == null) goto L7;
            byte[] r6 = r5.h();
        L8:
            g49.d.d(HeadControlSettingsViewModel.TAG, "takeHeadGesture result=".concat(w49.b.a(r6)));
            if (r6 == null) goto L11;
            r0 = w49.b.b(r6);
        L11:
            if (r0 != null) goto L14;
            g49.d.e(HeadControlSettingsViewModel.TAG, "takeHeadGesture ignored, invalid config=".concat(w49.b.a(r6)));
            return Unit.INSTANCE;
        L14:
            StateFlowImpl r7 = w49.e.a;
            Intrinsics.checkNotNullParameter(r0, "optionState");
            w49.e.a.setValue(r0);
            return Unit.INSTANCE;
        L7:
            r6 = null;
            goto L8
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel$refreshBehaviorAwareBannerState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel$refreshBehaviorAwareBannerState$1", f = "HeadControlSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeadControlSettingsViewModel this$0;

        public C02861(HeadControlSettingsViewModel r1, Continuation<? super C02861> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02861(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r5);
            boolean r6 = HeadControlSettingsViewModel.access$isSupportBehaviorAware(this.this$0);
            boolean r0 = false;
            if (r6 == false) goto L7;
            boolean r1 = HeadControlSettingsViewModel.access$takeBehaviorAwareToggleOnce(this.this$0);
        L8:
            g49.d.d(HeadControlSettingsViewModel.TAG, "refreshBehaviorAwareBannerState: isSupported=" + r6 + ", isEnabled=" + r1);
            if (r6 == false) goto L11;
            Boolean r2 = Boxing.boxBoolean(r1);
        L12:
            HeadControlSettingsViewModel.access$setCachedBehaviorAwareEnabled$cp(r2);
            z0 r3 = HeadControlSettingsViewModel.access$get_showBehaviorAwareBannerFlow$p(this.this$0);
            if (r6 == false) goto L16;
            if (r1 == true) goto L16;
            r0 = true;
        L16:
            r3.setValue(Boxing.boxBoolean(r0));
            return Unit.INSTANCE;
        L11:
            r2 = null;
            goto L12
        L7:
            r1 = false;
            goto L8
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel$syncBehaviorAwareEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.settings.HeadControlSettingsViewModel", f = "HeadControlSettingsViewModel.kt", i = {0}, l = {87}, m = "syncBehaviorAwareEnable", n = {"isEnabled"}, s = {"Z$0"})
    public static final class C02871 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ HeadControlSettingsViewModel this$0;

        public C02871(HeadControlSettingsViewModel r1, Continuation<? super C02871> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.syncBehaviorAwareEnable(false, this);
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isSupportBehaviorAware() {
        sk4.e r0 = o0.a;
        return o0.c(FlowProtocolAbility.FEATURE_BEHAVIOR_AWARE);
    }

    private final void registerHealthCallback() {
        if (this.isHealthCallbackRegistered == false) goto L5;
        return;
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L23;
        HealthService r1 = r0.w();
        if (r1 == null) goto L25;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        r1.a(this.healthCallback);     // Catch: Throwable -> L12
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L15:
        if (Result.isSuccess-impl(r3) == false) goto L17;
        Unit r4 = (Unit) r3;
        this.isHealthCallbackRegistered = true;
    L17:
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L24;
        g49.d.c(TAG, "registerHealthCallback failed", r5);
        return;
    L24:
        return;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L25:
        return;
    }

    private final boolean takeBehaviorAwareToggleOnce() {
        zj4.a r0 = zj4.a.a.a;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.g());
    L6:
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.intValue() != 1) goto L11;
    L12:
        g49.d.d(TAG, "takeBehaviorAwareToggleOnce: toggle=" + r1 + ", isEnabled=" + r2);
        return r2;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final void unregisterHealthCallback() {
        if (this.isHealthCallbackRegistered == true) goto L5;
        return;
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L21;
        HealthService r1 = r0.w();
        if (r1 == null) goto L22;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        r1.c(this.healthCallback);     // Catch: Throwable -> L12
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L17;
        g49.d.c(TAG, "unregisterHealthCallback failed", r4);
    L17:
        this.isHealthCallbackRegistered = false;
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return;
    }

    public HeadControlSettingsViewModel() {
        this.optionState = w49.e.b;
        Boolean r0 = cachedBehaviorAwareEnabled;
        if (r0 == null) goto L8;
        boolean r1 = r0.booleanValue();
        if (isSupportBehaviorAware() == false) goto L8;
        if (r1 == true) goto L8;
        boolean r2 = true;
    L9:
        StateFlowImpl r3 = j1.a(Boolean.valueOf(r2));
        this._showBehaviorAwareBannerFlow = r3;
        this.showBehaviorAwareBannerFlow = kotlinx.coroutines.flow.e.b(r3);
        this.healthCallback = new b(this);
        registerHealthCallback();
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void loadHeadGestureOptions() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public void onCleared() {
        unregisterHealthCallback();
        super.onCleared();
    }

    public final void refreshBehaviorAwareBannerState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02861(this, null), 2, null);
    }

    public final i1<w49.c> getOptionState() {
        return this.optionState;
    }

    public final i1<Boolean> getShowBehaviorAwareBannerFlow() {
        return this.showBehaviorAwareBannerFlow;
    }

    public static final /* synthetic */ z0 access$get_showBehaviorAwareBannerFlow$p(HeadControlSettingsViewModel r0) {
        return r0._showBehaviorAwareBannerFlow;
    }

    public static final /* synthetic */ boolean access$isSupportBehaviorAware(HeadControlSettingsViewModel r0) {
        return r0.isSupportBehaviorAware();
    }

    public static final /* synthetic */ void access$setCachedBehaviorAwareEnabled$cp(Boolean r0) {
        cachedBehaviorAwareEnabled = r0;
    }

    public static final /* synthetic */ boolean access$takeBehaviorAwareToggleOnce(HeadControlSettingsViewModel r0) {
        return r0.takeBehaviorAwareToggleOnce();
    }

    public final Object syncBehaviorAwareEnable(boolean r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof C02871) == false) goto L7;
        C02871 r0 = (C02871) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = r0.Z$0;
        ResultKt.throwOnFailure(r7);
    L22:
        boolean r8 = ((Boolean) r7).booleanValue();
        g49.d.d(TAG, "syncBehaviorAwareEnable: isEnabled=" + r5 + ", isSuccess=" + r8);
        if (r8 == false) goto L26;
        cachedBehaviorAwareEnabled = Boxing.boxBoolean(r5);
        this._showBehaviorAwareBannerFlow.setValue(Boxing.boxBoolean(!r5));
    L26:
        return Boxing.boxBoolean(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L28;
        HealthService r10 = r9.w();
        if (r10 == null) goto L28;
        r0.Z$0 = r5;
        r0.label = 1;
        r7 = r10.j(r5, r0);
        if (r7 != r2) goto L22;
        return r2;
    L28:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C02871(this, r6);
        goto L8
    }
}
