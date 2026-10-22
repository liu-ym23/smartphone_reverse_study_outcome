package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OComplexTaskConfig$a implements Parcelable.Creator<OComplexTaskConfig> {
    public OComplexTaskConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OComplexTaskConfig createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new OComplexTaskConfig(r5.readString(), r5.readString(), r5.readInt(), r5.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final OComplexTaskConfig[] newArray(int r1) {
        return new OComplexTaskConfig[r1];
    }
}
