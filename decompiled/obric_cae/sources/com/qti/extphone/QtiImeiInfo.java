package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class QtiImeiInfo implements Parcelable {
    public static final Parcelable.Creator<QtiImeiInfo> CREATOR = null;
    public static final int IMEI_TYPE_INVALID = 0;
    public static final int IMEI_TYPE_PRIMARY = 1;
    public static final int IMEI_TYPE_SECONDARY = 2;
    private static final String TAG = "QtiImeiInfo";
    private String mImei;
    private int mImeiType;
    private int mSlotId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QtiImeiInfo(int r8, String r10, int r11) {
        this.mSlotId = r8;
        this.mImei = r10;
        this.mImeiType = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L19;
        QtiImeiInfo r10 = (QtiImeiInfo) r8;
        if (this.mSlotId != r10.mSlotId) goto L18;
        if (this.mImeiType != r10.mImeiType) goto L18;
        if (Objects.equals(this.mImei, r10.mImei) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public String getImei() {
        return this.mImei;
    }

    public int getImeiType() {
        return this.mImeiType;
    }

    public int getSlotId() {
        return this.mSlotId;
    }

    public void readFromParcel(Parcel r8) {
        this.mSlotId = r8.readInt();
        this.mImei = r8.readString();
        this.mImeiType = r8.readInt();
    }

    public String toString() {
        return "QtiImeiInfo{ slotId=" + this.mSlotId + " mImeiType=" + getImeiType() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mSlotId);
        r8.writeString(this.mImei);
        r8.writeInt(this.mImeiType);
    }

    public QtiImeiInfo(Parcel r8) {
        this.mSlotId = r8.readInt();
        this.mImei = r8.readString();
        this.mImeiType = r8.readInt();
    }
}
