package com.obric.flow.cardlistpage.mvi;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004*\u00020\u0006H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/obric/flow/cardlistpage/mvi/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/flow/cardlistpage/mvi/j;", "I", "Lcom/obric/flow/cardlistpage/mvi/i;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.flow.cardlistpage.mvi.BaseMviViewModel$sendEffect$1", f = "BaseMviViewModel.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class BaseMviViewModel$sendEffect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $effect;
    int label;
    final /* synthetic */ d this$0;

    public BaseMviViewModel$sendEffect$1(d r5, i r10, Continuation<? super BaseMviViewModel$sendEffect$1> r11) {
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new BaseMviViewModel$sendEffect$1(null, null, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 != 0) goto L5;
        ResultKt.throwOnFailure(r5);
        throw null;
    L5:
        if (r10 != 1) goto L9;
        ResultKt.throwOnFailure(r5);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((BaseMviViewModel$sendEffect$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
