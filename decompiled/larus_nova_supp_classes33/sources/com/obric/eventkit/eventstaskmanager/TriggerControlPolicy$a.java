package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TriggerControlPolicy$a implements Parcelable.Creator<TriggerControlPolicy> {
    public TriggerControlPolicy$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TriggerControlPolicy createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        int r4 = 1;
        Long r5 = null;
        if (r8.readInt() != 0) goto L6;
        Boolean r2 = null;
    L11:
        if (r8.readInt() == 0) goto L14;
        r5 = Long.valueOf(r8.readLong());
    L14:
        TriggerControlPolicy r1 = new TriggerControlPolicy(r2, r5);
        int r3 = Math.min(r0, 0);
        ClassLoader r6 = TriggerControlPolicy$a.class.getClassLoader();
    L15:
        if (r4 > r3) goto L17;
        r4 = r4 + 1;
    L17:
        if (r4 > r0) goto L19;
        a.d(r8, r6);
        r4 = r4 + 1;
        goto L17
    L19:
        return r1;
    L6:
        if (r8.readInt() == 0) goto L8;
        boolean r7 = true;
    L9:
        r2 = Boolean.valueOf(r7);
        goto L11
    L8:
        r7 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final TriggerControlPolicy[] newArray(int r1) {
        return new TriggerControlPolicy[r1];
    }
}
