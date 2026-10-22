package com.bytedance.android.live.recharge.exchange.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/b;", "", "", "amount", "Ljava/lang/Integer;", "getAmount", "()Ljava/lang/Integer;", "setAmount", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/live/recharge/exchange/model/c;", "exchangeRate", "Lcom/bytedance/android/live/recharge/exchange/model/c;", "getExchangeRate", "()Lcom/bytedance/android/live/recharge/exchange/model/c;", "setExchangeRate", "(Lcom/bytedance/android/live/recharge/exchange/model/c;)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("amount")
    private Integer amount;

    @SerializedName("exchange_base_rate")
    private c exchangeRate;

    public b() {
    }
}
