package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RankingEffectModel$a implements Parcelable.Creator {
    public RankingEffectModel$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r6) {
        String r1 = r6.readString();
        String r2 = r6.readString();
        if (r6.readInt() == 0) goto L5;
        Integer r3 = Integer.valueOf(r6.readInt());
    L7:
        return new RankingEffectModel(r1, r2, r3, r6.readParcelable(RankingEffectModel.class.getClassLoader()));
    L5:
        r3 = null;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r1) {
        return new RankingEffectModel[r1];
    }
}
