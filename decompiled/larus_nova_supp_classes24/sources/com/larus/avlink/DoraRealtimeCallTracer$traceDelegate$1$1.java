package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class DoraRealtimeCallTracer$traceDelegate$1$1 extends FunctionReferenceImpl implements Function0<String> {
    public DoraRealtimeCallTracer$traceDelegate$1$1(Object r8) {
        super(0, r8, DoraRealtimeCallTracer.class, "getDoraScene", "getDoraScene()Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m404invoke() {
        DoraRealtimeCallTracer r0 = (DoraRealtimeCallTracer) ((CallableReference) this).receiver;
        int r1 = DoraRealtimeCallTracer.u;
        return r0.z0();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m404invoke();
    }
}
