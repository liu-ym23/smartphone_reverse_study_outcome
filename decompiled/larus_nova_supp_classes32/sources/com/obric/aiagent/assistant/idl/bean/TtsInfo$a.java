package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TtsInfo$a implements Parcelable.Creator<TtsInfo> {
    public TtsInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final TtsInfo createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r1 = r4.readString();
        if (r4.readInt() != 0) goto L5;
        Integer r5 = null;
    L7:
        return new TtsInfo(r1, r5);
    L5:
        r5 = Integer.valueOf(r4.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final TtsInfo[] newArray(int r1) {
        return new TtsInfo[r1];
    }
}
