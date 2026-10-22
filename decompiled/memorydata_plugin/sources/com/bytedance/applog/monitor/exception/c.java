package com.bytedance.applog.monitor.exception;

import com.bytedance.applog.monitor.v3.StageEventType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1675b;
    private final b c;
    private final LinkedList<a> d;
    private final Map<String, Integer> e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        StageEventType f1676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1677b;
        long c;

        public a(StageEventType r1, String r2, long r3) {
            this.f1676a = r1;
            this.f1677b = r2;
            this.c = r3;
        }
    }

    public interface b {
        void a(Map<String, Integer> r1);
    }

    private void a() {
        HashMap r0 = new HashMap(this.e);
        this.e.clear();
        this.d.clear();
        b r2 = this.c;
        if (r2 == null) goto L6;
        r2.a(r0);
        return;
    }

    private void a(long r6) {
    L3:
        if (this.d.isEmpty() == true) goto L12;
        if (((a) ZeusTransformUtils.preCheckCast(this.d.getFirst(), a.class, "com.obric.memorydata.plugin")).c >= (r6 - this.f1674a)) goto L22;
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.removeFirst(), a.class, "com.obric.memorydata.plugin");
        String r1 = r0.f1676a + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.f1677b;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.e.get(r1), Integer.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L3;
        if (r2.intValue() > 1) goto L10;
        this.e.remove(r1);
        goto L3
    L10:
        this.e.put(r1, Integer.valueOf(r2.intValue() - 1));
        goto L3
    L22:
        return;
    }

    public synchronized void a(StageEventType r3, String r4, long r5) {
        monitor-enter(this);
        this.d.add(new a(r3, r4, r5));     // Catch: Throwable -> L12
        String r6 = r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4;     // Catch: Throwable -> L12
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.e.get(r6), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r7 != null) goto L6;
        this.e.put(r6, 1);     // Catch: Throwable -> L12
    L7:
        a(r5);     // Catch: Throwable -> L12
        if (this.d.size() <= this.f1675b) goto L10;
        a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        this.e.put(r6, Integer.valueOf(r7.intValue() + 1));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
