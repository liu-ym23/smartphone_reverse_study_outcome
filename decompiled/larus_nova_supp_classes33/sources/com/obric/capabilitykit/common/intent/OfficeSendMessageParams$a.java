package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OfficeSendMessageParams$a implements Parcelable.Creator<OfficeSendMessageParams> {
    public OfficeSendMessageParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final OfficeSendMessageParams createFromParcel(Parcel r11) {
        int r0 = r11.readInt();
        Intrinsics.checkNotNullParameter(r11, "parcel");
        String r3 = r11.readString();
        String r4 = r11.readString();
        String r5 = r11.readString();
        if (r11.readInt() != 0) goto L5;
        Object r2 = null;
    L6:
        OfficeSendMessageParams r1 = new OfficeSendMessageParams(r3, r4, r5, (OfficeMessageContent) r2, null, 16, null);
        int r6 = Math.min(r0, 1);
        ClassLoader r7 = OfficeSendMessageParams$a.class.getClassLoader();
        int r8 = 1;
    L7:
        if (r8 > r6) goto L13;
        if (r8 != 1) goto L12;
        Object r9 = a.c(r11, r7);
        if (r9 == null) goto L12;
        r1.version = (Integer) r9;
    L12:
        r8 = r8 + 1;
    L13:
        if (r8 > r0) goto L15;
        a.d(r11, r7);
        r8 = r8 + 1;
        goto L13
    L15:
        return r1;
    L5:
        r2 = OfficeMessageContent.CREATOR.createFromParcel(r11);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final OfficeSendMessageParams[] newArray(int r1) {
        return new OfficeSendMessageParams[r1];
    }
}
