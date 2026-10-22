package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ContactEntity;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactsUpdateParams$a implements Parcelable.Creator<ContactsUpdateParams> {
    public ContactsUpdateParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsUpdateParams createFromParcel(Parcel r17) {
        int r1 = r17.readInt();
        Intrinsics.checkNotNullParameter(r17, "parcel");
        ContactEntity r4 = r17.readParcelable(ContactsUpdateParams.class.getClassLoader());
        String r5 = r17.readString();
        if (r17.readInt() != 0) goto L5;
        Telephone[] r6 = null;
    L9:
        ContactsUpdateParams r2 = new ContactsUpdateParams(r4, r5, r6, r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString());
        int r3 = Math.min(r1, 0);
        ClassLoader r7 = ContactsUpdateParams$a.class.getClassLoader();
        int r8 = 1;
    L10:
        if (r8 > r3) goto L12;
        r8 = r8 + 1;
    L12:
        if (r8 > r1) goto L14;
        a.d(r17, r7);
        r8 = r8 + 1;
        goto L12
    L14:
        return r2;
    L5:
        int r9 = r17.readInt();
        Telephone[] r10 = new Telephone[r9];
        int r11 = 0;
    L6:
        if (r11 == r9) goto L8;
        r10[r11] = Telephone.CREATOR.createFromParcel(r17);
        r11 = r11 + 1;
        goto L6
    L8:
        r6 = r10;
        goto L9
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsUpdateParams[] newArray(int r1) {
        return new ContactsUpdateParams[r1];
    }
}
