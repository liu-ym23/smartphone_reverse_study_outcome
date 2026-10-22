package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends TTHttpCallPriorityControl.a {
    private final f c;
    private final Map<String, Integer> d;
    private final Set<String> e;
    private int f;

    public b() {
        this.c = new f();
        this.d = new ConcurrentHashMap();
        this.e = new CopyOnWriteArraySet();
        this.f = 1000;
    }

    private int a(Request r3) {
        this.c.a(r3);
        if (this.d.isEmpty() == true) goto L9;
        Integer r2 = TTHttpCallPriorityControl.a(this.d, r3.getPath());
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    L9:
        if (this.e.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (TTHttpCallPriorityControl.a(this.e, r3.getPath()) == false) goto L13;
        return 0;
    L13:
        return this.f;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public boolean a(JSONObject r6) {
        super.a(r6);
        if (r6.isNull("bl_with_delay_ms") == true) goto L5;
    L7:
        this.c.a(r6);
        this.f3294a.a(r6, this.f3295b);
        JSONObject r0 = r6.optJSONObject("bl_with_delay_ms");
        if (r0 == null) goto L13;
        Iterator<String> r7 = r0.keys();
    L11:
        if (r7.hasNext() == false) goto L24;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        this.d.put(r1, Integer.valueOf(r0.optInt(r1)));
    L24:
        if (this.c.a() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.d.isEmpty() == false) goto L29;
        if (this.e.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r2 = r6.optJSONArray("wl");
        if (r2 == null) goto L22;
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L22;
        String r4 = r2.optString(r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.e.add(r4);
    L21:
        r3 = r3 + 1;
    L22:
        this.f = r6.optInt("delay_time_ms", 1000);
        goto L24
    L5:
        if (r6.isNull("wl") == false) goto L7;
        return false;
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    public void b() {
        super.b();
        this.f3294a.a();
    }

    @Override // com.bytedance.ttnet.priority.TTHttpCallPriorityControl.a
    TTHttpCallPriorityControl.ModeType c() {
        return TTHttpCallPriorityControl.ModeType.NORMAL_DELAY;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r10, Executor r11, Runnable r12) {
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r11, Executor.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin");
        long r5 = a(r10);
        if (Logger.debug() == false) goto L6;
        Logger.d("ModeNormalDelay", "get normal delay time " + r5 + " " + r10.getPath());
    L6:
        return this.f3294a.a(r10, false, r5, r7, r8);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r8) {
        long r5 = a(r8);
        if (Logger.debug() == false) goto L5;
        Logger.d("ModeNormalDelay", "get normal delay time " + r5 + " " + r8.getPath());
    L5:
        this.f3294a.a(r8, false, true, r5);
    }
}
