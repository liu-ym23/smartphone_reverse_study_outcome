package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ConditionTask$a implements Parcelable.Creator<ConditionTask> {
    public ConditionTask$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTask createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        Object r3 = EventTask.CREATOR.createFromParcel(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTask");
        return (ConditionTask) r3;
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTask[] newArray(int r1) {
        return new ConditionTask[r1];
    }
}
