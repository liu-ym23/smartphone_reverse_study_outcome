package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class NotesSearchParams$a implements Parcelable.Creator<NotesSearchParams> {
    public NotesSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final NotesSearchParams createFromParcel(Parcel r14) {
        int r0 = r14.readInt();
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r3 = r14.readString();
        if (r14.readInt() != 0) goto L5;
        Long r5 = null;
    L7:
        if (r14.readInt() != 0) goto L9;
        Long r6 = null;
    L10:
        int r11 = 1;
        if (r14.readInt() != 0) goto L14;
        Boolean r7 = null;
    L18:
        String r8 = r14.readString();
        String r9 = r14.readString();
        if (r14.readInt() != 0) goto L21;
        Integer r12 = null;
    L22:
        NotesSearchParams r1 = new NotesSearchParams(r3, r5, r6, r7, r8, r9, r12);
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = NotesSearchParams$a.class.getClassLoader();
    L23:
        if (r11 > r2) goto L25;
        r11 = r11 + 1;
    L25:
        if (r11 > r0) goto L27;
        a.d(r14, r4);
        r11 = r11 + 1;
        goto L25
    L27:
        return r1;
    L21:
        r12 = Integer.valueOf(r14.readInt());
        goto L22
    L14:
        if (r14.readInt() == 0) goto L16;
        boolean r10 = true;
    L17:
        r7 = Boolean.valueOf(r10);
        goto L18
    L16:
        r10 = false;
        goto L17
    L9:
        r6 = Long.valueOf(r14.readLong());
        goto L10
    L5:
        r5 = Long.valueOf(r14.readLong());
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final NotesSearchParams[] newArray(int r1) {
        return new NotesSearchParams[r1];
    }
}
