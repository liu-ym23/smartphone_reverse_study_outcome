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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.StateStore$resolveSubscription$1", f = "StateStore.kt", i = {}, l = {209, 211}, m = "invokeSuspend", n = {}, s = {})
final class StateStore$resolveSubscription$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ boolean $dropOldest;
    final /* synthetic */ Flow<Object> $this_resolveSubscription;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1) {
            this.a = r1;
        }

        public final Object emit(T r2, Continuation<? super Unit> r3) {
            Object r4 = this.a.invoke(r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public StateStore$resolveSubscription$1(boolean r1, Flow<Object> r2, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super StateStore$resolveSubscription$1> r4) {
        this.$dropOldest = r1;
        this.$this_resolveSubscription = r2;
        this.$action = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new StateStore$resolveSubscription$1(this.$dropOldest, this.$this_resolveSubscription, this.$action, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        if (this.$dropOldest == false) goto L15;
        Flow<Object> r6 = this.$this_resolveSubscription;
        Function2<Object, Continuation<? super Unit>, Object> r2 = this.$action;
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r6, r2, this) != r0) goto L19;
        return r0;
    L15:
        Flow<Object> r7 = this.$this_resolveSubscription;
        a r3 = new a(this.$action);
        this.label = 2;
        if (r7.collect(r3, this) != r0) goto L19;
        return r0;
    }
}
