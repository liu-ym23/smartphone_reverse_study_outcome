package be;

import ae.d;
import ae.f;
import ge.p;
import he.i;
import he.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ce.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f3171b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3172m;

    public c(d r8, f r10, p r11, Object r12) {
        this.f3171b = r11;
        this.f3172m = r12;
        i.d(r8, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        super(r8, r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        int r10 = this.f3170a;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        this.f3170a = 2;
        defpackage.c.m0(r8);
        return r8;
    L7:
        throw new IllegalStateException("This coroutine had already completed".toString());
    L8:
        this.f3170a = 1;
        defpackage.c.m0(r8);
        p r11 = this.f3171b;
        i.d(r11, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        r.a(2, r11);
        return r11.invoke(this.f3172m, this);
    }
}
