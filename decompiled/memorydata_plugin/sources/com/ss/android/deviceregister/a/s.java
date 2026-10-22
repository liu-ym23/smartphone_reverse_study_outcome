package com.ss.android.deviceregister.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class s {
    private static volatile s c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f15147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f15148b;
    private final boolean d;
    private final Context e;
    private final AtomicBoolean f;
    private Future<p> g;
    private p h;

    private s(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f = new AtomicBoolean(false);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = r0;
        n r1 = o.a(r6);
        this.f15147a = r1;
        if (r1 == null) goto L5;
        this.d = r1.b(r6);
    L6:
        this.f15148b = new q(r0);
        return;
    L5:
        this.d = false;
        goto L6
    }

    static long a(String r0, long r1) {
        return Long.parseLong(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return r1;
    }

    private p a(Context r13, p r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        long r0 = SystemClock.elapsedRealtime();
        n r12 = this.f15147a;
        String r2 = null;
        if (r12 == null) goto L18;
        n.a r16 = r12.c(r15);
        if (r16 == null) goto L19;
        int r17 = -1;
        int r3 = 1;
        if (r14 == null) goto L10;
        r2 = r14.f15144b;
        r17 = r14.f.intValue() + 1;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = UUID.randomUUID().toString();
    L12:
        String r6 = r2;
        if (r17 <= 0) goto L16;
        r3 = r17;
    L16:
        long r18 = SystemClock.elapsedRealtime() - r0;
        long r1 = r16.c;
        return new p(r16.f15141a, r6, Boolean.valueOf(r16.f15142b), Long.valueOf(r18), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r3), Long.valueOf(r1));
    L19:
        return null;
    L18:
        return null;
    }

    static /* synthetic */ p a(s r0) {
        return r0.d();
    }

    public static s a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (c != null) goto L15;
        monitor-enter(s.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new s(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(s.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    static <K, V> void a(Map<K, V> r2, K r3, V r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        r5.put(r3, r4);
        return;
    L8:
        return;
    }

    static void a(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static boolean a(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private p d() {
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#initOaid");
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#initOaid exec");
        p r0 = this.f15148b.a();
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#initOaid fetch=" + r0);
        if (r0 == null) goto L5;
        this.h = r0;
    L5:
        p r1 = a(this.e, r0);
        if (r1 == null) goto L8;
        this.f15148b.a(r1);
    L8:
        if (r1 == null) goto L10;
        this.h = r1;
    L10:
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#initOaid oaidModel=" + r1);
        return r1;
    }

    public Map<String, String> a(long r9) {
        Map<String, String> r3 = null;
        if (this.d == true) goto L5;
        return null;
    L5:
        a();
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaid timeoutMills=" + r9);
        p r2 = this.h;
        if (r2 != null) goto L16;
        long r4 = SystemClock.elapsedRealtime();
        p r10 = (p) ZeusTransformUtils.preCheckCast(this.g.get(r9, TimeUnit.MILLISECONDS), p.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r10;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L13:
        th = move-exception;
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        throw th;
    L16:
        if (r2 != null) goto L18;
        r2 = this.h;
    L18:
        if (r2 == null) goto L20;
        r3 = r2.a();
    L20:
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    public void a() {
        if (this.f.compareAndSet(false, true) == false) goto L6;
        this.g = com.bytedance.common.utility.a.a.c().submit(new AnonymousClass1(this));
        return;
    }

    public String b() {
        a();
        p r3 = this.h;
        if (r3 == null) goto L5;
        String r4 = r3.f15143a;
    L6:
        com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "Oaid#getOaidId sOaidId = " + r4);
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public boolean c() {
        a();
        return this.d;
    }
}
