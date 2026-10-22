package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = null;
    private final int mChannelId;
    private final boolean mConnected;
    private final String mLogInfo;
    private final int mServiceId;

    static class a implements Parcelable.Creator<ServiceConnectEvent> {
        a() {
        }

        public ServiceConnectEvent a(Parcel r10) {
            int r11 = r10.readInt();
            int r12 = r10.readInt();
            if (r10.readByte() == 0) goto L5;
            boolean r13 = true;
        L7:
            return new ServiceConnectEvent(r11, r12, r13, r10.readString());
        L5:
            r13 = false;
            goto L7
        }

        public ServiceConnectEvent[] b(int r10) {
            return new ServiceConnectEvent[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceConnectEvent createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceConnectEvent[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ServiceConnectEvent(int r10, int r11, boolean r12, String r13) {
        this.mChannelId = r10;
        this.mServiceId = r11;
        this.mConnected = r12;
        this.mLogInfo = r13;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    @Nullable
    public String getLogInfo() {
        return this.mLogInfo;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public boolean isServiceConnected() {
        return this.mConnected;
    }

    public String toString() {
        return "ServiceConnectEvent{mChannelId=" + this.mChannelId + ", mServiceId=" + this.mServiceId + ", mConnected=" + this.mConnected + ", mLogInfo='" + this.mLogInfo + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mChannelId);
        r10.writeInt(this.mServiceId);
        r10.writeByte(this.mConnected ? 1 : 0);
        r10.writeString(this.mLogInfo);
    }
}
