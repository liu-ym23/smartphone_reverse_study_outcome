package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CardView$a implements Parcelable.Creator<CardView> {
    public CardView$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final CardView createFromParcel(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        RemoteViews r2 = (RemoteViews) r8.readParcelable(RemoteViews.class.getClassLoader());
        Class r1 = Integer.TYPE;
        Object r3 = r8.readValue(r1.getClassLoader());
        if ((r3 instanceof Integer) == false) goto L5;
        Integer r4 = (Integer) r3;
    L6:
        Object r5 = r8.readValue(r1.getClassLoader());
        if ((r5 instanceof Integer) == false) goto L9;
        Integer r6 = (Integer) r5;
    L10:
        String r7 = r8.readString();
        Object r9 = r8.readValue(r1.getClassLoader());
        if ((r9 instanceof Integer) == false) goto L13;
        Integer r10 = (Integer) r9;
    L15:
        return new CardView(r2, r4, r6, r7, r10);
    L13:
        r10 = null;
        goto L15
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final CardView[] newArray(int r1) {
        return new CardView[r1];
    }
}
