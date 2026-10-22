package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PeriodicPolicy$a implements Parcelable.Creator<PeriodicPolicy> {
    public PeriodicPolicy$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PeriodicPolicy createFromParcel(Parcel r18) {
        int r1 = r18.readInt();
        Intrinsics.checkNotNullParameter(r18, "parcel");
        if (r18.readInt() == 0) goto L5;
        boolean r5 = true;
    L6:
        int[] r6 = r18.createIntArray();
        int r7 = r18.readInt();
        String r8 = r18.readString();
        if (r18.readInt() == 0) goto L9;
        boolean r9 = true;
    L11:
        if (r18.readInt() == 0) goto L13;
        boolean r10 = true;
    L14:
        boolean r4 = r5;
        boolean r11 = r9;
        boolean r12 = r10;
        PeriodicPolicy r2 = new PeriodicPolicy(r4, r6, r7, r8, r11, r12, null, false, r18.readString(), 192, null);
        int r13 = Math.min(r1, 2);
        ClassLoader r14 = PeriodicPolicy$a.class.getClassLoader();
        int r15 = 1;
    L15:
        if (r15 > r13) goto L25;
        if (r15 != 1) goto L20;
        Object r16 = a.c(r18, r14);
        if (r16 == null) goto L24;
        r2.expireDate = (String) r16;
    L24:
        r15 = r15 + 1;
        goto L15
    L20:
        if (r15 != 2) goto L24;
        Object r17 = a.c(r18, r14);
        if (r17 == null) goto L24;
        r2.isSingleTask = ((Boolean) r17).booleanValue();
    L25:
        if (r15 > r1) goto L27;
        a.d(r18, r14);
        r15 = r15 + 1;
        goto L25
    L27:
        return r2;
    L13:
        r10 = false;
        goto L14
    L9:
        r9 = false;
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final PeriodicPolicy[] newArray(int r1) {
        return new PeriodicPolicy[r1];
    }
}
