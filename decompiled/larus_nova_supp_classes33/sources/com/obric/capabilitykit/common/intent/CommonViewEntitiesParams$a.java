package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CommonViewEntitiesParams$a implements Parcelable.Creator<CommonViewEntitiesParams> {
    public CommonViewEntitiesParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CommonViewEntitiesParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        AppEntity[] r2 = null;
        if (r8.readInt() != 0) goto L5;
        Integer r1 = null;
    L7:
        if (r8.readInt() == 0) goto L13;
        int r3 = r8.readInt();
        AppEntity[] r4 = new AppEntity[r3];
        int r5 = 0;
    L10:
        if (r5 == r3) goto L12;
        r4[r5] = (AppEntity) r8.readParcelable(CommonViewEntitiesParams.class.getClassLoader());
        r5 = r5 + 1;
        goto L10
    L12:
        r2 = r4;
    L13:
        CommonViewEntitiesParams r6 = new CommonViewEntitiesParams(r1, r2);
        int r7 = Math.min(r0, 0);
        ClassLoader r9 = CommonViewEntitiesParams$a.class.getClassLoader();
        int r10 = 1;
    L14:
        if (r10 > r7) goto L16;
        r10 = r10 + 1;
    L16:
        if (r10 > r0) goto L18;
        a.d(r8, r9);
        r10 = r10 + 1;
        goto L16
    L18:
        return r6;
    L5:
        r1 = Integer.valueOf(r8.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final CommonViewEntitiesParams[] newArray(int r1) {
        return new CommonViewEntitiesParams[r1];
    }
}
