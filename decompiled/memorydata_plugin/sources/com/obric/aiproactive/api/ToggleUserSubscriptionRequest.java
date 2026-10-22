package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/aiproactive/api/ToggleUserSubscriptionRequest;", "Landroid/os/Parcelable;", "subscriptionId", "", "isActive", "", "<init>", "(Ljava/lang/String;Z)V", "getSubscriptionId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleUserSubscriptionRequest implements Parcelable {
    public static final Parcelable.Creator<ToggleUserSubscriptionRequest> CREATOR = null;
    private final boolean isActive;
    private final String subscriptionId;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ToggleUserSubscriptionRequest> {
        public a() {
        }

        public final ToggleUserSubscriptionRequest a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            String r0 = r2.readString();
            if (r2.readInt() == 0) goto L5;
            boolean r3 = true;
        L7:
            return new ToggleUserSubscriptionRequest(r0, r3);
        L5:
            r3 = false;
            goto L7
        }

        public final ToggleUserSubscriptionRequest[] a(int r1) {
            return new ToggleUserSubscriptionRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ToggleUserSubscriptionRequest createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ToggleUserSubscriptionRequest[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ToggleUserSubscriptionRequest(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "subscriptionId");
        this.subscriptionId = r2;
        this.isActive = r3;
    }

    public static /* synthetic */ ToggleUserSubscriptionRequest copy$default(ToggleUserSubscriptionRequest r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.subscriptionId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isActive;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.subscriptionId;
    }

    public final boolean component2() {
        return this.isActive;
    }

    public final ToggleUserSubscriptionRequest copy(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "subscriptionId");
        return new ToggleUserSubscriptionRequest(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ToggleUserSubscriptionRequest.class) == true) goto L8;
        return false;
    L8:
        ToggleUserSubscriptionRequest r6 = (ToggleUserSubscriptionRequest) ZeusTransformUtils.preCheckCast(r5, ToggleUserSubscriptionRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.subscriptionId, r6.subscriptionId) == true) goto L12;
        return false;
    L12:
        if (this.isActive == r6.isActive) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public int hashCode() {
        return (this.subscriptionId.hashCode() * 31) + Boolean.hashCode(this.isActive);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "ToggleUserSubscriptionRequest(subscriptionId=" + this.subscriptionId + ", isActive=" + this.isActive + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.subscriptionId);
        r1.writeInt(this.isActive ? 1 : 0);
    }
}
