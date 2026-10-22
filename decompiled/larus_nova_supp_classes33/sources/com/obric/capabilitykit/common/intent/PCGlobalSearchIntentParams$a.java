package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PCGlobalSearchIntentParams$a implements Parcelable.Creator<PCGlobalSearchIntentParams> {
    public PCGlobalSearchIntentParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PCGlobalSearchIntentParams createFromParcel(Parcel r11) {
        int r0 = r11.readInt();
        Intrinsics.checkNotNullParameter(r11, "parcel");
        PCGlobalSearchIntentParams r1 = new PCGlobalSearchIntentParams(r11.readString(), null, null, null, null, 30, null);
        int r3 = Math.min(r0, 4);
        ClassLoader r4 = PCGlobalSearchIntentParams$a.class.getClassLoader();
        int r6 = 1;
    L3:
        if (r6 > r3) goto L23;
        if (r6 != 1) goto L9;
        Object r7 = a.c(r11, r4);
        if (r7 == null) goto L22;
        r1.needDeepSearch = (Boolean) r7;
    L22:
        r6 = r6 + 1;
        goto L3
    L9:
        if (r6 != 2) goto L14;
        Object r8 = a.c(r11, r4);
        if (r8 == null) goto L22;
        r1.limitCount = (Integer) r8;
        goto L22
    L14:
        if (r6 != 3) goto L18;
        Object r9 = a.c(r11, r4);
        if (r9 == null) goto L22;
        r1.interactionType = (String) r9;
        goto L22
    L18:
        if (r6 != 4) goto L22;
        Object r10 = a.c(r11, r4);
        if (r10 == null) goto L22;
        r1.meta = (String) r10;
    L23:
        if (r6 > r0) goto L25;
        a.d(r11, r4);
        r6 = r6 + 1;
        goto L23
    L25:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final PCGlobalSearchIntentParams[] newArray(int r1) {
        return new PCGlobalSearchIntentParams[r1];
    }
}
