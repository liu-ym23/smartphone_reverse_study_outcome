package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class NetEaseCloudMusicSearchParams$a implements Parcelable.Creator<NetEaseCloudMusicSearchParams> {
    public NetEaseCloudMusicSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final NetEaseCloudMusicSearchParams createFromParcel(Parcel r10) {
        int r0 = r10.readInt();
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r2 = r10.readString();
        Integer r4 = null;
        if (r10.readInt() != 0) goto L5;
        Integer r3 = null;
    L6:
        int r7 = 1;
        if (r10.readInt() != 0) goto L10;
        Boolean r5 = null;
    L15:
        if (r10.readInt() == 0) goto L18;
        r4 = Integer.valueOf(r10.readInt());
    L18:
        NetEaseCloudMusicSearchParams r1 = new NetEaseCloudMusicSearchParams(r2, r3, r5, r4);
        int r6 = Math.min(r0, 0);
        ClassLoader r8 = NetEaseCloudMusicSearchParams$a.class.getClassLoader();
    L19:
        if (r7 > r6) goto L21;
        r7 = r7 + 1;
    L21:
        if (r7 > r0) goto L23;
        a.d(r10, r8);
        r7 = r7 + 1;
        goto L21
    L23:
        return r1;
    L10:
        if (r10.readInt() == 0) goto L12;
        boolean r9 = true;
    L13:
        r5 = Boolean.valueOf(r9);
        goto L15
    L12:
        r9 = false;
        goto L13
    L5:
        r3 = Integer.valueOf(r10.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final NetEaseCloudMusicSearchParams[] newArray(int r1) {
        return new NetEaseCloudMusicSearchParams[r1];
    }
}
