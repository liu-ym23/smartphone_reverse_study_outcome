package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhotoAddPhotosToAlbumParams$a implements Parcelable.Creator<PhotoAddPhotosToAlbumParams> {
    public PhotoAddPhotosToAlbumParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoAddPhotosToAlbumParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        AlbumEntity r1 = r8.readParcelable(PhotoAddPhotosToAlbumParams.class.getClassLoader());
        if (r8.readInt() != 0) goto L5;
        PhotoEntity[] r2 = null;
    L9:
        PhotoAddPhotosToAlbumParams r4 = new PhotoAddPhotosToAlbumParams(r1, r2);
        int r3 = Math.min(r0, 0);
        ClassLoader r5 = PhotoAddPhotosToAlbumParams$a.class.getClassLoader();
        int r6 = 1;
    L10:
        if (r6 > r3) goto L12;
        r6 = r6 + 1;
    L12:
        if (r6 > r0) goto L14;
        a.d(r8, r5);
        r6 = r6 + 1;
        goto L12
    L14:
        return r4;
    L5:
        int r7 = r8.readInt();
        PhotoEntity[] r9 = new PhotoEntity[r7];
        int r10 = 0;
    L6:
        if (r10 == r7) goto L8;
        r9[r10] = (PhotoEntity) r8.readParcelable(PhotoAddPhotosToAlbumParams.class.getClassLoader());
        r10 = r10 + 1;
        goto L6
    L8:
        r2 = r9;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoAddPhotosToAlbumParams[] newArray(int r1) {
        return new PhotoAddPhotosToAlbumParams[r1];
    }
}
