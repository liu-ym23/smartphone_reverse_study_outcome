package com.google.android.material.timepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5150b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f5151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f5152n;

    public class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        public final TimeModel createFromParcel(Parcel r8) {
            return new TimeModel(r8.readInt(), r8.readInt(), r8.readInt(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeModel[] newArray(int r8) {
            return new TimeModel[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public TimeModel() {
        this(0, 0, 10, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TimeModel) == true) goto L8;
        return false;
    L8:
        TimeModel r10 = (TimeModel) r8;
        int r11 = r10.f5150b;
        if (this.f5150b != r11) goto L18;
        if (this.f5151m != r10.f5151m) goto L18;
        if (this.f5149a != r10.f5149a) goto L18;
        if (this.f5152n != r10.f5152n) goto L18;
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5149a), Integer.valueOf(this.f5150b), Integer.valueOf(this.f5151m), Integer.valueOf(this.f5152n)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f5150b);
        r8.writeInt(this.f5151m);
        r8.writeInt(this.f5152n);
        r8.writeInt(this.f5149a);
    }

    public TimeModel(int r8, int r10, int r11, int r12) {
        this.f5150b = r8;
        this.f5151m = r10;
        this.f5152n = r11;
        this.f5149a = r12;
    }
}
