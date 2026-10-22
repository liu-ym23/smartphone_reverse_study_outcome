package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AppNotification$a implements Parcelable.Creator<AppNotification> {
    public AppNotification$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AppNotification createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new AppNotification(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final AppNotification[] newArray(int r1) {
        return new AppNotification[r1];
    }
}
