package com.larus.uaigc.worldcup.component;

import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupInputComponent$handleSendMessageAndGoChatPage$1", f = "WorldCupInputComponent.kt", i = {0, 0}, l = {468}, m = "invokeSuspend", n = {"pocket", "clickPocketInfo"}, s = {"L$3", "L$4"})
public final class WorldCupInputComponent$handleSendMessageAndGoChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $asrResult;
    final /* synthetic */ boolean $fromAsr;
    final /* synthetic */ ICoreInputAbility.OnSendParams $onSendParams;
    final /* synthetic */ String $scene;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ WorldCupInputComponent this$0;

    public WorldCupInputComponent$handleSendMessageAndGoChatPage$1(ICoreInputAbility.OnSendParams r1, WorldCupInputComponent r2, String r3, String r4, boolean r5, Continuation<? super WorldCupInputComponent$handleSendMessageAndGoChatPage$1> r6) {
        this.$onSendParams = r1;
        this.this$0 = r2;
        this.$scene = r3;
        this.$asrResult = r4;
        this.$fromAsr = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new WorldCupInputComponent$handleSendMessageAndGoChatPage$1(this.$onSendParams, this.this$0, this.$scene, this.$asrResult, this.$fromAsr, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r55) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        boolean r1 = this.Z$0;
        ClickPocketInfo r3 = (ClickPocketInfo) this.L$4;
        Pocket r4 = (Pocket) this.L$3;
        String r5 = (String) this.L$2;
        String r6 = (String) this.L$1;
        WorldCupInputComponent r7 = (WorldCupInputComponent) this.L$0;
        ResultKt.throwOnFailure(r55);
        String r8 = r5;
        WorldCupInputComponent r9 = r7;
        int r10 = 1;
        String r11 = r6;
        boolean r12 = r1;
        Object r13 = r55;
    L75:
        ICoreInputAbility.OnSendParams r14 = (ICoreInputAbility.OnSendParams) r13;
        Integer r15 = r4.getPocketType();
        if (r15 != null) goto L79;
    L81:
        if (r15 != null) goto L84;
    L87:
        return Unit.INSTANCE;
    L84:
        if (r15.intValue() != 4) goto L87;
        Map<String, Object> r16 = r3.getExtra();
        int r17 = WorldCupInputComponent.F;
        r9.z3(r14, r11, r8, r12, r16);
        goto L87
    L79:
        if (r15.intValue() != r10) goto L81;
        Map<String, Object> r18 = r3.getExtra();
        int r19 = WorldCupInputComponent.F;
        r9.z3(r14, r11, r8, r12, r18);
        goto L87
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r55);
        ICoreInputAbility.OnSendParams r20 = this.$onSendParams;
        if (r20 == null) goto L87;
        WorldCupInputComponent r110 = this.this$0;
        String r111 = this.$scene;
        String r112 = this.$asrResult;
        boolean r113 = this.$fromAsr;
        int r21 = WorldCupInputComponent.F;
        zz9.b r22 = r110.m3();
        if (r22 == null) goto L13;
        ClickPocketInfo r114 = r22.Ka();
    L14:
        if (r114 == null) goto L16;
        Pocket r115 = r114.getPocket();
    L17:
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("[handleSendMessageAndGoChatPage] springMainVenueLynxAbility = ");
        r24.append(r110.m3());
        r24.append(", clickPocketInfo = ");
        r24.append(r114);
        r24.append(", pocketId = ");
        if (r115 == null) goto L20;
        String r25 = r115.getPocketId();
    L21:
        r24.append(r25);
        r23.i("WorldCupInputComponent", r24.toString());
        if (r115 != null) goto L24;
        r110.z3(r20, r111, r112, r113, null);
        goto L87
    L24:
        String r26 = r20.getContent();
        boolean r27 = false;
        String r28 = "";
        if (o0.d(r26) == false) goto L40;
        com.larus.bmhome.instruction.g r29 = (com.larus.bmhome.instruction.g) r110.q.getValue();
        if (r29 == null) goto L39;
        String r30 = r29.kb(r26);
        if (r30 == null) goto L39;
        if (r30.length() <= 0) goto L33;
        boolean r116 = true;
    L34:
        if (r116 == true) goto L37;
        r30 = null;
    L37:
        if (r30 == null) goto L39;
    L43:
        Map<String, Object> r31 = r114.getOriginData();
        if (r31 != null) goto L46;
    L49:
        boolean r210 = true;
    L50:
        if (r210 == false) goto L52;
        LinkedHashMap r32 = null;
    L71:
        Pocket r33 = r115;
        ClickPocketInfo r56 = r114;
        ICoreInputAbility.OnSendParams r34 = ICoreInputAbility.OnSendParams.copy$default(r20, r30, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, -1048578, 1, null);
        Boolean r35 = r56.isFromAvatarResult();
        r9 = r110;
        this.L$0 = r9;
        this.L$1 = r111;
        this.L$2 = r112;
        this.L$3 = r33;
        this.L$4 = r56;
        this.Z$0 = r113;
        r10 = 1;
        this.label = 1;
        r13 = com.larus.uaigc.spring.utils.e.a(r34, r33, r35, this);
        if (r13 != r2) goto L74;
        return r2;
    L74:
        r4 = r33;
        r3 = r56;
        r8 = r112;
        r11 = r111;
        r12 = r113;
        goto L75
    L52:
        LinkedHashMap r36 = new LinkedHashMap();
        Result.Companion r211 = Result.Companion;     // Catch: Throwable -> L62
        if (r31 != null) goto L56;
    L57:
        r27 = true;
    L58:
        if (r27 == false) goto L60;
        String r37 = "";
    L67:
        if (r37 == null) goto L70;
        r28 = r37;
    L70:
        r36.put("pocket_map", r28);
        FLogger.a.i("WorldCupInputComponent", "[getMessageExtFromPocketDict] append pocket_map ext");
        r32 = r36;
        goto L71
    L60:
        r37 = ((Gson) r110.C.getValue()).toJson(r31);     // Catch: Throwable -> L62
        goto L67
    L56:
        if (r31.isEmpty() == false) goto L58;
    L62:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r39) == false) goto L66;
        r39 = null;
    L66:
        r37 = (String) r39;
        goto L67
    L46:
        if (r31.isEmpty() == true) goto L49;
        r210 = false;
        goto L50
    L33:
        r116 = false;
    L39:
        r30 = r26;
        goto L43
    L40:
        r30 = r115.getPrompt();
        if (r30 != null) goto L43;
        r30 = "";
        goto L43
    L20:
        r25 = null;
        goto L21
    L16:
        r115 = null;
        goto L17
    L13:
        r114 = null;
        goto L14
    }
}
