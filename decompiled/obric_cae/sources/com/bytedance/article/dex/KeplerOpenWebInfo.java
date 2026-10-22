package com.bytedance.article.dex;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class KeplerOpenWebInfo implements Parcelable {
    public static final Parcelable.Creator<KeplerOpenWebInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3786b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3787m;

    public static class a implements Parcelable.Creator<KeplerOpenWebInfo> {
        @Override // android.os.Parcelable.Creator
        public final KeplerOpenWebInfo createFromParcel(Parcel r8) {
            return new KeplerOpenWebInfo(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final KeplerOpenWebInfo[] newArray(int r8) {
            return new KeplerOpenWebInfo[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public KeplerOpenWebInfo(Parcel r8) {
        this.f3785a = r8.readString();
        this.f3786b = r8.readString();
        this.f3787m = r8.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3785a);
        r8.writeString(this.f3786b);
        r8.writeString(this.f3787m);
    }
}
