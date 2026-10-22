package com.ss.android.lark.chatbase.model;

import java.util.List;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class c<K, T, PageData, L extends List<T>> {
    public final d a;

    public static class a<T> implements hya.a<T> {
        public final T a;

        public a(T r1) {
            this.a = r1;
        }
    }

    public static abstract class b<T> implements hya.a<T> {
        public b() {
        }

        public abstract f5b.b b(Object r1);

        public final T a(T r1) {
            if (r1 != null) goto L4;
            return null;
        L4:
            return (T) b(r1);
        }
    }

    public abstract void b(x4b.a r1);

    public abstract L d();

    public abstract void e(x4b.a r1);

    public abstract void f(x4b.a r1);

    public final void c() {
        this.a.f();
    }

    public c(d r1) {
        this.a = r1;
    }
}
