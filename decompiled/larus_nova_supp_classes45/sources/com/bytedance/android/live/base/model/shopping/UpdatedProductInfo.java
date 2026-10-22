package com.bytedance.android.live.base.model.shopping;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nJ\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/shopping/UpdatedProductInfo;", "", "()V", "_cover", "", "get_cover", "()Ljava/lang/String;", "set_cover", "(Ljava/lang/String;)V", "_price", "", "get_price", "()J", "set_price", "(J)V", "_title", "get_title", "set_title", "getCover", "getPrice", "getTitle", "setCover", "", "cover", "setPrice", "price", "setTitle", "title", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatedProductInfo {

    @SerializedName("cover")
    private String _cover;

    @SerializedName("price")
    private long _price;

    @SerializedName("title")
    private String _title;

    public UpdatedProductInfo() {
    }

    public final String getCover() {
        return this._cover;
    }

    public final long getPrice() {
        return this._price;
    }

    public final String getTitle() {
        return this._title;
    }

    public final String get_cover() {
        return this._cover;
    }

    public final long get_price() {
        return this._price;
    }

    public final String get_title() {
        return this._title;
    }

    public final void setCover(String r1) {
        this._cover = r1;
    }

    public final void setPrice(long r1) {
        this._price = r1;
    }

    public final void setTitle(String r1) {
        this._title = r1;
    }

    public final void set_cover(String r1) {
        this._cover = r1;
    }

    public final void set_price(long r1) {
        this._price = r1;
    }

    public final void set_title(String r1) {
        this._title = r1;
    }
}
