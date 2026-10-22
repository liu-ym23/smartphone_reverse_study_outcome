package t3;

import com.bytedance.memory.shrink.BaseType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class i extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputStream f12943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f12944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ByteArrayOutputStream f12946e;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12947a = null;

        static {
            int[] r10 = new int[BaseType.values().length];
            f12947a = r10;
            r10[BaseType.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f12947a[BaseType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f12947a[BaseType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f12947a[BaseType.CHAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f12947a[BaseType.SHORT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f12947a[BaseType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f12947a[BaseType.INT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f12947a[BaseType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f12947a[BaseType.LONG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    private class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f12949b;

        b(i r10, int r11, int r12, long r13) {
            this.f12949b = r10;
            super(null);
            this.f12948a = r11;
        }

        private void n(ByteArrayInputStream r10, ByteArrayOutputStream r11, BaseType r12) {
            switch(a.f12947a[r12.ordinal()]) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L5;
                case 9: goto L5;
                default: goto L15;
            };
        L5:
            j.b(r10);
            j.l(r11, 0);
            return;
        L6:
            j.a(r10);
            j.k(r11, 0);
            return;
        L7:
            j.c(r10);
            j.m(r11, 0);
            return;
        L8:
            r10.read();
            r11.write(0);
            return;
        L9:
            j.o(r11, j.e(r10, i.j(this.f12949b)));
            return;
        }

        @Override // t3.e
        public void a() {
            i.l(this.f12949b).write(this.f12948a);     // Catch: Throwable -> L4
            i.l(this.f12949b).write(i.i(this.f12949b).toByteArray());     // Catch: Throwable -> L4
            i.i(this.f12949b).reset();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void b(int r10, f r11) {
            i.i(this.f12949b).write(r10);     // Catch: Throwable -> L6
            i.i(this.f12949b).write(r11.a());     // Catch: Throwable -> L6
            if (r10 != 1) goto L11;
            j.j(i.i(this.f12949b), i.j(this.f12949b));     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void c(f r10, int r11, f r12, f r13, int r14, d[] r15, d[] r16) {
            i.i(this.f12949b).write(32);     // Catch: Throwable -> L14
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L14
            i.i(this.f12949b).write(r12.a());     // Catch: Throwable -> L14
            i.i(this.f12949b).write(r13.a());     // Catch: Throwable -> L14
            j.j(i.i(this.f12949b), i.j(this.f12949b) << 1);     // Catch: Throwable -> L14
            j.m(i.i(this.f12949b), r14);     // Catch: Throwable -> L14
            int r17 = 0;
            j.m(i.i(this.f12949b), 0);     // Catch: Throwable -> L14
            j.m(i.i(this.f12949b), r15.length);     // Catch: Throwable -> L14
            int r18 = r15.length;     // Catch: Throwable -> L14
            int r19 = 0;
        L3:
            if (r19 >= r18) goto L9;
            d r20 = r15[r19];     // Catch: Throwable -> L14
            j.o(i.i(this.f12949b), r20.f12937b);     // Catch: Throwable -> L14
            i.i(this.f12949b).write(r20.f12936a);     // Catch: Throwable -> L14
            if (i.k(this.f12949b) == null) goto L7;
            j.n(i.i(this.f12949b), r20.f12938c);     // Catch: Throwable -> L14
        L8:
            r19 = r19 + 1;     // Catch: Throwable -> L14
            goto L3
        L7:
            j.q(i.i(this.f12949b), r20.f12938c);     // Catch: Throwable -> L14
            goto L8
        L9:
            j.m(i.i(this.f12949b), r16.length);     // Catch: Throwable -> L14
            int r21 = r16.length;     // Catch: Throwable -> L14
        L10:
            if (r17 >= r21) goto L13;
            d r22 = r16[r17];     // Catch: Throwable -> L14
            j.o(i.i(this.f12949b), r22.f12937b);     // Catch: Throwable -> L14
            i.i(this.f12949b).write(r22.f12936a);     // Catch: Throwable -> L14
            r17 = r17 + 1;
            goto L10
        L13:
            return;
        L14:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void d(int r10, f r11) {
            i.i(this.f12949b).write(254);     // Catch: Throwable -> L4
            j.k(i.i(this.f12949b), r10);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r11.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void e(f r10, int r11, f r12, byte[] r13) {
            i.i(this.f12949b).write(33);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r12.a());     // Catch: Throwable -> L4
            j.k(i.i(this.f12949b), r13.length);     // Catch: Throwable -> L4
            byte[] r14 = o(r10, r12, r13);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r14);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void f(f r10, int r11, int r12) {
            i.i(this.f12949b).write(3);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void g(f r10, int r11, int r12) {
            i.i(this.f12949b).write(2);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void h(f r10, int r11, int r12) {
            i.i(this.f12949b).write(142);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void i(f r10, int r11) {
            i.i(this.f12949b).write(4);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void j(f r10, int r11, int r12, f r13, byte[] r14) {
            i.i(this.f12949b).write(34);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            j.k(i.i(this.f12949b), r12);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r13.a());     // Catch: Throwable -> L4
            int r15 = r12 * i.j(this.f12949b);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r14, 0, r15);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void k(int r10, f r11, int r12, int r13, int r14, byte[] r15) {
            i.i(this.f12949b).write(r10);     // Catch: Throwable -> L8
            i.i(this.f12949b).write(r11.a());     // Catch: Throwable -> L8
            j.k(i.i(this.f12949b), r13);     // Catch: Throwable -> L8
            i.i(this.f12949b).write(r14);     // Catch: Throwable -> L8
            BaseType r16 = BaseType.getType(r14);     // Catch: Throwable -> L8
            if (r16 != BaseType.CHAR) goto L5;
            return;
        L5:
            if (r16 == BaseType.BYTE) goto L14;
            j.j(i.i(this.f12949b), r13 * BaseType.getType(r14).getSize(i.j(this.f12949b)));     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void l(f r10, int r11) {
            i.i(this.f12949b).write(6);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // t3.e
        public void m(f r10, int r11, int r12) {
            i.i(this.f12949b).write(8);     // Catch: Throwable -> L4
            i.i(this.f12949b).write(r10.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        public byte[] o(f r10, f r11, byte[] r12) {
            if (i.k(this.f12949b) != null) goto L5;
            return r12;
        L5:
            ByteArrayInputStream r13 = new ByteArrayInputStream(r12);
            ByteArrayOutputStream r14 = new ByteArrayOutputStream();
            HashMap<f, t3.a> r15 = i.k(this.f12949b).k();
        L6:
            t3.a r16 = r15.get(r11);
            if (r16 == null) goto L22;
            int r17 = 0;
            if (r16.f12925a.equals(i.k(this.f12949b).f12932f) == true) goto L13;
            d[] r18 = r16.f12927c;     // Catch: IOException -> L18
            int r19 = r18.length;     // Catch: IOException -> L18
        L11:
            if (r17 >= r19) goto L17;
            n(r13, r14, BaseType.getType(r18[r17].f12936a));     // Catch: IOException -> L18
            r17 = r17 + 1;     // Catch: IOException -> L18
        L17:
            r15 = i.k(this.f12949b).k();
            r11 = r16.f12926b;
            goto L6
        L13:
            d[] r20 = r16.f12927c;     // Catch: IOException -> L18
            int r21 = r20.length;     // Catch: IOException -> L18
            int r22 = 0;
        L14:
            if (r22 >= r21) goto L16;
            j.q(r14, j.h(r13, BaseType.getType(r20[r22].f12936a), i.j(this.f12949b)));     // Catch: IOException -> L18
            r22 = r22 + 1;     // Catch: IOException -> L18
            goto L14
        L16:
            p3.c.c("find a activity skip erase " + r16.f12925a, new Object[0]);     // Catch: IOException -> L18
        L18:
            e = move-exception;
            throw new RuntimeException(e);
        L22:
            return r14.toByteArray();
        }
    }

    public i(OutputStream r10, c r11) {
        super(null);
        this.f12945d = 0;
        this.f12946e = new ByteArrayOutputStream();
        this.f12943b = r10;
        this.f12944c = r11;
    }

    static /* synthetic */ ByteArrayOutputStream i(i r10) {
        return r10.f12946e;
    }

    static /* synthetic */ int j(i r10) {
        return r10.f12945d;
    }

    static /* synthetic */ c k(i r10) {
        return r10.f12944c;
    }

    static /* synthetic */ OutputStream l(i r10) {
        return r10.f12943b;
    }

    @Override // t3.h
    public void a() {
        this.f12943b.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // t3.h
    public void b(String r10, int r11, long r12) {
        this.f12945d = r11;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // t3.h
    public /* bridge */ /* synthetic */ e c(int r10, int r11, long r12) {
        return m(r10, r11, r12);
    }

    @Override // t3.h
    public void d(int r10, f r11, int r12, f r13, int r14, long r15) {
        this.f12943b.write(2);     // Catch: Throwable -> L4
        this.f12943b.write(r11.a());     // Catch: Throwable -> L4
        this.f12943b.write(r13.a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // t3.h
    public void e(f r10, f r11, f r12, f r13, int r14, int r15, int r16, long r17) {
    }

    @Override // t3.h
    public void f(int r10, int r11, f[] r12, int r13, long r14) {
    }

    @Override // t3.h
    public void g(f r10, String r11, int r12, long r13) {
        this.f12943b.write(1);     // Catch: Throwable -> L4
        j.m(this.f12943b, (int) r13);     // Catch: Throwable -> L4
        this.f12943b.write(r10.a());     // Catch: Throwable -> L4
        j.p(this.f12943b, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // t3.h
    public void h(int r10, int r11, long r12, byte[] r13) {
        if (r10 == 44) goto L10;
        return;
    L10:
        this.f12943b.write(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public b m(int r10, int r11, long r12) {
        return new b(this, r10, r11, r12);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
