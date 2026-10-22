package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DelayTaskDispatcher$sendMonitorData$1 extends Lambda implements Function0<Unit> {
    public static final DelayTaskDispatcher$sendMonitorData$1 INSTANCE = null;

    static {
        INSTANCE = new DelayTaskDispatcher$sendMonitorData$1();
    }

    DelayTaskDispatcher$sendMonitorData$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.lego.init.monitor.a.f2112c.f();
    }
}
