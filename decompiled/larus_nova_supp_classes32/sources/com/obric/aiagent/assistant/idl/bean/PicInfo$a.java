package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PicInfo$a implements Parcelable.Creator<PicInfo> {
    public PicInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PicInfo createFromParcel(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r2 = r10.readString();
        if (r10.readInt() != 0) goto L5;
        Integer r4 = null;
    L7:
        if (r10.readInt() != 0) goto L9;
        Integer r5 = null;
    L10:
        String r6 = r10.readString();
        if (r10.readInt() != 0) goto L13;
        Long r11 = null;
    L15:
        return new PicInfo(r2, r4, r5, r6, r11);
    L13:
        r11 = Long.valueOf(r10.readLong());
        goto L15
    L9:
        r5 = Integer.valueOf(r10.readInt());
        goto L10
    L5:
        r4 = Integer.valueOf(r10.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final PicInfo[] newArray(int r1) {
        return new PicInfo[r1];
    }
}
