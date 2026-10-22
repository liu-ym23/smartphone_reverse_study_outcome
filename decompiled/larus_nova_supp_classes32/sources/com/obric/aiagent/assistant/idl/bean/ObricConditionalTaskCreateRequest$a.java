package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricConditionalTaskCreateRequest$a implements Parcelable.Creator<ObricConditionalTaskCreateRequest> {
    public ObricConditionalTaskCreateRequest$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ObricConditionalTaskCreateRequest createFromParcel(Parcel r18) {
        Intrinsics.checkNotNullParameter(r18, "parcel");
        String r2 = r18.readString();
        String r3 = r18.readString();
        String r4 = r18.readString();
        String r5 = r18.readString();
        String r6 = r18.readString();
        String r7 = r18.readString();
        String r8 = r18.readString();
        String r9 = r18.readString();
        String r10 = r18.readString();
        String r11 = r18.readString();
        String r12 = r18.readString();
        if (r18.readInt() != 0) goto L5;
        LinkedHashMap r13 = null;
    L9:
        return new ObricConditionalTaskCreateRequest(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r18.readString(), r18.readString(), r18.readString());
    L5:
        int r0 = r18.readInt();
        r13 = new LinkedHashMap(r0);
        int r14 = 0;
    L6:
        if (r14 == r0) goto L9;
        r13.put(r18.readString(), r18.readString());
        r14 = r14 + 1;
        r0 = r0;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ObricConditionalTaskCreateRequest[] newArray(int r1) {
        return new ObricConditionalTaskCreateRequest[r1];
    }
}
