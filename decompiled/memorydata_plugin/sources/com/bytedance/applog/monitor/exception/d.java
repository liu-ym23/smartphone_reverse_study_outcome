package com.bytedance.applog.monitor.exception;

import com.bytedance.applog.monitor.v3.StageEventType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f1679b;
    private final b c;
    private final LinkedList<a> d;
    private final Map<String, c> e;
    private long f;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        StageEventType f1680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1681b;
        long c;
        long d;

        public a(StageEventType r1, String r2, long r3, long r5) {
            this.f1680a = r1;
            this.f1681b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    public interface b {
        void a(Map<String, c> r1);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1683b;
        public long c;

        public c(String r1, int r2, long r3) {
            this.f1682a = r1;
            this.f1683b = r2;
            this.c = r3;
        }

        public String toString() {
            return "LargeSizeItem{eventName='" + this.f1682a + "', count=" + this.f1683b + ", totalSize=" + this.c + '}';
        }
    }

    private void a() {
        HashMap r0 = new HashMap(this.e);
        this.e.clear();
        this.d.clear();
        this.f = 0;
        b r3 = this.c;
        if (r3 == null) goto L6;
        r3.a(r0);
        return;
    }

    private void a(long r8) {
    L3:
        if (this.d.isEmpty() == true) goto L13;
        if (((a) ZeusTransformUtils.preCheckCast(this.d.getFirst(), a.class, "com.obric.memorydata.plugin")).c >= (r8 - this.f1678a)) goto L20;
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.removeFirst(), a.class, "com.obric.memorydata.plugin");
        String r1 = r0.f1680a + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.f1681b;
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.e.get(r1), c.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L3;
        if (r2.f1683b <= 1) goto L11;
        r2.f1683b--;
        r2.c -= r0.d;
    L12:
        this.f -= r0.d;
        goto L3
    L11:
        this.e.remove(r1);
        goto L12
    L20:
        return;
    }

    public synchronized void a(StageEventType r9, String r10, long r11, long r13) {
        monitor-enter(this);
        this.d.add(new a(r9, r10, r11, r13));     // Catch: Throwable -> L12
        String r12 = r9 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r10;     // Catch: Throwable -> L12
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.e.get(r12), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
        this.e.put(r12, new c(r10, 1, r13));     // Catch: Throwable -> L12
    L7:
        this.f += r13;     // Catch: Throwable -> L12
        a(r11);     // Catch: Throwable -> L12
        if (this.f <= this.f1679b) goto L10;
        a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        r0.f1683b++;     // Catch: Throwable -> L12
        r0.c += r13;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
