package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class QuotaConfig$b implements Parcelable.Creator<QuotaConfig> {
    public QuotaConfig$b() {
    }

    @Override // android.os.Parcelable.Creator
    public final QuotaConfig createFromParcel(Parcel r29) {
        Intrinsics.checkNotNullParameter(r29, "parcel");
        if (r29.readInt() == 0) goto L5;
        boolean r5 = true;
    L6:
        String r6 = r29.readString();
        double r7 = r29.readDouble();
        if (r29.readInt() != 0) goto L9;
        ArrayList r9 = null;
    L12:
        ArrayList<String> r10 = r29.createStringArrayList();
        if (r29.readInt() == 0) goto L15;
        boolean r11 = true;
    L17:
        if (r29.readInt() != 0) goto L19;
        ArrayList r12 = null;
    L22:
        ArrayList<String> r13 = r29.createStringArrayList();
        if (r29.readInt() == 0) goto L25;
        boolean r14 = true;
    L27:
        if (r29.readInt() != 0) goto L29;
        ArrayList r15 = null;
    L32:
        ArrayList<String> r0 = r29.createStringArrayList();
        if (r29.readInt() == 0) goto L35;
        boolean r17 = true;
    L37:
        if (r29.readInt() != 0) goto L39;
        ArrayList r3 = null;
    L42:
        ArrayList<String> r1 = r29.createStringArrayList();
        if (r29.readInt() == 0) goto L45;
        boolean r20 = true;
    L47:
        if (r29.readInt() != 0) goto L49;
        ArrayList r2 = null;
    L53:
        ArrayList<String> r22 = r29.createStringArrayList();
        int r23 = r29.readInt();
        if (r29.readInt() == 0) goto L56;
        boolean r24 = true;
    L58:
        if (r29.readInt() != 0) goto L60;
        ArrayList r4 = null;
    L64:
        ArrayList<String> r26 = r29.createStringArrayList();
        if (r29.readInt() == 0) goto L67;
        boolean r27 = true;
    L69:
        return new QuotaConfig(r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r0, r17, r3, r1, r20, r2, r22, r23, r24, r4, r26, r27);
    L67:
        r27 = false;
        goto L69
    L60:
        int r8 = r29.readInt();
        ArrayList r16 = new ArrayList(r8);
        int r18 = 0;
    L61:
        if (r18 == r8) goto L63;
        int r19 = r8;
        r16.add(Long.valueOf(r29.readLong()));
        r18 = r18 + 1;
        r8 = r19;
        goto L61
    L63:
        r4 = r16;
        goto L64
    L56:
        r24 = false;
        goto L58
    L49:
        int r21 = r29.readInt();
        ArrayList r25 = new ArrayList(r21);
        int r28 = 0;
    L50:
        if (r28 == r21) goto L52;
        int r210 = r21;
        r25.add(Long.valueOf(r29.readLong()));
        r28 = r28 + 1;
        r21 = r210;
        goto L50
    L52:
        r2 = r25;
        goto L53
    L45:
        r20 = false;
        goto L47
    L39:
        int r30 = r29.readInt();
        r3 = new ArrayList(r30);
        int r31 = 0;
    L40:
        if (r31 == r30) goto L42;
        r3.add(Long.valueOf(r29.readLong()));
        r31 = r31 + 1;
        goto L40
    L35:
        r17 = false;
        goto L37
    L29:
        int r32 = r29.readInt();
        r15 = new ArrayList(r32);
        int r33 = 0;
    L30:
        if (r33 == r32) goto L32;
        r15.add(Long.valueOf(r29.readLong()));
        r33 = r33 + 1;
        goto L30
    L25:
        r14 = false;
        goto L27
    L19:
        int r34 = r29.readInt();
        r12 = new ArrayList(r34);
        int r110 = 0;
    L20:
        if (r110 == r34) goto L22;
        r12.add(Long.valueOf(r29.readLong()));
        r110 = r110 + 1;
        goto L20
    L15:
        r11 = false;
        goto L17
    L9:
        int r35 = r29.readInt();
        r9 = new ArrayList(r35);
        int r111 = 0;
    L10:
        if (r111 == r35) goto L12;
        r9.add(Long.valueOf(r29.readLong()));
        r111 = r111 + 1;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final QuotaConfig[] newArray(int r1) {
        return new QuotaConfig[r1];
    }
}
