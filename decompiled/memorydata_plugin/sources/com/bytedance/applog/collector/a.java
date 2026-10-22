package com.bytedance.applog.collector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.log.j;
import com.bytedance.applog.n.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f1552b;
    private long c;
    private String d;
    private final HashSet<Integer> e;
    private final com.bytedance.applog.b f;
    private boolean g;
    private boolean h;
    private volatile boolean i;
    private volatile b j;

    public a(com.bytedance.applog.b r4) {
        this.f1551a = 0;
        this.e = new HashSet(8);
        this.g = true;
        this.h = false;
        this.i = false;
        this.f = r4;
    }

    public i a() {
        return this.f1552b;
    }

    public i a(i r4, long r5) {
        i r0 = (i) ZeusTransformUtils.preCheckCast(r4.n(), i.class, "com.obric.memorydata.plugin");
        r0.a(r5);
        long r6 = r5 - r4.f1725b;
        if (r6 > 0) goto L5;
        r6 = 1000;
    L5:
        r0.v = r6;
        b r7 = this.j;
        if (r7 != null) goto L15;
    L13:
        this.f.a(r0);
        return r0;
    L15:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L11
        r7.b(r0.x, r8);     // Catch: Throwable -> L11
        if (r8.length() <= 0) goto L13;
        r0.A = r8.toString();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f.aA().a("Navigator callback onPause:{} failed", th, new Object[]{r0.x});
        goto L13
    }

    public i a(String r3, String r4, long r5, String r7) {
        i r0 = new i();
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r3 = r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4;
    L5:
        r0.x = r3;
        r0.a(r5);
        r0.v = -1;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r0.w = r7;
        b r6 = this.j;
        if (r6 != null) goto L19;
    L17:
        this.f.a(r0);
        return r0;
    L19:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L15
        r6.a(r0.x, r8);     // Catch: Throwable -> L15
        if (r8.length() <= 0) goto L17;
        r0.A = r8.toString();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.f.aA().a("Navigator callback onResume:{} failed", th, new Object[]{r0.x});
        goto L17
    }

    public void a(b r3) {
        this.j = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String r11, int r12) {
        this.f.aX().b(r11 + "___" + r12);
        long r0 = System.currentTimeMillis();
        this.f.aA().c("onActivityResumed: {}", new Object[]{r11});
        if (this.f1552b == null) goto L5;
    L7:
        Object[] r9 = false;
    L8:
        i r13 = a(r11, "", r0, this.d);
        this.f1552b = r13;
        r13.y = !this.e.remove(Integer.valueOf(r12)) ? 1 : 0;
        if (this.i == true) goto L11;
    L25:
        this.h = true;
        return;
    L11:
        if (this.h == true) goto L15;
        com.bytedance.applog.b r14 = this.f;
        String r1 = "{\"v\":1}";
    L13:
        r14.c("applog_activity_resume", r1);
        goto L25
    L15:
        if (r9 == false) goto L21;
        long r4 = this.c;
        if (r4 >= (r0 - 3000)) goto L21;
        if (r4 <= (r0 - 30000)) goto L21;
        r14 = this.f;
        r1 = "{\"v\":2}";
    L21:
        if (r9 == false) goto L25;
        if (this.c >= (r0 - 30000)) goto L25;
        r14 = this.f;
        r1 = "{\"v\":3}";
        goto L13
    L5:
        if (this.c <= 0) goto L7;
        r9 = true;
        goto L8
    }

    public void a(boolean r1) {
        this.i = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r2, Bundle r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        this.e.add(Integer.valueOf(r4.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.e.remove(Integer.valueOf(r4.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        String r1 = "";
        this.f.aX().b("");
        long r2 = System.currentTimeMillis();
        j r0 = this.f.aA();
        Object[] r4 = new Object[1];
        if (r7 == null) goto L5;
        r1 = r7.getClass().getName();
    L5:
        r4[0] = r1;
        r0.c("onActivityPaused:{}", r4);
        i r8 = this.f1552b;
        if (r8 == null) goto L9;
        this.d = r8.x;
        this.c = r2;
        a(r8, r2);
        this.f1552b = null;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        a(r4.getClass().getName(), r4.hashCode());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        this.f1551a++;
        this.g = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (this.d == null) goto L8;
        int r5 = this.f1551a - 1;
        this.f1551a = r5;
        if (r5 > 0) goto L9;
        this.d = null;
        this.c = 0;
        return;
    L9:
        return;
    }
}
