package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AwarenessConditionConfig$b implements Parcelable.Creator<AwarenessConditionConfig> {
    public AwarenessConditionConfig$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final AwarenessConditionConfig createFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        String r0 = r7.readString();
        String r1 = r7.readString();
        int r2 = r7.readInt();
        ArrayList r3 = new ArrayList(r2);
        int r4 = 0;
    L3:
        if (r4 == r2) goto L6;
        r3.add(AwarenessConditionRule.CREATOR.createFromParcel(r7));
        r4 = r4 + 1;
        goto L3
    L6:
        return new AwarenessConditionConfig(r0, r1, r3, r7.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final AwarenessConditionConfig[] newArray(int r1) {
        return new AwarenessConditionConfig[r1];
    }
}
