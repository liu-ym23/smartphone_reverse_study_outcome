package com.larus.dora.impl.wlan.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001(BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JI\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0006J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "Landroid/os/Parcelable;", "ssid", "", "bssid", "securityType", "", "level", "frequency", "inOperation", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIZ)V", "getSsid", "()Ljava/lang/String;", "getBssid", "getSecurityType", "()I", "getLevel", "getFrequency", "getInOperation", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiEntity implements Parcelable {
    public static final Parcelable.Creator<DoraWifiEntity> CREATOR = null;
    public final boolean a;

    @SerializedName("bssid")
    private final String bssid;

    @SerializedName("frequency")
    private final int frequency;

    @SerializedName("level")
    private final int level;

    @SerializedName("security_type")
    private final int securityType;

    @SerializedName("ssid")
    private final String ssid;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DoraWifiEntity> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraWifiEntity createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r2 = r9.readString();
            String r3 = r9.readString();
            int r4 = r9.readInt();
            int r5 = r9.readInt();
            int r6 = r9.readInt();
            if (r9.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            return new DoraWifiEntity(r2, r3, r4, r5, r6, r7);
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DoraWifiEntity[] newArray(int r1) {
            return new DoraWifiEntity[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraWifiEntity) == true) goto L8;
        return false;
    L8:
        DoraWifiEntity r6 = (DoraWifiEntity) r5;
        if (Intrinsics.areEqual(this.ssid, r6.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r6.bssid) == true) goto L15;
        return false;
    L15:
        if (this.securityType == r6.securityType) goto L18;
        return false;
    L18:
        if (this.level == r6.level) goto L21;
        return false;
    L21:
        if (this.frequency == r6.frequency) goto L24;
        return false;
    L24:
        if (this.a == r6.a) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.ssid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.bssid;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((((((r3 + r1) * 31) + this.securityType) * 31) + this.level) * 31) + this.frequency) * 31;
        if (this.a == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraWifiEntity(ssid=" + this.ssid + ", bssid=" + this.bssid + ", securityType=" + this.securityType + ", level=" + this.level + ", frequency=" + this.frequency + ", inOperation=" + this.a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.ssid);
        r1.writeString(this.bssid);
        r1.writeInt(this.securityType);
        r1.writeInt(this.level);
        r1.writeInt(this.frequency);
        r1.writeInt(this.a ? 1 : 0);
    }

    public DoraWifiEntity() {
        this("", "", -1, -1, -1, false);
    }

    public final int a() {
        return this.frequency;
    }

    public final int b() {
        return this.securityType;
    }

    public final String c() {
        return this.ssid;
    }

    public DoraWifiEntity(String r1, String r2, int r3, int r4, int r5, boolean r6) {
        this.ssid = r1;
        this.bssid = r2;
        this.securityType = r3;
        this.level = r4;
        this.frequency = r5;
        this.a = r6;
    }
}
