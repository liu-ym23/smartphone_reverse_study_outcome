package com.obric.memorydata.memory.ui.a;

import android.os.SystemClock;
import android.util.ArrayMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<a> f10558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayMap<b, Long> f10559b;
    private final ArrayList<b> c;
    private final C0517a d;
    private long e;
    private boolean f;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.a.a$a, reason: collision with other inner class name */
    public class C0517a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f10560a;

        public C0517a(a r1) {
            this.f10560a = r1;
        }

        public void a() {
            a.a(this.f10560a, SystemClock.uptimeMillis());
            a r3 = this.f10560a;
            a.b(r3, a.a(r3));
        }
    }

    interface b {
        boolean a(long r1);
    }

    static {
        f10558a = new ThreadLocal();
    }

    public a() {
        this.f10559b = new ArrayMap();
        this.c = new ArrayList();
        this.d = new C0517a(this);
        this.e = 0;
        this.f = false;
    }

    static /* synthetic */ long a(a r2) {
        return r2.e;
    }

    static /* synthetic */ long a(a r0, long r1) {
        r0.e = r1;
        return r1;
    }

    public static a a() {
        ThreadLocal<a> r0 = f10558a;
        if (r0.get() != null) goto L6;
        r0.set(new a());
    L6:
        return (a) ZeusTransformUtils.preCheckCast(r0.get(), a.class, "com.obric.memorydata.plugin");
    }

    private void a(long r7) {
        long r0 = SystemClock.uptimeMillis();
        int r2 = 0;
    L4:
        if (r2 >= this.c.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.c.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (b(r3, r0) == false) goto L11;
        r3.a(r7);
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        c();
    }

    static /* synthetic */ void b(a r0, long r1) {
        r0.a(r1);
    }

    private boolean b(b r5, long r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f10559b.get(r7), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.longValue() >= r6) goto L9;
        this.f10559b.remove(r7);
        return true;
    L9:
        return false;
    }

    private void c() {
        if (this.f == false) goto L15;
        int r0 = this.c.size() - 1;
    L5:
        if (r0 < 0) goto L10;
        if (this.c.get(r0) != null) goto L9;
        this.c.remove(r0);
    L9:
        r0 = r0 - 1;
        goto L5
    L10:
        this.f = false;
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        this.f10559b.remove(r4);
        int r5 = this.c.indexOf(r4);
        if (r5 < 0) goto L6;
        this.c.set(r5, null);
        this.f = true;
        return;
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (this.c.contains(r5) == true) goto L6;
        this.c.add(r5);
    L6:
        if (r4 <= 0) goto L9;
        this.f10559b.put(r5, Long.valueOf(SystemClock.uptimeMillis() + r4));
        return;
    }

    public C0517a b() {
        return this.d;
    }
}
