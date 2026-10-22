package com.obric.cae.utils;

import ae.d;
import be.a;
import ce.e;
import ce.h;
import defpackage.c;
import ge.l;
import ge.p;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.obric.cae.utils.AIKernelJavaBridge$executeBackground$1$1", f = "AIKernelJavaBridge.kt", l = {105}, m = "invokeSuspend")
public final class AIKernelJavaBridge$executeBackground$1$1 extends h implements p<z, d<? super j>, Object> {
    final /* synthetic */ l<d<? super j>, Object> $block;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AIKernelJavaBridge$executeBackground$1$1(l<? super d<? super j>, ? extends Object> r8, d<? super AIKernelJavaBridge$executeBackground$1$1> r10) {
        this.$block = r8;
        super(2, r10);
    }

    @Override // ce.a
    public final d<j> create(Object r8, d<?> r10) {
        return new AIKernelJavaBridge$executeBackground$1$1(this.$block, r10);
    }

    @Override // ge.p
    public /* bridge */ /* synthetic */ Object invoke(z r8, d<? super j> r10) {
        return invoke2(r8, r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        a r10 = a.f3165a;
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        c.m0(r8);
    L12:
        return j.f13877a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        c.m0(r8);
        l<d<? super j>, Object> r12 = this.$block;
        this.label = 1;
        if (r12.invoke(this) != r10) goto L12;
        return r10;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(z r8, d<? super j> r10) {
        return ((AIKernelJavaBridge$executeBackground$1$1) create(r8, r10)).invokeSuspend(j.f13877a);
    }
}
