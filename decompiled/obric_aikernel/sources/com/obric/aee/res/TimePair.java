package com.obric.aee.res;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class TimePair implements Parcelable {
    public static final Parcelable.Creator<TimePair> CREATOR = null;
    private final long finish;
    private final String key;
    private final long start;

    public static final class a implements Parcelable.Creator<TimePair> {
        public a() {
        }

        public final TimePair a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new TimePair(r10.readString(), r10.readLong(), r10.readLong());
        }

        public final TimePair[] b(int r10) {
            return new TimePair[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimePair createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimePair[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public TimePair(String r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.key = r10;
        this.start = r11;
        this.finish = r12;
    }

    public static /* synthetic */ TimePair copy$default(TimePair r10, String r11, long r12, long r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.key;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = r10.start;
    L8:
        long r16 = r12;
        if ((r14 & 4) == 0) goto L11;
        r13 = r10.finish;
    L11:
        String r17 = r11;
        return r10.copy(r17, r16, r13);
    }

    public final String component1() {
        return this.key;
    }

    public final long component2() {
        return this.start;
    }

    public final long component3() {
        return this.finish;
    }

    public final TimePair copy(String r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return new TimePair(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TimePair) == true) goto L8;
        return false;
    L8:
        TimePair r11 = (TimePair) r10;
        if (Intrinsics.areEqual(this.key, r11.key) == true) goto L12;
        return false;
    L12:
        if (this.start == r11.start) goto L15;
        return false;
    L15:
        if (this.finish == r11.finish) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getFinish() {
        return this.finish;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + Long.hashCode(this.start)) * 31) + Long.hashCode(this.finish);
    }

    public String toString() {
        return "TimePair(key=" + this.key + ", start=" + this.start + ", finish=" + this.finish + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "out");
        r10.writeString(this.key);
        r10.writeLong(this.start);
        r10.writeLong(this.finish);
    }
}
