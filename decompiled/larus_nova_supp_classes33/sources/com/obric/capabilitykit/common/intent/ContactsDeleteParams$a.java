package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ContactEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactsDeleteParams$a implements Parcelable.Creator<ContactsDeleteParams> {
    public ContactsDeleteParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsDeleteParams createFromParcel(Parcel r7) {
        int r0 = r7.readInt();
        Intrinsics.checkNotNullParameter(r7, "parcel");
        if (r7.readInt() != 0) goto L5;
        ContactEntity[] r1 = null;
    L9:
        ContactsDeleteParams r3 = new ContactsDeleteParams(r1);
        int r2 = Math.min(r0, 0);
        ClassLoader r4 = ContactsDeleteParams$a.class.getClassLoader();
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
        ContactEntity[] r8 = new ContactEntity[r6];
        int r9 = 0;
    L6:
        if (r9 == r6) goto L8;
        r8[r9] = (ContactEntity) r7.readParcelable(ContactsDeleteParams.class.getClassLoader());
        r9 = r9 + 1;
        goto L6
    L8:
        r1 = r8;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsDeleteParams[] newArray(int r1) {
        return new ContactsDeleteParams[r1];
    }
}
