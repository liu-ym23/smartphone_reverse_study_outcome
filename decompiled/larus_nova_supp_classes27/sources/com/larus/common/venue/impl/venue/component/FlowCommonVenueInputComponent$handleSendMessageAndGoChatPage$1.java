package com.larus.common.venue.impl.venue.component;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.common.venue.api.AssistantBizScene;
import com.larus.common.venue.impl.venue.api.Pocket;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.venue.impl.venue.component.FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1", f = "FlowCommonVenueInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $asrResult;
    final /* synthetic */ boolean $fromAsr;
    final /* synthetic */ ICoreInputAbility.OnSendParams $onSendParams;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ FlowCommonVenueInputComponent this$0;

    public FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1(ICoreInputAbility.OnSendParams r1, FlowCommonVenueInputComponent r2, String r3, String r4, boolean r5, Continuation<? super FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1> r6) {
        this.$onSendParams = r1;
        this.this$0 = r2;
        this.$scene = r3;
        this.$asrResult = r4;
        this.$fromAsr = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowCommonVenueInputComponent$handleSendMessageAndGoChatPage$1(this.$onSendParams, this.this$0, this.$scene, this.$asrResult, this.$fromAsr, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r88) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L141;
        ResultKt.throwOnFailure(r88);
        ICoreInputAbility.OnSendParams r2 = this.$onSendParams;
        if (r2 == null) goto L139;
        FlowCommonVenueInputComponent r15 = this.this$0;
        String r14 = this.$scene;
        String r13 = this.$asrResult;
        boolean r12 = this.$fromAsr;
        int r0 = FlowCommonVenueInputComponent.B;
        v09.b r1 = r15.B3();
        String r310 = null;
        if (r1 == null) goto L9;
        ClickPocketInfo r3 = r1.Ka();
    L10:
        if (r3 == null) goto L12;
        Pocket r40 = r3.getPocket();
    L13:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[handleSendMessageAndGoChatPage] flowCommonVenueLynxAbility = ");
        r5.append(r15.B3());
        r5.append(", clickPocketInfo = ");
        r5.append(r3);
        r5.append(", pocketId = ");
        if (r40 == null) goto L16;
        String r6 = r40.getPocketId();
    L17:
        r5.append(r6);
        r4.i("FlowCommonVenueComponent", r5.toString());
        if (r40 != null) goto L20;
        r15.G3(r2, r14, r13, r12);
        goto L139
    L20:
        String r7 = r2.getContent();
        boolean r41 = false;
        String r8 = "";
        if (o0.d(r7) == false) goto L35;
        com.larus.bmhome.instruction.g r9 = (com.larus.bmhome.instruction.g) r15.q.getValue();
        if (r9 == null) goto L38;
        String r10 = r9.kb(r7);
        if (r10 == null) goto L38;
        if (r10.length() <= 0) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == true) goto L33;
        r10 = null;
    L33:
        if (r10 == null) goto L38;
        r7 = r10;
        goto L38
    L29:
        r11 = false;
    L38:
        Map<String, Object> r16 = r3.getOriginData();
        if (r16 != null) goto L41;
    L44:
        boolean r17 = true;
    L45:
        if (r17 == false) goto L47;
        LinkedHashMap r18 = null;
    L96:
        ICoreInputAbility.OnSendParams r20 = ICoreInputAbility.OnSendParams.copy$default(r2, r7, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, r18, null, null, null, null, null, null, null, null, null, null, null, null, -1048578, 1, null);
        Integer r21 = r40.getPocketType();
        if (r21 != null) goto L99;
        boolean r22 = true;
    L103:
        if (r21 != null) goto L106;
    L128:
        if (r21 != null) goto L131;
    L133:
        if (r21 == null) goto L139;
        if (r21.intValue() != 4) goto L139;
        r49.G3(r20, r48, r47, r46);
        goto L139
    L131:
        if (r21.intValue() != 2) goto L133;
        r49.G3(r20, r48, r47, r46);
        goto L139
    L106:
        if (r21.intValue() != 3) goto L128;
        if (r40.getUploadInputPocket() == null) goto L139;
        v09.b r23 = r49.B3();
        if (r23 == null) goto L112;
        NestedFileContent r110 = r23.T();
    L113:
        if (r110 == null) goto L122;
        List r24 = r110.getEntities();
        if (r24 != null) goto L117;
    L119:
        boolean r25 = false;
    L120:
        if (r25 == false) goto L122;
        r41 = true;
        goto L122
    L117:
        if ((r24.isEmpty() ^ r22) != r22) goto L119;
        r25 = true;
    L122:
        if (r41 == false) goto L127;
        x09.a r26 = r49.h3();
        if (r26 == null) goto L126;
        r310 = r26.c();
    L126:
        r15.G3(ICoreInputAbility.OnSendParams.copy$default(r20, null, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, new CustomMultiAttachmentInfo("album", r310, r110, false, false, true, IZLotteryService.a.k(), null, 136, null), null, null, null, null, null, null, -67108865, 1, null), r14, r13, r12);
        goto L139
    L127:
        r49.G3(r20, r48, r47, r46);
        goto L139
    L112:
        r110 = null;
        goto L113
    L99:
        r22 = true;
        if (r21.intValue() != 1) goto L103;
        r15.G3(r20, r14, r13, r12);
        goto L139
    L47:
        LinkedHashMap r27 = new LinkedHashMap();
        if (r16.containsKey("ext") == true) goto L144;
    L142:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L70
        if (r16.isEmpty() == false) goto L68;
        String r30 = "";
    L75:
        if (r30 == null) goto L78;
        r8 = r30;
    L78:
        r27.put("pocket_map", r8);
        x09.a r31 = r15.h3();
        if (r31 == null) goto L81;
        Integer r32 = r31.b();
    L82:
        int r33 = AssistantBizScene.EcomPrePurchase.getValue();
        if (r32 != null) goto L86;
    L88:
        int r34 = AssistantBizScene.Travel.getValue();
        if (r32 != null) goto L92;
    L94:
        r27.put("action_bar_key", ActionBarInstructionKey.COCO_ECOM_ASSISTANT.getKey());
    L95:
        FLogger.a.i("FlowCommonVenueComponent", "[getMessageExtFromPocketDict] append pocket_map ext");
        r18 = r27;
        goto L96
    L92:
        if (r32.intValue() != r34) goto L94;
        r27.put("action_bar_key", ActionBarInstructionKey.COCO_TRAVEL_ASK_DOUBAO.getKey());
        goto L95
    L86:
        if (r32.intValue() != r33) goto L88;
        r27.put("action_bar_key", ActionBarInstructionKey.COCO_ECOM_ASSISTANT.getKey());
        goto L95
    L81:
        r32 = null;
        goto L82
    L68:
        r30 = ((Gson) r15.y.getValue()).toJson(r16);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Object r36 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r36) == false) goto L74;
        r36 = null;
    L74:
        r30 = (String) r36;
        goto L75
    L144:
        Result.Companion r210 = Result.Companion;     // Catch: Throwable -> L57
        int r211 = p0.a;     // Catch: Throwable -> L57
        Object r37 = r16.get("ext");     // Catch: Throwable -> L57
        if ((r37 instanceof String) == false) goto L52;
        String r38 = (String) r37;     // Catch: Throwable -> L57
    L53:
        if (r38 != null) goto L55;
        r38 = "";
    L55:
        Object r42 = Result.constructor-impl(p0.a(JSONObjectProtectorUtils.getString(new JSONObject(r38), "chat_lite_option").toString()));     // Catch: Throwable -> L57
    L60:
        if (Result.isFailure-impl(r42) == false) goto L62;
        r42 = null;
    L62:
        String r43 = (String) r42;
        if (r43 == null) goto L142;
        FLogger.a.i("FlowCommonVenueComponent", "[getMessageExtFromPocketDict] append chat_lite_option ext");
        r27.put("chat_lite_option", r43);
        goto L142
    L52:
        r38 = null;
    L57:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L41:
        if (r16.isEmpty() == true) goto L44;
        r17 = false;
        goto L45
    L35:
        r7 = r40.getPrompt();
        if (r7 != null) goto L38;
        r7 = "";
        goto L38
    L16:
        r6 = null;
        goto L17
    L12:
        r40 = null;
        goto L13
    L9:
        r3 = null;
    L139:
        return Unit.INSTANCE;
    L141:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
