package com.obric.aikernel.phx.core.api;

import ae.d;
import ae.f;
import android.os.Bundle;
import ce.e;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.l;
import he.i;
import he.j;
import he.o;
import pe.e1;
import pe.g;
import pe.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsApi implements IBaseModel {

    @e(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", l = {122}, m = "callModelAsResponse")
    public static final class a<T> extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AIKBinder f5215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l f5216b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public f f5217m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public o f5218n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public /* synthetic */ Object f5219o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ AbsApi f5220p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f5221q;

        public a(AbsApi r8, d<? super a> r10) {
            this.f5220p = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5219o = r8;
            this.f5221q |= Integer.MIN_VALUE;
            return this.f5220p.k(null, null, null, this);
        }
    }

    public static final class b extends j implements ge.a<xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g<Bundle> f5222a;

        public b(h r8) {
            this.f5222a = r8;
            super(0);
        }

        @Override // ge.a
        public final xd.j f() {
            Bundle r8 = new Bundle();
            wa.a.l(r8, 113, "binder died", 4);
            defpackage.c.c0(r8, this.f5222a);
            return xd.j.f13877a;
        }
    }

    @e(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", l = {109}, m = "unload")
    public static final class c extends ce.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AIKBinder f5224b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f5225m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AbsApi f5226n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f5227o;

        public c(AbsApi r8, d<? super c> r10) {
            this.f5226n = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.f5225m = r8;
            this.f5227o |= Integer.MIN_VALUE;
            return this.f5226n.n(null, null, this);
        }
    }

    public static final boolean a(AbsApi r8, AIKBinder r10, Bundle r11, final re.e r12) {
        r8.getClass();
        AIKLog.INSTANCE.i("AbsApi", "start callModelAsFlow " + r11.getString(IdlKeys.MethodName));
        r10.o0(r11, new AbsApi$sendFlowCallMethod$1(r12));     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        wa.a.k(th.getMessage(), new Bundle());
        r12.a();
        re.f.a.a(r12);
        return false;
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
    }

    public final se.a i(AIKBinder r8, Bundle r10) {
        i.f(r8, "binder");
        i.f(r10, QesdkUtils.TAGS.JSON_TAG_ARGS);
        return new se.a(new ta.a(r8, this, r10, null));
    }

    public final <T> Object k(AIKBinder r8, Bundle r10, l<? super Bundle, ? extends T> r11, d<? super T> r12) {
        if ((r12 instanceof a) == false) goto L7;
        a r13 = (a) r12;
        int r14 = r13.f5221q;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f5221q = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f5219o;
        be.a r16 = be.a.f3165a;
        int r17 = r13.f5221q;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        o r18 = r13.f5218n;
        r11 = r13.f5216b;
        defpackage.c.m0(r15);
    L23:
        Bundle r19 = (Bundle) r15;
        e1 r20 = (e1) r18.f8064a;
        if (r20 == null) goto L27;
        r20.H(null);
    L27:
        return r11.invoke(r19);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r15);
        AIKLog.INSTANCE.v("AbsApi", "start callModelAsResponse " + r10.getString(IdlKeys.MethodName) + ", traceid=" + r10.getString(IdlKeys.Args_TraceId));
        f r21 = r13.getContext();
        o r22 = new o();
        r13.f5215a = r8;
        r13.getClass();
        r13.f5216b = r11;
        r13.f5217m = r21;
        r13.f5218n = r22;
        r13.f5221q = 1;
        final h r23 = new h(1, l6.a.b0(r13));
        r23.q();
        r22.f8064a = (T) ua.b.f12525a.b(r21, r8, new b(r23));     // Catch: Throwable -> L17
        r8.o0(r10, new AbsApi$callModelAsResponse$responseBundle$1$2(r23));     // Catch: Throwable -> L17
    L19:
        r15 = r23.p();
        be.a r24 = be.a.f3165a;
        if (r15 != r16) goto L22;
        return r16;
    L22:
        r18 = r22;
    L17:
        th = move-exception;
        Bundle r25 = new Bundle();
        wa.a.k(th.getMessage(), r25);
        defpackage.c.c0(r25, r23);
    L7:
        r13 = new a(this, r12);
        goto L8
    }

    public final Object n(AIKBinder r10, final String r11, d<? super xd.j> r12) {
        if ((r12 instanceof c) == false) goto L7;
        c r8 = (c) r12;
        int r13 = r8.f5227o;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r8.f5227o = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r8.f5225m;
        be.a r15 = be.a.f3165a;
        int r16 = r8.f5227o;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = r8.f5224b;
        r11 = r8.f5223a;
        defpackage.c.m0(r14);
    L17:
        Bundle r17 = (Bundle) r14;
        wa.a.a(r17, r11, IdlKeys.Method_UnloadPackage, IdlKeys.Call_Type_CallBiz, null, "AbsApi", "unload", 200);
        r10.o0(r17, new AbsApi$unload$2(r11));
        return xd.j.f13877a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        defpackage.c.m0(r14);
        sa.a r18 = sa.a.f12056a;
        RequestParams r19 = new RequestParams(null, null, 3, null);
        r8.f5223a = r11;
        r8.f5224b = r10;
        r8.f5227o = 1;
        r14 = r18.c(r19, r8);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r8 = new c(this, r12);
        goto L8
    }
}
