package com.obric.cae.libs.useraware;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.protobuf.c;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BtAwareInfo implements Parcelable {
    public static final Parcelable.Creator<BtAwareInfo> CREATOR = null;
    private static final int VERSION = 2;
    private final String mAddress;
    private final int mAddressType;
    private final boolean mConnected;
    private final int mDeviceClass;
    private final int mDeviceType;
    private final String mManufacturer;
    private final String mName;
    private final int mRssi;
    private final long mTimestamp;
    private final ParcelUuid[] mUuids;

    public class a implements Parcelable.Creator<BtAwareInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo createFromParcel(Parcel r8) {
            return new BtAwareInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BtAwareInfo[] newArray(int r8) {
            return new BtAwareInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    @SuppressLint({"NewApi"})
    public BtAwareInfo(Parcel r8) {
        this.mTimestamp = r8.readLong();
        this.mAddress = r8.readString();
        this.mAddressType = r8.readInt();
        this.mDeviceType = r8.readInt();
        this.mName = r8.readString();
        this.mDeviceClass = r8.readInt();
        this.mManufacturer = r8.readString();
        this.mRssi = (short) r8.readInt();
        this.mConnected = r8.readBoolean();
        this.mUuids = (ParcelUuid[]) r8.createTypedArray(ParcelUuid.CREATOR);
    }

    public static /* synthetic */ String[] a(int r8) {
        return new String[r8];
    }

    public boolean compareTo(BtAwareInfo r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (Objects.equals(this.mName, r8.mName) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mAddress, r8.mAddress) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(Integer.valueOf(this.mAddressType), Integer.valueOf(r8.mAddressType)) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(Integer.valueOf(this.mRssi), Integer.valueOf(r8.mRssi)) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(Boolean.valueOf(this.mConnected), Boolean.valueOf(r8.mConnected)) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(Integer.valueOf(this.mDeviceType), Integer.valueOf(r8.mDeviceType)) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(Integer.valueOf(this.mDeviceClass), Integer.valueOf(r8.mDeviceClass)) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(this.mManufacturer, r8.mManufacturer) == false) goto L30;
        return true;
    L30:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDeviceClass() {
        return this.mDeviceClass;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getName() {
        return this.mName;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public ParcelUuid[] getUuids() {
        return this.mUuids;
    }

    public int getVersion() {
        return 2;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public String toString() {
        ParcelUuid[] r8 = this.mUuids;
        if (r8 != null) goto L5;
    L7:
        String r10 = "";
    L9:
        return "BtAwareInfo:[2, timestamp=" + this.mTimestamp + ", address=" + this.mAddress + ", addressType=" + this.mAddressType + ", deviceType=" + this.mDeviceType + ", name=" + this.mName + ", deviceClass=" + this.mDeviceClass + ", manufacturer=" + this.mManufacturer + ", rssi=" + this.mRssi + ", connected=" + this.mConnected + ", uuids=(" + r10 + ")]";
    L5:
        if (r8.length <= 0) goto L7;
        r10 = String.join(",", (CharSequence[]) Arrays.stream(r8).map(new c(2)).toArray(new com.obric.cae.libs.useraware.a(0)));
        goto L9
    }

    @Override // android.os.Parcelable
    @SuppressLint({"NewApi"})
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.mTimestamp);
        r8.writeString(this.mAddress);
        r8.writeInt(this.mAddressType);
        r8.writeInt(this.mDeviceType);
        r8.writeString(this.mName);
        r8.writeInt(this.mDeviceClass);
        r8.writeString(this.mManufacturer);
        r8.writeInt(this.mRssi);
        r8.writeBoolean(this.mConnected);
        r8.writeTypedArray(this.mUuids, r10);
    }

    public BtAwareInfo(String r8, int r10, int r11, String r12, int r13, String r14, int r15, boolean r16, ParcelUuid[] r17) {
        this.mTimestamp = System.currentTimeMillis();
        this.mAddress = r8;
        this.mAddressType = r10;
        this.mDeviceType = r11;
        this.mName = r12;
        this.mDeviceClass = r13;
        this.mManufacturer = r14;
        this.mRssi = r15;
        this.mConnected = r16;
        this.mUuids = r17;
    }
}
