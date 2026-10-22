package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.VisibleStatusFullUpdateData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/g0;", "", "", "", "updateFailedUidList", "Ljava/util/List;", "cancelFailedUidList", "", "statusCode", "Ljava/lang/Integer;", "", "errMsg", "Ljava/lang/String;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 implements vh7.h {

    @SerializedName("cancel_failed_uid_list")
    public List<Long> cancelFailedUidList;

    @SerializedName("err_msg")
    public String errMsg;

    @SerializedName("status_code")
    public Integer statusCode;

    @SerializedName("update_failed_uid_list")
    public List<Long> updateFailedUidList;

    public g0() {
    }

    public g0(am3.g r6) {
        this.updateFailedUidList = new ArrayList();
        this.cancelFailedUidList = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L19;
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L10;
        List<Long> r3 = this.cancelFailedUidList;
    L18:
        r3.add(Long.valueOf(r6.j()));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.statusCode = Integer.valueOf(r6.i());
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.errMsg = am3.h.c(r6);
        goto L3
    L13:
        am3.h.e(r6);
        goto L3
    L17:
        r3 = this.updateFailedUidList;
        goto L18
    L19:
        r6.d(r0);
    }
}
