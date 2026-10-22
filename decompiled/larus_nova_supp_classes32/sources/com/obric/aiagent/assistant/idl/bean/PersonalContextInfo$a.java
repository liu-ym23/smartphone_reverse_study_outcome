package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PersonalContextInfo$a implements Parcelable.Creator<PersonalContextInfo> {
    public PersonalContextInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final PersonalContextInfo createFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r1 = r4.readString();
        if (r4.readInt() != 0) goto L6;
        Boolean r5 = null;
    L11:
        return new PersonalContextInfo(r1, r5);
    L6:
        if (r4.readInt() == 0) goto L8;
        boolean r6 = true;
    L9:
        r5 = Boolean.valueOf(r6);
        goto L11
    L8:
        r6 = false;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final PersonalContextInfo[] newArray(int r1) {
        return new PersonalContextInfo[r1];
    }
}
