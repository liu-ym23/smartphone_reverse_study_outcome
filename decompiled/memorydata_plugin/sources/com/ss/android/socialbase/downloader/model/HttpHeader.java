package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class HttpHeader implements Parcelable, Comparable {
    public static final Parcelable.Creator<HttpHeader> CREATOR = null;
    private final String name;
    private final String value;

    static {
        CREATOR = new AnonymousClass1();
    }

    public HttpHeader(Parcel r2) {
        this.name = r2.readString();
        this.value = r2.readString();
    }

    public HttpHeader(String r1, String r2) {
        this.name = r1;
        this.value = r2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, HttpHeader.class) == true) goto L5;
        return 1;
    L5:
        if (TextUtils.equals(this.name, ((HttpHeader) ZeusTransformUtils.preCheckCast(r6, HttpHeader.class, "com.obric.memorydata.plugin")).getName()) == false) goto L7;
        return 0;
    L7:
        String r5 = this.name;
        if (r5 != null) goto L10;
        return -1;
    L10:
        int r7 = r5.compareTo(((HttpHeader) ZeusTransformUtils.preCheckCast(r6, HttpHeader.class, "com.obric.memorydata.plugin")).getName());
        if (r7 <= 0) goto L13;
        return 1;
    L13:
        if (r7 >= 0) goto L15;
        return -1;
    L15:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
        HttpHeader r6 = (HttpHeader) ZeusTransformUtils.preCheckCast(r5, HttpHeader.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(this.name, r6.name) == false) goto L16;
        if (TextUtils.equals(this.value, r6.value) == false) goto L16;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.name);
        r1.writeString(this.value);
    }
}
