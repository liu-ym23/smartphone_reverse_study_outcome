package com.ss.android.lark.contact.base.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Contact implements Parcelable, Serializable {
    public static final Parcelable.Creator<Contact> CREATOR = null;
    protected String avatarKey;
    protected String chatterId;
    protected String displayName;

    public class a implements Parcelable.Creator<Contact> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Contact createFromParcel(Parcel r2) {
            return new Contact(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Contact[] newArray(int r1) {
            return new Contact[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getChatterId() {
        return this.chatterId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Contact(Parcel r2) {
        this.chatterId = r2.readString();
        this.avatarKey = r2.readString();
        this.displayName = r2.readString();
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setChatterId(String r1) {
        this.chatterId = r1;
    }

    public void setDisplayName(String r1) {
        this.displayName = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.chatterId);
        r1.writeString(this.avatarKey);
        r1.writeString(this.displayName);
    }

    public Contact(String r1, String r2, String r3) {
        this.chatterId = r1;
        this.avatarKey = r2;
        this.displayName = r3;
    }
}
