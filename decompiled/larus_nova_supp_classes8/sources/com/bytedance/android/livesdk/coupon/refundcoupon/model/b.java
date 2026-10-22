package com.bytedance.android.livesdk.coupon.refundcoupon.model;

import am3.g;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.QueryUserBenefitPopupResponse.PopupWindow")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/b;", "", "", LiveEndPageData.TAG_TITLE, "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "description", "b", "setDescription", "Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/a;", "button", "Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/a;", "getButton", "()Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/a;", "setButton", "(Lcom/bytedance/android/livesdk/coupon/refundcoupon/model/a;)V", "", "price", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setPrice", "(Ljava/lang/Long;)V", "bgUrl", "a", "setBgUrl", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("background_url")
    protected String bgUrl;

    @SerializedName("button")
    protected a button;

    @SerializedName("description")
    protected String description;

    @SerializedName("amount")
    protected Long price;

    @SerializedName(LiveEndPageData.TAG_TITLE)
    protected String title;

    public b() {
        this.title = "";
        this.description = "";
        this.bgUrl = "";
    }

    public final String a() {
        return this.bgUrl;
    }

    public final String b() {
        return this.description;
    }

    public final Long c() {
        return this.price;
    }

    public final String d() {
        return this.title;
    }

    public b(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.description = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.button = new a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.price = Long.valueOf(r5.j());
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.bgUrl = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.title != null) goto L25;
        this.title = "";
    L25:
        if (this.description != null) goto L28;
        this.description = "";
    L28:
        if (this.bgUrl != null) goto L49;
        this.bgUrl = "";
        return;
    }
}
