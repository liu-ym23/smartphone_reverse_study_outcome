package com.larus.dora.impl.core;

import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraLifeCycleTracker$connectEvent$1", f = "DoraLifeCycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraLifeCycleTracker$connectEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraLifeCycleTracker$connectEvent$1(Continuation<? super DoraLifeCycleTracker$connectEvent$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraLifeCycleTracker$connectEvent$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        IDoraPageConfig r7 = (IDoraPageConfig) f0.b.getValue();
        if (r7 == null) goto L7;
        boolean r8 = r7.d("dora_g_config_key_env_observe_enable", false);
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_observation_settings", MapsKt.mapOf(TuplesKt.to("dora_g_observation_switch", x0.b(r8))), false, 12);
    L7:
        com.larus.dora.impl.util.b0.a.getClass();
        boolean r9 = com.larus.dora.impl.util.b0.w();
        boolean r2 = com.larus.dora.impl.util.b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
        DoraBuryPointManager r3 = DoraBuryPointManager.a;
        DoraBuryPointManager.J(r3, "dora_natural_wakeup_settings", MapsKt.plus(x0.a(r9), MapsKt.mapOf(TuplesKt.to("dora_g_natural_setting_bgm_switch", x0.b(r2)))), false, 12);
        boolean r4 = true;
        if (com.larus.dora.impl.util.b0.j().getInt("dora_g_button_mode", 1) != 1) goto L11;
        r4 = false;
    L11:
        DoraBuryPointManager.J(r3, "dora_photo_permission_settings", MapsKt.mapOf(TuplesKt.to("dora_g_photo_permission_switch", x0.b(r4))), false, 12);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
