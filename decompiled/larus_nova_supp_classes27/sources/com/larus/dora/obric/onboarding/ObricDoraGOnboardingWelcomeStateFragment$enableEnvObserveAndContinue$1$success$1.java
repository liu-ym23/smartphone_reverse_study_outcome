package com.larus.dora.obric.onboarding;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.o.api.IDoraODiaryService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {}, l = {922}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $mac;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1(String r1, ObricDoraGOnboardingWelcomeStateFragment r2, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1> r3) {
        this.$mac = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingWelcomeStateFragment$enableEnvObserveAndContinue$1$success$1(this.$mac, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L22:
        ObricDoraGOnboardingWelcomeStateFragment r2 = this.this$0;
        String r3 = this.$mac;
        if (Result.isSuccess-impl(r11) == true) goto L47;
    L41:
        Object r12 = Result.constructor-impl(r11);
    L42:
        Throwable r5 = Result.exceptionOrNull-impl(r12);
        if (r5 == null) goto L52;
        g49.d.c("ObricDoraGOnboardingWelcomeStateFragment", "enableEnvObserveAndContinue request failed", r5);
        return Boxing.boxBoolean(false);
    L52:
        return r12;
    L47:
        com.larus.dora.impl.network.i r13 = (com.larus.dora.impl.network.i) r11;     // Catch: Throwable -> L39
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "enableEnvObserveAndContinue response, code=" + r13.b() + ", msg=" + r13.c());     // Catch: Throwable -> L39
        Long r14 = r13.b();     // Catch: Throwable -> L39
        if (r14 != null) goto L28;
    L36:
        r4 = false;
    L37:
        r12 = Result.constructor-impl(Boxing.boxBoolean(r4));     // Catch: Throwable -> L39
        goto L42
    L28:
        if (r14.longValue() != 0) goto L36;
        IDoraPageConfig r15 = (IDoraPageConfig) r2.h1.getValue();     // Catch: Throwable -> L39
        if (r15 == null) goto L32;
        r15.a("dora_g_config_key_env_observe_enable", true);     // Catch: Throwable -> L39
        r15.a("dora_g_config_key_env_observe_auth_enable", true);     // Catch: Throwable -> L39
    L32:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_observation_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_observation_switch", "on")), false, 12);     // Catch: Throwable -> L39
        IDoraODiaryService r16 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);     // Catch: Throwable -> L39
        if (r16 == null) goto L35;
        r16.a(r3);     // Catch: Throwable -> L39
    L35:
        o49.b.b.a();     // Catch: Throwable -> L39
        EnvObserveChangeReason r17 = EnvObserveChangeReason.SWITCH_CHANGE;     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r17, "reason");     // Catch: Throwable -> L39
        DoraEnvObserveManager.a.getClass();     // Catch: Throwable -> L39
        DoraEnvObserveManager.h(r17, 181);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = ResultKt.createFailure(th);
        goto L41
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        List r18 = kj4.a.g().getDoraBindList();
        String r7 = this.$mac;
        Iterator r110 = r18.iterator();
    L10:
        if (r110.hasNext() == false) goto L14;
        Object r8 = r110.next();
        if (Intrinsics.areEqual(((DoraDevice) r8).mac, r7) == false) goto L10;
    L15:
        DoraDevice r9 = (DoraDevice) r8;
        if (r9 != null) goto L19;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "enableEnvObserveAndContinue failed, device is null");
        return Boxing.boxBoolean(false);
    L19:
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "enableEnvObserveAndContinue request, deviceFound=true, productId=" + r9.productId);
        DoraNetworkApi r111 = DoraNetworkApi.a;
        List<? extends Pair<String, ? extends Object>> r20 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("environmental_observation_agreement_status", "1"), TuplesKt.to("environmental_observation_switch", "1")});
        this.label = 1;
        r11 = r111.y(r9, r20, this);
        if (r11 != r0) goto L22;
        return r0;
    L14:
        r8 = null;
        goto L15
    }
}
