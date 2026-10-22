package com.bytedance.apm.core;

import a5.b;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3861b;

    static {
        CREATOR = new b(18);
    }

    public SpPair(String r5, Object r10) {
        this.f3860a = r5;
        this.f3861b = r10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeString(this.f3860a);
        r5.writeValue(this.f3861b);
    }
}
