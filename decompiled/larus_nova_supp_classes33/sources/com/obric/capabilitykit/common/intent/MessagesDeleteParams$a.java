package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.MessageEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MessagesDeleteParams$a implements Parcelable.Creator<MessagesDeleteParams> {
    public MessagesDeleteParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesDeleteParams createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        if (r7.readInt() != 0) goto L5;
        MessageEntity[] r1 = null;
    L9:
        MessagesDeleteParams r3 = new MessagesDeleteParams(r1);
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = MessagesDeleteParams$a.class.getClassLoader();
        int r5 = 1;
    L10:
        if (r5 > r2) goto L12;
        r5 = r5 + 1;
    L12:
        if (r5 > r0) goto L14;
        a.d(r7, r4);
        r5 = r5 + 1;
        goto L12
    L14:
        return r3;
    L5:
        int r6 = r7.readInt();
        MessageEntity[] r8 = new MessageEntity[r6];
        int r9 = 0;
    L6:
        if (r9 == r6) goto L8;
        r8[r9] = (MessageEntity) r7.readParcelable(MessagesDeleteParams.class.getClassLoader());
        r9 = r9 + 1;
        goto L6
    L8:
        r1 = r8;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final MessagesDeleteParams[] newArray(int r1) {
        return new MessagesDeleteParams[r1];
    }
}
