package com.ss.android.lark.contact.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class EmailContact implements Parcelable {
    public static final Parcelable.Creator<EmailContact> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;

    public class a implements Parcelable.Creator<EmailContact> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EmailContact createFromParcel(Parcel r2) {
            return new EmailContact(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final EmailContact[] newArray(int r1) {
            return new EmailContact[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int getType() {
        return this.e;
    }

    public EmailContact(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = r2.readString();
        this.e = r2.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
    }
}
