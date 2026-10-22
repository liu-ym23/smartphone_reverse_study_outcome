package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FeedbackBean$a implements Parcelable.Creator<FeedbackBean> {
    public FeedbackBean$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final FeedbackBean createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        ArrayList<String> r2 = r9.createStringArrayList();
        String r3 = r9.readString();
        if (r9.readInt() == 0) goto L5;
        boolean r6 = true;
    L7:
        if (r9.readInt() == 0) goto L9;
        boolean r7 = true;
    L11:
        if (r9.readInt() == 0) goto L13;
        boolean r10 = true;
    L15:
        return new FeedbackBean(r2, r3, r6, r7, r10);
    L13:
        r10 = false;
        goto L15
    L9:
        r7 = false;
        goto L11
    L5:
        r6 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final FeedbackBean[] newArray(int r1) {
        return new FeedbackBean[r1];
    }
}
