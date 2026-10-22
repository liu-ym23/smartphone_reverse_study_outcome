package com.bytedance.crash;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.crash.monitor.CrashListener;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.monitor.SdkMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MonitorCrash {

    @Deprecated
    private final Config mConfig;
    private final CrashListener mCrashListener;

    @Deprecated
    public class Config {
        private final MonitorCrash mMonitorCrash;
        final /* synthetic */ MonitorCrash this$0;

        Config(MonitorCrash r10, MonitorCrash r11) {
            this.this$0 = r10;
            this.mMonitorCrash = r11;
        }

        public Config setChannel(String r10) {
            this.mMonitorCrash.setChannel(r10);
            return this;
        }

        public Config setDeviceId(String r10) {
            this.mMonitorCrash.setDeviceId(r10);
            return this;
        }

        public Config setPackageName(String r10) {
            this.mMonitorCrash.setPackageName(r10);
            return this;
        }

        public Config setSoList(String[] r10) {
            this.mMonitorCrash.setSoList(r10);
            return this;
        }

        public Config setUID(long r10) {
            this.mMonitorCrash.setUserId(r10);
            return this;
        }
    }

    private MonitorCrash(@NonNull CrashListener r10) {
        this.mCrashListener = r10;
        this.mConfig = new Config(this, this);
    }

    @Deprecated
    public static MonitorCrash init(@NonNull Context r10, @NonNull String r11, long r12, @NonNull String r13) {
        return initApp(r10, r11, r12, r13);
    }

    public static MonitorCrash initApp(@NonNull Context r10, @NonNull String r11, long r12, @NonNull String r13) {
        return new MonitorCrash(MonitorManager.createAppMonitor(r10, r11, r13, r12));
    }

    @NonNull
    public static MonitorCrash initSDK(Context r10, String r11, long r12, String r13, String r14) {
        return initSDK(r10, r11, r12, r13, r14, null);
    }

    @NonNull
    public static MonitorCrash initSDK(@NonNull Context r10, @NonNull String r11, long r12, @NonNull String r13, String r14, String[] r15) {
        return new MonitorCrash(MonitorManager.createSdkMonitor(r10, r11, r13, r12, new String[]{r14}, r15));
    }

    @NonNull
    @Deprecated
    public Config config() {
        return this.mConfig;
    }

    @NonNull
    public UserDataCenter getUserDataCenter() {
        return this.mCrashListener.getUserDataCenter();
    }

    @Deprecated
    public void reportCustomErr(String r10, String r11, Throwable r12) {
        this.mCrashListener.reportEnsure(r10, r12);
    }

    public void reportCustomErr(String r10, Throwable r11) {
        this.mCrashListener.reportEnsure(r10, r11);
    }

    public void reportEvent(String r10, int r11, JSONObject r12, JSONObject r13) {
        this.mCrashListener.reportEvent(r10, r11, r12, r13);
    }

    public void setChannel(@NonNull String r10) {
        this.mCrashListener.setChannel(r10);
    }

    public void setDeviceId(@NonNull String r10) {
        this.mCrashListener.setDeviceId(r10);
    }

    public void setPackageName(String r10) {
        CrashListener r11 = this.mCrashListener;
        if ((r11 instanceof SdkMonitor) == false) goto L6;
        ((SdkMonitor) r11).setPackageName(new String[]{r10});
        return;
    }

    public void setSoList(String[] r10) {
        CrashListener r11 = this.mCrashListener;
        if ((r11 instanceof SdkMonitor) == false) goto L6;
        ((SdkMonitor) r11).setSoList(r10);
        return;
    }

    public void setUserId(@NonNull long r10) {
        this.mCrashListener.setUserId(r10);
    }
}
