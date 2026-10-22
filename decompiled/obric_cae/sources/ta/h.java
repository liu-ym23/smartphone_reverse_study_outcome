package ta;

import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.sdk.config.RequestParams;

/* JADX INFO: loaded from: classes.dex */
@ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", l = {43, 44, 44}, m = "inferenceTo")
public final class h extends ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f12356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RequestParams f12357b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f12358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AIKBinder f12359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f12360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d f12361p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12362q;

    public h(d r8, ae.d<? super h> r10) {
        this.f12361p = r8;
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        this.f12360o = r8;
        this.f12362q |= Integer.MIN_VALUE;
        return d.v(this.f12361p, null, this);
    }
}
