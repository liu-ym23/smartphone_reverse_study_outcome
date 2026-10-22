package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactsAddToBlocklistParams$a implements Parcelable.Creator<ContactsAddToBlocklistParams> {
    public ContactsAddToBlocklistParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsAddToBlocklistParams createFromParcel(Parcel r8) {
        int r0 = r8.readInt();
        Intrinsics.checkNotNullParameter(r8, "parcel");
        Boolean r3 = null;
        if (r8.readInt() != 0) goto L5;
        Object r2 = null;
    L6:
        BlockListTarget r4 = (BlockListTarget) r2;
        int r6 = 1;
        if (r8.readInt() != 0) goto L10;
    L14:
        ContactsAddToBlocklistParams r1 = new ContactsAddToBlocklistParams(r4, r3);
        int r5 = Math.min(r0, 0);
        ClassLoader r7 = ContactsAddToBlocklistParams$a.class.getClassLoader();
    L15:
        if (r6 > r5) goto L17;
        r6 = r6 + 1;
    L17:
        if (r6 > r0) goto L19;
        a.d(r8, r7);
        r6 = r6 + 1;
        goto L17
    L19:
        return r1;
    L10:
        if (r8.readInt() == 0) goto L12;
        boolean r9 = true;
    L13:
        r3 = Boolean.valueOf(r9);
        goto L14
    L12:
        r9 = false;
        goto L13
    L5:
        r2 = BlockListTarget.CREATOR.createFromParcel(r8);
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsAddToBlocklistParams[] newArray(int r1) {
        return new ContactsAddToBlocklistParams[r1];
    }
}
