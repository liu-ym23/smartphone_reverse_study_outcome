package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventTaskExecutionRecord$a implements Parcelable.Creator<EventTaskExecutionRecord> {
    public EventTaskExecutionRecord$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskExecutionRecord createFromParcel(Parcel r20) {
        int r1 = r20.readInt();
        Intrinsics.checkNotNullParameter(r20, "parcel");
        long r4 = r20.readLong();
        int r6 = r20.readInt();
        int r7 = r20.readInt();
        String r8 = r20.readString();
        String r9 = r20.readString();
        long r10 = r20.readLong();
        long r12 = r20.readLong();
        int r14 = r20.readInt();
        String r15 = r20.readString();
        if (r20.readInt() != 0) goto L5;
        LinkedHashMap r2 = null;
        int r18 = r1;
    L9:
        EventTaskExecutionRecord r0 = new EventTaskExecutionRecord(r4, r6, r7, r8, r9, r10, r12, r14, r15, r2);
        int r3 = r18;
        int r5 = Math.min(r3, 0);
        ClassLoader r11 = EventTaskExecutionRecord$a.class.getClassLoader();
        int r13 = 1;
    L10:
        if (r13 > r5) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 > r3) goto L14;
        a.d(r20, r11);
        r13 = r13 + 1;
        goto L12
    L14:
        return r0;
    L5:
        int r16 = r20.readInt();
        LinkedHashMap r17 = new LinkedHashMap(r16);
        int r19 = 0;
    L6:
        if (r19 == r16) goto L8;
        int r110 = r16;
        int r111 = r1;
        r17.put(r20.readString(), r20.readString());
        r19 = r19 + 1;
        r16 = r110;
        r1 = r111;
        goto L6
    L8:
        r18 = r1;
        r2 = r17;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskExecutionRecord[] newArray(int r1) {
        return new EventTaskExecutionRecord[r1];
    }
}
