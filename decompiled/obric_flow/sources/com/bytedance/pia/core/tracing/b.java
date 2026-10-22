package com.bytedance.pia.core.tracing;

import android.os.Handler;
import android.util.LruCache;
import com.bytedance.apm.f;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.pia.core.utils.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.cronet.b f7104r = null;
    public static final List s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final LruCache f7105t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f7106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f7108c;
    public int d;
    public a e;
    public a f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7115n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f7116o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f7117p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f7118q;

    static {
        f7104r = new com.bytedance.frameworks.baselib.network.http.cronet.b(7);
        s = CollectionsKt.listOf(new String[]{"RD", "WRD", "PF", "FR3", "PPS", "LCP"});
        f7105t = new LruCache(5);
    }

    public b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f7106a = LazyKt.lazy(OnlineTracing$closeOnlineMonitor$2.f7101a);
        this.d = -1;
        this.g = "-1";
        this.f7109h = "csr";
        this.f7111j = -1;
        this.f7112k = -1;
        this.f7113l = -1;
        this.f7114m = -1;
        this.f7115n = -1;
        this.f7116o = new ConcurrentHashMap();
        this.f7117p = new ConcurrentHashMap();
        com.bytedance.frameworks.baselib.network.http.cronet.b r10 = f7104r;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r5, "name");     // Catch: Throwable -> L13
        Long r11 = (Long) f7105t.get(r5);     // Catch: Throwable -> L13
        if (r11 != null) goto L8;
        monitor-exit(r10);
        long r12 = 0;
    L11:
        this.f7118q = r12;
        return;
    L8:
        long r13 = r11.longValue();     // Catch: Throwable -> L13
        monitor-exit(r10);
        r12 = r13;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(int r10) {
        int r5 = 2;
        int r11 = 1;
        if (((Boolean) this.f7106a.getValue()).booleanValue() == false) goto L6;
        return;
    L6:
        if (r10 == 0) goto L18;
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L23;
        a r12 = this.f;
        if (r12 == null) goto L20;
        Lazy r13 = m.f7155a;
        Intrinsics.checkNotNullParameter(r12, "runnable");
        ((Handler) m.f7156b.getValue()).removeCallbacks(r12);
        return;
    L20:
        return;
    L23:
        return;
    L14:
        a r14 = this.e;
        if (r14 == null) goto L21;
        Lazy r15 = m.f7155a;
        Intrinsics.checkNotNullParameter(r14, "runnable");
        ((Handler) m.f7156b.getValue()).removeCallbacks(r14);
        return;
    L21:
        return;
    L18:
        System.currentTimeMillis();
        a r16 = new a(this, r11);
        this.e = r16;
        Intrinsics.checkNotNull(r16);
        Lazy r17 = m.f7155a;
        Intrinsics.checkNotNullParameter(r16, "runnable");
        Lazy r18 = m.f7156b;
        ((Handler) r18.getValue()).postDelayed(r16, 1000);
        a r19 = new a(this, r5);
        this.f = r19;
        Intrinsics.checkNotNull(r19);
        Intrinsics.checkNotNullParameter(r19, "runnable");
        ((Handler) r18.getValue()).postDelayed(r19, WsConstants.EXIT_DELAY_TIME);
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        long r10 = this.f7118q;
        if (r10 <= 0) goto L6;
        this.f7116o.put(r5, CollectionsKt.mutableListOf(new Long[]{Long.valueOf(System.currentTimeMillis() - r10)}));
        return;
    }

    public final void c(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        String r11 = r5.toUpperCase(Locale.getDefault());
        Iterator r12 = s.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String r13 = (String) r12.next();
        if (StringsKt.g(r11, td.d.b(".", r13)) == false) goto L4;
        ConcurrentHashMap r14 = this.f7116o;
        List r15 = (List) r14.get(r13);
        if (r15 != null) goto L10;
        r15 = new ArrayList();
        r14.put(r13, r15);
    L10:
        r15.add(Long.valueOf(r10));
        goto L4
    }

    public final void d(String r10, lh.b r11, String r12, com.bytedance.pia.core.setting.a r13) {
        Intrinsics.checkNotNullParameter(r10, "html");
        if (((Boolean) this.f7106a.getValue()).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.f7108c == false) goto L8;
        return;
    L8:
        this.f7108c = true;
        m.b(new f(r10, r11, r12, this, r13));
    }
}
