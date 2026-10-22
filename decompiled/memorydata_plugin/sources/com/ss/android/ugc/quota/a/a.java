package com.ss.android.ugc.quota.a;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.bytedance.retrofit2.PriorityLevel;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15760b;
    private boolean c;
    private int d;

    public a(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        this.f15759a = 0;
        this.f15760b = false;
        this.c = true;
        this.d = PriorityLevel.INVALID;
        if (r4 != null) goto L5;
        return;
    L5:
        r4.registerActivityLifecycleCallbacks(new AnonymousClass1(this));
    }

    private void a(int r3) {
        if (this.d != r3) goto L5;
        return;
    L5:
        Log.d("BDNetworkLaunchMonitor", "Current launch type is " + r3);
        this.d = r3;
        BDNetworkTagManager.getInstance().updateLaunchType(r3);
    }

    static /* synthetic */ void a(a r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(a r2, String r3, Activity r4) {
        r2.a(r3, (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin"));
    }

    private void a(String r3, Activity r4) {
        Log.d("BDNetworkLaunchMonitor", r3 + ", Activity:" + ((Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin")) + ",fgActivityCount: " + this.f15759a + ",appInBackground: " + this.f15760b);
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.c;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.c = r1;
        return r1;
    }

    static /* synthetic */ int b(a r2) {
        int r0 = r2.f15759a;
        r2.f15759a = r0 + 1;
        return r0;
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        r0.f15760b = r1;
        return r1;
    }

    static /* synthetic */ int c(a r0) {
        return r0.f15759a;
    }

    static /* synthetic */ boolean d(a r0) {
        return r0.f15760b;
    }

    static /* synthetic */ int e(a r2) {
        int r0 = r2.f15759a;
        r2.f15759a = r0 - 1;
        return r0;
    }

    @Override // com.ss.android.ugc.quota.a.b
    public int a() {
        return this.d;
    }
}
