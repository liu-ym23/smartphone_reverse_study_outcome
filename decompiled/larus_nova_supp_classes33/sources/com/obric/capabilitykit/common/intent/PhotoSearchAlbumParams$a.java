package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhotoSearchAlbumParams$a implements Parcelable.Creator<PhotoSearchAlbumParams> {
    public PhotoSearchAlbumParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoSearchAlbumParams createFromParcel(Parcel r10) {
        int r0 = r10.readInt();
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r3 = r10.readString();
        if (r10.readInt() != 0) goto L5;
        Long r5 = null;
    L7:
        if (r10.readInt() != 0) goto L9;
        Long r6 = null;
    L10:
        String r7 = r10.readString();
        if (r10.readInt() != 0) goto L13;
        Integer r8 = null;
    L14:
        PhotoSearchAlbumParams r1 = new PhotoSearchAlbumParams(r3, r5, r6, r7, r8);
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = PhotoSearchAlbumParams$a.class.getClassLoader();
        int r9 = 1;
    L15:
        if (r9 > r2) goto L17;
        r9 = r9 + 1;
    L17:
        if (r9 > r0) goto L19;
        a.d(r10, r4);
        r9 = r9 + 1;
        goto L17
    L19:
        return r1;
    L13:
        r8 = Integer.valueOf(r10.readInt());
        goto L14
    L9:
        r6 = Long.valueOf(r10.readLong());
        goto L10
    L5:
        r5 = Long.valueOf(r10.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoSearchAlbumParams[] newArray(int r1) {
        return new PhotoSearchAlbumParams[r1];
    }
}
