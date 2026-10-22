package com.bytedance.crash.entity;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
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
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    public static void addOtherHeader(Header r10) {
    }

    @Deprecated
    public static void addRuntimeHeader(Header r10) {
    }

    public static Header createCrashHeader(@NonNull AppMonitor r10, long r11, long r12, CrashType r13, int r14, File r15) {
        Header r16 = new Header();
        r16.setAppInfo(r11);
        r16.setInitParams(r10, r11, r12, r15);
        r16.setCommonParams(r15);
        r16.setCommonHeader(r12, r13, r14, r15);
        return r16;
    }

    public static Header createEventHeader(@NonNull EventMonitor r10, long r11, CrashType r12, int r13) {
        Header r14 = new Header();
        r14.setAppInfo(r11);
        r14.setInitParams(r10, r12);
        r14.setCommonHeader(r11, r12, r13, null);
        return r14;
    }

    @Deprecated
    public static Header createHeader(Context r10) {
        return new Header();
    }

    public static Header createHeaderWithoutCommon(@NonNull AppMonitor r10, long r11, CrashType r12, int r13) {
        Header r14 = new Header();
        r14.setAppInfo(r11);
        JSONObject r15 = r14.mJson;
        if (r15.has("device_id") == true) goto L6;
        JSONUtils.put(r15, "device_id", r10.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));
    L6:
        if (r15.has("channel") == true) goto L8;
        JSONUtils.put(r15, "channel", r10.getChannel(r11));
    L8:
        int r16 = SettingManager.AID_DEFAULT;
        r16 = Integer.parseInt(r10.getAppId());     // Catch: Throwable -> L24
    L10:
        JSONUtils.put(r15, "aid", Integer.valueOf(r16));
        AppVersionModel r17 = r10.getVersion(r11);
        if (r17.getVersionName() == null) goto L14;
        JSONUtils.put(r15, "app_version", r17.getVersionName());
    L14:
        if (r17.getVersionCode() == 0) goto L17;
        JSONUtils.put(r15, "version_code", Long.valueOf(r17.getVersionCode()));
    L17:
        if (r17.getUpdateVersionCode() == 0) goto L20;
        JSONUtils.put(r15, "update_version_code", Long.valueOf(r17.getUpdateVersionCode()));
    L20:
        if (r17.getManifestVersionCode() == 0) goto L22;
        JSONUtils.put(r15, "manifest_version_code", Long.valueOf(r17.getManifestVersionCode()));
    L22:
        r14.setCommonHeader(r11, r12, r13, null);
        return r14;
    }

    public static boolean is64BitDevice() {
        if (sIs64Bit != (-1)) goto L6;
        sIs64Bit = HardwareInfoHelper.getCpuAbi().contains("64") ? 1 : 0;
    L6:
        if (sIs64Bit == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Deprecated
    private static void packRom(JSONObject r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject();
        GeneralInfoManager.putRomInfo(r11);
        r10.put(Api.KEY_ROM, r11.optString(Api.KEY_ROM));     // Catch: JSONException -> L8
        r10.put("rom_version", r11.optString("rom_version"));     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    private void setAppInfo(long r10) {
        GeneralInfoManager.putAppInfo(this.mJson, r10);
    }

    private void setCommonHeader(long r10, CrashType r11, int r12, File r13) {
        setRomInfo();
        setHardwareInfo();
        setCrashType(r11);
        setUniqueKey(r11, r12, r10);
        setLocale(r13);
    }

    private void setCommonParams(File r10) {
        if (r10 == null) goto L5;
        CommonParamInfo.load(this.mJson, r10);
        return;
    }

    private void setCrashType(CrashType r10) {
        JSONUtils.put(getJson(), KEY_CRASH_TYPE, r10.getName());
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
        int r12 = Integer.parseInt(r10.getAppId(r13));     // Catch: Throwable -> L5
    L6:
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(r12));
        if (AppVersion.load(this.mJson, r15) == true) goto L34;
        long r14 = getLastUpdateTime();
        if (r14 > 0) goto L15;
    L23:
        AppVersionModel r16 = r10.getVersion(r13);
        if (r16 != null) goto L26;
    L30:
        JSONObject r17 = this.mJson;
        String r18 = "app_info";
    L10:
        JSONUtils.put(r17, "version_type", r18);
        return;
    L26:
        if (r16.getVersionCode() == 0) goto L30;
        if (r16.getVersionName() == null) goto L30;
        JSONUtils.put(this.mJson, "app_version", r16.getVersionName());
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r16.getUpdateVersionCode()));
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r16.getVersionCode()));
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r16.getManifestVersionCode()));
        r17 = this.mJson;
        r18 = "crash_time";
        goto L10
    L15:
        if (r11 <= r14) goto L23;
        AppVersionModel r19 = r10.getVersionByAppUpdateTime(r14);
        if (r19 == null) goto L23;
        if (r19.getVersionCode() == 0) goto L23;
        if (r19.getVersionName() == null) goto L23;
        JSONUtils.put(this.mJson, "app_version", r19.getVersionName());
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r19.getUpdateVersionCode()));
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r19.getVersionCode()));
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r19.getManifestVersionCode()));
        r17 = this.mJson;
        r18 = KEY_APP_LAST_UPDATE_TIME;
        goto L10
    L34:
        JSONObject r110 = this.mJson;     // Catch: Throwable -> L31
        JSONUtils.put(r110, "init_version_name", r110.opt("version_name"));     // Catch: Throwable -> L31
        JSONObject r111 = this.mJson;     // Catch: Throwable -> L31
        JSONUtils.put(r111, "init_update_version_code", r111.opt("update_version_code"));     // Catch: Throwable -> L31
    L9:
        r17 = this.mJson;
        r18 = "crash_dump";
    L5:
        r12 = SettingManager.AID_DEFAULT;
        goto L6
    }

    private void setInitParams(EventMonitor r10, CrashType r11) {
        JSONUtils.put(this.mJson, "device_id", r10.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));
        JSONUtils.put(this.mJson, KEY_USER_ID, Long.valueOf(r10.getUserId()));
        JSONUtils.put(this.mJson, "channel", r10.getChannel());
        JSONUtils.put(this.mJson, "mp_params", r10.getMPParams());
        int r12 = Integer.parseInt(r10.getAppId());     // Catch: Throwable -> L5
    L6:
        JSONUtils.put(this.mJson, "aid", Integer.valueOf(r12));
        AppVersionModel r13 = r10.getVersion();
        if (r13.getVersionName() == null) goto L10;
        JSONUtils.put(this.mJson, "app_version", r13.getVersionName());
    L10:
        if (r13.getVersionCode() == 0) goto L13;
        JSONUtils.put(this.mJson, "version_code", Long.valueOf(r13.getVersionCode()));
    L13:
        if (r13.getUpdateVersionCode() == 0) goto L16;
        JSONUtils.put(this.mJson, "update_version_code", Long.valueOf(r13.getUpdateVersionCode()));
    L16:
        if (r13.getManifestVersionCode() == 0) goto L18;
        JSONUtils.put(this.mJson, "manifest_version_code", Long.valueOf(r13.getManifestVersionCode()));
    L18:
        Map<String, Object> r14 = r10.getCommParams();
        if (r14 == null) goto L26;
        Iterator<String> r15 = r14.keySet().iterator();
    L22:
        if (r15.hasNext() == false) goto L34;
        String r16 = r15.next();
        if (r14.get(r16) == null) goto L22;
        JSONUtils.put(this.mJson, r16, r14.get(r16));
        goto L22
    L34:
        return;
    L26:
        return;
    L5:
        r12 = SettingManager.AID_DEFAULT;
        goto L6
    }

    private void setLocale(File r10) {
        LocaleInfo.putTo(this.mJson, r10);
    }

    private void setRomInfo() {
        GeneralInfoManager.putRomInfo(this.mJson);
    }

    private void setUniqueKey(CrashType r10, int r11, long r12) {
        JSONUtils.put(getJson(), KEY_UNIQUE_KEY, "android_" + getDeviceId() + "_" + r12 + "_" + r11 + "_" + r10.getName());
    }

    @Deprecated
    public JSONObject expandHeader(@Nullable Map<String, Object> r10) {
        return this.mJson;
    }

    public int getAid() {
        return this.mJson.optInt("aid");
    }

    @NonNull
    public CrashType getCrashType() {
        return CrashType.getType(this.mJson.optString(KEY_CRASH_TYPE));
    }

    @NonNull
    public String getDeviceId() {
        return this.mJson.optString("device_id");
    }

    @NonNull
    @Deprecated
    public JSONObject getHeaderJson() {
        return this.mJson;
    }

    public long getJiffy() {
        return this.mJiffy;
    }

    @NonNull
    public JSONObject getJson() {
        return this.mJson;
    }

    public long getLastUpdateTime() {
        return this.mJson.optLong(KEY_APP_LAST_UPDATE_TIME);
    }

    @Deprecated
    public void setDeviceId(String r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L6
        if (r11 == null) goto L11;
        this.mJson.put("device_id", r11.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE));     // Catch: JSONException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Deprecated
    public void setUserId(long r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L6
        if (r11 == null) goto L11;
        this.mJson.put(KEY_USER_ID, r11.getUserId());     // Catch: JSONException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
