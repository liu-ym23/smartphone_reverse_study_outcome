package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.AbsEnv;
import com.bytedance.bdinstall.InstallOptions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class Constants {
    public static final long ACTIVE_RETRY_TIME = 900000;
    public static final String CLASS_TICKET_GUARD_ADAPTER = "com.bytedance.bdinstall.ticket.TicketGuardAdapter";
    public static final int DEFAULT_INSTANCE_CAPACITY = 4;
    public static final String NAME_NEW_USER_IMPL = "com.bytedance.bdinstall.nu.NUModeServiceImpl";
    public static final String PATH_ACTIVATE = "/service/2/app_alert_check/";
    public static final String PATH_REGISTER = "/service/2/device_register/";
    public static final String PATH_VERIFY = "/service/1/client_context/";
    public static final String SP_FILE_OPEN_UDID = "snssdk_openudid";
    public static final String SP_INSTALL = "ug_install_settings_pref";
    public static final String TAG_TICKET = "TicketGuard# ";
    private static final Singleton<SharedPreferences> sInstallSpref = null;

    public static class Events {
        public static String DR_ACTIVATE_RESULT = "dr_active_result";
        public static String DR_REGISTER_PARAM = "dr_register_param";
        public static String DR_REGISTER_RESULT = "dr_register_result";
        public static String DR_VERIFY_RESULT = "dr_verify_result";
        public static String KEY_ACTIVATE = "activate";
        public static String KEY_PARAMS = "params";
        public static String KEY_REGISTER = "register";
        public static String KEY_VERIFY = "verify";

        static {
        }

        public Events() {
        }
    }

    public static class TicketEvents {
        public static final String KEY_TICKET_CONSUMER_TICKET = "consumer_ticket";
        public static final String KEY_TICKET_DECRYPT = "ticket_decrypt";
        public static final String KEY_TICKET_GET_TICKET = "get_ticket";
        public static final String KEY_TICKET_HANDLE_RESPONSE = "ticket_handle_response";
        public static final String KEY_TICKET_INIT = "ticket_init";
        public static final String KEY_TICKET_TOTAL_TIME = "ticket_total_time";

        public TicketEvents() {
        }
    }

    static {
        sInstallSpref = new AnonymousClass1();
    }

    Constants() {
    }

    public static SharedPreferences getCommonSp(Context r2, InstallOptions r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        if (r3.isMainInstance() == false) goto L8;
        return getMainCommonSp(r4);
    L8:
        return getCommonSp(r4, String.valueOf(r3.getAid()));
    L10:
        return getMainCommonSp(r4);
    }

    public static SharedPreferences getCommonSp(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("ug_install_settings_pref_" + r3, 0);
    }

    public static SharedPreferences getMainCommonSp(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(sInstallSpref.get(new Object[]{r5}), SharedPreferences.class, "com.obric.memorydata.plugin");
    }

    public static String wrapEnvSuffix(String r1, AbsEnv r2) {
        if (r2.isI18n() == false) goto L6;
        r1 = r1 + "_i18n";
    L6:
        if (r2.isBoe() == false) goto L9;
        r1 = r1 + "_boe";
    L9:
        if (r2.isChildMode() == true) goto L11;
        return r1;
    L11:
        return r1 + "_cm";
    }

    public static String wrapServerIdSpName(AbsEnv r1) {
        return wrapEnvSuffix(SP_INSTALL, r1);
    }

    public static String wrapServerIdSpName(AbsEnv r2, String r3) {
        return wrapEnvSuffix(SP_INSTALL, r2) + "_" + r3;
    }
}
