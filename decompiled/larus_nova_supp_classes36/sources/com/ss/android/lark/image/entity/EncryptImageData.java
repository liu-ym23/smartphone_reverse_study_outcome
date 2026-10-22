package com.ss.android.lark.image.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class EncryptImageData implements Parcelable {
    public static final Parcelable.Creator<EncryptImageData> CREATOR = null;
    public String a;
    public String b;

    public class a implements Parcelable.Creator<EncryptImageData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptImageData createFromParcel(Parcel r2) {
            return new EncryptImageData(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final EncryptImageData[] newArray(int r1) {
            return new EncryptImageData[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public EncryptImageData() {
    }

    public EncryptImageData(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
    }
}
