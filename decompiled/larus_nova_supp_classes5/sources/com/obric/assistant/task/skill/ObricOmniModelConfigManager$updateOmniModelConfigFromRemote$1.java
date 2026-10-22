package com.obric.assistant.task.skill;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.network.api.bean.ObricOmniModelConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.task.skill.ObricOmniModelConfigManager$updateOmniModelConfigFromRemote$1", f = "ObricOmniModelConfigManager.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
public final class ObricOmniModelConfigManager$updateOmniModelConfigFromRemote$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricOmniModelConfigManager$updateOmniModelConfigFromRemote$1(Continuation<? super ObricOmniModelConfigManager$updateOmniModelConfigFromRemote$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricOmniModelConfigManager$updateOmniModelConfigFromRemote$1(r2);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L57
    L53:
        ObricOmniModelConfig r10 = (ObricOmniModelConfig) r9;     // Catch: Throwable -> L57
        if (r10 == null) goto L59;
        ObricOmniModelConfigManager.a(ObricOmniModelConfigManager.a, r10);     // Catch: Throwable -> L57
        ObricOmniModelConfigManager.f.set(r10);     // Catch: Throwable -> L57
        ObricOmniModelConfigManager.g.set(ObricOmniModelConfigManager.d(r10));     // Catch: Throwable -> L57
    L59:
        ObricOmniModelConfigManager.h.set(false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        ObricOmniModelConfigManager.a.getClass();
        if (ObricOmniModelConfigManager.f.get() != null) goto L44;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        String r12 = ((Keva) ObricOmniModelConfigManager.c.getValue()).getString("models_config", null);     // Catch: Throwable -> L24
        if (r12 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == true) goto L21;
        ObricOmniModelConfig r13 = (ObricOmniModelConfig) ((Gson) ObricOmniModelConfigManager.b.getValue()).fromJson(r12, ObricOmniModelConfig.class);     // Catch: Throwable -> L24
    L22:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L24
    L26:
        Throwable r5 = Result.exceptionOrNull-impl(r14);
        if (r5 == null) goto L30;
        FLogger.a.w("ObricOmniModelConfigHelper", "getOmniModelConfigFromKeva failed: " + r5.getMessage(), r5);
    L30:
        if (Result.isFailure-impl(r14) == false) goto L32;
        r14 = null;
    L32:
        ObricOmniModelConfig r15 = (ObricOmniModelConfig) r14;
        if (r15 == null) goto L44;
        AtomicReference r6 = ObricOmniModelConfigManager.f;
    L36:
        if (r6.compareAndSet(null, r15) == true) goto L37;
        if (r6.get() == null) goto L36;
        boolean r7 = false;
    L41:
        if (r7 == false) goto L44;
        ObricOmniModelConfigManager.g.set(ObricOmniModelConfigManager.d(r15));
        goto L44
    L37:
        r7 = true;
        goto L41
    L21:
        r13 = null;
        goto L22
    L15:
        if (r12.length() == 0) goto L18;
        r4 = false;
    L24:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        if (ObricOmniModelConfigManager.h.compareAndSet(false, true) == false) goto L46;
        ObricOmniModelConfigManager r16 = ObricOmniModelConfigManager.a;     // Catch: Throwable -> L57
        this.label = 1;     // Catch: Throwable -> L57
        r16.getClass();     // Catch: Throwable -> L57
        IObricNetworkService r17 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L57
        if (r17 == null) goto L50;
        r9 = r17.getOmniModelConfig(this);     // Catch: Throwable -> L57
    L51:
        if (r9 != r0) goto L53;
        return r0;
    L50:
        r9 = null;
        goto L51
    L46:
        return Unit.INSTANCE;
    L57:
        th = move-exception;
        ObricOmniModelConfigManager.h.set(false);
        throw th;
    }
}
