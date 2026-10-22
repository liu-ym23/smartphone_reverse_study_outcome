package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Api {
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
    public static final String KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER = "ZQLiNFJR+CWEI4px";
    public static final String KEY_GOOGLE_AID = "google_aid";
    public static final String KEY_GOOGLE_AID_LIMIT = "gaid_limited";
    public static final String KEY_HEADER = "header";
    public static final String KEY_HTTP_CODE = "HttpCode";
    public static final String KEY_IID = "iid";
    public static final String KEY_INSTALL_ID = "install_id";
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
    public static final String KEY_REGISTER_TIME = "register_time";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_RESOLUTION = "resolution";
    public static final String KEY_ROM = "rom";
    public static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_RTICKET = "_rticket";
    public static final String KEY_SDK_TARGET_VERSION = "sdk_target_version";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SDK_VERSION_CODE = "sdk_version_code";
    public static final String KEY_SERIAL_NUMBER = "serial_number";
    public static final String KEY_SET_COOKIE = "Set-Cookie";
    public static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SIM_REGION = "sim_region";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_SSMIX = "ssmix";
    public static final String KEY_STARTED = "_install_started_v2";
    public static final String KEY_TIMEZONE = "timezone";
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

    static {
        KEYS_PLAINTEXT = new String[]{"aid", "app_version", KEY_TT_DATA, "device_id", "bd_did"};
    }

    public Api() {
    }

    static boolean active(INetworkClient r10, String r11, boolean r12, IEncryptor r13, boolean r14) {
        StringBuilder r15 = new StringBuilder(r11);
        HashMap<String, String> r16 = buildHeader(r14);
        JSONObject r17 = null;
        String r18 = r10.get(encryptUrl(r15.toString(), r12, r13), r16);     // Catch: Exception -> L5
    L7:
        if (r18 != null) goto L18;
    L12:
        if (r17 != null) goto L14;
    L16:
        return false;
    L14:
        if ("success".equals(r17.optString("message", "")) == false) goto L16;
        return true;
    L18:
        r17 = new JSONObject(r18);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        DrLog.e("Register#active parse json error " + r18 + ", ", e);
        e.printStackTrace();
    L5:
        e = move-exception;
        DrLog.e("Register#active http error = ", e);
        e.printStackTrace();
        r18 = null;
        goto L7
    }

    static void addParams(StringBuilder r10, String r11, String r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return;
    L9:
        if (r10.toString().indexOf(63) >= 0) goto L11;
        String r13 = "?";
    L12:
        r10.append(r13);
        r10.append(r11);
        r10.append("=");
        r10.append(Uri.encode(r12));
        return;
    L11:
        r13 = "&";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> buildHeader(final boolean r10) {
        HashMap<String, String> r11 = new HashMap();
        Pair r12 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r10));     // Catch: Throwable -> L7
        if (r12 == null) goto L9;
        r11.put(r12.first, r12.second);     // Catch: Throwable -> L7
    L9:
        return r11;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    private static String encryptUrl(String r10, boolean r11, IEncryptor r12) {
        if (TextUtils.isEmpty(r10) == true) goto L20;
        Uri r13 = Uri.parse(r10);
        String r14 = r13.getQuery();
        ArrayList r15 = new ArrayList();
        String[] r16 = KEYS_PLAINTEXT;
        int r17 = r16.length;
        int r18 = 0;
    L5:
        if (r18 >= r17) goto L10;
        String r19 = r16[r18];
        String r20 = r13.getQueryParameter(r19);
        if (TextUtils.isEmpty(r20) == true) goto L9;
        r15.add(new Pair(r19, r20));
    L9:
        r18 = r18 + 1;
        goto L5
    L10:
        Uri.Builder r21 = r13.buildUpon();
        r21.clearQuery();
        Iterator r22 = r15.iterator();
    L12:
        if (r22.hasNext() == false) goto L14;
        Pair r23 = (Pair) r22.next();
        r21.appendQueryParameter((String) r23.first, (String) r23.second);
        goto L12
    L14:
        r21.appendQueryParameter(KEY_TT_INFO, new String(Base64.encode(transformStrToByte(r14, r11, r12), 8)));
        return r21.build().toString();
    L20:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> getHeaders(boolean r10, final boolean r11) {
        HashMap<String, String> r12 = new HashMap(2);
        if (r10 == false) goto L5;
        String r13 = "application/octet-stream;tt-data=a";
    L6:
        r12.put(NetConst.KEY_CONTENT_TYPE, r13);
        Pair r14 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass2(r11));     // Catch: Throwable -> L11
        if (r14 == null) goto L13;
        r12.put(r14.first, r14.second);     // Catch: Throwable -> L11
    L13:
        return r12;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L5:
        r13 = NetConst.CONTENT_TYPE;
        goto L6
    }

    static JSONObject register(INetworkClient r10, String r11, JSONObject r12, boolean r13, IEncryptor r14, boolean r15) {
        HashMap<String, String> r16 = getHeaders(r13, r15);
        byte[] r17 = transformStrToByte(r12.toString(), r13, r14);     // Catch: Exception -> L9
        if (r17 == null) goto L7;
        if (r13 == false) goto L7;
        r11 = r11 + "&tt_data=a";     // Catch: Exception -> L9
    L7:
        String r18 = r10.post(r11, r17, r16);     // Catch: Exception -> L9
    L11:
        if (r18 == null) goto L21;
        return new JSONObject(r18);
    L14:
        e = move-exception;
        DrLog.e("Register#doRegister parse json error " + r18 + ", ", e);
        e.printStackTrace();
        return null;
    L21:
        return null;
    L9:
        e = move-exception;
        DrLog.e("Register#doRegister http error = ", e);
        e.printStackTrace();
        r18 = null;
        goto L11
    }

    private static byte[] transformStrToByte(String r10, boolean r11, IEncryptor r12) {
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r14 = null;
        if (r11 == false) goto L11;
        GZIPOutputStream r15 = new GZIPOutputStream(r13);     // Catch: Throwable -> L9
        r15.write(r10.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r14 = r15;
    L12:
        if (r14 == null) goto L21;
        r14.close();     // Catch: IOException -> L19
    L33:
    L21:
        byte[] r16 = r13.toByteArray();
        if (r11 == false) goto L43;
        if (r12 != null) goto L25;
        return r16;
    L25:
        return r12.encrypt(r16, r16.length);
    L43:
        return r16;
    L7:
        th = th;
        r14 = r15;
    L36:
        DrLog.ysnp(th);     // Catch: Throwable -> L26
        if (r14 == null) goto L21;
        r14.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r14 != null) goto L40;
    L32:
        throw th;
    L40:
        r14.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        DrLog.ysnp(e);
        goto L32
    L11:
        r13.write(r10.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        DrLog.ysnp(e);
    L9:
        th = th;
        goto L36
    }
}
