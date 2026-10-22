package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class Client implements Parcelable {
    public static final Parcelable.Creator<Client> CREATOR = null;
    private static final String TAG = "Client";
    private IExtPhoneCallback mCallback;
    private int mId;
    private String mPackageName;
    private int mUid;

    static {
        CREATOR = new AnonymousClass1();
    }

    public Client(int r8, int r10, String r11, IExtPhoneCallback r12) {
        this.mId = r8;
        this.mUid = r10;
        this.mPackageName = r11;
        this.mCallback = r12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IExtPhoneCallback getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getUid() {
        return this.mUid;
    }

    public void readFromParcel(Parcel r8) {
        this.mId = r8.readInt();
        this.mUid = r8.readInt();
        this.mPackageName = r8.readString();
        this.mCallback = IExtPhoneCallback.Stub.asInterface(r8.readStrongBinder());
    }

    public String toString() {
        return "Client{mId=" + getId() + ", mUid=" + getUid() + ", mPackageName='" + getPackageName() + "', mCallback=" + getCallback() + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mId);
        r8.writeInt(this.mUid);
        r8.writeString(this.mPackageName);
        r8.writeStrongInterface(this.mCallback);
    }

    public Client(Parcel r8) {
        this.mId = r8.readInt();
        this.mUid = r8.readInt();
        this.mPackageName = r8.readString();
        this.mCallback = IExtPhoneCallback.Stub.asInterface(r8.readStrongBinder());
    }
}
