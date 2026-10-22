package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IntentDebugReport$a implements Parcelable.Creator<IntentDebugReport> {
    public IntentDebugReport$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final IntentDebugReport createFromParcel(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        String r2 = r13.readString();
        String r3 = r13.readString();
        String r4 = r13.readString();
        String r5 = r13.readString();
        String r6 = r13.readString();
        String r7 = r13.readString();
        String r8 = r13.readString();
        String r9 = r13.readString();
        String r10 = r13.readString();
        if (r13.readInt() != 0) goto L5;
        Integer r14 = null;
    L7:
        return new IntentDebugReport(r2, r3, r4, r5, r6, r7, r8, r9, r10, r14);
    L5:
        r14 = Integer.valueOf(r13.readInt());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final IntentDebugReport[] newArray(int r1) {
        return new IntentDebugReport[r1];
    }
}
