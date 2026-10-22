package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends TTHttpCallPriorityControl.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d5.b f2878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, Integer> f2879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<String> f2880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2881k;

    public b() {
        this.f2878h = new d5.b();
        this.f2879i = new ConcurrentHashMap();
        this.f2880j = new CopyOnWriteArraySet();
        this.f2881k = 1000;
    }

    private int l(n4.c r10) {
        this.f2878h.c(r10);
        if (this.f2879i.isEmpty() == true) goto L9;
        Integer r11 = TTHttpCallPriorityControl.i(this.f2879i, r10.A());
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.intValue();
    L9:
        if (this.f2880j.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (TTHttpCallPriorityControl.k(this.f2880j, r10.A()) == false) goto L13;
        return 0;
    L13:
        return this.f2881k;
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        long r12 = l(r10);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeNormalDelay", "get normal delay time " + r12 + " " + r10.A());
    L5:
        this.f2871a.h(r10, false, true, r12, r11);
    }

    @Override // s4.b
    public boolean d(n4.c r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        long r14 = l(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeNormalDelay", "get normal delay time " + r14 + " " + r10.A());
    L6:
        return this.f2871a.g(r10, false, r14, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean g(JSONObject r10) {
        super.g(r10);
        if (r10.isNull("bl_with_delay_ms") == true) goto L5;
    L7:
        this.f2878h.a(r10);
        this.f2871a.d(r10, this.f2872b);
        JSONObject r11 = r10.optJSONObject("bl_with_delay_ms");
        if (r11 == null) goto L13;
        Iterator<String> r12 = r11.keys();
    L11:
        if (r12.hasNext() == false) goto L24;
        String r13 = r12.next();
        this.f2879i.put(r13, Integer.valueOf(r11.optInt(r13)));
    L24:
        if (this.f2878h.b() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.f2879i.isEmpty() == false) goto L29;
        if (this.f2880j.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r14 = r10.optJSONArray("wl");
        if (r14 == null) goto L22;
        int r15 = 0;
    L17:
        if (r15 >= r14.length()) goto L22;
        String r16 = r14.optString(r15);
        if (TextUtils.isEmpty(r16) == true) goto L21;
        this.f2880j.add(r16);
    L21:
        r15 = r15 + 1;
    L22:
        this.f2881k = r10.optInt("delay_time_ms", 1000);
        goto L24
    L5:
        if (r10.isNull("wl") == false) goto L7;
        return false;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void j() {
        super.j();
        this.f2871a.f();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType k() {
        return TTHttpCallPriorityControl.ModeType.NORMAL_DELAY;
    }
}
