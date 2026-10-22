package com.ss.android.lark.passport.signinsdk_api.feature.listener.logout;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum LogoutReason extends Enum<LogoutReason> {
    public static final LogoutReason ADMIN_KICKOUT_WIPE = null;
    public static final LogoutReason BASICMODEL_LOGOUT_JSB = null;
    public static final LogoutReason DEVICE_IS_MIGRATE = null;
    public static final LogoutReason EMM_TASK = null;
    public static final LogoutReason ENCRYPT_KEY_EMPTY = null;
    public static final LogoutReason EXCEED_LIMIT_CAUSE_LOGOUT = null;
    public static final LogoutReason FORGOT_DIGITAL_CODE = null;
    public static final LogoutReason IDP_CLIENT_TYPE_CHANGE = null;
    public static final LogoutReason IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER = null;
    public static final LogoutReason IDP_REFRESH_TOKEN_INVALID_FOR_INIT = null;
    public static final LogoutReason INACTIVE_FOR_LONG_POPUP = null;
    public static final LogoutReason KA_OPEN_COMPONENT = null;
    public static final LogoutReason LOGOUT_CAUSE_BY_VPN_SDK = null;
    public static final LogoutReason MULTIPLE_LOGOUT = null;
    public static final LogoutReason NO_LOGIN_DATA = null;
    public static final LogoutReason NO_LOGIN_DATA_CORE = null;
    public static final LogoutReason NO_LOGIN_DATA_MAKE_LOGOUT = null;
    public static final LogoutReason NO_PERMISSION_CHECK_LOGOUT = null;
    public static final LogoutReason PASSPORT_LOGOUT_JSB = null;
    public static final LogoutReason PlaceHolder = null;
    public static final LogoutReason SEC_USER_IP_LIMIT = null;
    public static final LogoutReason SEC_USER_IP_LIMIT_ALL_LOGOUT = null;
    public static final LogoutReason SESSION_CHECK = null;
    public static final LogoutReason SESSION_CHECK_EMPTY_LIST = null;
    public static final LogoutReason SETTING_DATA_DEEP_CLEAN = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2 = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_LEARN_MODE = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2 = null;
    public static final LogoutReason SWITCH_NEXT_FAIL_BY_RETRY = null;
    public static final LogoutReason SWITCH_TO_VALID_ACTIVITY_FINISH = null;
    public static final LogoutReason USER_DRIVING_ALL_LOGOUT = null;
    public static final LogoutReason USER_DRIVING_SINGLE_LOGOUT = null;
    public static final LogoutReason USER_MAKE_LOGOUT = null;
    public static final /* synthetic */ LogoutReason[] a = null;
    private final int logoutTimeOut;
    private final boolean needOfflineLogout;
    private final boolean skipUpdateContainer;
    private final int toastId;

    static {
        LogoutReason r0 = new LogoutReason("PlaceHolder", 0);
        PlaceHolder = r0;
        LogoutReason r1 = new LogoutReason("SESSION_CHECK", 1);
        SESSION_CHECK = r1;
        LogoutReason r3 = new LogoutReason("EMM_TASK", 2);
        EMM_TASK = r3;
        LogoutReason r5 = new LogoutReason("PASSPORT_LOGOUT_JSB", 3);
        PASSPORT_LOGOUT_JSB = r5;
        LogoutReason r7 = new LogoutReason("BASICMODEL_LOGOUT_JSB", 4);
        BASICMODEL_LOGOUT_JSB = r7;
        LogoutReason r9 = new LogoutReason("IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER", 5);
        IDP_REFRESH_TOKEN_INVALID_FOR_BROWSER = r9;
        LogoutReason r11 = new LogoutReason("IDP_REFRESH_TOKEN_INVALID_FOR_INIT", 6);
        IDP_REFRESH_TOKEN_INVALID_FOR_INIT = r11;
        LogoutReason r13 = new LogoutReason("IDP_CLIENT_TYPE_CHANGE", 7);
        IDP_CLIENT_TYPE_CHANGE = r13;
        LogoutReason r15 = new LogoutReason("NO_LOGIN_DATA", 8);
        NO_LOGIN_DATA = r15;
        LogoutReason r14 = new LogoutReason("NO_LOGIN_DATA_CORE", 9);
        NO_LOGIN_DATA_CORE = r14;
        LogoutReason r12 = new LogoutReason("USER_MAKE_LOGOUT", 10);
        USER_MAKE_LOGOUT = r12;
        LogoutReason r10 = new LogoutReason("SWITCH_TO_VALID_ACTIVITY_FINISH", 11);
        SWITCH_TO_VALID_ACTIVITY_FINISH = r10;
        LogoutReason r8 = new LogoutReason("SWITCH_NEXT_FAIL_BY_LEARN_MODE", 12);
        SWITCH_NEXT_FAIL_BY_LEARN_MODE = r8;
        LogoutReason r6 = new LogoutReason("SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2", 13);
        SWITCH_NEXT_FAIL_BY_LEARN_MODE_V2 = r6;
        LogoutReason r4 = new LogoutReason("SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY", 14);
        SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY = r4;
        LogoutReason r2 = new LogoutReason("SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2", 15);
        SWITCH_NEXT_FAIL_BY_ERROR_NOT_VERIFY_V2 = r2;
        LogoutReason r16 = new LogoutReason("SWITCH_NEXT_FAIL_BY_RETRY", 16);
        SWITCH_NEXT_FAIL_BY_RETRY = r16;
        LogoutReason r17 = new LogoutReason("ENCRYPT_KEY_EMPTY", 17);
        ENCRYPT_KEY_EMPTY = r17;
        LogoutReason r18 = new LogoutReason("SESSION_CHECK_EMPTY_LIST", 18);
        SESSION_CHECK_EMPTY_LIST = r18;
        LogoutReason r19 = new LogoutReason("USER_DRIVING_ALL_LOGOUT", 19, 10, true, false);
        USER_DRIVING_ALL_LOGOUT = r19;
        LogoutReason r21 = new LogoutReason("USER_DRIVING_SINGLE_LOGOUT", 20, 10, false, false);
        USER_DRIVING_SINGLE_LOGOUT = r21;
        LogoutReason r28 = new LogoutReason("MULTIPLE_LOGOUT", 21, 30, true, true);
        MULTIPLE_LOGOUT = r28;
        LogoutReason r20 = new LogoutReason("EXCEED_LIMIT_CAUSE_LOGOUT", 22);
        EXCEED_LIMIT_CAUSE_LOGOUT = r20;
        LogoutReason r22 = new LogoutReason("FORGOT_DIGITAL_CODE", 23);
        FORGOT_DIGITAL_CODE = r22;
        LogoutReason r23 = new LogoutReason("NO_PERMISSION_CHECK_LOGOUT", 24);
        NO_PERMISSION_CHECK_LOGOUT = r23;
        LogoutReason r24 = new LogoutReason("LOGOUT_CAUSE_BY_VPN_SDK", 25);
        LOGOUT_CAUSE_BY_VPN_SDK = r24;
        LogoutReason r25 = new LogoutReason("NO_LOGIN_DATA_MAKE_LOGOUT", 26);
        NO_LOGIN_DATA_MAKE_LOGOUT = r25;
        LogoutReason r26 = new LogoutReason("INACTIVE_FOR_LONG_POPUP", 27);
        INACTIVE_FOR_LONG_POPUP = r26;
        LogoutReason r27 = new LogoutReason();
        DEVICE_IS_MIGRATE = r27;
        LogoutReason r29 = new LogoutReason("SEC_USER_IP_LIMIT", 29);
        SEC_USER_IP_LIMIT = r29;
        LogoutReason r30 = new LogoutReason("SEC_USER_IP_LIMIT_ALL_LOGOUT", 30, 10, true, false);
        SEC_USER_IP_LIMIT_ALL_LOGOUT = r30;
        LogoutReason r31 = new LogoutReason("KA_OPEN_COMPONENT", 31);
        KA_OPEN_COMPONENT = r31;
        LogoutReason r32 = new LogoutReason("SETTING_DATA_DEEP_CLEAN", 32);
        SETTING_DATA_DEEP_CLEAN = r32;
        LogoutReason r33 = new LogoutReason("ADMIN_KICKOUT_WIPE", 33);
        ADMIN_KICKOUT_WIPE = r33;
        a = new LogoutReason[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r21, r28, r20, r22, r23, r24, r25, r26, r27, r29, r30, r31, r32, r33};
    }

    public LogoutReason() {
        super("DEVICE_IS_MIGRATE", 28);
        this.toastId = 2131892506;
        this.logoutTimeOut = 30;
        this.needOfflineLogout = true;
        this.skipUpdateContainer = false;
    }

    public static LogoutReason[] values() {
        return (LogoutReason[]) a.clone();
    }

    public boolean hasValidToast() {
        if (this.toastId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public int getLogoutTimeOut() {
        return this.logoutTimeOut;
    }

    public boolean getNeedOfflineLogout() {
        return this.needOfflineLogout;
    }

    public int getToast() {
        return this.toastId;
    }

    public boolean isSkipUpdateContainer() {
        return this.skipUpdateContainer;
    }

    public static LogoutReason fromValue(String r5) {
        LogoutReason[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        LogoutReason r3 = r0[r2];
        if (r3.name().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return PlaceHolder;
    }

    public static LogoutReason valueOf(String r1) {
        return (LogoutReason) a.a(LogoutReason.class, r1);
    }

    public LogoutReason(String r1, int r2) {
        super(r1, r2);
        this.toastId = -1;
        this.logoutTimeOut = 30;
        this.needOfflineLogout = true;
        this.skipUpdateContainer = false;
    }

    public LogoutReason(String r1, int r2, int r3, boolean r4, boolean r5) {
        super(r1, r2);
        this.toastId = -1;
        this.logoutTimeOut = r3;
        this.needOfflineLogout = r4;
        this.skipUpdateContainer = r5;
    }
}
