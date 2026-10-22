package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LocationInfo$AoiInfo$a implements Parcelable.Creator<LocationInfo.AoiInfo> {
    public LocationInfo$AoiInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final LocationInfo.AoiInfo createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r6 = r5.readString();
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        LocationInfo.AoiInfo r2 = null;
        Object r3 = null;
        if (r1 == false) goto L28;
    L25:
        if (r2 == null) goto L27;
        return r2;
    L27:
        return new LocationInfo.AoiInfo(0);
    L28:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        LocationInfo.AoiInfo r7 = (LocationInfo.AoiInfo) a.a.fromJson(r6, LocationInfo.AoiInfo.class);     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        LocationInfo.AoiInfo r8 = a.a(r7);     // Catch: Throwable -> L18
    L16:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r9) == true) goto L24;
        r3 = r9;
    L24:
        r2 = (LocationInfo.AoiInfo) r3;
        goto L25
    L15:
        r8 = null;
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final LocationInfo.AoiInfo[] newArray(int r1) {
        return new LocationInfo.AoiInfo[r1];
    }
}
