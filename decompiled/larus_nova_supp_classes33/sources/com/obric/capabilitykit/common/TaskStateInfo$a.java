package com.obric.capabilitykit.common;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TaskStateInfo$a implements Parcelable.Creator<TaskStateInfo> {
    public TaskStateInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TaskStateInfo createFromParcel(Parcel r11) {
        int r0 = r11.readInt();
        Intrinsics.checkNotNullParameter(r11, "parcel");
        TaskState r1 = TaskState.valueOf(r11.readString());
        String r2 = r11.readString();
        Bitmap r3 = (Bitmap) r11.readParcelable(TaskStateInfo.class.getClassLoader());
        if (r11.readInt() != 0) goto L5;
        LinkedHashMap r4 = null;
    L9:
        TaskStateInfo r6 = new TaskStateInfo(r1, r2, r3, r4);
        int r5 = Math.min(r0, 0);
        ClassLoader r7 = TaskStateInfo$a.class.getClassLoader();
        int r8 = 1;
    L10:
        if (r8 > r5) goto L12;
        r8 = r8 + 1;
    L12:
        if (r8 > r0) goto L14;
        a.d(r11, r7);
        r8 = r8 + 1;
        goto L12
    L14:
        return r6;
    L5:
        int r9 = r11.readInt();
        LinkedHashMap r10 = new LinkedHashMap(r9);
        int r12 = 0;
    L6:
        if (r12 == r9) goto L8;
        r10.put(r11.readString(), r11.readString());
        r12 = r12 + 1;
        goto L6
    L8:
        r4 = r10;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final TaskStateInfo[] newArray(int r1) {
        return new TaskStateInfo[r1];
    }
}
