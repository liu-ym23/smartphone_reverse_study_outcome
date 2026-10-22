package com.bytedance.android.live.profit.vote.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/vote/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class VoteIconModel$onCreate$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.profit.vote.model.b, Unit> {
    public VoteIconModel$onCreate$1(VoteIconModel r8) {
        super(1, r8, VoteIconModel.class, "moveToState", "moveToState(Ljava/lang/Object;)V", 0);
    }

    public final void invoke(com.bytedance.android.live.profit.vote.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((VoteIconModel) ((CallableReference) this).receiver).moveToState(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.live.profit.vote.model.b) r1);
        return Unit.INSTANCE;
    }
}
