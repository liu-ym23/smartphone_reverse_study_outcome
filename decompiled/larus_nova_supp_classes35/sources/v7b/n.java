package v7b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n extends s {
    public String j;
    public String k;

    @Override // v7b.s
    public final s h() {
        return new n(this.j, this.k);
    }

    @Override // v7b.s
    public final String o() {
        return "destination=" + this.j + ", title=" + this.k;
    }

    public n() {
    }

    @Override // v7b.s
    public final void c(f0 r1) {
        r1.a(this);
    }

    public n(String r1, String r2) {
        this.j = r1;
        this.k = r2;
    }
}
