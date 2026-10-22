package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FeatureConfigMap$a implements Parcelable.Creator<FeatureConfigMap> {
    public FeatureConfigMap$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final FeatureConfigMap createFromParcel(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        int r0 = r6.readInt();
        LinkedHashMap r1 = new LinkedHashMap(r0);
        int r2 = 0;
    L3:
        if (r2 == r0) goto L10;
        String r3 = r6.readString();
        if (r6.readInt() != 0) goto L7;
        FeatureConfigBean r4 = null;
    L8:
        r1.put(r3, r4);
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = FeatureConfigBean.CREATOR.createFromParcel(r6);
        goto L8
    L10:
        return new FeatureConfigMap(r1);
    }

    @Override // android.os.Parcelable.Creator
    public final FeatureConfigMap[] newArray(int r1) {
        return new FeatureConfigMap[r1];
    }
}
