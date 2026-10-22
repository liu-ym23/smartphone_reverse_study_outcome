package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class j extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f2512a;

    class a implements c<Object, com.bytedance.retrofit2.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f2513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f2514b;

        a(j r10, Type r11, Executor r12) {
            this.f2513a = r11;
            this.f2514b = r12;
        }

        @Override // com.bytedance.retrofit2.c
        public Type a() {
            return this.f2513a;
        }

        @Override // com.bytedance.retrofit2.c
        public /* bridge */ /* synthetic */ com.bytedance.retrofit2.b<?> b(com.bytedance.retrofit2.b<Object> r10) {
            return c(r10);
        }

        public com.bytedance.retrofit2.b<Object> c(com.bytedance.retrofit2.b<Object> r10) {
            Executor r11 = this.f2514b;
            if (r11 != null) goto L6;
            return r10;
        L6:
            return new b(r11, r10);
        }
    }

    static final class b<T> implements com.bytedance.retrofit2.b<T>, m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f2515c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final com.bytedance.retrofit2.b<T> f2516g;

        class a implements k<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f2517a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f2518b;

            /* JADX INFO: renamed from: com.bytedance.retrofit2.j$b$a$a, reason: collision with other inner class name */
            class RunnableC0068a implements Runnable {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ a0 f2519c;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ a f2520g;

                RunnableC0068a(a r10, a0 r11) {
                    this.f2520g = r10;
                    this.f2519c = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f2520g.f2518b.f2516g.isCanceled() == false) goto L5;
                    a r10 = this.f2520g;
                    r10.f2517a.b(r10.f2518b, new IOException("Canceled"));
                    return;
                L5:
                    a r11 = this.f2520g;
                    r11.f2517a.a(r11.f2518b, this.f2519c);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.retrofit2.j$b$a$b, reason: collision with other inner class name */
            class RunnableC0069b implements Runnable {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Throwable f2521c;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ a f2522g;

                RunnableC0069b(a r10, Throwable r11) {
                    this.f2522g = r10;
                    this.f2521c = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a r10 = this.f2522g;
                    r10.f2517a.b(r10.f2518b, this.f2521c);
                }
            }

            a(b r10, e r11) {
                this.f2518b = r10;
                this.f2517a = r11;
            }

            @Override // com.bytedance.retrofit2.e
            public void a(com.bytedance.retrofit2.b<T> r10, a0<T> r11) {
                this.f2518b.f2515c.execute(new RunnableC0068a(this, r11));
            }

            @Override // com.bytedance.retrofit2.e
            public void b(com.bytedance.retrofit2.b<T> r10, Throwable r11) {
                this.f2518b.f2515c.execute(new RunnableC0069b(this, r11));
            }

            @Override // com.bytedance.retrofit2.k
            public void c(r r10) {
                e r11 = this.f2517a;
                if ((r11 instanceof k) == false) goto L6;
                ((k) r11).c(r10);
                return;
            }

            @Override // com.bytedance.retrofit2.k
            public void d(com.bytedance.retrofit2.b<T> r10, a0<T> r11) {
                e r12 = this.f2517a;
                if ((r12 instanceof k) == false) goto L6;
                ((k) r12).d(r10, r11);
                return;
            }
        }

        b(Executor r10, com.bytedance.retrofit2.b<T> r11) {
            this.f2515c = r10;
            this.f2516g = r11;
        }

        @Override // com.bytedance.retrofit2.b
        public n4.c a() {
            return this.f2516g.a();
        }

        @Override // com.bytedance.retrofit2.b
        public void c(e<T> r10) {
            c0.a(r10, "callback == null");
            this.f2516g.c(new a(this, r10));
        }

        @Override // com.bytedance.retrofit2.b
        public void cancel() {
            this.f2516g.cancel();
        }

        @Override // com.bytedance.retrofit2.b
        public com.bytedance.retrofit2.b<T> clone() {
            return new b(this.f2515c, this.f2516g.clone());
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m11clone() {
            return clone();
        }

        @Override // com.bytedance.retrofit2.b
        public a0 execute() {
            return this.f2516g.execute();
        }

        @Override // com.bytedance.retrofit2.b
        public boolean isCanceled() {
            return this.f2516g.isCanceled();
        }
    }

    j(Executor r10) {
        this.f2512a = r10;
    }

    @Override // com.bytedance.retrofit2.c.a
    public c<?, ?> a(Type r10, Annotation[] r11, t r12) {
        Executor r13 = null;
        if (c.a.b(r10) == com.bytedance.retrofit2.b.class) goto L6;
        return null;
    L6:
        if ((r10 instanceof ParameterizedType) == false) goto L14;
        Type r14 = c0.f(r10);
        if (c0.n(r11, x.class) == true) goto L12;
        r13 = this.f2512a;
    L12:
        return new a(this, r14, r13);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
