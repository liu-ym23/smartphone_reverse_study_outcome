package com.bytedance.android.live.profit.redpacket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class RedPacketIconModel$wannaSend$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RedPacketIconModel this$0;

    public RedPacketIconModel$wannaSend$2(RedPacketIconModel r1) {
        this.this$0 = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2) {
        if (r2 == false) goto L5;
        RedPacketIconModel r3 = this.this$0;
        com.bytedance.android.live.revenue.common.u0 r0 = RedPacketIconModel.w;
        r3.j();
        return;
    }
}
