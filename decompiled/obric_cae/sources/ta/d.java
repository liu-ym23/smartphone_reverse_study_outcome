package ta;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import ge.l;
import ge.p;
import pe.z;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbsApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RequestParams f12332b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AIKBinder f12333m;

    @ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$close$1$1", f = "ScriptBizApi.kt", l = {63}, m = "invokeSuspend")
    public static final class a extends ce.h implements p<z, ae.d<? super xd.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f12335b;

        public a(d r8, ae.d<? super a> r10) {
            this.f12335b = r8;
            super(2, r10);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            return new a(this.f12335b, r10);
        }

        @Override // ge.p
        public final Object invoke(z r8, ae.d<? super xd.j> r10) {
            return ((a) create(r8, r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12334a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L12:
            return xd.j.f13877a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            d r12 = this.f12335b;
            AIKBinder r13 = r12.f12333m;
            String r14 = r12.f12331a;
            this.f12334a = 1;
            if (r12.n(r13, r14, this) != r10) goto L12;
            return r10;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi", f = "ScriptBizApi.kt", l = {26}, m = "getBinder")
    public static final class b extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f12336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12337b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ d f12338m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12339n;

        public b(d r8, ae.d<? super b> r10) {
            this.f12338m = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12337b = r8;
            this.f12339n |= Integer.MIN_VALUE;
            return this.f12338m.w(this);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$infer$2", f = "ScriptBizApi.kt", l = {34}, m = "invokeSuspend")
    public static final class c extends ce.h implements l<ae.d<? super xa.a<Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f12341b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ RequestParams f12342m;

        public c(d r8, RequestParams r10, ae.d<? super c> r11) {
            this.f12341b = r8;
            this.f12342m = r10;
            super(1, r11);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            return new c(this.f12341b, this.f12342m, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super xa.a<Object>> r8) {
            return ((c) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12340a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            this.f12340a = 1;
            r8 = d.v(this.f12341b, this.f12342m, this);
            if (r8 != r10) goto L11;
            return r10;
        }
    }

    /* JADX INFO: renamed from: ta.d$d, reason: collision with other inner class name */
    @ce.e(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferAsFlow$2", f = "ScriptBizApi.kt", l = {39}, m = "invokeSuspend")
    public static final class C0165d extends ce.h implements l<ae.d<? super se.c<? extends xa.a<Object>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f12344b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ RequestParams f12345m;

        public C0165d(d r8, RequestParams r10, ae.d<? super C0165d> r11) {
            this.f12344b = r8;
            this.f12345m = r10;
            super(1, r11);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            return new C0165d(this.f12344b, this.f12345m, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super se.c<? extends xa.a<Object>>> r8) {
            return ((C0165d) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12343a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            this.f12343a = 1;
            r8 = d.r(this.f12344b, this.f12345m, this);
            if (r8 != r10) goto L11;
            return r10;
        }
    }

    public d(String r8, RequestParams r10, AIKBinder r11) {
        he.i.f(r8, "bizName");
        he.i.f(r10, "params");
        this.f12331a = r8;
        this.f12332b = r10;
        this.f12333m = r11;
    }

    public static final Object r(d r8, RequestParams r10, ae.d r11) {
        r8.getClass();
        if ((r11 instanceof f) == false) goto L7;
        f r12 = (f) r11;
        int r13 = r12.f12353q;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f12353q = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f12351o;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f12353q;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        AIKBinder r17 = r12.f12350n;
        d r18 = r12.f12349m;
        RequestParams r19 = r12.f12348b;
        d r20 = r12.f12347a;
        defpackage.c.m0(r14);
    L26:
        Bundle r21 = r19.getBackend();
        wa.a.j(r21, r20.f12331a, "ScriptBizApi", "inferenceAsFlow");
        r21.putBoolean(IdlKeys.Args_StreamingCall, true);
        xd.j r22 = xd.j.f13877a;
        return new e(r18.i(r17, (Bundle) r14));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = r12.f12348b;
        r8 = r12.f12347a;
        defpackage.c.m0(r14);
    L19:
        AIKBinder r23 = (AIKBinder) r14;
        if (r23 == null) goto L28;
        sa.a r24 = sa.a.f12056a;
        r12.f12347a = r8;
        r12.f12348b = r10;
        r12.f12349m = r8;
        r12.f12350n = r23;
        r12.f12353q = 2;
        Object r25 = r24.c(r10, r12);
        if (r25 == r15) goto L30;
        r19 = r10;
        r18 = r8;
        r17 = r23;
        r14 = r25;
        r20 = r18;
        goto L26
    L30:
        return r15;
    L28:
        return new se.g(new g(null));
    L16:
        defpackage.c.m0(r14);
        AIKLog.INSTANCE.i("ScriptBizApi", "call inferenceAsFlow " + r8.f12331a);
        r12.f12347a = r8;
        r12.f12348b = r10;
        r12.f12353q = 1;
        r14 = r8.w(r12);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r12 = new f(r8, r11);
        goto L8
    }

    public static final Object v(d r8, RequestParams r10, ae.d r11) {
        r8.getClass();
        if ((r11 instanceof h) == false) goto L7;
        h r12 = (h) r11;
        int r13 = r12.f12362q;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f12362q = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f12360o;
        be.a r15 = be.a.f3165a;
        int r16 = r12.f12362q;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        defpackage.c.m0(r14);
    L32:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        AIKBinder r17 = r12.f12359n;
        d r18 = r12.f12358m;
        RequestParams r19 = r12.f12357b;
        d r20 = r12.f12356a;
        defpackage.c.m0(r14);
    L28:
        wa.a.j(r19.getBackend(), r20.f12331a, "ScriptBizApi", "inferenceTo");
        xd.j r21 = xd.j.f13877a;
        r12.f12356a = null;
        r12.f12357b = null;
        r12.f12358m = null;
        r12.f12359n = null;
        r12.f12362q = 3;
        r14 = r18.k(r17, (Bundle) r14, j.f12364a, r12);
        if (r14 != r15) goto L32;
        return r15;
    L17:
        r10 = r12.f12357b;
        r8 = r12.f12356a;
        defpackage.c.m0(r14);
    L21:
        AIKBinder r22 = (AIKBinder) r14;
        if (r22 == null) goto L33;
        sa.a r23 = sa.a.f12056a;
        r12.f12356a = r8;
        r12.f12357b = r10;
        r12.f12358m = r8;
        r12.f12359n = r22;
        r12.f12362q = 2;
        Object r24 = r23.c(r10, r12);
        if (r24 == r15) goto L35;
        r20 = r8;
        r17 = r22;
        r14 = r24;
        r19 = r10;
        r18 = r20;
        goto L28
    L35:
        return r15;
    L33:
        return new xa.a();
    L18:
        defpackage.c.m0(r14);
        r12.f12356a = r8;
        r12.f12357b = r10;
        r12.f12362q = 1;
        r14 = r8.w(r12);
        if (r14 != r15) goto L21;
        return r15;
    L7:
        r12 = new h(r8, r11);
        goto L8
    }

    @Override // com.obric.aikernel.phx.core.api.AbsApi, com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public final void close() {
        l6.a.J0(new a(this, null));     // Catch: Throwable -> L4
        xd.j r8 = xd.j.f13877a;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        defpackage.c.D(th);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public final Object infer(RequestParams r8, ae.d<? super xa.a<Object>> r10) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().h(r8, this.f12333m, new c(this, r8, null), r10);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public final Object inferAsFlow(RequestParams r8, ae.d<? super se.c<xa.a<Object>>> r10) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().h(r8, this.f12333m, new C0165d(this, r8, null), r10);
    }

    public final Object w(ae.d<? super AIKBinder> r8) {
        if ((r8 instanceof b) == false) goto L7;
        b r10 = (b) r8;
        int r11 = r10.f12339n;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.f12339n = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f12337b;
        l6.a.M();
        be.a r13 = be.a.f3165a;
        int r14 = r10.f12339n;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        d this = r10.f12336a;
        defpackage.c.m0(r12);
    L21:
        if ((r12 instanceof d) == false) goto L23;
        d r15 = (d) r12;
    L24:
        if (r15 == null) goto L27;
        this.f12333m = r15.f12333m;
    L27:
        return this.f12333m;
    L23:
        r15 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r12);
        if (this.f12333m.asBinder().isBinderAlive() == true) goto L27;
        IAIKernelManager r16 = AIKernelManager.INSTANCE.invoke();
        r10.f12336a = this;
        r10.f12339n = 1;
        r12 = IAIKernelManager.b.a(r16, this.f12331a, this.f12332b, r10);
        if (r12 != r13) goto L21;
        return r13;
    L7:
        r10 = new b(this, r8);
        goto L8
    }
}
