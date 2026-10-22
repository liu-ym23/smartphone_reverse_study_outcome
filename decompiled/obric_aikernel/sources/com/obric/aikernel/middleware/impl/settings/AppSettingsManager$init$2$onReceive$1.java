package com.obric.aikernel.middleware.impl.settings;

import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.middleware.impl.settings.AppSettingsManager$init$2$onReceive$1", f = "AppSettingsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppSettingsManager$init$2$onReceive$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;

    AppSettingsManager$init$2$onReceive$1(Continuation<? super AppSettingsManager$init$2$onReceive$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppSettingsManager$init$2$onReceive$1(r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AppSettingsManager$init$2$onReceive$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r10);
        e4.e.l(true);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        AIKLog.INSTANCE.e("InitSettingsTask", "screen on update settings failed", th);
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
