package bt1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements ct1.f {
    public final /* synthetic */ b a;

    @Override // ct1.f
    public final void onFinish() {
        this.a.e();
    }

    public d(b r1) {
        this.a = r1;
    }

    @Override // ct1.f
    public final void onTick(long r2) {
        a r0 = this.a.j;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
