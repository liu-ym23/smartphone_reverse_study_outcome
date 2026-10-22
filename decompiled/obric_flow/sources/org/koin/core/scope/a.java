package org.koin.core.scope;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.instance.b;
import org.koin.core.instance.c;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wu.a f21023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21025c;
    public final org.koin.core.a d;
    public final ArrayList e;
    public Object f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThreadLocal f21026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21027i;

    public a(wu.a r5, String r10, boolean r11, org.koin.core.a r12) {
        Intrinsics.checkNotNullParameter(r5, "scopeQualifier");
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r12, "_koin");
        this.f21023a = r5;
        this.f21024b = r10;
        this.f21025c = r11;
        this.d = r12;
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.f21026h = new ThreadLocal();
    }

    public final void a() {
        Function0<Unit> r5 = new Scope$close$1(this);
        Intrinsics.checkNotNullParameter(this, "lock");
        Intrinsics.checkNotNullParameter(r5, "block");
        monitor-enter(this);
        r5.invoke();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final Object b(Function0 r10, KClass r11, wu.a r12) {
        Intrinsics.checkNotNullParameter(r11, "clazz");
        org.koin.core.a r5 = this.d;
        um.a r13 = r5.f21001c;
        Level r14 = Level.DEBUG;
        if (r13.r(r14) == false) goto L11;
        if (r12 == null) goto L8;
        String r15 = " with qualifier '" + r12 + '\'';
        if (r15 == null) goto L8;
    L9:
        r5.f21001c.p(r14, "|- '" + yu.a.a(r11) + '\'' + r15 + " ...");
        long r16 = System.nanoTime();
        Object r17 = d(r10, r11, r12);
        double r18 = ((double) (System.nanoTime() - r16)) / 1000000.0d;
        r5.f21001c.p(r14, "|- '" + yu.a.a(r11) + "' in " + r18 + " ms");
        return r17;
    L8:
        r15 = "";
        goto L9
    L11:
        return d(r10, r11, r12);
    }

    public final Object c(Function0 r5, KClass r10, wu.a r11) {
        org.koin.core.a r12 = this.d;
        Intrinsics.checkNotNullParameter(r10, "clazz");
    L11:
        return b(r5, r10, r11);
    L6:
        r12.f21001c.o("* Scope closed - no instance found for " + yu.a.a(r10) + " on scope " + this);
        return null;
    L5:
        r12.f21001c.o("* No instance found for type '" + yu.a.a(r10) + "' on scope '" + this + '\'');
        return null;
    }

    public final Object d(Function0 r11, KClass r12, wu.a r13) {
        if (this.f21027i == true) goto L63;
        Object r5 = null;
        if (r11 == null) goto L7;
        final vu.a r10 = (vu.a) r11.invoke();
    L8:
        ThreadLocal r14 = this.f21026h;
        org.koin.core.a r15 = this.d;
        if (r10 == null) goto L17;
        um.a r16 = r15.f21001c;
        Level r17 = Level.DEBUG;
        Function0<String> r18 = new Scope$resolveInstance$1(r10);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "lvl");
        Intrinsics.checkNotNullParameter(r18, "msg");
        if (r16.r(r17) == false) goto L13;
        r16.p(r17, r18.invoke());
    L13:
        ArrayDeque r19 = (ArrayDeque) r14.get();
        if (r19 != null) goto L16;
        r19 = new ArrayDeque();
        r14.set(r19);
    L16:
        r19.addFirst(r10);
    L18:
        b r20 = new b(r15.f21001c, this, r10);
        i4.a r21 = r15.f21000b;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r12, "clazz");
        wu.a r22 = this.f21023a;
        Intrinsics.checkNotNullParameter(r22, "scopeQualifier");
        Intrinsics.checkNotNullParameter(r20, "instanceContext");
        Intrinsics.checkNotNullParameter(r12, "clazz");
        Intrinsics.checkNotNullParameter(r22, "scopeQualifier");
        c r23 = (c) ((ConcurrentHashMap) r21.d).get(xq.b.r(r12, r13, r22));
        if (r23 == null) goto L21;
        Object r24 = r23.b(r20);
    L22:
        if (r24 != null) goto L24;
        r24 = null;
    L24:
        if (r24 != null) goto L59;
        r15.f21001c.o("|- ? t:'" + yu.a.a(r12) + "' - q:'" + r13 + "' look in injected parameters");
        ArrayDeque r25 = (ArrayDeque) r14.get();
        if (r25 == null) goto L30;
        vu.a r26 = (vu.a) r25.firstOrNull();
        if (r26 == null) goto L30;
        r24 = r26.b(r12);
    L31:
        if (r24 != null) goto L59;
        if (this.f21025c == true) goto L41;
        r15.f21001c.o("|- ? t:'" + yu.a.a(r12) + "' - q:'" + r13 + "' look at scope source");
        Object r27 = this.f;
        if (r27 == null) goto L41;
        if (r12.isInstance(r27) == false) goto L41;
        if (r13 != null) goto L41;
        r24 = this.f;
        if (r24 == null) goto L41;
    L42:
        if (r24 != null) goto L59;
        r15.f21001c.o("|- ? t:'" + yu.a.a(r12) + "' - q:'" + r13 + "' look in other scopes");
        Iterator r110 = this.e.iterator();
    L45:
        if (r110.hasNext() == false) goto L48;
        r5 = ((a) r110.next()).c(r11, r12, r13);
        if (r5 == null) goto L45;
    L48:
        r24 = r5;
        if (r24 != null) goto L59;
        if (r11 == null) goto L53;
        r14.remove();
        r15.f21001c.o("|- << parameters");
    L53:
        if (r13 == null) goto L56;
        String r111 = " and qualifier '" + r13 + '\'';
        if (r111 == null) goto L56;
    L58:
        throw new NoBeanDefFoundException("No definition found for type '" + yu.a.a(r12) + '\'' + r111 + ". Check your Modules configuration and add missing type and/or qualifier!");
    L56:
        r111 = "";
    L41:
        r24 = null;
    L30:
        r24 = null;
    L59:
        if (r19 == null) goto L61;
        r15.f21001c.o("| << parameters");
        r19.removeFirstOrNull();
    L61:
        return r24;
    L21:
        r24 = null;
        goto L22
    L17:
        r19 = null;
        goto L18
    L7:
        r10 = null;
        goto L8
    L63:
        throw new ClosedScopeException(j0.q(new StringBuilder("Scope '"), this.f21024b, "' is closed"));
    }

    public final String toString() {
        return j0.q(new StringBuilder("['"), this.f21024b, "']");
    }
}
