package com.ss.android.lark.chat.core.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import y6b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T, S> implements d.a<d<S>> {
    public final x4b.c<S, T> a;
    public volatile List<T> b;
    public volatile List<T> c;
    public volatile boolean d;
    public volatile boolean e;
    public final InterfaceC0086b<T> f;
    public final List<a<T>> g;
    public final List<e<T>> h;

    public interface a<T> {
        void a(List<T> r1, int r2, int r3);

        void b(List<T> r1, int r2, int r3);

        void c(List r1, int r2);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.core.model.b$b, reason: collision with other inner class name */
    public interface InterfaceC0086b<T> {
        void onChanged(List<T> r1);
    }

    public final void f() {
        boolean r0 = false;
        this.d = false;
        this.b = this.c;
        this.c = null;
        if (this.f != null) goto L5;
    L7:
        StringBuilder r1 = new StringBuilder("snapshots size=");
        r1.append(this.b.size());
        r1.append(", listener=");
        if (this.f == null) goto L10;
        r0 = true;
    L10:
        r1.append(r0);
        r1.append(", mHasChange=");
        r1.append(this.e);
        PerfLog.end("DataListPipeline_onUpdate", r1.toString());
        return;
    L5:
        if (this.e == false) goto L7;
        this.f.onChanged(b());
        goto L7
    }

    public final void a() {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.c == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("should call updateBegin at first");
    }

    public final List<T> b() {
        List<T> r0 = this.b;
        Iterator<e<T>> r1 = this.h.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = r1.next().a(r0);
        goto L4
    L7:
        return new ArrayList(r0);
    }

    public final void c() {
        if (this.f != null) goto L6;
        return;
    L6:
        if (this.d == false) goto L8;
        this.e = true;
        return;
    L8:
        this.f.onChanged(b());
    }

    public final void e() {
        PerfLog.start("DataListPipeline_onUpdate", "snapshots size = " + this.b.size());
        this.c = new ArrayList(this.b);
        this.e = false;
        this.d = true;
    }

    public final void d(d<S> r6, int r7, int r8) {
        if (r8 > 0) goto L4;
        return;
    L4:
        a();
        this.e = true;
        int r0 = 0;
    L5:
        if (r0 >= r8) goto L7;
        int r2 = r7 + r0;
        ListProtector.add(this.c, r2, this.a.b(r6.get(r2)));
        r0 = r0 + 1;
        goto L5
    L7:
        List<a<T>> r9 = this.g;
        if (r9 != null) goto L10;
        return;
    L10:
        if (r9.isEmpty() == true) goto L18;
        Iterator<a<T>> r10 = this.g.iterator();
    L13:
        if (r10.hasNext() == false) goto L19;
        r10.next().b(this.c, r7, r8);
        goto L13
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d<S> r3, x4b.c<S, T> r4, List<a<T>> r5, InterfaceC0086b<T> r6) {
        this.b = new ArrayList();
        this.d = false;
        this.e = false;
        this.h = new ArrayList();
        this.a = r4;
        this.g = r5;
        this.f = r6;
        r3.acquireReadAccess();
        r3.removeOnListUpdateCallback(this);
        r3.addOnListUpdateCallback(this);
        e();
        d(r3, 0, ((ArrayList) r3).size());
        f();
        r3.releaseReadAccess();
    }
}
