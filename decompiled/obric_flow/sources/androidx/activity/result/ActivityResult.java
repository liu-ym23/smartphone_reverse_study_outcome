package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;

    @Nullable
    private final Intent mData;
    private final int mResultCode;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ActivityResult(int r5, @Nullable Intent r10) {
        this.mResultCode = r5;
        this.mData = r10;
    }

    @NonNull
    public static String resultCodeToString(int r5) {
        if (r5 == (-1)) goto L9;
        if (r5 != 0) goto L6;
        return "RESULT_CANCELED";
    L6:
        return String.valueOf(r5);
    L9:
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r5, int r10) {
        r5.writeInt(this.mResultCode);
        if (this.mData != null) goto L5;
        int r11 = 0;
    L6:
        r5.writeInt(r11);
        Intent r12 = this.mData;
        if (r12 == null) goto L10;
        r12.writeToParcel(r5, r10);
        return;
    L10:
        return;
    L5:
        r11 = 1;
        goto L6
    }

    public ActivityResult(Parcel r5) {
        this.mResultCode = r5.readInt();
        if (r5.readInt() != 0) goto L5;
        Intent r10 = null;
    L6:
        this.mData = r10;
        return;
    L5:
        r10 = (Intent) Intent.CREATOR.createFromParcel(r5);
        goto L6
    }
}
