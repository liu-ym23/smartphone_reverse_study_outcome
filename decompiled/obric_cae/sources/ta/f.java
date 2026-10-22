package ta;

import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.sdk.config.RequestParams;

/* JADX INFO: loaded from: classes.dex */
@ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", l = {51, 52}, m = "inferenceAsFlow")
public final class f extends ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f12347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RequestParams f12348b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f12349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AIKBinder f12350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f12351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d f12352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12353q;

    public f(d r8, ae.d<? super f> r10) {
        this.f12352p = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12351o = r8;
        this.f12353q |= Integer.MIN_VALUE;
        return d.r(this.f12352p, null, this);
    }
}
