package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ForMain
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/g;", "Lcom/bytedance/android/live/base/model/Extra;", "", "coupon", "Ljava/lang/String;", "couponDescription", "", "Lcom/bytedance/android/live/recharge/platform/model/a;", "couponDetail", "Ljava/util/List;", "", "rebateAmount", "J", "deductAmount", "rebateMessage", "", "status", "I", "successToastMsg", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g extends Extra implements vh7.h {

    @SerializedName("coupon")
    public String coupon;

    @SerializedName("coupon_description")
    public String couponDescription;

    @SerializedName("coupon_detail")
    public List<a> couponDetail;

    @SerializedName("deduct_amount")
    public long deductAmount;

    @SerializedName("rebate_amount")
    public long rebateAmount;

    @SerializedName("rebate_message")
    public String rebateMessage;

    @SerializedName("status")
    public int status;

    @SerializedName("success_toast")
    public String successToastMsg;

    public g() {
    }

    public g(am3.g r5) {
        this.couponDetail = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L6;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.successToastMsg = am3.h.c(r5);
        goto L3
    L8:
        this.status = (int) r5.j();
        goto L3
    L9:
        this.deductAmount = r5.j();
        goto L3
    L10:
        this.rebateMessage = am3.h.c(r5);
        goto L3
    L11:
        this.rebateAmount = r5.j();
        goto L3
    L12:
        this.couponDetail.add(new a(r5));
        goto L3
    L13:
        this.couponDescription = am3.h.c(r5);
        goto L3
    L14:
        this.coupon = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
