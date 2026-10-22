package com.ss.android.lark.conditional.access.nopermission.manager;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/manager/DialogInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "title", BuildConfig.FLAVOR, "getTitle", "()I", "setTitle", "(I)V", "content", "getContent", "setContent", "primaryButton", "getPrimaryButton", "setPrimaryButton", "describeContents", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DialogInfo implements Parcelable {
    public static final Parcelable.Creator<DialogInfo> CREATOR = null;
    public int a;
    public int b;
    public int c;

    public static final class a implements Parcelable.Creator<DialogInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DialogInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            r2.readInt();
            return new DialogInfo();
        }

        @Override // android.os.Parcelable.Creator
        public final DialogInfo[] newArray(int r1) {
            return new DialogInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DialogInfo() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(1);
    }
}
