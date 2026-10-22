package com.obric.oui.orecyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public class d<T> {
    private static final Executor e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c<T> f14145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Executor f14146b;
    int c;
    private final r d;
    private final List<a<T>> f;
    private List<T> g;
    private List<T> h;

    public interface a<T> {
        void a(List<T> r1, List<T> r2);
    }

    private static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Handler f14152a;

        b() {
            this.f14152a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.f14152a.post(r4);
        }
    }

    static {
        e = new b();
    }

    public d(r r3, c<T> r4) {
        r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        this.f = new CopyOnWriteArrayList();
        this.h = Collections.emptyList();
        this.d = r5;
        this.f14145a = r4;
        if (r4.a() == null) goto L5;
        Executor r6 = r4.a();
    L6:
        this.f14146b = r6;
        return;
    L5:
        r6 = e;
        goto L6
    }

    private void b(List<T> r5, Runnable r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Iterator<a<T>> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a(r7, this.h);
        goto L4
    L6:
        if (r8 == null) goto L10;
        r8.run();
        return;
    }

    public List<T> a() {
        return this.h;
    }

    public void a(a<T> r3) {
        a<T> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f.add(r4);
    }

    public void a(List<T> r3) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), null);
    }

    void a(List<T> r3, i.d r4, Runnable r5) {
        List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        List<T> r0 = this.h;
        this.g = r6;
        this.h = Collections.unmodifiableList(r6);
        r4.a(this.d);
        b(r0, r7);
    }

    public void a(List<T> r9, Runnable r10) {
        final List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        final Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.memorydata.plugin");
        final int r6 = this.c + 1;
        this.c = r6;
        final List<T> r4 = this.g;
        if (r5 != r4) goto L7;
        if (r7 == null) goto L16;
        r7.run();
        return;
    L16:
        return;
    L7:
        List<T> r11 = this.h;
        if (r5 != null) goto L11;
        int r0 = r4.size();
        this.g = null;
        this.h = Collections.emptyList();
        this.d.b(0, r0);
        b(r11, r7);
        return;
    L11:
        if (r4 != null) goto L14;
        this.g = r5;
        this.h = Collections.unmodifiableList(r5);
        this.d.a(0, r5.size());
        b(r11, r7);
        return;
    L14:
        this.f14145a.b().execute(new AnonymousClass1(this, r4, r5, r6, r7));
    }
}
