package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lds2/b;", "", "invoke", "(Lds2/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RedPacketIconModel$login$1 extends Lambda implements Function1<ds2.b, Unit> {
    public static final RedPacketIconModel$login$1 INSTANCE = null;

    static {
        INSTANCE = new RedPacketIconModel$login$1();
    }

    public RedPacketIconModel$login$1() {
        super(1);
    }

    public final void invoke(ds2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.setMessage(s1.B(2131920131));
        r2.a(5);
        r2.setEnterFrom("live_detail");
        r2.setActionType("red_envelope");
        r2.setSource("live");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ds2.b) r1);
        return Unit.INSTANCE;
    }
}
