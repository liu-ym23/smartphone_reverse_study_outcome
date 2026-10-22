package c4;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3351d = null;

    public static class a extends b {
        public a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            return new f();
        }
    }

    static {
        f3351d = new a();
    }

    public static g u() {
        return (g) f3351d.b(new Object[0]);
    }

    @Override // c4.g
    public final void a(int r8, List<String> r10, String r11, Object... r12) {
        m(r8, r10, r11, null, r12);
    }

    @Override // c4.g
    public final void b(String r8, Object... r10) {
        f(0, null, r8, r10);
    }

    @Override // c4.g
    public final void c(String r8, Object... r10) {
        i(null, r8, null, r10);
    }

    @Override // c4.g
    public final void d(int r8, String r10, Object... r11) {
        l(r8, null, r10, r11);
    }

    @Override // c4.g
    public final void e(String r8, Object... r10) {
        l(0, null, r8, r10);
    }

    @Override // c4.g
    public final void f(int r8, List<String> r10, String r11, Object... r12) {
        r(r8, 3, r10, null, r11, r12);
    }

    @Override // c4.g
    public final void g(int r8, List<String> r10, String r11, Object... r12) {
        r(r8, 2, r10, null, r11, r12);
    }

    @Override // c4.g
    public final void h(List<String> r8, String r10, Object... r11) {
        l(0, r8, r10, r11);
    }

    @Override // c4.g
    public final void i(List<String> r8, String r10, Throwable r11, Object... r12) {
        m(0, r8, r10, r11, r12);
    }

    @Override // c4.g
    public final void j(List<String> r8, String r10, Object... r11) {
        f(0, r8, r10, r11);
    }

    @Override // c4.g
    public final void k(Throwable r8, int r10, String r11, Object... r12) {
        m(r10, null, r11, r8, r12);
    }

    @Override // c4.g
    public final void l(int r8, List<String> r10, String r11, Object... r12) {
        r(r8, 1, r10, null, r11, r12);
    }

    @Override // c4.g
    public final void m(int r8, List<String> r10, String r11, Throwable r12, Object... r13) {
        r(r8, 4, r10, r12, r11, r13);
    }

    @Override // c4.g
    public final void n(int r8, String r10, Object... r11) {
        f(r8, null, r10, r11);
    }

    @Override // c4.g
    public final void o(Throwable r8, String r10, Object... r11) {
        i(null, r10, r8, r11);
    }

    @Override // c4.g
    public final void p(List<String> r8, String r10, Object... r11) {
        g(0, r8, r10, r11);
    }

    public final void t(String r8, Object... r10) {
        a(5, null, r8, r10);
    }
}
