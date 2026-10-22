package com.bytedance.android.live.cloudgrouplive.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/b;", "", "", "userIdStr", "Ljava/lang/String;", "getUserIdStr", "()Ljava/lang/String;", "rtcUserId", "b", "rtcExtInfo", "a", "", "rtcRole", "Ljava/lang/Integer;", "getRtcRole", "()Ljava/lang/Integer;", "userOpenIdStr", "getUserOpenIdStr", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements h {

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    @SerializedName("rtc_role")
    protected Integer rtcRole;

    @SerializedName("rtc_user_id")
    protected String rtcUserId;

    @SerializedName("user_id_str")
    protected String userIdStr;

    @SerializedName("user_open_id_str")
    protected String userOpenIdStr;

    public b() {
    }

    public final String a() {
        return this.rtcExtInfo;
    }

    public final String b() {
        return this.rtcUserId;
    }

    public b(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.userIdStr = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtcUserId = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.rtcExtInfo = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.rtcRole = Integer.valueOf(r5.i());
        goto L3
    L14:
        if (r2 != 5000) goto L15;
        this.userOpenIdStr = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
