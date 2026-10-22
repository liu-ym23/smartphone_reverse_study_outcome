package com.bytedance.android.live.base.model.shopping;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\rJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/SkuInfo;", "", "()V", "_couponPrice", "", "get_couponPrice", "()J", "set_couponPrice", "(J)V", "_price", "get_price", "set_price", "_skuId", "", "get_skuId", "()Ljava/lang/String;", "set_skuId", "(Ljava/lang/String;)V", "_stockNum", "get_stockNum", "set_stockNum", "getCouponPrice", "getPrice", "getSkuId", "getStockNum", "setCouponPrice", "", "couponPrice", "setPrice", "price", "setSkuId", "skuId", "setStockNum", "stockNum", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuInfo {

    @SerializedName("coupon_price")
    private long _couponPrice;

    @SerializedName("price")
    private long _price;

    @SerializedName("sku_id")
    private String _skuId;

    @SerializedName("stock_num")
    private long _stockNum;

    public SkuInfo() {
    }

    public final long getCouponPrice() {
        return this._couponPrice;
    }

    public final long getPrice() {
        return this._price;
    }

    public final String getSkuId() {
        return this._skuId;
    }

    public final long getStockNum() {
        return this._stockNum;
    }

    public final long get_couponPrice() {
        return this._couponPrice;
    }

    public final long get_price() {
        return this._price;
    }

    public final String get_skuId() {
        return this._skuId;
    }

    public final long get_stockNum() {
        return this._stockNum;
    }

    public final void setCouponPrice(long r1) {
        this._couponPrice = r1;
    }

    public final void setPrice(long r1) {
        this._price = r1;
    }

    public final void setSkuId(String r1) {
        this._skuId = r1;
    }

    public final void setStockNum(long r1) {
        this._stockNum = r1;
    }

    public final void set_couponPrice(long r1) {
        this._couponPrice = r1;
    }

    public final void set_price(long r1) {
        this._price = r1;
    }

    public final void set_skuId(String r1) {
        this._skuId = r1;
    }

    public final void set_stockNum(long r1) {
        this._stockNum = r1;
    }
}
