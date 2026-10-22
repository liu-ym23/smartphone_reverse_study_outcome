package com.obric.memorydata.sdk.assistant;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class QueryContext$a implements Parcelable.Creator<QueryContext> {
    public QueryContext$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final QueryContext createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        int r0 = r3.readInt();
        if (r3.dataAvail() <= 0) goto L5;
        int r4 = r3.readInt();
    L7:
        return new QueryContext(r0, r4);
    L5:
        r4 = 0;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final QueryContext[] newArray(int r1) {
        return new QueryContext[r1];
    }
}
