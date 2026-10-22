package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IMMessage$a implements Parcelable.Creator<IMMessage> {
    public IMMessage$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final IMMessage createFromParcel(Parcel r29) {
        Intrinsics.checkNotNullParameter(r29, "parcel");
        String r3 = r29.readString();
        String r4 = r29.readString();
        int r5 = r29.readInt();
        int r6 = r29.readInt();
        int r7 = r29.readInt();
        int r8 = r29.readInt();
        int r2 = 0;
        if (r29.readInt() == 0) goto L5;
        boolean r9 = true;
    L6:
        String r10 = r29.readString();
        LinkedHashMap r11 = null;
        if (r29.readInt() != 0) goto L9;
        ArrayList r12 = null;
    L13:
        if (r29.readInt() != 0) goto L15;
    L14:
        LinkedHashMap r0 = r11;
        String r13 = r29.readString();
        String r14 = r29.readString();
        long r15 = r29.readLong();
        long r17 = r29.readLong();
        String r19 = r29.readString();
        int r16 = r29.readInt();
        LinkedHashMap r1 = new LinkedHashMap(r16);
    L19:
        if (r2 == r16) goto L22;
        r1.put(r29.readString(), r29.readString());
        r2 = r2 + 1;
        r16 = r16;
        r15 = r15;
        goto L19
    L22:
        return new IMMessage(r3, r4, r5, r6, r7, r8, r9, r10, r12, r0, r13, r14, r15, r17, r19, r1, r29.readString(), r29.readString(), r29.readLong());
    L15:
        int r18 = r29.readInt();
        r11 = new LinkedHashMap(r18);
        int r110 = 0;
    L16:
        if (r110 == r18) goto L14;
        r11.put(r29.readString(), r29.readString());
        r110 = r110 + 1;
        goto L16
    L9:
        int r20 = r29.readInt();
        r12 = new ArrayList(r20);
        int r111 = 0;
    L10:
        if (r111 == r20) goto L13;
        r12.add(r29.readSerializable());
        r111 = r111 + 1;
        goto L10
    L5:
        r9 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final IMMessage[] newArray(int r1) {
        return new IMMessage[r1];
    }
}
