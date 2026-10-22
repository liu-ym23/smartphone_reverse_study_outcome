package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactsCreateParams$a implements Parcelable.Creator<ContactsCreateParams> {
    public ContactsCreateParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsCreateParams createFromParcel(Parcel r15) {
        int r0 = r15.readInt();
        Intrinsics.checkNotNullParameter(r15, "parcel");
        String r3 = r15.readString();
        if (r15.readInt() != 0) goto L5;
        Telephone[] r4 = null;
    L9:
        ContactsCreateParams r1 = new ContactsCreateParams(r3, r4, r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readString());
        int r2 = Math.min(r0, 0);
        ClassLoader r5 = ContactsCreateParams$a.class.getClassLoader();
        int r6 = 1;
    L10:
        if (r6 > r2) goto L12;
        r6 = r6 + 1;
    L12:
        if (r6 > r0) goto L14;
        a.d(r15, r5);
        r6 = r6 + 1;
        goto L12
    L14:
        return r1;
    L5:
        int r7 = r15.readInt();
        Telephone[] r8 = new Telephone[r7];
        int r9 = 0;
    L6:
        if (r9 == r7) goto L8;
        r8[r9] = Telephone.CREATOR.createFromParcel(r15);
        r9 = r9 + 1;
        goto L6
    L8:
        r4 = r8;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsCreateParams[] newArray(int r1) {
        return new ContactsCreateParams[r1];
    }
}
