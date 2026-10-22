package com.larus.bmhome.chat.model.strategy.block;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ChatEntryOption;
import com.larus.im.bean.message.ChatEntrySourceType;
import com.larus.im.bean.message.ChatLite;
import com.larus.im.bean.message.ChatQueryOption;
import com.larus.im.bean.message.ClientMeta;
import com.larus.im.bean.message.ConversationInitExt;
import com.larus.im.bean.message.ConversationInitOption;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageRequestV2;
import com.larus.im.bean.message.ModelConfig;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.jni.callback.NativeIMCallback;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.internal.legacy.i3;
import com.larus.im.internal.legacy.k3;
import com.larus.im.internal.legacy.t3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$regenMessage$1", f = "ChatBlockSendStrategy.kt", i = {2}, l = {693, 697, 701, 706}, m = "invokeSuspend", n = {"questionId"}, s = {"L$0"})
public final class ChatBlockSendStrategy$regenMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $answer;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $question;
    final /* synthetic */ String $regenInstruction;
    Object L$0;
    int label;
    final /* synthetic */ ChatBlockSendStrategy this$0;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ wc9.e a;
        public final /* synthetic */ Message b;
        public final /* synthetic */ Message c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ChatPageContext e;
        public final /* synthetic */ ClientMeta f;
        public final /* synthetic */ b g;
        public final /* synthetic */ ChatBlockSendStrategy h;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.g.onFailure(r2);
        }

        public final void onSuccess(Object r83) {
            List r0 = (List) r83;
            Intrinsics.checkNotNullParameter(r0, "result");
            ChatSendUtils r2 = ChatSendUtils.a;
            wc9.e r3 = this.a;
            Message r4 = this.b;
            Message r5 = this.c;
            String r6 = this.d;
            r2.getClass();
            Map r9 = MapsKt.toMutableMap(ChatSendUtils.m(r3, r4, r5, r6));
            Message r7 = this.b;
            ChatBlockSendStrategy r8 = this.h;
            ChatPageContext r10 = this.e;
            String r11 = r7.getLocalMessageId();
            if (r11 != null) goto L5;
            r11 = "";
        L5:
            String r12 = r7.getMessageId();
            if (r12 != null) goto L8;
            r12 = "";
        L8:
            ChatSendUtils.d(r11, r12, r9);
            ChatBlockSendStrategy.k(r8, r9, r10);
            d0 r13 = d0.a;
            String r14 = (String) r9.remove("delivery_address");
            if (r14 != null) goto L11;
        L13:
            r14 = null;
        L14:
            r13.getClass();
            List r15 = d0.d(r14);
            ChatPageContext r16 = this.e;
            if (r16 == null) goto L17;
            List<GuiContext> r17 = r16.getGuiContext();
        L18:
            List r18 = d0.a(r15, r17);
            String r19 = (String) r9.get("applet_follow_up_data");
            if (r19 == null) goto L21;
            r9.remove("applet_follow_up_data");
            String r47 = r19;
        L22:
            com.larus.bmhome.instruction.c r20 = com.larus.bmhome.instruction.c.a;
            String r21 = this.b.getSenderId();
            if (r21 != null) goto L25;
            r21 = "";
        L25:
            ReplyOption r22 = r20.a(r21, ActiveSwitchType.DEEPTHINK.getValue());
            ModelItemIdentity r23 = r22.getModel();
            String r24 = (String) r9.get("need_deep_think");
            if (r24 == null) goto L30;
            Integer r25 = StringsKt.toIntOrNull(r24);
            if (r25 == null) goto L30;
            int r26 = r25.intValue();
        L31:
            Object r27 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
            int r28 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r22);
            ChatPageContext r29 = this.e;
            if (r29 == null) goto L34;
            Map<String, String> r30 = r29.getBizExt();
        L35:
            if (r30 != null) goto L37;
            r30 = MapsKt.emptyMap();
        L37:
            Map r31 = MapsKt.toMutableMap(r30);
            ChatPageContext r110 = this.e;
            String r111 = r23.getKey();
            if (r111 != null) goto L40;
            r111 = "";
        L40:
            r31.put("model_item_key", r111);
            r31.put("provider_id", com.larus.bmhome.view.actionbar.custom.cache.e.g(r23));
            String r112 = r22.getModeId();
            if (r112 != null) goto L43;
            r112 = "";
        L43:
            r31.put("mode_id", r112);
            Integer r113 = r22.getReasoningEffort();
            if (r113 == null) goto L47;
            String r114 = r113.toString();
            if (r114 == null) goto L47;
        L48:
            r31.put("reasoning_effort", r114);
            if (r110 == null) goto L62;
            String r115 = r110.getConversationMode();
            if (r115 == null) goto L62;
            if (r115.length() <= 0) goto L55;
            boolean r116 = true;
        L56:
            if (r116 == true) goto L59;
            r115 = null;
        L59:
            if (r115 == null) goto L62;
            String r117 = (String) r31.put("conversation_mode", r115);
            goto L62
        L55:
            r116 = false;
        L62:
            if (com.larus.bmhome.view.actionbar.custom.cache.e.i(r22) == true) goto L64;
        L68:
            MessageRequestType r118 = MessageRequestType.UNKNOWN;
            ClientMeta r119 = this.f;
            ArrayList r120 = new ArrayList();
            List r1 = r0;
            ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r32 = r1.iterator();
        L70:
            if (r32.hasNext() == false) goto L75;
            String r122 = ((Message) r32.next()).getMessageId();
            if (r122 != null) goto L74;
            r122 = "";
        L74:
            r121.add(r122);
            goto L70
        L75:
            String r34 = UUID.randomUUID().toString();
            UserSettingCacheManager.a.getClass();
            boolean r210 = UserSettingCacheManager.a();
            String r211 = r22.getModeId();
            if (this.b.getContentType() != 6) goto L78;
        L81:
            boolean r33 = true;
        L83:
            if (r26 == t0.e.getDeprecatedItemId()) goto L85;
        L87:
            int r212 = r26;
        L88:
            String r35 = r23.getKey();
            Object r36 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
            ModelConfig r37 = new ModelConfig(r35, com.larus.bmhome.view.actionbar.custom.cache.e.f(r23), r22.getReasoningEffort());
            if (TextUtils.isEmpty((CharSequence) r9.get("conversation_init_option")) == false) goto L91;
            r119 = r119;
            ArrayList r61 = r120;
            ConversationInitOption r41 = null;
        L118:
            if (Intrinsics.areEqual(r9.get("need_conversation_init_ext"), "1") == false) goto L124;
            r9.remove("need_conversation_init_ext");
            String r49 = r23.getKey();
            String r50 = r22.getModeId();
            Integer r38 = r22.getReasoningEffort();
            if (r38 == null) goto L122;
            String r51 = r38.toString();
        L123:
            ConversationInitExt r42 = new ConversationInitExt(r49, r50, r51, null, 8, null);
        L125:
            String r39 = (String) r9.get("pocket_map");
            if (r39 != null) goto L128;
        L151:
            Object r40 = null;
        L153:
            if ((r40 instanceof String) == false) goto L155;
            String r43 = (String) r40;
        L156:
            if (r43 == null) goto L171;
            zd9.h r44 = zd9.h.a;
            if (StringsKt.isBlank(r43) == false) goto L248;
        L169:
            Object r45 = null;
        L170:
            ChatLite r46 = (ChatLite) r45;
        L172:
            String r48 = (String) r9.get("general_task_param");
            if (r48 != null) goto L175;
            GeneralTaskParam r410 = null;
        L196:
            ChatSendUtils r52 = ChatSendUtils.a;
            Message r53 = this.b;
            r52.getClass();
            Intrinsics.checkNotNullParameter(r53, "answer");
            Map r54 = ChatSendUtils.j(CollectionsKt.listOf(r53));
            String r55 = (String) r9.get("chat_entry_source");
            if (r55 == null) goto L201;
            Integer r56 = StringsKt.toIntOrNull(r55);
            if (r56 == null) goto L201;
            int r57 = r56.intValue();
        L202:
            int r123 = r57;
            d0.a.getClass();
            boolean r124 = d0.i(r9, "is_first_open_in_source_page");
            boolean r125 = d0.i(r9, "is_chat_flow_collapsed");
            String r58 = (String) r9.get("origin_message_id");
            if (r58 != null) goto L205;
        L210:
            String r213 = null;
        L211:
            ChatEntryOption r59 = new ChatEntryOption(r123, r124, r125, r213, r31);
            String r60 = (String) r9.get("biz_task_id");
            if (r60 != null) goto L214;
        L219:
            String r510 = null;
        L220:
            String r62 = (String) r9.get("miniapp_appkey");
            if (r62 != null) goto L223;
        L228:
            String r511 = null;
        L229:
            ChatQueryOption r63 = new ChatQueryOption(null, 0, null, false, r210, Integer.valueOf(r28), r211, false, r212, false, false, null, true, r121, r33, this.d, r34, false, false, 0, 0, null, null, r41, r42, r46, r410, null, false, r47, null, false, null, r37, r54, r59, r510, r511, r31, -662827377, 1, null);
            List r64 = CollectionsKt.listOf(new String[]{"chat_entry_source", "is_first_open_in_source_page", "is_chat_flow_collapsed", "biz_task_id", "miniapp_appkey", "select_project_id"});
            LruCache r65 = CommonParamManager.a;
            String[] r66 = new String[3];
            Message r67 = this.c;
            if (r67 == null) goto L232;
            String r68 = r67.getMessageId();
        L233:
            r66[0] = r68;
            Message r69 = this.c;
            if (r69 == null) goto L236;
            String r70 = r69.getLocalMessageId();
            char r71 = 1;
        L237:
            r66[r71] = r70;
            r66[2] = this.b.getReplyId();
            List r72 = CollectionsKt.listOfNotNull(r66);
            ArrayList r73 = new ArrayList();
            Iterator r74 = r72.iterator();
        L239:
            if (r74.hasNext() == false) goto L246;
            Object r75 = r74.next();
            if (((String) r75).length() <= 0) goto L243;
            boolean r126 = true;
        L244:
            if (r126 == false) goto L239;
            r73.add(r75);
            goto L239
        L243:
            r126 = false;
            goto L244
        L246:
            MessageRequestV2 r127 = new MessageRequestV2(r118, r119, r61, r63, null, r9, r64, r18, CommonParamManager.a(r73, Integer.valueOf(r28), "regen"), 16, null);
            FLogger.a.i("ChatBlockSendStrategy", "regenMessage, req = " + r127);
            NativeMessageServiceImpl r76 = com.larus.im.d.e();
            b r77 = this.g;
            r76.getClass();
            Intrinsics.checkNotNullParameter(r127, "request");
            OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, NativeMessageServiceImpl.r(), false, 2, null).withMessageService(new t3(r127, r77));
            return;
        L236:
            r71 = 1;
            r70 = null;
            goto L237
        L232:
            r68 = null;
            goto L233
        L223:
            if (r62.length() <= 0) goto L225;
            boolean r78 = true;
        L226:
            if (r78 == false) goto L228;
            r511 = r62;
            goto L229
        L225:
            r78 = false;
            goto L226
        L214:
            if (r60.length() <= 0) goto L216;
            boolean r79 = true;
        L217:
            if (r79 == false) goto L219;
            r510 = r60;
            goto L220
        L216:
            r79 = false;
            goto L217
        L205:
            if (r58.length() <= 0) goto L207;
            boolean r80 = true;
        L208:
            if (r80 == false) goto L210;
            r213 = r58;
            goto L211
        L207:
            r80 = false;
        L201:
            r57 = ChatEntrySourceType.ChatEntrySourceType_Default.getValue();
            goto L202
        L175:
            if (TextUtils.isEmpty(r48) == false) goto L180;
            Object r81 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
            if (com.larus.bmhome.view.actionbar.custom.cache.e.i(r22) == false) goto L179;
            GeneralTaskParam r82 = new GeneralTaskParam(null, null, null, null, 1, null, null, null, null, null, null, null, null, false, null, null, 65519, null);
        L194:
            r410 = r82;
            goto L196
        L179:
            r82 = null;
            goto L194
        L180:
            zd9.h r84 = zd9.h.a;
            if (StringsKt.isBlank(r48) == false) goto L250;
        L192:
            Object r85 = null;
        L193:
            r82 = (GeneralTaskParam) r85;
            goto L194
        L250:
            Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L185
            r84.getClass();     // Catch: Throwable -> L185
            r85 = Result.constructor-impl(zd9.h.b.fromJson(r48, new t().getType()));     // Catch: Throwable -> L185
        L187:
            Throwable r87 = Result.exceptionOrNull-impl(r85);
            if (r87 == null) goto L191;
            com.larus.im.internal.delegate.c0 r88 = com.larus.im.internal.delegate.c0.b;
            StringBuilder r89 = new StringBuilder("fromJson failed, stack: ");
            Intrinsics.checkNotNullParameter(r87, "<this>");
            r89.append(ExceptionsKt.stackTraceToString(r87));
            r88.e("GsonHolder", r89.toString());
        L191:
            if (Result.isFailure-impl(r85) == false) goto L193;
        L185:
            th = move-exception;
            Result.Companion r90 = Result.Companion;
            r85 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L187
        L248:
            Result.Companion r91 = Result.Companion;     // Catch: Throwable -> L162
            r44.getClass();     // Catch: Throwable -> L162
            r45 = Result.constructor-impl(zd9.h.b.fromJson(r43, new v().getType()));     // Catch: Throwable -> L162
        L164:
            Throwable r92 = Result.exceptionOrNull-impl(r45);
            if (r92 == null) goto L168;
            com.larus.im.internal.delegate.c0 r93 = com.larus.im.internal.delegate.c0.b;
            StringBuilder r128 = new StringBuilder("fromJson failed, stack: ");
            Intrinsics.checkNotNullParameter(r92, "<this>");
            r128.append(ExceptionsKt.stackTraceToString(r92));
            r93.e("GsonHolder", r128.toString());
        L168:
            if (Result.isFailure-impl(r45) == false) goto L170;
        L162:
            th = move-exception;
            Result.Companion r94 = Result.Companion;
            r45 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L164
        L171:
            r46 = null;
            goto L172
        L155:
            r43 = null;
            goto L156
        L128:
            if (r39.length() <= 0) goto L130;
            boolean r95 = true;
        L131:
            if (r95 == true) goto L134;
            r39 = null;
        L134:
            if (r39 == null) goto L151;
            zd9.h r96 = zd9.h.a;
            if (StringsKt.isBlank(r39) == false) goto L256;
        L147:
            Object r97 = null;
        L148:
            Map r99 = (Map) r97;
            if (r99 == null) goto L151;
            r40 = r99.get("ext");
            goto L153
        L256:
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L140
            r96.getClass();     // Catch: Throwable -> L140
            r97 = Result.constructor-impl(zd9.h.b.fromJson(r39, new u().getType()));     // Catch: Throwable -> L140
        L142:
            Throwable r101 = Result.exceptionOrNull-impl(r97);
            if (r101 == null) goto L146;
            com.larus.im.internal.delegate.c0 r102 = com.larus.im.internal.delegate.c0.b;
            StringBuilder r129 = new StringBuilder("fromJson failed, stack: ");
            Intrinsics.checkNotNullParameter(r101, "<this>");
            r129.append(ExceptionsKt.stackTraceToString(r101));
            r102.e("GsonHolder", r129.toString());
        L146:
            if (Result.isFailure-impl(r97) == false) goto L148;
        L140:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            r97 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L142
        L130:
            r95 = false;
            goto L131
        L122:
            r51 = null;
            goto L123
        L124:
            r42 = null;
            goto L125
        L91:
            zd9.h r104 = zd9.h.a;
            String r105 = (String) r9.get("conversation_init_option");
            if (r105 != null) goto L94;
        L97:
            boolean r130 = true;
        L98:
            if (r130 == false) goto L254;
            r119 = r119;
            r61 = r120;
        L115:
            Object r106 = null;
        L116:
            r41 = (ConversationInitOption) r106;
            goto L118
        L254:
            Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L106
            r104.getClass();     // Catch: Throwable -> L106
            r61 = r120;
            r106 = Result.constructor-impl(zd9.h.b.fromJson(r105, new s().getType()));     // Catch: Throwable -> L104
        L109:
            Throwable r107 = Result.exceptionOrNull-impl(r106);
            if (r107 == null) goto L114;
            com.larus.im.internal.delegate.c0 r132 = com.larus.im.internal.delegate.c0.b;
            StringBuilder r133 = new StringBuilder("fromJson failed, stack: ");
            Intrinsics.checkNotNullParameter(r107, "<this>");
            r133.append(ExceptionsKt.stackTraceToString(r107));
            r132.e("GsonHolder", r133.toString());
        L114:
            if (Result.isFailure-impl(r106) == false) goto L116;
        L104:
            th = th;
        L108:
            Result.Companion r108 = Result.Companion;
            r106 = Result.constructor-impl(ResultKt.createFailure(th));
        L106:
            th = th;
            r61 = r120;
            goto L108
        L94:
            if (StringsKt.isBlank(r105) == true) goto L97;
            r130 = false;
            goto L98
        L85:
            if (r28 == AgentMode.MOA.getValue()) goto L87;
            r212 = t0.d.getDeprecatedItemId();
            goto L88
        L78:
            if (com.larus.im.bean.message.a.E(this.b) == true) goto L81;
            r33 = false;
            goto L83
        L64:
            if (o0.d((String) r9.get("target_device_id")) == false) goto L66;
            String r134 = "local";
        L67:
            r31.put("computer_type", r134);
            r31.put("computer_status", "online");
            goto L68
        L66:
            r134 = "cloud";
        L47:
            r114 = "";
            goto L48
        L34:
            r30 = null;
        L30:
            r26 = 0;
            goto L31
        L21:
            r47 = null;
            goto L22
        L17:
            r17 = null;
            goto L18
        L11:
            if ((!StringsKt.isBlank(r14)) == false) goto L13;
            goto L13
        }

        public a(wc9.e r1, Message r2, Message r3, String r4, ChatPageContext r5, ClientMeta r6, b r7, ChatBlockSendStrategy r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public static final class b implements IIMCallback<Boolean> {
        public final /* synthetic */ Message a;
        public final /* synthetic */ Message b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r11) {
            Intrinsics.checkNotNullParameter(r11, "error");
            Intrinsics.checkNotNullParameter(r11, "error");
            if (this.a == null) goto L9;
            ISDKPointCallback.EndMsg r0 = new ISDKPointCallback.EndMsg("-10", 0, 6, false, 0, 16, null);
            com.larus.bmhome.chat.trace.appreciable.f r1 = com.larus.bmhome.chat.trace.appreciable.f.a;
            String r2 = this.a.getLocalMessageId();
            if (r2 != null) goto L7;
            r2 = "";
        L7:
            r1.getClass();
            com.larus.bmhome.chat.trace.appreciable.f.g(r2, r0);
        L9:
            if (r11.getCode() != (-15)) goto L12;
            t19.s.a.g(AppHost.a.getApplication(), 2131907257, false);
            return;
        }

        public final void onSuccess(Object r10) {
            ((Boolean) r10).booleanValue();
            if (this.a == null) goto L9;
            ISDKPointCallback.EndMsg r11 = new ISDKPointCallback.EndMsg("regen_id_1", this.b.getContentType(), 0, false, 0, 16, null);
            com.larus.bmhome.chat.trace.appreciable.f r0 = com.larus.bmhome.chat.trace.appreciable.f.a;
            String r1 = this.a.getMessageId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.getClass();
            com.larus.bmhome.chat.trace.appreciable.f.g(r1, r11);
            return;
        }

        public b(Message r1, Message r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ChatBlockSendStrategy$regenMessage$1(wc9.e r1, ChatBlockSendStrategy r2, Message r3, Message r4, String r5, ChatPageContext r6, Continuation<? super ChatBlockSendStrategy$regenMessage$1> r7) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$answer = r3;
        this.$question = r4;
        this.$regenInstruction = r5;
        this.$chatPageContext = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatBlockSendStrategy$regenMessage$1(this.$conversation, this.this$0, this.$answer, this.$question, this.$regenInstruction, this.$chatPageContext, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r8 = "";
        boolean r14 = true;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        ResultKt.throwOnFailure(r36);
        Object r1 = r36;
    L40:
        BotModel r2 = (BotModel) r1;
        String r3 = this.$conversation.a;
        if (r2 == null) goto L43;
        String r17 = r2.getBotId();
    L44:
        Long r4 = this.$conversation.q;
        if (r4 == null) goto L47;
        long r5 = r4.longValue();
    L48:
        String r6 = this.$conversation.B;
        ClientMeta r32 = new ClientMeta(null, r3, r17, null, null, null, ClientMetaPermissionHelper.a(false), null, r6, r5, DoraCallStateCode.ENV_OBSERVE_USER_WIFI_CONFIG, null);
        b r9 = new b(this.$question, this.$answer);
        NativeMessageServiceImpl r10 = com.larus.im.d.e();
        String r11 = this.$conversation.a;
        String r12 = this.$answer.getMessageId();
        if (r12 == null) goto L52;
        r8 = r12;
    L52:
        a r13 = new a(this.$conversation, this.$answer, this.$question, this.$regenInstruction, this.$chatPageContext, r32, r9, this.this$0);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r13, "callback");
        OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, NativeMessageServiceImpl.r(), false, 2, null).withMessageService(new k3(r11, r8, new NativeIMCallback("getQueryListByAnswerId", "cvsId:" + r11 + ",answerId:" + r8, r13, new i3())));
        return Unit.INSTANCE;
    L47:
        r5 = this.$answer.getServerIndex();
        goto L48
    L43:
        r17 = null;
        goto L44
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        String r15 = (String) this.L$0;
        ResultKt.throwOnFailure(r36);
    L33:
        RepoDispatcher.a.getClass();
        ChatRepo r16 = RepoDispatcher.d;
        final Message r18 = this.$question;
        r16.r1(r15, new r(r18));
    L34:
        RepoDispatcher.a.getClass();
        BotRepo r19 = RepoDispatcher.g;
        String r20 = this.$answer.getConversationId();
        if (r20 != null) goto L37;
        r20 = "";
    L37:
        this.L$0 = null;
        this.label = 4;
        r1 = r19.j1(r20, false, this);
        if (r1 != r7) goto L40;
        return r7;
    L12:
        ResultKt.throwOnFailure(r36);
    L23:
        r15 = this.$answer.getReplyId();
        if (r15 != null) goto L26;
    L29:
        if (r14 == true) goto L34;
        ChatSendUtils r21 = ChatSendUtils.a;
        this.L$0 = r15;
        this.label = 3;
        if (r21.s(r15, this) != r7) goto L33;
        return r7;
    L26:
        if (StringsKt.isBlank(r15) == true) goto L29;
        r14 = false;
        goto L29
    L13:
        ResultKt.throwOnFailure(r36);
        Object r22 = r36;
    L19:
        Boolean r23 = (Boolean) r22;
    L20:
        ChatSendUtils r24 = ChatSendUtils.a;
        Message r25 = this.$answer;
        this.label = 2;
        if (r24.r(r25, this) != r7) goto L23;
        return r7;
    L14:
        ResultKt.throwOnFailure(r36);
        com.larus.bmhome.chat.helper.d0 r26 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r27 = (IObricChatSPIService) this.this$0.c.getValue();
        if (r27 == null) goto L20;
        String r28 = this.$conversation.a;
        this.label = 1;
        r22 = IObricChatSPIService.a.a(r27, r28, false, null, this, 6);
        if (r22 != r7) goto L19;
        return r7;
    }
}
