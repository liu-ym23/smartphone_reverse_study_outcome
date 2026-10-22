package com.ss.android.lark.passport.flow.auth_type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ContactPointTypeEnum extends Enum<ContactPointTypeEnum> {
    public static final ContactPointTypeEnum IDP = null;
    public static final ContactPointTypeEnum MAIL = null;
    public static final ContactPointTypeEnum OTHERS = null;
    public static final ContactPointTypeEnum PHONE = null;
    public static final ContactPointTypeEnum QR = null;
    public static final /* synthetic */ ContactPointTypeEnum[] a = null;
    private final int type;

    static {
        ContactPointTypeEnum r0 = new ContactPointTypeEnum("PHONE", 0, 1);
        PHONE = r0;
        ContactPointTypeEnum r1 = new ContactPointTypeEnum("MAIL", 1, 2);
        MAIL = r1;
        ContactPointTypeEnum r4 = new ContactPointTypeEnum("IDP", 2, 32);
        IDP = r4;
        ContactPointTypeEnum r6 = new ContactPointTypeEnum("QR", 3, 4);
        QR = r6;
        ContactPointTypeEnum r7 = new ContactPointTypeEnum("OTHERS", 4, -1);
        OTHERS = r7;
        a = new ContactPointTypeEnum[]{r0, r1, r4, r6, r7};
    }

    public static ContactPointTypeEnum[] values() {
        return (ContactPointTypeEnum[]) a.clone();
    }

    public int value() {
        return this.type;
    }

    public static ContactPointTypeEnum fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 4) goto L15;
        if (r1 == 32) goto L13;
        return OTHERS;
    L13:
        return IDP;
    L15:
        return QR;
    L17:
        return MAIL;
    L19:
        return PHONE;
    }

    public static ContactPointTypeEnum valueOf(String r1) {
        return (ContactPointTypeEnum) r27.a.a(ContactPointTypeEnum.class, r1);
    }

    public ContactPointTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
