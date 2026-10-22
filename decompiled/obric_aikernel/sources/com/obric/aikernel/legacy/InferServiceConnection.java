package com.obric.aikernel.legacy;

import android.content.Context;
import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class InferServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f4488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<Continuation<? super com.obric.aikernel.a>, Unit> f4489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f4490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private r0<? extends com.obric.aikernel.a> f4491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.obric.aikernel.a f4492f;

    public static final /* synthetic */ Context a(InferServiceConnection r10) {
        return r10.f4487a;
    }

    public static final /* synthetic */ l0 b(InferServiceConnection r10) {
        return r10.f4488b;
    }

    public static final /* synthetic */ Function1 c(InferServiceConnection r10) {
        return r10.f4489c;
    }

    public static final /* synthetic */ r0 d(InferServiceConnection r10) {
        return r10.f4491e;
    }

    public static final /* synthetic */ void e(InferServiceConnection r10, ServiceConnection r11) {
        r10.f4490d = r11;
    }

    public static final /* synthetic */ void f(InferServiceConnection r10, r0 r11) {
        r10.f4491e = r11;
    }

    private final Object g(long r10, Continuation<? super Unit> r11) {
        return TimeoutKt.d(r10, new InferServiceConnection$getBinder$2(this, null), r11);
    }

    static /* synthetic */ Object h(InferServiceConnection r10, long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 1000;
    L6:
        return r10.g(r11, r12);
    }

    public final void i(com.obric.aikernel.a r10) {
        this.f4492f = r10;
    }
}
