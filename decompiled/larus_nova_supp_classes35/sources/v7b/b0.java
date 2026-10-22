package v7b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b0 extends s {
    public String j;

    @Override // v7b.s
    public final s h() {
        return new b0(this.j);
    }

    @Override // v7b.s
    public final String o() {
        return "literal=" + this.j;
    }

    public b0() {
    }

    public b0(String r1) {
        this.j = r1;
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        r1.a(this);
    }
}
