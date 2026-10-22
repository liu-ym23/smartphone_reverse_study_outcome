package bolts;

/* JADX INFO: loaded from: classes.dex */
public class h<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<TResult> f113a;

    public h() {
        this.f113a = new g();
    }

    public g<TResult> a() {
        return this.f113a;
    }

    public boolean a(Exception r1) {
        return this.f113a.a(r1);
    }

    public boolean a(TResult r1) {
        return this.f113a.b(r1);
    }

    public void b(Exception r1) {
        if (a(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the error on a completed task.");
    }

    public boolean b() {
        return this.f113a.e();
    }

    public void c() {
        if (b() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot cancel a completed task.");
    }

    public void setResult(TResult r1) {
        if (a(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }
}
