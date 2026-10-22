package my8;

import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q implements t1a.c {
    public final Bundle a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final String n;
    public final Lazy o;
    public final Lazy p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final Lazy u;
    public String v;
    public final String w;
    public final long x;
    public final Lazy y;
    public String z;

    public static final class a {
    }

    static {
    }

    public q() {
        this(null);
    }

    public final String a() {
        return (String) this.o.getValue();
    }

    public final String b() {
        return (String) this.m.getValue();
    }

    public final String c() {
        return (String) this.p.getValue();
    }

    public final String d() {
        return (String) this.u.getValue();
    }

    public q(Bundle r3) {
        this.a = r3;
        this.b = LazyKt.lazy(new my8.a(this));
        this.c = LazyKt.lazy(new n(this));
        this.d = LazyKt.lazy(new o(this));
        this.e = LazyKt.lazy(new p(this));
        this.f = LazyKt.lazy(new b(this));
        this.g = LazyKt.lazy(new c(this));
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new e());
        this.j = LazyKt.lazy(new f(this));
        this.k = LazyKt.lazy(new g(this));
        this.l = LazyKt.lazy(new h(this));
        this.m = LazyKt.lazy(new i(this));
        this.n = "coco_instruction";
        this.o = LazyKt.lazy(new j(this));
        this.p = LazyKt.lazy(new k(this));
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getString("enter_method");
    L6:
        this.q = r1;
        if (r3 == null) goto L9;
        String r2 = r3.getString("pic_source_message_id");
    L10:
        this.r = r2;
        if (r3 == null) goto L13;
        r0 = r3.getString("source_creation_task_id");
    L13:
        this.s = r0;
        this.t = "image_generate_canvas";
        this.u = LazyKt.lazy(new l(this));
        this.v = "image_generate_page";
        this.w = "pure";
        this.x = System.currentTimeMillis();
        Lazy r4 = LazyKt.lazy(new m(this));
        this.y = r4;
        this.z = (String) r4.getValue();
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
