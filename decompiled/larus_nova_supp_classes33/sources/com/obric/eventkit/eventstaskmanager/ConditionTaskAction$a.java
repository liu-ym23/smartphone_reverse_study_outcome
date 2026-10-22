package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ConditionTaskAction$a implements Parcelable.Creator<ConditionTaskAction> {
    public ConditionTaskAction$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTaskAction createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        ConditionTaskAction r1 = new ConditionTaskAction(r6);
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = ConditionTaskAction$a.class.getClassLoader();
        int r4 = 1;
    L3:
        if (r4 > r2) goto L5;
        r4 = r4 + 1;
    L5:
        if (r4 > r0) goto L7;
        a.d(r6, r3);
        r4 = r4 + 1;
        goto L5
    L7:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTaskAction[] newArray(int r1) {
        return new ConditionTaskAction[r1];
    }
}
