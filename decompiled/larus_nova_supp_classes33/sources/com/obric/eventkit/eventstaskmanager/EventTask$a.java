package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventTask$a implements Parcelable.Creator<EventTask> {
    public EventTask$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final EventTask createFromParcel(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        int r0 = r14.readInt();
        String r2 = TimerTaskKt.a(r14);
        String r3 = TimerTaskKt.a(r14);
        int r1 = r14.readInt();
        int r4 = r14.readInt();
        long r5 = r14.readLong();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r7 = new LinkedHashMap();
        r14.readMap(r7, String.class.getClassLoader(), String.class, String.class);
        if ((!r7.isEmpty()) == true) goto L19;
    L18:
        r7 = null;
    L19:
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L36;
        if (r0 != 3) goto L26;
        return new ShortcutTask(r2, r3, Integer.valueOf(r1), Integer.valueOf(r4), Long.valueOf(r5), r7, r14);
    L26:
        throw new IllegalArgumentException("Unknown event task type: " + r0);
    L36:
        return new ConditionTask(r2, r3, Integer.valueOf(r1), Integer.valueOf(r4), Long.valueOf(r5), r7, r14);
    L29:
        return new TimerTaskV2(r2, r3, Integer.valueOf(r1), Integer.valueOf(r4), Long.valueOf(r5), r7, r14);
    L7:
        Bundle r8 = r14.readBundle(EventTask.class.getClassLoader());
        if (r8 == null) goto L18;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<T> r10 = r8.keySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) r10.next();
        String r12 = r8.getString(r11);
        if (r12 == null) goto L11;
        r9.put(r11, r12);
        goto L11
    L16:
        if ((!r9.isEmpty()) == false) goto L18;
        r7 = r9;
        goto L19
    }

    @Override // android.os.Parcelable.Creator
    public final EventTask[] newArray(int r1) {
        return new EventTask[r1];
    }
}
