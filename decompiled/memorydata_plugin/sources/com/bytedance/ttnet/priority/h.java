package com.bytedance.ttnet.priority;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.throttle.TTNetThrottle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3308a = "RequestSpeedController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f3309b = null;
    private final Map<String, Integer> c;
    private Set<String> d;
    private Set<String> e;
    private Set<String> f;
    private Set<String> g;
    private long h;
    private long i;
    private long j;
    private long k;

    static {
        f3309b = new String[0];
    }

    public h() {
        this.c = new ConcurrentHashMap();
        this.d = new CopyOnWriteArraySet();
        this.e = new CopyOnWriteArraySet();
        this.f = new CopyOnWriteArraySet();
        this.g = new CopyOnWriteArraySet();
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }

    public Request a(Request r5) {
        Integer r4 = TTHttpCallPriorityControl.a(this.c, r5.getPath());
        if (r4 != null) goto L5;
        return r5;
    L5:
        Request.Builder r0 = r5.newBuilder();
        Object r6 = r5.getExtraInfo();
        if (r6 != null) goto L9;
        r6 = new com.bytedance.ttnet.b.d();
        r0.setExtraInfo(r6);
    L9:
        if (ZeusTransformUtils.instanceOf(r6, com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L11;
        com.bytedance.frameworks.baselib.network.http.c r1 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r6, com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        r1.s = r4.longValue();
    L11:
        r0.setExtraInfo(r6);
        return r0.build();
    }

    public void a() {
        if (Logger.debug() == false) goto L6;
        Logger.d(f3308a, "connectionThrottleStart");
        Logger.d(f3308a, "normal_up throttle " + this.d.size() + " speed " + this.h);
        Logger.d(f3308a, "normal_down throttle " + this.e.size() + " speed " + this.i);
        Logger.d(f3308a, "ws_up throttle " + this.f.size() + " speed " + this.j);
        Logger.d(f3308a, "ws_down throttle " + this.g.size() + " speed " + this.k);
    L6:
        if (this.d.size() <= 0) goto L11;
        if (this.h <= 0) goto L11;
        TTNetThrottle.start((String[]) ZeusTransformUtils.preCheckCast(this.d.toArray(f3309b), String[].class, "com.obric.memorydata.plugin"), 1, this.h);
    L11:
        if (this.e.size() <= 0) goto L16;
        if (this.i <= 0) goto L16;
        TTNetThrottle.start((String[]) ZeusTransformUtils.preCheckCast(this.e.toArray(f3309b), String[].class, "com.obric.memorydata.plugin"), 2, this.i);
    L16:
        if (this.f.size() <= 0) goto L21;
        if (this.j <= 0) goto L21;
        TTNetThrottle.start((String[]) ZeusTransformUtils.preCheckCast(this.f.toArray(f3309b), String[].class, "com.obric.memorydata.plugin"), 4, this.j);
    L21:
        if (this.g.size() > 0) goto L23;
        return;
    L23:
        if (this.k <= 0) goto L27;
        TTNetThrottle.start((String[]) ZeusTransformUtils.preCheckCast(this.g.toArray(f3309b), String[].class, "com.obric.memorydata.plugin"), 8, this.k);
        return;
    }

    public boolean a(JSONObject r7) {
        b();
        this.c.clear();
        JSONObject r8 = r7.optJSONObject("throttle");
        if (r8 != null) goto L6;
        return false;
    L6:
        JSONObject r0 = r8.optJSONObject("request_throttle");
        if (r0 == null) goto L12;
        Iterator<String> r1 = r0.keys();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        this.c.put(r2, Integer.valueOf(r0.optInt(r2)));
    L12:
        JSONObject r9 = r8.optJSONObject("connection_throttle");
        if (r9 == null) goto L29;
        JSONObject r3 = r9.optJSONObject("normal_up");
        if (r3 == null) goto L17;
        this.d = TTHttpCallPriorityControl.a(r3, "hosts");
        this.h = r3.optInt("speed", -1);
    L17:
        JSONObject r4 = r9.optJSONObject("normal_down");
        if (r4 == null) goto L20;
        this.e = TTHttpCallPriorityControl.a(r4, "hosts");
        this.i = r4.optInt("speed", -1);
    L20:
        JSONObject r5 = r9.optJSONObject("ws_up");
        if (r5 == null) goto L23;
        this.f = TTHttpCallPriorityControl.a(r5, "hosts");
        this.j = r5.optInt("speed", -1);
    L23:
        JSONObject r10 = r9.optJSONObject("ws_down");
        if (r10 == null) goto L30;
        this.g = TTHttpCallPriorityControl.a(r10, "hosts");
        this.k = r10.optInt("speed", -1);
        return true;
    L30:
        return true;
    L29:
        return true;
    }

    public void b() {
        Set<String> r0 = this.d;
        String[] r1 = f3309b;
        TTNetThrottle.stop((String[]) ZeusTransformUtils.preCheckCast(r0.toArray(r1), String[].class, "com.obric.memorydata.plugin"), 1);
        TTNetThrottle.stop((String[]) ZeusTransformUtils.preCheckCast(this.e.toArray(r1), String[].class, "com.obric.memorydata.plugin"), 2);
        TTNetThrottle.stop((String[]) ZeusTransformUtils.preCheckCast(this.f.toArray(r1), String[].class, "com.obric.memorydata.plugin"), 4);
        TTNetThrottle.stop((String[]) ZeusTransformUtils.preCheckCast(this.g.toArray(r1), String[].class, "com.obric.memorydata.plugin"), 8);
    }
}
