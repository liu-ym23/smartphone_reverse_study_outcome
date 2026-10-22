package com.bytedance.badger.collect.impl.monitor;

import com.bytedance.badger.collect.impl.BuildConfig;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.interfaces.ICommonConfig;
import com.bytedance.badger.collect.impl.utils.KLog;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class AbsMonitor {
    protected final SecureRandom random;

    public abstract void clear();

    public abstract String getEventName();

    public abstract JSONObject getParams() throws Exception;

    public void report() {
        ICommonConfig r1 = BadgerCollectApi.commonConfig;
        if (r1 != null) goto L5;
        return;
    L5:
        int r2 = r1.getSampleRate();
        if (r2 > 0) goto L8;
    L20:
        JSONObject r3 = getParams();     // Catch: Exception -> L19
        String r4 = getEventName();     // Catch: Exception -> L19
        if (r3 == null) goto L14;
        r3.putOpt("params_for_special", "uc_login");     // Catch: Exception -> L19
        r3.putOpt("sdk_version_code", Integer.valueOf(BuildConfig.SDK_VERSION_CODE));     // Catch: Exception -> L19
        r3.putOpt("sdk_version_name", BuildConfig.SDK_VERSION_NAME);     // Catch: Exception -> L19
        r3.putOpt("device_id", r1.getDeviceId());     // Catch: Exception -> L19
        r3.putOpt("tag", "badger");     // Catch: Exception -> L19
    L14:
        r1.onEventDepend(r4, r3);     // Catch: Exception -> L19
        if (KLog.isDebug() == false) goto L17;
        KLog.d(Constants.TAGS.EVENT, "埋点数据: " + r4 + ", " + r3);     // Catch: Exception -> L19
    L17:
        clear();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L8:
        if (this.random.nextInt(r2) == 0) goto L20;
        KLog.w(Constants.TAGS.EVENT, getEventName() + " 被采样，不上报埋点");
    }

    public AbsMonitor() {
        this.random = new SecureRandom();
    }
}
