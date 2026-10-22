package com.bytedance.android.livesdk.end;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yu1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J&\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "Lyu1/a;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "isVip", "newRoomID", "copy", "(Ljava/lang/Boolean;J)Lcom/bytedance/android/livesdk/end/VipLiveEndData;", "", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/Boolean;", "J", "getNewRoomID", "()J", "<init>", "(Ljava/lang/Boolean;J)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VipLiveEndData extends a {

    @SerializedName("is_member")
    private final Boolean isVip;

    @SerializedName("new_room_id")
    private final long newRoomID;

    public VipLiveEndData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ VipLiveEndData copy$default(VipLiveEndData r0, Boolean r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isVip;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.newRoomID;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.isVip;
    }

    public final long component2() {
        return this.newRoomID;
    }

    public final VipLiveEndData copy(Boolean r2, long r3) {
        return new VipLiveEndData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof VipLiveEndData) == false) goto L10;
        VipLiveEndData r6 = (VipLiveEndData) r5;
        if (Intrinsics.areEqual(this.isVip, r6.isVip) == true) goto L8;
        return false;
    L8:
        if (this.newRoomID == r6.newRoomID) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Boolean r0 = this.isVip;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.newRoomID;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "VipLiveEndData(isVip=" + this.isVip + ", newRoomID=" + this.newRoomID + ")";
    }

    public final long getNewRoomID() {
        return this.newRoomID;
    }

    public final Boolean isVip() {
        return this.isVip;
    }

    public VipLiveEndData(Boolean r1, long r2) {
        this.isVip = r1;
        this.newRoomID = r2;
    }

    public /* synthetic */ VipLiveEndData(Boolean r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = Boolean.FALSE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
