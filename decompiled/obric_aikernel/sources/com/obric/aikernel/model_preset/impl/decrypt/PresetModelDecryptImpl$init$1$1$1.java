package com.obric.aikernel.model_preset.impl.decrypt;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.g;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_preset.impl.decrypt.PresetModelDecryptImpl$init$1$1$1", f = "PresetModelDecryptImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PresetModelDecryptImpl$init$1$1$1 extends SuspendLambda implements Function2<g<? extends String>, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    int label;

    PresetModelDecryptImpl$init$1$1$1(Continuation<? super PresetModelDecryptImpl$init$1$1$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        PresetModelDecryptImpl$init$1$1$1 r12 = new PresetModelDecryptImpl$init$1$1$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(g<? extends String> r10, Continuation<? super String> r11) {
        return m21invokeWpGqRn0(r10.k(), r11);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m21invokeWpGqRn0(Object r10, Continuation<? super String> r11) {
        return ((PresetModelDecryptImpl$init$1$1$1) create(g.b(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((g) this.L$0).k();
        AIKLog.INSTANCE.d("PresetModelDecryptImpl", "foreground: " + ((String) g.f(r11)));
        return g.f(r11);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
