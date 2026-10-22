package com.obric.eventkit.eventstaskmanager;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class EventTaskSpec$a implements Parcelable.Creator<EventTaskSpec> {
    public EventTaskSpec$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskSpec createFromParcel(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        int r0 = r13.readInt();
        String r2 = r13.readString();
        int r1 = r13.readInt();
        TaskKnowledge r4 = r13.readParcelable(EventTaskSpec.class.getClassLoader());
        String r5 = r13.readString();
        int r3 = r13.readInt();
        int r6 = r13.readInt();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        LinkedHashMap r7 = new LinkedHashMap();
        r13.readMap(r7, String.class.getClassLoader(), String.class, String.class);
        if ((!r7.isEmpty()) == true) goto L19;
    L18:
        r7 = null;
    L19:
        LinkedHashMap r8 = r7;
    L21:
        if (r0 == 2) goto L28;
        if (r0 != 3) goto L26;
        return new ShortcutTaskSpec(r2, Integer.valueOf(r1), r4, r5, Integer.valueOf(r3), Integer.valueOf(r6), r8, r13);
    L26:
        throw new IllegalArgumentException("Unknown event task type: " + r0);
    L28:
        return new ConditionTaskSpec(r2, Integer.valueOf(r1), r4, r5, Integer.valueOf(r3), Integer.valueOf(r6), r8, r13);
    L7:
        Bundle r9 = r13.readBundle(EventTaskSpec.class.getClassLoader());
        if (r9 == null) goto L18;
        r8 = new LinkedHashMap();
        Iterator<T> r10 = r9.keySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) r10.next();
        String r12 = r9.getString(r11);
        if (r12 == null) goto L11;
        r8.put(r11, r12);
        goto L11
    L16:
        if ((!r8.isEmpty()) == false) goto L18;
        goto L18
    }

    @Override // android.os.Parcelable.Creator
    public final EventTaskSpec[] newArray(int r1) {
        return new EventTaskSpec[r1];
    }
}
