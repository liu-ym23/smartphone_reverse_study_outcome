package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;
    public String mKey;
    public Object mValue;

    static {
        CREATOR = new AnonymousClass1();
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
