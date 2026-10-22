package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TimerTaskResult$a implements Parcelable.Creator<TimerTaskResult> {
    public static TimerTaskResult a(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        return new TimerTaskResult(r1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ TimerTaskResult createFromParcel(Parcel r1) {
        return a(r1);
    }

    public TimerTaskResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TimerTaskResult[] newArray(int r1) {
        return new TimerTaskResult[r1];
    }
}
