package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class HeifOutputOption$a implements Parcelable.Creator<HeifOutputOption> {
    public HeifOutputOption$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final HeifOutputOption createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new HeifOutputOption(r5.readInt(), r5.readInt(), r5.readInt(), r5.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final HeifOutputOption[] newArray(int r1) {
        return new HeifOutputOption[r1];
    }
}
