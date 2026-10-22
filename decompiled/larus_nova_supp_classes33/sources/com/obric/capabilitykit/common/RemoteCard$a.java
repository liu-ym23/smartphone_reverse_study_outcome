package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class RemoteCard$a implements Parcelable.Creator<RemoteCard> {
    public RemoteCard$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RemoteCard createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        Object r1 = r8.readValue(CardProvider.class.getClassLoader());
        if ((r1 instanceof Boolean) == false) goto L5;
        Boolean r2 = (Boolean) r1;
    L6:
        int r3 = r8.readInt();
        CardProvider[] r4 = new CardProvider[r3];
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L9;
        r4[r5] = (CardProvider) r8.readParcelable(CardProvider.class.getClassLoader());
        r5 = r5 + 1;
        goto L7
    L9:
        RemoteCard r6 = new RemoteCard(r2, r4);
        int r7 = Math.min(r0, 0);
        ClassLoader r9 = RemoteCard$a.class.getClassLoader();
        int r10 = 1;
    L10:
        if (r10 > r7) goto L12;
        r10 = r10 + 1;
    L12:
        if (r10 > r0) goto L14;
        a.d(r8, r9);
        r10 = r10 + 1;
        goto L12
    L14:
        return r6;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final RemoteCard[] newArray(int r1) {
        return new RemoteCard[r1];
    }
}
