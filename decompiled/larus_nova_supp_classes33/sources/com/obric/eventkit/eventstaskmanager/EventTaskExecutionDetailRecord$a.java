package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventTaskExecutionDetailRecord$a implements Parcelable.Creator<EventTaskExecutionDetailRecord> {
    public EventTaskExecutionDetailRecord$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskExecutionDetailRecord createFromParcel(Parcel r17) {
        int r1 = r17.readInt();
        Intrinsics.checkNotNullParameter(r17, "parcel");
        long r4 = r17.readLong();
        String r6 = r17.readString();
        long r7 = r17.readLong();
        String r9 = r17.readString();
        String r10 = r17.readString();
        String r11 = r17.readString();
        int r12 = r17.readInt();
        if (r17.readInt() != 0) goto L5;
        LinkedHashMap r13 = null;
    L9:
        EventTaskExecutionDetailRecord r2 = new EventTaskExecutionDetailRecord(r4, r6, r7, r9, r10, r11, r12, r13);
        int r3 = Math.min(r1, 0);
        ClassLoader r5 = EventTaskExecutionDetailRecord$a.class.getClassLoader();
        int r8 = 1;
    L10:
        if (r8 > r3) goto L12;
        r8 = r8 + 1;
    L12:
        if (r8 > r1) goto L14;
        a.d(r17, r5);
        r8 = r8 + 1;
        goto L12
    L14:
        return r2;
    L5:
        int r14 = r17.readInt();
        LinkedHashMap r15 = new LinkedHashMap(r14);
        int r16 = 0;
    L6:
        if (r16 == r14) goto L8;
        r15.put(r17.readString(), r17.readString());
        r16 = r16 + 1;
        goto L6
    L8:
        r13 = r15;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskExecutionDetailRecord[] newArray(int r1) {
        return new EventTaskExecutionDetailRecord[r1];
    }
}
