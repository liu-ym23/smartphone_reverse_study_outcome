package com.bytedance.apm6.consumer.slardar.weedout;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class WeedOutManager {
    private static final int MINIMUM_OF_MB_TODAY = 80;
    private static final long WEED_OUT_INTERVAL = 14400000;
    private static volatile WeedOutManager instance;
    private int keepDays;
    private WeedOutListener listener;
    private int maxSizeMB;
    private int maxSizeMBToday;
    private Set<WeedOutStrategy> strategies;

    static {
        instance = new WeedOutManager();
    }

    public WeedOutManager() {
        this.strategies = new HashSet();
        this.maxSizeMB = 80;
        this.keepDays = 5;
        this.maxSizeMBToday = -1;
    }

    static /* synthetic */ int access$000(WeedOutManager r10) {
        return r10.keepDays;
    }

    static /* synthetic */ int access$100(WeedOutManager r10) {
        return r10.maxSizeMB;
    }

    static /* synthetic */ Set access$200(WeedOutManager r10) {
        return r10.strategies;
    }

    static /* synthetic */ int access$300(WeedOutManager r10) {
        return r10.maxSizeMBToday;
    }

    static /* synthetic */ WeedOutListener access$400(WeedOutManager r10) {
        return r10.listener;
    }

    public static WeedOutManager getInstance() {
        return instance;
    }

    public synchronized void addStrategy(WeedOutStrategy r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.strategies.add(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void init() {
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        AsyncTaskManager r10 = AsyncTaskManager.getInstance(AsyncTaskManagerType.IO);
        final long r11 = 0;
        final long r12 = WEED_OUT_INTERVAL;
        r10.sendTask(new AnonymousClass1(this, r11, r12));
    }

    public synchronized void register(WeedOutListener r10) {
        monitor-enter(this);
        this.listener = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setWeedOutConfig(int r10, int r11, int r12) {
        if (r10 <= 0) goto L12;
        if (r11 <= 0) goto L14;
        this.maxSizeMB = r10;
        this.keepDays = r11;
        int r13 = -1;
        if (r12 == (-1)) goto L8;
        r13 = Math.max(r12, 80);
    L8:
        this.maxSizeMBToday = r13;
        if (ApmBaseContext.isDebugMode() == false) goto L13;
        Logger.d(Constants.TAG, "weed out config:maxSizeMB:" + r10 + " keepDays:" + r11);
        return;
    L13:
        return;
    L14:
        return;
    }
}
