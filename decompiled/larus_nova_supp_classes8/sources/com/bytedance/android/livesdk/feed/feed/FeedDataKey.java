package com.bytedance.android.livesdk.feed.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedDataKey implements Parcelable {
    public static final Parcelable.Creator<FeedDataKey> CREATOR = null;
    public static final Integer e = null;
    public static final Integer f = null;
    public final String a;
    public final String b;
    public final long c;
    public final int d;

    public class a implements Parcelable.Creator<FeedDataKey> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDataKey createFromParcel(Parcel r8) {
            return new FeedDataKey(r8.readString(), r8.readString(), r8.readLong(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDataKey[] newArray(int r1) {
            return new FeedDataKey[r1];
        }
    }

    static {
        e = 1;
        f = 31;
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        Integer r0 = f;
        int r1 = r0.intValue();
        String r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = r1 + r4;
        int r6 = r0.intValue() * r5;
        String r7 = this.a;
        if (r7 == null) goto L9;
        r3 = r7.hashCode();
    L9:
        int r8 = r0.intValue();
        return (r8 * (r6 + r3)) + Long.valueOf(this.c).hashCode();
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("label: ");
        String r1 = this.b;
        String r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append("; url: ");
        String r3 = this.a;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append("; id: ");
        r0.append(this.c);
        r0.append("; repeatCheck: ");
        r0.append(this.d);
        return r0.toString();
    }

    public final boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof FeedDataKey) == false) goto L19;
        FeedDataKey r7 = (FeedDataKey) r6;
        if (TextUtils.equals(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(this.a, r7.a) == true) goto L12;
        return false;
    L12:
        if (this.c != r7.c) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.b);
        r3.writeString(this.a);
        r3.writeLong(this.c);
        r3.writeInt(this.d);
    }

    public static FeedDataKey a(String r7, String r8, long r9) {
        int r6 = e.intValue();
        if (TextUtils.isEmpty(r7) == true) goto L7;
        return new FeedDataKey(r7, r8, r9, r6);
    L7:
        throw new IllegalArgumentException("label must not be null or empty");
    }

    public FeedDataKey(String r3, String r4, long r5, int r7) {
        this.a = "";
        this.b = "";
        this.c = Long.MIN_VALUE;
        this.d = e.intValue();
        this.b = r3;
        this.a = r4;
        this.c = r5;
        this.d = r7;
    }
}
