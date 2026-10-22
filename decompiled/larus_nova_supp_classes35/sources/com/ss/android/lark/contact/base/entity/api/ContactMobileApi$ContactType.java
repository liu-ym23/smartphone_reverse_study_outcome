package com.ss.android.lark.contact.base.entity.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ContactMobileApi$ContactType extends Enum<ContactMobileApi$ContactType> {
    public static final ContactMobileApi$ContactType EMAIL = null;
    public static final ContactMobileApi$ContactType PHONE = null;
    public static final /* synthetic */ ContactMobileApi$ContactType[] a = null;

    static {
        ContactMobileApi$ContactType r0 = new ContactMobileApi$ContactType("EMAIL", 0);
        EMAIL = r0;
        ContactMobileApi$ContactType r1 = new ContactMobileApi$ContactType("PHONE", 1);
        PHONE = r1;
        a = new ContactMobileApi$ContactType[]{r0, r1};
    }

    public static ContactMobileApi$ContactType[] values() {
        return (ContactMobileApi$ContactType[]) a.clone();
    }

    public static ContactMobileApi$ContactType valueOf(String r1) {
        return (ContactMobileApi$ContactType) a.a(ContactMobileApi$ContactType.class, r1);
    }

    public ContactMobileApi$ContactType(String r1, int r2) {
        super(r1, r2);
    }
}
