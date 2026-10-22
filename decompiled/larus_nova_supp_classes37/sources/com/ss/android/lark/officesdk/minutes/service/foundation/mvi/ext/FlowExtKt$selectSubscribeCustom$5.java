package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "A", "<destruct>", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple1;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$selectSubscribeCustom$5", f = "FlowExt.kt", i = {}, l = {AvatarItemView.FIRST_VIEW_MIN_WIDTH}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$selectSubscribeCustom$5 extends SuspendLambda implements Function2<d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    public FlowExtKt$selectSubscribeCustom$5(Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super FlowExtKt$selectSubscribeCustom$5> r2) {
        this.$action = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowExtKt$selectSubscribeCustom$5 r0 = new FlowExtKt$selectSubscribeCustom$5(this.$action, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(d<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((d) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        A r5 = ((d) this.L$0).a;
        Function2<Object, Continuation<? super Unit>, Object> r2 = this.$action;
        this.label = 1;
        if (r2.invoke(r5, this) != r0) goto L12;
        return r0;
    }
}
