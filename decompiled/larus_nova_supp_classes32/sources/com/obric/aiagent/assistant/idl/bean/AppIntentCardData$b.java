package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentCardData$b implements Parcelable.Creator<AppIntentCardData> {
    public AppIntentCardData$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final AppIntentCardData createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        int r2 = r9.readInt();
        AppEntity r3 = r9.readParcelable(AppIntentCardData.class.getClassLoader());
        CardProvider r4 = r9.readParcelable(AppIntentCardData.class.getClassLoader());
        boolean r6 = false;
        if (r9.readInt() == 0) goto L5;
        boolean r7 = true;
    L7:
        if (r9.readInt() == 0) goto L10;
        r6 = true;
    L10:
        return new AppIntentCardData(r2, r3, r4, r7, r6);
    L5:
        r7 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final AppIntentCardData[] newArray(int r1) {
        return new AppIntentCardData[r1];
    }
}
