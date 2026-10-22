package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ConditionTaskResult$a implements Parcelable.Creator<ConditionTaskResult> {
    public ConditionTaskResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTaskResult createFromParcel(Parcel r10) {
        int r0 = r10.readInt();
        Intrinsics.checkNotNullParameter(r10, "parcel");
        int r1 = r10.readInt();
        String r2 = r10.readString();
        ArrayList r5 = null;
        if (r10.readInt() == 0) goto L13;
        int r3 = r10.readInt();
        ArrayList r6 = new ArrayList(r3);
        int r7 = 0;
    L6:
        if (r7 == r3) goto L12;
        if (r10.readInt() != 0) goto L10;
        Object r8 = null;
    L11:
        r6.add(r8);
        r7 = r7 + 1;
        goto L6
    L10:
        r8 = ConditionTask.CREATOR.createFromParcel(r10);
        goto L11
    L12:
        r5 = r6;
    L13:
        ConditionTaskResult r4 = new ConditionTaskResult(r1, r2, r5);
        int r9 = Math.min(r0, 0);
        ClassLoader r11 = ConditionTaskResult$a.class.getClassLoader();
        int r12 = 1;
    L14:
        if (r12 > r9) goto L16;
        r12 = r12 + 1;
    L16:
        if (r12 > r0) goto L18;
        a.d(r10, r11);
        r12 = r12 + 1;
        goto L16
    L18:
        return r4;
    }

    @Override // android.os.Parcelable.Creator
    public final ConditionTaskResult[] newArray(int r1) {
        return new ConditionTaskResult[r1];
    }
}
