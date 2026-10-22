package com.bytedance.forest.preload;

import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.u;
import com.bytedance.forest.model.w;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.utils.PoolType;
import com.bytedance.forest.utils.h;
import com.bytedance.forest.utils.j;
import com.bytedance.forest.utils.n;
import com.bytedance.forest.utils.q;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.lynx.tasm.behavior.ui.utils.p;
import com.lynx.tasm.ui.image.f0;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList f4569c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s6.c f4570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Forest f4571b;

    static {
        f4569c = new CopyOnWriteArrayList();
    }

    public d(Forest r5) {
        this.f4571b = r5;
        f4569c.add(new WeakReference(this));
        this.f4570a = new s6.c(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e a(final com.bytedance.forest.utils.a r10, boolean r11, com.bytedance.forest.utils.d r12, j r13) {
        if (q.b() == false) goto L5;
        com.bytedance.forest.utils.d.c(r12, 5, "PreLoader", null, null, new PreLoader$fetchCacheSync$1(r10), 28);
    L5:
        final CountDownLatch r5 = new CountDownLatch(1);
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        c(r10, r11, r12, r13, new PreLoader$fetchCacheSync$2(r14, r5));
        List r15 = com.bytedance.forest.model.b.f4359a;
        r5.await(20000, TimeUnit.MILLISECONDS);
        return (e) r14.element;
    }

    public final void b(u r5, Scene r10, String r11, String r12, String r13, String r14) {
        ForestPostProcessor r15 = r5.f4426a;
        if (r15 == null) goto L5;
        t r16 = new com.bytedance.forest.postprocessor.e(r15, r10);
    L7:
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        Lazy r17 = r16.f4421v;
        ((Map) r17.getValue()).put("x-forest-preload-from", r13);
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        ((Map) r17.getValue()).put("x-forest-injected-ua", r14);
        r16.C = r5.f4427b;
        boolean r18 = r5.d;
        r16.g = r18;
        r16.f4418r = Boolean.valueOf(r18);
        r16.f4411k = r5.e;
        if (r11 == null) goto L17;
        r16.f4419t = r11;
    L17:
        r16.f4420u = r12;
        d(r5.f4428c, r16);
        return;
    L5:
        r16 = new t(r10);
        goto L7
    }

    public final void c(final com.bytedance.forest.utils.a r23, boolean r24, com.bytedance.forest.utils.d r25, j r26, final Function1 r27) {
        DataSource r5 = null;
        if (r23 != null) goto L6;
        r27.invoke(null);
        return;
    L6:
        s6.c r10 = this.f4570a;
        LinkedList r11 = (LinkedList) r10.f21828b;
        monitor-enter(r11);
        LinkedList r12 = (LinkedList) r10.f21828b;     // Catch: Throwable -> L74
        monitor-enter(r12);     // Catch: Throwable -> L74
        Iterator r13 = ((LinkedList) r10.f21828b).iterator();     // Catch: Throwable -> L16
    L12:
        if (r13.hasNext() == false) goto L18;
        Object r14 = r13.next();     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(((f) r14).f4576c, r23) == false) goto L12;
    L19:
        f r15 = (f) r14;     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L74
        LinkedList r16 = (LinkedList) r10.f21828b;     // Catch: Throwable -> L74
        if (r16 == null) goto L77;
        TypeIntrinsics.asMutableCollection(r16).remove(r15);     // Catch: Throwable -> L74
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L74
        monitor-exit(r11);
        h r18 = r26.b(r23, true);
        if (r18 == null) goto L38;
        n r19 = r18.e;
        if (r19 == null) goto L30;
        PoolType r20 = r19.f4653b;
    L32:
        if (r20 == PoolType.f4582a) goto L35;
        r18 = null;
    L35:
        if (r18 == null) goto L38;
        com.bytedance.forest.utils.d.b(r25, 4, "PreLoader", "fetchCache:hit in-memory cache immediately", true, null, null, 48);
        r27.invoke(new e(r18.d, false));
        return;
    L30:
        r20 = null;
    L38:
        f r21 = this.f4570a.l(r23);
        if (r21 != null) goto L42;
        com.bytedance.forest.utils.d.c(r25, 3, "PreLoader", null, null, new PreLoader$fetchCache$3(r23), 24);
        r27.invoke(null);
        return;
    L42:
        c r22 = r21.d;
        com.bytedance.forest.utils.d.c(r25, 4, "PreLoader", null, null, new PreLoader$fetchCache$4(r23), 24);
        monitor-enter(r22);
    L49:
        th = move-exception;
        throw th;
    L45:
        if (r22.f4566a == null) goto L65;
        SoftReference r28 = r22.f4568c;     // Catch: Throwable -> L49
        if (r28 == null) goto L51;
        r5 = (DataSource) r28.get();     // Catch: Throwable -> L49
    L51:
        StringBuilder r29 = new StringBuilder("fetchCache:hit callbackDelegate response immediately. LynxImage=[finished:");     // Catch: Throwable -> L49
        if (r5 == null) goto L54;
        boolean r30 = ((AbstractDataSource) r5).f();     // Catch: Throwable -> L49
    L55:
        r29.append(r30);     // Catch: Throwable -> L49
        r29.append(" progress:");     // Catch: Throwable -> L49
        if (r5 == null) goto L58;
        Object r31 = Float.valueOf(((AbstractDataSource) r5).c());     // Catch: Throwable -> L49
    L59:
        r29.append(r31);     // Catch: Throwable -> L49
        r29.append(']');     // Catch: Throwable -> L49
        com.bytedance.forest.utils.d.b(r25, 4, "PreLoader", r29.toString(), true, null, null, 48);     // Catch: Throwable -> L49
        w r32 = r22.f4566a;     // Catch: Throwable -> L49
        if (r32 != null) goto L62;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L62:
        r27.invoke(new e(r32, false));     // Catch: Throwable -> L49
        monitor-exit(r22);
        return;
    L58:
        r31 = -1;     // Catch: Throwable -> L49
        goto L59
    L54:
        r30 = false;
        goto L55
    L65:
        if (r24 == false) goto L69;
        com.bytedance.forest.utils.d.b(r25, 4, "PreLoader", "fetchCache:request not finished and ignoring waiting it", true, null, null, 48);     // Catch: Throwable -> L49
        r27.invoke(null);     // Catch: Throwable -> L49
        monitor-exit(r22);
        return;
    L69:
        com.bytedance.forest.utils.d.b(r25, 4, "PreLoader", "fetchCache:waiting for result", true, null, null, 48);     // Catch: Throwable -> L49
        r22.f4567b.add(new PreLoader$fetchCache$$inlined$synchronized$lambda$1(r27));     // Catch: Throwable -> L49
        monitor-exit(r22);
        return;
    L77:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");     // Catch: Throwable -> L74
    L18:
        r14 = null;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    }

    public final void d(String r13, t r14) {
        com.bytedance.forest.utils.a r5 = p.c(r13, r14, this.f4571b);
        if (r5 != null) goto L5;
        f0.g(116, "PreLoader", "can not generate cache key for preload task of ".concat(r13), null);
        return;
    L5:
        if (e(r5) == false) goto L8;
        f0.h("PreLoader", 60, "already has a preload producing or preloaded task for " + r5, false);
        return;
    L8:
        c r10 = new c(r13, r14.H, new PreLoader$preload$delegate$1(this, r5));
        f r11 = new f(r13, r14, r5, r10);
        s6.c r12 = this.f4570a;
        r12.getClass();
        ArrayList r15 = (ArrayList) r12.f21829c;
        monitor-enter(r15);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (((LinkedList) r12.f21828b).size() < 3) goto L29;
        f0.h("PreLoader", 60, "can not producing " + r5 + ", cause " + ((LinkedList) r12.f21828b).size() + " in producing, maxProducingCount=3", false);     // Catch: Throwable -> L27
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r15);
        LinkedList r17 = (LinkedList) r12.f21828b;
        monitor-enter(r17);
    L19:
        th = move-exception;
        throw th;
    L17:
        if (((LinkedList) r12.f21828b).size() < 30) goto L21;
        f0.f(60, "PreLoader", "eliminate " + ((f) ((LinkedList) r12.f21828b).removeFirst()) + " for inserting " + r11);     // Catch: Throwable -> L19
    L21:
        ((LinkedList) r12.f21828b).add(r11);     // Catch: Throwable -> L19
        monitor-exit(r17);
        f0.h("PreLoader", 60, "can not perform preload task for " + r5 + ", maybe producing queue is full, wait for someone finish", false);
        return;
    L29:
        LinkedList r18 = (LinkedList) r12.f21828b;     // Catch: Throwable -> L27
        monitor-enter(r18);     // Catch: Throwable -> L27
        ((LinkedList) r12.f21828b).remove(r11);     // Catch: Throwable -> L37
        monitor-exit(r18);     // Catch: Throwable -> L27
        ((ArrayList) r12.f21829c).add(r11);     // Catch: Throwable -> L27
        monitor-exit(r15);
        r14.f4422w = true;
        f0.h("PreLoader", 60, "start preload for " + r5, false);
        this.f4571b.fetchResourceAsync(r13, r14, r10);
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    }

    public final boolean e(com.bytedance.forest.utils.a r10) {
        if (r10 == null) goto L47;
        Object r5 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
        s6.c r12 = this.f4570a;     // Catch: Throwable -> L21
        r12.getClass();     // Catch: Throwable -> L21
        boolean r13 = true;
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        Object r15 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
    L16:
        if (Result.m130isFailureimpl(r15) == false) goto L18;
        r15 = null;
    L18:
        Boolean r16 = (Boolean) r15;     // Catch: Throwable -> L21
        if (r16 == null) goto L23;
        boolean r17 = r16.booleanValue();     // Catch: Throwable -> L21
    L24:
        if (r17 == true) goto L32;
        j r18 = this.f4571b.getMemoryManager$forest_release();     // Catch: Throwable -> L21
        r18.getClass();     // Catch: Throwable -> L21
        PoolType r19 = PoolType.f4582a;     // Catch: Throwable -> L21
        if (r18.f4645b.f4652a.get(r10) == null) goto L28;
        boolean r20 = true;
    L29:
        if (r20 == true) goto L32;
        r13 = false;
        goto L32
    L28:
        r20 = false;
    L32:
        Object r21 = Result.m124constructorimpl(Boolean.valueOf(r13));     // Catch: Throwable -> L21
    L36:
        if (Result.m130isFailureimpl(r21) == true) goto L39;
        r5 = r21;
    L39:
        Boolean r22 = (Boolean) r5;
        if (r22 != null) goto L42;
        return false;
    L42:
        return r22.booleanValue();
    L23:
        r17 = false;
        goto L24
    L8:
        if (r12.l(r10) == null) goto L10;
        boolean r23 = true;
    L11:
        r15 = Result.m124constructorimpl(Boolean.valueOf(r23));     // Catch: Throwable -> L13
    L10:
        r23 = false;
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L36
    L47:
        return false;
    }
}
