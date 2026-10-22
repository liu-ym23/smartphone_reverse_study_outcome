package com.bytedance.android.live.base.model.shopping;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0018\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0012\u0010\u000f\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/UpdatedCouponInfo;", "", "()V", "_couponApplet", "", "get_couponApplet", "()Ljava/lang/String;", "set_couponApplet", "(Ljava/lang/String;)V", "_couponMetaId", "get_couponMetaId", "set_couponMetaId", "_couponUrl", "get_couponUrl", "set_couponUrl", "_isValid", "", "_tag", "get_tag", "set_tag", "getCouponApplet", "getCouponMetaId", "getCouponUrl", "getTag", "getValid", "setCouponApplet", "", "couponApplet", "setCouponMetaId", "couponMetaId", "setCouponUrl", "couponUrl", "setTag", "tag", "setValid", "valid", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatedCouponInfo {

    @SerializedName("coupon_applet")
    private String _couponApplet;

    @SerializedName("coupon_meta_id")
    private String _couponMetaId;

    @SerializedName("coupon_url")
    private String _couponUrl;

    @SerializedName("is_valid")
    private boolean _isValid;

    @SerializedName("tag")
    private String _tag;

    public UpdatedCouponInfo() {
    }

    public final String getCouponApplet() {
        return this._couponApplet;
    }

    public final String getCouponMetaId() {
        return this._couponMetaId;
    }

    public final String getCouponUrl() {
        return this._couponUrl;
    }

    public final String getTag() {
        return this._tag;
    }

    public final boolean getValid() {
        return this._isValid;
    }

    public final String get_couponApplet() {
        return this._couponApplet;
    }

    public final String get_couponMetaId() {
        return this._couponMetaId;
    }

    public final String get_couponUrl() {
        return this._couponUrl;
    }

    public final String get_tag() {
        return this._tag;
    }

    public final void setCouponApplet(String r1) {
        this._couponApplet = r1;
    }

    public final void setCouponMetaId(String r1) {
        this._couponMetaId = r1;
    }

    public final void setCouponUrl(String r1) {
        this._couponUrl = r1;
    }

    public final void setTag(String r1) {
        this._tag = r1;
    }

    public final void setValid(boolean r1) {
        this._isValid = r1;
    }

    public final void set_couponApplet(String r1) {
        this._couponApplet = r1;
    }

    public final void set_couponMetaId(String r1) {
        this._couponMetaId = r1;
    }

    public final void set_couponUrl(String r1) {
        this._couponUrl = r1;
    }

    public final void set_tag(String r1) {
        this._tag = r1;
    }
}
