package com.tencent.open.log;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class f implements Iterable<String> {
    private ConcurrentLinkedQueue<String> a;
    private AtomicInteger b;

    public int a() {
        return this.b.get();
    }

    public void b() {
        this.a.clear();
        this.b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.a.iterator();
    }

    public f() {
        this.a = null;
        this.b = null;
        this.a = new ConcurrentLinkedQueue();
        this.b = new AtomicInteger(0);
    }

    public int a(String r3) {
        int r0 = r3.length();
        this.a.add(r3);
        return this.b.addAndGet(r0);
    }

    public void a(Writer[] r12, char[] r13) throws IOException {
        if (r12 == null) goto L66;
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.length != 0) goto L7;
        return;
    L7:
        if (r12.length < 2) goto L70;
        Writer r1 = r12[0];
        Writer r14 = r12[1];
        int r2 = r13.length;
        Iterator<String> r3 = iterator();
        int r5 = r2;
        int r4 = 0;
    L11:
        if (r3.hasNext() == false) goto L29;
        String r6 = r3.next();
        int r7 = r6.length();
        int r8 = 0;
    L13:
        if (r7 <= 0) goto L11;
        if (r5 <= r7) goto L16;
        int r9 = r7;
    L17:
        r8 = r8 + r9;
        r6.getChars(r8, r8, r13, r4);
        r5 = r5 - r9;
        r4 = r4 + r9;
        r7 = r7 - r9;
        if (r5 != 0) goto L13;
        if (r1 != null) goto L56;
    L23:
        if (r14 != null) goto L50;
    L27:
        r5 = r2;
        r4 = 0;
        goto L13
    L50:
        r14.write(r13, 0, r2);     // Catch: Exception -> L26
        goto L27
    L56:
        r1.write(r13, 0, r2);     // Catch: Exception -> L22
        goto L23
    L16:
        r9 = r5;
        goto L17
    L29:
        if (r4 <= 0) goto L38;
        if (r1 != null) goto L52;
    L34:
        if (r14 == null) goto L38;
        r14.write(r13, 0, r4);     // Catch: Exception -> L37
        goto L38
    L52:
        r1.write(r13, 0, r4);     // Catch: Exception -> L33
    L38:
        if (r1 != null) goto L54;
    L42:
        if (r14 == null) goto L69;
        r14.flush();     // Catch: Exception -> L45
        return;
    L71:
        return;
    L69:
        return;
    L54:
        r1.flush();     // Catch: Exception -> L41
        goto L42
    L70:
        return;
    }
}
