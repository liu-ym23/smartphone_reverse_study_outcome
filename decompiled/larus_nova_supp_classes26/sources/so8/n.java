package so8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ k b;

    public /* synthetic */ n(r r1, k r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r0 = this.a;
        r0.c(this.b, "passive hide");
        r0.b(r0.b);
    }
}
