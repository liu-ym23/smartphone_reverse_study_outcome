package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventTaskResult$a implements Parcelable.Creator<EventTaskResult> {
    public EventTaskResult$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskResult createFromParcel(Parcel r9) {
        int r0 = r9.readInt();
        Intrinsics.checkNotNullParameter(r9, "parcel");
        int r1 = r9.readInt();
        String r2 = r9.readString();
        if (r9.readInt() != 0) goto L5;
        ArrayList r3 = null;
    L9:
        EventTaskResult r6 = new EventTaskResult(r1, r2, r3, r9.readString());
        int r4 = Math.min(r0, 0);
        ClassLoader r5 = EventTaskResult$a.class.getClassLoader();
        int r7 = 1;
    L10:
        if (r7 > r4) goto L12;
        r7 = r7 + 1;
    L12:
        if (r7 > r0) goto L14;
        a.d(r9, r5);
        r7 = r7 + 1;
        goto L12
    L14:
        return r6;
    L5:
        int r8 = r9.readInt();
        ArrayList r10 = new ArrayList(r8);
        int r11 = 0;
    L6:
        if (r11 == r8) goto L8;
        r10.add(r9.readParcelable(EventTaskResult.class.getClassLoader()));
        r11 = r11 + 1;
        goto L6
    L8:
        r3 = r10;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskResult[] newArray(int r1) {
        return new EventTaskResult[r1];
    }
}
