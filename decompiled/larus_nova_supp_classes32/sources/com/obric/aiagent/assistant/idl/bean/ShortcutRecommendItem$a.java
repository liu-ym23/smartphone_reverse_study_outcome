package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ShortcutRecommendItem$a implements Parcelable.Creator<ShortcutRecommendItem> {
    public ShortcutRecommendItem$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ShortcutRecommendItem createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        String r2 = r9.readString();
        String r3 = r9.readString();
        String r4 = r9.readString();
        if (r9.readInt() == 0) goto L5;
        boolean r5 = true;
    L7:
        return new ShortcutRecommendItem(r2, r3, r4, r5, r9.readLong());
    L5:
        r5 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final ShortcutRecommendItem[] newArray(int r1) {
        return new ShortcutRecommendItem[r1];
    }
}
