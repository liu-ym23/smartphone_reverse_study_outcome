package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class DMTaskInfo$a implements Parcelable.Creator<DMTaskInfo> {
    public DMTaskInfo$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final DMTaskInfo createFromParcel(Parcel r12) {
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r2 = r12.readString();
        int r3 = r12.readInt();
        LinkedHashMap r1 = null;
        if (r12.readInt() != 0) goto L5;
        Object r0 = null;
    L6:
        IMMessage r4 = (IMMessage) r0;
        long r5 = r12.readLong();
        if (r12.readInt() != 0) goto L9;
        Integer r7 = null;
    L11:
        if (r12.readInt() == 0) goto L17;
        int r6 = r12.readInt();
        r1 = new LinkedHashMap(r6);
        int r8 = 0;
    L14:
        if (r8 == r6) goto L17;
        r1.put(r12.readString(), r12.readString());
        r8 = r8 + 1;
    L17:
        return new DMTaskInfo(r2, r3, r4, r5, r7, r1);
    L9:
        r7 = Integer.valueOf(r12.readInt());
        goto L11
    L5:
        r0 = IMMessage.CREATOR.createFromParcel(r12);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final DMTaskInfo[] newArray(int r1) {
        return new DMTaskInfo[r1];
    }
}
