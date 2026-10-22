package com.bytedance.crash.config;

import c4.d;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;
import u4.a;

/* JADX INFO: loaded from: classes.dex */
public class InnerConfigManager extends ConfigManager implements a {
    private static final int MAX_RETRY_COUNT = 30;
    private static final int RETRY_INTERVAL = 2000;
    private volatile boolean isReady;
    private final Runnable mFetchConfigRunnable;
    private IConfigManager mIConfigManager;
    private volatile int mTryCount;

    public InnerConfigManager(EventMonitor r10) {
        super(r10);
        this.isReady = false;
        this.mFetchConfigRunnable = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(InnerConfigManager r10) {
        r10.tryGetConfigFromApm();
    }

    private void tryGetConfigFromApm() {
        NpthLog.i("tryGetConfigFromApm isReady:" + this.isReady);
        if (this.isReady == false) goto L5;
        return;
    L5:
        NpthLog.i("tryGetConfigFromApm mTryCount:" + this.mTryCount);
        if (this.mTryCount < 30) goto L9;
        DefaultWorkThread.removeCallbacks(this.mFetchConfigRunnable);
        super.initConfig();
    L14:
        this.mTryCount++;
        return;
    L9:
        if (this.mIConfigManager != null) goto L13;
        IConfigManager r10 = (IConfigManager) d.a(IConfigManager.class);
        this.mIConfigManager = r10;
        if (r10 == null) goto L13;
        r10.registerConfigListener(this);
    L13:
        DefaultWorkThread.removeCallbacks(this.mFetchConfigRunnable);
        DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000);
        goto L14
    }

    @Override // com.bytedance.crash.config.ConfigManager
    protected void initConfig() {
        if (App.isMainProcess() == true) goto L14;
        super.initConfig();
        return;
    L14:
        IConfigManager r10 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Throwable -> L11
        this.mIConfigManager = r10;     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        r10.registerConfigListener(this);     // Catch: Throwable -> L11
    L9:
        DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        super.initConfig();
        NpthLog.e(th);
    }

    @Override // u4.a
    public void onReady() {
    }

    @Override // u4.a
    public void onRefresh(final JSONObject r10, boolean r11) {
        this.isReady = true;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass2(this, r10));
    }
}
