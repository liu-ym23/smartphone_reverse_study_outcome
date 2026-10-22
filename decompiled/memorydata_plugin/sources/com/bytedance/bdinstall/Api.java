package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.rpc.internal.RpcUtils;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Api {
    public static final String DATA = "data";
    public static final int ERROR_CODE_FALLBACK_BY_SERVER = 429;
    public static final int ERROR_CODE_FALLBACK_BY_TTNET = -555;
    private static final String[] KEYS_PLAINTEXT = null;
    public static final String KEY_ABFLAG = "abflag";
    public static final String KEY_AB_CLIENT = "ab_client";
    public static final String KEY_AB_FEATURE = "ab_feature";
    public static final String KEY_AB_GROUP = "ab_group";
    public static final String KEY_AB_VERSION = "ab_version";
    public static final String KEY_AC = "ac";
    public static final String KEY_ACCESS = "access";
    public static final String KEY_AID = "aid";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_APP_LANGUAGE = "app_language";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_APP_REGION = "app_region";
    public static final String KEY_APP_TRACK = "app_track";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_APP_VERSION_MINOR = "app_version_minor";
    public static final String KEY_BASIC_CONTEXT = "basic_context";
    public static final String KEY_BD_DID = "bd_did";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_CARRIER = "carrier";
    public static final String KEY_CD = "cd";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CLEAR_KEY_PREFIX = "clear_key_prefix";
    public static final String KEY_CPU_ABI = "cpu_abi";
    public static final String KEY_CUSTOM = "custom";
    public static final String KEY_C_UDID = "clientudid";
    public static final String KEY_DENSITY_DPI = "density_dpi";
    public static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_CATEGORY = "device_category";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    public static final String KEY_DEVICE_MODEL = "device_model";
    public static final String KEY_DEVICE_PLATFORM = "device_platform";
    public static final String KEY_DEVICE_TOKEN = "device_token";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_DISPLAY_DENSITY = "display_density";
    public static final String KEY_DISPLAY_NAME = "display_name";
    public static final String KEY_DPI = "dpi";
    public static final String KEY_ENCRYPT_DID = "klink_edi";
    public static final String KEY_ENCRYPT_IID = "klink_eii";
    public static final String KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER = "ZQLiNFJR+CWEI4px";
    public static final String KEY_GOOGLE_AID = "google_aid";
    public static final String KEY_GOOGLE_AID_LIMIT = "gaid_limited";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HTTP_CODE = "HttpCode";
    public static final String KEY_IID = "iid";
    public static final String KEY_INSTALL_ID = "install_id";
    public static final String KEY_KLINK_EGDI = "klink_egdi";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_MAC_ADDRESS = "mac_address";
    public static final String KEY_MAGIC = "magic_tag";
    public static final String KEY_MANIFEST_VERSION_CODE = "manifest_version_code";
    public static final String KEY_MCC_MNC = "mcc_mnc";
    private static final String KEY_MSG = "message";
    public static final String KEY_NEW_USER = "new_user";
    public static final String KEY_NEW_USER_MODE = "new_user_mode";
    public static final String KEY_NOT_REQUEST_SENDER = "not_request_sender";
    public static final String KEY_OLD_DID = "old_did";
    public static final String KEY_OPEN_UDID = "openudid";
    public static final String KEY_OS = "os";
    public static final String KEY_OS_API = "os_api";
    public static final String KEY_OS_VERSION = "os_version";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PICO_SN = "pico_sn";
    public static final String KEY_REAL_PACKAGE_NAME = "real_package_name";
    public static final String KEY_REGION = "region";
    public static final String KEY_REGISTER_CUSTOM = "register_custom";
    public static final String KEY_REGISTER_TIME = "register_time";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_RESOLUTION = "resolution";
    public static final String KEY_ROM = "rom";
    public static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_RTICKET = "_rticket";
    public static final String KEY_SDK_TARGET_VERSION = "sdk_target_version";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    public static final String KEY_SECURITY_CONTEXT = "security_context";
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SIM_REGION = "sim_region";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_SSMIX = "ssmix";
    public static final String KEY_STARTED = "_install_started_v2";
    public static final String KEY_TICKET = "ticket";
    public static final String KEY_TICKET_APP_ID = "app_id";
    public static final String KEY_TICKET_DEVICE_ID = "device_id";
    public static final String KEY_TICKET_INSTALL_ID = "installation_id";
    public static final String KEY_TIMEZONE = "timezone";
    public static final String KEY_TS_SIGN = "ts_sign";
    private static final String KEY_TT_DATA = "tt_data";
    private static final String KEY_TT_INFO = "tt_info";
    public static final String KEY_TWEAKED_CHANNEL = "tweaked_channel";
    public static final String KEY_TZ_NAME = "tz_name";
    public static final String KEY_TZ_OFFSET = "tz_offset";
    public static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_USER_AGENT = "user_agent";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    public static final String KEY_UUID = "uuid";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String KEY_VERSION_NAME = "version_name";
    public static final String MSG_MAGIC = "ss_app_log";
    private static final String MSG_OK = "success";
    public static final String REQ_ID = "req_id";
    public static final String SP_KEY_BD_DID = "bd_did";
    public static final String SP_KEY_C_UDID = "clientudid";
    public static final String SP_KEY_DEVICE_ID = "device_id";
    public static final String SP_KEY_DEVICE_TOKEN = "device_token";
    public static final String SP_KEY_GOOGLE_AD_LIMITED = "gaid_limited";
    public static final String SP_KEY_GOOGLE_AID = "google_aid";
    public static final String SP_KEY_INSTALL_ID = "install_id";
    public static final String SP_KEY_IS_ACTIVATED = "is_activated";
    public static final String SP_KEY_IS_FIRST_ACTIVATE_FOR_APP = "is_first_activate_for_app";
    public static final String SP_KEY_IS_FIRST_REGISTER_FOR_APP = "is_first_register_for_app";
    public static final String SP_KEY_IS_MIGRATE = "is_migrate";
    public static final String SP_KEY_OLD_DID = "old_did";
    public static final String SP_KEY_OPEN_UDID = "openudid";
    public static final String SP_KEY_SERIAL_NUMBER = "serial_number";
    public static final String VERSION = "version";

    static {
        KEYS_PLAINTEXT = new String[]{"aid", "app_version", KEY_TT_DATA, "device_id", "bd_did"};
    }

    public Api() {
    }

    static TTResponse active(INetworkClient r2, INetworkClientWrapper r3, String r4, boolean r5, IEncryptor r6, boolean r7) {
        INetworkClient r8 = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r2, INetworkClient.class, "com.obric.memorydata.plugin");
        INetworkClientWrapper r9 = (INetworkClientWrapper) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClientWrapper.class, "com.obric.memorydata.plugin");
        IEncryptor r10 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r6, IEncryptor.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(r4);
        HashMap<String, String> r11 = buildHeader(r7);
        if (r9 == null) goto L5;
        TTResponse r12 = r9.get(encryptUrl(r0.toString(), r5, r10), r11);     // Catch: Exception -> L7
        DrLog.d("ticket network client is ready. response is " + r12);     // Catch: Exception -> L7
        return r12;
    L5:
        TTResponse r13 = new TTResponse(r4, 200, null, r8.get(encryptUrl(r0.toString(), r5, r10), r11));     // Catch: Exception -> L7
        DrLog.d("network client is ready. response is " + r13);     // Catch: Exception -> L7
    L10:
        return r13;
    L7:
        e = move-exception;
        r13 = parseTTNetFallback(e);
        DrLog.e("active http error = ", e);
        goto L10
    }

    static void addParams(StringBuilder r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        String r0 = "?";
    L12:
        r2.append(r0);
        r2.append(r3).append("=").append(Uri.encode(r4));
        return;
    L11:
        r0 = "&";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> buildHeader(final boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair<String, String> r4 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L9:
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    private static HashMap<String, String> createHeader(boolean r1, boolean r2) {
        HashMap<String, String> r3 = buildHeader(r2);
        if (r1 == false) goto L5;
        String r4 = "application/octet-stream;tt-data=a";
    L6:
        r3.put(NetConst.KEY_CONTENT_TYPE, r4);
        return r3;
    L5:
        r4 = "application/json; charset=utf-8";
        goto L6
    }

    private static String encryptUrl(String r9, boolean r10, IEncryptor r11) {
        IEncryptor r12 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r11, IEncryptor.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r9) == true) goto L20;
        Uri r13 = Uri.parse(r9);
        String r0 = r13.getQuery();
        ArrayList r2 = new ArrayList();
        String[] r3 = KEYS_PLAINTEXT;
        int r4 = r3.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        String r6 = r3[r5];
        String r7 = r13.getQueryParameter(r6);
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r2.add(new Pair(r6, r7));
    L9:
        r5 = r5 + 1;
        goto L5
    L10:
        Uri.Builder r14 = r13.buildUpon();
        r14.clearQuery();
        Iterator r8 = r2.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        r14.appendQueryParameter((String) ZeusTransformUtils.preCheckCast(r15.first, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r15.second, String.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        r14.appendQueryParameter(KEY_TT_INFO, new String(Base64.encode(transformStrToByte(r0, r10, r12), 8)));
        return r14.build().toString();
    L20:
        return r9;
    }

    private static TTResponse parseTTNetFallback(Exception r4) {
        if (ZeusTransformUtils.instanceOf(r4, RangersHttpException.class) == false) goto L6;
        RangersHttpException r5 = (RangersHttpException) ZeusTransformUtils.preCheckCast(r4, RangersHttpException.class, "com.obric.memorydata.plugin");
        return new TTResponse("", r5.getResponseCode(), null, r5.getMessage());
    L6:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static TTResponse register(INetworkClient r4, INetworkClientWrapper r5, String r6, JSONObject r7, boolean r8, IEncryptor r9, boolean r10, List<Pair<String, String>> r11) {
        INetworkClient r12 = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r4, INetworkClient.class, "com.obric.memorydata.plugin");
        INetworkClientWrapper r13 = (INetworkClientWrapper) ZeusTransformUtils.wrapperContextForParams(r5, INetworkClientWrapper.class, "com.obric.memorydata.plugin");
        IEncryptor r14 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r9, IEncryptor.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        HashMap<String, String> r16 = createHeader(r8, r10);
        if (r15 != null) goto L5;
    L22:
        byte[] r17 = transformStrToByte(r7.toString(), r8, r14);     // Catch: Exception -> L18
        if (r17 == null) goto L14;
        if (r8 == false) goto L14;
        r6 = r6 + "&tt_data=a";     // Catch: Exception -> L18
    L14:
        if (r13 == null) goto L16;
        TTResponse r18 = r13.post(r6, r17, r16);     // Catch: Exception -> L18
        DrLog.d("ticket network client is ready. response is " + r18);     // Catch: Exception -> L18
        return r18;
    L16:
        TTResponse r19 = new TTResponse(r6, 200, null, r12.post(r6, r17, r16));     // Catch: Exception -> L18
        DrLog.d("network client is ready. response is " + r19);     // Catch: Exception -> L18
    L21:
        return r19;
    L18:
        e = move-exception;
        r19 = parseTTNetFallback(e);
        DrLog.e("doRegister# http error= " + e.toString(), e);
        goto L21
    L5:
        if (r15.size() <= 0) goto L22;
        int r0 = 0;
    L8:
        if (r0 >= r15.size()) goto L22;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r15.get(r0), Pair.class, "com.obric.memorydata.plugin");
        r16.put(r2.first, r2.second);
        r0 = r0 + 1;
        goto L8
    }

    public static TTResponse statsCollect(INetworkClient r2, INetworkClientWrapper r3, String r4, String r5, boolean r6, IEncryptor r7, boolean r8) {
        INetworkClient r9 = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r2, INetworkClient.class, "com.obric.memorydata.plugin");
        INetworkClientWrapper r10 = (INetworkClientWrapper) ZeusTransformUtils.wrapperContextForParams(r3, INetworkClientWrapper.class, "com.obric.memorydata.plugin");
        IEncryptor r11 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r7, IEncryptor.class, "com.obric.memorydata.plugin");
        HashMap<String, String> r12 = createHeader(r6, r8);
        TTResponse r0 = null;
        byte[] r13 = transformStrToByte(r5, r6, r11);     // Catch: Exception -> L14
        if (r13 == null) goto L7;
        if (r6 == false) goto L7;
        r4 = r4 + "&tt_data=a";     // Catch: Exception -> L14
    L7:
        if (r10 == null) goto L9;
        TTResponse r1 = r10.post(r4, r13, r12);     // Catch: Exception -> L14
        DrLog.d("ticket network client is ready. response is " + r1);     // Catch: Exception -> L14
        return r1;
    L9:
        TTResponse r14 = new TTResponse(r4, 200, null, r9.post(r4, r13, r12));     // Catch: Exception -> L14
        DrLog.d("network client is ready. response is " + r14);     // Catch: Exception -> L12
        return r14;
    L12:
        e = e;
        r0 = r14;
    L15:
        DrLog.e("Register#doRegister http error = ", e);
        e.printStackTrace();
        return r0;
    L14:
        e = e;
        goto L15
    }

    private static byte[] transformStrToByte(String r4, boolean r5, IEncryptor r6) {
        IEncryptor r7 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r6, IEncryptor.class, "com.obric.memorydata.plugin");
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        if (r5 == false) goto L11;
        GZIPOutputStream r3 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r3.write(r4.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L7
        r2 = r3;
    L12:
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L41:
    L21:
        byte[] r8 = r0.toByteArray();
        if (r5 == false) goto L43;
        if (r7 != null) goto L25;
        return r8;
    L25:
        return r7.encrypt(r8, r8.length);
    L43:
        return r8;
    L7:
        th = th;
        r2 = r3;
    L33:
        DrLog.ysnp(th);     // Catch: Throwable -> L26
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r2 != null) goto L35;
    L32:
        throw th;
    L35:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        DrLog.ysnp(e);
        goto L32
    L11:
        r0.write(r4.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L9
    L9:
        th = th;
    L19:
        e = move-exception;
        DrLog.ysnp(e);
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    static boolean verify(INetworkClient r6, INetworkClientWrapper r7, String r8, JSONObject r9, boolean r10, IEncryptor r11, boolean r12, List<Pair<String, String>> r13) {
        INetworkClient r14 = (INetworkClient) ZeusTransformUtils.wrapperContextForParams(r6, INetworkClient.class, "com.obric.memorydata.plugin");
        INetworkClientWrapper r15 = (INetworkClientWrapper) ZeusTransformUtils.wrapperContextForParams(r7, INetworkClientWrapper.class, "com.obric.memorydata.plugin");
        IEncryptor r16 = (IEncryptor) ZeusTransformUtils.wrapperContextForParams(r11, IEncryptor.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        HashMap<String, String> r18 = createHeader(r10, r12);
        if (r17.size() <= 0) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= r17.size()) goto L8;
        r18.put(((Pair) ZeusTransformUtils.preCheckCast(r17.get(r0), Pair.class, "com.obric.memorydata.plugin")).first, ((Pair) ZeusTransformUtils.preCheckCast(r17.get(r0), Pair.class, "com.obric.memorydata.plugin")).second);
        r0 = r0 + 1;
    L8:
        DrLog.d("TicketGuard# [before verify] add headers " + r18);
        JSONObject r19 = null;
        byte[] r20 = transformStrToByte(r9.toString(), r10, r16);     // Catch: Exception -> L19
        if (r20 == null) goto L13;
        if (r10 == false) goto L13;
        r8 = r8 + "&tt_data=a";     // Catch: Exception -> L19
    L13:
        if (r15 == null) goto L15;
        TTResponse r21 = r15.post(r8, r20, r18);     // Catch: Exception -> L19
        DrLog.d("ticket network client is ready. response is " + r21);     // Catch: Exception -> L19
    L16:
        if (r21 == null) goto L21;
        r19 = new JSONObject(r21.getBody());     // Catch: Exception -> L19
    L21:
        if (r19 != null) goto L23;
        return false;
    L23:
        if ("success".equals(r19.optString("message", "")) == false) goto L30;
        return true;
    L30:
        return false;
    L15:
        TTResponse r22 = new TTResponse(r8, 200, null, r14.post(r8, r20, r18));     // Catch: Exception -> L19
        DrLog.d(" network client is ready. response is " + r22);     // Catch: Exception -> L19
        r21 = r22;
    L19:
        e = move-exception;
        DrLog.e("TicketGuard# doVerify http error = ", e);
        e.printStackTrace();
        goto L21
    }
}
