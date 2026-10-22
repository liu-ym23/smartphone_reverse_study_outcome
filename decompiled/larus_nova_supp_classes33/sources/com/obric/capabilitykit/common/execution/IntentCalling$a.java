package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IntentCalling$a implements Parcelable.Creator<IntentCalling> {
    public IntentCalling$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final IntentCalling createFromParcel(Parcel r22) {
        int r1 = r22.readInt();
        Intrinsics.checkNotNullParameter(r22, "parcel");
        long r4 = r22.readLong();
        long r6 = r22.readLong();
        long r8 = r22.readLong();
        long r10 = r22.readLong();
        long r12 = r22.readLong();
        String r14 = r22.readString();
        String r15 = r22.readString();
        String r16 = r22.readString();
        String r17 = r22.readString();
        Parcelable r18 = r22.readParcelable(IntentCalling.class.getClassLoader());
        if (r22.readInt() != 0) goto L5;
        int r20 = r1;
        LinkedHashMap r19 = null;
    L9:
        IntentCalling r0 = new IntentCalling(r4, r6, r8, r10, r12, r14, r15, r16, r17, r18, r19);
        int r2 = r20;
        int r3 = Math.min(r2, 1);
        ClassLoader r5 = IntentCalling$a.class.getClassLoader();
        int r7 = 1;
    L11:
        if (r7 > r3) goto L17;
        if (r7 != 1) goto L16;
        Object r9 = a.c(r22, r5);
        if (r9 == null) goto L16;
        r0.k = (Map) r9;
    L16:
        r7 = r7 + 1;
    L17:
        if (r7 > r2) goto L19;
        a.d(r22, r5);
        r7 = r7 + 1;
        goto L17
    L19:
        return r0;
    L5:
        int r11 = r22.readInt();
        LinkedHashMap r13 = new LinkedHashMap(r11);
        int r21 = 0;
    L6:
        if (r21 == r11) goto L8;
        r13.put(r22.readString(), r22.readString());
        r21 = r21 + 1;
        r11 = r11;
        r1 = r1;
        goto L6
    L8:
        r20 = r1;
        r19 = r13;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final IntentCalling[] newArray(int r1) {
        return new IntentCalling[r1];
    }
}
