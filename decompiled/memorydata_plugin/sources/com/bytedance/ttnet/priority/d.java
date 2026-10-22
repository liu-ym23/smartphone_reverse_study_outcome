package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends TTHttpCallPriorityControl.a {
    private final f c;
    private final Set<String> d;
    private final Set<String> e;
    private final Set<String> f;
    private int g;
    private int h;
    private final AtomicLong i;
    private final Set<Request> j;

    public d() {
        this.c = new f();
        this.d = new CopyOnWriteArraySet();
        this.e = new CopyOnWriteArraySet();
        this.f = new CopyOnWriteArraySet();
        this.g = 5000;
        this.h = 5000;
        this.i = new AtomicLong(0);
        this.j = new CopyOnWriteArraySet();
    }

    static /* synthetic */ Set a(d r0) {
        return r0.j;
    }

    private boolean a(Request r7) {
        this.c.a(r7);
        boolean r1 = false;
        if (TTHttpCallPriorityControl.a(this.d, r7.getPath()) == false) goto L7;
        this.i.set(System.currentTimeMillis());
        this.j.add(r7);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.i.get()) <= this.g) goto L9;
    L19:
        return r1;
    L9:
        if (this.j.isEmpty() == true) goto L19;
        if (this.e.isEmpty() == false) goto L14;
        r1 = true;
        if (this.f.isEmpty() == true) goto L19;
        return !TTHttpCallPriorityControl.a(this.f, r7.getPath());
    L14:
        return TTHttpCallPriorityControl.a(this.e, r7.getPath());
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean a(JSONObject r6) {
        super.a(r6);
        this.c.a(r6);
        this.f3294a.a(r6, this.f3295b);
        JSONArray r0 = r6.optJSONArray("p0");
        int r1 = 0;
        if (r0 == null) goto L12;
        int r2 = 0;
    L6:
        if (r2 >= r0.length()) goto L12;
        String r3 = r0.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        this.d.add(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (this.c.a() == false) goto L14;
    L16:
        JSONArray r4 = r6.optJSONArray("bl_for_runtime");
        if (r4 == null) goto L25;
        int r5 = 0;
    L20:
        if (r5 >= r4.length()) goto L25;
        String r7 = r4.optString(r5);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        this.e.add(r7);
    L24:
        r5 = r5 + 1;
    L25:
        JSONArray r8 = r6.optJSONArray("wl_for_runtime");
        if (r8 != null) goto L28;
    L33:
        this.g = r6.optInt("p0_check_max_ms", 5000);
        this.h = r6.optInt("p1_wait_max_ms", 5000);
        return true;
    L28:
        if (r1 >= r8.length()) goto L33;
        String r9 = r8.optString(r1);
        if (TextUtils.isEmpty(r9) == true) goto L32;
        this.f.add(r9);
    L32:
        r1 = r1 + 1;
        goto L28
    L14:
        if (this.d.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void b() {
        super.b();
        this.f3294a.a();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType c() {
        return TTHttpCallPriorityControl.ModeType.RUNTIME_DELAY;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin");
        if (a(r10) == true) goto L5;
        return false;
    L5:
        return this.f3294a.a(r10, false, this.h, r7, r8);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r8) {
        if (a(r8) == false) goto L6;
        this.f3294a.a(r8, false, true, this.h);
        return;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a, com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r3) {
        com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(new AnonymousClass1(this, r3));
    }
}
