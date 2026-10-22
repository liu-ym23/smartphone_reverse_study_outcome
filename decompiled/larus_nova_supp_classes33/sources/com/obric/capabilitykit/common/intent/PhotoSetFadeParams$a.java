package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PhotoSetFadeParams$a implements Parcelable.Creator<PhotoSetFadeParams> {
    public PhotoSetFadeParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoSetFadeParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        PhotoEntity r2 = r6.readParcelable(PhotoSetFadeParams.class.getClassLoader());
        String r3 = r6.readString();
        if (r6.readInt() != 0) goto L5;
        Integer r4 = null;
    L6:
        PhotoSetFadeParams r1 = new PhotoSetFadeParams(r2, r3, r4);
        int r5 = Math.min(r0, 0);
        ClassLoader r7 = PhotoSetFadeParams$a.class.getClassLoader();
        int r8 = 1;
    L7:
        if (r8 > r5) goto L9;
        r8 = r8 + 1;
    L9:
        if (r8 > r0) goto L11;
        a.d(r6, r7);
        r8 = r8 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r4 = Integer.valueOf(r6.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final PhotoSetFadeParams[] newArray(int r1) {
        return new PhotoSetFadeParams[r1];
    }
}
