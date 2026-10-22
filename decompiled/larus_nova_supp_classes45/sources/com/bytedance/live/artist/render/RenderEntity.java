package com.bytedance.live.artist.render;

import com.bytedance.live.artist.core.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RenderEntity {
    public final Map<Class<?>, nf6.a> a;
    public final List<e> b;
    public final f c;
    public final b d;
    public final b e;
    public int f;
    public long g;
    public EntityState h;
    public mf6.a i;
    public final com.bytedance.live.artist.core.b j;
    public final a k;

    public final void c() {
        d(RenderEntity$destroy$1.INSTANCE);
        ((ArrayList) this.b).clear();
        ((HashMap) this.a).clear();
        f r0 = this.c;
        r0.a = 0.0f;
        r0.b = 0.0f;
        b r1 = this.d;
        r1.a = 0.0f;
        r1.b = 0.0f;
        g(EntityState.Destroyed);
    }

    public final void b(nf6.a r2) {
        a(r2.getClass(), r2);
    }

    public final void d(Function1<? super e, Unit> r3) {
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.invoke(r0.next());
        goto L4
    }

    public final <T extends nf6.a> T e(Class<T> r2) {
        Object r3 = ((HashMap) this.a).get(r2);
        if ((r3 instanceof nf6.a) == true) goto L6;
        r3 = null;
    L6:
        return (T) r3;
    }

    public final void g(EntityState r2) {
        this.h = r2;
        this.k.a(this, r2);
    }

    public RenderEntity(com.bytedance.live.artist.core.b r1, EntityManager r2) {
        this.j = r1;
        this.k = r2;
        this.a = new HashMap();
        this.b = new ArrayList();
        this.c = new f();
        this.d = new b();
        this.e = new b();
        this.f = 1;
        this.h = EntityState.Init;
    }

    public static void f(RenderEntity r2, Function1 r3) {
        if (r2.h != EntityState.Rendering) goto L9;
        Iterator r4 = ((ArrayList) r2.b).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        e r0 = (e) r4.next();
        Unit r1 = (Unit) r3.invoke(r0);
        r0.f();
        goto L7
    L11:
        return;
    }

    public final void a(Class<?> r2, nf6.a r3) {
        ((HashMap) this.a).put(r2, r3);
    }
}
