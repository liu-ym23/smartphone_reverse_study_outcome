package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MessagesSearchParams$a implements Parcelable.Creator<MessagesSearchParams> {
    public MessagesSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesSearchParams createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r3 = r12.readString();
        String r4 = r12.readString();
        if (r12.readInt() != 0) goto L5;
        Long r6 = null;
    L7:
        if (r12.readInt() != 0) goto L9;
        Long r7 = null;
    L10:
        String r8 = r12.readString();
        String r9 = r12.readString();
        if (r12.readInt() != 0) goto L13;
        Integer r10 = null;
    L14:
        MessagesSearchParams r1 = new MessagesSearchParams(r3, r4, r6, r7, r8, r9, r10);
        int r2 = Math.min(r0, 0);
        ClassLoader r5 = MessagesSearchParams$a.class.getClassLoader();
        int r11 = 1;
    L15:
        if (r11 > r2) goto L17;
        r11 = r11 + 1;
    L17:
        if (r11 > r0) goto L19;
        a.d(r12, r5);
        r11 = r11 + 1;
        goto L17
    L19:
        return r1;
    L13:
        r10 = Integer.valueOf(r12.readInt());
        goto L14
    L9:
        r7 = Long.valueOf(r12.readLong());
        goto L10
    L5:
        r6 = Long.valueOf(r12.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesSearchParams[] newArray(int r1) {
        return new MessagesSearchParams[r1];
    }
}
