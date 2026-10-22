package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TimerTask$a implements Parcelable.Creator<TimerTask> {
    public TimerTask$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TimerTask createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new TimerTask(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final TimerTask[] newArray(int r1) {
        return new TimerTask[r1];
    }
}
