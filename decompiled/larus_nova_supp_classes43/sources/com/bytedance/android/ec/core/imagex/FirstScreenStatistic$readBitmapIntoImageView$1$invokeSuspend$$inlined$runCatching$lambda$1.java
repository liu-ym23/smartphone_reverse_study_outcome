package com.bytedance.android.ec.core.imagex;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/imagex/FirstScreenStatistic$readBitmapIntoImageView$1$runResult$1$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$readBitmapIntoImageView$1$runResult$1$1", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $bitmap$inlined;
    int label;
    final /* synthetic */ FirstScreenStatistic$readBitmapIntoImageView$1 this$0;

    public FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1(Continuation r1, FirstScreenStatistic$readBitmapIntoImageView$1 r10, Ref.ObjectRef r11) {
        this.this$0 = r10;
        this.$bitmap$inlined = r11;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new FirstScreenStatistic$readBitmapIntoImageView$1$invokeSuspend$$inlined$runCatching$lambda$1(r11, this.this$0, this.$bitmap$inlined);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        this.this$0.$callback.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
