package com.bytedance.android.livesdk.interactivity;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends com.bytedance.android.livesdk.interactivity.a {
    public final PriorityQueue<v> a;
    public boolean b;
    public b c;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            v r6 = (v) r4;
            v r7 = (v) r5;
            Intrinsics.checkNotNullParameter(r6, "widget1");
            Intrinsics.checkNotNullParameter(r7, "widget2");
            return (r7.f > r6.f ? 1 : (r7.f == r6.f ? 0 : -1));
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ v b;
        public final /* synthetic */ ViewGroup c;

        public b(Function2 r1, v r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void c() {
        MainThreadPostUtils.d(this.c);
        this.b = false;
        this.a.clear();
    }

    public w() {
        this.a = new PriorityQueue(10, a.a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void a(v r2) {
        Intrinsics.checkNotNullParameter(r2, "wrapWidget");
        this.a.add(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void b(v r2) {
        Intrinsics.checkNotNullParameter(r2, "wrapWidget");
        this.a.remove(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void d(v r3, ViewGroup r4, Function2<? super v, ? super ViewGroup, Unit> r5, Function2<? super v, ? super ViewGroup, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "wrapWidget");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "startAction");
        Intrinsics.checkNotNullParameter(r6, "endAction");
        v r0 = (v) CollectionsKt.firstOrNull(this.a);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == false) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(r0, r3)) == true) goto L13;
        r5.invoke(r3, r4);
        this.b = true;
        b r7 = new b(r6, r3, r4);
        this.c = r7;
        MainThreadPostUtils.c(r7, r3.g);
        return;
    }
}
