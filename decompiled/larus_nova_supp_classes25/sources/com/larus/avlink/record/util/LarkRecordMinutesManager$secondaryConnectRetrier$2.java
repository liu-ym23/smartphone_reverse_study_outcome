package com.larus.avlink.record.util;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.minutes.api.IMinutesService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/avlink/record/util/RetryDecision;", "ctx", "Lcom/larus/avlink/record/util/RetryContext;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$secondaryConnectRetrier$2", f = "LarkRecordMinutesManager.kt", i = {}, l = {DoraCallStateCode.CLIENT_INTENT}, m = "invokeSuspend", n = {}, s = {})
public final class LarkRecordMinutesManager$secondaryConnectRetrier$2 extends SuspendLambda implements Function2<s, Continuation<? super RetryDecision>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$secondaryConnectRetrier$2(Continuation<? super LarkRecordMinutesManager$secondaryConnectRetrier$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        LarkRecordMinutesManager$secondaryConnectRetrier$2 r0 = new LarkRecordMinutesManager$secondaryConnectRetrier$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(s r1, Continuation<? super RetryDecision> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((s) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        return r20;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        s r12 = (s) this.L$0;
        LarkRecordMinutesManager r4 = LarkRecordMinutesManager.a;
        this.label = 1;
        String r7 = LarkRecordMinutesManager.C;
        String r9 = LarkRecordMinutesManager.k;
        r4.getClass();
        Integer r10 = LarkRecordMinutesManager.k();
        String r11 = LarkRecordMinutesManager.H;
        String r5 = LarkRecordMinutesManager.A;
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
        n1.e("LarkRecordMinutesManager", "GRecord lark retry skipped, no offline recordingId");
        Object r8 = RetryDecision.RETRY;
    L47:
        if (r8 != r1) goto L50;
        return r1;
    L50:
        return r8;
    L18:
        IMinutesService r14 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r14 != null) goto L21;
        n1.b("LarkRecordMinutesManager", "GRecord lark minutes service is null");
        r8 = RetryDecision.RETRY;
        goto L47
    L21:
        long r13 = System.currentTimeMillis();
        kotlinx.coroutines.j r15 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r15.C();
        String r16 = null;
        if (r11 != null) goto L24;
    L29:
        String r17 = null;
    L31:
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        String r18 = LarkRecordMinutesManager.K;
        if (r18 != null) goto L36;
    L41:
        if (r16 != null) goto L43;
        r16 = "";
    L43:
        r14.G0(r5, LarkRecordMinutesManager.e(r17, r16), new i(r13, r7, r5, r9, r10, r11, r12, r15));
        Object r0 = r15.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(this);
    L46:
        r8 = r0;
        goto L47
    L36:
        if (r18.length() > 0) goto L39;
        r3 = false;
    L39:
        if (r3 == false) goto L41;
        r16 = r18;
        goto L41
    L24:
        if (r11.length() <= 0) goto L26;
        boolean r19 = true;
    L27:
        if (r19 == false) goto L29;
        r17 = r11;
        goto L31
    L26:
        r19 = false;
        goto L27
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
        goto L16
    }
}
