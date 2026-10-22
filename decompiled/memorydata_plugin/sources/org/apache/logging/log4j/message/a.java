package org.apache.logging.log4j.message;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.util.r;

/* JADX INFO: loaded from: classes6.dex */
class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17890b;
    private final String c;
    private final Thread.State d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final String h;

    a(Thread r3) {
        this.f17889a = r3.getId();
        this.f17890b = r3.getName();
        this.c = r3.toString();
        this.d = r3.getState();
        this.e = r3.getPriority();
        this.f = r3.isAlive();
        this.g = r3.isDaemon();
        ThreadGroup r4 = r3.getThreadGroup();
        if (r4 != null) goto L5;
        String r5 = null;
    L6:
        this.h = r5;
        return;
    L5:
        r5 = r4.getName();
        goto L6
    }

    @Override // org.apache.logging.log4j.message.h
    public void a(StringBuilder r5) {
        r.a(r5, this.f17890b).append(' ');
        if (this.g == false) goto L5;
        r5.append("daemon ");
    L5:
        r5.append("prio=").append(this.e).append(" tid=").append(this.f17889a).append(' ');
        String r0 = this.h;
        if (r0 == null) goto L8;
        r.a(r5, "group", r0);
    L8:
        r5.append('\n');
        r5.append("\tThread state: ").append(this.d.name()).append('\n');
    }

    @Override // org.apache.logging.log4j.message.h
    public void a(StringBuilder r4, StackTraceElement[] r5) {
        int r3 = r5.length;
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        StackTraceElement r1 = r5[r0];
        r4.append("\tat ").append(r1).append('\n');
        r0 = r0 + 1;
        goto L3
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L22:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L22;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
        if (this.f17889a == r8.f17889a) goto L13;
        return false;
    L13:
        String r6 = this.f17890b;
        if (r6 == null) goto L19;
        if (r6.equals(r8.f17890b) == false) goto L20;
    L21:
        return true;
    L20:
        return false;
    L19:
        if (r8.f17890b == null) goto L21;
        goto L20
    }

    public int hashCode() {
        long r0 = this.f17889a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r4 = this.f17890b;
        if (r4 == null) goto L5;
        int r5 = r4.hashCode();
    L7:
        return r1 + r5;
    L5:
        r5 = 0;
        goto L7
    }
}
