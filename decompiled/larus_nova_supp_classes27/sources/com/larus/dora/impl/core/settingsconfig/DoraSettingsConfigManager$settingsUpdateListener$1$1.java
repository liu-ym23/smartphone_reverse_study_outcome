package com.larus.dora.impl.core.settingsconfig;

import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.dora.impl.ota.g2.Trigger;
import com.larus.settings.value.e10;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import nu9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.settingsconfig.DoraSettingsConfigManager$settingsUpdateListener$1$1", f = "DoraSettingsConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSettingsConfigManager$settingsUpdateListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraSettingsConfigManager$settingsUpdateListener$1$1(Continuation<? super DoraSettingsConfigManager$settingsUpdateListener$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraSettingsConfigManager$settingsUpdateListener$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        DoraSettingsConfigManager r3 = DoraSettingsConfigManager.a;
        e10 r0 = e10.a;
        o r1 = e10.Q();
        r3.getClass();
        DoraSettingsConfigManager.e(r1, "settings_update");
        G2OtaFacade.INSTANCE.getClass();
        G2OtaFacade.K(Trigger.CONDITION_CHANGED);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
