package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SystemAutoActionParams$a implements Parcelable.Creator<SystemAutoActionParams> {
    public SystemAutoActionParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final SystemAutoActionParams createFromParcel(Parcel r14) {
        int r0 = r14.readInt();
        Intrinsics.checkNotNullParameter(r14, "parcel");
        SystemAutoActionParams r1 = new SystemAutoActionParams(r14.readString(), r14.readString(), null, null, null, null, null, null, 252, null);
        int r3 = Math.min(r0, 6);
        ClassLoader r4 = SystemAutoActionParams$a.class.getClassLoader();
        int r6 = 1;
    L3:
        if (r6 > r3) goto L33;
        if (r6 != 1) goto L9;
        Object r7 = a.c(r14, r4);
        if (r7 == null) goto L32;
        r1.taskScenario = (String) r7;
    L32:
        r6 = r6 + 1;
        goto L3
    L9:
        if (r6 != 2) goto L14;
        Object r8 = a.c(r14, r4);
        if (r8 == null) goto L32;
        r1.sourceFrom = (String) r8;
        goto L32
    L14:
        if (r6 != 3) goto L19;
        Object r9 = a.c(r14, r4);
        if (r9 == null) goto L32;
        r1.assistantHistory = (String) r9;
        goto L32
    L19:
        if (r6 != 4) goto L24;
        Object r10 = a.c(r14, r4);
        if (r10 == null) goto L32;
        r1.executionMode = (String) r10;
        goto L32
    L24:
        if (r6 != 5) goto L28;
        Object r11 = a.c(r14, r4);
        if (r11 == null) goto L32;
        r1.meta = (String) r11;
        goto L32
    L28:
        if (r6 != 6) goto L32;
        Object r12 = a.c(r14, r4);
        if (r12 == null) goto L32;
        r1.requestAuth = (Boolean) r12;
    L33:
        if (r6 > r0) goto L35;
        a.d(r14, r4);
        r6 = r6 + 1;
        goto L33
    L35:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final SystemAutoActionParams[] newArray(int r1) {
        return new SystemAutoActionParams[r1];
    }
}
