package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ActiveAgentEvent$a implements Parcelable.Creator<ActiveAgentEvent> {
    public ActiveAgentEvent$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ActiveAgentEvent createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final ActiveAgentEvent[] newArray(int r1) {
        return new ActiveAgentEvent[r1];
    }
}
