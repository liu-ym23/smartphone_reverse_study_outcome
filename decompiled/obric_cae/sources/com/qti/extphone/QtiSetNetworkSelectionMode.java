package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class QtiSetNetworkSelectionMode implements Parcelable {
    public static final int ACCESS_MODE_INVALID = 0;
    public static final int ACCESS_NETWORK_UNKNOWN = 0;
    public static final long CAG_ID_INVALID = -1;
    public static final Parcelable.Creator<QtiSetNetworkSelectionMode> CREATOR = null;
    private static final String TAG = "QtiSetNetworkSelectionMode";
    private int mAccessMode;
    private long mCagId;
    private byte[] mNid;
    private String mOperatorNumeric;
    private int mRan;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QtiSetNetworkSelectionMode(Parcel r8) {
        this.mRan = 0;
        this.mAccessMode = 0;
        this.mCagId = -1;
        this.mOperatorNumeric = r8.readString();
        this.mRan = r8.readInt();
        this.mAccessMode = r8.readInt();
        this.mCagId = r8.readLong();
        int r10 = r8.readInt();
        if (r10 <= 0) goto L5;
        byte[] r11 = new byte[r10];
        this.mNid = r11;
        r8.readByteArray(r11);
        return;
    L5:
        this.mNid = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccessMode() {
        return this.mAccessMode;
    }

    public long getCagId() {
        return this.mCagId;
    }

    public byte[] getNid() {
        return this.mNid;
    }

    public String getOperatorNumeric() {
        return this.mOperatorNumeric;
    }

    public int getRan() {
        return this.mRan;
    }

    public void readFromParcel(Parcel r8) {
        this.mOperatorNumeric = r8.readString();
        this.mRan = r8.readInt();
        this.mAccessMode = r8.readInt();
        this.mCagId = r8.readLong();
        int r10 = r8.readInt();
        if (r10 <= 0) goto L5;
        byte[] r11 = new byte[r10];
        this.mNid = r11;
        r8.readByteArray(r11);
        return;
    L5:
        this.mNid = null;
    }

    public String toString() {
        return TAG + this.mOperatorNumeric + "/" + this.mRan + "/" + this.mAccessMode + "/" + this.mCagId + "/" + this.mNid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.mOperatorNumeric);
        r8.writeInt(this.mRan);
        r8.writeInt(this.mAccessMode);
        r8.writeLong(this.mCagId);
        byte[] r11 = this.mNid;
        if (r11 != null) goto L5;
    L7:
        r8.writeInt(0);
        return;
    L5:
        if (r11.length <= 0) goto L7;
        r8.writeInt(r11.length);
        r8.writeByteArray(this.mNid);
    }

    public QtiSetNetworkSelectionMode(String r8, int r10, int r11, long r12, byte[] r13) {
        this.mOperatorNumeric = r8;
        this.mRan = r10;
        this.mAccessMode = r11;
        this.mCagId = r12;
        this.mNid = r13;
    }
}
