package com.ttnet.org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = null;
    private final long mHigh;
    private final long mLow;

    static {
        CREATOR = new AnonymousClass1();
    }

    private UnguessableToken(long r8, long r10) {
        this.mHigh = r8;
        this.mLow = r10;
    }

    @CalledByNative
    private static UnguessableToken create(long r8, long r10) {
        return new UnguessableToken(r8, r10);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel r8 = Parcel.obtain();
        writeToParcel(r8, 0);
        r8.setDataPosition(0);
        UnguessableToken r10 = CREATOR.createFromParcel(r8);
        r8.recycle();
        return r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.mHigh);
        r8.writeLong(this.mLow);
    }

    public /* synthetic */ UnguessableToken(long r8, long r10, AnonymousClass1 r11) {
        this(r8, r10);
    }
}
