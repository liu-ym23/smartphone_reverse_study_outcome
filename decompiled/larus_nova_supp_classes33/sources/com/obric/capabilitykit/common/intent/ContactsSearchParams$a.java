package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import joa.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ContactsSearchParams$a implements Parcelable.Creator<ContactsSearchParams> {
    public ContactsSearchParams$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsSearchParams createFromParcel(Parcel r12) {
        int r0 = r12.readInt();
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r3 = r12.readString();
        String r4 = r12.readString();
        String r5 = r12.readString();
        String r6 = r12.readString();
        String r7 = r12.readString();
        String r8 = r12.readString();
        String r9 = r12.readString();
        if (r12.readInt() != 0) goto L5;
        Integer r2 = null;
    L6:
        ContactsSearchParams r1 = new ContactsSearchParams(r3, r4, r5, r6, r7, r8, r9, r2);
        int r10 = Math.min(r0, 0);
        ClassLoader r11 = ContactsSearchParams$a.class.getClassLoader();
        int r13 = 1;
    L7:
        if (r13 > r10) goto L9;
        r13 = r13 + 1;
    L9:
        if (r13 > r0) goto L11;
        a.d(r12, r11);
        r13 = r13 + 1;
        goto L9
    L11:
        return r1;
    L5:
        r2 = Integer.valueOf(r12.readInt());
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final ContactsSearchParams[] newArray(int r1) {
        return new ContactsSearchParams[r1];
    }
}
