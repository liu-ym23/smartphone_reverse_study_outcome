package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardLaunchParam implements Parcelable {
    public static final Parcelable.Creator<ForwardLaunchParam> CREATOR = null;
    public int a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int POP_OVER = 0;
        public static final int WINDOW = 1;
    }

    public class a implements Parcelable.Creator<ForwardLaunchParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardLaunchParam createFromParcel(Parcel r2) {
            return new ForwardLaunchParam(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardLaunchParam[] newArray(int r1) {
            return new ForwardLaunchParam[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardLaunchParam() {
    }

    public ForwardLaunchParam(Parcel r1) {
        this.a = r1.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
    }
}
