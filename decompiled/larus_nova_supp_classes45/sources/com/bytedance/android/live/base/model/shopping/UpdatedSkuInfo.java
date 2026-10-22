package com.bytedance.android.live.base.model.shopping;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0004J\u001c\u0010&\u001a\u00020 2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010J\u000e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/UpdatedSkuInfo;", "", "()V", "_couponPrice", "", "get_couponPrice", "()J", "set_couponPrice", "(J)V", "_maxPrice", "get_maxPrice", "set_maxPrice", "_minPrice", "get_minPrice", "set_minPrice", "_skus", "", "", "Lcom/bytedance/android/live/base/model/shopping/SkuInfo;", "get_skus", "()Ljava/util/Map;", "set_skus", "(Ljava/util/Map;)V", "_unUseMinPrice", "get_unUseMinPrice", "set_unUseMinPrice", "getCouponPrice", "getMaxPrice", "getMinPrice", "getSkus", "getUnUseMinPrice", "setCouponPrice", "", "couponPrice", "setMaxPrice", "maxPrice", "setMinPrice", "minPrice", "setSkus", "skus", "setUnUseMinPrice", "unUseMinPrice", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatedSkuInfo {

    @SerializedName("coupon_price")
    private long _couponPrice;

    @SerializedName("max_price")
    private long _maxPrice;

    @SerializedName("min_price")
    private long _minPrice;

    @SerializedName("skus")
    private Map<String, SkuInfo> _skus;

    @SerializedName("unuse_min_price")
    private long _unUseMinPrice;

    public UpdatedSkuInfo() {
    }

    public final long getCouponPrice() {
        return this._couponPrice;
    }

    public final long getMaxPrice() {
        return this._maxPrice;
    }

    public final long getMinPrice() {
        return this._minPrice;
    }

    public final Map<String, SkuInfo> getSkus() {
        return this._skus;
    }

    public final long getUnUseMinPrice() {
        return this._unUseMinPrice;
    }

    public final long get_couponPrice() {
        return this._couponPrice;
    }

    public final long get_maxPrice() {
        return this._maxPrice;
    }

    public final long get_minPrice() {
        return this._minPrice;
    }

    public final Map<String, SkuInfo> get_skus() {
        return this._skus;
    }

    public final long get_unUseMinPrice() {
        return this._unUseMinPrice;
    }

    public final void setCouponPrice(long r1) {
        this._couponPrice = r1;
    }

    public final void setMaxPrice(long r1) {
        this._maxPrice = r1;
    }

    public final void setMinPrice(long r1) {
        this._minPrice = r1;
    }

    public final void setSkus(Map<String, SkuInfo> r1) {
        this._skus = r1;
    }

    public final void setUnUseMinPrice(long r1) {
        this._unUseMinPrice = r1;
    }

    public final void set_couponPrice(long r1) {
        this._couponPrice = r1;
    }

    public final void set_maxPrice(long r1) {
        this._maxPrice = r1;
    }

    public final void set_minPrice(long r1) {
        this._minPrice = r1;
    }

    public final void set_skus(Map<String, SkuInfo> r1) {
        this._skus = r1;
    }

    public final void set_unUseMinPrice(long r1) {
        this._unUseMinPrice = r1;
    }
}
