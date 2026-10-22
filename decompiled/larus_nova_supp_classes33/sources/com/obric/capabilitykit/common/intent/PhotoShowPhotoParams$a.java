package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhotoShowPhotoParams$a implements Parcelable.Creator<PhotoShowPhotoParams> {
    public PhotoShowPhotoParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoShowPhotoParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        Integer r3 = null;
        if (r8.readInt() != 0) goto L5;
        PhotoEntity[] r4 = null;
    L9:
        if (r8.readInt() == 0) goto L12;
        r3 = Integer.valueOf(r8.readInt());
    L12:
        PhotoShowPhotoParams r1 = new PhotoShowPhotoParams(r4, r3);
        int r2 = Math.min(r0, 0);
        ClassLoader r5 = PhotoShowPhotoParams$a.class.getClassLoader();
        int r6 = 1;
    L13:
        if (r6 > r2) goto L15;
        r6 = r6 + 1;
    L15:
        if (r6 > r0) goto L17;
        a.d(r8, r5);
        r6 = r6 + 1;
        goto L15
    L17:
        return r1;
    L5:
        int r7 = r8.readInt();
        r4 = new PhotoEntity[r7];
        int r9 = 0;
    L6:
        if (r9 == r7) goto L9;
        r4[r9] = (PhotoEntity) r8.readParcelable(PhotoShowPhotoParams.class.getClassLoader());
        r9 = r9 + 1;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoShowPhotoParams[] newArray(int r1) {
        return new PhotoShowPhotoParams[r1];
    }
}
