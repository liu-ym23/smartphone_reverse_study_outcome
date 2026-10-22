package com.bytedance.badger.x;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class A implements Parcelable {
    public static final Parcelable.Creator d = null;
    public final int a;
    public final byte[] b;
    public final int c;

    static {
        d = new g0();
    }

    public A(Parcel r2) {
        this.a = r2.readInt();
        this.b = r2.createByteArray();
        this.c = r2.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
        r1.writeByteArray(this.b);
        r1.writeInt(this.c);
    }
}
