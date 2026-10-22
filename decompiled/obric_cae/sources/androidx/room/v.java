package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class v<T> extends LiveData<T> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f2701v = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r f2702l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f2703m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2704n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable<T> f2705o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u f2706p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f2707q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f2708r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f2709s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.activity.d f2710t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.activity.j f2711u;

    public v(r r8, h r10, r1.w r11, String[] r12) {
        he.i.f(r8, "database");
        this.f2702l = r8;
        this.f2703m = r10;
        this.f2704n = true;
        this.f2705o = r11;
        this.f2706p = new u(r12, this);
        this.f2707q = new AtomicBoolean(true);
        this.f2708r = new AtomicBoolean(false);
        this.f2709s = new AtomicBoolean(false);
        this.f2710t = new androidx.activity.d(this, 7);
        this.f2711u = new androidx.activity.j(this, 8);
    }

    @Override // androidx.lifecycle.LiveData
    public final void e() {
        h r8 = this.f2703m;
        r8.getClass();
        ((Set) r8.f2621b).add(this);
        boolean r10 = this.f2704n;
        r r11 = this.f2702l;
        if (r10 == false) goto L5;
        Executor r12 = r11.getTransactionExecutor();
    L6:
        r12.execute(this.f2710t);
        return;
    L5:
        r12 = r11.getQueryExecutor();
        goto L6
    }

    @Override // androidx.lifecycle.LiveData
    public final void f() {
        h r8 = this.f2703m;
        r8.getClass();
        ((Set) r8.f2621b).remove(this);
    }
}
