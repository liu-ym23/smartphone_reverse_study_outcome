package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.CheckSellingPointResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/a;", "", "", "isPass", "Z", "c", "()Z", "", "rejectType", "I", "b", "()I", "", "rejectReason", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("is_pass")
    protected boolean isPass;

    @SerializedName("reject_reason")
    protected String rejectReason;

    @SerializedName("reject_reason_type")
    protected int rejectType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.isPass == r4.isPass) goto L8;
        return false;
    L8:
        if (this.rejectType == r4.rejectType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rejectReason, r4.rejectReason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.isPass;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.rejectType) * 31;
        String r3 = this.rejectReason;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "CheckSellingPointResponse(isPass=" + this.isPass + ", rejectType=" + this.rejectType + ", rejectReason=" + this.rejectReason + ")";
    }

    public a() {
        this.isPass = false;
        this.rejectType = CheckSellingPointRejectType.UNKNOWN.ordinal();
        this.rejectReason = null;
    }

    public final String a() {
        return this.rejectReason;
    }

    public final int b() {
        return this.rejectType;
    }

    public final boolean c() {
        return this.isPass;
    }

    public a(am3.g r8) {
        long r0 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L14;
        if (r4 != 1) goto L7;
        this.isPass = am3.h.a(r8);
        r3 = r3 | 1;
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.rejectReason = am3.h.c(r8);
        goto L3
    L9:
        if (r4 != 3) goto L10;
        this.rejectType = r8.i();
        r3 = r3 | 2;
        goto L3
    L10:
        am3.h.e(r8);
        goto L3
    L14:
        r8.d(r0);
        if ((r3 & 1) != 0) goto L18;
        this.isPass = false;
    L18:
        if ((r3 & 2) != 0) goto L21;
        this.rejectType = CheckSellingPointRejectType.UNKNOWN.ordinal();
    L21:
        if (this.rejectReason != null) goto L36;
        this.rejectReason = null;
        return;
    }
}
