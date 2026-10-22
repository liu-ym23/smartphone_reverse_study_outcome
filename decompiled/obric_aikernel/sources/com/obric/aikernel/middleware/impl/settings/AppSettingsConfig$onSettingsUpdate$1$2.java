package com.obric.aikernel.middleware.impl.settings;

import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.middleware.impl.settings.AppSettingsConfig$onSettingsUpdate$1$2", f = "AppSettingsConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppSettingsConfig$onSettingsUpdate$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Lazy<List<s7.f>> $targetObservers$delegate;
    int label;
    final /* synthetic */ AppSettingsConfig this$0;

    /* JADX WARN: Multi-variable type inference failed */
    AppSettingsConfig$onSettingsUpdate$1$2(AppSettingsConfig r10, String r11, Lazy<? extends List<? extends s7.f>> r12, Continuation<? super AppSettingsConfig$onSettingsUpdate$1$2> r13) {
        this.this$0 = r10;
        this.$key = r11;
        this.$targetObservers$delegate = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppSettingsConfig$onSettingsUpdate$1$2(this.this$0, this.$key, this.$targetObservers$delegate, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AppSettingsConfig$onSettingsUpdate$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        AppSettingsConfig r11 = this.this$0;
        List r12 = AppSettingsConfig.d(this.$targetObservers$delegate);
        String r13 = this.$key;
        Intrinsics.checkNotNullExpressionValue(r13, "key");
        AppSettingsConfig.c(r11, r12, r13);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
