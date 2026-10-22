package io.noties.markwon.ext.onetex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final t a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final ExecutorService e;
    public final boolean f;
    public final boolean g;
    public final List<String> h;
    public final String i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final int n;

    public static final class a {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public List<String> f;
        public String g;
        public int h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int l;
        public final t m;

        public a(t r1) {
            this.m = r1;
            this.a = true;
            this.c = true;
            this.f = CollectionsKt.emptyList();
            this.l = 5000;
        }
    }

    public f(a r4) {
        this.a = r4.m;
        this.b = r4.a;
        this.c = r4.b;
        this.d = r4.c;
        LaTexHelper.d.getClass();
        Lazy r0 = LaTexHelper.c;
        KProperty r1 = LaTexHelper.a[0];
        this.e = (ThreadPoolExecutor) r0.getValue();
        this.f = r4.d;
        this.g = r4.e;
        this.h = r4.f;
        this.i = r4.g;
        this.j = r4.h;
        this.k = r4.j;
        this.l = r4.i;
        this.m = r4.k;
        this.n = r4.l;
    }
}
