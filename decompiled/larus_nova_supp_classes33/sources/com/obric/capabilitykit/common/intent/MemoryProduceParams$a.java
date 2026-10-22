package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MemoryProduceParams$a implements Parcelable.Creator<MemoryProduceParams> {
    public MemoryProduceParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MemoryProduceParams createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r3 = r12.readString();
        if (r12.readInt() != 0) goto L7;
        Boolean r2 = null;
    L11:
        MemoryProduceParams r1 = new MemoryProduceParams(r3, r2, null, null, null, 28, null);
        int r4 = Math.min(r0, 3);
        ClassLoader r5 = MemoryProduceParams$a.class.getClassLoader();
        int r6 = 1;
    L12:
        if (r6 > r4) goto L27;
        if (r6 != 1) goto L18;
        Object r7 = a.c(r12, r5);
        if (r7 == null) goto L26;
        r1.chatHistory = (String) r7;
    L26:
        r6 = r6 + 1;
        goto L12
    L18:
        if (r6 != 2) goto L22;
        Object r8 = a.c(r12, r5);
        if (r8 == null) goto L26;
        r1.targets = (String) r8;
        goto L26
    L22:
        if (r6 != 3) goto L26;
        Object r9 = a.c(r12, r5);
        if (r9 == null) goto L26;
        r1.subIntent = (Integer) r9;
    L27:
        if (r6 > r0) goto L29;
        a.d(r12, r5);
        r6 = r6 + 1;
        goto L27
    L29:
        return r1;
    L7:
        if (r12.readInt() == 0) goto L9;
        boolean r10 = true;
    L10:
        r2 = Boolean.valueOf(r10);
        goto L11
    L9:
        r10 = false;
        goto L10
    }

    @Override // android.os.Parcelable.Creator
    public final MemoryProduceParams[] newArray(int r1) {
        return new MemoryProduceParams[r1];
    }
}
