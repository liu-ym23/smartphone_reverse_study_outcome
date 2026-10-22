package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.api.PayDiamondsResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/g0;", "", "", "orderId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "", "orderStatus", "I", "b", "()I", "setOrderStatus", "(I)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 implements vh7.h {

    @SerializedName("order_id")
    protected String orderId;

    @SerializedName("order_status")
    protected int orderStatus;

    public g0() {
    }

    public final String a() {
        return this.orderId;
    }

    public final int b() {
        return this.orderStatus;
    }

    public g0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.orderId = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.orderStatus = r5.i();
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }
}
