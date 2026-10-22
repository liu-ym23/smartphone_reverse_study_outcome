package com.obric.memorydata.sdk.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PermissionCheckResult$a implements Parcelable.Creator<PermissionCheckResult> {
    public PermissionCheckResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PermissionCheckResult createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        return (PermissionCheckResult) GsonProtectorUtils.fromJson(UtilsKt.a(), r3.readString(), PermissionCheckResult.class);
    }

    @Override // android.os.Parcelable.Creator
    public final PermissionCheckResult[] newArray(int r1) {
        return new PermissionCheckResult[r1];
    }
}
