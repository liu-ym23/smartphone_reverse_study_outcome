package w50;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.v;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static volatile h n;
    public final AtomicBoolean a;
    public final HashSet<String> b;
    public final HashSet<String> c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public final HashSet<Pair<String, String>> j;
    public final HashSet<String> k;
    public int l;
    public final LiveTracingMonitor.EventModule m;

    public static h a() {
        if (n != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (n != null) goto L9;
        n = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return n;
    }

    public h() {
        this.a = new AtomicBoolean(false);
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new HashSet();
        this.k = new HashSet();
        this.l = 0;
        this.m = LiveTracingMonitor.EventModule.TEXT_MESSAGE;
    }

    public final void c(@Nullable String r8, @Nullable String r9) {
        if (v.a() == false) goto L6;
        return;
    L6:
        if (this.a.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r9) == false) goto L11;
        this.d++;
    L15:
        if (TextUtils.isEmpty(r8) == false) goto L17;
        this.f++;
    L20:
        this.a.set(false);
        return;
    L17:
        this.g++;
        if (this.b.size() >= 30) goto L20;
        this.b.add(r8);
        goto L20
    L11:
        this.e++;
        if (this.c.size() >= 30) goto L15;
        this.c.add(r9);
        goto L15
    }

    public final void b(@Nullable String r5, @Nullable String r6, @Nullable String r7) {
        if (v.a() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r6) == false) goto L11;
        return;
    L11:
        if (this.a.compareAndSet(false, true) == true) goto L14;
        return;
    L14:
        if (this.j.size() >= 30) goto L20;
        this.j.add(new Pair(r5, r6));
        if (TextUtils.isEmpty(r7) == false) goto L18;
    L21:
        this.a.set(false);
        return;
    L18:
        if (this.k.size() >= 30) goto L21;
        this.k.add(r7);
        goto L21
    L20:
        this.l++;
        goto L21
    }
}
