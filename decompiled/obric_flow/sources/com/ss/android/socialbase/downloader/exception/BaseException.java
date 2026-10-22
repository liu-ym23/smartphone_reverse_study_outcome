package com.ss.android.socialbase.downloader.exception;

import ai.j0;
import android.os.Parcel;
import android.os.Parcelable;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15603c;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BaseException(int r5, String r10) {
        super(d.b("[d-ex]:", r10));
        this.f15603c = "";
        this.f15602b = d.b("[d-ex]:", r10);
        this.f15601a = r5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder r5 = new StringBuilder("BaseException{errorCode=");
        r5.append(this.f15601a);
        r5.append(", errorMsg='");
        return j0.q(r5, this.f15602b, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f15601a);
        r5.writeString(this.f15602b);
        r5.writeString(this.f15603c);
    }

    public BaseException(int r5, String r10, Throwable r11) {
        super(d.b("[d-ex]:", r10), r11);
        this.f15603c = "";
        this.f15602b = d.b("[d-ex]:", r10);
        this.f15601a = r5;
    }

    public BaseException() {
        this.f15603c = "";
    }

    public BaseException(Parcel r5) {
        this.f15603c = "";
        this.f15601a = r5.readInt();
        this.f15602b = r5.readString();
        this.f15603c = r5.readString();
    }
}
