package com.bytedance.bdinstall.dtrait.extra_finger;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.bytedance.bdinstall.dtrait.utils.DTraitTraceUtil;
import com.bytedance.bdinstall.dtrait.utils.Utils;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.security.Sword.Sword;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ExtraLoaderConfigHandler {
    private static final long ONE_HOUR = 3600000;
    private final DTraitCacheManager dTraitCacheManager;
    private long delayTime;
    private long dtraitExpireTime;
    private final Map<String, JSONObject> dtraitFieldsMap;
    private final Map<String, JSONObject> fieldsMap;
    private final ReentrantLock lock;
    private String version;

    public ExtraLoaderConfigHandler(Context r4, DTraitCacheManager r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.delayTime = 5000;
        this.dtraitExpireTime = 1800000;
        this.fieldsMap = new HashMap();
        HashMap r0 = new HashMap();
        this.dtraitFieldsMap = r0;
        this.version = "";
        this.lock = new ReentrantLock();
        this.dTraitCacheManager = r5;
        parseConfigFields(Utils.getCommonSp(r6).getString(DTraitConstant.KEY_D_DATA, ""));
        DTraitTraceUtil.log(DTraitLogLevel.DEBUG, DTraitConstant.BUSINESS_TAG_DEVICE, DTraitConstant.METHOD_EXTRA_LOADER_CONFIG_HANDLER, String.format("ExtraLoaderConfigHandler# init config from sp, dtraitFields: %s", new Object[]{new JSONObject(r0)}));
    }

    private boolean isValidResponse(JSONObject r2) {
        if (r2.optString("message", "").equals("ok") == true) goto L6;
        DTLog.d("[dt] parseDTraitConfig# error response.message not equals ok");
        return false;
    L6:
        return true;
    }

    private void parseConfigFields(String r7) {
        if (this.fieldsMap.isEmpty() == false) goto L5;
    L7:
        byte[] r8 = Sword.clientUnpackedBase64(r7);
        if (r8 != null) goto L10;
    L26:
        DTLog.d("[dt] parseDTraitConfig# error bytesData is null");
        return;
    L10:
        if (r8.length == 0) goto L26;
        JSONObject r0 = new JSONObject(new String(r8));     // Catch: Exception -> L23
        if (DTLog.debug() == false) goto L15;
        DTLog.d("[dt] parseDTraitConfig# success: " + r0);     // Catch: Exception -> L23
    L15:
        this.version = r0.optString("version", "");     // Catch: Exception -> L23
        parseJSONArrayFieldsConfig(r0, "fields", this.fieldsMap);     // Catch: Exception -> L23
        int r9 = r0.optInt("delay_sec", 0);     // Catch: Exception -> L23
        if (r9 <= 0) goto L18;
        this.delayTime = ((long) r9) * 1000;     // Catch: Exception -> L23
    L18:
        int r10 = r0.optInt("dtrait_mem_ttl_sec", 0);     // Catch: Exception -> L23
        if (r10 <= 0) goto L21;
        this.dtraitExpireTime = ((long) r10) * 1000;     // Catch: Exception -> L23
    L21:
        parseJSONArrayFieldsConfig(r0, "dtrait_fields", this.dtraitFieldsMap);     // Catch: Exception -> L23
        DTLog.d(DTraitConstant.TAG_DTRAIT + String.format("parseConfigFields# fields: status_collect delay time:%s, dtraitExpireTime:%s", new Object[]{Long.valueOf(this.delayTime), Long.valueOf(this.dtraitExpireTime)}));     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        DTLog.e("[dt] parseConfigFields# error: " + e.getMessage());
        return;
    L5:
        if (this.dtraitFieldsMap.isEmpty() == true) goto L7;
    }

    private void parseJSONArrayFieldsConfig(JSONObject r3, String r4, Map<String, JSONObject> r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        JSONArray r6 = r3.optJSONArray(r4);
        if (r6 != null) goto L6;
        DTLog.e("[dt] parseFieldsConfig# fields config is null, key: " + r4);
        return;
    L6:
        int r7 = 0;
    L8:
        if (r7 >= r6.length()) goto L10;
        JSONObject r8 = (JSONObject) ZeusTransformUtils.preCheckCast(r6.get(r7), JSONObject.class, "com.obric.memorydata.plugin");
        r2.put(r8.optString(ActivityLifecycle.NAME), r8);
        r7 = r7 + 1;
        goto L8
    }

    private void updateMemCacheAndRisk(String r3) {
        this.dTraitCacheManager.updateDiskCache(DTraitConstant.KEY_D_DATA, r3);
        this.dTraitCacheManager.updateMemoryCache(DTraitConstant.KEY_D_DATA, r3);
    }

    public Map<String, JSONObject> getDTraitFiledsMap() {
        return this.dtraitFieldsMap;
    }

    public long getDelayTime() {
        return this.delayTime;
    }

    public long getDtraitExpireTime() {
        return this.dtraitExpireTime;
    }

    public Map<String, JSONObject> getFiledsMap() {
        return this.fieldsMap;
    }

    public String getVersion() {
        return this.version;
    }

    public void parseLoaderConfig(JSONObject r3) {
        this.lock.lock();
    L14:
        e = move-exception;
        DTLog.e("[dt] parseDTraitConfig# error " + e.getMessage());     // Catch: Throwable -> L12
    L16:
        this.lock.unlock();
        return;
    L4:
        if (isValidResponse(r3) == true) goto L7;
    L5:
        this.lock.unlock();
        return;
    L7:
        String r4 = r3.optString("data");     // Catch: Throwable -> L12 Exception -> L14
        if (TextUtils.isEmpty(r4) == false) goto L10;
        DTLog.d("[dt] parseLoaderConfig error response.data is null");     // Catch: Throwable -> L12 Exception -> L14
        goto L5
    L10:
        updateMemCacheAndRisk(r4);     // Catch: Throwable -> L12 Exception -> L14
        parseConfigFields(r4);     // Catch: Throwable -> L12 Exception -> L14
        DTLog.d("[dt] parseDTraitConfig# updateMemCacheAndRisk config parse success");     // Catch: Throwable -> L12 Exception -> L14
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void updateSpLoaderConfig(JSONObject r2) {
    L11:
        e = move-exception;
        DTLog.e("[dt] updateSpLoaderConfig# error " + e.getMessage());
        return;
    L3:
        if (isValidResponse(r2) == true) goto L5;
        return;
    L5:
        String r3 = r2.optString("data");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r3) == false) goto L9;
        DTLog.d("[dt] updateSpLoaderConfig# error response.data is null");     // Catch: Exception -> L11
        return;
    L9:
        updateMemCacheAndRisk(r3);     // Catch: Exception -> L11
        parseConfigFields(r3);     // Catch: Exception -> L11
        DTLog.d("[dt] updateSpLoaderConfig# updateMemCacheAndRisk success");     // Catch: Exception -> L11
    }
}
