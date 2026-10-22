package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class StateInfo$a implements Parcelable.Creator<StateInfo> {
    public StateInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final StateInfo createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new StateInfo(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final StateInfo[] newArray(int r1) {
        return new StateInfo[r1];
    }
}
