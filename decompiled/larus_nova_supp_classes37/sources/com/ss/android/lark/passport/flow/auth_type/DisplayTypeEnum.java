package com.ss.android.lark.passport.flow.auth_type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DisplayTypeEnum extends Enum<DisplayTypeEnum> {
    public static final DisplayTypeEnum APPLE = null;
    public static final DisplayTypeEnum GOOGLE = null;
    public static final DisplayTypeEnum IDP = null;
    public static final DisplayTypeEnum MAIL = null;
    public static final DisplayTypeEnum OTHERS = null;
    public static final DisplayTypeEnum OTP = null;
    public static final DisplayTypeEnum PASSWORD = null;
    public static final DisplayTypeEnum PHONE = null;
    public static final DisplayTypeEnum QR = null;
    public static final DisplayTypeEnum SPARE = null;
    public static final /* synthetic */ DisplayTypeEnum[] a = null;
    private final int iconRes;
    private final int type;

    static {
        DisplayTypeEnum r0 = new DisplayTypeEnum("PHONE", 0, ContactPointTypeEnum.PHONE.value(), 2131254072);
        PHONE = r0;
        DisplayTypeEnum r1 = new DisplayTypeEnum("MAIL", 1, ContactPointTypeEnum.MAIL.value(), 2131255069);
        MAIL = r1;
        DisplayTypeEnum r2 = new DisplayTypeEnum("OTP", 2, 3, 2131248213);
        OTP = r2;
        DisplayTypeEnum r3 = new DisplayTypeEnum("GOOGLE", 3, 4, 2131254826);
        GOOGLE = r3;
        DisplayTypeEnum r5 = new DisplayTypeEnum("APPLE", 4, 5, 2131253651);
        APPLE = r5;
        DisplayTypeEnum r9 = new DisplayTypeEnum("PASSWORD", 5, 6, 2131255047);
        PASSWORD = r9;
        DisplayTypeEnum r11 = new DisplayTypeEnum("SPARE", 6, 6, 2131255591);
        SPARE = r11;
        DisplayTypeEnum r13 = new DisplayTypeEnum("IDP", 7, ContactPointTypeEnum.IDP.value(), 2131248214);
        IDP = r13;
        DisplayTypeEnum r12 = new DisplayTypeEnum("QR", 8, ContactPointTypeEnum.QR.value(), 2131255472);
        QR = r12;
        DisplayTypeEnum r10 = new DisplayTypeEnum("OTHERS", 9, ContactPointTypeEnum.OTHERS.value(), 2131255098);
        OTHERS = r10;
        a = new DisplayTypeEnum[]{r0, r1, r2, r3, r5, r9, r11, r13, r12, r10};
    }

    public static DisplayTypeEnum[] values() {
        return (DisplayTypeEnum[]) a.clone();
    }

    public int getIconRes() {
        return this.iconRes;
    }

    public int value() {
        return this.type;
    }

    public static DisplayTypeEnum fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 32) goto L13;
        return OTHERS;
    L13:
        return IDP;
    L15:
        return OTP;
    L17:
        return MAIL;
    L19:
        return PHONE;
    }

    public static DisplayTypeEnum valueOf(String r1) {
        return (DisplayTypeEnum) r27.a.a(DisplayTypeEnum.class, r1);
    }

    public DisplayTypeEnum(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.type = r3;
        this.iconRes = r4;
    }
}
