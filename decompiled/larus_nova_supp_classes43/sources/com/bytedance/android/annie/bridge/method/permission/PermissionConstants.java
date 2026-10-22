package com.bytedance.android.annie.bridge.method.permission;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PermissionConstants {
    public static final String[] a = null;
    public static final String[] b = null;
    public static final String[] c = null;
    public static final String[] d = null;
    public static final String[] e = null;
    public static final String[] f = null;
    public static final String[] g = null;
    public static final String[] h = null;
    public static final String[] i = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    static {
        a = new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        b = new String[]{"android.permission.CAMERA"};
        c = new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
        d = new String[]{"android.permission.RECORD_AUDIO"};
        e = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
        f = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
        g = new String[]{"android.permission.BODY_SENSORS"};
        h = new String[]{"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
        i = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }
}
