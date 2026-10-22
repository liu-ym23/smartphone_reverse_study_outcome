package com.ss.android.common.applog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public /* synthetic */ class AppLog$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AppLog$ActionQueueType.values().length];
        a = r0;
        r0[AppLog$ActionQueueType.EVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
    L64:
        a[AppLog$ActionQueueType.SAVE_MISC_LOG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
    L48:
        a[AppLog$ActionQueueType.PAGE_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
    L60:
        a[AppLog$ActionQueueType.PAGE_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
    L66:
        a[AppLog$ActionQueueType.IMAGE_SAMPLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
    L50:
        a[AppLog$ActionQueueType.API_SAMPLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
    L54:
        a[AppLog$ActionQueueType.CONFIG_UPDATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
    L78:
        a[AppLog$ActionQueueType.UA_UPDATE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
    L44:
        a[AppLog$ActionQueueType.SAVE_ANR_TAG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
    L70:
        a[AppLog$ActionQueueType.SAVE_DNS_REPORT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
    L74:
        a[AppLog$ActionQueueType.CUSTOMER_HEADER_UPDATE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
    L56:
        a[AppLog$ActionQueueType.DEVICE_ID_UPDATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
    L62:
        a[AppLog$ActionQueueType.UPDATE_GOOGLE_AID.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
    L46:
        a[AppLog$ActionQueueType.UPDATE_APP_LANGUAGE_REGION.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
    L52:
        a[AppLog$ActionQueueType.CLEAR_WHEN_SWITCH_CHILD_MODE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
    L76:
        a[AppLog$ActionQueueType.RESET_WHEN_SWITCH_CHILD_MODE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
    L42:
        a[AppLog$ActionQueueType.FLUSH_EVENT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
    L68:
        a[AppLog$ActionQueueType.UPDATE_USER_UNIQUE_ID.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
    L72:
        a[AppLog$ActionQueueType.DELAY_START_LOG_REAPER.ordinal()] = 19;     // Catch: NoSuchFieldError -> L41
        return;
    }
}
