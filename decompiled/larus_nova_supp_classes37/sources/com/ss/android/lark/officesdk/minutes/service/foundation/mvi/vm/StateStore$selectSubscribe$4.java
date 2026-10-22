package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "A", "B", "<destruct>", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple2;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.StateStore$selectSubscribe$4", f = "StateStore.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
final class StateStore$selectSubscribe$4 extends SuspendLambda implements Function2<e<Object, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Object, Object, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    public StateStore$selectSubscribe$4(Function3<Object, Object, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super StateStore$selectSubscribe$4> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        StateStore$selectSubscribe$4 r0 = new StateStore$selectSubscribe$4(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(e<Object, Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        e r6 = (e) this.L$0;
        A r2 = r6.a;
        B r7 = r6.b;
        Function3<Object, Object, Continuation<? super Unit>, Object> r3 = this.$action;
        this.label = 1;
        if (r3.invoke(r2, r7, this) != r0) goto L12;
        return r0;
    }
}
