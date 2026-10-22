package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceParcelable> CREATOR = null;
    private final int mChannelId;
    private final int mServiceId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ServiceParcelable(int r1, int r2) {
        this.mChannelId = r1;
        this.mServiceId = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mChannelId);
        r1.writeInt(this.mServiceId);
    }
}
