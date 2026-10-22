package com.bytedance.apm6.consumer.slardar.header;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderUtils {
    private static long sHeaderKey = -1;

    static {
    }

    public HeaderUtils() {
    }

    public static HeaderInfo deserialize(byte[] r10) {
        HeaderInfo r11 = new HeaderInfo();     // Catch: Exception -> L9
        JSONObject r12 = new JSONObject(new String(r10));     // Catch: Exception -> L9
        r11.setVersionCode(JsonUtils.removeString(r12, "version_code"));     // Catch: Exception -> L9
        r11.setVersionName(JsonUtils.removeString(r12, "version_name"));     // Catch: Exception -> L9
        r11.setManifestVersionCode(JsonUtils.removeString(r12, "manifest_version_code"));     // Catch: Exception -> L9
        r11.setUpdateVersionCode(JsonUtils.removeString(r12, "update_version_code"));     // Catch: Exception -> L9
        r11.setAppVersion(JsonUtils.removeString(r12, "app_version"));     // Catch: Exception -> L9
        r11.setOs(JsonUtils.removeString(r12, "os"));     // Catch: Exception -> L9
        r11.setDevicePlatform(JsonUtils.removeString(r12, "device_platform"));     // Catch: Exception -> L9
        r11.setOsVersion(JsonUtils.removeString(r12, "os_version"));     // Catch: Exception -> L9
        r11.setApiVersion(JsonUtils.removeInt(r12, "os_api"));     // Catch: Exception -> L9
        r11.setDeviceModel(JsonUtils.removeString(r12, "device_model"));     // Catch: Exception -> L9
        r11.setDeviceBrand(JsonUtils.removeString(r12, "device_brand"));     // Catch: Exception -> L9
        r11.setDeviceManufacturer(JsonUtils.removeString(r12, "device_manufacturer"));     // Catch: Exception -> L9
        r11.setProcessName(JsonUtils.removeString(r12, "process_name"));     // Catch: Exception -> L9
        r11.setSid(JsonUtils.removeLong(r12, "sid"));     // Catch: Exception -> L9
        r11.setRomVersion(JsonUtils.removeString(r12, "rom_version"));     // Catch: Exception -> L9
        r11.setPackageName(JsonUtils.removeString(r12, "package"));     // Catch: Exception -> L9
        r11.setMonitorVersion(JsonUtils.removeString(r12, Constants.KEY_MONITOR_VERSION));     // Catch: Exception -> L9
        r11.setChannel(JsonUtils.removeString(r12, "channel"));     // Catch: Exception -> L9
        r11.setAid(JsonUtils.removeInt(r12, "aid"));     // Catch: Exception -> L9
        r11.setDeviceId(JsonUtils.removeString(r12, "device_id"));     // Catch: Exception -> L9
        r11.setPhoneStartTime(JsonUtils.removeLong(r12, Constants.KEY_PHONE_STARTUP_TIME));     // Catch: Exception -> L9
        r11.setReleaseBuild(JsonUtils.removeString(r12, "release_build"));     // Catch: Exception -> L9
        r11.setUid(JsonUtils.removeLong(r12, "uid"));     // Catch: Exception -> L9
        r11.setVerifyInfo(JsonUtils.removeString(r12, Constants.KEY_VERIFY_INFO));     // Catch: Exception -> L9
        r11.setCurrentUpdateVersionCode(JsonUtils.removeString(r12, Constants.KEY_HEADER_UPDATE_VERSION_CODE));     // Catch: Exception -> L9
        if (r12.has(Constants.KEY_CONFIG_TIME) == false) goto L12;
        r11.setConfigTime(JsonUtils.removeInt(r12, Constants.KEY_CONFIG_TIME));     // Catch: Exception -> L9
    L12:
        r11.setFilters(new JSONObject((String) r12.remove("filters")));     // Catch: Exception -> L11
    L7:
        r11.setStableExtra(r12);     // Catch: Exception -> L9
        return r11;
    L9:
        return null;
    }

    static long getTimeByHeaderId(long r10) {
        if (r10 >= 0) goto L6;
        return 0;
    L6:
        return r10 >> 16;
    }

    public static long getUniqueHeaderId() {
        if (sHeaderKey != (-1)) goto L6;
        long r10 = ApmContext.getStartId();
        sHeaderKey = (r10 << 16) | ((long) Process.myPid());
    L6:
        return sHeaderKey;
    }

    public static JSONObject serialize(HeaderInfo r10) {
        if (r10 != null) goto L31;
        return null;
    L31:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L30
        if (r10.getStableExtra() == null) goto L9;
        r11 = JsonUtils.copyJson2(r11, r10.getStableExtra());     // Catch: Exception -> L30
    L9:
        if (r10.getDynamicExtra() == null) goto L11;
        r11 = JsonUtils.copyJson2(r11, r10.getDynamicExtra());     // Catch: Exception -> L30
    L11:
        r11.put("version_code", r10.getVersionCode());     // Catch: Exception -> L30
        r11.put("version_name", r10.getVersionName());     // Catch: Exception -> L30
        r11.put("manifest_version_code", r10.getManifestVersionCode());     // Catch: Exception -> L30
        r11.put("update_version_code", r10.getUpdateVersionCode());     // Catch: Exception -> L30
        r11.put("app_version", r10.getAppVersion());     // Catch: Exception -> L30
        r11.put("os", r10.getOs());     // Catch: Exception -> L30
        r11.put("device_platform", r10.getDevicePlatform());     // Catch: Exception -> L30
        r11.put("os_version", r10.getOsVersion());     // Catch: Exception -> L30
        r11.put("os_api", r10.getApiVersion());     // Catch: Exception -> L30
        r11.put("device_model", r10.getDeviceModel());     // Catch: Exception -> L30
        r11.put("device_brand", r10.getDeviceBrand());     // Catch: Exception -> L30
        r11.put("device_manufacturer", r10.getDeviceManufacturer());     // Catch: Exception -> L30
        r11.put("process_name", r10.getProcessName());     // Catch: Exception -> L30
        r11.put("sid", r10.getSid());     // Catch: Exception -> L30
        r11.put("rom_version", r10.getRomVersion());     // Catch: Exception -> L30
        r11.put("package", r10.getPackageName());     // Catch: Exception -> L30
        r11.put(Constants.KEY_MONITOR_VERSION, r10.getMonitorVersion());     // Catch: Exception -> L30
        r11.put("channel", r10.getChannel());     // Catch: Exception -> L30
        r11.put("aid", r10.getAid());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r10.getDeviceId()) == true) goto L14;
        r11.put("device_id", r10.getDeviceId());     // Catch: Exception -> L30
    L14:
        r11.put("uid", r10.getUid());     // Catch: Exception -> L30
        r11.put(Constants.KEY_PHONE_STARTUP_TIME, r10.getPhoneStartTime());     // Catch: Exception -> L30
        r11.put("release_build", r10.getReleaseBuild());     // Catch: Exception -> L30
        if (r10.getConfigTime() == (-1)) goto L18;
        r11.put(Constants.KEY_CONFIG_TIME, String.valueOf(r10.getConfigTime()));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r10.getVerifyInfo()) == true) goto L20;
        r11.put(Constants.KEY_VERIFY_INFO, r10.getVerifyInfo());     // Catch: Exception -> L30
    L20:
        r11.put(Constants.KEY_HEADER_UPDATE_VERSION_CODE, r10.getCurrentUpdateVersionCode());     // Catch: Exception -> L30
        if (r10.getNtpTime() == (-1)) goto L24;
        r11.put(Constants.KEY_NTP_TIME, r10.getNtpTime());     // Catch: Exception -> L30
    L24:
        if (r10.getNtpOffset() == (-1)) goto L27;
        r11.put(Constants.KEY_NTP_OFFSET, r10.getNtpOffset());     // Catch: Exception -> L30
    L27:
        if (r10.getFilters() == null) goto L29;
        r11.put("filters", r10.getFilters());     // Catch: Exception -> L30
    L29:
        return r11;
    L30:
        return null;
    }
}
