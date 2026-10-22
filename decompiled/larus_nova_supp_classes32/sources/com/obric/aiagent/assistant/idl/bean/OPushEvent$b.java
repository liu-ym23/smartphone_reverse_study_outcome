package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OPushEvent$b implements Parcelable.Creator<OPushEvent> {
    public OPushEvent$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final OPushEvent createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        Object r2 = null;
        if (r5.readInt() != 0) goto L5;
        Integer r1 = null;
    L7:
        if (r5.readInt() == 0) goto L11;
        r2 = OAppAction.CREATOR.createFromParcel(r5);
    L11:
        return new OPushEvent(r1, (OAppAction) r2);
    L5:
        r1 = Integer.valueOf(r5.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final OPushEvent[] newArray(int r1) {
        return new OPushEvent[r1];
    }
}
