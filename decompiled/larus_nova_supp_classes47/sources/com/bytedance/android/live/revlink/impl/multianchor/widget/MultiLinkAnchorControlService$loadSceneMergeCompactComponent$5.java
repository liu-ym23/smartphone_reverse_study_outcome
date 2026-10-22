package com.bytedance.android.live.revlink.impl.multianchor.widget;

import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.livesdk.link.model.i2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i2;", "p1", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext;", "p2", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i2;Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkAnchorControlService$loadSceneMergeCompactComponent$5 extends FunctionReferenceImpl implements Function2<i2, PkReserveBattleDataContext, Unit> {
    public MultiLinkAnchorControlService$loadSceneMergeCompactComponent$5(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r8) {
        super(2, r8, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a.class, "showReserveBeInviteDialog", "showReserveBeInviteDialog(Lcom/bytedance/android/livesdk/link/model/IBattleReserveInviteMessage;Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext;)V", 0);
    }

    public final void invoke(i2 r3, PkReserveBattleDataContext r4) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a r0 = (com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.a) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "beInvitedMsg");
        com.bytedance.android.live.revlink.link.domain.anchorimpl.c r1 = r0.a;
        if (r1 == null) goto L6;
        r1.l(r3, r4);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((i2) r1, (PkReserveBattleDataContext) r2);
        return Unit.INSTANCE;
    }
}
