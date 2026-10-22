package com.larus.asr.session;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.IFlowAsrClientService;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class QuicInterpretAsrSessionV2$createComponents$3 extends FunctionReferenceImpl implements Function1<com.larus.asr.session.component.f0, Unit> {
    public QuicInterpretAsrSessionV2$createComponents$3(Object r8) {
        super(1, r8, QuicInterpretAsrSessionV2.class, "startQuicInterpret", "startQuicInterpret(Lcom/larus/asr/session/component/AsrSessionContext;)V", 0);
    }

    public final void invoke(com.larus.asr.session.component.f0 r33) {
        Intrinsics.checkNotNullParameter(r33, IP0SubProcess.P0_PROCESS_NAME);
        final QuicInterpretAsrSessionV2 r1 = (QuicInterpretAsrSessionV2) ((CallableReference) this).receiver;
        int r2 = QuicInterpretAsrSessionV2.n;
        r1.a.onAsrStart(r1.b);
        if (com.larus.platform.api.f2.a.useNewAsrTasksV2() == false) goto L5;
        QuicInterpretAsrSessionV2.QuicInterpretTransportRoute r3 = QuicInterpretAsrSessionV2.QuicInterpretTransportRoute.FLOW_ASR_CLIENT;
    L6:
        r1.k = r3;
        int r4 = QuicInterpretAsrSessionV2.b.a[r3.ordinal()];
        if (r4 != 1) goto L9;
        final xa8.d r5 = r1.n();
        if (r5 != null) goto L22;
        FLogger.a.i("QuicInterpretAsrSessionV2", "[startViaFlowAsrClient][" + r1.b + "] simultaneousTranslatorAbility is null");
        return;
    L22:
        String r8 = r1.b;
        b68.b r6 = b68.b.a;
        String r7 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        r6.getClass();
        String r9 = b68.b.c("/record/asr/pcm/", r7);
        if (r9 != null) goto L25;
        String r11 = "";
    L26:
        wc9.e r10 = r1.a.h();
        String r12 = null;
        if (r10 == null) goto L29;
        String r13 = r10.a;
    L30:
        if (r13 != null) goto L32;
        String r14 = "";
    L33:
        BotModel r15 = r1.a.i();
        if (r15 == null) goto L36;
        r12 = r15.getBotId();
    L36:
        if (r12 != null) goto L38;
        String r26 = "";
    L39:
        final y58.a r16 = new y58.a(null, r8, r14, null, r11, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, r26, new y58.d(0), 0, "QUIC_INTERPRET", 16777193);
        final com.larus.asr.task.a r17 = new com.larus.asr.task.a();
        FLogger.a.i("QuicInterpretAsrSessionV2", "simultaneousTranslatorAbility startSession (FlowAsrClient)");
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r19 = IFlowAsrClientService.a.a();
        r19.d(new k1());
        r19.a(r1.b, r16, new l1(r17), new m1(r5, r1, r16), null);
        return;
    L38:
        r26 = r12;
        goto L39
    L32:
        r14 = r13;
        goto L33
    L29:
        r13 = null;
        goto L30
    L25:
        r11 = r9;
        goto L26
    L9:
        if (r4 != 2) goto L11;
        xa8.d r20 = r1.n();
        if (r20 == null) goto L18;
        int r21 = r1.m();
        r20.gq(r21);
        FLogger.a.i("QuicInterpretAsrSessionV2", "simultaneousTranslatorAbility startSession (legacy)");
        r20.VJ(r1.m);
        r20.lw(r21);
        return;
    L18:
        FLogger.a.i("QuicInterpretAsrSessionV2", "[startLegacy][" + r1.b + "] simultaneousTranslatorAbility is null");
        return;
    L11:
        if (r4 != 3) goto L14;
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r3 = QuicInterpretAsrSessionV2.QuicInterpretTransportRoute.LEGACY;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.asr.session.component.f0) r1);
        return Unit.INSTANCE;
    }
}
