package com.bytedance.frameworks.plugin.dependency;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class BaseAttribute implements Parcelable {
    public static final Parcelable.Creator<BaseAttribute> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3939b;

    public static class a implements Parcelable.Creator<BaseAttribute> {
        @Override // android.os.Parcelable.Creator
        public final BaseAttribute createFromParcel(Parcel r8) {
            return new BaseAttribute(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final BaseAttribute[] newArray(int r8) {
            return new BaseAttribute[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseAttribute() {
    }

    public BaseAttribute(Parcel r8) {
        this.f3938a = r8.readString();
        this.f3939b = r8.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L20;
        BaseAttribute r10 = (BaseAttribute) r8;
        if (this.f3939b == r10.f3939b) goto L13;
        return false;
    L13:
        String r11 = r10.f3938a;
        String r12 = this.f3938a;
        if (r12 != null) goto L21;
        if (r11 != null) goto L19;
        return true;
    L19:
        return false;
    L21:
        return r12.equals(r11);
    }

    public final int hashCode() {
        String r8 = this.f3938a;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L7:
        return (r10 * 31) + this.f3939b;
    L5:
        r10 = 0;
        goto L7
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeString(this.f3938a);
        r8.writeInt(this.f3939b);
    }
}
