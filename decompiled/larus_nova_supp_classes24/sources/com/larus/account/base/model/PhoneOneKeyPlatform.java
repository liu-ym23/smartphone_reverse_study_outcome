package com.larus.account.base.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum PhoneOneKeyPlatform extends Enum<PhoneOneKeyPlatform> {
    public static final PhoneOneKeyPlatform MOBILE = null;
    public static final PhoneOneKeyPlatform TELECOM = null;
    public static final PhoneOneKeyPlatform UNICOM = null;
    public static final PhoneOneKeyPlatform UNKNOWN = null;
    public static final /* synthetic */ PhoneOneKeyPlatform[] a = null;

    static {
        PhoneOneKeyPlatform r0 = new PhoneOneKeyPlatform("MOBILE", 0);
        MOBILE = r0;
        PhoneOneKeyPlatform r1 = new PhoneOneKeyPlatform("TELECOM", 1);
        TELECOM = r1;
        PhoneOneKeyPlatform r3 = new PhoneOneKeyPlatform("UNICOM", 2);
        UNICOM = r3;
        PhoneOneKeyPlatform r5 = new PhoneOneKeyPlatform("UNKNOWN", 3);
        UNKNOWN = r5;
        a = new PhoneOneKeyPlatform[]{r0, r1, r3, r5};
    }

    public static PhoneOneKeyPlatform[] values() {
        return (PhoneOneKeyPlatform[]) a.clone();
    }

    public static PhoneOneKeyPlatform valueOf(String r1) {
        return (PhoneOneKeyPlatform) a.a(PhoneOneKeyPlatform.class, r1);
    }

    public PhoneOneKeyPlatform(String r1, int r2) {
        super(r1, r2);
    }
}
