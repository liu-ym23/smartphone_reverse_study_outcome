package com.bytedance.android.live.recharge;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/h;", "", "", "exchangeBalance", "J", "getExchangeBalance", "()J", "a", "(J)V", "rebateLimit", "getRebateLimit", "c", "giftAmount", "getGiftAmount", "b", "<init>", "()V", "liverecharge-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.ExchangeInfo")
public final class h {

    @SerializedName("exchange_balance")
    private long exchangeBalance;

    @SerializedName("gift_amount")
    private long giftAmount;

    @SerializedName("rebate_limit")
    private long rebateLimit;

    public h() {
    }

    public final void a(long r1) {
        this.exchangeBalance = r1;
    }

    public final void b(long r1) {
        this.giftAmount = r1;
    }

    public final void c(long r1) {
        this.rebateLimit = r1;
    }
}
