package v7b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a extends s {
    @Override // v7b.s
    public final s i() {
        return (a) this.d;
    }

    public a() {
    }

    @Override // v7b.s
    public final void m(s r2) {
        if ((r2 instanceof a) == false) goto L7;
        this.d = r2;
        return;
    L7:
        throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
    }
}
