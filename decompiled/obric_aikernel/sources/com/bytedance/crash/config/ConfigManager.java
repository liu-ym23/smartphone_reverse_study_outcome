package com.bytedance.crash.config;

import android.os.FileObserver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager implements Runnable {
    public static final String CONFIG_SUFFIX = ".config";
    private static final long FETCH_SETTING_INTERVAL_SECONDS = 1200;
    private static final long MIN_FETCH_SETTING_INTERVAL_SECONDS = 600;
    private static final String MONITOR_CONFIG_REFRESH_TIME = "monitor_configure_refresh_time";
    private static final String SETTING_GENERAL = "general";
    private static final String SETTING_GENERAL_API = "slardar_api_settings";
    private static final String SETTING_GENERAL_API_FETCH = "fetch_setting";
    private static final String SETTING_GENERAL_API_FETCH_INTERVAL = "fetch_setting_interval";
    private static final String TAG = "ConfigManager";
    private static final ConcurrentHashMap<EventMonitor, ConfigManager> mManagers = null;
    private File configFile;
    private volatile boolean inited;
    private JSONObject mConfigData;
    private List<IConfigChangeListener> mConfigListeners;
    private long mConfigNetFetchSuccessTs;
    private long mConfigNetRefreshFailedIntervalSeconds;
    private long mFetchSettingIntervalSeconds;
    private final EventMonitor mMonitor;
    private boolean mReady;
    private ConfigFileObserver observer;

    private class ConfigFileObserver extends FileObserver {
        private final File configFile;
        final /* synthetic */ ConfigManager this$0;

        public ConfigFileObserver(ConfigManager r10, File r11) {
            this.this$0 = r10;
            super(r11.getAbsolutePath(), 264);
            this.configFile = r11;
        }

        @Override // android.os.FileObserver
        public void onEvent(int r10, String r11) {
            if ((r10 & 8) == 0) goto L6;
            this.this$0.updateFromLocal();
            return;
        }

        public void start() {
            if (this.configFile.exists() == false) goto L9;
        L7:
            startWatching();
            return;
        L9:
            this.configFile.createNewFile();     // Catch: IOException -> L6
        }
    }

    static {
        mManagers = new ConcurrentHashMap();
    }

    public ConfigManager(@NonNull EventMonitor r10) {
        this.mFetchSettingIntervalSeconds = FETCH_SETTING_INTERVAL_SECONDS;
        this.inited = false;
        this.mConfigNetFetchSuccessTs = -1;
        this.mConfigNetRefreshFailedIntervalSeconds = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        this.mMonitor = r10;
        this.mConfigListeners = new CopyOnWriteArrayList();
        mManagers.put(r10, this);
    }

    static /* synthetic */ boolean access$000(ConfigManager r10) {
        return r10.queryFromNet();
    }

    private File getConfigFile() {
        File r10 = this.configFile;
        if (r10 == null) goto L5;
        return r10;
    L5:
        File r11 = new File(Global.getRootDirectory(), "configs");
        if (r11.exists() == true) goto L8;
        FileSystemUtils.createDirectory(r11);
    L8:
        File r12 = new File(r11, this.mMonitor.getAppId() + CONFIG_SUFFIX);
        this.configFile = r12;
        return r12;
    }

    private void notifyListenerRefresh(JSONObject r10, boolean r11) {
        this.mReady = true;
        List<IConfigChangeListener> r12 = this.mConfigListeners;
        if (r12 == null) goto L12;
        Iterator<IConfigChangeListener> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L19;
        r13.next().onConfigChanged(r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        NpthLog.e(TAG, "notifyListenerRefresh", th);
        goto L6
    L19:
        return;
    }

    private String queryFromLocal() {
        File r10 = getConfigFile();
        return FileUtils.readFile(r10);
    L5:
        if (r10 == null) goto L11;
        r10.delete();
        return null;
    L11:
        return null;
    }

    private boolean queryFromNet() {
        String r10 = UploaderUrl.appendUrlParamsByMonitor(NetConfig.getApmConfigUrl(), this.mMonitor);     // Catch: Throwable -> L16
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        NpthLog.i(TAG, "queryFromNet:" + r10);     // Catch: Throwable -> L16
    L6:
        byte[] r11 = CrashUploader.doGet(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L9;
    L15:
        return false;
    L9:
        if (r11.length <= 0) goto L15;
        JSONObject r12 = new JSONObject(new String(r11)).optJSONObject("ret");     // Catch: Throwable -> L16
        if (r12 == null) goto L18;
        return saveConfig(r12);
    L18:
        return false;
    L16:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L18
    }

    private void updateCurrentConfig(JSONObject r10) {
        if (JSONUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mConfigData = r10;
        JSONObject r11 = JSONUtils.optJSONObject(r10, "general", "slardar_api_settings");
        if (r11 == null) goto L17;
        JSONObject r12 = r11.optJSONObject(SETTING_GENERAL_API_FETCH);
        if (r12 == null) goto L11;
        this.mFetchSettingIntervalSeconds = r12.optLong(SETTING_GENERAL_API_FETCH_INTERVAL, FETCH_SETTING_INTERVAL_SECONDS);
    L11:
        if (this.mFetchSettingIntervalSeconds >= MIN_FETCH_SETTING_INTERVAL_SECONDS) goto L14;
        this.mFetchSettingIntervalSeconds = MIN_FETCH_SETTING_INTERVAL_SECONDS;
    L14:
        if (RuntimeConfig.isLocalDebug() == false) goto L18;
        NpthLog.i(TAG, "updateCurrentConfig:" + this.mFetchSettingIntervalSeconds);
        return;
    L18:
        return;
    }

    public synchronized void init() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.inited = true;     // Catch: Throwable -> L11
        NpthLog.i(TAG, "init：" + this.mMonitor.getAppId());     // Catch: Throwable -> L11
        DefaultWorkThread.post(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    protected void initConfig() {
        updateFromLocal();
        if (App.isMainProcess() == false) goto L14;
        long r10 = System.currentTimeMillis() - this.mConfigNetFetchSuccessTs;
        long r11 = this.mFetchSettingIntervalSeconds * 1000;
        if (r10 <= r11) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == false) goto L13;
        queryConfigFromRemote();
        return;
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), r11 - r10);
        return;
    L7:
        if (r10 < 0) goto L10;
        r12 = false;
        goto L11
    L14:
        ConfigFileObserver r13 = new ConfigFileObserver(this, getConfigFile());
        this.observer = r13;
        r13.start();
    }

    protected void queryConfigFromRemote() {
        if (Net.isNetworkAvailable() == true) goto L7;
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), 300000);
        return;
    L7:
        if (queryFromNet() == false) goto L9;
        long r10 = this.mFetchSettingIntervalSeconds;
    L11:
        if (RuntimeConfig.isLocalDebug() == false) goto L13;
        NpthLog.i(TAG, "queryConfigFromRemote:" + r10);
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass3(this), r10 * 1000);
        return;
    L9:
        r10 = Math.min(this.mConfigNetRefreshFailedIntervalSeconds * 2, MIN_FETCH_SETTING_INTERVAL_SECONDS);
        this.mConfigNetRefreshFailedIntervalSeconds = r10;
        goto L11
    }

    public void registerConfigListener(IConfigChangeListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mConfigListeners != null) goto L8;
        this.mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (this.mConfigListeners.contains(r10) == true) goto L11;
        this.mConfigListeners.add(r10);
    L11:
        if (this.mReady == false) goto L14;
        r10.onConfigChanged(this.mConfigData);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.mMonitor.getAppId()) == false) goto L5;
    L9:
        NpthLog.i(TAG, "app id isEmpty：");
        if ((this.mMonitor instanceof AppMonitor) == false) goto L12;
        long r10 = 200;
    L13:
        DefaultWorkThread.postDelayed(this, r10);
        return;
    L12:
        r10 = 500;
        goto L13
    L5:
        if (TextUtils.isEmpty(this.mMonitor.getDeviceId("")) == true) goto L9;
        DefaultWorkThread.removeCallbacks(this);
        initConfig();
    }

    protected boolean saveConfig(JSONObject r10) {
    L9:
        e = move-exception;
        NpthLog.e(TAG, "saveConfig", e);
        return false;
    L4:
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        NpthLog.i(TAG, "saveConfig :" + r10);     // Catch: Exception -> L9
    L6:
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L9
        this.mConfigNetFetchSuccessTs = r11;     // Catch: Exception -> L9
        r10.put(MONITOR_CONFIG_REFRESH_TIME, r11);     // Catch: Exception -> L9
        FileUtils.writeFile(getConfigFile(), r10, false);     // Catch: Exception -> L9
        updateCurrentConfig(r10);     // Catch: Exception -> L9
        notifyListenerRefresh(r10, false);     // Catch: Exception -> L9
        return true;
    }

    protected void updateFromLocal() {
        String r10 = queryFromLocal();
        if (TextUtils.isEmpty(r10) == true) goto L14;
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L9
        this.mConfigNetFetchSuccessTs = r11.optLong(MONITOR_CONFIG_REFRESH_TIME);     // Catch: Exception -> L9
        if (RuntimeConfig.isLocalDebug() == false) goto L7;
        NpthLog.i(TAG, "updateFromLocal:" + this.mMonitor.getAppId() + " " + this.mConfigNetFetchSuccessTs);     // Catch: Exception -> L9
    L7:
        updateCurrentConfig(r11);     // Catch: Exception -> L9
        notifyListenerRefresh(r11, true);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        NpthLog.e(TAG, "updateFromLocal", e);
        return;
    }
}
