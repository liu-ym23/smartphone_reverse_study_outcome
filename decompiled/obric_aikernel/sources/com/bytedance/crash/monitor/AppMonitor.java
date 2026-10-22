package com.bytedance.crash.monitor;

import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.Global;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AppMonitor extends CrashListener {
    private static final UserDataCenter sUserDataCenter = null;

    private static class Holder {
        public static final AppMonitor DEFAULT = null;

        static {
            DEFAULT = new AppMonitor("4444", NetConst.NOT_ENCRYPT_VERISON_CODE, 0);
        }

        private Holder() {
        }
    }

    static {
        sUserDataCenter = new UserDataCenter();
    }

    AppMonitor() {
        super(sUserDataCenter);
    }

    AppMonitor(@NonNull String r10, @NonNull String r11, long r12) {
        super(sUserDataCenter, r10, r11, r12);
        Global.setAppVersion(r12, 0, 0, r11);
    }

    public static AppMonitor getDefault() {
        return Holder.DEFAULT;
    }

    static UserDataCenter getDefaultUserDataCenter() {
        return sUserDataCenter;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public Map<String, Object> getCommParams() {
        return null;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public EnsureDeliverer getEnsureDeliver() {
        EnsureDeliverer r10 = MonitorManager.getAppEnsureManager();
        r10.setMonitor(this);
        return r10;
    }

    public AppVersionModel getVersionByAppUpdateTime(long r10) {
        return this.mCacheManager.getVersionAfter(r10);
    }
}
