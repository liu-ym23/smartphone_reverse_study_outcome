package com.loc;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class em implements Parcelable {
    public static final Parcelable.Creator<em> CREATOR = null;
    public long a;
    public long b;
    public long c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public static class a implements Parcelable.Creator<em> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final em createFromParcel(Parcel r4) {
            em r0 = new em();
            r0.e = r4.readString();
            r0.f = r4.readString();
            r0.g = r4.readString();
            r0.h = r4.readString();
            r0.j = r4.readString();
            r0.a = r4.readLong();
            r0.b = r4.readLong();
            r0.c = r4.readLong();
            r0.d = r4.readLong();
            r0.i = r4.readString();
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final em[] newArray(int r1) {
            return new em[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public em() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.g = "first";
        this.h = NameKeys.UnloadStrategy_No_Strategy;
        this.i = NameKeys.UnloadStrategy_No_Strategy;
        this.j = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.e);     // Catch: Throwable -> L4
        r3.writeString(this.f);     // Catch: Throwable -> L4
        r3.writeString(this.g);     // Catch: Throwable -> L4
        r3.writeString(this.h);     // Catch: Throwable -> L4
        r3.writeString(this.j);     // Catch: Throwable -> L4
        r3.writeLong(this.a);     // Catch: Throwable -> L4
        r3.writeLong(this.b);     // Catch: Throwable -> L4
        r3.writeLong(this.c);     // Catch: Throwable -> L4
        r3.writeLong(this.d);     // Catch: Throwable -> L4
        r3.writeString(this.i);     // Catch: Throwable -> L4
        return;
    }
}
