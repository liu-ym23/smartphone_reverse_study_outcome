package com.larus.account.saas.core.internal.network;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/account/saas/core/internal/network/CheckUserNameResponse;", "", "userName", "", "isUnique", "", "(Ljava/lang/String;Z)V", "()Z", "getUserName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "account-saas-core_release"}, k = 1, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CheckUserNameResponse {

    @SerializedName("is_unique")
    private final boolean isUnique;

    @SerializedName("user_name")
    private final String userName;

    public CheckUserNameResponse() {
        String r2 = null;
        this(r2, false, 3, r2);
    }

    public static /* synthetic */ CheckUserNameResponse copy$default(CheckUserNameResponse r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.userName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isUnique;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.userName;
    }

    public final boolean component2() {
        return this.isUnique;
    }

    public final CheckUserNameResponse copy(String r2, boolean r3) {
        return new CheckUserNameResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CheckUserNameResponse) == true) goto L8;
        return false;
    L8:
        CheckUserNameResponse r6 = (CheckUserNameResponse) r5;
        if (Intrinsics.areEqual(this.userName, r6.userName) == true) goto L12;
        return false;
    L12:
        if (this.isUnique == r6.isUnique) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String r0 = this.userName;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.isUnique;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckUserNameResponse(userName=" + this.userName + ", isUnique=" + this.isUnique + ')';
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean isUnique() {
        return this.isUnique;
    }

    public CheckUserNameResponse(String r1, boolean r2) {
        this.userName = r1;
        this.isUnique = r2;
    }

    public /* synthetic */ CheckUserNameResponse(String r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
