package com.ss.android.token;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.a0;
import com.bytedance.android.sdk.bdticketguard.d0;
import com.bytedance.sdk.account.settings.common.b;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.sdk.account.utils.d;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TTTokenMonitor {
    public static volatile long a;
    public static final HashSet<String> b = null;

    public static final enum SessionExpiredHandleResult extends Enum<SessionExpiredHandleResult> {
        public static final /* synthetic */ SessionExpiredHandleResult[] a = null;
        public static final SessionExpiredHandleResult ignore = null;
        public static final SessionExpiredHandleResult logout = null;

        static {
            SessionExpiredHandleResult r0 = new SessionExpiredHandleResult("ignore", 0);
            ignore = r0;
            SessionExpiredHandleResult r1 = new SessionExpiredHandleResult("logout", 1);
            logout = r1;
            a = new SessionExpiredHandleResult[]{r0, r1};
        }

        public static SessionExpiredHandleResult[] values() {
            return (SessionExpiredHandleResult[]) a.clone();
        }

        public static SessionExpiredHandleResult valueOf(String r1) {
            return (SessionExpiredHandleResult) a.a(SessionExpiredHandleResult.class, r1);
        }

        public SessionExpiredHandleResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        b = new HashSet();
    }

    public static void i() {
        JSONObject r0 = new JSONObject();
        r0.put("sdk_aid", 71769);     // Catch: Exception -> L5
        r0.put(EffectConfiguration.KEY_SDK_VERSION, "0.6.5-alpha.72-doubao");     // Catch: Exception -> L5
    L7:
        r("sdk_session_launch", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static String a(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L15;
    L14:
        return r3;
    L15:
        URI r0 = new URI(r3);     // Catch: Exception -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r0.getHost()) == true) goto L8;
        r1.append(r0.getHost());     // Catch: Exception -> L12
    L8:
        if (TextUtils.isEmpty(r0.getPath()) == true) goto L10;
        r1.append(r0.getPath());     // Catch: Exception -> L12
    L10:
        return r1.toString();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static void d(Throwable r3) {
        r3.printStackTrace();     // Catch: Exception -> L4
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L4
        r0.put("exception_stack_trace", Log.getStackTraceString(r3));     // Catch: Exception -> L4
        t("tt_token_exception", r0);     // Catch: Exception -> L4
        k.b r4 = k.a;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("from", r2);     // Catch: JSONException -> L4
        r0.put("old_token", com.bytedance.sdk.account.utils.r.c(r3));     // Catch: JSONException -> L4
        r("passport_login_token_update", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(int r3, String r4) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L5
        r1.put("sp_name", "token_shared_preference");     // Catch: JSONException -> L5
        r1.put("error_code", r3);     // Catch: JSONException -> L5
        r1.put("error_msg", r4);     // Catch: JSONException -> L5
        com.bytedance.sdk.account.monitor.a.a("passport_save_sp_fail", r1);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorSpSaveFail error", e);
    }

    public static void k(int r3, String r4) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L5
        r1.put("error_code", r3);     // Catch: Exception -> L5
        r1.put("error_code_msg", r4);     // Catch: Exception -> L5
        r1.put(DBDefinition.EXTRA, new StringBuilder().toString());     // Catch: Exception -> L5
        t("tt_token_beat", r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void l(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("token", TokenFactory.l(r2));     // Catch: Exception -> L4
        r0.put("logid", r3);     // Catch: Exception -> L4
        t("tt_token_change", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void m(String r2, String r3) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("token", TokenFactory.l(r2));     // Catch: JSONException -> L4
        r0.put("encrypt_token", TokenFactory.l(r3));     // Catch: JSONException -> L4
        com.bytedance.sdk.account.monitor.a.a("passport_token_encrypt_compensate", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorTokenEncryptCompensate error", e);
    }

    public static void r(String r3, JSONObject r4) {
        if (r4 != null) goto L9;
    L7:
        com.bytedance.sdk.account.monitor.a.a(r3, r4);
        return;
    L9:
        r4.put("token_config_version", com.bytedance.sdk.account.ticketguard.f.g);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        tb7.a.c("AccountSDK", "onEvent error", e);
        goto L7
    }

    public static void t(String r2, JSONObject r3) {
        if (r3 == null) goto L9;
    L4:
        r3.put("result", 0);     // Catch: JSONException -> L6
        r(r2, r3);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        r3 = new JSONObject();     // Catch: JSONException -> L6
        goto L4
    }

    public static void c(String r2, String r3, JSONObject r4) {
        if (r4 == null) goto L16;
    L4:
        r4.put("error_name", r2);     // Catch: Exception -> L13
        r4.put("error_message", r3);     // Catch: Exception -> L13
        int r0 = 0;
        if (NetworkUtils.d(k.c()) == false) goto L7;
        int r5 = 1;
    L8:
        r4.put("network_available", r5);     // Catch: Exception -> L13
        if (d.d() == false) goto L11;
        r0 = 1;
    L11:
        r4.put("app_in_foreground", r0);     // Catch: Exception -> L13
        t("token_config_err_v2", r4);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        r5 = 0;
        goto L8
    L16:
        r4 = new JSONObject();     // Catch: Exception -> L13
        goto L4
    }

    public static void e(String r7, String r8, String r9) {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.j == true) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put("host", r7);     // Catch: Exception -> L7
        r0.put(DownloadConstants.PATH_KEY, r8);     // Catch: Exception -> L7
        r0.put("reason", r9);     // Catch: Exception -> L7
        TicketGuardEventHelper r10 = TicketGuardEventHelper.g;     // Catch: Exception -> L7
        String r5 = r0.toString();     // Catch: Exception -> L7
        r10.getClass();     // Catch: Exception -> L7
        TicketGuardEventHelper.h("account_not_mark_get", DownloadConstants.ENCODING_SCENE_ALL, 0, r8 + " not mark get ticket", r5, null);     // Catch: Exception -> L7
        return;
    }

    public static void j(String r5, List r6, boolean r7) {
        String r0 = "";
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L18
        if (r6 == null) goto L16;
        ArrayList r8 = (ArrayList) r6;     // Catch: Exception -> L18
        if (r8.isEmpty() == true) goto L16;
        Iterator r9 = r8.iterator();     // Catch: Exception -> L18
    L8:
        if (r9.hasNext() == false) goto L16;
        Object r2 = r9.next();     // Catch: Exception -> L18
        if ((r2 instanceof o) == true) goto L12;
        if (r2 == null) goto L8;
        r1.append(r2.toString());     // Catch: Exception -> L18
        r1.append(";");     // Catch: Exception -> L18
        goto L8
    L12:
        if ("X-TT-LOGID".equalsIgnoreCase(((o) r2).a) == false) goto L8;
        r0 = ((o) r2).b;     // Catch: Exception -> L18
    L16:
        String r10 = r1.toString();     // Catch: Exception -> L18
        s(a(r5), r0, r10, r7);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        d(e);
    }

    public static void n(String r2, String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(DownloadConstants.PATH_KEY, r2);     // Catch: JSONException -> L4
        r0.put("ticket_name", r3);     // Catch: JSONException -> L4
        r0.put("error_code", r4);     // Catch: JSONException -> L4
        r0.put("error_desc", r5);     // Catch: JSONException -> L4
        r("passport_token_guard_fail", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void o(Long r2, Long r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("old_id", String.valueOf(r2));     // Catch: JSONException -> L4
        r0.put("new_id", String.valueOf(r3));     // Catch: JSONException -> L4
        r0.put(DownloadConstants.PATH_KEY, r4);     // Catch: JSONException -> L4
        r0.put("from", r5);     // Catch: JSONException -> L4
        r("passport_uid_update", r0);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorUidUpdate error", e);
    }

    public static void s(String r3, String r4, String r5, boolean r6) {
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r1.put("logid", r4);     // Catch: JSONException -> L18
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r1.put("urlpath", r3);     // Catch: JSONException -> L18
    L9:
        r1.put("sdkVersion", 2);     // Catch: JSONException -> L18
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r1.put(DBDefinition.EXTRA, r5);     // Catch: JSONException -> L18
    L13:
        if (r6 == false) goto L15;
        String r7 = "1";
    L16:
        r1.put("user_was_login", r7);     // Catch: JSONException -> L18
        r1.put("result", 0);     // Catch: JSONException -> L18
        r("tt_token_logout", r1);     // Catch: JSONException -> L18
        return;
    L15:
        r7 = "0";
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(String r7, String r8, String r9, Map<String, String> r10, Collection<String> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L42;
        HashMap r12 = (HashMap) r10;
        if (r12.isEmpty() == true) goto L44;
        HashSet r0 = new HashSet(r11);
        r0.add("X-Tt-Token".toLowerCase());
        StringBuffer r1 = new StringBuffer();
        Iterator r2 = r0.iterator();
        boolean r3 = false;
        boolean r4 = false;
    L10:
        if (r2.hasNext() == false) goto L21;
        String r5 = (String) r2.next();
        if (r5 == null) goto L10;
        String r6 = r5.toLowerCase();
        if (r1.length() <= 0) goto L17;
        r1.append(",");
    L17:
        r1.append(r6);
        r1.append("=");
        if (TextUtils.isEmpty((String) r12.get(r6)) == false) goto L19;
        r1.append(0);
        r4 = true;
        goto L10
    L19:
        r1.append(1);
        r3 = true;
        goto L10
    L21:
        if (r3 == false) goto L43;
        if (r4 == false) goto L45;
        tb7.a.a("TTTokenMonitor", "response extra headers no identical: " + r1);
        JSONObject r13 = new JSONObject();
        r13.put("host", r7);     // Catch: Exception -> L27
        r13.put(DownloadConstants.PATH_KEY, r8);     // Catch: Exception -> L27
        r13.put("logid", r9);     // Catch: Exception -> L27
        r13.put("x_tt_token", r12.containsKey("X-Tt-Token".toLowerCase()) ? 1 : 0);     // Catch: Exception -> L27
        r13.put("extra_headers", r1.toString());     // Catch: Exception -> L27
    L29:
        r("passport_response_extra_header", r13);
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L45:
        return;
    L43:
        return;
    L44:
        return;
    }

    public static void f(String r14, String r15, String r16, String r17, f r18, Map<String, String> r19) {
        if (r18 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r16) == true) goto L83;
        b.a();
        Collection r3 = b.c.c;
        b.a();
        if (b.b == true) goto L10;
        return;
    L10:
        if (r3.isEmpty() == true) goto L84;
        String r4 = r16.toLowerCase();
        if ("/passport/token/beat/v2/".equals(r4) == true) goto L15;
        return;
    L15:
        StringBuilder r5 = new StringBuilder();
        StringBuilder r6 = new StringBuilder();
        Map r1 = r18.a;
        if (r1 != null) goto L18;
        r1 = new HashMap();
    L18:
        Iterator r7 = r3.iterator();
        int r8 = 0;
        boolean r9 = false;
    L20:
        if (r7.hasNext() == false) goto L40;
        String r10 = (String) r7.next();
        if (r10 == null) goto L20;
        if (r10.isEmpty() == true) goto L20;
        if (r5.length() <= 0) goto L29;
        r5.append(",");
    L29:
        r5.append(r10);
        r5.append("=");
        if (TextUtils.isEmpty((String) r1.get(r10)) == false) goto L32;
        r5.append(0);
        r9 = true;
    L34:
        if (r6.length() <= 0) goto L36;
        r6.append(",");
    L36:
        r6.append(r10);
        r6.append("=");
        if (TextUtils.isEmpty((String) ((HashMap) r19).get(r10)) == true) goto L38;
        r6.append(1);
        goto L20
    L38:
        r6.append(0);
        goto L20
    L32:
        r5.append(1);
        goto L34
    L40:
        if (r9 == true) goto L42;
        return;
    L42:
        if (r14 != null) goto L44;
    L46:
        boolean r0 = false;
    L47:
        JSONObject r11 = new JSONObject();
        r11.put("host", r15);     // Catch: Exception -> L65
        r11.put(DownloadConstants.PATH_KEY, r4);     // Catch: Exception -> L65
        r11.put("logid", r17);     // Catch: Exception -> L65
        if (com.bytedance.sdk.account.impl.h.a().isLogin() == false) goto L51;
        int r12 = 1;
    L52:
        r11.put("is_login", r12);     // Catch: Exception -> L65
        if (TextUtils.isEmpty((CharSequence) r1.get("sdk-version")) == true) goto L55;
        int r13 = 1;
    L56:
        r11.put(EffectConfiguration.KEY_SDK_VERSION, r13);     // Catch: Exception -> L65
        if (r0 == false) goto L59;
        int r2 = 1;
    L60:
        r11.put("is_from_ttaccountsdk", r2);     // Catch: Exception -> L65
        if (TextUtils.isEmpty((CharSequence) r1.get("X-Tt-Token")) == true) goto L63;
        r8 = 1;
    L63:
        r11.put("request_x_tt_token", r8);     // Catch: Exception -> L65
        HashMap r20 = (HashMap) r19;     // Catch: Exception -> L65
        r11.put("response_x_tt_token", !TextUtils.isEmpty((CharSequence) r20.get("X-Tt-Token".toLowerCase())) ? 1 : 0);     // Catch: Exception -> L65
        r11.put("request_extra_header", r5.toString());     // Catch: Exception -> L65
        r11.put("response_extra_header", r6.toString());     // Catch: Exception -> L65
    L67:
        r("passport_request_extra_header_miss", r11);
        return;
    L59:
        r2 = 0;
        goto L60
    L55:
        r13 = 0;
        goto L56
    L51:
        r12 = 0;
    L65:
        e = move-exception;
        e.printStackTrace();
        goto L67
    L44:
        if (r14.contains("is_from_ttaccountsdk=1") == false) goto L46;
        r0 = true;
        goto L47
    L84:
        return;
    }

    public static void p(String r8, String r9, String r10, f r11, e0 r12, String r13, List r14) {
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L75
        r2.put("host", r8);     // Catch: JSONException -> L75
        r2.put(DownloadConstants.PATH_KEY, r9);     // Catch: JSONException -> L75
        r2.put("log_id", r10);     // Catch: JSONException -> L75
        int r15 = 1;
        if (r11 == null) goto L27;
        a0 r16 = r11.b;     // Catch: JSONException -> L75
        if (r16 == null) goto L27;
        List r17 = ((d0) r16).b;     // Catch: JSONException -> L75
        if (r17 == null) goto L27;
        if (r17.isEmpty() == true) goto L27;
        Iterator r18 = ((d0) r16).b.iterator();     // Catch: JSONException -> L75
        int r19 = 0;
        int r3 = 0;
        int r4 = 0;
    L13:
        if (r18.hasNext() == false) goto L26;
        Pair r5 = (Pair) r18.next();     // Catch: JSONException -> L75
        if (r5 == null) goto L13;
        if (TextUtils.equals("bd-ticket-guard-client-csr", (CharSequence) r5.first) == true) goto L19;
        if (TextUtils.equals("bd-ticket-guard-client-cert", (CharSequence) r5.first) == true) goto L22;
        if (TextUtils.equals("bd-ticket-guard-ree-public-key", (CharSequence) r5.first) == false) goto L13;
        r4 = !TextUtils.isEmpty((CharSequence) r5.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L22:
        r3 = !TextUtils.isEmpty((CharSequence) r5.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L19:
        r19 = !TextUtils.isEmpty((CharSequence) r5.second) ? 1 : 0;     // Catch: JSONException -> L75
        goto L13
    L26:
        r2.put("csr", r19);     // Catch: JSONException -> L75
        r2.put("client_cert", r3);     // Catch: JSONException -> L75
        r2.put("ree_public_key", r4);     // Catch: JSONException -> L75
    L27:
        if (r14 == null) goto L51;
        ArrayList r110 = (ArrayList) r14;     // Catch: JSONException -> L75
        if (r110.isEmpty() == true) goto L51;
        StringBuffer r111 = new StringBuffer();     // Catch: JSONException -> L75
        Iterator r112 = r110.iterator();     // Catch: JSONException -> L75
    L32:
        if (r112.hasNext() == false) goto L48;
        o r113 = (o) r112.next();     // Catch: JSONException -> L75
        if ("set-cookie".equalsIgnoreCase(r113.a) == false) goto L32;
        String r114 = r113.b;     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r114) == true) goto L32;
        if (r114.contains("sessionid") == false) goto L32;
        String r115 = r114.split(";")[0].split("=")[0];     // Catch: JSONException -> L75
        if (r115 == null) goto L32;
        if (r115.startsWith("sessionid") == false) goto L32;
        if (r111.length() <= 0) goto L46;
        r111.append(",");     // Catch: JSONException -> L75
    L46:
        r111.append(r115);     // Catch: JSONException -> L75
        r111.append("=1");     // Catch: JSONException -> L75
        goto L32
    L48:
        if (r111.length() <= 0) goto L51;
        r2.put("cookies", r111.toString());     // Catch: JSONException -> L75
    L51:
        if (TextUtils.isEmpty(r12.a) == true) goto L53;
        int r116 = 1;
    L54:
        r2.put("token", r116);     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r12.b) == true) goto L57;
        int r117 = 1;
    L58:
        r2.put("tssign", r117);     // Catch: JSONException -> L75
        String r118 = r12.b;     // Catch: JSONException -> L75
        TokenFactory r119 = TokenFactory.C;     // Catch: JSONException -> L75
        String r120 = r118.replace(" ", "");     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r120) == false) goto L61;
    L65:
        boolean r121 = false;
    L66:
        if (r121 == false) goto L68;
        int r122 = 1;
    L69:
        r2.put("has_tee_sign", r122);     // Catch: JSONException -> L75
        if (TextUtils.isEmpty(r12.c) == false) goto L73;
        r15 = 0;
    L73:
        r2.put("attest_tssign", r15);     // Catch: JSONException -> L75
        r2.put("new_token", com.bytedance.sdk.account.utils.r.c(r12.a));     // Catch: JSONException -> L75
        r2.put("old_token", com.bytedance.sdk.account.utils.r.c(r13));     // Catch: JSONException -> L75
        r2.put("from", "interceptor");     // Catch: JSONException -> L75
        r2.put("had_sec_uid", r12.h);     // Catch: JSONException -> L75
        r("passport_login_token_update", r2);     // Catch: JSONException -> L75
        return;
    L68:
        r122 = 0;
        goto L69
    L61:
        if (r120.contains("\"ts_sign\"") == false) goto L65;
        if (r120.contains("\"ts_sign\":\"\"") == true) goto L65;
        r121 = true;
        goto L66
    L57:
        r117 = 0;
        goto L58
    L53:
        r116 = 0;
    L75:
        e = move-exception;
        e.printStackTrace();
    }

    public static void q(String r4, String r5, boolean r6, String r7, String r8, boolean r9, String r10) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L19
        int r2 = 0;
        if (r6 == false) goto L5;
        int r11 = 1;
    L6:
        r0.put("token_is_null", r11);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r7) == false) goto L9;
        int r1 = 1;
    L10:
        r0.put("response_sec_uid_is_null", r1);     // Catch: JSONException -> L19
        if (TextUtils.isEmpty(r8) == false) goto L13;
        int r3 = 1;
    L14:
        r0.put("sec_uid_is_null", r3);     // Catch: JSONException -> L19
        r0.put(DownloadConstants.PATH_KEY, r4);     // Catch: JSONException -> L19
        r0.put("logid", r5);     // Catch: JSONException -> L19
        if (r9 == false) goto L17;
        r2 = 1;
    L17:
        r0.put("is_login", r2);     // Catch: JSONException -> L19
        r0.put("sec_uid", r8);     // Catch: JSONException -> L19
        r0.put("response_sec_uid", r7);     // Catch: JSONException -> L19
        r0.put("error_name", r10);     // Catch: JSONException -> L19
        r("passport_user_mixed_uid", r0);     // Catch: JSONException -> L19
        return;
    L13:
        r3 = 0;
        goto L14
    L9:
        r1 = 0;
        goto L10
    L5:
        r11 = 0;
    L19:
        e = move-exception;
        tb7.a.c("AccountSDK", "monitorUserMixedUid error", e);
    }
}
