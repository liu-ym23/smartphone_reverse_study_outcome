package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.EventProcessorDispatch;
import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0015\u0010\u0004\u001a\u00110\u0000¢\u0006\f\b\u0001\u0012\b\b\u0002\u0012\u0004\b\b(\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/consumechain/j;", "Lkotlin/ParameterName;", "name", "initEvent", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/multianchor/widget/linkoutstrategy/consumechain/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkOutStrategy$handleReceiveReply$dispatch$1 extends FunctionReferenceImpl implements Function1<j, Unit> {
    public RevLinkOutStrategy$handleReceiveReply$dispatch$1(EventProcessorDispatch r8) {
        super(1, r8, EventProcessorDispatch.class, "dispatch", "dispatch(Ljava/lang/Object;)V", 0);
    }

    public final void invoke(j r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((EventProcessorDispatch) ((CallableReference) this).receiver).a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }
}
