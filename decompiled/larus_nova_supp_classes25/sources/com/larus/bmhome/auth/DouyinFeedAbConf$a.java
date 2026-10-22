package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DouyinFeedAbConf$a implements Parcelable.Creator<DouyinFeedAbConf> {
    public DouyinFeedAbConf$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DouyinFeedAbConf createFromParcel(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        int r1 = 0;
        Object r2 = null;
        if (r8.readInt() != 0) goto L6;
        Boolean r0 = null;
    L10:
        String r3 = r8.readString();
        if (r8.readInt() != 0) goto L13;
        ArrayList r5 = null;
    L17:
        if (r8.readInt() == 0) goto L21;
        r2 = DouyinFeedEntrance.CREATOR.createFromParcel(r8);
    L21:
        return new DouyinFeedAbConf(r0, r3, r5, (DouyinFeedEntrance) r2);
    L13:
        int r4 = r8.readInt();
        r5 = new ArrayList(r4);
    L14:
        if (r1 == r4) goto L17;
        r5.add(DouyinFeedEntrance.CREATOR.createFromParcel(r8));
        r1 = r1 + 1;
        goto L14
    L6:
        if (r8.readInt() == 0) goto L8;
        boolean r6 = true;
    L9:
        r0 = Boolean.valueOf(r6);
        goto L10
    L8:
        r6 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final DouyinFeedAbConf[] newArray(int r1) {
        return new DouyinFeedAbConf[r1];
    }
}
