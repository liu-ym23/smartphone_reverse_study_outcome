package com.obric.assistant.omnidetailpage.componment;

import android.os.Bundle;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTrackComponent$reportStopClick$1", f = "OmniDetailTrackComponent.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailTrackComponent$reportStopClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OmniDetailTrackComponent this$0;

    public OmniDetailTrackComponent$reportStopClick$1(OmniDetailTrackComponent r1, Continuation<? super OmniDetailTrackComponent$reportStopClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailTrackComponent$reportStopClick$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Message r8 = (Message) r7;
        Bundle r2 = s1a.a.c(this.this$0).getArguments();
        String r3 = "";
        if (r2 == null) goto L15;
        String r4 = r2.getString("task_id");
        if (r4 == null) goto L15;
    L18:
        Bundle r5 = s1a.a.c(this.this$0).getArguments();
        if (r5 == null) goto L24;
        String r6 = r5.getString("o_reference_msg_id");
        if (r6 == null) goto L24;
        r3 = r6;
    L26:
        OmniDetailTrackComponent r9 = this.this$0;
        int r10 = OmniDetailTrackComponent.k;
        String r11 = r9.N2(r8);
        com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
        Bundle r13 = new Bundle();
        r13.putString("source_from", "omni_detail_page");
        r13.putString("instruction_type", r11);
        r13.putString("instruction_id", r4);
        r13.putString("doubao_message_id", r3);
        r13.putString("device_id", r12.getDeviceId());
        Unit r14 = Unit.INSTANCE;
        r12.b("obric_omni_user_stop_click", r13);
        return Unit.INSTANCE;
    L24:
        if (r8 == null) goto L26;
        r3 = com.obric.assistant.utils.k.a(r8);
    L15:
        if (r8 == null) goto L17;
        r4 = com.obric.assistant.utils.k.b(r8);
        goto L18
    L17:
        r4 = "";
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        OmniDetailTrackComponent r15 = this.this$0;
        this.label = 1;
        int r16 = OmniDetailTrackComponent.k;
        r7 = r15.L2(this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
