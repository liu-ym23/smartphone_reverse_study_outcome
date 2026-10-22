package com.bytedance.android.live.revlink.impl.multianchor.widget;

import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext;", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkAnchorControlService$loadSceneMergeCompactComponent$3 extends FunctionReferenceImpl implements Function1<PkPrecisionMatchDataContext, Unit> {
    public MultiLinkAnchorControlService$loadSceneMergeCompactComponent$3(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r8) {
        super(1, r8, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a.class, "updateMatchUser", "updateMatchUser(Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkPrecisionMatchDataContext;)V", 0);
    }

    public final void invoke(PkPrecisionMatchDataContext r2) {
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r0 = ((com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a) ((CallableReference) this).receiver).a;
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((PkPrecisionMatchDataContext) r1);
        return Unit.INSTANCE;
    }
}
