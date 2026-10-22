package com.ss.android.lark.forseti.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "placeMode", "Lcom/ss/android/lark/api/bean/ForsetiMode;", "getPlaceMode", "()Lcom/ss/android/lark/api/bean/ForsetiMode;", "setPlaceMode", "(Lcom/ss/android/lark/api/bean/ForsetiMode;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiAttachInfo implements Parcelable {
    public static final a CREATOR = null;
    public ForsetiMode a;

    public static final class a implements Parcelable.Creator<ForsetiAttachInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiAttachInfo createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            ForsetiAttachInfo r1 = new ForsetiAttachInfo();
            ForsetiMode r4 = r3.readParcelable(ForsetiMode.class.getClassLoader());
            if (r4 != null) goto L5;
            r4 = r1.a;
        L5:
            r1.a = r4;
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiAttachInfo[] newArray(int r1) {
            return new ForsetiAttachInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForsetiAttachInfo() {
        this.a = ForsetiMode.Unknown;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.a, r3);
    }
}
