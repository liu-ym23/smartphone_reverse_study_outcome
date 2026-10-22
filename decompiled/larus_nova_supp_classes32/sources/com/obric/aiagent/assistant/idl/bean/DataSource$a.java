package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DataSource$a implements Parcelable.Creator<DataSource> {
    public DataSource$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DataSource createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        return new DataSource(r4.readString(), r4.readString(), r4.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final DataSource[] newArray(int r1) {
        return new DataSource[r1];
    }
}
