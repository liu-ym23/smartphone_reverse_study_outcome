package com.ss.android.lark.pb.misc;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
    private static final /* synthetic */ DeniedReason[] $VALUES = null;
    public static final ProtoAdapter<DeniedReason> ADAPTER = null;
    public static final DeniedReason BE_BLOCKED = null;
    public static final DeniedReason BLOCKED = null;
    public static final DeniedReason CROSS_TENANT_DENY = null;
    public static final DeniedReason CRYPTO_CHAT_DENY = null;
    public static final DeniedReason EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason NOT_SUPPORT_AI = null;
    public static final DeniedReason NO_FRIENDSHIP = null;
    public static final DeniedReason PRIVACY_SETTING = null;
    public static final DeniedReason PRIVATE_CALENDAR = null;
    public static final DeniedReason PRIVATE_CHAT_CROSS_TENANT = null;
    public static final DeniedReason PRIVATE_CHAT_DENY = null;
    public static final DeniedReason PRIVATE_CHAT_DISABLED = null;
    public static final DeniedReason PRIVATE_CHAT_KMS_UNAVAILABLE = null;
    public static final DeniedReason SAME_TENANT_DENY = null;
    public static final DeniedReason SEND_SECRET_CHAT_BY_ICON_DENY = null;
    public static final DeniedReason TARGET_EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason TARGET_PRIVACY_SETTING = null;
    public static final DeniedReason UNKNOWN_REASON = null;
    private final int value;

    static {
        DeniedReason r0 = new DeniedReason("UNKNOWN_REASON", 0, 0);
        UNKNOWN_REASON = r0;
        DeniedReason r1 = new DeniedReason("BE_BLOCKED", 1, 1);
        BE_BLOCKED = r1;
        DeniedReason r3 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
        CROSS_TENANT_DENY = r3;
        DeniedReason r5 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
        SAME_TENANT_DENY = r5;
        DeniedReason r7 = new DeniedReason("CRYPTO_CHAT_DENY", 4, 4);
        CRYPTO_CHAT_DENY = r7;
        DeniedReason r9 = new DeniedReason("BLOCKED", 5, 5);
        BLOCKED = r9;
        DeniedReason r11 = new DeniedReason("NO_FRIENDSHIP", 6, 6);
        NO_FRIENDSHIP = r11;
        DeniedReason r13 = new DeniedReason("PRIVACY_SETTING", 7, 7);
        PRIVACY_SETTING = r13;
        DeniedReason r15 = new DeniedReason("TARGET_PRIVACY_SETTING", 8, 8);
        TARGET_PRIVACY_SETTING = r15;
        DeniedReason r14 = new DeniedReason("PRIVATE_CALENDAR", 9, 9);
        PRIVATE_CALENDAR = r14;
        DeniedReason r12 = new DeniedReason("EXTERNAL_COORDINATE_CTL", 10, 10);
        EXTERNAL_COORDINATE_CTL = r12;
        DeniedReason r10 = new DeniedReason("TARGET_EXTERNAL_COORDINATE_CTL", 11, 11);
        TARGET_EXTERNAL_COORDINATE_CTL = r10;
        DeniedReason r8 = new DeniedReason("SEND_SECRET_CHAT_BY_ICON_DENY", 12, 12);
        SEND_SECRET_CHAT_BY_ICON_DENY = r8;
        DeniedReason r6 = new DeniedReason("PRIVATE_CHAT_DISABLED", 13, 15);
        PRIVATE_CHAT_DISABLED = r6;
        DeniedReason r4 = new DeniedReason("PRIVATE_CHAT_KMS_UNAVAILABLE", 14, 16);
        PRIVATE_CHAT_KMS_UNAVAILABLE = r4;
        DeniedReason r2 = new DeniedReason("PRIVATE_CHAT_DENY", 15, 17);
        PRIVATE_CHAT_DENY = r2;
        DeniedReason r16 = new DeniedReason("PRIVATE_CHAT_CROSS_TENANT", 16, 18);
        PRIVATE_CHAT_CROSS_TENANT = r16;
        DeniedReason r17 = new DeniedReason("NOT_SUPPORT_AI", 17, 51);
        NOT_SUPPORT_AI = r17;
        $VALUES = new DeniedReason[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
        ADAPTER = ProtoAdapter.newEnumAdapter(DeniedReason.class);
    }

    public static DeniedReason[] values() {
        return (DeniedReason[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DeniedReason fromValue(int r1) {
        if (r1 == 51) goto L43;
        switch(r1) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L25;
            case 9: goto L23;
            case 10: goto L21;
            case 11: goto L19;
            case 12: goto L17;
            default: goto L5;
        };
    L5:
        switch(r1) {
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L6;
        };
    L6:
        return null;
    L9:
        return PRIVATE_CHAT_CROSS_TENANT;
    L11:
        return PRIVATE_CHAT_DENY;
    L13:
        return PRIVATE_CHAT_KMS_UNAVAILABLE;
    L15:
        return PRIVATE_CHAT_DISABLED;
    L17:
        return SEND_SECRET_CHAT_BY_ICON_DENY;
    L19:
        return TARGET_EXTERNAL_COORDINATE_CTL;
    L21:
        return EXTERNAL_COORDINATE_CTL;
    L23:
        return PRIVATE_CALENDAR;
    L25:
        return TARGET_PRIVACY_SETTING;
    L27:
        return PRIVACY_SETTING;
    L29:
        return NO_FRIENDSHIP;
    L31:
        return BLOCKED;
    L33:
        return CRYPTO_CHAT_DENY;
    L35:
        return SAME_TENANT_DENY;
    L37:
        return CROSS_TENANT_DENY;
    L39:
        return BE_BLOCKED;
    L41:
        return UNKNOWN_REASON;
    L43:
        return NOT_SUPPORT_AI;
    }

    public static DeniedReason valueOf(String r1) {
        return (DeniedReason) a.a(DeniedReason.class, r1);
    }

    private DeniedReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
