package com.larus.dora.impl.device.settings.lab.env;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.g;
import com.larus.dora.impl.network.h;
import java.util.List;
import kj4.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveNetwork$fetchDeviceInfo$1", f = "DoraEnvObserveNetwork.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveNetwork$fetchDeviceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraEnvObserveNetwork$fetchDeviceInfo$1(Continuation<? super DoraEnvObserveNetwork$fetchDeviceInfo$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraEnvObserveNetwork$fetchDeviceInfo$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
        Object r14 = ((Result) r13).unbox-impl();
    L14:
        if (Result.isSuccess-impl(r14) == true) goto L43;
    L33:
        Object r15 = Result.constructor-impl(r14);
    L35:
        if (Result.exceptionOrNull-impl(r15) == null) goto L39;
        g49.d.d("DoraEnvObserveNetwork", "fetch data: failed");
        r15 = Unit.INSTANCE;
    L39:
        if (((Unit) r15) != null) goto L42;
    L40:
        g49.d.d("DoraEnvObserveNetwork", "fetch device info failed, due cur dora device is null");
    L42:
        return Unit.INSTANCE;
    L43:
        h r16 = (h) r14;     // Catch: Throwable -> L31
        g49.d.d("DoraEnvObserveNetwork", "fetch data: " + r16);     // Catch: Throwable -> L31
        IDoraPageConfig r0 = (IDoraPageConfig) DoraEnvObserveNetwork.a.getValue();     // Catch: Throwable -> L31
        if (r0 == null) goto L28;
        g r17 = r16.a();     // Catch: Throwable -> L31
        if (r17 == null) goto L27;
        a(r0, "dora_g_config_key_env_observe_auth_enable", r17.a());     // Catch: Throwable -> L31
        a(r0, "dora_g_config_key_env_observe_enable", r17.f());     // Catch: Throwable -> L31
        a(r0, "dora_g_config_key_env_observe_timer_enable", r17.e());     // Catch: Throwable -> L31
        String r3 = r17.d();     // Catch: Throwable -> L31
        if (r3 == null) goto L23;
        r0.e(EnvObserveViewModel.START_TIME_SET, r3);     // Catch: Throwable -> L31
    L23:
        String r4 = r17.c();     // Catch: Throwable -> L31
        if (r4 == null) goto L26;
        r0.e(EnvObserveViewModel.END_TIME_SET, r4);     // Catch: Throwable -> L31
    L26:
        a(r0, "dora_g_config_key_env_observe_light_enable", r17.b());     // Catch: Throwable -> L31
        a(r0, "dora_g_config_key_precapture_upload_enable", r17.g());     // Catch: Throwable -> L31
    L27:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        r15 = Result.constructor-impl(r18);     // Catch: Throwable -> L31
        goto L35
    L28:
        r18 = null;
    L31:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r14 = ResultKt.createFailure(th);
        goto L33
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        DoraDevice r110 = a.g().c();
        if (r110 == null) goto L40;
        DoraNetworkApi r6 = DoraNetworkApi.a;
        List<String> r7 = CollectionsKt.listOf(new String[]{"environmental_observation_switch", "environmental_observation_pause_timing_switch", "environmental_observation_pause_timing_start_time", "environmental_observation_pause_timing_end_time", "environmental_observation_agreement_status", "environmental_observation_lighting_switch", "quick_chat_switch"});
        this.label = 1;
        r14 = r6.x(r110, r7, this);
        if (r14 != r1) goto L14;
        return r1;
    }

    public static final void a(IDoraPageConfig r1, String r2, String r3) {
        if (r3 == null) goto L11;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L12;
        boolean r0 = true;
        if (r4.intValue() == 1) goto L9;
        r0 = false;
    L9:
        r1.a(r2, r0);
        return;
    L12:
        return;
    }
}
