package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AuthorThumbModel$a implements Parcelable.Creator {
    public AuthorThumbModel$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r7) {
        String r1 = r7.readString();
        ArrayList<String> r2 = r7.createStringArrayList();
        Integer r4 = null;
        if (r7.readInt() == 0) goto L5;
        Integer r3 = Integer.valueOf(r7.readInt());
    L7:
        if (r7.readInt() == 0) goto L10;
        r4 = Integer.valueOf(r7.readInt());
    L10:
        return new AuthorThumbModel(r1, r2, r3, r4);
    L5:
        r3 = null;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r1) {
        return new AuthorThumbModel[r1];
    }
}
