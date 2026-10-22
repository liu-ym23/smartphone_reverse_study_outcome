package f1;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f1.a<g> f8838d = null;

    static class a extends f1.a<g> {
        a() {
        }

        @Override // f1.a
        protected /* bridge */ /* synthetic */ g a(Object[] r10) {
            return c(r10);
        }

        protected g c(Object... r10) {
            return new f();
        }
    }

    static {
        f8838d = new a();
    }

    public n() {
    }

    public static g B() {
        return f8838d.b(new Object[0]);
    }

    public void C(int r10, List<String> r11, String r12, Object... r13) {
        z(r10, 0, r11, null, r12, r13);
    }

    @Override // f1.g
    public void a(int r10, String r11, Object... r12) {
        C(r10, null, r11, r12);
    }

    @Override // f1.g
    public void b(int r10, List<String> r11, String r12, Object... r13) {
        r(r10, r11, r12, null, r13);
    }

    @Override // f1.g
    public void c(String r10, Object... r11) {
        g(null, r10, r11);
    }

    @Override // f1.g
    public void d(int r10, String r11, Object... r12) {
        n(r10, null, r11, r12);
    }

    @Override // f1.g
    public void f(String r10, Object... r11) {
        j(r10, null, r11);
    }

    @Override // f1.g
    public void g(List<String> r10, String r11, Object... r12) {
        l(0, r10, r11, r12);
    }

    @Override // f1.g
    public void h(int r10, String r11, Object... r12) {
        k(r10, null, r11, r12);
    }

    @Override // f1.g
    public void i(String r10, Object... r11) {
        o(null, r10, r11);
    }

    @Override // f1.g
    public void j(String r10, Throwable r11, Object... r12) {
        u(null, r10, r11, r12);
    }

    @Override // f1.g
    public void k(int r10, List<String> r11, String r12, Object... r13) {
        z(r10, 1, r11, null, r12, r13);
    }

    @Override // f1.g
    public void l(int r10, List<String> r11, String r12, Object... r13) {
        z(r10, 3, r11, null, r12, r13);
    }

    @Override // f1.g
    public void m(List<String> r10, String r11, Object... r12) {
        u(r10, r11, null, r12);
    }

    @Override // f1.g
    public void n(int r10, List<String> r11, String r12, Object... r13) {
        z(r10, 2, r11, null, r12, r13);
    }

    @Override // f1.g
    public void o(List<String> r10, String r11, Object... r12) {
        k(0, r10, r11, r12);
    }

    @Override // f1.g
    public void p(String r10, Object... r11) {
        t(null, r10, r11);
    }

    @Override // f1.g
    public void q(int r10, String r11, Object... r12) {
        b(r10, null, r11, r12);
    }

    @Override // f1.g
    public void r(int r10, List<String> r11, String r12, Throwable r13, Object... r14) {
        z(r10, 4, r11, r13, r12, r14);
    }

    @Override // f1.g
    public void s(int r10, String r11, Object... r12) {
        l(r10, null, r11, r12);
    }

    @Override // f1.g
    public void t(List<String> r10, String r11, Object... r12) {
        n(0, r10, r11, r12);
    }

    @Override // f1.g
    public void u(List<String> r10, String r11, Throwable r12, Object... r13) {
        r(0, r10, r11, r12, r13);
    }

    @Override // f1.g
    public void v(int r10, String r11, Throwable r12, Object... r13) {
        r(r10, null, r11, r12, r13);
    }
}
