package com.obric.cae.utils;

import ae.d;
import be.a;
import ce.e;
import ce.h;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import defpackage.c;
import ge.p;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.obric.cae.utils.AIKernelUtils$loadAndCacheModel$pkgResult$1", f = "AIKernelUtils.kt", l = {55}, m = "invokeSuspend")
public final class AIKernelUtils$loadAndCacheModel$pkgResult$1 extends h implements p<z, d<? super xd.e<? extends PackageResource>>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ RequestParams $params;
    int label;

    public AIKernelUtils$loadAndCacheModel$pkgResult$1(String r8, RequestParams r10, d<? super AIKernelUtils$loadAndCacheModel$pkgResult$1> r11) {
        this.$biz = r8;
        this.$params = r10;
        super(2, r11);
    }

    @Override // ce.a
    public final d<j> create(Object r8, d<?> r10) {
        return new AIKernelUtils$loadAndCacheModel$pkgResult$1(this.$biz, this.$params, r10);
    }

    @Override // ge.p
    public /* bridge */ /* synthetic */ Object invoke(z r8, d<? super xd.e<? extends PackageResource>> r10) {
        return invoke2(r8, r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        a r10 = a.f3165a;
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        c.m0(r8);
        Object r12 = ((xd.e) r8).f13869a;
    L12:
        return new xd.e(r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.m0(r8);
        AIKernelManager r13 = AIKernelManager.INSTANCE;
        String r14 = this.$biz;
        RequestParams r15 = this.$params;
        this.label = 1;
        r12 = r13.mo9getPackage0E7RQCE(r14, r15, this);
        if (r12 != r10) goto L12;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(z r8, d<? super xd.e<PackageResource>> r10) {
        return ((AIKernelUtils$loadAndCacheModel$pkgResult$1) create(r8, r10)).invokeSuspend(j.f13877a);
    }
}
