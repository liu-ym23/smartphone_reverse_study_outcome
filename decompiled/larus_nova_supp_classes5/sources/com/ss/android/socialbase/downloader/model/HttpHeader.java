package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = null;
    private final String name;
    private final String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.value;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "HttpHeader{name='" + this.name + "', value='" + this.value + "'}";
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public HttpHeader(Parcel r2) {
        this.name = r2.readString();
        this.value = r2.readString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r5) {
        if ((r5 instanceof HttpHeader) == false) goto L16;
        HttpHeader r6 = (HttpHeader) r5;
        if (TextUtils.equals(this.name, r6.getName()) == false) goto L7;
        return 0;
    L7:
        String r0 = this.name;
        if (r0 != null) goto L10;
        return -1;
    L10:
        int r7 = r0.compareTo(r6.getName());
        if (r7 <= 0) goto L13;
        return 1;
    L13:
        if (r7 >= 0) goto L15;
        return -1;
    L15:
        return 0;
    L16:
        return 1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        HttpHeader r6 = (HttpHeader) r5;
        if (TextUtils.equals(this.name, r6.name) == true) goto L13;
    L15:
        return false;
    L13:
        if (TextUtils.equals(this.value, r6.value) == false) goto L15;
        return true;
    }

    public HttpHeader(String r1, String r2) {
        this.name = r1;
        this.value = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.name);
        r1.writeString(this.value);
    }
}
