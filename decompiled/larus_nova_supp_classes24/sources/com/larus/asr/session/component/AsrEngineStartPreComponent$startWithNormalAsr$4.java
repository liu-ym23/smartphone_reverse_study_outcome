package com.larus.asr.session.component;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$4 extends FunctionReferenceImpl implements Function4<String, String, Long, Integer, Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$4(Object r8) {
        super(4, r8, b.class, "onFailure", "onFailure(Ljava/lang/String;Ljava/lang/String;JI)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10) {
        invoke((String) r7, (String) r8, ((Number) r9).longValue(), ((Number) r10).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r8, String r9, long r10, int r12) {
        Intrinsics.checkNotNullParameter(r8, IP0SubProcess.P0_PROCESS_NAME);
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((b) ((CallableReference) this).receiver).c(r8, r9, r10, r12);
    }
}
