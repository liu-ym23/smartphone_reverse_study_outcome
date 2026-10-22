package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3883a;

    public static class a implements Parcelable.Creator<IntegerParcelable> {
        @Override // android.os.Parcelable.Creator
        public final IntegerParcelable createFromParcel(Parcel r8) {
            return new IntegerParcelable(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final IntegerParcelable[] newArray(int r8) {
            return new IntegerParcelable[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public IntegerParcelable(Parcel r8) {
        this.f3883a = r8.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f3883a);
    }
}
