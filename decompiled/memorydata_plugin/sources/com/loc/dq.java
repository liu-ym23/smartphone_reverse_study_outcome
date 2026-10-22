package com.loc;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dq<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f5459b;
    private boolean c;
    private Map<String, a> d;
    private Handler e;
    private String f;
    private boolean g;
    private Runnable h;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5463b;
        long c;

        public a(int r1, long r2, long r4) {
            this.f5462a = r1;
            this.f5463b = r2;
            this.c = r4;
        }
    }

    public dq(Context r3, String r4, Handler r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.c = false;
        this.d = new ConcurrentHashMap();
        this.f = null;
        this.h = new AnonymousClass2(this);
        if (r6 != null) goto L5;
        return;
    L5:
        this.e = r5;
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = "unknow";
    L8:
        this.f5458a = r4;
        this.f = fd.l(r6);
        String r7 = r6.getFilesDir().getPath();
        this.f5459b = new File(r7, this.f5458a);     // Catch: Throwable -> L11
    L13:
        d();
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public static int a(long r0, long r2) {
        if (r0 >= r2) goto L6;
        return -1;
    L6:
        if (r0 != r2) goto L9;
        return 0;
    L9:
        return 1;
    }

    static /* synthetic */ Map a(dq r0) {
        return r0.d;
    }

    private void b(T r11, long r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (d(r11) < 0) goto L17;
        String r0 = b(r11);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r0), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        a(r11, r12);
        this.d.put(r0, new a(c(r11), d(r11), r12));
        this.g = true;
        return;
    L10:
        r1.c = r12;
        if (r1.f5462a == c(r11)) goto L14;
        a(r11, r12);
        r1.f5462a = c(r11);
        r1.f5463b = d(r11);
        this.g = true;
        return;
    L14:
        a(r11, r1.f5463b);
        return;
    }

    static /* synthetic */ boolean b(dq r0) {
        return r0.c;
    }

    static /* synthetic */ boolean c(dq r0) {
        return r0.g;
    }

    private void d() {
        StringBuilder r0 = new StringBuilder("restore from：\n");     // Catch: Throwable -> L19
        Iterator<String> r1 = fd.a(this.f5459b).iterator();     // Catch: Throwable -> L19
    L3:
        if (r1.hasNext() == false) goto L18;
        String r3 = new String(eh.b(fq.b((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")), this.f), RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L12
        r0.append(r3).append("\n");     // Catch: Throwable -> L12
        String[] r2 = r3.split(",");     // Catch: Throwable -> L12
    L7:
        if (r2.length < 4) goto L9;
        long r4 = Long.parseLong(r2[3]);     // Catch: Throwable -> L12
    L10:
        long r9 = r4;
        this.d.put(r2[0], new a(Integer.parseInt(r2[1]), Long.parseLong(r2[2]), r9));     // Catch: Throwable -> L12
        goto L3
    L9:
        r4 = fd.b();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f5459b.exists() == false) goto L16;
        this.f5459b.delete();     // Catch: Throwable -> L19
    L16:
        th.printStackTrace();     // Catch: Throwable -> L19
        goto L3
    L18:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ void d(dq r0) {
        r0.e();
    }

    private void e() {
        if (c() <= 0) goto L18;
        this.d.size();
        if (b() <= 0) goto L13;
        long r2 = fd.b();
        Iterator<Map.Entry<String, a>> r0 = this.d.entrySet().iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        if ((r2 - ((a) ZeusTransformUtils.preCheckCast(this.d.get(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey()), a.class, "com.obric.memorydata.plugin")).c) <= b()) goto L8;
        r0.remove();
    L13:
        if (this.d.size() <= c()) goto L18;
        ArrayList r1 = new ArrayList(this.d.keySet());
        Collections.sort(r1, new AnonymousClass1(this));
        int r3 = (int) c();
    L16:
        if (r3 >= r1.size()) goto L18;
        this.d.remove(r1.get(r3));
        r3 = r3 + 1;
    L18:
        StringBuilder r4 = new StringBuilder();
        Iterator<Map.Entry<String, a>> r5 = this.d.entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L26;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.append(fq.b(eh.a((((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin")) + "," + ((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.memorydata.plugin")).f5462a + "," + ((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.memorydata.plugin")).f5463b + "," + ((a) ZeusTransformUtils.preCheckCast(r6.getValue(), a.class, "com.obric.memorydata.plugin")).c).getBytes(RpcUtils.CHARSET_UTF8), this.f)) + "\n");     // Catch: UnsupportedEncodingException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L26:
        String r7 = r4.toString();
        if (TextUtils.isEmpty(r7) == true) goto L42;
        fd.a(this.f5459b, r7);
        return;
    }

    static /* synthetic */ boolean e(dq r1) {
        r1.g = false;
        return false;
    }

    static /* synthetic */ Handler f(dq r0) {
        return r0.e;
    }

    static /* synthetic */ Runnable g(dq r0) {
        return r0.h;
    }

    public final void a() {
        if (this.c == true) goto L7;
        Handler r0 = this.e;
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.h);
        this.e.postDelayed(this.h, 60000);
    L7:
        this.c = true;
    }

    public final void a(T r3) {
        b(r3, fd.b());
    }

    abstract void a(T r1, long r2);

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(List<T> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        long r6 = fd.b();
        Iterator r0 = r13.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        b(r0.next(), r6);
        goto L4
    L7:
        if (this.d.size() < r13.size()) goto L10;
        this.g = true;
    L10:
        if (this.d.size() <= 16384) goto L12;
    L13:
        this.d.clear();
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L20;
        Object r1 = r14.next();
        this.d.put(b(r1), new a(c(r1), d(r1), r6));
        goto L15
    L20:
        return;
    L12:
        if (c() <= 0) goto L13;
    }

    public final void a(boolean r3) {
        Handler r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.h);
    L5:
        if (r3 == true) goto L7;
        this.h.run();
    L7:
        this.c = false;
    }

    abstract long b();

    public abstract String b(T r1);

    abstract int c(T r1);

    abstract long c();

    abstract long d(T r1);

    public final long e(T r3) {
        return (fd.b() - d(r3)) / 1000;
    }
}
