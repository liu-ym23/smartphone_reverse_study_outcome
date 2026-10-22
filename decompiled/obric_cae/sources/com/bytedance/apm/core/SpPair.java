package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3759b;

    public static class a implements Parcelable.Creator<SpPair> {
        @Override // android.os.Parcelable.Creator
        public final SpPair createFromParcel(Parcel r8) {
            return new SpPair(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final SpPair[] newArray(int r8) {
            return new SpPair[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SpPair(Parcel r8) {
        this.f3758a = r8.readString();
        this.f3759b = r8.readValue(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3758a);
        r8.writeValue(this.f3759b);
    }

    public SpPair(Object r8, String r10) {
        this.f3758a = r10;
        this.f3759b = r8;
    }
}
