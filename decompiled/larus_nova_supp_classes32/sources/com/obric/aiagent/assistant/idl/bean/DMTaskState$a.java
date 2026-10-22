package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DMTaskState$a implements Parcelable.Creator<DMTaskState> {
    public DMTaskState$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DMTaskState createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        String r0 = r9.readString();
        if (r9.readInt() != 0) goto L5;
        Object r1 = null;
    L6:
        DMTaskInfo r2 = (DMTaskInfo) r1;
        int r3 = r9.readInt();
        int r4 = r9.readInt();
        LinkedHashMap r5 = new LinkedHashMap(r4);
        int r6 = 0;
    L7:
        if (r6 == r4) goto L10;
        r5.put(r9.readString(), r9.readString());
        r6 = r6 + 1;
        goto L7
    L10:
        return new DMTaskState(r0, r2, r3, r5);
    L5:
        r1 = DMTaskInfo.CREATOR.createFromParcel(r9);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final DMTaskState[] newArray(int r1) {
        return new DMTaskState[r1];
    }
}
