package com.bytedance.apm.h.b;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f1343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f1344b;
    private long c;
    private volatile long d;
    private volatile long e;
    private volatile long f;
    private volatile long g;
    private volatile long h;
    private volatile long i;
    private volatile long j;
    private volatile long k;

    public e() {
        this.f1344b = new CopyOnWriteArrayList();
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    private void m() {
        e this = this;
        if ((System.currentTimeMillis() - this.c) >= 1000) goto L5;
        return;
    L5:
        this.c = System.currentTimeMillis();
        int r1 = Process.myUid();
        n();
        if (i.a(this.f1344b) == false) goto L8;
        return;
    L8:
        Iterator<String> r2 = this.f1344b.iterator();
        long r3 = 0;
        long r5 = 0;
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
        long r13 = 0;
        long r15 = 0;
        long r19 = 0;
    L10:
        if (r2.hasNext() == false) goto L47;
        long r21 = r15;
        r2 = r2;
        String[] r0 = ((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")).split(" ");
    L44:
        int r32 = r1;
    L43:
        long r4 = r13;
        long r14 = r21;
    L45:
        long r36 = r4;
        long r6 = r14;
        r13 = r36;
    L46:
        r15 = r6;
        r1 = r32;
        goto L10
    L13:
        if (TextUtils.equals(r0[3], "uid_tag_int") == true) goto L14;
        if (r1 != Integer.parseInt(r0[3])) goto L42;
        long r23 = Long.parseLong(r0[5]);     // Catch: Exception -> L44
        long r25 = Long.parseLong(r0[6]);     // Catch: Exception -> L44
        long r27 = Long.parseLong(r0[7]);     // Catch: Exception -> L44
        long r29 = Long.parseLong(r0[8]);     // Catch: Exception -> L44
        r32 = r1;
        if (Long.valueOf(r0[4]).longValue() != 1) goto L58;
        if (r0[1].startsWith("rmnet_data") == false) goto L24;
        r11 = r11 + (r27 + r23);     // Catch: Exception -> L51
        r13 = r13 + (r29 + r25);     // Catch: Exception -> L51
        goto L58
    L24:
        if (r0[1].startsWith("wlan") == false) goto L58;
        r9 = r9 + (r27 + r23);
        r3 = r3 + (r29 + r25);
    L58:
        if (Long.valueOf(r0[4]).longValue() == 0) goto L56;
        long r37 = r13;
        r14 = r21;
        long r22 = r37;
    L38:
        r6 = r14;
        r13 = r22;
        goto L46
    L56:
        if (r0[1].startsWith("rmnet_data") == false) goto L33;
        r7 = r7 + (r27 + r23);
        r6 = r21 + (r29 + r25);
        goto L46
    L33:
        long r38 = r13;
        r14 = r21;
        r22 = r38;
        if (r0[1].startsWith("wlan") == false) goto L38;
        r5 = r5 + (r27 + r23);
        r19 = r19 + (r29 + r25);
    L41:
        r4 = r22;
    L40:
        long r39 = r13;
        r14 = r21;
        r22 = r39;
        goto L41
    L42:
        r32 = r1;
        goto L43
    L14:
        r15 = r21;
        goto L10
    L47:
        e r8 = this;
        long r10 = r13;
        r8.d = r5;
        r8.e = r7;
        r8.f = r9;
        r8.g = r11;
        r8.h = r19;
        r8.i = r15;
        r8.j = r3;
        r8.k = r10;
    }

    private void n() {
        if (this.f1343a != null) goto L5;
        return;
    L5:
        BufferedReader r0 = null;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L17
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(this.f1343a), "utf-8"));     // Catch: Throwable -> L17
        int r3 = 1;
    L26:
        String r4 = r2.readLine();     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        if (r3 < 0) goto L12;
        r1.add(r4);     // Catch: Throwable -> L15
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L26
    L13:
        this.f1344b.clear();     // Catch: Throwable -> L15
        this.f1344b.addAll(r1);     // Catch: Throwable -> L15
        com.bytedance.monitor.util.d.a(r2);
        return;
    L15:
        th = th;
        r0 = r2;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L21
        com.bytedance.monitor.util.d.a(r0);
        return;
    L21:
        th = move-exception;
        com.bytedance.monitor.util.d.a(r0);
        throw th;
    L17:
        th = th;
        goto L24
    }

    @Override // com.bytedance.apm.h.b.b
    public void a() {
        this.f1343a = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // com.bytedance.apm.h.b.b
    public void a(boolean r1) {
    }

    @Override // com.bytedance.apm.h.b.b
    public long b() {
        return i() + h();
    }

    @Override // com.bytedance.apm.h.b.b
    public long c() {
        return k() + j();
    }

    @Override // com.bytedance.apm.h.b.b
    public long d() {
        return i() + k();
    }

    @Override // com.bytedance.apm.h.b.b
    public long e() {
        m();
        return this.i + this.h;
    }

    @Override // com.bytedance.apm.h.b.b
    public long f() {
        return h() + j();
    }

    @Override // com.bytedance.apm.h.b.b
    public long g() {
        m();
        return this.k + this.j;
    }

    @Override // com.bytedance.apm.h.b.b
    public long h() {
        m();
        return this.g;
    }

    @Override // com.bytedance.apm.h.b.b
    public long i() {
        m();
        return this.e;
    }

    @Override // com.bytedance.apm.h.b.b
    public long j() {
        m();
        return this.f;
    }

    @Override // com.bytedance.apm.h.b.b
    public long k() {
        m();
        return this.d;
    }

    @Override // com.bytedance.apm.h.b.b
    public long l() {
        return b() + c();
    }
}
