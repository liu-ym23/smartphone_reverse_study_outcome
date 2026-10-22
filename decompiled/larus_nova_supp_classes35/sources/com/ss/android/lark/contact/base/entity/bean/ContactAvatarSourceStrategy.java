package com.ss.android.lark.contact.base.entity.bean;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ContactAvatarSourceStrategy extends Enum<ContactAvatarSourceStrategy> {
    public static final ContactAvatarSourceStrategy FOREGROUND_USER = null;
    public static final ContactAvatarSourceStrategy LOGIN_CHATTER = null;
    public static final /* synthetic */ ContactAvatarSourceStrategy[] a = null;

    static {
        ContactAvatarSourceStrategy r0 = new ContactAvatarSourceStrategy("FOREGROUND_USER", 0);
        FOREGROUND_USER = r0;
        ContactAvatarSourceStrategy r1 = new ContactAvatarSourceStrategy("LOGIN_CHATTER", 1);
        LOGIN_CHATTER = r1;
        a = new ContactAvatarSourceStrategy[]{r0, r1};
    }

    public static ContactAvatarSourceStrategy[] values() {
        return (ContactAvatarSourceStrategy[]) a.clone();
    }

    public static ContactAvatarSourceStrategy valueOf(String r1) {
        return (ContactAvatarSourceStrategy) a.a(ContactAvatarSourceStrategy.class, r1);
    }

    public ContactAvatarSourceStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
