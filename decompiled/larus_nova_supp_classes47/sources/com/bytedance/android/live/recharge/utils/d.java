package com.bytedance.android.live.recharge.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/utils/d;", "", "", "cashExchangeOptEnable", "Z", "", "frequencyBase", "I", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    @SerializedName("cash_exchange_optimize_enable")
    private boolean cashExchangeOptEnable;

    @SerializedName("cash_exchange_frequency_base")
    private int frequencyBase;

    public d() {
        this.cashExchangeOptEnable = true;
        this.frequencyBase = 7;
    }

    public final int a() {
        return this.frequencyBase;
    }

    public final boolean b() {
        return this.cashExchangeOptEnable;
    }
}
