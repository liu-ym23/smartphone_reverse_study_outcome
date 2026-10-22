package com.bytedance.ttnet.priority;

import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends TTHttpCallPriorityControl.a {
    private final f c;
    private final g d;
    private final h e;
    private final Set<String> f;
    private final Set<String> g;
    private int h;

    public c() {
        this.c = new f();
        this.d = new g();
        this.e = new h();
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
        this.h = 60000;
    }

    private boolean a(Request r2) {
        this.c.a(r2);
        if (this.f.isEmpty() == true) goto L7;
        return TTHttpCallPriorityControl.a(this.f, r2.getPath());
    L7:
        if (this.g.isEmpty() == false) goto L9;
        return false;
    L9:
        return !TTHttpCallPriorityControl.a(this.g, r2.getPath());
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void a() {
        super.a();
        this.e.a();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean a(JSONObject r3) {
        super.a(r3);
        this.c.a(r3);
        this.f3294a.a(r3, this.f3295b);
        JSONObject r0 = r3.optJSONObject("priority");
        if (this.c.a() == true) goto L7;
        if (r0 != null) goto L7;
        return false;
    L7:
        this.d.a(r0);
        this.e.a(r3);
        JSONObject r4 = r3.optJSONObject("delay");
        if (r4 == null) goto L12;
        this.f.addAll(TTHttpCallPriorityControl.a(r4, "bl_with_priority"));
        this.g.addAll(TTHttpCallPriorityControl.a(r4, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void b() {
        super.b();
        this.e.b();
        this.f3294a.a();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType c() {
        return TTHttpCallPriorityControl.ModeType.PRIORITY;
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

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r2) {
        Request r3 = this.d.a(r2);
        return this.e.a(r3);
    }
}
