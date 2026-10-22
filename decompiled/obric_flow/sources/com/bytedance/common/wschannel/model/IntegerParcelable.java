package com.bytedance.common.wschannel.model;

import a5.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3995a;

    static {
        CREATOR = new b(13);
    }

    public IntegerParcelable(Parcel r5) {
        this.f3995a = r5.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f3995a);
    }
}
