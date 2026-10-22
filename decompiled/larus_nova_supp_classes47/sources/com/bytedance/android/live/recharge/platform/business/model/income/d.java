package com.bytedance.android.live.recharge.platform.business.model.income;

import am3.g;
import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/income/d;", "Lcom/bytedance/android/live/base/model/Extra;", "", "firstExchange", "Z", "hideCombineExchange", "hideCashExchange", "", "giftPanelType", "I", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d extends Extra implements h {

    @SerializedName("is_first_income_exchange")
    public boolean firstExchange;

    @SerializedName("gift_panel_type")
    public int giftPanelType;

    @SerializedName("hide_cash_exchange")
    public boolean hideCashExchange;

    @SerializedName("hide_combine_exchange")
    public boolean hideCombineExchange;

    public d() {
    }

    public d(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.firstExchange = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this.hideCombineExchange = am3.h.a(r5);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this.hideCashExchange = am3.h.a(r5);
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this.giftPanelType = (int) r5.j();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
