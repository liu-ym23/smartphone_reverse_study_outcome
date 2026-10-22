package com.obric.memorydata.sdk.awareness.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GeoFenceInfo$a implements Parcelable.Creator<GeoFenceInfo> {
    public GeoFenceInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final GeoFenceInfo createFromParcel(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r6 = r5.readString();
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        GeoFenceInfo r2 = null;
        Object r3 = null;
        if (r1 == false) goto L31;
    L28:
        if (r2 == null) goto L30;
        return r2;
    L30:
        return new GeoFenceInfo(0);
    L31:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        GeoFenceInfo r7 = (GeoFenceInfo) qka.a.a.fromJson(r6, GeoFenceInfo.class);     // Catch: Throwable -> L21
        if (r7 != null) goto L15;
        GeoFenceInfo r8 = null;
    L19:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r9) == true) goto L27;
        r3 = r9;
    L27:
        r2 = (GeoFenceInfo) r3;
        goto L28
    L15:
        String r10 = r7.a();     // Catch: Throwable -> L21
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r8 = new GeoFenceInfo(r10);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L5:
        if (StringsKt.isBlank(r6) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final GeoFenceInfo[] newArray(int r1) {
        return new GeoFenceInfo[r1];
    }
}
