package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CardProvider$a implements Parcelable.Creator<CardProvider> {
    public CardProvider$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CardProvider createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        String r2 = r7.readString();
        Object r3 = r7.readValue(Integer.TYPE.getClassLoader());
        if ((r3 instanceof Integer) == false) goto L5;
        Integer r4 = (Integer) r3;
    L6:
        CardProvider r1 = new CardProvider(r2, r4, r7.readString(), r7.readString());
        int r5 = Math.min(r0, 0);
        ClassLoader r6 = CardProvider$a.class.getClassLoader();
        int r8 = 1;
    L7:
        if (r8 > r5) goto L9;
        r8 = r8 + 1;
    L9:
        if (r8 > r0) goto L11;
        a.d(r7, r6);
        r8 = r8 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final CardProvider[] newArray(int r1) {
        return new CardProvider[r1];
    }
}
