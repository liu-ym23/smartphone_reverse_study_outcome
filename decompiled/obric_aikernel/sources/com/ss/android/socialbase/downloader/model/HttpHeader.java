package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = null;
    private final String name;
    private final String value;

    static class a implements Parcelable.Creator<HttpHeader> {
        a() {
        }

        public HttpHeader a(Parcel r10) {
            return new HttpHeader(r10);
        }

        public HttpHeader[] b(int r10) {
            return new HttpHeader[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HttpHeader createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HttpHeader[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    protected HttpHeader(Parcel r10) {
        this.name = r10.readString();
        this.value = r10.readString();
    }

    public HttpHeader(String r10, String r11) {
        this.name = r10;
        this.value = r11;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r10) {
        if ((r10 instanceof HttpHeader) == false) goto L16;
        HttpHeader r11 = (HttpHeader) r10;
        if (TextUtils.equals(this.name, r11.getName()) == false) goto L7;
        return 0;
    L7:
        String r12 = this.name;
        if (r12 != null) goto L10;
        return -1;
    L10:
        int r13 = r12.compareTo(r11.getName());
        if (r13 <= 0) goto L13;
        return 1;
    L13:
        if (r13 >= 0) goto L15;
        return -1;
    L15:
        return 0;
    L16:
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L17;
        HttpHeader r11 = (HttpHeader) r10;
        if (TextUtils.equals(this.name, r11.name) == false) goto L16;
        if (TextUtils.equals(this.value, r11.value) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String r10 = this.name;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.value;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "HttpHeader{name='" + this.name + "', value='" + this.value + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.name);
        r10.writeString(this.value);
    }
}
