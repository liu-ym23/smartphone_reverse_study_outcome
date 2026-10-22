package com.larus.uaigc.spring.component;

import com.google.gson.Gson;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.List;
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
@DebugMetadata(c = "com.larus.uaigc.spring.component.SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1", f = "SpringMainVenueInputComponent.kt", i = {0}, l = {551}, m = "invokeSuspend", n = {"pocket"}, s = {"L$3"})
public final class SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $asrResult;
    final /* synthetic */ boolean $fromAsr;
    final /* synthetic */ ICoreInputAbility.OnSendParams $onSendParams;
    final /* synthetic */ String $scene;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ SpringMainVenueInputComponent this$0;

    public SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1(ICoreInputAbility.OnSendParams r1, SpringMainVenueInputComponent r2, String r3, String r4, boolean r5, Continuation<? super SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1> r6) {
        this.$onSendParams = r1;
        this.this$0 = r2;
        this.$scene = r3;
        this.$asrResult = r4;
        this.$fromAsr = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SpringMainVenueInputComponent$handleSendMessageAndGoChatPage$1(this.$onSendParams, this.this$0, this.$scene, this.$asrResult, this.$fromAsr, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r56) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        boolean r1 = this.Z$0;
        Pocket r3 = (Pocket) this.L$3;
        String r6 = (String) this.L$2;
        String r7 = (String) this.L$1;
        SpringMainVenueInputComponent r8 = (SpringMainVenueInputComponent) this.L$0;
        ResultKt.throwOnFailure(r56);
        boolean r5 = r1;
        int r9 = 1;
        Object r4 = r56;
    L83:
        ICoreInputAbility.OnSendParams r10 = (ICoreInputAbility.OnSendParams) r4;
        Integer r11 = r3.getPocketType();
        if (r11 != null) goto L87;
    L89:
        if (r11 != null) goto L92;
    L117:
        if (r11 != null) goto L120;
    L122:
        if (r11 != null) goto L125;
    L128:
        return Unit.INSTANCE;
    L125:
        if (r11.intValue() != 4) goto L128;
        int r12 = SpringMainVenueInputComponent.F;
        r8.D3(r10, r7, r6, r5);
        goto L128
    L120:
        if (r11.intValue() != 2) goto L122;
        int r13 = SpringMainVenueInputComponent.F;
        r8.D3(r10, r7, r6, r5);
        goto L128
    L92:
        if (r11.intValue() != 3) goto L117;
        int r14 = SpringMainVenueInputComponent.F;
        r8.getClass();
        if (r3.getUploadInputPocket() == null) goto L128;
        zz9.b r15 = r8.z3();
        if (r15 == null) goto L98;
        NestedFileContent r25 = r15.T();
    L99:
        if (r25 == null) goto L109;
        List r16 = r25.getEntities();
        if (r16 == null) goto L106;
        if ((!r16.isEmpty()) != true) goto L106;
        boolean r17 = true;
    L107:
        if (r17 == false) goto L109;
        boolean r18 = true;
    L110:
        if (r18 == false) goto L116;
        a0a.b r19 = r8.h3();
        if (r19 == null) goto L114;
        String r24 = r19.b();
    L115:
        r8.D3(ICoreInputAbility.OnSendParams.copy$default(r10, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, new CustomMultiAttachmentInfo("album", r24, r25, false, false, true, IZLotteryService.a.k(), null, 136, null), null, null, null, null, null, null, -67108865, 1, null), r7, r6, r5);
        goto L128
    L114:
        r24 = null;
        goto L115
    L116:
        r8.D3(r10, r7, r6, r5);
    L106:
        r17 = false;
    L109:
        r18 = false;
        goto L110
    L98:
        r25 = null;
        goto L99
    L87:
        if (r11.intValue() != r9) goto L89;
        int r20 = SpringMainVenueInputComponent.F;
        r8.D3(r10, r7, r6, r5);
        goto L128
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r56);
        ICoreInputAbility.OnSendParams r21 = this.$onSendParams;
        if (r21 == null) goto L128;
        SpringMainVenueInputComponent r110 = this.this$0;
        String r111 = this.$scene;
        String r112 = this.$asrResult;
        boolean r113 = this.$fromAsr;
        int r22 = SpringMainVenueInputComponent.F;
        zz9.b r23 = r110.z3();
        if (r23 == null) goto L13;
        ClickPocketInfo r114 = r23.Ka();
    L14:
        if (r114 == null) goto L16;
        Pocket r115 = r114.getPocket();
    L17:
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("[handleSendMessageAndGoChatPage] springMainVenueLynxAbility = ");
        r27.append(r110.z3());
        r27.append(", clickPocketInfo = ");
        r27.append(r114);
        r27.append(", pocketId = ");
        if (r115 == null) goto L20;
        String r28 = r115.getPocketId();
    L21:
        r27.append(r28);
        r26.i("SpringMainVenueComponent", r27.toString());
        if (r115 != null) goto L24;
        r110.D3(r21, r111, r112, r113);
        goto L128
    L24:
        Integer r29 = r115.getIntentionType();
        if (r29 != null) goto L28;
    L30:
        String r30 = r21.getContent();
        String r31 = "";
        if (o0.d(r30) == false) goto L46;
        com.larus.bmhome.instruction.g r32 = (com.larus.bmhome.instruction.g) r110.q.getValue();
        if (r32 == null) goto L45;
        String r33 = r32.kb(r30);
        if (r33 == null) goto L45;
        if (r33.length() <= 0) goto L39;
        boolean r116 = true;
    L40:
        if (r116 == true) goto L43;
        r33 = null;
    L43:
        if (r33 == null) goto L45;
    L49:
        Map<String, Object> r34 = r114.getOriginData();
        if (r34 != null) goto L52;
    L55:
        boolean r210 = true;
    L56:
        if (r210 == false) goto L58;
        LinkedHashMap r35 = null;
    L79:
        Pocket r36 = r115;
        r5 = r113;
        ICoreInputAbility.OnSendParams r37 = ICoreInputAbility.OnSendParams.copy$default(r21, r33, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r35, null, null, null, null, null, null, null, null, null, null, null, null, -1048578, 1, null);
        Boolean r38 = r114.isFromAvatarResult();
        this.L$0 = r110;
        r7 = r111;
        this.L$1 = r7;
        this.L$2 = r112;
        this.L$3 = r36;
        this.Z$0 = r5;
        r9 = 1;
        this.label = 1;
        r4 = com.larus.uaigc.spring.utils.e.a(r37, r36, r38, this);
        if (r4 != r2) goto L82;
        return r2;
    L82:
        r3 = r36;
        r8 = r110;
        r6 = r112;
        goto L83
    L58:
        r35 = new LinkedHashMap();
        Result.Companion r211 = Result.Companion;     // Catch: Throwable -> L70
        if (r34 != null) goto L62;
    L65:
        boolean r212 = true;
    L66:
        if (r212 == false) goto L68;
        String r39 = "";
    L75:
        if (r39 == null) goto L78;
        r31 = r39;
    L78:
        r35.put("pocket_map", r31);
        FLogger.a.i("SpringMainVenueComponent", "[getMessageExtFromPocketDict] append pocket_map ext");
        goto L79
    L68:
        r39 = ((Gson) r110.C.getValue()).toJson(r34);     // Catch: Throwable -> L70
        goto L75
    L62:
        if (r34.isEmpty() == true) goto L65;
        r212 = false;
    L70:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        Object r41 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r41) == false) goto L74;
        r41 = null;
    L74:
        r39 = (String) r41;
        goto L75
    L52:
        if (r34.isEmpty() == true) goto L55;
        r210 = false;
        goto L56
    L39:
        r116 = false;
    L45:
        r33 = r30;
        goto L49
    L46:
        r33 = r115.getPrompt();
        if (r33 != null) goto L49;
        r33 = "";
        goto L49
    L28:
        if (r29.intValue() != 20) goto L30;
        IZLotteryService.a.r();
        goto L30
    L20:
        r28 = null;
        goto L21
    L16:
        r115 = null;
        goto L17
    L13:
        r114 = null;
        goto L14
    }
}
