package com.ss.android.lark.flow.passport.ui.widget.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt$collectLatestLifecycleFlow$1", f = "FlowUtil.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
final class FlowUtilKt$collectLatestLifecycleFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $collect;
    final /* synthetic */ Flow<Object> $flow;
    int label;

    public FlowUtilKt$collectLatestLifecycleFlow$1(Flow<Object> r1, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super FlowUtilKt$collectLatestLifecycleFlow$1> r3) {
        this.$flow = r1;
        this.$collect = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowUtilKt$collectLatestLifecycleFlow$1(this.$flow, this.$collect, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
        Flow<Object> r5 = this.$flow;
        Function2<Object, Continuation<? super Unit>, Object> r2 = this.$collect;
        this.label = 1;
        if (e.i(r5, r2, this) != r0) goto L12;
        return r0;
    }
}
