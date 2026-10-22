package com.ss.android.lark.keyboard.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements l {
    public final Object a;
    public final o.a b;
    public final ConcurrentHashMap<Class<? extends q>, Function2<g, ?, Unit>> c;
    public final ConcurrentHashMap<Class<? extends m>, Function3<g, ?, ?, Unit>> d;
    public final f<q> e;
    public final f<m> f;
    public final List<Function2<g, j, Boolean>> g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final void a() {
        this.b.dispose();
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final void b(Function2<? super g, ? super j, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.g).add(r2);
    }

    public p(Object r2, KeyboardEventCenter$handleFactory$1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.a = r2;
        this.b = r3;
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new f();
        this.f = new f();
        this.g = new ArrayList();
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final <E extends q> void c(Class<E> r2, Function2<? super g, ? super E, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.e.b(r2);
        this.c.put(r2, r3);
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final <S extends m> void d(Class<S> r2, Function3<? super g, ? super S, ? super S, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.f.b(r2);
        this.d.put(r2, r3);
    }
}
