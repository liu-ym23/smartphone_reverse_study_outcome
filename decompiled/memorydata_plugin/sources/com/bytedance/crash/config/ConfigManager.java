package com.bytedance.crash.config;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.Net;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

        public ConfigFileObserver(ConfigManager r2, File r3) {
            this.this$0 = r2;
            super(r3.getAbsolutePath(), 264);
            this.configFile = r3;
        }

        @Override // android.os.FileObserver
        public void onEvent(int r1, String r2) {
            if ((r1 & 8) == 0) goto L6;
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

    public ConfigManager(EventMonitor r3) {
        this.mFetchSettingIntervalSeconds = FETCH_SETTING_INTERVAL_SECONDS;
        this.inited = false;
        this.mConfigNetFetchSuccessTs = -1;
        this.mConfigNetRefreshFailedIntervalSeconds = 60000;
        this.mMonitor = r3;
        this.mConfigListeners = new CopyOnWriteArrayList();
        mManagers.put(r3, this);
    }

    static /* synthetic */ boolean access$000(ConfigManager r0) {
        return r0.queryFromNet();
    }

    private File getConfigFile() {
        File r0 = this.configFile;
        if (r0 == null) goto L5;
        return r0;
    L5:
        File r1 = new File(Global.getRootDirectory(), "configs");
        if (r1.exists() == true) goto L8;
        FileSystemUtils.createDirectory(r1);
    L8:
        File r2 = new File(r1, this.mMonitor.getAppId() + CONFIG_SUFFIX);
        this.configFile = r2;
        return r2;
    }

    private void notifyListenerRefresh(JSONObject r3, boolean r4) {
        this.mReady = true;
        List<IConfigChangeListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L12;
        Iterator<IConfigChangeListener> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L19;
        ((IConfigChangeListener) ZeusTransformUtils.preCheckCast(r5.next(), IConfigChangeListener.class, "com.obric.memorydata.plugin")).onConfigChanged(r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        NpthLog.e(TAG, "notifyListenerRefresh", th);
        goto L6
    L19:
        return;
    }

    private String queryFromLocal() {
        File r0 = getConfigFile();
        return FileUtils.readFile(r0);
    L5:
        if (r0 == null) goto L11;
        r0.delete();
        return null;
    L11:
        return null;
    }

    private boolean queryFromNet() {
        String r1 = UploaderUrl.appendUrlParamsByMonitor(NetConfig.getApmConfigUrl(), this.mMonitor);     // Catch: Throwable -> L16
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        NpthLog.i(TAG, "queryFromNet:" + r1);     // Catch: Throwable -> L16
    L6:
        byte[] r2 = CrashUploader.doGet(r1);     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
    L15:
        return false;
    L9:
        if (r2.length <= 0) goto L15;
        JSONObject r3 = new JSONObject(new String(r2)).optJSONObject("ret");     // Catch: Throwable -> L16
        if (r3 == null) goto L18;
        return saveConfig(r3);
    L18:
        return false;
    L16:
        th = move-exception;
        NpthMonitor.reportInnerException(th);
        goto L18
    }

    private void updateCurrentConfig(JSONObject r5) {
        if (JSONUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        this.mConfigData = r5;
        JSONObject r6 = JSONUtils.optJSONObject(r5, "general", "slardar_api_settings");
        if (r6 == null) goto L17;
        JSONObject r7 = r6.optJSONObject(SETTING_GENERAL_API_FETCH);
        if (r7 == null) goto L11;
        this.mFetchSettingIntervalSeconds = r7.optLong(SETTING_GENERAL_API_FETCH_INTERVAL, FETCH_SETTING_INTERVAL_SECONDS);
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

    public void initConfig() {
        updateFromLocal();
        if (App.isMainProcess() == false) goto L14;
        long r0 = System.currentTimeMillis() - this.mConfigNetFetchSuccessTs;
        long r2 = this.mFetchSettingIntervalSeconds * 1000;
        if (r0 <= r2) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        queryConfigFromRemote();
        return;
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), r2 - r0);
        return;
    L7:
        if (r0 < 0) goto L10;
        r4 = false;
        goto L11
    L14:
        ConfigFileObserver r1 = new ConfigFileObserver(this, getConfigFile());
        this.observer = r1;
        r1.start();
    }

    public void queryConfigFromRemote() {
        if (Net.isNetworkAvailable() == true) goto L7;
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), 300000);
        return;
    L7:
        if (queryFromNet() == false) goto L9;
        long r0 = this.mFetchSettingIntervalSeconds;
    L11:
        if (RuntimeConfig.isLocalDebug() == false) goto L13;
        NpthLog.i(TAG, "queryConfigFromRemote:" + r0);
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass3(this), r0 * 1000);
        return;
    L9:
        r0 = Math.min(this.mConfigNetRefreshFailedIntervalSeconds * 2, MIN_FETCH_SETTING_INTERVAL_SECONDS);
        this.mConfigNetRefreshFailedIntervalSeconds = r0;
        goto L11
    }

    public void registerConfigListener(IConfigChangeListener r3) {
        IConfigChangeListener r4 = (IConfigChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IConfigChangeListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.mConfigListeners != null) goto L9;
        this.mConfigListeners = new CopyOnWriteArrayList();
    L9:
        if (this.mConfigListeners.contains(r4) == true) goto L12;
        this.mConfigListeners.add(r4);
    L12:
        if (this.mReady == false) goto L15;
        r4.onConfigChanged(this.mConfigData);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.mMonitor.getAppId()) == false) goto L5;
    L9:
        NpthLog.i(TAG, "app id isEmpty：");
        if (ZeusTransformUtils.instanceOf(this.mMonitor, AppMonitor.class) == false) goto L12;
        long r0 = 200;
    L13:
        DefaultWorkThread.postDelayed(this, r0);
        return;
    L12:
        r0 = 500;
        goto L13
    L5:
        if (TextUtils.isEmpty(this.mMonitor.getDeviceId("")) == true) goto L9;
        DefaultWorkThread.removeCallbacks(this);
        initConfig();
    }

    public boolean saveConfig(JSONObject r6) {
    L9:
        e = move-exception;
        NpthLog.e(TAG, "saveConfig", e);
        return false;
    L4:
        if (RuntimeConfig.isLocalDebug() == false) goto L6;
        NpthLog.i(TAG, "saveConfig :" + r6);     // Catch: Exception -> L9
    L6:
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L9
        this.mConfigNetFetchSuccessTs = r2;     // Catch: Exception -> L9
        r6.put(MONITOR_CONFIG_REFRESH_TIME, r2);     // Catch: Exception -> L9
        FileUtils.writeFile(getConfigFile(), r6, false);     // Catch: Exception -> L9
        updateCurrentConfig(r6);     // Catch: Exception -> L9
        notifyListenerRefresh(r6, false);     // Catch: Exception -> L9
        return true;
    }

    public void updateFromLocal() {
        String r1 = queryFromLocal();
        if (TextUtils.isEmpty(r1) == true) goto L14;
        JSONObject r2 = new JSONObject(r1);     // Catch: Exception -> L9
        this.mConfigNetFetchSuccessTs = r2.optLong(MONITOR_CONFIG_REFRESH_TIME);     // Catch: Exception -> L9
        if (RuntimeConfig.isLocalDebug() == false) goto L7;
        NpthLog.i(TAG, "updateFromLocal:" + this.mMonitor.getAppId() + " " + this.mConfigNetFetchSuccessTs);     // Catch: Exception -> L9
    L7:
        updateCurrentConfig(r2);     // Catch: Exception -> L9
        notifyListenerRefresh(r2, true);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        NpthLog.e(TAG, "updateFromLocal", e);
        return;
    }
}
