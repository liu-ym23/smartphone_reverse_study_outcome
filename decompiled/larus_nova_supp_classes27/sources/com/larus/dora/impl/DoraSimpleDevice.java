package com.larus.dora.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0007J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/DoraSimpleDevice;", "Landroid/os/Parcelable;", "name", "", "mac", "sn", "sku", "", "type", "serialNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getMac", "getSn", "getSku", "()I", "getType", "getSerialNumber", "toDevice", "Lcom/bytedance/dora/device/DoraDevice;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSimpleDevice implements Parcelable {
    public static final Parcelable.Creator<DoraSimpleDevice> CREATOR = null;
    private final String mac;
    private final String name;
    private final String serialNumber;
    private final int sku;
    private final String sn;
    private final int type;

    public static final class a implements Parcelable.Creator<DoraSimpleDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraSimpleDevice createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new DoraSimpleDevice(r9.readString(), r9.readString(), r9.readString(), r9.readInt(), r9.readInt(), r9.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraSimpleDevice[] newArray(int r1) {
            return new DoraSimpleDevice[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ DoraSimpleDevice copy$default(DoraSimpleDevice r4, String r5, String r6, String r7, int r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.name;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.mac;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.sn;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.sku;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.type;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.serialNumber;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.mac;
    }

    public final String component3() {
        return this.sn;
    }

    public final int component4() {
        return this.sku;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.serialNumber;
    }

    public final DoraSimpleDevice copy(String r9, String r10, String r11, int r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "name");
        Intrinsics.checkNotNullParameter(r10, "mac");
        Intrinsics.checkNotNullParameter(r11, "sn");
        Intrinsics.checkNotNullParameter(r14, "serialNumber");
        return new DoraSimpleDevice(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraSimpleDevice) == true) goto L8;
        return false;
    L8:
        DoraSimpleDevice r6 = (DoraSimpleDevice) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mac, r6.mac) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sn, r6.sn) == true) goto L18;
        return false;
    L18:
        if (this.sku == r6.sku) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.serialNumber, r6.serialNumber) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.name.hashCode() * 31) + this.mac.hashCode()) * 31) + this.sn.hashCode()) * 31) + this.sku) * 31) + this.type) * 31) + this.serialNumber.hashCode();
    }

    public String toString() {
        return "DoraSimpleDevice(name=" + this.name + ", mac=" + this.mac + ", sn=" + this.sn + ", sku=" + this.sku + ", type=" + this.type + ", serialNumber=" + this.serialNumber + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.name);
        r1.writeString(this.mac);
        r1.writeString(this.sn);
        r1.writeInt(this.sku);
        r1.writeInt(this.type);
        r1.writeString(this.serialNumber);
    }

    public final DoraDevice toDevice() {
        DoraDevice r0 = new DoraDevice();
        r0.name = this.name;
        r0.mac = this.mac;
        r0.sn = this.sn;
        r0.sku = this.sku;
        r0.type = this.type;
        return r0;
    }

    public final String getMac() {
        return this.mac;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final int getSku() {
        return this.sku;
    }

    public final String getSn() {
        return this.sn;
    }

    public final int getType() {
        return this.type;
    }

    public DoraSimpleDevice(String r2, String r3, String r4, int r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, "sn");
        Intrinsics.checkNotNullParameter(r7, "serialNumber");
        this.name = r2;
        this.mac = r3;
        this.sn = r4;
        this.sku = r5;
        this.type = r6;
        this.serialNumber = r7;
    }
}
