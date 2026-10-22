package com.larus.avlink.record.util;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$stopVUIRecord$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LarkRecordMinutesManager$stopVUIRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $endSource;
    int label;

    public LarkRecordMinutesManager$stopVUIRecord$1(String r1, Continuation<? super LarkRecordMinutesManager$stopVUIRecord$1> r2) {
        this.$endSource = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LarkRecordMinutesManager$stopVUIRecord$1(this.$endSource, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r4);
        String r5 = this.$endSource;
        if (Intrinsics.areEqual(r5, "command_stop") == false) goto L12;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L24;
        SessionService r7 = r6.d();
        if (r7 == null) goto L24;
        r7.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM, false);
    L24:
        return Unit.INSTANCE;
    L12:
        if (Intrinsics.areEqual(r5, "out_of_time") == false) goto L18;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L24;
        SessionService r9 = r8.d();
        if (r9 == null) goto L24;
        r9.y(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, false);
        goto L24
    L18:
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L24;
        SessionService r11 = r10.d();
        if (r11 == null) goto L24;
        Boxing.boxInt(r11.b(3, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI, false));
        goto L24
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
