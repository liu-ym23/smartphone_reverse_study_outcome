package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class Token implements Parcelable {
    public static final Parcelable.Creator<Token> CREATOR = null;
    private static final String TAG = "Token";
    public static final int UNSOL = -1;
    private int mValue;

    static {
        CREATOR = new AnonymousClass1();
    }

    public Token(int r8) {
        this.mValue = r8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void readFromParcel(Parcel r8) {
        this.mValue = r8.readInt();
    }

    public String toString() {
        return "Token: " + get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.mValue);
    }

    public Token(Parcel r8) {
        this.mValue = r8.readInt();
    }
}
