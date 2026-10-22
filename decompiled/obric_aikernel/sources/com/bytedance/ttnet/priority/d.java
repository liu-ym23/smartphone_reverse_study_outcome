package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends TTHttpCallPriorityControl.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d5.b f2887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<String> f2888i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<String> f2889j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Set<String> f2890k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2891l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2892m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicLong f2893n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set<n4.c> f2894o;

    class a extends j2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n4.c f2895c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f2896g;

        a(d r10, n4.c r11) {
            this.f2896g = r10;
            this.f2895c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.l(this.f2896g).remove(this.f2895c) == true) goto L5;
            return;
        L5:
            if (d.l(this.f2896g).size() != 0) goto L9;
            this.f2896g.f2871a.f();
            return;
        }
    }

    public d() {
        this.f2887h = new d5.b();
        this.f2888i = new CopyOnWriteArraySet();
        this.f2889j = new CopyOnWriteArraySet();
        this.f2890k = new CopyOnWriteArraySet();
        this.f2891l = 5000;
        this.f2892m = 5000;
        this.f2893n = new AtomicLong(0);
        this.f2894o = new CopyOnWriteArraySet();
    }

    static /* synthetic */ Set l(d r10) {
        return r10.f2894o;
    }

    private boolean m(n4.c r10) {
        this.f2887h.c(r10);
        boolean r11 = false;
        if (TTHttpCallPriorityControl.k(this.f2888i, r10.A()) == false) goto L7;
        this.f2893n.set(System.currentTimeMillis());
        this.f2894o.add(r10);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.f2893n.get()) <= this.f2891l) goto L9;
    L19:
        return r11;
    L9:
        if (this.f2894o.isEmpty() == true) goto L19;
        if (this.f2889j.isEmpty() == false) goto L14;
        r11 = true;
        if (this.f2890k.isEmpty() == true) goto L19;
        return !TTHttpCallPriorityControl.k(this.f2890k, r10.A());
    L14:
        return TTHttpCallPriorityControl.k(this.f2889j, r10.A());
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        if (m(r10) == false) goto L6;
        this.f2871a.h(r10, false, true, this.f2892m, r11);
        return;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a, s4.b
    public void b(n4.c r10) {
        j2.b.d(NetworkAsyncTaskType.NETWORK).e(new a(this, r10));
    }

    @Override // s4.b
    public boolean d(n4.c r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        if (m(r10) == true) goto L5;
        return false;
    L5:
        return this.f2871a.g(r10, false, this.f2892m, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean g(JSONObject r10) {
        super.g(r10);
        this.f2887h.a(r10);
        this.f2871a.d(r10, this.f2872b);
        JSONArray r11 = r10.optJSONArray("p0");
        int r12 = 0;
        if (r11 == null) goto L12;
        int r13 = 0;
    L6:
        if (r13 >= r11.length()) goto L12;
        String r14 = r11.optString(r13);
        if (TextUtils.isEmpty(r14) == true) goto L10;
        this.f2888i.add(r14);
    L10:
        r13 = r13 + 1;
    L12:
        if (this.f2887h.b() == false) goto L14;
    L16:
        JSONArray r15 = r10.optJSONArray("bl_for_runtime");
        if (r15 == null) goto L25;
        int r16 = 0;
    L20:
        if (r16 >= r15.length()) goto L25;
        String r17 = r15.optString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L24;
        this.f2889j.add(r17);
    L24:
        r16 = r16 + 1;
    L25:
        JSONArray r18 = r10.optJSONArray("wl_for_runtime");
        if (r18 != null) goto L28;
    L33:
        this.f2891l = r10.optInt("p0_check_max_ms", 5000);
        this.f2892m = r10.optInt("p1_wait_max_ms", 5000);
        return true;
    L28:
        if (r12 >= r18.length()) goto L33;
        String r19 = r18.optString(r12);
        if (TextUtils.isEmpty(r19) == true) goto L32;
        this.f2890k.add(r19);
    L32:
        r12 = r12 + 1;
        goto L28
    L14:
        if (this.f2888i.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void j() {
        super.j();
        this.f2871a.f();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType k() {
        return TTHttpCallPriorityControl.ModeType.RUNTIME_DELAY;
    }
}
