package com.ss.android.lark.forwardv2.dto.template.choosechat;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PreSelectedPair implements Parcelable {
    public static final Parcelable.Creator<PreSelectedPair> CREATOR = null;
    public final String a;
    public final String b;

    public class a implements Parcelable.Creator<PreSelectedPair> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PreSelectedPair createFromParcel(Parcel r2) {
            return new PreSelectedPair(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final PreSelectedPair[] newArray(int r1) {
            return new PreSelectedPair[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PreSelectedPair() {
    }

    public PreSelectedPair(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
    }
}
