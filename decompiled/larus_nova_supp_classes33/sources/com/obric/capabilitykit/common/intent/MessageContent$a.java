package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class MessageContent$a implements Parcelable.Creator<MessageContent> {
    public MessageContent$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final MessageContent createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        MessageContent r1 = new MessageContent(r7.readString(), r7.readParcelable(MessageContent.class.getClassLoader()), r7.readParcelable(MessageContent.class.getClassLoader()), r7.readParcelable(MessageContent.class.getClassLoader()));
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = MessageContent$a.class.getClassLoader();
        int r4 = 1;
    L3:
        if (r4 > r2) goto L5;
        r4 = r4 + 1;
    L5:
        if (r4 > r0) goto L7;
        a.d(r7, r3);
        r4 = r4 + 1;
        goto L5
    L7:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final MessageContent[] newArray(int r1) {
        return new MessageContent[r1];
    }
}
