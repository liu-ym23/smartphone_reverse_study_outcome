package com.obric.cae.libs.nfc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class CaeNfcCardSwitchResult implements Parcelable {
    public static final Parcelable.Creator<CaeNfcCardSwitchResult> CREATOR = null;
    public static final int RESULT_ACTIVATION_FAILED = 7;
    public static final int RESULT_AMBIGUOUS_ACTIVE_CARD = 5;
    public static final int RESULT_DEACTIVATION_FAILED = 6;
    public static final int RESULT_INVALID_ARGUMENT = 2;
    public static final int RESULT_NO_CHANGE = 1;
    public static final int RESULT_QUERY_FAILED = 3;
    public static final int RESULT_SE_UNAVAILABLE = 8;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_TARGET_NOT_INSTALLED = 4;
    private final int mActivationStatusWord;
    private final int mDeactivationStatusWord;
    private final long mEndBoottimeNs;
    private final String mPreviousCardIdentifier;
    private final int mResultCode;
    private final long mStartBoottimeNs;
    private final String mTargetCardIdentifier;

    public class a implements Parcelable.Creator<CaeNfcCardSwitchResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardSwitchResult createFromParcel(Parcel r1) {
            return new CaeNfcCardSwitchResult(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardSwitchResult[] newArray(int r1) {
            return new CaeNfcCardSwitchResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeNfcCardSwitchResult(int r1, String r2, String r3, int r4, int r5, long r6, long r8) {
        this.mResultCode = r1;
        this.mPreviousCardIdentifier = r2;
        this.mTargetCardIdentifier = r3;
        this.mDeactivationStatusWord = r4;
        this.mActivationStatusWord = r5;
        this.mStartBoottimeNs = r6;
        this.mEndBoottimeNs = r8;
    }

    public CaeNfcCardSwitchResult(Parcel r3) {
        this.mResultCode = r3.readInt();
        this.mPreviousCardIdentifier = r3.readString();
        this.mTargetCardIdentifier = r3.readString();
        this.mDeactivationStatusWord = r3.readInt();
        this.mActivationStatusWord = r3.readInt();
        this.mStartBoottimeNs = r3.readLong();
        this.mEndBoottimeNs = r3.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActivationStatusWord() {
        return this.mActivationStatusWord;
    }

    public int getDeactivationStatusWord() {
        return this.mDeactivationStatusWord;
    }

    public long getEndBoottimeNs() {
        return this.mEndBoottimeNs;
    }

    public String getPreviousCardIdentifier() {
        return this.mPreviousCardIdentifier;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public long getStartBoottimeNs() {
        return this.mStartBoottimeNs;
    }

    public String getTargetCardIdentifier() {
        return this.mTargetCardIdentifier;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mResultCode);
        r3.writeString(this.mPreviousCardIdentifier);
        r3.writeString(this.mTargetCardIdentifier);
        r3.writeInt(this.mDeactivationStatusWord);
        r3.writeInt(this.mActivationStatusWord);
        r3.writeLong(this.mStartBoottimeNs);
        r3.writeLong(this.mEndBoottimeNs);
    }
}
