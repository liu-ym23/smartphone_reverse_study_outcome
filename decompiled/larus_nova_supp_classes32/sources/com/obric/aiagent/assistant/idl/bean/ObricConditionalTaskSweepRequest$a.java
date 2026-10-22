package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricConditionalTaskSweepRequest$a implements Parcelable.Creator<ObricConditionalTaskSweepRequest> {
    public ObricConditionalTaskSweepRequest$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ObricConditionalTaskSweepRequest createFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        int r1 = 0;
        LinkedHashMap r2 = null;
        if (r7.readInt() != 0) goto L5;
        ArrayList r3 = null;
    L9:
        if (r7.readInt() == 0) goto L15;
        int r0 = r7.readInt();
        r2 = new LinkedHashMap(r0);
    L12:
        if (r1 == r0) goto L15;
        r2.put(r7.readString(), r7.readString());
        r1 = r1 + 1;
    L15:
        return new ObricConditionalTaskSweepRequest(r3, r2);
    L5:
        int r4 = r7.readInt();
        r3 = new ArrayList(r4);
        int r5 = 0;
    L6:
        if (r5 == r4) goto L9;
        r3.add(ObricConditionalTaskCreateRequest.CREATOR.createFromParcel(r7));
        r5 = r5 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ObricConditionalTaskSweepRequest[] newArray(int r1) {
        return new ObricConditionalTaskSweepRequest[r1];
    }
}
