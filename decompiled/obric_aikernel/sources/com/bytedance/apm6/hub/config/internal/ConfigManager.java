package com.bytedance.apm6.hub.config.internal;

import android.text.TextUtils;
import c4.d;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager {
    private static volatile ConfigManager sInstance;
    private AsyncTask asyncTask;
    private IConfigManager configManager;
    private volatile boolean inited;
    private AsyncTask interceptorAsyncTask;
    private volatile JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigChangeListener> mConfigListeners;
    private volatile boolean mReady;

    private ConfigManager() {
        this.inited = false;
    }

    static /* synthetic */ JSONObject access$000(ConfigManager r10) {
        return r10.mConfigData;
    }

    static /* synthetic */ void access$100(ConfigManager r10) {
        r10.initConfig();
    }

    static /* synthetic */ AsyncTask access$200(ConfigManager r10) {
        return r10.asyncTask;
    }

    static /* synthetic */ AsyncTask access$300(ConfigManager r10) {
        return r10.interceptorAsyncTask;
    }

    static /* synthetic */ AsyncTask access$302(ConfigManager r10, AsyncTask r11) {
        r10.interceptorAsyncTask = r11;
        return r11;
    }

    static /* synthetic */ void access$400(ConfigManager r10, JSONObject r11, boolean r12) {
        r10.updateCurrentConfig(r11, r12);
    }

    public static ConfigManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(ConfigManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ConfigManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ConfigManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initConfig() {
        if (this.configManager != null) goto L5;
        this.configManager = (IConfigManager) d.a(IConfigManager.class);
    L5:
        IConfigManager r10 = this.configManager;
        if (r10 != null) goto L8;
        return;
    L8:
        String r11 = r10.queryConfig();
        if (ApmBaseContext.isDebugMode() == false) goto L16;
        Logger.d(ConfigConstants.LOG_TAG, "initConfig:" + r11);
    L16:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        updateCurrentConfig(new JSONObject(r11), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    private void notifyListenerRefresh(JSONObject r10, boolean r11) {
        this.mReady = true;
        List<IConfigChangeListener> r12 = this.mConfigListeners;
        if (r12 == null) goto L10;
        Iterator<IConfigChangeListener> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L17;
        r13.next().onConfigChanged(r10, r11);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    private void updateCurrentConfig(JSONObject r10, boolean r11) {
        if (JsonUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        this.mConfigData = r10;
        this.mConfigFromLocal = r11;
        notifyListenerRefresh(r10, r11);
    }

    public synchronized void init() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.inited = true;     // Catch: Throwable -> L14
        if (ApmContext.isMainProcess() == false) goto L11;
        final long r10 = 500;
        final long r11 = 1000;
        this.asyncTask = new AnonymousClass1(this, r10, r11);     // Catch: Throwable -> L14
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);     // Catch: Throwable -> L14
    L11:
        IConfigManager r12 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Throwable -> L14
        this.configManager = r12;     // Catch: Throwable -> L14
        r12.registerConfigListener(new AnonymousClass2(this));     // Catch: Throwable -> L14
        monitor-exit(this);
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
        r10.onConfigChanged(this.mConfigData, this.mConfigFromLocal);
        return;
    }

    public void removeConfigListener(IConfigChangeListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List<IConfigChangeListener> r11 = this.mConfigListeners;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }
}
