package com.ss.android.common.applog;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum AppLog$ActionQueueType extends Enum<AppLog$ActionQueueType> {
    public static final AppLog$ActionQueueType API_SAMPLE = null;
    public static final AppLog$ActionQueueType CLEAR_WHEN_SWITCH_CHILD_MODE = null;
    public static final AppLog$ActionQueueType CONFIG_UPDATE = null;
    public static final AppLog$ActionQueueType CUSTOMER_HEADER_UPDATE = null;
    public static final AppLog$ActionQueueType DELAY_START_LOG_REAPER = null;
    public static final AppLog$ActionQueueType DEVICE_ID_UPDATE = null;
    public static final AppLog$ActionQueueType EVENT = null;
    public static final AppLog$ActionQueueType FLUSH_EVENT = null;
    public static final AppLog$ActionQueueType IMAGE_SAMPLE = null;
    public static final AppLog$ActionQueueType PAGE_END = null;
    public static final AppLog$ActionQueueType PAGE_START = null;
    public static final AppLog$ActionQueueType RESET_WHEN_SWITCH_CHILD_MODE = null;
    public static final AppLog$ActionQueueType SAVE_ANR_TAG = null;
    public static final AppLog$ActionQueueType SAVE_DNS_REPORT = null;
    public static final AppLog$ActionQueueType SAVE_MISC_LOG = null;
    public static final AppLog$ActionQueueType UA_UPDATE = null;
    public static final AppLog$ActionQueueType UPDATE_APP_LANGUAGE_REGION = null;
    public static final AppLog$ActionQueueType UPDATE_GOOGLE_AID = null;
    public static final AppLog$ActionQueueType UPDATE_USER_UNIQUE_ID = null;
    public static final /* synthetic */ AppLog$ActionQueueType[] a = null;
    final int nativeInt;

    static {
        AppLog$ActionQueueType r0 = new AppLog$ActionQueueType("PAGE_START", 0, 0);
        PAGE_START = r0;
        AppLog$ActionQueueType r1 = new AppLog$ActionQueueType("PAGE_END", 1, 1);
        PAGE_END = r1;
        AppLog$ActionQueueType r3 = new AppLog$ActionQueueType("EVENT", 2, 2);
        EVENT = r3;
        AppLog$ActionQueueType r5 = new AppLog$ActionQueueType("IMAGE_SAMPLE", 3, 3);
        IMAGE_SAMPLE = r5;
        AppLog$ActionQueueType r7 = new AppLog$ActionQueueType("CONFIG_UPDATE", 4, 4);
        CONFIG_UPDATE = r7;
        AppLog$ActionQueueType r9 = new AppLog$ActionQueueType("API_SAMPLE", 5, 5);
        API_SAMPLE = r9;
        AppLog$ActionQueueType r11 = new AppLog$ActionQueueType("UA_UPDATE", 6, 6);
        UA_UPDATE = r11;
        AppLog$ActionQueueType r13 = new AppLog$ActionQueueType("SAVE_ANR_TAG", 7, 7);
        SAVE_ANR_TAG = r13;
        AppLog$ActionQueueType r15 = new AppLog$ActionQueueType("SAVE_DNS_REPORT", 8, 8);
        SAVE_DNS_REPORT = r15;
        AppLog$ActionQueueType r14 = new AppLog$ActionQueueType("SAVE_MISC_LOG", 9, 9);
        SAVE_MISC_LOG = r14;
        AppLog$ActionQueueType r12 = new AppLog$ActionQueueType("DEVICE_ID_UPDATE", 10, 10);
        DEVICE_ID_UPDATE = r12;
        AppLog$ActionQueueType r10 = new AppLog$ActionQueueType("CUSTOMER_HEADER_UPDATE", 11, 11);
        CUSTOMER_HEADER_UPDATE = r10;
        AppLog$ActionQueueType r8 = new AppLog$ActionQueueType("UPDATE_GOOGLE_AID", 12, 12);
        UPDATE_GOOGLE_AID = r8;
        AppLog$ActionQueueType r6 = new AppLog$ActionQueueType("UPDATE_APP_LANGUAGE_REGION", 13, 13);
        UPDATE_APP_LANGUAGE_REGION = r6;
        AppLog$ActionQueueType r4 = new AppLog$ActionQueueType("CLEAR_WHEN_SWITCH_CHILD_MODE", 14, 14);
        CLEAR_WHEN_SWITCH_CHILD_MODE = r4;
        AppLog$ActionQueueType r2 = new AppLog$ActionQueueType("RESET_WHEN_SWITCH_CHILD_MODE", 15, 15);
        RESET_WHEN_SWITCH_CHILD_MODE = r2;
        AppLog$ActionQueueType r16 = new AppLog$ActionQueueType("FLUSH_EVENT", 16, 16);
        FLUSH_EVENT = r16;
        AppLog$ActionQueueType r17 = new AppLog$ActionQueueType("UPDATE_USER_UNIQUE_ID", 17, 17);
        UPDATE_USER_UNIQUE_ID = r17;
        AppLog$ActionQueueType r18 = new AppLog$ActionQueueType("DELAY_START_LOG_REAPER", 18, 18);
        DELAY_START_LOG_REAPER = r18;
        a = new AppLog$ActionQueueType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
    }

    public static AppLog$ActionQueueType[] values() {
        return (AppLog$ActionQueueType[]) a.clone();
    }

    public static AppLog$ActionQueueType valueOf(String r1) {
        return (AppLog$ActionQueueType) a.a(AppLog$ActionQueueType.class, r1);
    }

    public AppLog$ActionQueueType(String r1, int r2, int r3) {
        super(r1, r2);
        this.nativeInt = r3;
    }
}
