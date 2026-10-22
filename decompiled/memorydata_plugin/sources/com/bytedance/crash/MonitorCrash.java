package com.bytedance.crash;

import android.content.Context;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.monitor.SdkMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorCrash {

    @Deprecated
    private final Config mConfig;
    private final CrashListener mCrashListener;

    @Deprecated
    public class Config {
        private final MonitorCrash mMonitorCrash;
        final /* synthetic */ MonitorCrash this$0;

        Config(MonitorCrash r1, MonitorCrash r2) {
            this.this$0 = r1;
            this.mMonitorCrash = r2;
        }

        public Config setChannel(String r2) {
            this.mMonitorCrash.setChannel(r2);
            return this;
        }

        public Config setDeviceId(String r2) {
            this.mMonitorCrash.setDeviceId(r2);
            return this;
        }

        public Config setPackageName(String r2) {
            this.mMonitorCrash.setPackageName(r2);
            return this;
        }

        public Config setSoList(String[] r2) {
            this.mMonitorCrash.setSoList(r2);
            return this;
        }

        public Config setUID(long r2) {
            this.mMonitorCrash.setUserId(r2);
            return this;
        }
    }

    private MonitorCrash(CrashListener r1) {
        this.mCrashListener = r1;
        this.mConfig = new Config(this, this);
    }

    @Deprecated
    public static MonitorCrash init(Context r2, String r3, long r4, String r6) {
        return initApp((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r6);
    }

    public static MonitorCrash initApp(Context r2, String r3, long r4, String r6) {
        return new MonitorCrash(MonitorManager.createAppMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r6, r4));
    }

    public static MonitorCrash initSDK(Context r7, String r8, long r9, String r11, String r12) {
        return initSDK((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12, null);
    }

    public static MonitorCrash initSDK(Context r7, String r8, long r9, String r11, String r12, String[] r13) {
        return new MonitorCrash(MonitorManager.createSdkMonitor((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r11, r9, new String[]{r12}, r13));
    }

    @Deprecated
    public Config config() {
        return this.mConfig;
    }

    public UserDataCenter getUserDataCenter() {
        return this.mCrashListener.getUserDataCenter();
    }

    @Deprecated
    public void reportCustomErr(String r1, String r2, Throwable r3) {
        this.mCrashListener.reportEnsure(r1, r3);
    }

    public void reportCustomErr(String r1, Throwable r2) {
        this.mCrashListener.reportEnsure(r1, r2);
    }

    public void reportEvent(String r1, int r2, JSONObject r3, JSONObject r4) {
        this.mCrashListener.reportEvent(r1, r2, r3, r4);
    }

    public void setChannel(String r1) {
        this.mCrashListener.setChannel(r1);
    }

    public void setDeviceId(String r1) {
        this.mCrashListener.setDeviceId(r1);
    }

    public void setPackageName(String r3) {
        if (ZeusTransformUtils.instanceOf(this.mCrashListener, SdkMonitor.class) == false) goto L6;
        ((SdkMonitor) ZeusTransformUtils.preCheckCast(this.mCrashListener, SdkMonitor.class, "com.obric.memorydata.plugin")).setPackageName(new String[]{r3});
        return;
    }

    public void setSoList(String[] r3) {
        if (ZeusTransformUtils.instanceOf(this.mCrashListener, SdkMonitor.class) == false) goto L6;
        ((SdkMonitor) ZeusTransformUtils.preCheckCast(this.mCrashListener, SdkMonitor.class, "com.obric.memorydata.plugin")).setSoList(r3);
        return;
    }

    public void setUserId(long r1) {
        this.mCrashListener.setUserId(r1);
    }
}
