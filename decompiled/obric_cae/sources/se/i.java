package se;

import pe.e1;

/* JADX INFO: loaded from: classes2.dex */
@ce.e(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
public final class i extends ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f12118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f12119b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f12120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e1 f12121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f12122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f12123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ j<Object> f12124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12125r;

    public i(j<Object> r8, ae.d<? super i> r10) {
        this.f12124q = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12123p = r8;
        this.f12125r |= Integer.MIN_VALUE;
        return this.f12124q.a(null, this);
    }
}
