package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ViewTreeOption$a implements Parcelable.Creator<ViewTreeOption> {
    public ViewTreeOption$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ViewTreeOption createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        if (r5.readInt() == 0) goto L5;
        boolean r1 = true;
    L7:
        return new ViewTreeOption(r1, r5.readLong());
    L5:
        r1 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ViewTreeOption[] newArray(int r1) {
        return new ViewTreeOption[r1];
    }
}
