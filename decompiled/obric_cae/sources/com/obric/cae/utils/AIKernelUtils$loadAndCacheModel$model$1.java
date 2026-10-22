package com.obric.cae.utils;

import ae.d;
import be.a;
import ce.e;
import ce.h;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import defpackage.c;
import ge.p;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.obric.cae.utils.AIKernelUtils$loadAndCacheModel$model$1", f = "AIKernelUtils.kt", l = {74}, m = "invokeSuspend")
public final class AIKernelUtils$loadAndCacheModel$model$1 extends h implements p<z, d<? super IBaseModel>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ boolean $useCloud;
    int label;

    public AIKernelUtils$loadAndCacheModel$model$1(String r8, boolean r10, RequestParams r11, d<? super AIKernelUtils$loadAndCacheModel$model$1> r12) {
        this.$biz = r8;
        this.$useCloud = r10;
        this.$params = r11;
        super(2, r12);
    }

    @Override // ce.a
    public final d<j> create(Object r8, d<?> r10) {
        return new AIKernelUtils$loadAndCacheModel$model$1(this.$biz, this.$useCloud, this.$params, r10);
    }

    @Override // ge.p
    public /* bridge */ /* synthetic */ Object invoke(z r8, d<? super IBaseModel> r10) {
        return invoke2(r8, r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        a r10 = a.f3165a;
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        c.m0(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.m0(r8);
        AIKernelManager r12 = AIKernelManager.INSTANCE;
        String r13 = this.$biz;
        boolean r14 = this.$useCloud;
        RequestParams r15 = this.$params;
        this.label = 1;
        r8 = r12.loadPackage(r13, r14, r15, this);
        if (r8 != r10) goto L11;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(z r8, d<? super IBaseModel> r10) {
        return ((AIKernelUtils$loadAndCacheModel$model$1) create(r8, r10)).invokeSuspend(j.f13877a);
    }
}
