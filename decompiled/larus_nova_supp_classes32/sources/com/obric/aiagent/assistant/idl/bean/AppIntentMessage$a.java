package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentMessage$a implements Parcelable.Creator<AppIntentMessage> {
    public AppIntentMessage$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final AppIntentMessage createFromParcel(Parcel r15) {
        Intrinsics.checkNotNullParameter(r15, "parcel");
        DataSource r2 = (DataSource) DataSource.CREATOR.createFromParcel(r15);
        int r3 = 0;
        if (r15.readInt() == 0) goto L5;
        boolean r0 = true;
    L7:
        if (r15.readInt() == 0) goto L9;
        boolean r4 = true;
    L10:
        String r5 = r15.readString();
        String r6 = r15.readString();
        if (r15.readInt() == 0) goto L13;
        boolean r7 = true;
    L15:
        if (r15.readInt() == 0) goto L17;
        boolean r8 = true;
    L18:
        LinkedHashMap r9 = null;
        if (r15.readInt() != 0) goto L21;
        ArrayList r10 = null;
    L25:
        if (r15.readInt() != 0) goto L27;
        ArrayList r11 = null;
    L31:
        if (r15.readInt() == 0) goto L37;
        int r1 = r15.readInt();
        r9 = new LinkedHashMap(r1);
    L34:
        if (r3 == r1) goto L37;
        r9.put(r15.readString(), r15.readString());
        r3 = r3 + 1;
    L37:
        return new AppIntentMessage(r2, r0, r4, r5, r6, r7, r8, r10, r11, r9);
    L27:
        int r12 = r15.readInt();
        r11 = new ArrayList(r12);
        int r13 = 0;
    L28:
        if (r13 == r12) goto L31;
        r11.add(AppIntentCardData.CREATOR.createFromParcel(r15));
        r13 = r13 + 1;
        goto L28
    L21:
        int r14 = r15.readInt();
        r10 = new ArrayList(r14);
        int r16 = 0;
    L22:
        if (r16 == r14) goto L25;
        r10.add(r15.readParcelable(AppIntentMessage.class.getClassLoader()));
        r16 = r16 + 1;
        goto L22
    L17:
        r8 = false;
        goto L18
    L13:
        r7 = false;
        goto L15
    L9:
        r4 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public final AppIntentMessage[] newArray(int r1) {
        return new AppIntentMessage[r1];
    }
}
