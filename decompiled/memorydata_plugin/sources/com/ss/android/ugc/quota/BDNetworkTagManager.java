package com.ss.android.ugc.quota;

import android.app.Application;
import android.util.Log;
import android.util.Pair;
import com.bytedance.retrofit2.PriorityLevel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class BDNetworkTagManager {
    private static final Pair<String, String> DEFAULT_TAG = null;
    public static final String KEY_BD_NETWORK_REQUEST_TAG = "x-tt-request-tag";
    private static final String TAG = "BDNetworkTagManager";
    private static volatile BDNetworkTagManager sInstance;
    private e<Application> contextLazy;
    private e<d> dependLazy;
    private AtomicBoolean enable;
    private boolean firstInstallLaunch;
    private e<com.ss.android.ugc.quota.a.b> launchMonitorLazy;
    private int launchType;

    static {
        DEFAULT_TAG = new Pair(KEY_BD_NETWORK_REQUEST_TAG, "");
    }

    private BDNetworkTagManager() {
        this.contextLazy = new AnonymousClass1(this);
        this.dependLazy = new AnonymousClass2(this);
        this.launchMonitorLazy = new AnonymousClass3(this);
        this.enable = new AtomicBoolean(false);
        this.launchType = PriorityLevel.INVALID;
    }

    static /* synthetic */ AtomicBoolean access$000(BDNetworkTagManager r0) {
        return r0.enable;
    }

    static /* synthetic */ boolean access$102(BDNetworkTagManager r0, boolean r1) {
        r0.firstInstallLaunch = r1;
        return r1;
    }

    static /* synthetic */ e access$200(BDNetworkTagManager r0) {
        return r0.dependLazy;
    }

    static /* synthetic */ e access$300(BDNetworkTagManager r0) {
        return r0.contextLazy;
    }

    private boolean enabled() {
        if (this.dependLazy.c() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.enable.get() == false) goto L7;
        return true;
    }

    public static BDNetworkTagManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDNetworkTagManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDNetworkTagManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDNetworkTagManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Pair<String, String> buildBDNetworkTag(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (enabled() == false) goto L5;
        if (r5 == null) goto L8;
        int r0 = ((com.ss.android.ugc.quota.a.b) ZeusTransformUtils.preCheckCast(this.launchMonitorLazy.c(), com.ss.android.ugc.quota.a.b.class, "com.obric.memorydata.plugin")).a();
        if (this.launchType == r0) goto L13;
        updateLaunchType(r0);
    L13:
        return new Pair(KEY_BD_NETWORK_REQUEST_TAG, "t=" + r5.triggerType() + ";n=" + (r5.markAsNewUser() ? 1 : 0));
    L8:
        return DEFAULT_TAG;
    L5:
        return DEFAULT_TAG;
    }

    public int currentLaunchType() {
        if (enabled() == true) goto L7;
        return PriorityLevel.INVALID;
    L7:
        return this.launchType;
    }

    public void enable(boolean r1) {
        this.enable.set(r1);
    }

    public void init(Application r3, d r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (this.dependLazy.d() == false) goto L6;
        Log.d(TAG, "Already inited");
        return;
    L6:
        if (r5 == null) goto L14;
        if (r6 == null) goto L14;
        this.contextLazy.a(r5);
        this.enable.set(r6.a());
        com.ss.android.ugc.quota.a.b r7 = r6.c();
        if (r7 == null) goto L11;
        this.launchMonitorLazy.a(r7);
    L11:
        this.firstInstallLaunch = r6.b();
        this.dependLazy.a(r6);
        return;
    L14:
        throw new IllegalArgumentException("Context or depend is NULL");
    }

    public boolean isFirstInstallLaunch() {
        if (enabled() == true) goto L7;
        return false;
    L7:
        return this.firstInstallLaunch;
    }

    public void updateLaunchType(int r3) {
        if (enabled() == true) goto L5;
        return;
    L5:
        this.launchType = r3;
        if (this.dependLazy.c() == null) goto L9;
        ((d) ZeusTransformUtils.preCheckCast(this.dependLazy.c(), d.class, "com.obric.memorydata.plugin")).a(r3);
        return;
    }
}
