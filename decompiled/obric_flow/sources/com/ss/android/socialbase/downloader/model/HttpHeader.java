package com.ss.android.socialbase.downloader.model;

import ai.j0;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15910b;

    static {
        CREATOR = new AnonymousClass1();
    }

    public HttpHeader(String r5, String r10) {
        this.f15909a = r5;
        this.f15910b = r10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        if ((r5 instanceof HttpHeader) == false) goto L16;
        HttpHeader r10 = (HttpHeader) r5;
        if (TextUtils.equals(this.f15909a, r10.f15909a) == false) goto L7;
        return 0;
    L7:
        String r11 = this.f15909a;
        if (r11 != null) goto L10;
        return -1;
    L10:
        int r12 = r11.compareTo(r10.f15909a);
        if (r12 <= 0) goto L13;
        return 1;
    L13:
        if (r12 >= 0) goto L15;
        return -1;
    L15:
        return 0;
    L16:
        return 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L15;
        HttpHeader r10 = (HttpHeader) r5;
        if (TextUtils.equals(this.f15909a, r10.f15909a) == false) goto L15;
        if (TextUtils.equals(this.f15910b, r10.f15910b) == false) goto L15;
        return true;
    }

    public final int hashCode() {
        String r5 = this.f15909a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f15910b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("HttpHeader{name='");
        r5.append(this.f15909a);
        r5.append("', value='");
        return j0.q(r5, this.f15910b, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeString(this.f15909a);
        r5.writeString(this.f15910b);
    }

    public HttpHeader(Parcel r5) {
        this.f15909a = r5.readString();
        this.f15910b = r5.readString();
    }
}
