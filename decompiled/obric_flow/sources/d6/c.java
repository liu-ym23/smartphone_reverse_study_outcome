package d6;

import android.os.Looper;
import android.util.Printer;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.j;
import g8.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jg.i;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g6.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f16598k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f16599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f16600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f16601c;
    public final CopyOnWriteArrayList d;
    public final boolean e;
    public boolean f;
    public final g g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z6.e f16602h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f16603i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f16604j;

    static {
        f16598k = new c();
    }

    public c() {
        z r5 = new z();
        r5.f23549a = new long[4];
        this.f16600b = r5;
        this.f16601c = new long[4];
        this.d = new CopyOnWriteArrayList();
        this.e = false;
        this.f = false;
        this.g = new g(13);
        this.f16602h = new z6.e("looper_monitor");
        this.f16603i = new HashMap();
    }

    public final void a(xg.b r5) {
        if (this.f16599a == true) goto L24;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L6:
        if (j.d() == true) goto L10;
        monitor-exit(this);
        goto L24
    L10:
        if (this.f16604j == false) goto L20;
        if (this.f16599a == true) goto L17;
        this.f16599a = true;     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);
        goto L24
    L20:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L15
    L24:
        if (this.d.contains(r5) == true) goto L28;
        this.d.add(r5);
        return;
    }

    public final void b() {
        int r5 = 0;
        if (this.f16604j == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L28;
        ActivityLifeObserver.getInstance().register(this);
        if (i.f18332a == true) goto L25;
        i.f18332a = true;
        i.f18333b = new jg.g(r5);
        boolean r10 = i.f18332a;
        if (com.bytedance.common.utility.b.d == true) goto L20;
        com.bytedance.common.utility.b.d = true;
        com.bytedance.common.utility.e r11 = new com.bytedance.common.utility.e();
        r11.f3956a = new ArrayList();
        r11.f3957b = new ArrayList();
        r11.f3958c = new ArrayList();
        r11.d = false;
        r11.e = false;
        com.bytedance.common.utility.b.f3955c = r11;
        Field r12 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L16
        r12.setAccessible(true);     // Catch: Exception -> L16
        Printer r13 = (Printer) r12.get(Looper.getMainLooper());     // Catch: Exception -> L16
    L17:
        if (r13 == null) goto L19;
        com.bytedance.common.utility.b.f3955c.f3956a.add(r13);
    L19:
        Looper.getMainLooper().setMessageLogging(com.bytedance.common.utility.b.f3955c);
    L16:
        r13 = null;
    L20:
        jg.g r14 = i.f18333b;
        if (r14 == null) goto L25;
        if (com.bytedance.common.utility.b.f3955c.f3958c.contains(r14) == true) goto L25;
        com.bytedance.common.utility.b.f3955c.f3958c.add(r14);
        com.bytedance.common.utility.b.f3955c.e = true;
    L25:
        i.d = new a(this);
        this.f16604j = true;
        return;
    L28:
        throw new AssertionError("must be init in main thread!");
    }
}
