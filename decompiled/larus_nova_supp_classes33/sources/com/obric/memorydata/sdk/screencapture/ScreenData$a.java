package com.obric.memorydata.sdk.screencapture;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ScreenData$a implements Parcelable.Creator<ScreenData> {
    public ScreenData$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ScreenData createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        Bitmap r2 = (Bitmap) r9.readParcelable(ScreenData.class.getClassLoader());
        HardwareBuffer r3 = (HardwareBuffer) r9.readParcelable(ScreenData.class.getClassLoader());
        String r4 = r9.readString();
        int r1 = 0;
        if (r9.readInt() == 0) goto L5;
        boolean r5 = true;
    L7:
        if (r9.readInt() != 0) goto L9;
        ArrayList r6 = null;
    L13:
        return new ScreenData(r2, r3, r4, r5, r6);
    L9:
        int r0 = r9.readInt();
        r6 = new ArrayList(r0);
    L10:
        if (r1 == r0) goto L13;
        r6.add(ViewTreeNode.CREATOR.createFromParcel(r9));
        r1 = r1 + 1;
        goto L10
    L5:
        r5 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ScreenData[] newArray(int r1) {
        return new ScreenData[r1];
    }
}
