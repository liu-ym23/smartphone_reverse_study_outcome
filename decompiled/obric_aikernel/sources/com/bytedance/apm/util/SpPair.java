package com.bytedance.apm.util;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;
    public String mKey;
    public Object mValue;

    static class a implements Parcelable.Creator<SpPair> {
        a() {
        }

        public SpPair a(Parcel r10) {
            return new SpPair(r10);
        }

        public SpPair[] b(int r10) {
            return new SpPair[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SpPair createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SpPair[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    protected SpPair(Parcel r10) {
        this.mKey = r10.readString();
        this.mValue = r10.readValue(getClass().getClassLoader());
    }

    public SpPair(String r10, Object r11) {
        this.mKey = r10;
        this.mValue = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.mKey);
        r10.writeValue(this.mValue);
    }
}
