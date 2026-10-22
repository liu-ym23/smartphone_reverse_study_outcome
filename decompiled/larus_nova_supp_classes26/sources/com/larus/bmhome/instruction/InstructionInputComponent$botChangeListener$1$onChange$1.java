package com.larus.bmhome.instruction;

import android.os.SystemClock;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$botChangeListener$1$onChange$1", f = "InstructionInputComponent.kt", i = {0, 0, 0, 1}, l = {1054, 1061}, m = "invokeSuspend", n = {"it", "startTime", "isColdStart", "it"}, s = {"L$2", "J$0", "Z$0", "L$2"})
final class InstructionInputComponent$botChangeListener$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $new;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public InstructionInputComponent$botChangeListener$1$onChange$1(InstructionInputComponent r1, BotModel r2, Continuation<? super InstructionInputComponent$botChangeListener$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$new = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$botChangeListener$1$onChange$1(this.this$0, this.$new, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        wc9.e r3 = (wc9.e) this.L$2;
        BotModel r4 = (BotModel) this.L$1;
        InstructionInputComponent r5 = (InstructionInputComponent) this.L$0;
        ResultKt.throwOnFailure(r19);
    L35:
        String r6 = InstructionInputComponent.Z2;
        r5.getClass();
        if (ic8.n.v(r3) == false) goto L41;
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L41;
        r7.C0();
        hc9.d r8 = hc9.d.a;
        String r9 = r3.a;
    L41:
        if (ic8.n.D(r3) == false) goto L58;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        va8.f0 r10 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r5, r5)).getAbility(va8.f0.class);
        if (r10 == null) goto L55;
        if (r10.R() == false) goto L47;
    L50:
        boolean r11 = true;
    L52:
        if (r11 != true) goto L55;
        boolean r12 = true;
    L56:
        if (r12 == false) goto L58;
        boolean r13 = true;
    L59:
        if (r13 == false) goto L62;
        Intrinsics.checkNotNullParameter(r4, "botModel");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InstructionInputComponent$updateMainConversationBotCache$1(r5, r4, null), 3, null);
        r5.A = r4;
        FLogger.a.i("InstructionInputComponent", "[updateMainConversationBotCache] botId = " + r4.getBotId());
    L62:
        return Unit.INSTANCE;
    L47:
        if (r10.aD() == true) goto L50;
        r11 = false;
    L55:
        r12 = false;
    L58:
        r13 = false;
        goto L59
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        boolean r14 = this.Z$0;
        long r15 = this.J$0;
        wc9.e r16 = (wc9.e) this.L$2;
        BotModel r17 = (BotModel) this.L$1;
        InstructionInputComponent r18 = (InstructionInputComponent) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r110 = r19;
    L27:
        Boolean r111 = (Boolean) r110;
    L28:
        a2 r112 = r18.q;
        long r113 = SystemClock.elapsedRealtime();
        if (r112.e != 0) goto L31;
        r112.e = r113;
    L31:
        FLogger.a.d("InstructionInputComponent", "PreLoadMainBotTask.loadDeffer cost:" + (SystemClock.elapsedRealtime() - r15) + ", isColdStart:" + r14);
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r16;
        this.label = 2;
        if (InstructionInputComponent.h3(r18, r16, r17, this) != r1) goto L34;
        return r1;
    L34:
        r3 = r16;
        r4 = r17;
        r5 = r18;
        goto L35
    L10:
        ResultKt.throwOnFailure(r19);
        InstructionInputComponent r20 = this.this$0;
        String r21 = InstructionInputComponent.Z2;
        com.larus.bmhome.chat.component.cvs.y r22 = r20.u0();
        if (r22 == null) goto L62;
        r16 = r22.h();
        if (r16 == null) goto L62;
        r18 = this.this$0;
        r17 = this.$new;
        r15 = SystemClock.elapsedRealtime();
        r14 = r18.f1().w();
        a2 r114 = r18.q;
        if (r114.d != 0) goto L17;
        r114.d = r15;
    L17:
        if (r14 == false) goto L28;
        z2 r115 = z2.a;
        if (r115.isLazyMainComponentEnable() == false) goto L28;
        if (r115.actionBarShowDurationOpt() == true) goto L28;
        CompletableDeferred<Boolean> r116 = wr8.d.a;
        if (r116 == null) goto L28;
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r16;
        this.J$0 = r15;
        this.Z$0 = r14;
        this.label = 1;
        r110 = r116.await(this);
        if (r110 != r1) goto L27;
        return r1;
    }
}
