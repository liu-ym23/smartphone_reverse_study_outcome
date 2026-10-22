package com.bytedance.framwork.core.sdklib.apm6.a;

import android.os.Process;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdklib.apm6.safety.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Long, ConcurrentHashMap<Long, JSONObject>> f2578b;
    private volatile boolean c;

    public a() {
        this.f2578b = new ConcurrentHashMap();
        this.c = false;
    }

    public static a a() {
        if (f2577a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2577a != null) goto L9;
        f2577a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f2577a;
    }

    private String b(long r1, long r3) {
        return r1 + "_" + r3;
    }

    private synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.c = true;     // Catch: Throwable -> L11
        b.a().b();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private static long c() {
        return (System.currentTimeMillis() << 16) | ((long) Process.myPid());
    }

    public long a(long r6, JSONObject r8) {
        long r0 = c();
        if (this.f2578b.containsKey(Long.valueOf(r6)) == true) goto L5;
        this.f2578b.put(Long.valueOf(r6), new ConcurrentHashMap());
    L5:
        ((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.f2578b.get(Long.valueOf(r6)), ConcurrentHashMap.class, "com.obric.memorydata.plugin")).put(Long.valueOf(r0), r8);
        String r2 = b(r6, r0);
        if (j.d() == false) goto L8;
        c.a("APM-SDK", "header init:" + r6 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r2 + " " + r8);
    L8:
        b.a().a(r2, com.bytedance.framwork.core.sdklib.b.b.a(r8));
        b();
        return r0;
    }

    public JSONObject a(long r7, long r9) {
        ConcurrentHashMap r0 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.f2578b.get(Long.valueOf(r7)), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        JSONObject r1 = b.a().a(b(r7, r9));
        if (j.d() == false) goto L12;
        c.a("APM-SDK", "header init:" + r7 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r9 + " " + b(r7, r9));
    L12:
        if (this.f2578b.containsKey(Long.valueOf(r7)) == true) goto L14;
        this.f2578b.put(Long.valueOf(r7), new ConcurrentHashMap());
    L14:
        if (r1 == null) goto L16;
        ((ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.f2578b.get(Long.valueOf(r7)), ConcurrentHashMap.class, "com.obric.memorydata.plugin")).put(Long.valueOf(r9), r1);
    L17:
        if (r1 != null) goto L19;
        c.c("APM-SDK", "header==null " + r7);
    L19:
        return r1;
    L16:
        r1 = j.a(r7);
        goto L17
    L5:
        if (r0.containsKey(Long.valueOf(r9)) == false) goto L8;
        return (JSONObject) ZeusTransformUtils.preCheckCast(r0.get(Long.valueOf(r9)), JSONObject.class, "com.obric.memorydata.plugin");
    }
}
