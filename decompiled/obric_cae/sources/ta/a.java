package ta;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.core.api.AbsApi;
import ge.p;
import pe.e1;

/* JADX INFO: loaded from: classes.dex */
@ce.e(c = "com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1", f = "AbsApi.kt", l = {44}, m = "invokeSuspend")
public final class a extends ce.h implements p<re.e<? super Bundle>, ae.d<? super xd.j>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12301b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AIKBinder f12302m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AbsApi f12303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bundle f12304o;

    /* JADX INFO: renamed from: ta.a$a, reason: collision with other inner class name */
    public static final class C0163a extends he.j implements ge.a<xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e1 f12305a;

        public C0163a(e1 r8) {
            this.f12305a = r8;
            super(0);
        }

        @Override // ge.a
        public final xd.j f() {
            e1 r8 = this.f12305a;
            if (r8 == null) goto L6;
            r8.H(null);
        L6:
            return xd.j.f13877a;
        }
    }

    public static final class b extends he.j implements ge.a<xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ re.e<Bundle> f12306a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(re.e<? super Bundle> r8) {
            this.f12306a = r8;
            super(0);
        }

        @Override // ge.a
        public final xd.j f() {
            wa.a.l(new Bundle(), 113, "binder died", 4);
            re.e<Bundle> r8 = this.f12306a;
            r8.a();
            re.f.a.a(r8);
            return xd.j.f13877a;
        }
    }

    public a(AIKBinder r8, AbsApi r10, Bundle r11, ae.d<? super a> r12) {
        this.f12302m = r8;
        this.f12303n = r10;
        this.f12304o = r11;
        super(2, r12);
    }

    @Override // ce.a
    public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
        AbsApi r11 = this.f12303n;
        Bundle r12 = this.f12304o;
        a r13 = new a(this.f12302m, r11, r12, r10);
        r13.f12301b = r8;
        return r13;
    }

    @Override // ge.p
    public final Object invoke(re.e<? super Bundle> r8, ae.d<? super xd.j> r10) {
        return ((a) create(r8, r10)).invokeSuspend(xd.j.f13877a);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        l6.a.M();
        be.a r10 = be.a.f3165a;
        int r11 = this.f12300a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        defpackage.c.m0(r8);
    L15:
        return xd.j.f13877a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        defpackage.c.m0(r8);
        re.e r12 = (re.e) this.f12301b;
        AIKLog.INSTANCE.i("AbsApi", "start callModelAsFlow...");
        ua.b r13 = ua.b.f12525a;
        ae.f r14 = r12.d();
        b r15 = new b(r12);
        AIKBinder r16 = this.f12302m;
        e1 r17 = r13.b(r14, r16, r15);
        if (AbsApi.a(this.f12303n, r16, this.f12304o, r12) == true) goto L11;
        e1.a.a(r17);
        goto L15
    L11:
        C0163a r18 = new C0163a(r17);
        this.f12300a = 1;
        if (re.d.a(r12, r18, this) != r10) goto L15;
        return r10;
    }
}
