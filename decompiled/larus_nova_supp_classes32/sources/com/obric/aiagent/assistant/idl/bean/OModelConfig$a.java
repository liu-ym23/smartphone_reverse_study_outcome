package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OModelConfig$a implements Parcelable.Creator<OModelConfig> {
    public OModelConfig$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OModelConfig createFromParcel(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        return new OModelConfig(r6.readString(), r6.readString(), r6.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final OModelConfig[] newArray(int r1) {
        return new OModelConfig[r1];
    }
}
