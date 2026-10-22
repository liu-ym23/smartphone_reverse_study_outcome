package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IslandCardSession$a implements Parcelable.Creator<IslandCardSession> {
    public IslandCardSession$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final IslandCardSession createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        return new IslandCardSession(r5.readInt(), r5.readLong());
    }

    @Override // android.os.Parcelable.Creator
    public final IslandCardSession[] newArray(int r1) {
        return new IslandCardSession[r1];
    }
}
