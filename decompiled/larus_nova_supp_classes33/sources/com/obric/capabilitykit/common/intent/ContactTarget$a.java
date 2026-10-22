package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactTarget$a implements Parcelable.Creator<ContactTarget> {
    public ContactTarget$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactTarget createFromParcel(Parcel r6) {
        int r0 = r6.readInt();
        Intrinsics.checkNotNullParameter(r6, "parcel");
        ContactTarget r1 = new ContactTarget(r6.readString(), r6.readParcelable(ContactTarget.class.getClassLoader()));
        int r2 = Math.min(r0, 0);
        ClassLoader r3 = ContactTarget$a.class.getClassLoader();
        int r4 = 1;
    L3:
        if (r4 > r2) goto L5;
        r4 = r4 + 1;
    L5:
        if (r4 > r0) goto L7;
        a.d(r6, r3);
        r4 = r4 + 1;
        goto L5
    L7:
        return r1;
    }

    @Override // android.os.Parcelable.Creator
    public final ContactTarget[] newArray(int r1) {
        return new ContactTarget[r1];
    }
}
