package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "Landroid/os/Parcelable;", ActivityLifecycle.NAME, "", MemoryKeyInfoEntity.KEY_ADDRESS, "batteryLevel", "", "deviceClass", "majorDeviceClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;II)V", "getName", "()Ljava/lang/String;", "getAddress", "getBatteryLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeviceClass", "()I", "getMajorDeviceClass", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;II)Lcom/obric/memorydata/sdk/awareness/model/BluetoothDeviceInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BluetoothDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<BluetoothDeviceInfo> CREATOR = null;
    private final String address;
    private final Integer batteryLevel;
    private final int deviceClass;
    private final int majorDeviceClass;
    private final String name;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<BluetoothDeviceInfo> {
        public a() {
        }

        public final BluetoothDeviceInfo a(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            String r1 = r7.readString();
            String r2 = r7.readString();
            if (r7.readInt() != 0) goto L5;
            Integer r0 = null;
        L7:
            return new BluetoothDeviceInfo(r1, r2, r0, r7.readInt(), r7.readInt());
        L5:
            r0 = Integer.valueOf(r7.readInt());
            goto L7
        }

        public final BluetoothDeviceInfo[] a(int r1) {
            return new BluetoothDeviceInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BluetoothDeviceInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ BluetoothDeviceInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public BluetoothDeviceInfo(String r2, String r3, Integer r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
        this.name = r2;
        this.address = r3;
        this.batteryLevel = r4;
        this.deviceClass = r5;
        this.majorDeviceClass = r6;
    }

    public static /* synthetic */ BluetoothDeviceInfo copy$default(BluetoothDeviceInfo r3, String r4, String r5, Integer r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.name;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.address;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.batteryLevel;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.deviceClass;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.majorDeviceClass;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final Integer component3() {
        return this.batteryLevel;
    }

    public final int component4() {
        return this.deviceClass;
    }

    public final int component5() {
        return this.majorDeviceClass;
    }

    public final BluetoothDeviceInfo copy(String r7, String r8, Integer r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r8, MemoryKeyInfoEntity.KEY_ADDRESS);
        return new BluetoothDeviceInfo(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BluetoothDeviceInfo.class) == true) goto L8;
        return false;
    L8:
        BluetoothDeviceInfo r6 = (BluetoothDeviceInfo) ZeusTransformUtils.preCheckCast(r5, BluetoothDeviceInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.address, r6.address) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.batteryLevel, r6.batteryLevel) == true) goto L18;
        return false;
    L18:
        if (this.deviceClass == r6.deviceClass) goto L21;
        return false;
    L21:
        if (this.majorDeviceClass == r6.majorDeviceClass) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    public final int getDeviceClass() {
        return this.deviceClass;
    }

    public final int getMajorDeviceClass() {
        return this.majorDeviceClass;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int r0 = ((this.name.hashCode() * 31) + this.address.hashCode()) * 31;
        Integer r1 = this.batteryLevel;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Integer.hashCode(this.deviceClass)) * 31) + Integer.hashCode(this.majorDeviceClass);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BluetoothDeviceInfo(name=" + this.name + ", address=" + this.address + ", batteryLevel=" + this.batteryLevel + ", deviceClass=" + this.deviceClass + ", majorDeviceClass=" + this.majorDeviceClass + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.name);
        r2.writeString(this.address);
        Integer r4 = this.batteryLevel;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        r2.writeInt(r5);
        r2.writeInt(this.deviceClass);
        r2.writeInt(this.majorDeviceClass);
        return;
    L5:
        r2.writeInt(1);
        r5 = r4.intValue();
        goto L6
    }
}
