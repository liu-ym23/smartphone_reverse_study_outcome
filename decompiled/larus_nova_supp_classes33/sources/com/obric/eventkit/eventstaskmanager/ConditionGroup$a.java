package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ConditionGroup$a implements Parcelable.Creator<ConditionGroup> {
    public ConditionGroup$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionGroup createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        String r1 = r8.readString();
        int r2 = r8.readInt();
        ArrayList r3 = new ArrayList(r2);
        int r5 = 0;
    L3:
        if (r5 == r2) goto L5;
        r3.add(r8.readParcelable(ConditionGroup.class.getClassLoader()));
        r5 = r5 + 1;
        goto L3
    L5:
        ConditionGroup r4 = new ConditionGroup(r1, r3);
        int r6 = Math.min(r0, 0);
        ClassLoader r7 = ConditionGroup$a.class.getClassLoader();
        int r9 = 1;
    L6:
        if (r9 > r6) goto L8;
        r9 = r9 + 1;
    L8:
        if (r9 > r0) goto L10;
        a.d(r8, r7);
        r9 = r9 + 1;
        goto L8
    L10:
        return r4;
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionGroup[] newArray(int r1) {
        return new ConditionGroup[r1];
    }
}
