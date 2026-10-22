package com.larus.reach.impl;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/reach/impl/ReachActionResponse;", "", "showMessage", "", "isSuccess", "", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getShowMessage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailReason", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/reach/impl/ReachActionResponse;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final class ReachActionResponse {

    @SerializedName("fail_reason")
    private final String failReason;

    @SerializedName("is_success")
    private final Boolean isSuccess;

    @SerializedName("show_message")
    private final String showMessage;

    public ReachActionResponse() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ReachActionResponse copy$default(ReachActionResponse r0, String r1, Boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.showMessage;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.isSuccess;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.failReason;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.showMessage;
    }

    public final Boolean component2() {
        return this.isSuccess;
    }

    public final String component3() {
        return this.failReason;
    }

    public final ReachActionResponse copy(String r2, Boolean r3, String r4) {
        return new ReachActionResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReachActionResponse) == true) goto L8;
        return false;
    L8:
        ReachActionResponse r6 = (ReachActionResponse) r5;
        if (Intrinsics.areEqual(this.showMessage, r6.showMessage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isSuccess, r6.isSuccess) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.failReason, r6.failReason) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.showMessage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isSuccess;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.failReason;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ReachActionResponse(showMessage=" + this.showMessage + ", isSuccess=" + this.isSuccess + ", failReason=" + this.failReason + ')';
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final String getShowMessage() {
        return this.showMessage;
    }

    public final Boolean isSuccess() {
        return this.isSuccess;
    }

    public ReachActionResponse(String r1, Boolean r2, String r3) {
        this.showMessage = r1;
        this.isSuccess = r2;
        this.failReason = r3;
    }

    public /* synthetic */ ReachActionResponse(String r2, Boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
