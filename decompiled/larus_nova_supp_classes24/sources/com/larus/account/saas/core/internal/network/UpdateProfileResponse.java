package com.larus.account.saas.core.internal.network;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/core/internal/network/UpdateProfileResponse;", "", "userID", "", "(Ljava/lang/String;)V", "getUserID", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "account-saas-core_release"}, k = 1, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UpdateProfileResponse {

    @SerializedName("entity_id")
    private final String userID;

    public UpdateProfileResponse() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ UpdateProfileResponse copy$default(UpdateProfileResponse r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.userID;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.userID;
    }

    public final UpdateProfileResponse copy(String r2) {
        return new UpdateProfileResponse(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof UpdateProfileResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userID, ((UpdateProfileResponse) r4).userID) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.userID;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "UpdateProfileResponse(userID=" + this.userID + ')';
    }

    public final String getUserID() {
        return this.userID;
    }

    public UpdateProfileResponse(String r1) {
        this.userID = r1;
    }

    public /* synthetic */ UpdateProfileResponse(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
