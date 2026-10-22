package com.obric.assistant.privacy.activity;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.product.api.IObricProduct;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.privacy.activity.ObricLoginRedirectActivity$initFeatureConfig$1", f = "ObricLoginRedirectActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricLoginRedirectActivity$initFeatureConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricLoginRedirectActivity this$0;

    public ObricLoginRedirectActivity$initFeatureConfig$1(ObricLoginRedirectActivity r1, Continuation<? super ObricLoginRedirectActivity$initFeatureConfig$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricLoginRedirectActivity$initFeatureConfig$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        FLogger r6 = FLogger.a;     // Catch: Exception -> L10
        r6.i("TAG_ObricLoginRedirectActivity", this.this$0 + " Start initProductSdk() asynchronously");     // Catch: Exception -> L10
        IObricProduct.a.getClass();     // Catch: Exception -> L10
        IObricProduct r1 = IObricProduct.a.a();     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        r1.a();     // Catch: Exception -> L10
    L8:
        r6.i("TAG_ObricLoginRedirectActivity", this.this$0 + " initProductSdk() completed successfully");     // Catch: Exception -> L10
        this.this$0.d.complete(Unit.INSTANCE);     // Catch: Exception -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        FLogger.a.e("TAG_ObricLoginRedirectActivity", this.this$0 + " Error in initProductSdk()", e);
        this.this$0.d.completeExceptionally(e);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
