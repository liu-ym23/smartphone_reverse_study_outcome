package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BaseException$1 implements Parcelable.Creator<BaseException> {
    public BaseException$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BaseException createFromParcel(Parcel r2) {
        return new BaseException(r2);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ BaseException[] newArray(int r1) {
        return newArray(r1);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ BaseException createFromParcel(Parcel r1) {
        return createFromParcel(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BaseException[] newArray(int r1) {
        return new BaseException[r1];
    }
}
