package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/WifiCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "ssid", "", "bssid", "(Ljava/lang/String;Ljava/lang/String;)V", "getBssid", "()Ljava/lang/String;", "getSsid", "component1", "component2", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WifiCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<WifiCondition> CREATOR = null;
    private final String bssid;
    private final String ssid;

    public static final class a implements Parcelable.Creator<WifiCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WifiCondition createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            WifiCondition r1 = new WifiCondition(r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r3 = a.class.getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L5;
            r4 = r4 + 1;
        L5:
            if (r4 > r0) goto L7;
            joa.a.d(r6, r3);
            r4 = r4 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final WifiCondition[] newArray(int r1) {
            return new WifiCondition[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public WifiCondition(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ssid");
        this.ssid = r2;
        this.bssid = r3;
    }

    public /* synthetic */ WifiCondition(String r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ WifiCondition copy$default(WifiCondition r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ssid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bssid;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final WifiCondition copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "ssid");
        return new WifiCondition(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WifiCondition) == true) goto L8;
        return false;
    L8:
        WifiCondition r6 = (WifiCondition) r5;
        if (Intrinsics.areEqual(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r6.bssid) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public int hashCode() {
        int r0 = this.ssid.hashCode() * 31;
        String r1 = this.bssid;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "WifiCondition(ssid=" + this.ssid + ", bssid=" + this.bssid + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.ssid);
        r1.writeString(this.bssid);
    }
}
