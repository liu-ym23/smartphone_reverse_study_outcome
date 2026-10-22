package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class OSkill$a implements Parcelable.Creator<OSkill> {
    public OSkill$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OSkill createFromParcel(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        String r2 = r13.readString();
        String r3 = r13.readString();
        String r4 = r13.readString();
        boolean r6 = false;
        if (r13.readInt() == 0) goto L5;
        boolean r7 = true;
    L7:
        if (r13.readInt() == 0) goto L10;
        r6 = true;
    L10:
        if (r13.readInt() != 0) goto L12;
        Long r8 = null;
    L14:
        if (r13.readInt() != 0) goto L16;
        Long r9 = null;
    L18:
        if (r13.readInt() != 0) goto L20;
        Long r14 = null;
    L22:
        return new OSkill(r2, r3, r4, r7, r6, r8, r9, r14);
    L20:
        r14 = Long.valueOf(r13.readLong());
        goto L22
    L16:
        r9 = Long.valueOf(r13.readLong());
        goto L18
    L12:
        r8 = Long.valueOf(r13.readLong());
        goto L14
    L5:
        r7 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final OSkill[] newArray(int r1) {
        return new OSkill[r1];
    }
}
