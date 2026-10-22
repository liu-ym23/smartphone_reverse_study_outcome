package com.ss.android.lark.profile.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ErrorResultWrapper implements Parcelable {
    public static final Parcelable.Creator<ErrorResultWrapper> CREATOR = null;
    public final ErrorResult a;

    public class a implements Parcelable.Creator<ErrorResultWrapper> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorResultWrapper createFromParcel(Parcel r2) {
            return new ErrorResultWrapper(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ErrorResultWrapper[] newArray(int r1) {
            return new ErrorResultWrapper[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ErrorResultWrapper(Parcel r1) {
        this.a = r1.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeSerializable(this.a);
    }
}
