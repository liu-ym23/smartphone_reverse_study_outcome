package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhotoAddToFavoriteParams$a implements Parcelable.Creator<PhotoAddToFavoriteParams> {
    public PhotoAddToFavoriteParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoAddToFavoriteParams createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        PhotoEntity r2 = r7.readParcelable(PhotoAddToFavoriteParams.class.getClassLoader());
        int r5 = 1;
        if (r7.readInt() != 0) goto L6;
        Boolean r3 = null;
    L10:
        PhotoAddToFavoriteParams r1 = new PhotoAddToFavoriteParams(r2, r3);
        int r4 = Math.min(r0, 0);
        ClassLoader r6 = PhotoAddToFavoriteParams$a.class.getClassLoader();
    L11:
        if (r5 > r4) goto L13;
        r5 = r5 + 1;
    L13:
        if (r5 > r0) goto L15;
        a.d(r7, r6);
        r5 = r5 + 1;
        goto L13
    L15:
        return r1;
    L6:
        if (r7.readInt() == 0) goto L8;
        boolean r8 = true;
    L9:
        r3 = Boolean.valueOf(r8);
        goto L10
    L8:
        r8 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoAddToFavoriteParams[] newArray(int r1) {
        return new PhotoAddToFavoriteParams[r1];
    }
}
