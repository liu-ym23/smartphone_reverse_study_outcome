package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ y0 a;
    public final /* synthetic */ e b;

    public a1(y0 r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        RedPacketState r5 = (RedPacketState) r4;
        if ((r5 instanceof RedPacketState.Waiting) == false) goto L6;
        this.a.c.a(new y0.a.e(this.b));
        return;
    L6:
        if ((r5 instanceof RedPacketState.Available) == false) goto L8;
    L13:
        this.a.c.a(new y0.a.C0049a(this.b));
        return;
    L8:
        if ((r5 instanceof RedPacketState.Rushing) == true) goto L13;
        if ((r5 instanceof RedPacketState.Empty) == false) goto L16;
        Function0<Unit> r6 = new RedPacketViewModel$updateState$2$observer$1(this);
        this.a.c.a(new y0.a.b(this.b, r6));
        return;
    }
}
