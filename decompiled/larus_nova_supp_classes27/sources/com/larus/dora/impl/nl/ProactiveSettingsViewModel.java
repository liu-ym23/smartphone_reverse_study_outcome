package com.larus.dora.impl.nl;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.platform.service.AccountService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/nl/ProactiveSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/nl/ProactiveSettingsUiState;", "uiState", "getUiState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "onAction", "", "action", "Lcom/larus/dora/impl/nl/ProactiveSettingsAction;", "onGetProactiveSwitchState", "updateProactiveSwitchStateFromLocal", "saveProactiveSwitchStateToLocal", "state", "", "onProactiveSwitchChanged", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final ProactivePriorityState DEFAULT_PRIORITY_STATE = null;
    private static final String TAG = "ProactiveSettingsViewModel";
    private final z0<y0> _uiState;
    private final z0<y0> uiState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.ProactiveSettingsViewModel$onGetProactiveSwitchState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.ProactiveSettingsViewModel$onGetProactiveSwitchState$1", f = "ProactiveSettingsViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ProactiveSettingsViewModel this$0;

        public AnonymousClass1(ProactiveSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L23:
            if (Result.isSuccess-impl(r8) == false) goto L39;
            String r2 = null;
            if (Result.isFailure-impl(r8) == false) goto L27;
            r8 = null;
        L27:
            com.larus.dora.impl.network.d r9 = (com.larus.dora.impl.network.d) r8;
            if (r9 == null) goto L32;
            Map<String, Object> r3 = r9.a();
            if (r3 == null) goto L32;
            Object r4 = r3.get("priority_broadcast_switch");
        L34:
            if ((r4 instanceof String) == false) goto L36;
            r2 = (String) r4;
        L36:
            if (r2 != null) goto L38;
            r2 = ProactiveSettingsViewModel.access$getDEFAULT_PRIORITY_STATE$cp().getValue();
        L38:
            boolean r5 = Intrinsics.areEqual(r2, ProactivePriorityState.ENABLED.getValue());
            g49.d.d(ProactiveSettingsViewModel.TAG, "getProactiveSwitchState: getDeviceInfo success, switchState: " + r2 + ", response:" + r9);
            z0 r10 = ProactiveSettingsViewModel.access$get_uiState$p(this.this$0);
            ((y0) ProactiveSettingsViewModel.access$get_uiState$p(this.this$0).getValue()).getClass();
            r10.setValue(new y0(r5));
        L41:
            return Unit.INSTANCE;
        L32:
            r4 = null;
            goto L34
        L39:
            ProactiveSettingsViewModel.access$updateProactiveSwitchStateFromLocal(this.this$0);
            g49.d.b(ProactiveSettingsViewModel.TAG, "getProactiveSwitchState: getDeviceInfo failed: " + Result.exceptionOrNull-impl(r8));
            goto L41
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            DoraDevice r11 = DoraAdapterExtKt.h(kj4.a.g());
            if (r11 == null) goto L42;
            String r6 = r11.sn;
            if (r6 != null) goto L13;
        L16:
            boolean r12 = true;
        L17:
            if (r12 == true) goto L42;
            DoraNetworkApi r13 = DoraNetworkApi.a;
            List<String> r14 = CollectionsKt.listOf("priority_broadcast_switch");
            this.label = 1;
            r8 = r13.l(r11, r14, this);
            if (r8 != r0) goto L23;
            return r0;
        L13:
            if (r6.length() == 0) goto L16;
            r12 = false;
        L42:
            g49.d.e(ProactiveSettingsViewModel.TAG, "onProactiveSwitchChanged: device is null or sn is empty");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.ProactiveSettingsViewModel$onProactiveSwitchChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.ProactiveSettingsViewModel$onProactiveSwitchChanged$1", f = "ProactiveSettingsViewModel.kt", i = {0}, l = {87}, m = "invokeSuspend", n = {"switchState"}, s = {"L$0"})
    public static final class C03601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        Object L$0;
        int label;
        final /* synthetic */ ProactiveSettingsViewModel this$0;

        public C03601(boolean r1, ProactiveSettingsViewModel r2, Continuation<? super C03601> r3) {
            this.$state = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03601(this.$state, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r9);
            Object r10 = ((Result) r9).unbox-impl();
        L28:
            if (Result.isSuccess-impl(r10) == false) goto L30;
            g49.d.d(ProactiveSettingsViewModel.TAG, "onProactiveSwitchChanged: syncDeviceInfo success:" + r2);
            ProactiveSettingsViewModel.access$saveProactiveSwitchStateToLocal(this.this$0, this.$state);
            z0 r11 = ProactiveSettingsViewModel.access$get_uiState$p(this.this$0);
            y0 r3 = (y0) ProactiveSettingsViewModel.access$get_uiState$p(this.this$0).getValue();
            boolean r4 = this.$state;
            r3.getClass();
            r11.setValue(new y0(r4));
        L32:
            return Unit.INSTANCE;
        L30:
            t19.s r5 = t19.s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            t19.s.b(r6, 2131908080, false);
            g49.d.b(ProactiveSettingsViewModel.TAG, "onProactiveSwitchChanged: syncDeviceInfo failed: " + Result.exceptionOrNull-impl(r10));
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            DoraDevice r12 = DoraAdapterExtKt.h(kj4.a.g());
            if (r12 == null) goto L33;
            String r7 = r12.sn;
            if (r7 != null) goto L13;
        L16:
            boolean r8 = true;
        L17:
            if (r8 == true) goto L33;
            if (this.$state == false) goto L22;
            ProactivePriorityState r13 = ProactivePriorityState.ENABLED;
        L23:
            String r14 = r13.getValue();
            DoraNetworkApi r15 = DoraNetworkApi.a;
            JSONObject r16 = new JSONObject();
            r16.put("priority_broadcast_switch", r14);
            Unit r17 = Unit.INSTANCE;
            this.L$0 = r14;
            this.label = 1;
            r10 = r15.A(r12, r16, this);
            if (r10 != r0) goto L26;
            return r0;
        L26:
            r2 = r14;
            goto L28
        L22:
            r13 = ProactivePriorityState.DISABLED;
            goto L23
        L13:
            if (r7.length() == 0) goto L16;
            r8 = false;
        L33:
            g49.d.e(ProactiveSettingsViewModel.TAG, "onProactiveSwitchChanged: device is null or sn is empty");
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a();
        DEFAULT_PRIORITY_STATE = ProactivePriorityState.ENABLED;
    }

    private final void updateProactiveSwitchStateFromLocal() {
        String r0 = AccountService.a.getUserId();
        com.larus.dora.impl.util.b0.a.getClass();
        boolean r1 = com.larus.dora.impl.util.b0.v(r0);
        z0<y0> r2 = this._uiState;
        ((y0) r2.getValue()).getClass();
        r2.setValue(new y0(r1));
    }

    public ProactiveSettingsViewModel() {
        if (DEFAULT_PRIORITY_STATE != ProactivePriorityState.ENABLED) goto L5;
        boolean r1 = true;
    L6:
        StateFlowImpl r0 = j1.a(new y0(r1));
        this._uiState = r0;
        this.uiState = r0;
        onAction(o.b.a);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void onGetProactiveSwitchState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final /* synthetic */ ProactivePriorityState access$getDEFAULT_PRIORITY_STATE$cp() {
        return DEFAULT_PRIORITY_STATE;
    }

    public final z0<y0> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(ProactiveSettingsViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ void access$updateProactiveSwitchStateFromLocal(ProactiveSettingsViewModel r0) {
        r0.updateProactiveSwitchStateFromLocal();
    }

    private final void onProactiveSwitchChanged(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03601(r7, this, null), 3, null);
    }

    private final void saveProactiveSwitchStateToLocal(boolean r3) {
        String r0 = AccountService.a.getUserId();
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.L(r0, r3);
    }

    public final void onAction(o r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof o.b) == false) goto L6;
        onGetProactiveSwitchState();
        return;
    L6:
        if ((r2 instanceof o.a) == false) goto L10;
        onProactiveSwitchChanged(((o.a) r2).a);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$saveProactiveSwitchStateToLocal(ProactiveSettingsViewModel r0, boolean r1) {
        r0.saveProactiveSwitchStateToLocal(r1);
    }
}
