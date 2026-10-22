package com.ttnet.org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = null;
    private final long mHigh;
    private final long mLow;

    static {
        CREATOR = new AnonymousClass1();
    }

    private UnguessableToken(long r10, long r11) {
        this.mHigh = r10;
        this.mLow = r11;
    }

    /* synthetic */ UnguessableToken(long r10, long r11, AnonymousClass1 r12) {
        this(r10, r11);
    }

    @CalledByNative
    private static UnguessableToken create(long r10, long r11) {
        return new UnguessableToken(r10, r11);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel r10 = Parcel.obtain();
        writeToParcel(r10, 0);
        r10.setDataPosition(0);
        UnguessableToken r11 = CREATOR.createFromParcel(r10);
        r10.recycle();
        return r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (getClass() != r10.getClass()) goto L16;
        UnguessableToken r11 = (UnguessableToken) r10;
        if (r11.mHigh == this.mHigh) goto L10;
        return false;
    L10:
        if (r11.mLow != this.mLow) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    public int hashCode() {
        long r10 = this.mLow;
        int r11 = (int) (r10 ^ (r10 >>> 32));
        long r12 = this.mHigh;
        int r13 = r11 * 31;
        return r13 + ((int) ((r12 >>> 32) ^ r12));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeLong(this.mHigh);
        r10.writeLong(this.mLow);
    }
}
