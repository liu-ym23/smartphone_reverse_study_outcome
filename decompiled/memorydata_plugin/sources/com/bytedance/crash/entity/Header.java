package com.bytedance.crash.entity;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.AppVersion;
import com.bytedance.crash.dumper.CommonParamInfo;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.general.HardwareInfoHelper;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppVersionModel;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.SettingManager;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Header {
    public static final String KEY_AID = "aid";
    public static final String KEY_APP_LAST_UPDATE_TIME = "last_update_time";
    public static final String KEY_APP_START_TIME = "app_start_time";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CRASH_TYPE = "crash_type";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_GET_PARAMS_ERROR = "get_params_error";
    public static final String KEY_OS_TYPE = "os";
    public static final String KEY_RELEASE_BUILD = "release_build";
    public static final String KEY_TOKEN = "x-auth-token";
    public static final String KEY_UNIQUE_KEY = "unique_key";
    public static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String KEY_VERSION_NAME = "version_name";
    private static int sIs64Bit = -1;
    private long mJiffy;
    private final JSONObject mJson;

    static {
    }

    public Header() {
        this.mJiffy = -1;
        this.mJson = new JSONObject();
    }

    @Deprecated
    public static void addOtherHeader(Header r0) {
    }

    @Deprecated
    public static void addRuntimeHeader(Header r0) {
    }

    public static Header createCrashHeader(AppMonitor r8, long r9, long r11, CrashType r13, int r14, File r15) {
        Header r7 = new Header();
        r7.setAppInfo(r9);
        r7.setInitParams(r8, r9, r11, r15);
        r7.setCommonParams(r15);
        r7.setCommonHeader(r11, r13, r14, r15);
        return r7;
    }

    public static Header createEventHeader(EventMonitor r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        r6.setAppInfo(r8);
        r6.setInitParams(r7, r10);
        r6.setCommonHeader(r8, r10, r11, null);
        return r6;
    }

    @Deprecated
    public static Header createHeader(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return new Header();
    }

    public static Header createHeaderWithoutCommon(AppMonitor r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        r6.setAppInfo(r8);
        JSONObject r0 = r6.mJson;
        if (r0.has("device_id") == true) goto L6;
        JSONUtils.put(r0, "device_id", r7.getDeviceId("0"));
    L6:
        if (r0.has("channel") == true) goto L8;
        JSONUtils.put(r0, "channel", r7.getChannel(r8));
    L8:
        int r1 = SettingManager.AID_DEFAULT;
        r1 = Integer.parseInt(r7.getAppId());     // Catch: Throwable -> L24
    L10:
        JSONUtils.put(r0, "aid", Integer.valueOf(r1));
        AppVersionModel r9 = r7.getVersion(r8);
        if (r9.getVersionName() == null) goto L14;
        JSONUtils.put(r0, "app_version", r9.getVersionName());
    L14:
        if (r9.getVersionCode() == 0) goto L17;
        JSONUtils.put(r0, "version_code", Long.valueOf(r9.getVersionCode()));
    L17:
        if (r9.getUpdateVersionCode() == 0) goto L20;
        JSONUtils.put(r0, "update_version_code", Long.valueOf(r9.getUpdateVersionCode()));
    L20:
        if (r9.getManifestVersionCode() == 0) goto L22;
        JSONUtils.put(r0, "manifest_version_code", Long.valueOf(r9.getManifestVersionCode()));
    L22:
        r6.setCommonHeader(r8, r10, r11, null);
        return r6;
    }

    public static boolean is64BitDevice() {
        if (sIs64Bit != (-1)) goto L6;
        sIs64Bit = HardwareInfoHelper.getCpuAbi().contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;
    L6:
        if (sIs64Bit == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Deprecated
    private static void packRom(JSONObject r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        JSONObject r2 = new JSONObject();
        GeneralInfoManager.putRomInfo(r2);
        r4.put(Api.KEY_ROM, r2.optString(Api.KEY_ROM));     // Catch: JSONException -> L8
        r4.put("rom_version", r2.optString("rom_version"));     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    private void setAppInfo(long r1) {
        GeneralInfoManager.putAppInfo(this.mJson, r1);
    }

    private void setCommonHeader(long r1, CrashType r3, int r4, File r5) {
        setRomInfo();
        setHardwareInfo();
        setCrashType(r3);
        setUniqueKey(r3, r4, r1);
        setLocale(r5);
    }

    private void setCommonParams(File r1) {
        if (r1 == null) goto L5;
        CommonParamInfo.load(this.mJson, r1);
        return;
    }

    private void setCrashType(CrashType r2) {
        JSONUtils.put(getJson(), KEY_CRASH_TYPE, r2.getName());
    }

    private void setHardwareInfo() {
        GeneralInfoManager.putHardwareInfo(this.mJson);
        this.mJiffy = GeneralInfoManager.getJiffy();
    }

    private void setInitParams(AppMonitor r10, long r11, long r13, File r15) {
        JSONUtils.put(this.mJson, "device_id", r10.getDeviceId(r13));
        JSONUtils.put(this.mJson, KEY_USER_ID, Long.valueOf(r10.getUserId(r13)));
        JSONUtils.put(this.mJson, "channel", r10.getChannel(r13));
        JSONUtils.put(this.mJson, "mp_params", r10.getMPParams());
        int r0 = Integer.parseInt(r10.getAppId(r13));     // Catch: Throwable -> L5
    L6:
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(r0));
        if (AppVersion.load(this.mJson, r15) == true) goto L34;
        long r2 = getLastUpdateTime();
        if (r2 > 0) goto L15;
    L23:
        AppVersionModel r12 = r10.getVersion(r13);
        if (r12 != null) goto L26;
    L30:
        JSONObject r9 = this.mJson;
        String r14 = "app_info";
    L10:
        JSONUtils.put(r9, "version_type", r14);
        return;
    L26:
        if (r12.getVersionCode() == 0) goto L30;
        if (r12.getVersionName() == null) goto L30;
        JSONUtils.put(this.mJson, "app_version", r12.getVersionName());
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r12.getUpdateVersionCode()));
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r12.getVersionCode()));
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r12.getManifestVersionCode()));
        r9 = this.mJson;
        r14 = "crash_time";
        goto L10
    L15:
        if (r11 <= r2) goto L23;
        AppVersionModel r16 = r10.getVersionByAppUpdateTime(r2);
        if (r16 == null) goto L23;
        if (r16.getVersionCode() == 0) goto L23;
        if (r16.getVersionName() == null) goto L23;
        JSONUtils.put(this.mJson, "app_version", r16.getVersionName());
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r16.getUpdateVersionCode()));
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r16.getVersionCode()));
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r16.getManifestVersionCode()));
        r9 = this.mJson;
        r14 = KEY_APP_LAST_UPDATE_TIME;
        goto L10
    L34:
        JSONObject r17 = this.mJson;     // Catch: Throwable -> L31
        JSONUtils.put(r17, "init_version_name", r17.opt("version_name"));     // Catch: Throwable -> L31
        JSONObject r18 = this.mJson;     // Catch: Throwable -> L31
        JSONUtils.put(r18, "init_update_version_code", r18.opt("update_version_code"));     // Catch: Throwable -> L31
    L9:
        r9 = this.mJson;
        r14 = "crash_dump";
    L5:
        r0 = SettingManager.AID_DEFAULT;
        goto L6
    }

    private void setInitParams(EventMonitor r7, CrashType r8) {
        JSONUtils.put(this.mJson, "device_id", r7.getDeviceId("0"));
        JSONUtils.put(this.mJson, KEY_USER_ID, Long.valueOf(r7.getUserId()));
        JSONUtils.put(this.mJson, "channel", r7.getChannel());
        JSONUtils.put(this.mJson, "mp_params", r7.getMPParams());
        int r9 = Integer.parseInt(r7.getAppId());     // Catch: Throwable -> L5
    L6:
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(r9));
        AppVersionModel r10 = r7.getVersion();
        if (r10.getVersionName() == null) goto L10;
        JSONUtils.put(this.mJson, "app_version", r10.getVersionName());
    L10:
        if (r10.getVersionCode() == 0) goto L13;
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r10.getVersionCode()));
    L13:
        if (r10.getUpdateVersionCode() == 0) goto L16;
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r10.getUpdateVersionCode()));
    L16:
        if (r10.getManifestVersionCode() == 0) goto L18;
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r10.getManifestVersionCode()));
    L18:
        Map<String, Object> r11 = r7.getCommParams();
        if (r11 == null) goto L26;
        Iterator<String> r12 = r11.keySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L34;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (r11.get(r0) == null) goto L22;
        JSONUtils.put(this.mJson, r0, r11.get(r0));
        goto L22
    L34:
        return;
    L26:
        return;
    L5:
        r9 = SettingManager.AID_DEFAULT;
        goto L6
    }

    private void setLocale(File r1) {
        LocaleInfo.putTo(this.mJson, r1);
    }

    private void setRomInfo() {
        GeneralInfoManager.putRomInfo(this.mJson);
    }

    private void setUniqueKey(CrashType r3, int r4, long r5) {
        JSONUtils.put(getJson(), KEY_UNIQUE_KEY, "android_" + getDeviceId() + "_" + r5 + "_" + r4 + "_" + r3.getName());
    }

    @Deprecated
    public JSONObject expandHeader(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return this.mJson;
    }

    public int getAid() {
        return this.mJson.optInt("aid");
    }

    public CrashType getCrashType() {
        return CrashType.getType(this.mJson.optString(KEY_CRASH_TYPE));
    }

    public String getDeviceId() {
        return this.mJson.optString("device_id");
    }

    @Deprecated
    public JSONObject getHeaderJson() {
        return this.mJson;
    }

    public long getJiffy() {
        return this.mJiffy;
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public long getLastUpdateTime() {
        return this.mJson.optLong(KEY_APP_LAST_UPDATE_TIME);
    }

    @Deprecated
    public void setDeviceId(String r3) {
        AppMonitor r4 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L6
        if (r4 == null) goto L11;
        this.mJson.put("device_id", r4.getDeviceId("0"));     // Catch: JSONException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated
    public void setUserId(long r3) {
        AppMonitor r4 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L6
        if (r4 == null) goto L11;
        this.mJson.put(KEY_USER_ID, r4.getUserId());     // Catch: JSONException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
