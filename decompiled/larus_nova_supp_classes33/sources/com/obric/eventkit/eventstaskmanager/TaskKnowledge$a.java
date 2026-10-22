package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TaskKnowledge$a implements Parcelable.Creator<TaskKnowledge> {
    public TaskKnowledge$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TaskKnowledge createFromParcel(Parcel r13) {
        int r0 = r13.readInt();
        Intrinsics.checkNotNullParameter(r13, "parcel");
        if (r13.readInt() == 0) goto L5;
        boolean r3 = true;
    L6:
        TaskKnowledge r1 = new TaskKnowledge(r3, r13.readString(), r13.readString(), r13.readInt(), false, null, 48, null);
        int r4 = Math.min(r0, 2);
        ClassLoader r5 = TaskKnowledge$a.class.getClassLoader();
        int r6 = 1;
    L7:
        if (r6 > r4) goto L17;
        if (r6 != 1) goto L12;
        Object r7 = a.c(r13, r5);
        if (r7 == null) goto L16;
        r1.learningSwitch = ((Boolean) r7).booleanValue();
    L16:
        r6 = r6 + 1;
        goto L7
    L12:
        if (r6 != 2) goto L16;
        Object r8 = a.c(r13, r5);
        if (r8 == null) goto L16;
        r1.evolutionInfo = (String) r8;
    L17:
        if (r6 > r0) goto L19;
        a.d(r13, r5);
        r6 = r6 + 1;
        goto L17
    L19:
        return r1;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final TaskKnowledge[] newArray(int r1) {
        return new TaskKnowledge[r1];
    }
}
