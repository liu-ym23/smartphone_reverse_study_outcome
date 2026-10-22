package com.obric.flow.cardlistpage.ui.component.popupdialog;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0004*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0005*\u00020\u0007H\u008a@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/flow/cardlistpage/mvi/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/flow/cardlistpage/mvi/j;", "I", "Lcom/obric/flow/cardlistpage/mvi/e;", "K", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V", "com/obric/flow/cardlistpage/mvi/BaseMviComponent$collectState$1"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.popupdialog.PopupDialogComponent$observeState$$inlined$collectState$1", f = "PopupDialogComponent.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBaseMviComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMviComponent.kt\ncom/obric/flow/cardlistpage/mvi/BaseMviComponent$collectState$1\n*L\n1#1,99:1\n*E\n"})
public final class PopupDialogComponent$observeState$$inlined$collectState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ o this$0;

    public PopupDialogComponent$observeState$$inlined$collectState$1(Continuation r5, o r10, o r11) {
        this.this$0 = r10;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        o r11 = this.this$0;
        return new PopupDialogComponent$observeState$$inlined$collectState$1(r10, r11, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final o r12 = this.this$0;
        kotlinx.coroutines.flow.g r13 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(r12));
        m r14 = new m(this.this$0);
        this.label = 1;
        if (r13.collect(r14, this) != r10) goto L12;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((PopupDialogComponent$observeState$$inlined$collectState$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
