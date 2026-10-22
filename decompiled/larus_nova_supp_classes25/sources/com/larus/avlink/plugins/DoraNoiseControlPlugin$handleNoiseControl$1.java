package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraNoiseControlPlugin$handleNoiseControl$1", f = "DoraNoiseControlPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraNoiseControlPlugin$handleNoiseControl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $ancMode;
    final /* synthetic */ String $mode;
    int label;
    final /* synthetic */ o2 this$0;

    public DoraNoiseControlPlugin$handleNoiseControl$1(int r1, o2 r2, String r3, Continuation<? super DoraNoiseControlPlugin$handleNoiseControl$1> r4) {
        this.$ancMode = r1;
        this.this$0 = r2;
        this.$mode = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraNoiseControlPlugin$handleNoiseControl$1(this.$ancMode, this.this$0, this.$mode, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r8);
        Map<Function1<Boolean, Unit>, k4> r9 = x2.a;
        int r10 = this.$ancMode;
        IDoraService r0 = x2.c();
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        int r11 = r1.A0(r10);
    L10:
        com.larus.avlink.n1.d(this.this$0.f, "handleNoiseControl mode=" + this.$mode + ", ancMode=" + this.$ancMode + ", result=" + r11);
        if (r11 == 0) goto L30;
        o2 r2 = this.this$0;
        r2.getClass();
        if (r11 != 2) goto L15;
        String r12 = "dora_h_denoise_unavailable_switch_cn";
    L19:
        LinkedHashMap r3 = new LinkedHashMap();
        ouc.g0 r4 = ouc.k.c(r12);
        Intrinsics.checkNotNullParameter("notice_starling_key", "key");
        Intrinsics.checkNotNullParameter(r4, "element");
        ouc.i r5 = (ouc.i) r3.put("notice_starling_key", r4);
        ouc.g0 r6 = ouc.k.c("1");
        Intrinsics.checkNotNullParameter("save_to_message_context", "key");
        Intrinsics.checkNotNullParameter(r6, "element");
        ouc.i r7 = (ouc.i) r3.put("save_to_message_context", r6);
        ouc.g0 r13 = ouc.k.c("1");
        Intrinsics.checkNotNullParameter("display_on_screen", "key");
        Intrinsics.checkNotNullParameter(r13, "element");
        ouc.i r14 = (ouc.i) r3.put("display_on_screen", r13);
        String r15 = new ouc.d0(r3).toString();
        id9.d r16 = ((n4) r2.getContext()).j();
        if (r16 == null) goto L22;
        jd9.c r17 = r16.state();
    L24:
        if ((r17 instanceof jd9.c.a) == false) goto L28;
        com.larus.avlink.n1.d(r2.f, "sendNoiseControlFailNotice trigger, value=".concat(r12));
        id9.d r18 = ((n4) r2.getContext()).j();
        if (r18 == null) goto L30;
        r18.p(TriggerMode.CLIENT_SUMMON_NOTICE, r15);
        goto L30
    L28:
        com.larus.avlink.n1.d(r2.f, "sendNoiseControlFailNotice pending, value=".concat(r12));
        ((ArrayList) r2.g).add(TuplesKt.to(TriggerMode.CLIENT_SUMMON_NOTICE, r15));
        goto L30
    L22:
        r17 = null;
        goto L24
    L15:
        if (r11 == 3) goto L17;
        r12 = "dora_h_action_fail_cn";
        goto L19
    L17:
        r12 = "dora_h_denoise_unavailable_already_cn";
    L30:
        return Unit.INSTANCE;
    L9:
        r11 = 1;
        goto L10
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
