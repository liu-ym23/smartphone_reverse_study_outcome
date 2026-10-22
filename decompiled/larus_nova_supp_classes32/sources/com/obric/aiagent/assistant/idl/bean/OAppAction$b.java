package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OAppAction$b implements Parcelable.Creator<OAppAction> {
    public OAppAction$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final OAppAction createFromParcel(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        return new OAppAction(r13.readInt(), r13.readLong(), r13.readLong(), r13.readLong(), r13.readString(), r13.readInt(), r13.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final OAppAction[] newArray(int r1) {
        return new OAppAction[r1];
    }
}
