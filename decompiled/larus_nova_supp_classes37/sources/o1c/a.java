package o1c;

import android.os.SystemClock;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.preload.v2.condition.ConditionSet;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a<P, T> implements c<P, T> {
    public final String a;
    public int b;
    public boolean c;
    public boolean d;
    public final d e;
    public ConditionSet f;
    public ConditionSet g;
    public ConditionSet h;
    public P i;
    public IGetDataCallback<?> j;
    public c.a k;
    public long l;
    public long m;
    public b n;

    public abstract void d(P r1);

    public abstract Set<String> f(P r1);

    @Override // java.lang.Runnable
    public final void run() {
        this.f.getClass();
        e(this.i);
    }

    @Override // o1c.c
    public final void s1() {
        c.a r0 = this.k;
        if (r0 == null) goto L5;
        r0.g(this);
    L5:
        b r1 = this.n;
        if (r1 == null) goto L9;
        r1.b(this);
        return;
    }

    public a() {
        this.a = k0.a(8);
        this.b = 10;
        this.d = true;
        this.e = new d(0);
        this.f = new ConditionSet();
        this.g = new ConditionSet();
        this.h = new ConditionSet();
    }

    @Override // o1c.c
    public final ConditionSet C1() {
        return this.h;
    }

    @Override // o1c.c
    public final long L0() {
        return this.l;
    }

    @Override // o1c.c
    public final d R() {
        return this.e;
    }

    @Override // o1c.c
    public final boolean T0() {
        return this.d;
    }

    @Override // o1c.c
    public final int getPriority() {
        return this.b;
    }

    @Override // o1c.c
    public final String getTaskId() {
        return this.a;
    }

    @Override // o1c.c
    public boolean isInterrupted() {
        return this.c;
    }

    @Override // o1c.c
    public final ConditionSet p0() {
        return this.f;
    }

    @Override // o1c.c
    public final ConditionSet w0() {
        return this.g;
    }

    @Override // o1c.c
    public final void J0(e1c.a r1) {
        this.n = r1;
    }

    @Override // o1c.c
    public final void K(e1c.d r1) {
        this.k = r1;
    }

    @Override // o1c.c
    public final void L(ConditionSet r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    @Override // o1c.c
    public final void N0(boolean r1) {
        this.d = r1;
    }

    @Override // o1c.c
    public final void b0(IGetDataCallback<?> r1) {
        this.j = r1;
    }

    @Override // java.lang.Comparable
    public final int compareTo(c<?, ?> r2) {
        c<?, ?> r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "other");
        return this.b - r3.getPriority();
    }

    public void e(P r6) {
        Set<String> r0 = f(r6);
        this.m = SystemClock.elapsedRealtime();
        c.a r1 = this.k;
        if (r1 == null) goto L5;
        r1.e(this, r0.size());
    L5:
        d(r6);
        b r7 = this.n;
        if (r7 == null) goto L8;
        r7.a(this, r0);
    L8:
        c.a r8 = this.k;
        if (r8 == null) goto L12;
        r8.b(this, r0.size(), MapsKt.mapOf(TuplesKt.to("executeTime", Long.valueOf(SystemClock.elapsedRealtime() - this.m))));
        return;
    }

    @Override // o1c.c
    public final void e1(ConditionSet r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // o1c.c
    public final void h1(P r1) {
        this.i = r1;
    }

    @Override // o1c.c
    public void k(boolean r1) {
        this.c = r1;
    }

    @Override // o1c.c
    public final void o0(ConditionSet r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // o1c.c
    public final void setPriority(int r1) {
        this.b = r1;
    }

    @Override // o1c.c
    public final void y0(long r1) {
        this.l = r1;
    }

    @Override // o1c.c
    public void J1(P r1, IGetDataCallback<?> r2) {
        d(r1);
    }
}
