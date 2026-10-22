package com.larus.audio;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h68.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class IFlowAsrClientService$startAsr$1 extends FunctionReferenceImpl implements Function2<String, y58.a, e> {
    public IFlowAsrClientService$startAsr$1(Object r8) {
        super(2, r8, IFlowAsrClientService.class, "createAsrTask", "createAsrTask(Ljava/lang/String;Lcom/larus/audio/audiov3/config/task/sami/asr/AsrConfig;)Lcom/larus/audio/audiov3/task/asr/IAsrTask;", 0);
    }

    public final e invoke(String r2, y58.a r3) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        Intrinsics.checkNotNullParameter(r3, "p1");
        return ((IFlowAsrClientService) ((CallableReference) this).receiver).c(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (y58.a) r2);
    }
}
