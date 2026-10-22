package com.larus.bmhome.instruction.helper;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper$onPermissionGranted$1", f = "AiBeautifyPickPhotoHelper.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
final class AiBeautifyPickPhotoHelper$onPermissionGranted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMultiMode;
    final /* synthetic */ int $maxSelectCount;
    int label;
    final /* synthetic */ AiBeautifyPickPhotoHelper this$0;

    public AiBeautifyPickPhotoHelper$onPermissionGranted$1(AiBeautifyPickPhotoHelper r1, boolean r2, int r3, Continuation<? super AiBeautifyPickPhotoHelper$onPermissionGranted$1> r4) {
        this.this$0 = r1;
        this.$isMultiMode = r2;
        this.$maxSelectCount = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AiBeautifyPickPhotoHelper$onPermissionGranted$1(this.this$0, this.$isMultiMode, this.$maxSelectCount, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MutableSharedFlow<g> r7 = this.this$0.d;
        g r2 = new g(this.$isMultiMode, this.$maxSelectCount);
        this.label = 1;
        if (r7.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
