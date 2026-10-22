package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentResult;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IntentExecutionRecord$a implements Parcelable.Creator<IntentExecutionRecord> {
    public IntentExecutionRecord$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final IntentExecutionRecord createFromParcel(Parcel r11) {
        int r0 = r11.readInt();
        Intrinsics.checkNotNullParameter(r11, "parcel");
        String r3 = r11.readString();
        String r4 = r11.readString();
        String r5 = r11.readString();
        IntentResult r6 = r11.readParcelable(IntentExecutionRecord.class.getClassLoader());
        int r9 = 1;
        if (r11.readInt() == 0) goto L5;
        boolean r7 = true;
    L6:
        IntentExecutionRecord r1 = new IntentExecutionRecord(r3, r4, r5, r6, r7);
        int r2 = Math.min(r0, 0);
        ClassLoader r8 = IntentExecutionRecord$a.class.getClassLoader();
    L7:
        if (r9 > r2) goto L9;
        r9 = r9 + 1;
    L9:
        if (r9 > r0) goto L11;
        a.d(r11, r8);
        r9 = r9 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r7 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final IntentExecutionRecord[] newArray(int r1) {
        return new IntentExecutionRecord[r1];
    }
}
