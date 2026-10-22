package ta;

import ge.p;

/* JADX INFO: loaded from: classes.dex */
@ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$binder$1", f = "ScriptBizApi.kt", l = {51}, m = "invokeSuspend")
public final class g extends ce.h implements p<se.d<? super xa.a<Object>>, ae.d<? super xd.j>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12355b;

    public g(ae.d<? super g> r8) {
        super(2, r8);
    }

    @Override // ce.a
    public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
        g r11 = new g(r10);
        r11.f12355b = r8;
        return r11;
    }

    @Override // ge.p
    public final Object invoke(se.d<? super xa.a<Object>> r8, ae.d<? super xd.j> r10) {
        return ((g) create(r8, r10)).invokeSuspend(xd.j.f13877a);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        be.a r10 = be.a.f3165a;
        int r11 = this.f12354a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        defpackage.c.m0(r8);
    L12:
        return xd.j.f13877a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        defpackage.c.m0(r8);
        se.d r12 = (se.d) this.f12355b;
        xa.a r13 = new xa.a();
        this.f12354a = 1;
        if (r12.e(r13, this) != r10) goto L12;
        return r10;
    }
}
