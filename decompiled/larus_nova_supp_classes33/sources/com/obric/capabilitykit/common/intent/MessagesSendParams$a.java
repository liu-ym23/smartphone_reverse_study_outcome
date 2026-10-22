package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MessagesSendParams$a implements Parcelable.Creator<MessagesSendParams> {
    public MessagesSendParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesSendParams createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        Object r3 = null;
        if (r6.readInt() != 0) goto L5;
        Object r2 = null;
    L6:
        ContactTarget r4 = (ContactTarget) r2;
        if (r6.readInt() == 0) goto L10;
        r3 = MessageContent.CREATOR.createFromParcel(r6);
    L10:
        MessagesSendParams r1 = new MessagesSendParams(r4, (MessageContent) r3);
        int r5 = Math.min(r0, 0);
        ClassLoader r7 = MessagesSendParams$a.class.getClassLoader();
        int r8 = 1;
    L11:
        if (r8 > r5) goto L13;
        r8 = r8 + 1;
    L13:
        if (r8 > r0) goto L15;
        a.d(r6, r7);
        r8 = r8 + 1;
        goto L13
    L15:
        return r1;
    L5:
        r2 = ContactTarget.CREATOR.createFromParcel(r6);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesSendParams[] newArray(int r1) {
        return new MessagesSendParams[r1];
    }
}
