package com.obric.aikernel.phx.sdk.api;

import ae.d;
import android.os.Bundle;
import android.os.IBinder;
import ce.e;
import ce.h;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import defpackage.c;
import ge.l;
import ge.p;
import he.i;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
@e(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$2$1$1", f = "AIKernelApi.kt", l = {}, m = "invokeSuspend")
public final class a extends h implements p<z, d<? super j>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestParams f5324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5325b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Throwable f5326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ AIKBinder f5327n;

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.a$a, reason: collision with other inner class name */
    public static final class C0052a extends he.j implements l<RequestParams, j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestParams f5328a;

        public C0052a(RequestParams r8) {
            this.f5328a = r8;
            super(1);
        }

        @Override // ge.l
        public final j invoke(RequestParams r8) {
            RequestParams r10 = r8;
            i.f(r10, "$this$$receiver");
            Bundle r11 = r10.getBackend();
            RequestParams r12 = this.f5328a;
            r11.putLong(IdlKeys.Args_ReqTime, r12.getBackend().getLong(IdlKeys.Args_ReqTime));
            r10.getBackend().putString(IdlKeys.Args_TraceId, r12.getBackend().getString(IdlKeys.Args_TraceId));
            return j.f13877a;
        }
    }

    public a(RequestParams r8, int r10, Throwable r11, AIKBinder r12, d<? super a> r13) {
        this.f5324a = r8;
        this.f5325b = r10;
        this.f5326m = r11;
        this.f5327n = r12;
        super(2, r13);
    }

    @Override // ce.a
    public final d<j> create(Object r8, d<?> r10) {
        return new a(this.f5324a, this.f5325b, this.f5326m, this.f5327n, r10);
    }

    @Override // ge.p
    public final Object invoke(z r8, d<? super j> r10) {
        return ((a) create(r8, r10)).invokeSuspend(j.f13877a);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        l6.a.M();
        c.m0(r8);
        AIKLog r10 = AIKLog.INSTANCE;
        StringBuilder r11 = new StringBuilder("[SDK] client req ");
        RequestParams r12 = this.f5324a;
        r11.append(r12.getTraceIdStr());
        r11.append(" competed by event ");
        int r13 = this.f5325b;
        r11.append(r13);
        r11.append(" cause: ");
        r11.append(this.f5326m);
        r10.i("AIKernelApi", r11.toString());
        IBinder r14 = this.f5327n.asBinder();
        i.e(r14, "binder.asBinder()");
        c.U(r14, new RequestParams(null, new C0052a(r12), 1, null), r13);
        return j.f13877a;
    }
}
