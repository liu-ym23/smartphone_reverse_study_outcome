package be;

import ae.d;
import ce.g;
import ge.p;
import he.i;
import he.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f3168b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3169m;

    public b(Object r8, d r10, p r11) {
        this.f3168b = r11;
        this.f3169m = r8;
        i.d(r10, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        super(r10);
    }

    @Override // ce.a
    public final Object invokeSuspend(Object r8) {
        int r10 = this.f3167a;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        this.f3167a = 2;
        defpackage.c.m0(r8);
        return r8;
    L7:
        throw new IllegalStateException("This coroutine had already completed".toString());
    L8:
        this.f3167a = 1;
        defpackage.c.m0(r8);
        p r11 = this.f3168b;
        i.d(r11, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        r.a(2, r11);
        return r11.invoke(this.f3169m, this);
    }
}
