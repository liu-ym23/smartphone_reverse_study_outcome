package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceParcelable> CREATOR = null;
    private final int mChannelId;
    private final int mServiceId;

    static class a implements Parcelable.Creator<ServiceParcelable> {
        a() {
        }

        public ServiceParcelable a(Parcel r10) {
            return new ServiceParcelable(r10.readInt(), r10.readInt());
        }

        public ServiceParcelable[] b(int r10) {
            return new ServiceParcelable[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceParcelable createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceParcelable[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ServiceParcelable(int r10, int r11) {
        this.mChannelId = r10;
        this.mServiceId = r11;
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
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mChannelId);
        r10.writeInt(this.mServiceId);
    }
}
