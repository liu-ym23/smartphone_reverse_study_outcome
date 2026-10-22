package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RealTimeContext$b implements Parcelable.Creator<RealTimeContext> {
    public RealTimeContext$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final RealTimeContext createFromParcel(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        int r0 = r10.readInt();
        ArrayList r2 = new ArrayList(r0);
        int r1 = 0;
        int r3 = 0;
    L3:
        if (r3 == r0) goto L5;
        r2.add(r10.readParcelable(RealTimeContext.class.getClassLoader()));
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = r10.readInt();
        ArrayList r5 = new ArrayList(r4);
        int r6 = 0;
    L6:
        if (r6 == r4) goto L8;
        r5.add(r10.readParcelable(RealTimeContext.class.getClassLoader()));
        r6 = r6 + 1;
        goto L6
    L8:
        int r7 = r10.readInt();
        ArrayList r8 = new ArrayList(r7);
        int r9 = 0;
    L9:
        if (r9 == r7) goto L11;
        r8.add(r10.readParcelable(RealTimeContext.class.getClassLoader()));
        r9 = r9 + 1;
        goto L9
    L11:
        int r11 = r10.readInt();
        ArrayList r12 = new ArrayList(r11);
    L12:
        if (r1 == r11) goto L15;
        r12.add(r10.readParcelable(RealTimeContext.class.getClassLoader()));
        r1 = r1 + 1;
        goto L12
    L15:
        return new RealTimeContext(r2, r5, r8, r12, r10.readString(), r10.readString(), r10.readString());
    }

    @Override // android.os.Parcelable.Creator
    public final RealTimeContext[] newArray(int r1) {
        return new RealTimeContext[r1];
    }
}
