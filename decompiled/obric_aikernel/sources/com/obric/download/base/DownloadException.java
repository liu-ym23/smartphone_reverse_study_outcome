package com.obric.download.base;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00172\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001\u0018B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/obric/download/base/DownloadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorCode", "I", "getErrorCode", "()I", "<init>", "(Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "base_release"}, k = 1, mv = {1, 4, 3})
public final class DownloadException extends Exception implements Parcelable {
    public static final a CREATOR = null;
    private final int errorCode;
    private final String errorMsg;

    public static final class a implements Parcelable.Creator<DownloadException> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public DownloadException a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new DownloadException(r10);
        }

        public DownloadException[] b(int r10) {
            return new DownloadException[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadException createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DownloadException[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public DownloadException(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r11 = r10.readString();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        Intrinsics.checkNotNullExpressionValue(r11, "parcel.readString() ?: \"\"");
        this(r11, r10.readInt());
    }

    public DownloadException(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "errorMsg");
        super(r10);
        this.errorMsg = r10;
        this.errorCode = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeString(this.errorMsg);
        r10.writeInt(this.errorCode);
    }
}
