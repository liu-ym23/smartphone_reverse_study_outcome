package com.obric.memorydata.sdk.entity.search.userprofile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class UserProfileMemoryResult$a implements Parcelable.Creator<UserProfileMemoryResult> {
    public UserProfileMemoryResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final UserProfileMemoryResult createFromParcel(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        return new UserProfileMemoryResult(r2);
    }

    @Override // android.os.Parcelable.Creator
    public final UserProfileMemoryResult[] newArray(int r1) {
        return new UserProfileMemoryResult[r1];
    }
}
