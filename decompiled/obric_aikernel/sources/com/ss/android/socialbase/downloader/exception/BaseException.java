package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.utils.g;

/* JADX INFO: loaded from: classes2.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = null;
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    static class a implements Parcelable.Creator<BaseException> {
        a() {
        }

        public BaseException a(Parcel r10) {
            return new BaseException(r10);
        }

        public BaseException[] b(int r10) {
            return new BaseException[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BaseException createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BaseException[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseException() {
        this.extraInfo = "";
    }

    public BaseException(int r10, String r11) {
        super(TAG + r11);
        this.extraInfo = "";
        this.errorMsg = TAG + r11;
        this.errorCode = r10;
    }

    public BaseException(int r10, String r11, Throwable r12) {
        super(TAG + r11, r12);
        this.extraInfo = "";
        this.errorMsg = TAG + r11;
        this.errorCode = r10;
    }

    public BaseException(int r10, Throwable r11) {
        this(r10, g.G(r11));
    }

    protected BaseException(Parcel r10) {
        this.extraInfo = "";
        readFromParcel(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void readFromParcel(Parcel r10) {
        this.errorCode = r10.readInt();
        this.errorMsg = r10.readString();
        this.extraInfo = r10.readString();
    }

    public void setErrorMsg(String r10) {
        this.errorMsg = r10;
    }

    public void setExtraInfo(String r10) {
        this.extraInfo = r10;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.errorCode);
        r10.writeString(this.errorMsg);
        r10.writeString(this.extraInfo);
    }
}
