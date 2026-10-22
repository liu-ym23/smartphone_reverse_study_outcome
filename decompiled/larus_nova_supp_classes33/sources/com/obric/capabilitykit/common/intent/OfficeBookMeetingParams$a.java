package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OfficeBookMeetingParams$a implements Parcelable.Creator<OfficeBookMeetingParams> {
    public OfficeBookMeetingParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OfficeBookMeetingParams createFromParcel(Parcel r13) {
        int r0 = r13.readInt();
        Intrinsics.checkNotNullParameter(r13, "parcel");
        OfficeBookMeetingParams r1 = new OfficeBookMeetingParams(r13.readString(), r13.readString(), r13.readString(), r13.createStringArray(), r13.readString(), null, null, 96, null);
        int r3 = Math.min(r0, 2);
        ClassLoader r4 = OfficeBookMeetingParams$a.class.getClassLoader();
        int r6 = 1;
    L3:
        if (r6 > r3) goto L13;
        if (r6 != 1) goto L8;
        Object r7 = a.c(r13, r4);
        if (r7 == null) goto L12;
        r1.participantsId = (String[]) r7;
    L12:
        r6 = r6 + 1;
        goto L3
    L8:
        if (r6 != 2) goto L12;
        Object r8 = a.c(r13, r4);
        if (r8 == null) goto L12;
        r1.version = (Integer) r8;
    L13:
        if (r6 > r0) goto L15;
        a.d(r13, r4);
        r6 = r6 + 1;
        goto L13
    L15:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final OfficeBookMeetingParams[] newArray(int r1) {
        return new OfficeBookMeetingParams[r1];
    }
}
