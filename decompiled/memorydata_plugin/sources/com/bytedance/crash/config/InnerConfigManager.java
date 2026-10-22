package com.bytedance.crash.config;

import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class InnerConfigManager extends ConfigManager implements a {
    private static final int MAX_RETRY_COUNT = 30;
    private static final int RETRY_INTERVAL = 2000;
    private volatile boolean isReady;
    private final Runnable mFetchConfigRunnable;
    private IConfigManager mIConfigManager;
    private volatile int mTryCount;

    public InnerConfigManager(EventMonitor r1) {
        super(r1);
        this.isReady = false;
        this.mFetchConfigRunnable = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(InnerConfigManager r0) {
        r0.tryGetConfigFromApm();
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
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");
        this.mIConfigManager = r0;
        if (r0 == null) goto L13;
        r0.registerConfigListener(this);
    L13:
        DefaultWorkThread.removeCallbacks(this.mFetchConfigRunnable);
        DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000);
        goto L14
    }

    @Override // com.bytedance.crash.config.ConfigManager
    public void initConfig() {
        if (App.isMainProcess() == true) goto L14;
        super.initConfig();
        return;
    L14:
        IConfigManager r0 = (IConfigManager) ZeusTransformUtils.preCheckCast(d.a(IConfigManager.class), IConfigManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.mIConfigManager = r0;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.registerConfigListener(this);     // Catch: Throwable -> L11
    L9:
        DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        super.initConfig();
        NpthLog.e(th);
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(final JSONObject r1, boolean r2) {
        this.isReady = true;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new AnonymousClass2(this, r1));
    }
}
