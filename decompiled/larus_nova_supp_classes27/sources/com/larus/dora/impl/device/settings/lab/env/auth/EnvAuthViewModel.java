package com.larus.dora.impl.device.settings.lab.env.auth;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.i;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_envAuthStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthState;", "envAuthState", "Lkotlinx/coroutines/flow/StateFlow;", "getEnvAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "updatePrivateResult", "", "mac", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvAuthViewModel extends ViewModel {
    private z0<c> _envAuthStateFlow;
    private final Lazy doraPageConfig$delegate;
    private final i1<c> envAuthState;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.env.auth.EnvAuthViewModel$updatePrivateResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.auth.EnvAuthViewModel$updatePrivateResult$1", f = "EnvAuthViewModel.kt", i = {}, l = {35, 39, 55, 57, 60}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ EnvAuthViewModel this$0;

        public AnonymousClass1(EnvAuthViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$mac, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r7 = false;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            if (r1 == 4) goto L12;
            if (r1 != 5) goto L11;
            ResultKt.throwOnFailure(r14);
        L67:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L48
        L56:
            Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L48
        L60:
            EnvAuthViewModel r2 = this.this$0;
            if (Result.exceptionOrNull-impl(r15) == null) goto L67;
            z0 r16 = EnvAuthViewModel.access$get_envAuthStateFlow$p(r2);
            c.a r3 = new c.a(false);
            this.label = 5;
            if (r16.emit(r3, this) != r0) goto L67;
            return r0;
        L14:
            ResultKt.throwOnFailure(r14);
            Object r17 = ((Result) r14).unbox-impl();
        L38:
            EnvAuthViewModel r4 = this.this$0;
            if (Result.isSuccess-impl(r17) == false) goto L59;
            Long r18 = ((i) r17).a();     // Catch: Throwable -> L48
            if (r18 != null) goto L44;
        L53:
            z0 r110 = EnvAuthViewModel.access$get_envAuthStateFlow$p(r4);     // Catch: Throwable -> L48
            c.a r5 = new c.a(false);     // Catch: Throwable -> L48
            this.label = 4;     // Catch: Throwable -> L48
            if (r110.emit(r5, this) != r0) goto L56;
            return r0;
        L44:
            if (r18.longValue() != 0) goto L53;
            IDoraPageConfig r111 = EnvAuthViewModel.access$getDoraPageConfig(r4);     // Catch: Throwable -> L48
            if (r111 == null) goto L50;
            r111.a("dora_g_config_key_env_observe_enable", true);     // Catch: Throwable -> L48
            r111.a("dora_g_config_key_env_observe_auth_enable", true);     // Catch: Throwable -> L48
            DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_observation_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_observation_switch", "on")), false, 12);     // Catch: Throwable -> L48
            o49.b.b.a();     // Catch: Throwable -> L48
            EnvObserveChangeReason r112 = EnvObserveChangeReason.SWITCH_CHANGE;     // Catch: Throwable -> L48
            Intrinsics.checkNotNullParameter(r112, "reason");     // Catch: Throwable -> L48
            DoraEnvObserveManager.a.getClass();     // Catch: Throwable -> L48
            DoraEnvObserveManager.h(r112, 181);     // Catch: Throwable -> L48
        L50:
            z0 r113 = EnvAuthViewModel.access$get_envAuthStateFlow$p(r4);     // Catch: Throwable -> L48
            c.a r6 = new c.a(true);     // Catch: Throwable -> L48
            this.label = 3;     // Catch: Throwable -> L48
            if (r113.emit(r6, this) != r0) goto L56;
            return r0;
        L59:
            r15 = Result.constructor-impl(r17);
            goto L60
        L15:
            ResultKt.throwOnFailure(r14);
        L28:
            StringBuilder r114 = new StringBuilder("cur device is null, mac is empty: ");
            String r8 = this.$mac;
            if (r8 != null) goto L31;
        L32:
            r7 = true;
        L33:
            r114.append(r7);
            g49.d.d("DoraGFeedbackViewModel", r114.toString());
            return Unit.INSTANCE;
        L31:
            if (r8.length() != 0) goto L33;
        L16:
            ResultKt.throwOnFailure(r14);
            g49.d.d("DoraGFeedbackViewModel", "env auth update private and switch enable");
            List r115 = kj4.a.g().getDoraBindList();
            String r9 = this.$mac;
            Iterator r116 = r115.iterator();
        L18:
            if (r116.hasNext() == false) goto L22;
            Object r10 = r116.next();
            if (Intrinsics.areEqual(((DoraDevice) r10).mac, r9) == false) goto L18;
        L23:
            DoraDevice r11 = (DoraDevice) r10;
            if (r11 != null) goto L35;
            z0 r117 = EnvAuthViewModel.access$get_envAuthStateFlow$p(this.this$0);
            c.a r12 = new c.a(false);
            this.label = 1;
            if (r117.emit(r12, this) != r0) goto L28;
            return r0;
        L35:
            DoraNetworkApi r118 = DoraNetworkApi.a;
            List<? extends Pair<String, ? extends Object>> r13 = CollectionsKt.listOf(new Pair[]{new Pair("environmental_observation_agreement_status", "1"), new Pair("environmental_observation_switch", "1")});
            this.label = 2;
            r17 = r118.y(r11, r13, this);
            if (r17 != r0) goto L38;
            return r0;
        L22:
            r10 = null;
        L48:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r17 = ResultKt.createFailure(th);
            goto L59
        }
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    public EnvAuthViewModel() {
        StateFlowImpl r0 = j1.a(c.b.a);
        this._envAuthStateFlow = r0;
        this.envAuthState = r0;
        this.doraPageConfig$delegate = LazyKt.lazy(new d());
    }

    public final i1<c> getEnvAuthState() {
        return this.envAuthState;
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(EnvAuthViewModel r0) {
        return r0.getDoraPageConfig();
    }

    public static final /* synthetic */ z0 access$get_envAuthStateFlow$p(EnvAuthViewModel r0) {
        return r0._envAuthStateFlow;
    }

    public final void updatePrivateResult(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r7, null), 2, null);
    }
}
