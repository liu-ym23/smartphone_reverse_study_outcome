package ta;

import android.os.Bundle;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.config.RequestParams;
import ge.l;
import ge.p;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AbsApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12307a;

    @ce.e(c = "com.obric.aikernel.phx.core.api.CloudBizApi$infer$2", f = "CloudBizApi.kt", l = {20, 20}, m = "invokeSuspend")
    public static final class a extends ce.h implements l<ae.d<? super xa.a<Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f12308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12309b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f12310m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ RequestParams f12311n;

        public a(b r8, RequestParams r10, ae.d<? super a> r11) {
            this.f12310m = r8;
            this.f12311n = r10;
            super(1, r11);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            return new a(this.f12310m, this.f12311n, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super xa.a<Object>> r8) {
            return ((a) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12309b;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            defpackage.c.m0(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            b r12 = this.f12308a;
            defpackage.c.m0(r8);
        L13:
            this.f12308a = null;
            this.f12309b = 2;
            r8 = r12.r((Bundle) r8, this);
            if (r8 != r10) goto L16;
            return r10;
        L10:
            defpackage.c.m0(r8);
            sa.a r13 = sa.a.f12056a;
            r12 = this.f12310m;
            this.f12308a = r12;
            this.f12309b = 1;
            r8 = r13.c(this.f12311n, this);
            if (r8 != r10) goto L13;
            return r10;
        }
    }

    /* JADX INFO: renamed from: ta.b$b, reason: collision with other inner class name */
    @ce.e(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferAsFlow$2", f = "CloudBizApi.kt", l = {25, 25}, m = "invokeSuspend")
    public static final class C0164b extends ce.h implements l<ae.d<? super se.c<? extends xa.a<Object>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f12312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12313b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b f12314m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ RequestParams f12315n;

        public C0164b(b r8, RequestParams r10, ae.d<? super C0164b> r11) {
            this.f12314m = r8;
            this.f12315n = r10;
            super(1, r11);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(ae.d<?> r8) {
            return new C0164b(this.f12314m, this.f12315n, r8);
        }

        @Override // ge.l
        public final Object invoke(ae.d<? super se.c<? extends xa.a<Object>>> r8) {
            return ((C0164b) create(r8)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12313b;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            defpackage.c.m0(r8);
        L16:
            return r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            b r12 = this.f12312a;
            defpackage.c.m0(r8);
        L13:
            this.f12312a = null;
            this.f12313b = 2;
            r8 = r12.v((Bundle) r8, this);
            if (r8 != r10) goto L16;
            return r10;
        L10:
            defpackage.c.m0(r8);
            sa.a r13 = sa.a.f12056a;
            r12 = this.f12314m;
            this.f12312a = r12;
            this.f12313b = 1;
            r8 = r13.c(this.f12315n, this);
            if (r8 != r10) goto L13;
            return r10;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", l = {32, 34}, m = "inference")
    public static final class c extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f12316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f12317b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f12318m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ b f12319n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12320o;

        public c(b r8, ae.d<? super c> r10) {
            this.f12319n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12318m = r8;
            this.f12320o |= Integer.MIN_VALUE;
            return this.f12319n.r(null, this);
        }
    }

    public static final class d extends he.j implements l<Bundle, xa.a<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f12321a = null;

        static {
            f12321a = new d();
        }

        public d() {
            super(1);
        }

        @Override // ge.l
        public final xa.a<Object> invoke(Bundle r10) {
            Bundle r8 = r10;
            he.i.f(r8, "it");
            int r11 = wa.a.f13086a;
            ta.c r12 = ta.c.f12330a;
            he.i.f(r12, "block");
            int r13 = r8.getInt(IdlKeys.ErrorCode, 0);
            String r14 = r8.getString(IdlKeys.ErrorInfo);
            boolean r15 = r8.getBoolean(IdlKeys.IsFinish, true);
            boolean r16 = r8.getBoolean(IdlKeys.IsTaskId, false);
            return new xa.a(r13, r14, r12.invoke(r8, IdlKeys.Result), r15, r16, wa.a.o(r8), r8);
        }
    }

    public static final class e implements se.c<xa.a<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ se.c f12322a;

        public e(se.a r8) {
            this.f12322a = r8;
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.core.api.CloudBizApi", f = "CloudBizApi.kt", l = {45}, m = "inferenceAsFlow")
    public static final class f extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f12323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f12324b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f12325m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ b f12326n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12327o;

        public f(b r8, ae.d<? super f> r10) {
            this.f12326n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f12325m = r8;
            this.f12327o |= Integer.MIN_VALUE;
            return this.f12326n.v(null, this);
        }
    }

    @ce.e(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$binder$1", f = "CloudBizApi.kt", l = {45}, m = "invokeSuspend")
    public static final class g extends ce.h implements p<se.d<? super xa.a<Object>>, ae.d<? super xd.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12329b;

        public g(ae.d<? super g> r8) {
            super(2, r8);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            g r11 = new g(r10);
            r11.f12329b = r8;
            return r11;
        }

        @Override // ge.p
        public final Object invoke(se.d<? super xa.a<Object>> r8, ae.d<? super xd.j> r10) {
            return ((g) create(r8, r10)).invokeSuspend(xd.j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            be.a r10 = be.a.f3165a;
            int r11 = this.f12328a;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            defpackage.c.m0(r8);
        L12:
            return xd.j.f13877a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            se.d r12 = (se.d) this.f12329b;
            xa.a r13 = new xa.a();
            this.f12328a = 1;
            if (r12.e(r13, this) != r10) goto L12;
            return r10;
        }
    }

    public b(String r8) {
        he.i.f(r8, "bizName");
        this.f12307a = r8;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public final Object infer(RequestParams r8, ae.d<? super xa.a<Object>> r10) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().h(r8, null, new a(this, r8, null), r10);
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel
    public final Object inferAsFlow(RequestParams r8, ae.d<? super se.c<xa.a<Object>>> r10) {
        return AIKernelManager.INSTANCE.getInstance$sdk_release().h(r8, null, new C0164b(this, r8, null), r10);
    }

    public final Object r(Bundle r8, ae.d<? super xa.a<Object>> r10) {
        if ((r10 instanceof c) == false) goto L7;
        c r11 = (c) r10;
        int r12 = r11.f12320o;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f12320o = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f12318m;
        be.a r14 = be.a.f3165a;
        int r15 = r11.f12320o;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        defpackage.c.m0(r13);
    L26:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = r11.f12317b;
        b this = r11.f12316a;
        defpackage.c.m0(r13);
    L19:
        AIKBinder r16 = (AIKBinder) r13;
        if (r16 == null) goto L22;
        r11.f12316a = null;
        r11.f12317b = null;
        r11.f12320o = 2;
        r13 = this.k(r16, r8, d.f12321a, r11);
        if (r13 != r14) goto L26;
        return r14;
    L22:
        return new xa.a();
    L16:
        defpackage.c.m0(r13);
        wa.a.j(r8, this.f12307a, "CloudBizApi", "inference");
        r8.putBoolean(IdlKeys.Args_UseCloud, true);
        r11.f12316a = this;
        r11.f12317b = r8;
        r11.f12320o = 1;
        r13 = AIKernelApi.d(AIKernelManager.INSTANCE.getInstance$sdk_release(), r11);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r11 = new c(this, r10);
        goto L8
    }

    public final Object v(Bundle r8, ae.d<? super se.c<xa.a<Object>>> r10) {
        if ((r10 instanceof f) == false) goto L7;
        f r11 = (f) r10;
        int r12 = r11.f12327o;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f12327o = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f12325m;
        be.a r14 = be.a.f3165a;
        int r15 = r11.f12327o;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r8 = r11.f12324b;
        b this = r11.f12323a;
        defpackage.c.m0(r13);
    L17:
        AIKBinder r16 = (AIKBinder) r13;
        if (r16 != null) goto L22;
        return new se.g(new g(null));
    L22:
        return new e(this.i(r16, r8));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r13);
        wa.a.j(r8, this.f12307a, "CloudBizApi", "inferenceAsFlow");
        r8.putBoolean(IdlKeys.Args_UseCloud, true);
        r8.putBoolean(IdlKeys.Args_StreamingCall, true);
        r11.f12323a = this;
        r11.f12324b = r8;
        r11.f12327o = 1;
        r13 = AIKernelApi.d(AIKernelManager.INSTANCE.getInstance$sdk_release(), r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new f(this, r10);
        goto L8
    }
}
