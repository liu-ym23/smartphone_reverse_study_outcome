package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("open.private.im_api.UpdatePrivateMsgTabStatusResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/n;", "", "", "statusCode", "I", "a", "()I", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n implements vh7.h {

    @SerializedName("status_code")
    protected int statusCode;

    @SerializedName("status_msg")
    protected String statusMsg;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L10;
        n r4 = (n) r3;
        if (this.statusCode == r4.statusCode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r4.statusMsg) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.statusCode * 31;
        String r1 = this.statusMsg;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "UpdatePrivateMsgTabStatusResponse(statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ")";
    }

    public n() {
        this.statusCode = 0;
        this.statusMsg = null;
    }

    public final int a() {
        return this.statusCode;
    }

    public n(am3.g r8) {
        long r0 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L11;
        if (r4 != 1) goto L7;
        this.statusCode = (int) r8.j();
        r3 = r3 | true;
        goto L3
    L7:
        if (r4 != 2) goto L8;
        this.statusMsg = am3.h.c(r8);
        goto L3
    L8:
        am3.h.e(r8);
        goto L3
    L11:
        r8.d(r0);
        if ((r3 & true) == true) goto L15;
        this.statusCode = 0;
    L15:
        if (this.statusMsg != null) goto L27;
        this.statusMsg = null;
        return;
    }
}
