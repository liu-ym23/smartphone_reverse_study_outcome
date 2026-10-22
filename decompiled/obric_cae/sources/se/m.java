package se;

/* JADX INFO: loaded from: classes2.dex */
@ce.e(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
public final class m extends ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f12131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public te.g f12132b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f12133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ n<Object> f12134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12135o;

    public m(n<Object> r8, ae.d<? super m> r10) {
        this.f12134n = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12133m = r8;
        this.f12135o |= Integer.MIN_VALUE;
        return this.f12134n.a(this);
    }
}
