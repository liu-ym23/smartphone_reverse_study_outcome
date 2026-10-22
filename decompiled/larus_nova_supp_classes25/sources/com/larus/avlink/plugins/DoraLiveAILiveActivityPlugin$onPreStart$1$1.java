package com.larus.avlink.plugins;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraLiveAILiveActivityPlugin$onPreStart$1$1", f = "DoraLiveAILiveActivityPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiveAILiveActivityPlugin$onPreStart$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ DoraLiveAILiveActivityPlugin this$0;

    public DoraLiveAILiveActivityPlugin$onPreStart$1$1(DoraLiveAILiveActivityPlugin r1, Continuation<? super DoraLiveAILiveActivityPlugin$onPreStart$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraLiveAILiveActivityPlugin$onPreStart$1$1 r0 = new DoraLiveAILiveActivityPlugin$onPreStart$1$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        if (r5 != 1) goto L7;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L23;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L23;
        r7.C0(true);
    L23:
        this.this$0.getClass();
        com.larus.avlink.n1.d("DoraLiveActivityPlugin", "call mute");
    L25:
        return Unit.INSTANCE;
    L7:
        if (r5 != 2) goto L9;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L17;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L17;
        r9.C0(false);
    L17:
        this.this$0.getClass();
        com.larus.avlink.n1.d("DoraLiveActivityPlugin", "call unmute");
        goto L25
    L9:
        if (r5 != 3) goto L25;
        ((n4) this.this$0.getContext()).d(false, 11, DoraCallStateCode.DOUBAO_CMD_5);
        goto L25
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
