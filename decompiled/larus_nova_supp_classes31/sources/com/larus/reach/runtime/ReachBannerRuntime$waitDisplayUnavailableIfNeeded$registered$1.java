package com.larus.reach.runtime;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class ReachBannerRuntime$waitDisplayUnavailableIfNeeded$registered$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ReachBannerRuntime$waitDisplayUnavailableIfNeeded$registered$1(Object r8) {
        super(0, r8, ReachBannerRuntime.class, "onHostEnvironmentChanged", "onHostEnvironmentChanged()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m60invoke() {
        ReachBannerRuntime r0 = (ReachBannerRuntime) ((CallableReference) this).receiver;
        int r1 = ReachBannerRuntime.j;
        r0.l();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m60invoke();
        return Unit.INSTANCE;
    }
}
