package com.obric.aikernel.service.foreground;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineForegroundServiceStopScheduler implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineForegroundServiceStopScheduler f5443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l0 f5444b = null;

    static {
        f5443a = new CoroutineForegroundServiceStopScheduler();
        f5444b = m0.a(q2.b(null, 1, null).plus(z0.a()));
    }

    private CoroutineForegroundServiceStopScheduler() {
    }

    public static /* synthetic */ void b(v1 r10) {
        c(r10);
    }

    private static final void c(v1 r10) {
        Intrinsics.checkNotNullParameter(r10, "$job");
        v1.a.a(r10, null, 1, null);
    }

    @Override // com.obric.aikernel.service.foreground.e
    public a a(long r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        final v1 r12 = h.d(f5444b, null, null, new CoroutineForegroundServiceStopScheduler$schedule$job$1(r10, r11, null), 3, null);
        return new b(r12);
    }
}
