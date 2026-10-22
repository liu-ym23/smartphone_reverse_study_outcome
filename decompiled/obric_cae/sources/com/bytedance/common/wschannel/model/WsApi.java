package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3902b;

    public static class a implements Parcelable.Creator<WsApi> {
        @Override // android.os.Parcelable.Creator
        public final WsApi createFromParcel(Parcel r8) {
            WsApi r10 = new WsApi();
            r10.f3901a = r8.readInt();
            r10.f3902b = r8.readInt();
            return r10;
        }

        @Override // android.os.Parcelable.Creator
        public final WsApi[] newArray(int r8) {
            return new WsApi[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public WsApi() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f3901a);
        r8.writeInt(this.f3902b);
    }
}
