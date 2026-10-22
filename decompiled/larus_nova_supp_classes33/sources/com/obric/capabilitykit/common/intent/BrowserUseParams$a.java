package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class BrowserUseParams$a implements Parcelable.Creator<BrowserUseParams> {
    public BrowserUseParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final BrowserUseParams createFromParcel(Parcel r32) {
        int r1 = r32.readInt();
        Intrinsics.checkNotNullParameter(r32, "parcel");
        String r4 = r32.readString();
        String r5 = r32.readString();
        if (r32.readInt() != 0) goto L5;
        Integer r6 = null;
    L6:
        String r7 = r32.readString();
        if (r32.readInt() != 0) goto L9;
        Integer r8 = null;
    L11:
        if (r32.readInt() != 0) goto L14;
        Boolean r9 = null;
    L18:
        String r10 = r32.readString();
        String r11 = r32.readString();
        String r12 = r32.readString();
        if (r32.readInt() != 0) goto L21;
        Integer r13 = null;
    L22:
        String r14 = r32.readString();
        String r2 = r32.readString();
        String r16 = r32.readString();
        String r17 = r32.readString();
        if (r32.readInt() != 0) goto L25;
        BrowserUseInput[] r3 = null;
    L30:
        if (r32.readInt() != 0) goto L32;
        Integer r20 = null;
    L33:
        String r21 = r32.readString();
        if (r32.readInt() != 0) goto L36;
        Integer r29 = null;
    L37:
        BrowserUseInput[] r18 = r3;
        Integer r19 = r20;
        Integer r22 = r29;
        BrowserUseParams r30 = new BrowserUseParams(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, r16, r17, r18, r19, r21, r22, r32.readString(), r32.readString(), r32.readString(), r32.readString(), r32.readString());
        int r0 = Math.min(r1, 0);
        ClassLoader r15 = BrowserUseParams$a.class.getClassLoader();
        int r23 = 1;
    L38:
        if (r23 > r0) goto L40;
        r23 = r23 + 1;
    L40:
        if (r23 > r1) goto L42;
        a.d(r32, r15);
        r23 = r23 + 1;
        goto L40
    L42:
        return r30;
    L36:
        r29 = Integer.valueOf(r32.readInt());
        goto L37
    L32:
        r20 = Integer.valueOf(r32.readInt());
        goto L33
    L25:
        int r24 = r32.readInt();
        BrowserUseInput[] r110 = new BrowserUseInput[r24];
        int r25 = 0;
    L26:
        if (r25 == r24) goto L28;
        int r26 = r24;
        r110[r25] = BrowserUseInput.CREATOR.createFromParcel(r32);
        r25 = r25 + 1;
        r24 = r26;
        goto L26
    L28:
        r3 = r110;
        goto L30
    L21:
        r13 = Integer.valueOf(r32.readInt());
        goto L22
    L14:
        if (r32.readInt() == 0) goto L16;
        boolean r27 = true;
    L17:
        r9 = Boolean.valueOf(r27);
        goto L18
    L16:
        r27 = false;
        goto L17
    L9:
        r8 = Integer.valueOf(r32.readInt());
        goto L11
    L5:
        r6 = Integer.valueOf(r32.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final BrowserUseParams[] newArray(int r1) {
        return new BrowserUseParams[r1];
    }
}
