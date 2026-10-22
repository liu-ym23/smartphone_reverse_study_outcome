package com.bytedance.apm6.hub.config.internal;

import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static /* synthetic */ JSONObject access$000(ConfigManager r0) {
        return r0.mConfigData;
    }

    static /* synthetic */ void access$100(ConfigManager r0) {
        r0.initConfig();
    }

    static /* synthetic */ AsyncTask access$200(ConfigManager r0) {
        return r0.asyncTask;
    }

    static /* synthetic */ AsyncTask access$300(ConfigManager r0) {
        return r0.interceptorAsyncTask;
    }

    static /* synthetic */ AsyncTask access$302(ConfigManager r0, AsyncTask r1) {
        r0.interceptorAsyncTask = r1;
        return r1;
    }

    static /* synthetic */ void access$400(ConfigManager r0, JSONObject r1, boolean r2) {
        r0.updateCurrentConfig(r1, r2);
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
        this.configManager = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");
    L5:
        IConfigManager r0 = this.configManager;
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r0.queryConfig();
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.d(ConfigConstants.LOG_TAG, "initConfig:" + r1);
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        updateCurrentConfig(new JSONObject(r1), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    private void notifyListenerRefresh(JSONObject r4, boolean r5) {
        this.mReady = true;
        List<IConfigChangeListener> r3 = this.mConfigListeners;
        if (r3 == null) goto L10;
        Iterator<IConfigChangeListener> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        ((IConfigChangeListener) ZeusTransformUtils.preCheckCast(r6.next(), IConfigChangeListener.class, "com.obric.memorydata.plugin")).onConfigChanged(r4, r5);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    private void updateCurrentConfig(JSONObject r2, boolean r3) {
        if (JsonUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mConfigData = r2;
        this.mConfigFromLocal = r3;
        notifyListenerRefresh(r2, r3);
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
        final long r3 = 500;
        final long r5 = 1000;
        this.asyncTask = new AnonymousClass1(this, r3, r5);     // Catch: Throwable -> L14
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);     // Catch: Throwable -> L14
    L11:
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.configManager = r0;     // Catch: Throwable -> L14
        r0.registerConfigListener(new AnonymousClass2(this));     // Catch: Throwable -> L14
        monitor-exit(this);
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
        r4.onConfigChanged(this.mConfigData, this.mConfigFromLocal);
        return;
    }

    public void removeConfigListener(IConfigChangeListener r3) {
        IConfigChangeListener r4 = (IConfigChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IConfigChangeListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<IConfigChangeListener> r2 = this.mConfigListeners;
        if (r2 == null) goto L9;
        r2.remove(r4);
        return;
    }
}
