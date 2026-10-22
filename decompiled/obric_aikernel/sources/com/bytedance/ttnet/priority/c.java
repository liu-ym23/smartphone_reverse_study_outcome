package com.bytedance.ttnet.priority;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends TTHttpCallPriorityControl.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d5.b f2882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d5.c f2883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d5.d f2884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set<String> f2885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set<String> f2886l;

    public c() {
        this.f2882h = new d5.b();
        this.f2883i = new d5.c();
        this.f2884j = new d5.d();
        this.f2885k = new CopyOnWriteArraySet();
        this.f2886l = new CopyOnWriteArraySet();
    }

    private boolean l(n4.c r10) {
        this.f2882h.c(r10);
        if (this.f2885k.isEmpty() == true) goto L7;
        return TTHttpCallPriorityControl.k(this.f2885k, r10.A());
    L7:
        if (this.f2886l.isEmpty() == false) goto L9;
        return false;
    L9:
        return !TTHttpCallPriorityControl.k(this.f2886l, r10.A());
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        if (l(r10) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("RequestDelay", "Delay request:" + r10.A());
    L7:
        this.f2871a.h(r10, false, true, this.f2876f, r11);
    }

    @Override // s4.b
    public n4.c c(n4.c r10) {
        n4.c r11 = this.f2883i.b(r10);
        return this.f2884j.d(r11);
    }

    @Override // s4.b
    public boolean d(n4.c r11, RetrofitMetrics r12, Executor r13, Runnable r14) {
        if (l(r11) == true) goto L5;
        return false;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDelay", "Async Delay request:" + r11.A());
    L8:
        return this.f2871a.g(r11, false, this.f2876f, r14, r13, r12);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean g(JSONObject r10) {
        super.g(r10);
        this.f2882h.a(r10);
        this.f2871a.d(r10, this.f2872b);
        JSONObject r11 = r10.optJSONObject("priority");
        if (this.f2882h.b() == true) goto L7;
        if (r11 != null) goto L7;
        return false;
    L7:
        this.f2883i.a(r11);
        this.f2884j.c(r10);
        JSONObject r12 = r10.optJSONObject("delay");
        if (r12 == null) goto L12;
        this.f2885k.addAll(TTHttpCallPriorityControl.j(r12, "bl_with_priority"));
        this.f2886l.addAll(TTHttpCallPriorityControl.j(r12, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void i() {
        super.i();
        this.f2884j.a();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void j() {
        super.j();
        this.f2884j.b();
        this.f2871a.f();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType k() {
        return TTHttpCallPriorityControl.ModeType.PRIORITY;
    }
}
