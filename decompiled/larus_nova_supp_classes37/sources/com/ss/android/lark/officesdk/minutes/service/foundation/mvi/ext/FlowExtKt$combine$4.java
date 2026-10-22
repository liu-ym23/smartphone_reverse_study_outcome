package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0010\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u0006\"\u0004\b\u0006\u0010\u0007\"\u0004\b\u0007\u0010\b\"\u0004\b\b\u0010\t\"\u0004\b\t\u0010\n2\u0006\u0010\u000b\u001a\u0002H\u00022\u0006\u0010\f\u001a\u0002H\u00032\u0006\u0010\r\u001a\u0002H\u00042\u0006\u0010\u000e\u001a\u0002H\u00052$\u0010\u000f\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n0\u0010H\n"}, d2 = {"<anonymous>", "R", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "t1", "t2", "t3", "t4", "combine", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple5;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$combine$4", f = "FlowExt.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$combine$4 extends SuspendLambda implements Function6<Object, Object, Object, Object, h<Object, Object, Object, Object, Object>, Continuation<Object>, Object> {
    final /* synthetic */ Function10<Object, Object, Object, Object, Object, Object, Object, Object, Object, Continuation<Object>, Object> $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    int label;

    public FlowExtKt$combine$4(Function10<Object, Object, Object, Object, Object, Object, Object, Object, Object, ? super Continuation<Object>, ? extends Object> r1, Continuation<? super FlowExtKt$combine$4> r2) {
        this.$transform = r1;
        super(6, r2);
    }

    public final Object invoke(Object r3, Object r4, Object r5, Object r6, h<Object, Object, Object, Object, Object> r7, Continuation<Object> r8) {
        FlowExtKt$combine$4 r0 = new FlowExtKt$combine$4(this.$transform, r8);
        r0.L$0 = r3;
        r0.L$1 = r4;
        r0.L$2 = r5;
        r0.L$3 = r6;
        r0.L$4 = r7;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6) {
        return invoke(r1, r2, r3, r4, (h) r5, (Continuation) r6);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Object r14 = this.L$0;
        Object r3 = this.L$1;
        Object r4 = this.L$2;
        Object r5 = this.L$3;
        h r2 = (h) this.L$4;
        Function10<Object, Object, Object, Object, Object, Object, Object, Object, Object, Continuation<Object>, Object> r6 = this.$transform;
        A r7 = r2.a;
        B r8 = r2.b;
        C r9 = r2.c;
        D r10 = r2.d;
        E r11 = r2.e;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 1;
        r13 = r6.invoke(r14, r3, r4, r5, r7, r8, r9, r10, r11, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
