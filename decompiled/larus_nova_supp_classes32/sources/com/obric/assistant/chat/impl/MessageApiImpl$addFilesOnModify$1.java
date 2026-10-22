package com.obric.assistant.chat.impl;

import ai8.f;
import com.flow.kmp.common.util.i;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.d;
import com.larus.im.internal.core.message.converter.c;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.IObricMessageExtService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.h;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.api.a$a;
import com.obric.assistant.interaction.api.IWindowEffects;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import wc9.e;
import yc9.e0;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$addFilesOnModify$1", f = "MessageApiImpl.kt", i = {0, 0, 1, 1, 1}, l = {305, SpeechEvent.LOCAL_EVENT_SET_VAD_PARAM}, m = "invokeSuspend", n = {"ext", "newFile", "ext", "newFile", "conv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class MessageApiImpl$addFilesOnModify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ Message $message;
    final /* synthetic */ boolean $needReplaceTxtAndFile;
    final /* synthetic */ a$a $newFile;
    final /* synthetic */ String $replaceContent;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.chat.impl.MessageApiImpl$addFilesOnModify$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$addFilesOnModify$1$3", f = "MessageApiImpl.kt", i = {}, l = {419}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $message;
        final /* synthetic */ e0 $modifyRequest;
        final /* synthetic */ f0 $newReferenceMsgRequest;
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.chat.impl.MessageApiImpl$addFilesOnModify$1$3$a */
        public static final class a implements IIMCallback<List<? extends Message>> {
            public final /* synthetic */ e0 a;
            public final /* synthetic */ f0 b;
            public final /* synthetic */ Message c;

            public final boolean mustInMain() {
                return true;
            }

            public final void onFailure(IIMError r4) {
                Intrinsics.checkNotNullParameter(r4, "error");
                Intrinsics.checkNotNullParameter(r4, "error");
                FLogger.a.e("MessageApiImpl", "oReplaceContentOnModify, modifyMessageContent, error: " + r4 + ", " + this.a);
            }

            public final void onSuccess(Object r9) {
                List r10 = (List) r9;
                Intrinsics.checkNotNullParameter(r10, "result");
                FLogger r0 = FLogger.a;
                r0.i("MessageApiImpl", "oReplaceContentOnModify, modifyMessageContent, success, I: " + this.a);
                r0.i("MessageApiImpl", "oReplaceContentOnModify, modifyMessageContent, success,II: " + this.b);
                r0.i("MessageApiImpl", "oReplaceContentOnModify, modifyMessageContent, success,III: " + r10.size());
                Job r11 = MessageApiImpl.h;
                if (r11 == null) goto L5;
                Job.DefaultImpls.cancel$default(r11, null, 1, null);
            L5:
                MessageApiImpl.h = BuildersKt.launch$default(MessageApiImpl.b, null, null, new MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1(this.c, null), 3, null);
            }

            public a(e0 r1, f0 r2, Message r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public AnonymousClass3(e0 r1, f0 r2, Message r3, Continuation<? super AnonymousClass3> r4) {
            this.$modifyRequest = r1;
            this.$newReferenceMsgRequest = r2;
            this.$message = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.$modifyRequest, this.$newReferenceMsgRequest, this.$message, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            IWindowEffects r6 = (IWindowEffects) ServiceManager.get().getService(IWindowEffects.class);
            if (r6 == null) goto L14;
            r6.showScreenShotEffect();
        L14:
            NativeMessageServiceImpl r7 = d.e();
            e0 r2 = this.$modifyRequest;
            r7.modifyMessageContent(r2, new a(r2, this.$newReferenceMsgRequest, this.$message));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (DelayKt.delay(3000, this) != r0) goto L11;
            return r0;
        }
    }

    public MessageApiImpl$addFilesOnModify$1(Message r1, Map<String, String> r2, a$a r3, String r4, boolean r5, Continuation<? super MessageApiImpl$addFilesOnModify$1> r6) {
        this.$message = r1;
        this.$extras = r2;
        this.$newFile = r3;
        this.$replaceContent = r4;
        this.$needReplaceTxtAndFile = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageApiImpl$addFilesOnModify$1(this.$message, this.$extras, this.$newFile, this.$replaceContent, this.$needReplaceTxtAndFile, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r64) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r11 = false;
        String r12 = NameKeys.UnloadStrategy_No_Strategy;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        e r2 = (e) this.L$2;
        f r3 = (f) this.L$1;
        Map r4 = (Map) this.L$0;
        ResultKt.throwOnFailure(r64);
        Object r5 = r64;
        Map r6 = r4;
        f r7 = r3;
        e r8 = r2;
    L47:
        BotModel r9 = (BotModel) r5;
        r6.put("collection_id", UUID.randomUUID().toString());
        r6.put("is_semantic_screen_qa", "1");
        String r10 = (String) r6.get("o_session");     // Catch: Exception -> L53
        if (r10 == null) goto L51;
        JSONObject r15 = new JSONObject(r10);     // Catch: Exception -> L53
    L184:
    L55:
        r15.put("is_semantic_screen_qa", "1");
        r6.put("o_session", r15.toString());
        Message r16 = this.$message;
        String r13 = this.$replaceContent;
        Map r14 = r16.getBusinessExt();
        if (r14 != null) goto L58;
        r14 = new LinkedHashMap();
    L58:
        Message r17 = Message.copy$default(r16, null, null, null, 0, 0, null, 0, false, null, r13, null, null, null, r6, null, null, 0, 0, false, null, null, null, h.c(r14, new Pair[]{TuplesKt.to("send_loading", "1")}), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4203009, 31, null);
        IObricMessageExtService.Companion r18 = IObricMessageExtService.a;
        f0 r19 = com.larus.bmhome.chat.bean.d.g1(r17, r18.b(r9));
        if (r9 == null) goto L63;
        BotCreatorInfo r20 = r9.getBotCreatorInfo();
        if (r20 == null) goto L63;
        String r21 = r20.getId();
    L64:
        AccountService r22 = AccountService.a;
        boolean r110 = Intrinsics.areEqual(r21, r22.getUserId());
        if (r9 == null) goto L67;
        String r23 = r9.getBgImgUrl();
    L68:
        if (r23 != null) goto L70;
    L73:
        boolean r24 = true;
    L74:
        if (r24 == false) goto L76;
    L78:
        boolean r111 = false;
    L79:
        if (r9 == null) goto L81;
        String r25 = r9.getBgVideoModel();
    L82:
        if (r25 != null) goto L84;
    L87:
        boolean r26 = true;
    L88:
        if (r26 == false) goto L90;
    L92:
        boolean r27 = false;
    L93:
        String r28 = r19.i;
        if (r28 != null) goto L96;
        r28 = NameKeys.UnloadStrategy_No_Strategy;
    L96:
        r18.g(r28);
        String r29 = r19.i;
        if (r29 != null) goto L99;
        r29 = NameKeys.UnloadStrategy_No_Strategy;
    L99:
        r18.h(r29, r19.a, 1, null);
        Message r112 = c.a(r19);
        if (r8 == null) goto L104;
        Integer r113 = r8.v;
        if (r113 == null) goto L104;
        int r114 = r113.intValue();
    L105:
        if (r9 == null) goto L109;
        Integer r115 = r9.getBotType();
        if (r115 == null) goto L109;
        int r116 = r115.intValue();
    L110:
        if (r9 == null) goto L112;
        String r210 = r9.getBotId();
    L113:
        r18.c(r112, r114, r116, r110, r111, r27, r210, null);
        if (r9 == null) goto L121;
        Integer r117 = r9.getBotType();
        if (r117 == null) goto L121;
        if (r117.intValue() != 1) goto L121;
        r11 = true;
    L121:
        if (r11 == false) goto L125;
        IFlowSdkDepend r118 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r118 == null) goto L125;
        r118.r0();
        e2 r119 = e2.a;
        Unit r120 = Unit.INSTANCE;
    L125:
        AppletPayloadProviderDelegate r121 = AppletPayloadProviderDelegate.a;
        String r122 = r19.a;
        if (r9 == null) goto L128;
        String r123 = r9.getBotId();
    L129:
        String r124 = r19.i;
        if (r124 != null) goto L132;
        r124 = NameKeys.UnloadStrategy_No_Strategy;
    L132:
        r19.A = r121.b(r122, r123, r124);
        Unit r125 = Unit.INSTANCE;
        r18.k(r8);
        if (r9 == null) goto L135;
        String r126 = r9.getBotId();
    L136:
        if (r126 != null) goto L138;
        r126 = NameKeys.UnloadStrategy_No_Strategy;
    L138:
        ReplyOption r30 = r18.a(r126, ActiveSwitchType.DEEPTHINK.getValue());
        if (r9 == null) goto L144;
        String r127 = r9.getBotId();
        if (r127 == null) goto L144;
        String r211 = r127;
    L145:
        LinkedHashMap r128 = new LinkedHashMap();
        r128.putAll(r19.w);
        r128.putAll(r18.d());
        f0 r129 = f0.a(r19, null, null, null, 0, null, null, null, 0, null, null, null, null, r128, null, r211, 515899391);
        r18.l(r29, r19, r30);
        r18.j(r29, r19.e);
        Map r212 = MapsKt.toMutableMap(r6);
        if (r7 == null) goto L164;
        String r130 = r129.a;
        String r131 = r22.getUserId();
        if (r9 == null) goto L153;
        String r31 = r9.getBotId();
        if (r31 == null) goto L153;
        String r34 = r31;
    L154:
        String r32 = (String) r6.get("collection_id");
        if (r32 != null) goto L157;
        r32 = UUID.randomUUID().toString();
    L157:
        TuplesKt.to("collection_id", r32);
        ClientControllerParam r33 = r18.b(r9);
        String r213 = r7.content();
        String r35 = r7.b;
        if (r35 != null) goto L160;
        int r36 = wf9.b.a;
        r35 = i.a();
    L160:
        String r214 = r35;
        MessageRequestType r132 = r7.d();
        LinkedHashMap r37 = new LinkedHashMap();
        Pair r38 = r7.h();
        if (r38 == null) goto L163;
        r37.put(r38.getFirst(), r38.getSecond());
    L163:
        f0 r133 = new f0(r130, r132, r131, 1, MessageContentType.OTHER, r213, r214, null, 0, null, false, null, r212, "flow_nested", null, null, null, r37, r33, r34, null, 507117248);
    L165:
        int r39 = wf9.b.a;
        String r40 = i.a();
        e0 r41 = new e0(this.$needReplaceTxtAndFile, r129, r133, r40);
        String r42 = r129.i;
        if (r42 != null) goto L168;
        r42 = NameKeys.UnloadStrategy_No_Strategy;
    L168:
        r18.f(r42);
        if (r133 == null) goto L175;
        String r43 = r133.i;
        if (r43 == null) goto L174;
        r12 = r43;
    L174:
        r18.f(r12);
    L175:
        r18.f(r40);
        r18.e(r40, null, r129.r);
        if (r133 == null) goto L178;
        Map r44 = r133.r;
    L179:
        r18.e(r40, null, r44);
        Job r45 = MessageApiImpl.g;
        if (r45 == null) goto L182;
        Job.DefaultImpls.cancel$default(r45, null, 1, null);
    L182:
        MessageApiImpl.g = BuildersKt.launch$default(MessageApiImpl.b, null, null, new AnonymousClass3(r41, r133, this.$message, null), 3, null);
        return Unit.INSTANCE;
    L178:
        r44 = null;
    L153:
        r34 = NameKeys.UnloadStrategy_No_Strategy;
        goto L154
    L164:
        r133 = null;
    L144:
        r211 = NameKeys.UnloadStrategy_No_Strategy;
        goto L145
    L135:
        r126 = null;
        goto L136
    L128:
        r123 = null;
        goto L129
    L112:
        r210 = null;
    L109:
        r116 = 1;
    L104:
        r114 = 0;
        goto L105
    L90:
        if (z2.a.chatImmerseEnable() == false) goto L92;
        r27 = true;
        goto L93
    L84:
        if (StringsKt.isBlank(r25) == true) goto L87;
        r26 = false;
        goto L88
    L81:
        r25 = null;
        goto L82
    L76:
        if (z2.a.chatImmerseEnable() == false) goto L78;
        r111 = true;
        goto L79
    L70:
        if (StringsKt.isBlank(r23) == true) goto L73;
        r24 = false;
        goto L74
    L67:
        r23 = null;
    L63:
        r21 = null;
        goto L64
    L51:
        r15 = new JSONObject();     // Catch: Exception -> L53
    L53:
        e = move-exception;
        FLogger.a.w("MessageApiImpl", "Failed to parse o_session JSON, creating new", e);
        r15 = new JSONObject();
        goto L55
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        f r46 = (f) this.L$1;
        Map r47 = (Map) this.L$0;
        ResultKt.throwOnFailure(r64);
        Map r134 = r47;
        r7 = r46;
        Object r48 = r64;
    L40:
        r8 = (e) r48;
        IBotRepoService r49 = zh8.a.e;
        String r50 = this.$message.getConversationId();
        if (r50 != null) goto L43;
        r50 = NameKeys.UnloadStrategy_No_Strategy;
    L43:
        this.L$0 = r134;
        this.L$1 = r7;
        this.L$2 = r8;
        this.label = 2;
        r5 = r49.j1(r50, false, this);
        if (r5 != r0) goto L46;
        return r0;
    L46:
        r6 = r134;
        goto L47
    L10:
        ResultKt.throwOnFailure(r64);
        FLogger.a.i("MessageApiImpl", "addFilesOnModify");
        Map r51 = this.$message.getExt();
        if (r51 == null) goto L17;
        Map r52 = MapsKt.toMutableMap(r51);
        if (r52 == null) goto L17;
        Map<String, String> r53 = this.$extras;
        if (r53 == null) goto L21;
        r52.putAll(r53);
    L21:
        r134 = r52;
        a$a r54 = this.$newFile;
        if (r54 == null) goto L32;
        MessageApiImpl r55 = MessageApiImpl.a;
        ArrayList r56 = new ArrayList();
        String r310 = UUID.randomUUID().toString();
        int r57 = UplinkEntityType.EntityTypeImage.getValue();
        UplinkEntityContent r58 = new UplinkEntityContent(null, null, 3, null);
        String r59 = r54.a;
        Integer r60 = r54.d;
        if (r60 == null) goto L26;
        int r410 = r60.intValue();
    L27:
        Integer r61 = r54.c;
        if (r61 == null) goto L30;
        int r411 = r61.intValue();
    L31:
        ImageObj r412 = new ImageObj(null, r411, r410, null, null, 25, null);
        String r62 = r54.b;
        Boolean r215 = Boolean.FALSE;
        r58.setUplinkImageInfo(new Image(r59, null, null, r412, r62, null, r310, null, null, null, null, r215, null, null, 14246, null));
        r56.add(new UplinkFileEntity(Integer.valueOf(r57), r58, r310, null, null, null, 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), r215, false, null, null, null, null, 15928, null));
        NestedFileContent r510 = new NestedFileContent(r56, null, false, null, 14, null);
        int r63 = wf9.b.a;
        f r65 = new f(r510, i.a(), MessageStatus.MessageStatus_INVISIBLE, null, null, null, false, null, null, null, 1016);
    L33:
        IConversationRepoService r66 = zh8.a.b;
        String r67 = this.$message.getConversationId();
        if (r67 != null) goto L36;
        r67 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        this.L$0 = r134;
        this.L$1 = r65;
        this.label = 1;
        f r135 = r65;
        r48 = IConversationRepoService.a.c(r66, r67, false, null, this, 6);
        if (r48 != r0) goto L39;
        return r0;
    L39:
        r7 = r135;
        goto L40
    L30:
        r411 = 0;
        goto L31
    L26:
        r410 = 0;
        goto L27
    L32:
        r65 = null;
    L17:
        Map<String, String> r68 = this.$extras;
        if (r68 == null) goto L20;
        r52 = MapsKt.toMutableMap(r68);
        goto L21
    L20:
        r52 = new LinkedHashMap();
        goto L21
    }
}
