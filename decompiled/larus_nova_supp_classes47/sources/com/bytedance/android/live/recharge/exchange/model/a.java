package com.bytedance.android.live.recharge.exchange.model;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/a;", "Lcom/bytedance/android/live/base/model/Extra;", "", "firstExchange", "Ljava/lang/String;", "getFirstExchange", "()Ljava/lang/String;", "setFirstExchange", "(Ljava/lang/String;)V", "disable", "getDisable", "setDisable", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a extends Extra {

    @SerializedName("is_hotsoon_incentive_offline")
    private String disable;

    @SerializedName("is_first_exchange")
    private String firstExchange;

    public a() {
        this.firstExchange = "false";
        this.disable = "false";
    }
}
