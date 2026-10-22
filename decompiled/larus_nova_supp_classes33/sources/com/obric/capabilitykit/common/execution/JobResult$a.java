package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class JobResult$a implements Parcelable.Creator<JobResult> {
    public JobResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final JobResult createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        long r3 = r12.readLong();
        int r9 = 1;
        if (r12.readInt() == 0) goto L5;
        boolean r5 = true;
    L6:
        String r6 = r12.readString();
        int r1 = r12.readInt();
        ArrayList r7 = new ArrayList(r1);
        int r2 = 0;
    L7:
        if (r2 == r1) goto L9;
        r7.add(IntentExecutionRecord.CREATOR.createFromParcel(r12));
        r2 = r2 + 1;
        goto L7
    L9:
        JobResult r4 = new JobResult(r3, r5, r6, r7);
        int r8 = Math.min(r0, 0);
        ClassLoader r10 = JobResult$a.class.getClassLoader();
    L10:
        if (r9 > r8) goto L12;
        r9 = r9 + 1;
    L12:
        if (r9 > r0) goto L14;
        a.d(r12, r10);
        r9 = r9 + 1;
        goto L12
    L14:
        return r4;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final JobResult[] newArray(int r1) {
        return new JobResult[r1];
    }
}
